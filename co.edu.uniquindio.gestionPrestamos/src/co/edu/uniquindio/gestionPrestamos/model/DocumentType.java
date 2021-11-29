package co.edu.uniquindio.gestionPrestamos.model;

public enum DocumentType {

    ID_CITIZEN(0), PASSPORT(1), ID_FOREIGNER(3);
    private int documentType;

    private DocumentType(int documentType) {
        this.documentType = documentType;
    }

    public int getDocumentType() {
        return documentType;
    }

    public void setDocumentType(int documentType) {
        this.documentType = documentType;
    }

    public String toString(){

        String type = "";

        switch(documentType){
            case 0:
                type = "ID_CITIZEN";
                break;
            case 1:
                type = "PASSPORT";
                break;
            case 2:
                type = "ID_FOREIGNER";
                break;
            default:
                break;
        }
        return type;
    }

}
