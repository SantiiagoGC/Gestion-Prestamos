package co.edu.uniquindio.gestionPrestamos.model;

/**
 * Representa a la calse empleado
 * @author Mauricio y Johan
 *
 **/
public class Empleado extends Person{

    private TypeEmployee tipoEmpleado;
    private String aniosExperiencia;
    /*
     * Cosntructor
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
     * @param tipoEmpleado
     */
    public Empleado(String documento, String nombre, String telefono, String celular, String direccion,
            String ciudadResidencia, String departamento, String pais, String mail,
            TypeEmployee tipoEmpleado, String aniosExperiencia) {
        super(documento, nombre, telefono, celular, direccion, ciudadResidencia, departamento, pais, mail);
        this.tipoEmpleado = tipoEmpleado;
        this.aniosExperiencia = aniosExperiencia;
    }
    //Setters y Getters-------------------------------------------------------------
    public TypeEmployee getTipoEmpleado() {
        return tipoEmpleado;
    }
    public void setTipoEmpleado(TypeEmployee tipoEmpleado) {
        this.tipoEmpleado = tipoEmpleado;
    }
    
    public String getAniosExperiencia() {
		return aniosExperiencia;
	}
	public void setAniosExperiencia(String aniosExperiencia) {
		this.aniosExperiencia = aniosExperiencia;
	}
	@Override
    public String toString() {
        return "Empleado [tipoEmpleado=" + tipoEmpleado + ", getDocumento()=" + getDocumento() + ", getNombre()="
                + getNombre() + ", getTelefono()=" + getTelefono() + ", getCelular()=" + getCelular()
                + ", getDireccion()=" + getDireccion() + ", getCiudadResidencia()=" + getCiudadResidencia()
                + ", getDepartamento()=" + getDepartamento() + ", getPais()=" + getPais() + ", getMail()=" + getMail()
                + ",getAniosExperiencia()=" + getAniosExperiencia() + "]";
    }




}
