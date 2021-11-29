package co.edu.uniquindio.gestionPrestamos.model;

/*
* Representa la clase cliente
* @author Mauricio y Johan
*
*/
public class Cliente extends Person {

	private String profesion;
	private String genero;

	/*
	 * Consttructor
	 * 
	 * @param documento
	 * 
	 * @param nombre
	 * 
	 * @param apellidos
	 * 
	 * @param celular
	 * 
	 * @param direccion
	 * 
	 * @param ciudadResidencia
	 * 
	 * @param departamento
	 * 
	 * @param pais
	 * 
	 * @param mail
	 * 
	 * @param tipoDcoumento
	 * 
	 * @param profesion
	 */
	public Cliente(String documento, String nombre, String telefono, String celular, String direccion,
			String ciudadResidencia, String departamento, String pais, String mail,
			String profesion, String genero) {
		super(documento, nombre, telefono, celular, direccion, ciudadResidencia, departamento, pais, mail);
		this.profesion = profesion;
		this.genero = genero;
	}

	// Setters y Getters------------------------------------------------
	public String getProfesion() {
		return profesion;
	}

	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}

	public String getGenero() {
		return genero;
	}

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
