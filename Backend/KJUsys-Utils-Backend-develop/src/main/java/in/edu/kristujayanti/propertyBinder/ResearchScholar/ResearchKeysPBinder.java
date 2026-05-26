package in.edu.kristujayanti.propertyBinder.ResearchScholar;

import in.edu.kristujayanti.propertyBinder.KJUSYSPropertyBinder;
import org.bson.types.ObjectId;
import software.amazon.awssdk.core.document.Document;

public enum ResearchKeysPBinder implements KJUSYSPropertyBinder {


    RESEARCH_PUBLICATION_TYPE("researchPublicationType_ResearchKeys_Text","Research Publication Type", String.class),
    RESEARCH_SUB_TYPE("researchSubType_ResearchKeys_Text","Research Sub Type",String.class),
    RESEARCH_SUBJECT_AREA("researchSubjectArea_ResearchKeys_Text","Research Subject Area", String.class),
    RESEARCH_SUB_AREA("researchSubArea_ResearchKeys_Text","Research Sub Area", String.class),
    AUTHOR_ID("authorId_ResearchKeys_ObjectId","Author Id", ObjectId.class),

    //JOURNAL ARTICLE
    JOURNAL_ARTICLE_TITLE("journalArticleTitle_ResearchKeys_Text","Journal Article Title",String.class),
    JOURNAL_ARTICLE_ABSTRACT_SUMMARY("journalArticleAbstractSummary_ResearchKeys_Text","Journal Article Abstract Summary",String.class),
    JOURNAL_ARTICLE_KEYWORDS("journalArticleKeywords_ResearchKeys_Text","Journal Article Keywords",String.class),
    JOURNAL_ARTICLE_AUTHORS_LIST("journalArticleAuthorsList_ResearchKeys_DocumentArray","Journal Article List", Document.class),
    JOURNAL_ARTICLE_AUTHOR_NAME("journalArticleAuthorName_ResearchKeys_Text","Journal Article Author Name",String.class),
    JOURNAL_ARTICLE_AUTHOR_AFFILIATION("journalArticleAuthorAffiliation_ResearchKeys_Text","Journal Article Author  Affiliation",String.class),
    JOURNAL_ARTICLE_AUTHOR_ROLE("journalArticleAuthorRole_ResearchKeys_Text","Journal Article Author Role", String.class),
    JOURNAL_ARTICLE_PUBLICATION_DATE("journalArticlePublicationDate_ResearchKeys_Date","Journal Article Publication Date",Long.class),
    JOURNAL_ARTICLE_LANGUAGE("journalArticleLanguage_ResearchKeys_Text","Journal Article Language",String.class),

    JOURNAL_ARTICLE_JOURNAL_NAME("journalArticleJournalName_ResearchKeys_Text", "Journal Article Journal Name", String.class),
    JOURNAL_ARTICLE_PUBLISHER_NAME("journalArticlePublisherName_ResearchKeys_Text", "Journal Article Publisher Name", String.class),
    JOURNAL_ARTICLE_VOLUME("journalArticleVolume_ResearchKeys_Text", "Journal Article Volume", String.class),
    JOURNAL_ARTICLE_ISSUE("journalArticleIssue_ResearchKeys_Text", "Journal Article Issue", String.class),
    JOURNAL_ARTICLE_ID("journalArticleId_ResearchKeys_Text", "Journal Article Article ID", String.class),
    JOURNAL_ARTICLE_PAGE_NUMBERS("journalArticlePageNumbers_ResearchKeys_Text", "Journal Article Page Numbers", String.class),
    JOURNAL_ARTICLE_ISSN("journalArticleIssn_ResearchKeys_Text", "Journal Article Issn", String.class),
    JOURNAL_ARTICLE_DOI("journalArticleDoi_ResearchKeys_Text", "Journal Article Doi", String.class),
    JOURNAL_ARTICLE_URL_TO_DIGITAL_ARCHIVE("journalArticleUrlToDigitalArchive_ResearchKeys_Text", "Journal Article URL to Digital Archive", String.class),

