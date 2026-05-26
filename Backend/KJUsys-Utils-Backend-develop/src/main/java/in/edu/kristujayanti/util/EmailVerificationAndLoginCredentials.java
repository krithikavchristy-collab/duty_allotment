package in.edu.kristujayanti.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

import software.amazon.awssdk.core.SdkBytes;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.services.sesv2.model.*;
import software.amazon.awssdk.services.sesv2.SesV2Client;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.internet.*;

public class EmailVerificationAndLoginCredentials {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmailVerificationAndLoginCredentials.class);

    private final Properties emailProperties;

    public EmailVerificationAndLoginCredentials() {
        this.emailProperties = loadEmailProperties();
    }

    private Properties loadEmailProperties() {
        Properties properties = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("aws_config.properties")) {
            if (input == null) {
                LOGGER.error("Unable to find aws_config.properties");
                return properties;
            }
            properties.load(input);
        } catch (IOException ex) {
            LOGGER.error("Error loading aws properties", ex);
        }
        return properties;
    }

    protected AwsBasicCredentials loadAwsCredentials() throws IOException {
        return AwsBasicCredentials.create(this.emailProperties.getProperty("aws.accessKeyId"), this.emailProperties.getProperty("aws.secretKey"));
    }

    protected static SesV2Client initializeSesV2Client(AwsBasicCredentials awsCreds) {
        return SesV2Client.builder()
                .region(Region.AP_SOUTH_1)
                .credentialsProvider(StaticCredentialsProvider.create(awsCreds))
                .build();
    }

    /**
     * Sends an email based on a template using the specified client, sender, recipient, and template name.
     *
     * @param templateData The template data
     * @param recipient    The recipient's email address.
     * @param templateName The name of the email template.
     */
    public void sendEmail(String recipient, String templateName, String templateData, String awsEmail) {
        try {
            AwsBasicCredentials awsCreds = loadAwsCredentials();
            SesV2Client client = initializeSesV2Client(awsCreds);
            String sender = this.emailProperties.getProperty(awsEmail);
            send(client, sender, recipient, templateName, templateData);
        } catch (IOException e) {
            LOGGER.error("Error initializing AWS credentials", e);
        }
    }

    public void sendBulkEmail(List<String> recipients, String templateName, String templateData, String awsEmail) {
        try {
            AwsBasicCredentials awsCreds = loadAwsCredentials();
            SesV2Client client = initializeSesV2Client(awsCreds);
            String sender = this.emailProperties.getProperty(awsEmail);

            sendBulk(client, sender, recipients, templateName, templateData);
        } catch (IOException e) {
            LOGGER.error("Error initializing AWS credentials", e);
        }
    }

    // new method
    public void sendBulkEmail(List<String> recipients, List<String> templateData, String templateName, String awsEmail) {
        try {
            AwsBasicCredentials awsCreds = loadAwsCredentials();
            SesV2Client client = initializeSesV2Client(awsCreds);
            String sender = this.emailProperties.getProperty(awsEmail);

            // Build recipient -> templateData map
            Map<String, String> recipientDataMap = new HashMap<>();
            for (int i = 0; i < recipients.size(); i++) {
                recipientDataMap.put(recipients.get(i), templateData.get(i));
            }

            sendBulk(client, sender, recipientDataMap, templateName);
        } catch (IOException e) {
            LOGGER.error("Error initializing AWS credentials", e);
        }
    }


    // new method
    protected static void sendBulk(SesV2Client client, String sender, Map<String, String> recipientDataMap, String templateName) {
        List<BulkEmailEntry> bulkEmailEntries = recipientDataMap.entrySet().stream()
                .map(entry ->
                        BulkEmailEntry.builder()
                                .destination(Destination.builder().toAddresses(entry.getKey()).build())
                                .replacementEmailContent(ReplacementEmailContent.builder()
                                        .replacementTemplate(ReplacementTemplate.builder()
                                                .replacementTemplateData(entry.getValue()) // personalized data
                                                .build())
                                        .build())
                                .build()
                )
                .toList();

        SendBulkEmailRequest bulkEmailRequest = SendBulkEmailRequest.builder()
                .defaultContent(BulkEmailContent.builder()
                        .template(Template.builder()
                                .templateName(templateName)
                                .templateData("{}") // fallback empty template data
                                .build())
                        .build())
                .bulkEmailEntries(bulkEmailEntries)
                .fromEmailAddress(sender)
                .build();

        try {
            LOGGER.info("Sending bulk email using SES...");
            SendBulkEmailResponse response = client.sendBulkEmail(bulkEmailRequest);
            LOGGER.info("Bulk email response: {}", response);
        } catch (SesV2Exception e) {
            LOGGER.error("Error sending bulk email: {}", e.awsErrorDetails().errorMessage());
        }
    }







    protected static void sendBulk(SesV2Client client, String sender, List<String> recipients, String templateName, String templateData) {
        List<BulkEmailEntry> bulkEmailEntries = recipients.stream().map(email ->
                BulkEmailEntry.builder()
                        .destination(Destination.builder().toAddresses(email).build())
                        .replacementEmailContent(ReplacementEmailContent.builder()
                                .replacementTemplate(ReplacementTemplate.builder()
                                        .replacementTemplateData(templateData) // customize per recipient if needed
                                        .build())
                                .build())
                        .build()
        ).toList();

        SendBulkEmailRequest bulkEmailRequest = SendBulkEmailRequest.builder()
                .defaultContent(BulkEmailContent.builder()
                        .template(Template.builder()
                                .templateName(templateName)
                                .templateData(templateData)
                                .build())
                        .build())
                .bulkEmailEntries(bulkEmailEntries)
                .fromEmailAddress(sender)
                .build();

        try {
            LOGGER.info("Sending bulk email using SES...");
            SendBulkEmailResponse response = client.sendBulkEmail(bulkEmailRequest);
            LOGGER.info("Bulk email response: {}", response);
        } catch (SesV2Exception e) {
            LOGGER.error("Error sending bulk email: {}", e.awsErrorDetails().errorMessage());
        }
    }


    protected static void send(SesV2Client client, String sender, String recipient, String templateName, String templateData) {
        Destination destination = Destination.builder()
                .toAddresses(recipient)
                .build();

        Template myTemplate = Template.builder()
                .templateName(templateName)
                .templateData(templateData)
                .build();

        EmailContent emailContent = EmailContent.builder()
                .template(myTemplate)
                .build();

        SendEmailRequest emailRequest = SendEmailRequest.builder()
                .destination(destination)
                .content(emailContent)
                .fromEmailAddress(sender)
                .build();

        try {
            LOGGER.info("Attempting to send an email based on a template using the AWS SDK for Java (v2)...");
            client.sendEmail(emailRequest);
            LOGGER.info("Email based on a template was sent.");
        } catch (SesV2Exception e) {
            LOGGER.error(e.awsErrorDetails().errorMessage());

        }
    }

    public void sendEmailWithCC(String recipient, String templateName, String templateData, String awsEmail, String ccKey) {
        try {
            AwsBasicCredentials awsCreds = loadAwsCredentials();
            SesV2Client client = initializeSesV2Client(awsCreds);

            String sender = this.emailProperties.getProperty(awsEmail);

            // Fetch comma-separated CC addresses from properties
            String ccString = this.emailProperties.getProperty(ccKey); // e.g., "ccEmails.supportTeam"
            List<String> ccRecipients = ccString != null ? Arrays.stream(ccString.split(","))
                    .map(String::trim)
                    .filter(email -> !email.isEmpty())
                    .collect(Collectors.toList())
                    : Collections.emptyList();

            sendEmailWithCC(client, sender, recipient, ccRecipients, templateName, templateData);
        } catch (IOException e) {
            LOGGER.error("Error initializing AWS credentials", e);
        }
    }


    protected static void sendEmailWithCC(SesV2Client client, String sender, String recipient, List<String> ccRecipients, String templateName, String templateData) {
        Destination.Builder destinationBuilder = Destination.builder()
                .toAddresses(recipient);

        // Only add ccAddresses if the list is not empty
        if (ccRecipients != null && !ccRecipients.isEmpty()) {
            destinationBuilder.ccAddresses(ccRecipients);
        }

        Destination destination = destinationBuilder.build();

        Template myTemplate = Template.builder()
                .templateName(templateName)
                .templateData(templateData)
                .build();

        EmailContent emailContent = EmailContent.builder()
                .template(myTemplate)
                .build();

        SendEmailRequest emailRequest = SendEmailRequest.builder()
                .destination(destination)
                .content(emailContent)
                .fromEmailAddress(sender)
                .build();

        try {
            LOGGER.info("Attempting to send an email with CC using a template...");
            client.sendEmail(emailRequest);
            LOGGER.info("Email was sent.");
        } catch (SesV2Exception e) {
            LOGGER.error("Failed to send email: {}", e.awsErrorDetails().errorMessage());
        }
    }


    public void sendEmailWithAttachment(String recipient, String subject, String body, File attachment) {
        try {
            AwsBasicCredentials awsCreds = loadAwsCredentials();
            SesV2Client client = initializeSesV2Client(awsCreds);
            String sender = this.emailProperties.getProperty("aws.email#2");

            // Create the raw email with attachment
            // Create the MIME-formatted email
            MimeMessage mimeMessage = createMimeMessage(sender, recipient, subject, body, attachment);

            // Convert the MimeMessage to a raw format
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            mimeMessage.writeTo(outputStream);
            SdkBytes rawMessageData = SdkBytes.fromByteArray(outputStream.toByteArray());

            RawMessage rawMessage = RawMessage.builder()
                    .data(rawMessageData)
                    .build();

            SendEmailRequest emailRequest = SendEmailRequest.builder()
                    .content(EmailContent.builder().raw(rawMessage).build())
                    .build();

            // Send the email
            client.sendEmail(emailRequest);
            System.out.println("Email with attachment sent successfully.");

        } catch (IOException | MessagingException | SesV2Exception e) {
            System.err.println("Error sending email with attachment: " + e.getMessage());
        }
    }

    private MimeMessage createMimeMessage(String sender, String recipient, String subject, String body, File attachment)
            throws MessagingException, IOException {

        // Set up the session with MIME properties
        Properties props = new Properties();
        props.put("mail.mime.charset", "UTF-8");
        props.put("mail.mime.encodefilename", "true");
        Session session = Session.getInstance(props);

        // Create a new MimeMessage
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(sender));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
        message.setSubject(subject, "UTF-8");

        Multipart multipart;

        if (attachment != null) {
            // Create a "mixed" multipart for email with attachment
            multipart = new MimeMultipart("mixed");

            // Add the attachment part
            MimeBodyPart attachmentPart = new MimeBodyPart();
            attachmentPart.attachFile(attachment);

            // Set the content type and content disposition headers for the attachment
            attachmentPart.setHeader("Content-Type", determineContentType(attachment.getName()));
            attachmentPart.setHeader("Content-Disposition",
                    "attachment; filename=\"" + MimeUtility.encodeText(attachment.getName(), "UTF-8", null) + "\"");
            multipart.addBodyPart(attachmentPart);
        } else {
            // Create an "alternative" multipart for plain text email without attachment
            multipart = new MimeMultipart("alternative");
        }

        // Add the text part
        MimeBodyPart textPart = new MimeBodyPart();
        textPart.setText(body, "UTF-8");
        textPart.setContent(body, "text/plain; charset=UTF-8");
        multipart.addBodyPart(textPart);

        // Set the content and save changes
        message.setContent(multipart);
        message.saveChanges();

        return message;
    }



    public void sendEmailWithAttachment(List<String> recipients, String subject, String body, File attachment) {
        try {
            AwsBasicCredentials awsCreds = loadAwsCredentials();
            SesV2Client client = initializeSesV2Client(awsCreds);
            String sender = this.emailProperties.getProperty("aws.email#2");

            MimeMessage mimeMessage = createMimeMessage(sender, recipients, subject, body, attachment);

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            mimeMessage.writeTo(outputStream);
            SdkBytes rawMessageData = SdkBytes.fromByteArray(outputStream.toByteArray());

            RawMessage rawMessage = RawMessage.builder()
                    .data(rawMessageData)
                    .build();

            SendEmailRequest emailRequest = SendEmailRequest.builder()
                    .content(EmailContent.builder().raw(rawMessage).build())
                    .build();

            client.sendEmail(emailRequest);
            System.out.println("Email with attachment sent successfully to: " + recipients);

        } catch (IOException | MessagingException | SesV2Exception e) {
            System.err.println("Error sending email with attachment: " + e.getMessage());
        }
    }


    private MimeMessage createMimeMessage(String sender, List<String> recipients, String subject, String body, File attachment)
            throws MessagingException, IOException {
        Properties props = new Properties();
        props.put("mail.mime.charset", "UTF-8");
        props.put("mail.mime.encodefilename", "true");

        Session session = Session.getInstance(props);
        MimeMessage message = new MimeMessage(session);

        // Set sender
        message.setFrom(new InternetAddress(sender));

        // Set multiple recipients
        InternetAddress[] recipientAddresses = recipients.stream()
                .map(email -> {
                    try {
                        return new InternetAddress(email);
                    } catch (AddressException e) {
                        throw new RuntimeException("Invalid email address: " + email, e);
                    }
                })
                .toArray(InternetAddress[]::new);
        message.setRecipients(Message.RecipientType.TO, recipientAddresses);

        // Set subject with UTF-8
        message.setSubject(subject, "UTF-8");

        // Choose MIME type based on presence of attachment
        Multipart multipart = (attachment != null)
                ? new MimeMultipart("mixed")
                : new MimeMultipart("alternative");

        // Body part (always included)
        MimeBodyPart textPart = new MimeBodyPart();
        textPart.setText(body, "UTF-8");
        textPart.setContent(body, "text/plain; charset=UTF-8");
        multipart.addBodyPart(textPart);

        // Optional attachment
        if (attachment != null) {
            MimeBodyPart attachmentPart = new MimeBodyPart();
            attachmentPart.attachFile(attachment);

            // Set headers
            attachmentPart.setHeader("Content-Type", this.determineContentType(attachment.getName()));
            attachmentPart.setHeader(
                    "Content-Disposition",
                    "attachment; filename=\"" + MimeUtility.encodeText(attachment.getName(), "UTF-8", null) + "\""
            );
            multipart.addBodyPart(attachmentPart);
        }

        // Set multipart content and finalize
        message.setContent(multipart);
        message.saveChanges();

        return message;
    }


    private String determineContentType(String fileName) {
        String extension = fileName.substring(fileName.lastIndexOf('.') + 1).toLowerCase();
        switch (extension) {
            case "pdf":
                return "application/pdf";
            case "doc":
                return "application/msword";
            case "docx":
                return "application/vnd.openxmlformats-officedocument.wordprocessingml.document";
            case "xls":
                return "application/vnd.ms-excel";
            case "xlsx":
                return "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
            case "jpg":
            case "jpeg":
                return "image/jpeg";
            case "png":
                return "image/png";
            case "txt":
                return "text/plain";
            default:
                return "application/octet-stream";
        }
    }


    // Sends bulk email to multiple recipients with personalized content (e.g., different names per recipient)
    public void sendBulkPersonalizedEmail(
            List<String> recipients,
            List<Map<String, String>> templateDataList,
            Map<String, String> commonTemplateData,
            String templateName,
            String awsEmailKey
    ) {
        try {
            AwsBasicCredentials awsCreds = loadAwsCredentials();
            SesV2Client client = initializeSesV2Client(awsCreds);
            String sender = emailProperties.getProperty(awsEmailKey);

            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, String> recipientDataMap = new HashMap<>();

            // Validate input consistency
            if (recipients == null || templateDataList == null
                    || recipients.size() != templateDataList.size()) {
                throw new IllegalArgumentException(
                        "Recipients and templateDataList must be non-null and of same size"
                );
            }

            for (int i = 0; i < recipients.size(); i++) {

                Map<String, String> mergedData = new HashMap<>();

                // Add common data first (shared for all)
                if (commonTemplateData != null) {
                    mergedData.putAll(commonTemplateData);
                }

                //  Add personalized data (overrides common if same key exists)
                if (templateDataList.get(i) != null) {
                    mergedData.putAll(templateDataList.get(i));
                }

                String jsonData = objectMapper.writeValueAsString(mergedData);

                recipientDataMap.put(recipients.get(i), jsonData);
            }

            sendBulk(client, sender, recipientDataMap, templateName);

        } catch (Exception e) {
            LOGGER.error("Error sending bulk personalized email", e);
        }
    }
}