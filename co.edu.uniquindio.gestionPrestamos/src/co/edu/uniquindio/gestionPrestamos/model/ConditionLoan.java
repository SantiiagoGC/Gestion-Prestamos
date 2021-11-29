package co.edu.uniquindio.gestionPrestamos.model;

public enum ConditionLoan {

	ENTREGADO(1), FALTA_POR_ENTREGAR(2);
    int conditionProduct;

    private ConditionLoan(int conditionProduct){
        this.conditionProduct = conditionProduct;
    }

    public int getConditionLoan() {
        return conditionProduct;
    }

    public void setConditionLoan(int conditionProduct) {
        this.conditionProduct = conditionProduct;
    }

    public String toString(){

        String condition = "";

        switch(conditionProduct){
            case 1:
                condition = "ENTREGADO";
                break;
            case 2:
                condition = "FALTA_POR_ENTREGAR";
                break;
            default:
                break;
        }
        return condition;
    }
}