    JOURNAL_ARTICLE_INDEXED_IN("journalArticleIndexedIn_ResearchKeys_TextArray", "Journal Article Indexed In", String.class),

    JOURNAL_ARTICLE_IMPACT_FACTOR("journalArticleImpactFactor_ResearchKeys_Double", "Journal Article Impact Factor", Double.class),
    JOURNAL_ARTICLE_CITE_SCORE("journalArticleCiteScore_ResearchKeys_Double", "Journal Article CiteScore Number", Double.class),
    JOURNAL_ARTICLE_ABDC_RANKING("journalArticleAbdcRanking_ResearchKeys_Text", "Journal Article ABDC Ranking", String.class),
    JOURNAL_ARTICLE_JOURNAL_QUARTILE("journalArticleJournalQuartile_ResearchKeys_Text", "Journal Article Journal Quartile", String.class),

    // FULL PAPER IN A CONFERENCE PROCEEDINGS
    FULL_PAPER_IN_A_CONFERENCE_PROCEEDINGS_TITLE("fullPaperInAConferenceProceedingsTitle_ResearchKeys_Text","Full Paper In A Conference Proceedings Title",String.class),
    FULL_PAPER_IN_A_CONFERENCE_PROCEEDINGS_ABSTRACT_SUMMARY("fullPaperInAConferenceProceedingsAbstractSummary_ResearchKeys_Text","Full Paper In A Conference Proceedings Abstract Summary",String.class),
    FULL_PAPER_IN_A_CONFERENCE_PROCEEDINGS_KEYWORDS("fullPaperInAConferenceProceedingsKeywords_ResearchKeys_Text","Full Paper In A Conference Proceedings Keywords",String.class),
    FULL_PAPER_IN_A_CONFERENCE_PROCEEDINGS_AUTHORS_LIST("fullPaperInAConferenceProceedingsAuthorsList_ResearchKeys_DocumentArray","Full Paper In A Conference Proceedings Authors List", Document.class),
    FULL_PAPER_IN_A_CONFERENCE_PROCEEDINGS_AUTHOR_NAME("fullPaperInAConferenceProceedingsAuthorName_ResearchKeys_Text", "Full Paper In A Conference Proceedings Author Name", String.class),
    FULL_PAPER_IN_A_CONFERENCE_PROCEEDINGS_AUTHOR_AFFILIATION("fullPaperInAConferenceProceedingsAuthorAffiliation_ResearchKeys_Text", "Full Paper In A Conference Proceedings Author Affiliation", String.class),
    FULL_PAPER_IN_A_CONFERENCE_PROCEEDINGS_AUTHOR_ROLE("fullPaperInAConferenceProceedingsAuthorRole_ResearchKeys_Text", "Full Paper In A Conference Proceedings Author Role", String.class),
    FULL_PAPER_IN_A_CONFERENCE_PROCEEDINGS_PUBLICATION_DATE("fullPaperInAConferenceProceedingsPublicationDate_ResearchKeys_Date", "Full Paper In A Conference Proceedings Publication Date", Long.class),
    FULL_PAPER_IN_A_CONFERENCE_PROCEEDINGS_LANGUAGE("fullPaperInAConferenceProceedingsLanguage_ResearchKeys_Text", "Full Paper In A Conference Proceedings Language", String.class),

