package in.edu.kristujayanti.collectionNames;

public enum JayantianScholarCNBinder implements KJUSYSCNBinder{

    PUBLICATION_TYPE_COLLECTION("research_publication_type"),
    SUBJECT_AREA_COLLECTION("research_subject_area"),
    JAYANTIAN_SCHOLAR_COLLECTION("jayantian_scholar_collection"),
    CITATION_OVERVIEW("citation_overview")
    ;

    private final String collectionName;

    private JayantianScholarCNBinder(String collectionName){
        this.collectionName = collectionName;
    }

    private static JayantianScholarCNBinder[] $values() {
        return JayantianScholarCNBinder.class.getEnumConstants();
    }

    @Override
    public String getCollectionName() {
        return this.collectionName;
    }
}