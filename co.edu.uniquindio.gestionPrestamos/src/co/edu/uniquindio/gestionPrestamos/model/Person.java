package co.edu.uniquindio.gestionPrestamos.model;

/**
 * Representa la clase
 * @author stella
 *
 */
public abstract class Person {

    private String documento;
    private String nombre;
    private String telefono;
    private String celular;
    private String direccion;
    private String ciudadResidencia;
    private String departamento;
    private String pais;
    private String mail;
    /**
     * Constructor
     * @param documento
     * @param nombre
     * @param apellidos
     * @param celular
     * @param direccion
     * @param ciudadResidencia
     * @param departamento
     * @param pais
     * @param mail
     * @param tipoDcoumento
     */
    public Person(String documento, String nombre, String telefono, String celular, String direccion,
            String ciudadResidencia, String departamento, String pais, String mail) {
        super();
        this.documento = documento;
        this.nombre = nombre;
        this.telefono = telefono;
        this.celular = celular;
        this.direccion = direccion;
        this.ciudadResidencia = ciudadResidencia;
        this.departamento = departamento;
        this.pais = pais;
        this.mail = mail;
    }
    //Getters y setters---------------------------------------------------------------
    public String getDocumento() {
        return documento;
    }
    public void setDocumento(String documento) {
        this.documento = documento;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getCelular() {
        return celular;
    }
    public void setCelular(String celular) {
        this.celular = celular;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getCiudadResidencia() {
        return ciudadResidencia;
    }
    public void setCiudadResidencia(String ciudadResidencia) {
        this.ciudadResidencia = ciudadResidencia;
    }
    public String getDepartamento() {
        return departamento;
    }
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
    public String getPais() {
        return pais;
    }
    public void setPais(String pais) {
        this.pais = pais;
    }
    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }

 
    @Override
    public String toString() {
        return "Persona [documento=" + documento + ", nombre=" + nombre + ", apellidos=" + telefono + ", celular="
                + celular + ", direccion=" + direccion + ", ciudadResidencia=" + ciudadResidencia + ", departamento="
                + departamento + ", pais=" + pais + ", mail=" + mail +  "]";
    }



}