    FULL_PAPER_IN_A_CONFERENCE_PROCEEDINGS_INFORMATION_TITLE("fullPaperInAConferenceProceedingsInformationTitle_ResearchKeys_Text", "Full Paper in a Conference Proceedings Title", String.class),
    FULL_PAPER_IN_A_CONFERENCE_PROCEEDINGS_CONFERENCE_NAME("fullPaperInAConferenceProceedingsConferenceName_ResearchKeys_Text", "Full Paper in a Conference Proceedings Conference Name", String.class),
    FULL_PAPER_IN_A_CONFERENCE_PROCEEDINGS_CONFERENCE_DATE("fullPaperInAConferenceProceedingsConferenceDate_ResearchKeys_Date", "Full Paper in a Conference Proceedings Conference Date ", Long.class),
    FULL_PAPER_IN_A_CONFERENCE_PROCEEDINGS_CONFERENCE_VENUE("fullPaperInAConferenceProceedingsConferenceVenue_ResearchKeys_Text", "Full Paper in a Conference Proceedings Venue", String.class),
    FULL_PAPER_IN_A_CONFERENCE_PROCEEDINGS_EDITORS_NAMES("fullPaperInAConferenceProceedingsEditorsNames_ResearchKeys_Text", "Full Paper in a Conference Proceedings Editors Name(s)", String.class),
    FULL_PAPER_IN_A_CONFERENCE_PROCEEDINGS_PUBLISHER_NAME("fullPaperInAConferenceProceedingsPublisherName_ResearchKeys_Text", "Full Paper in a Conference Proceedings Publisher Name", String.class),
    FULL_PAPER_IN_A_CONFERENCE_PROCEEDINGS_ISBN("fullPaperInAConferenceProceedingsIsbn_ResearchKeys_Text", "Full Paper in a Conference Proceedings ISBN", String.class),
    FULL_PAPER_IN_A_CONFERENCE_PROCEEDINGS_DOI("fullPaperInAConferenceProceedingsDoi_ResearchKeys_Text", "Full Paper in a Conference Proceedings DOI", String.class),
    FULL_PAPER_IN_A_CONFERENCE_PROCEEDINGS_URL_DIGITAL_ARCHIVE("fullPaperInAConferenceProceedingsUrlDigitalArchive_ResearchKeys_Text", "Full Paper in a Conference Proceedings URL to Digital Archive", String.class),

    FULL_PAPER_IN_A_CONFERENCE_PROCEEDINGS_INDEXED_IN("fullPaperInAConferenceProceedingsIndexedIn_ResearchKeys_TextArray", "Full Paper In A Conference Proceedings Indexed In", String.class),

   //CHAPTER IN A BOOK SERIES
    CHAPTER_IN_A_BOOK_SERIES_TITLE("chapterInABookSeriesTitle_ResearchKeys_Text","Chapter In A Book Series Title", String.class),
    CHAPTER_IN_A_BOOK_SERIES_ABSTRACT_SUMMARY("chapterInABookSeriesAbstractSummary_ResearchKeys_Text", "Chapter In A Book Series Abstract Summary", String.class),
    CHAPTER_IN_A_BOOK_SERIES_KEYWORDS("chapterInABookSeriesKeywords_ResearchKeys_Text", "Chapter In A Book Series Keywords", String.class),
    CHAPTER_IN_A_BOOK_SERIES_AUTHORS_LIST("chapterInABookSeriesAuthorsList_ResearchKeys_DocumentArray","Chapter In A Book Series Authors List", Document.class),
    CHAPTER_IN_A_BOOK_SERIES_AUTHOR_NAME("chapterInABookSeriesAuthorName_ResearchKeys_Text", "Chapter In A Book Series Author Name", String.class),
    CHAPTER_IN_A_BOOK_SERIES_AUTHOR_AFFILIATION("chapterInABookSeriesAuthorAffiliation_ResearchKeys_Text", "Chapter In A Book Series Author Affiliation", String.class),
    CHAPTER_IN_A_BOOK_SERIES_AUTHOR_ROLE("chapterInABookSeriesAuthorRole_ResearchKeys_Text", "Chapter In A Book Series Author Role", String.class),
    CHAPTER_IN_A_BOOK_SERIES_PUBLICATION_DATE("chapterInABookSeriesPublicationDate_ResearchKeys_Date", "Chapter In A Book Series Publication Date", Long.class),
    CHAPTER_IN_A_BOOK_SERIES_LANGUAGE("chapterInABookSeriesLanguage_ResearchKeys_Text", "Chapter In A Book Series Language", String.class),
    CHAPTER_IN_A_BOOK_SERIES_BOOK_SERIES_TITLE("chapterInABookSeriesBookSeriesTitle_ResearchKeys_Text", "Chapter In A Book Series Book Series Title", String.class),

