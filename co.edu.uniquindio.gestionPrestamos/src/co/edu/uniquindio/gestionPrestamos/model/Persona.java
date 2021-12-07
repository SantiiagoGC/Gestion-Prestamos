package co.edu.uniquindio.gestionPrestamos.model;

/**
 * Representa la clase Persona
 * @author santi, nodier, juan
 *
 */
public class Persona {

	//Variables de la clase Persona
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
     * Metodo constructor de la clase persona
     * @param documento Representa el documento de una persona
     * @param nombre Representa el nombre de una persona
     * @param telefono Representa el telefono de una persona
     * @param celular Representa el celular de una persona
     * @param direccion Representa la direccion de una persona
     * @param ciudadResidencia Representa la ciudad de una persona
     * @param departamento Representa el departamento de una persona
     * @param pais Representa el pais de una persona
     * @param mail Representa el email de una persona
     */
    public Persona(String documento, String nombre, String telefono, String celular, String direccion,
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
    //---------------------------------GETTERS AND SETTERS---------------------------//
    
    /**
     * Metodo get del documento de una persona
     * @return String con el documento de una persona
     */
    public String getDocumento() {
        return documento;
    }
    
    /**
     * Metodo set del documento de una persona
     * @param documento
     */
    public void setDocumento(String documento) {
        this.documento = documento;
    }
    
    /**
     * Metodo get del nombre de una persona
     * @return String con el nombre de una persona
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * Metodo set con el nombre de una persona
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * Metodo get con el telefono de una persona
     * @return String con el telefono de una persona
     */
    public String getTelefono() {
        return telefono;
    }
    
    /**
     * Metodo set del telefono de una persona
     * @param telefono
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    /**
     * Metodo get con el celular de una persona
     * @return String con el telefono de una persona
     */
    public String getCelular() {
        return celular;
    }
    
    /**
     * Metodo set del celular de una persona
     * @param celular
     */
    public void setCelular(String celular) {
        this.celular = celular;
    }
    
    /**
     * Metodo get de la dirccion de una persona
     * @return String con la direccion de una persona
     */
    public String getDireccion() {
        return direccion;
    }
    
    /**
     * Metodo set de la direccion de una persona
     * @param direccion
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    /**
     * Metodo get de la ciudad de una persona
     * @return String con la direccion de una persona
     */
    public String getCiudadResidencia() {
        return ciudadResidencia;
    }
    
    /**
     * Metodo set de la ciudad de una persona
     * @param ciudadResidencia
     */
    public void setCiudadResidencia(String ciudadResidencia) {
        this.ciudadResidencia = ciudadResidencia;
    }
    
    /**
     * Metodo get del departamento de una persona
     * @return String con el departamento de una persona
     */
    public String getDepartamento() {
        return departamento;
    }
    
    /**
     * Metodo set del departamento de una persona
     * @param departamento
     */
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
    
    /**
     * Metodo get del pais de una persona
     * @return String con el pais de una persona
     */
    public String getPais() {
        return pais;
    }
    
    /**
     * Metodo set del pais de una persona
     * @param pais
     */
    public void setPais(String pais) {
        this.pais = pais;
    }
    
    /**
     * Metodo get del email de una persona
     * @return String con el email de una persona
     */
    public String getMail() {
        return mail;
    }
    
    /**
     * Metodo set del email de una persona
     * @param mail
     */
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