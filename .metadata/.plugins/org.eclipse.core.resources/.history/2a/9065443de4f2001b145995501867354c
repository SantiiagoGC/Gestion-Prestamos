package co.edu.uniquindio.gestionPrestamos.model;

public enum ConditionProduct {

    DISPONIBLE(1), NO_DISPONIBLE(2);
    int productCondition;

    private ConditionProduct(int productCondition){
        this.productCondition = productCondition;
    }

    public int getProductCondition() {
        return productCondition;
    }

    public void setProductCondition(int productCondition) {
        this.productCondition = productCondition;
    }

    public String toString(){

        String condition = "";

        switch(productCondition){
            case 1:
                condition = "DISPONIBLE";
                break;
            case 2:
                condition = "NO_DISPONIBLE";
                break;
            default:
                break;
        }
        return condition;
    }
}