    CHAPTER_IN_A_BOOK_SERIES_BOOK_TITLE("chapterInABookSeriesBookTitle_ResearchKeys_Text", "Chapter In A Book Series Book Title", String.class),
    CHAPTER_IN_A_BOOK_SERIES_PUBLISHER_NAME("chapterInABookSeriesPublisherName_ResearchKeys_Text", "Chapter In A Book Series Publisher Name", String.class),
    CHAPTER_IN_A_BOOK_SERIES_ISBN("chapterInABookSeriesIsbn_ResearchKeys_Text", "Chapter In A Book Series ISBN", String.class),
    CHAPTER_IN_A_BOOK_SERIES_ISSN("chapterInABookSeriesIssn_ResearchKeys_Text", "Chapter In A Book Series ISSN", String.class),
    CHAPTER_IN_A_BOOK_SERIES_DOI("chapterInABookSeriesDoi_ResearchKeys_Text", "Chapter In A Book Series DOI", String.class),
    CHAPTER_IN_A_BOOK_SERIES_URL_TO_DIGITAL_ARCHIVE("chapterInABookSeriesUrlToDigitalArchive_ResearchKeys_Text", "Chapter In A Book Series URL to Digital Archive", String.class),

    CHAPTER_IN_A_BOOK_SERIES_INDEXED_IN("chapterInABookSeriesIndexedIn_ResearchKeys_TextArray", "Chapter In A Book Series Indexed In", String.class),
    CHAPTER_IN_A_BOOK_SERIES_IMPACT_FACTOR("chapterInABookSeriesImpactFactor_ResearchKeys_Double","Chapter In A Book Series Impact Factor", Double.class),
    CHAPTER_IN_A_BOOK_SERIES_CITE_SCORE("chapterInABookSeriesCiteScore_ResearchKeys_Double","Chapter In A Book Series Cite Score", Double.class),
    CHAPTER_IN_A_BOOK_SERIES_JOURNAL_QUARTILE("chapterInABookSeriesJournalQuartile_ResearchKeys_Text","Chapter In A Book Series Journal Quartile", String.class),

    //CHAPTER IN AN EDITED BOOK
    CHAPTER_IN_AN_EDITED_BOOK_TITLE("chapterInAnEditedBookTitle_ResearchKeys_Text", "Chapter In An Edited Book Title", String.class),
    CHAPTER_IN_AN_EDITED_BOOK_ABSTRACT_SUMMARY("chapterInAnEditedBookAbstractSummary_ResearchKeys_Text", "Chapter In An Edited Book Abstract Summary", String.class),
    CHAPTER_IN_AN_EDITED_BOOK_KEYWORDS("chapterInAnEditedBookKeywords_ResearchKeys_Text", "Chapter In An Edited Book Keywords", String.class),
    CHAPTER_IN_AN_EDITED_BOOK_AUTHORS_LIST("chapterInAnEditedBookAuthorsList_ResearchKeys_DocumentArray","Chapter In An Edited Book Authors List", Document.class),
    CHAPTER_IN_AN_EDITED_BOOK_AUTHOR_NAME("chapterInAnEditedBookAuthorName_ResearchKeys_Text", "Chapter In An Edited Book Author Name", String.class),
    CHAPTER_IN_AN_EDITED_BOOK_AUTHOR_AFFILIATION("chapterInAnEditedBookAuthorAffiliation_ResearchKeys_Text", "Chapter In An Edited Book Author Affiliation", String.class),
    CHAPTER_IN_AN_EDITED_BOOK_AUTHOR_ROLE("chapterInAnEditedBookAuthorRole_ResearchKeys_Text", "Chapter In An Edited Book Author Role", String.class),
    CHAPTER_IN_AN_EDITED_BOOK_PUBLICATION_DATE("chapterInAnEditedBookPublicationDate_ResearchKeys_Date", "Chapter In An Edited Book Publication Date", Long.class),
    CHAPTER_IN_AN_EDITED_BOOK_LANGUAGE("chapterInAnEditedBookLanguage_ResearchKeys_Text", "Chapter In An Edited Book Language", String.class),

