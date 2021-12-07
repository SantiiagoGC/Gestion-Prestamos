package co.edu.uniquindio.gestionPrestamos.model;

/**
 * Represnta la clase Empleado, que extiende de  la clase Persona.
 * @author santi, nodier, juan.
 *
 */
public class Empleado extends Persona{

	//Variables del empleado
    private String tipoEmpleado;
    private String aniosExperiencia;

    /**
     * Metodo constructo de la clase Empleado
     * @param documento Este paramentro representa el documento del empleado
     * @param nombre Este paramentro representa el nombre del empleado
     * @param telefono Este paramentro representa el telefono del empleado
     * @param celular Este paramentro representa el celular del empleado
     * @param direccion Este paramentro representa la direccion del empleado
     * @param ciudadResidencia Este paramentro representa la ciudad del empleado
     * @param departamento Este paramentro representa el departamento del empleado
     * @param pais Este paramentro representa el pais del empleado
     * @param mail Este paramentro representa el email del empleado
     * @param tipoEmpleado Este paramentro representa el tipo de empleado
     * @param aniosExperiencia Este paramentro representa los anios de xp del empleado
     */
    public Empleado(String documento, String nombre, String telefono, String celular,
    		String direccion, String ciudadResidencia, String departamento, String pais,
    		String mail, String tipoEmpleado, String aniosExperiencia) {
    	
        super(documento, nombre, telefono, celular, direccion, ciudadResidencia,
        		departamento, pais, mail);
        
        this.tipoEmpleado = tipoEmpleado;
        this.aniosExperiencia = aniosExperiencia;
    }
    
    //-------------------------GETTERS AND SETTERS----------------------------------//
    
    /**
     * Metodo get del tipo de empleado
     * @return String con tipo de empleado
     */
    public String getTipoEmpleado() {
        return tipoEmpleado;
    }
    
    /**
     * Metodo set del tipo de empleado
     * @param tipoEmpleado
     */
    public void setTipoEmpleado(String tipoEmpleado) {
        this.tipoEmpleado = tipoEmpleado;
    }
    
    /**
     * Metodo get de los anios de experiencia del empleado
     * @return String con los aniso de experiencia
     */
    public String getAniosExperiencia() {
		return aniosExperiencia;
	}
    
    /**
     * Metodo set de los anios de experiencia del empleado
     * @param aniosExperiencia
     */
	public void setAniosExperiencia(String aniosExperiencia) {
		this.aniosExperiencia = aniosExperiencia;
	}
	
	@Override
	public String toString() {
		return "Nombre: " + getNombre() + "\nDocumento: " + getDocumento() + "\nCelular: " +
				getCelular() + "\nTelefono: " + getTelefono() +
				"\nDireccion: " + getDireccion() + "\nCiudad: " + getCiudadResidencia() +
				"\nDepartamento: " + getDepartamento() +"\nPais: " + getPais() + "\nEmail: " +
				getMail() + "\nTipo de empleado: " + tipoEmpleado +"\nAños de experiencia " +aniosExperiencia+ "." ;
		
	}

}
