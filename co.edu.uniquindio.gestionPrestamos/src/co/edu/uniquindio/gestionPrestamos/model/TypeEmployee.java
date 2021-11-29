package co.edu.uniquindio.gestionPrestamos.model;

public enum TypeEmployee {

    AMINISTRADOR(0), PRESTADOR(1), JEFE_DE_INVENTARIO(3);
    private int typeEmployee;

    private TypeEmployee(int typeEmployee) {
        this.typeEmployee = typeEmployee;
    }

    public int getTypeEmployee() {
        return typeEmployee;
    }

    public void setTypeEmployee(int documentType) {
        this.typeEmployee = documentType;
    }

    public String toString(){

        String type = "";

        switch(typeEmployee){
            case 0:
                type = "AMINISTRADOR";
                break;
            case 1:
                type = "PRESTADOR";
                break;
            case 2:
                type = "JEFE_DE_INVENTARIO";
                break;
            default:
                break;
        }
        return type;
    }

}