    CHAPTER_IN_AN_EDITED_BOOK_BOOK_TITLE("chapterInAnEditedBookBookTitle_ResearchKeys_Text", "Chapter In An Edited Book Book Title", String.class),
    CHAPTER_IN_AN_EDITED_BOOK_EDITOR_NAME("chapterInAnEditedBookEditorName_ResearchKeys_Text", "Chapter In An Edited Book Editor Name", String.class),
    CHAPTER_IN_AN_EDITED_BOOK_PUBLISHER_NAME("chapterInAnEditedBookPublisherName_ResearchKeys_Text", "Chapter In An Edited Book Publisher Name", String.class),
    CHAPTER_IN_AN_EDITED_BOOK_ISBN("chapterInAnEditedBookIsbn_ResearchKeys_Text", "Chapter In An Edited Book Isbn", String.class),
    CHAPTER_IN_AN_EDITED_BOOK_DOI("chapterInAnEditedBookDoi_ResearchKeys_Text", "Chapter In An Edited Book DOI", String.class),
    CHAPTER_IN_AN_EDITED_BOOK_URL_TO_DIGITAL_ARCHIVE("chapterInAnEditedBookUrlToDigitalArchive_ResearchKeys_Text", "Chapter In An Edited Book URL To Digital Archive", String.class),

    CHAPTER_IN_AN_EDITED_BOOK_INDEXED_IN("chapterInAnEditedBookIndexedIn_ResearchKeys_TextArray", "Chapter In An Edited Book Indexed In", String.class),

    //AUTHORED BOOK
    AUTHORED_BOOK_TITLE("authoredBookTitle_ResearchKeys_Text","Authored Book Title", String.class),
    AUTHORED_BOOK_SUB_TITLE("authoredBookSubTitle_ResearchKeys_Text", "Authored Book Sub Title", String.class),
    AUTHORED_BOOK_ABSTRACT("authoredBookAbstract_ResearchKeys_Text","Authored Book Abstract", String.class),
    AUTHORED_BOOK_AUTHORS_LIST("authoredBookAuthorsList_ResearchKeys_DocumentArray","Authored Book  Authors List", Document.class),
    AUTHORED_BOOK_AUTHOR_NAMES("authoredBookAuthorNames_ResearchKeys_Text", "Authored Book Author Names", String.class),
    AUTHORED_BOOK_AUTHOR_AFFILIATION("authoredBookAuthorAffiliation_ResearchKeys_Text", "Authored Book Author Affiliation", String.class),
    AUTHORED_BOOK_PUBLICATION_DATE("authoredBookPublicationDate_ResearchKeys_Date", "Authored Book Publication Date", Long.class),
    AUTHORED_BOOK_LANGUAGE("authoredBookLanguage_ResearchKeys_Text", "Authored Book Language", String.class),

    AUTHORED_BOOK_PUBLISHER_NAME("authoredBookPublisherName_ResearchKeys_Text", "Authored Book Publisher Name", String.class),
    AUTHORED_BOOK_ISBN_PRINT("authoredBookIsbnPrint_ResearchKeys_Text", "Authored Book ISBN (Print)", String.class),
    AUTHORED_BOOK_ISBN_EBOOK("authoredBookIsbnEbook_ResearchKeys_Text", "Authored Book ISBN (eBook)", String.class),
    AUTHORED_BOOK_DOI("authoredBookDoi_ResearchKeys_Text", "Authored Book DOI", String.class),
    AUTHORED_BOOK_URL_DIGITAL_ARCHIVE("authoredBookUrlDigitalArchive_ResearchKeys_Text", "Authored Book URL to Digital Archive", String.class),

