package in.edu.kristujayanti.util;

import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Projections.fields;
import static com.mongodb.client.model.Projections.include;
import static in.edu.kristujayanti.propertyBinder.core.ERPUserProfileKeysPBinder.*;

public class EmployeeDetailsUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeDetailsUtil.class);

    public static Document getEmployeeDetailsByUserId(MongoDatabase mongoDatabase, String userId) {
        try {
            // Validate userId format
            if (userId == null || userId.isBlank()) {
                LOGGER.warn("Invalid userId: userId is null or blank");
                return null;
            }

            ObjectId objectId;
            try {
                objectId = new ObjectId(userId);
            } catch (IllegalArgumentException e) {
                LOGGER.warn("Invalid ObjectId format for userId: {}", userId);
                return null;
            }

            Bson filter = eq("_id", objectId);

            Document employee = mongoDatabase.getCollection("erp_staff_user_profile")
                    .find(filter)
                    .projection(fields(
                            include(
                                    EMPLOYEE_CODE.getPropertyName(),
                                    EMPLOYEE_FULL_NAME.getPropertyName(),
                                    EMPLOYEE_JOINING_DATE.getPropertyName(),
                                    EMPLOYEE_DEPARTMENT.getPropertyName(),
                                    EMPLOYEE_ID_PHOTO_PATH.getPropertyName()
                            )))
                    .first();

            if (employee == null) {
                LOGGER.warn("Employee not found for userId: {}", userId);
                return null;
            }

            // Return only the needed fields
            return new Document()
                    .append("_id", employee.getObjectId("_id").toHexString())
                    .append(EMPLOYEE_CODE.getPropertyName(), employee.getString(EMPLOYEE_CODE.getPropertyName()))
                    .append(EMPLOYEE_FULL_NAME.getPropertyName(), employee.getString(EMPLOYEE_FULL_NAME.getPropertyName()))
                    .append(EMPLOYEE_ID_PHOTO_PATH.getPropertyName(), employee.getString(EMPLOYEE_ID_PHOTO_PATH.getPropertyName()))
                    .append(EMPLOYEE_JOINING_DATE.getPropertyName(), employee.getLong(EMPLOYEE_JOINING_DATE.getPropertyName()))
                    .append(EMPLOYEE_DEPARTMENT.getPropertyName(), employee.getString(EMPLOYEE_DEPARTMENT.getPropertyName()));

        } catch (Exception e) {
            LOGGER.error("Error fetching employee details for userId: {}", userId, e);
            return null;   // swallow the error, caller will see null
        }
    }

    public static Document getEmployeeDetailsByEmail(MongoDatabase mongoDatabase, String email) {
        try {
            Bson filter = eq("employeeOfficialEmail_ERPUserProfile_Text", email);

            Document employee = mongoDatabase.getCollection("erp_staff_user_profile")
                    .find(filter)
                    .projection(fields(
                            include(
                                    EMPLOYEE_CODE.getPropertyName(),
                                    EMPLOYEE_FULL_NAME.getPropertyName(),
                                    EMPLOYEE_JOINING_DATE.getPropertyName(),
                                    EMPLOYEE_DEPARTMENT.getPropertyName(),
                                    EMPLOYEE_ID_PHOTO_PATH.getPropertyName()
                            )))
                    .first();

            if (employee == null) {
                LOGGER.warn("Employee not found for email: {}", email);
                return null;
            }

            // Return only the needed fields
            return new Document()
                    .append(EMPLOYEE_CODE.getPropertyName(), employee.getString(EMPLOYEE_CODE.getPropertyName()))
                    .append(EMPLOYEE_FULL_NAME.getPropertyName(), employee.getString(EMPLOYEE_FULL_NAME.getPropertyName()))
                    .append(EMPLOYEE_ID_PHOTO_PATH.getPropertyName(), employee.getString(EMPLOYEE_ID_PHOTO_PATH.getPropertyName()))
                    .append(EMPLOYEE_JOINING_DATE.getPropertyName(), employee.getLong(EMPLOYEE_JOINING_DATE.getPropertyName()))
                    .append(EMPLOYEE_DEPARTMENT.getPropertyName(), employee.getString(EMPLOYEE_DEPARTMENT.getPropertyName()));

        } catch (Exception e) {
            LOGGER.error("Error fetching employee details for email: {}", email, e);
            return null;
        }
    }
}