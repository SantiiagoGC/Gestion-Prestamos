package co.edu.uniquindio.gestionPrestamos.model;

/**
 * Representa la clase Cliente, esta extiende de la clase Persona
 * @author santi, juan, nodier.
 */
public class Cliente extends Persona {

	//Variables de Cliente
	private String profesion;
	private String genero;

	/**
	 * Metodo contructor de la clase Cliente
	 * @param documento este parametro representa el documento del cliente
	 * @param nombre este parametro representa el nombre del cliente
	 * @param telefono este parametro representa el telefono del cliente
	 * @param celular este parametro representa el celular del cliente
	 * @param direccion este parametro representa la direccion del cliente
	 * @param ciudadResidencia este parametro representa la ciudad del cliente
	 * @param departamento este parametro representa el departamento del cliente
	 * @param pais este parametro representa el pais del cliente
	 * @param mail este parametro representa el mail del cliente
	 * @param profesion este parametro representa la profesion del cliente
	 * @param genero este parametro representa el genero del cliente
	 */
	public Cliente(String documento, String nombre, String telefono, String celular,
			String direccion, String ciudadResidencia, String departamento,
			String pais, String mail, String profesion, String genero) {
		
		super(documento, nombre, telefono, celular, direccion, ciudadResidencia,
				departamento, pais, mail);
		this.profesion = profesion;
		this.genero = genero;
	}

	//-------------------------SETTERS AND GETTERS------------------------------//
	
	/**
	 * Metodo get de la profesion del cliente
	 * @return profesion del cliente
	 */
	public String getProfesion() {
		return profesion;
	}

	/**
	 * Metodo set de la profesion del cliente
	 * @param profesion
	 */
	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}

	/**
	 * Metodo get del genero del cliente
	 * @return genero del cliente
	 */
	public String getGenero() {
		return genero;
	}

	/**
	 * Metodo set del genero del cliente
	 * @param genero
	 */
	public void setGenero(String genero) {
		this.genero = genero;
	}

	@Override
	public String toString() {
		return "Cliente [profesion=" + profesion + ", getDocumento()=" + getDocumento() + ", getNombre()=" + getNombre()
				+ ", getTelefono()=" + getTelefono() + ", getCelular()=" + getCelular() + ", getDireccion()="
				+ getDireccion() + ", getCiudadResidencia()=" + getCiudadResidencia() + ", getDepartamento()="
				+ getDepartamento() + ", getPais()=" + getPais() + ", getMail()=" + getMail() + "]";
	}

	public String toStringNombre() {
		return "" + getNombre();
	}

}