    AUTHORED_BOOK_INDEXED_IN("authoredBookIndexedIn_ResearchKeys_TextArray", "Authored Book Indexed In", String.class),

   //EDITED BOOK
    EDITED_BOOK_TITLE("editedBookTitle_ResearchKeys_Text","Edited Book Title", String.class),
    EDITED_BOOK_SUB_TITLE("editedBookSubTitle_ResearchKeys_Text", "Edited Book Sub Title", String.class),
    EDITED_BOOK_ABSTRACT("editedBookAbstract_ResearchKeys_Text","Edited Book Abstract", String.class),
    EDITED_BOOK_AUTHORS_LIST("editedBookAuthorsList_ResearchKeys_DocumentArray", "Edited Book  Authors List", Document.class),
    EDITED_BOOK_AUTHOR_NAMES("editedBookAuthorNames_ResearchKeys_Text", "Edited Book Author Names", String.class),
    EDITED_BOOK_AUTHOR_AFFILIATION("editedBookAuthorAffiliation_ResearchKeys_Text", "Edited Book Author Affiliation", String.class),
    EDITED_BOOK_PUBLICATION_DATE("editedBookPublicationDate_ResearchKeys_Date", "Edited Book Publication Date", Long.class),
    EDITED_BOOK_LANGUAGE("editedBookLanguage_ResearchKeys_Text", "Edited Book Language", String.class),

    EDITED_BOOK_PUBLISHER_NAME("editedBookPublisherName_ResearchKeys_Text", "Edited Book Publisher Name", String.class),
    EDITED_BOOK_ISBN_PRINT("editedBookIsbnPrint_ResearchKeys_Text", "Edited Book ISBN (Print)", String.class),
    EDITED_BOOK_ISBN_EBOOK("editedBookIsbnEbook_ResearchKeys_Text", "Edited Book ISBN (eBook)", String.class),
    EDITED_BOOK_DOI("editedBookDoi_ResearchKeys_Text", "Edited Book DOI", String.class),
    EDITED_BOOK_URL_DIGITAL_ARCHIVE("editedBookUrlDigitalArchive_ResearchKeys_Text", "Edited Book URL to Digital Archive", String.class),

    EDITED_BOOK_INDEXED_IN("editedBookIndexedIn_ResearchKeys_TextArray", "Edited Book Indexed In", String.class),

    // CONFERENCE PRESENTATION

    CONFERENCE_MODE_OF_PRESENTATION("conferenceModeOfPresentation_ResearchKeys_Text", "Conference Mode of Presentation", String.class),
    CONFERENCE_TYPE_OF_PRESENTATION("conferenceTypeOfPresentation_ResearchKeys_Text", "Conference Type of Presentation", String.class),
    CONFERENCE_TITLE_OF_PRESENTATION("conferenceTitleOfPresentation_ResearchKeys_Text", " Conference Title Of Presentation ", String.class),
    CONFERENCE_TITLE("conferenceTitle_ResearchKeys_Text", " Conference Title", String.class),
    CONFERENCE_ORGANIZING_INSTITUTION("conferenceOrganizingInstitution_ResearchKeys_Text", " Conference Organizing Institution", String.class),
    UPLOAD_CERTIFICATE("uploadCertificate_ResearchKeys_File","Upload Certificate ",String.class),
    CONFERENCE_PRESENTER("conferencePresenter_ResearchKeys_Text", "Conference Presentation Conference Name", String.class),
    CONFERENCE_AFFILIATION("conferenceAffiliation_ResearchKeys_Text", "Conference Affiliation", String.class),
    DATE_OF_PRESENTATION("dateOfPresentation_ResearchKeys_Date", "Conference Presentation Conference Name", Long.class),
    CONFERENCE_PRESENTER_LIST("conferencePresenterList_ResearchKeys_DocumentArray", "Conference Presenter List",Document.class),

    //CONFERENCE_PRESENTATION_STATUS("conferencePresentationStatus_ResearchKeys_Text", "Conference Presentation Status", String.class),
    //CONFERENCE_PRESENTATION_AUTHOR_ROLE("conferencePresentationAuthorRole_ResearchKeys_Text", "Conference Presentation Author Role", String.class),
    //CONFERENCE_PRESENTATION_CONFERENCE_NAME("conferencePresentationConferenceName_ResearchKeys_Text", "Conference Presentation Conference Name", String.class),
    //CONFERENCE_PRESENTATION_CONFERENCE_THEME_TRACK("conferencePresentationConferenceThemeTrack_ResearchKeys_Text", "Conference Presentation Conference Theme/Track", String.class),
    //CONFERENCE_PRESENTATION_ORGANIZER_NAME("conferencePresentationOrganizerName_ResearchKeys_Text", "Conference Presentation Organizer Name", String.class),
    //CONFERENCE_PRESENTATION_CONFERENCE_TYPE("conferencePresentationConferenceType_ResearchKeys_Text", "Conference Presentation Conference Type", String.class),
    //CONFERENCE_PRESENTATION_VENUE("conferencePresentationVenue_ResearchKeys_Text", "Conference Presentation Venue ", String.class),

    // PATENT

    PATENT_NATURE("patentNature_ResearchKeys_Text", "Patent Nature", String.class),
    PATENT_TYPE("patentType_ResearchKeys_Text", "Patent Type", String.class),
    PATENT_TITLE("patentTitle_ResearchKeys_Text", "Patent Title", String.class),
    PATENT_ABSTRACT("patentAbstract_ResearchKeys_Text", "Patent Abstract", String.class),
    PATENT_KEYWORDS("patentKeywords_ResearchKeys_Text", "Patent Keywords", String.class),
    PATENT_NUMBER("patentNumber_ResearchKeys_Text", "Patent Number", String.class),
    PATENT_STATUS("patentStatus_ResearchKeys_Text", "Patent Status", String.class),
    PATENTEE_INVENTION_OWNED_BY_KJU("patenteeInventionOwnedByKju_ResearchKeys_Bool", "Patentee Invention Owned By Kju",Boolean.class),
    FILED_THROUGH_IPR_OFFICE_OF_KJU("filedThroughIprOfficeOfKju_ResearchKeys_Bool", "Filed Through Ipr Office Of Kju" ,Boolean.class),
    PATENT_INVENTOR_NAME("patentInventorName_ResearchKeys_Text", "Patent Inventor Name", String.class),
    PATENT_INVENTOR_AFFILIATION("patentInventorAffiliation_ResearchKeys_Text", "Patent Inventor Affiliation", String.class),
    PATENT_REGISTERED_DATE("patentRegisteredDate_ResearchKeys_Date", "Patent Publication Date", Long.class),
    PATENT_PUBLISHED_DATE("patentPublishedDate_ResearchKeys_Date", "Patent Published Date", Long.class),
    PATENT_GRANTED_DATE("patentGrantedDate_ResearchKeys_Date", "Patent Granted Date", Long.class),

    PROOF_OF_PATENT("proofOfPatent_ResearchKeys_File","Proof Of Patent ",String.class),
    PROOF_OF_PAYMENT_RECEIPT("proofOfPaymentReceipt_ResearchKeys_File","Proof Of Payment Receipt",String.class),
    PATENT_INVENTORS_LIST("patentInventorsList_ResearchKeys_DocumentArray", "Patent Inventors List",Document.class),
    APPROVED_AT("approvedAt_ResearchKeys_Date","Approved At", Long.class),
    APPROVED_BY("approvedBy_ResearchKeys_Text","Approved By", String.class),

    SAVE_AS_DRAFT("saveAsDraft_ResearchKeys_Bool","Save As Draft",Boolean.class),
    DETAILS_CREATED_BY("detailsCreatedBy_ResearchKeys_Text","Details Created By", String.class),
    DETAILS_CREATED_AT("detailsCreatedAt_ResearchKeys_Date","Details Created At", Long.class),
    DETAILS_UPDATED_AT("detailsUpdatedAt_ResearchKeys_Date","Details Created At", Long.class),
    PUBLICATION_STATUS("publicationStatus_ResearchKeys_Text","Publication Status",String.class),
    PAPER_FILE_UPLOAD("paperFileUpload_ResearchKeys_File","Paper File Upload",String.class),
    REFERENCE_NUMBER("referenceNumber_ResearchKeys_Text","Reference Number", String.class),

    ADMINS_REMARKS("adminsRemarks_ResearchKeys_Text", "Admins Remarks", String.class),
    SEED_MONEY_FILE_UPLOAD("seedMoneyFileUpload_ResearchKeys_File", "Seed Money File Upload", String.class),
    SEED_MONEY("seedMoney_ResearchKeys_Double", "Seed Money", Double.class),
    ADMIN_EDITED_AT("adminEditedAt_ResearchKeys_Date","Admin Edited At", Long.class),


    APPROVED_INDEXING("approvedIndexing_ResearchKeys_Text","Approved Indexing",String.class),


    APPROVED_CITE_SCORE("approvedCiteScore_ResearchKeys_Text","Approved Cite Score",String.class),

    ACCOUNTS_INCENTIVE_STATUS("accountsIncentiveStatus_ResearchKeys_Bool","Accounts Incentive Status",Boolean.class),
    PUBLICATION_USER_TYPE("publicationUserType_ResearchKeys_Text","Publication User Type",String.class),
    ACCOUNTS_INCENTIVE_STATUS_PATENT("accountsIncentiveStatusPatent_ResearchKeys_Text","Accounts Incentive Status Patent",String.class),

    //Citation Overview
    OVERALL_DOCUMENTS("overallDocuments_ResearchKeys_Int","Overall Documents",Integer.class),
    AUTHOR_COUNT("authorCount_ResearchKeys_Int","Overall Documents",Integer.class),
    CITATION_OVERVIEW_DOCUMENTS("citationOverviewDocuments_ResearchKeys_Int","Citation Overview Documents", Integer.class),
    TOTAL_CITATIONS("totalCitations_ResearchKeys_Int","Total Citations", Integer.class),
    H_INDEX("hIndex_ResearchKeys_Int","H Index", Integer.class),
    ROLE_NAME("roleName_ResearchKeys_Text", "Role Name", String.class),
    TRANSACTION_ID("transactionId_ResearchKeys_Text", "Transaction Id", String.class),

    ;


    private final String property;
    private final String label;
    private final Class<?> dataType;
    private final int minLength;
    private final int maxLength;

    private ResearchKeysPBinder(String property, String label, Class<?> dataType, int minLength, int maxLength) {
        this.property = property;
        this.label = label;
        this.dataType = dataType;
        this.minLength = minLength;
        this.maxLength = maxLength;
    }

    private ResearchKeysPBinder(String property, String label, Class<?> dataType) {
        this.property = property;
        this.label = label;
        this.dataType = dataType;
        this.minLength = -1;
        this.maxLength = -1;
    }

    public String getPropertyName() {
        return this.property;
    }

    public String getDisplayName() {
        return this.label;
    }

    public Class<?> getDataType() {
        return this.dataType;
    }

    public Integer getMinLength() {
        return this.minLength;
    }

    public Integer getMaxLength() {
        return this.maxLength;
    }

    private static ResearchKeysPBinder[] $values() {
        return ResearchKeysPBinder.class.getEnumConstants();
    }

}
