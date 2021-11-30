package co.edu.uniquindio.gestionPrestamos.model;

/**
 * Representa la clase Objeto
 * @author Mauricio y Johan
 *
 */
public class Objeto {

    private String codigo;
    private String nombre;
    private String color;
    private String peso;
    private String precioAlquiler;
    private String estadoObjeto;
    private String tipo;
    private String descripcion;
	private int unidadesDisponibles;
	private int unidadesPrestadas;
    /**
     * Constructor
     * @param codigo
     * @param nombre
     * @param color
     * @param peso
     * @param estado
     * @param valorUnitario
     * @param valorTotal
     * @param estadoObjeto
     */

	public Objeto(String codigo, String nombre, String color, String peso, String precioAlquiler,
			String estadoObjeto,  String tipo, String descripcion, int unidadesDisponibles,
			int unidadesPrestadas) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.color = color;
		this.peso = peso;
		this.precioAlquiler = precioAlquiler;
		this.estadoObjeto = estadoObjeto;
		this.tipo = tipo;
		this.descripcion = descripcion;
		this.unidadesDisponibles = unidadesDisponibles;
		this.unidadesPrestadas = unidadesPrestadas;
	}
	
	//Getters y Setters

    public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String getPeso() {
        return peso;
    }
    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getEstadoObjeto() {
        return estadoObjeto;
    }

    public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public void setEstadoObjeto(String estadoObjeto) {
        this.estadoObjeto = estadoObjeto;
    }

	public String getPrecioAlquiler() {
		return precioAlquiler;
	}

	public void setPrecioAlquiler(String precioAlquiler) {
		this.precioAlquiler = precioAlquiler;
	}

	public int getUnidadesDisponibles() {
		return unidadesDisponibles;
	}

	public void setUnidadesDisponibles(int unidadesDisponibles) {
		this.unidadesDisponibles = unidadesDisponibles;
	}

	public int getUnidadesPrestadas() {
		return unidadesPrestadas;
	}

	public void setUnidadesPrestadas(int unidadesPrestadas) {
		this.unidadesPrestadas = unidadesPrestadas;
	}

	@Override
	public String toString() {
		return "Product [codigo=" + codigo + ", nombre=" + nombre + ", color=" + color + ", peso=" + peso
				+ ", precioAlquiler=" + precioAlquiler + ", estadoObjeto=" + estadoObjeto + ", tipo=" + tipo
				+ ", descripcion=" + descripcion + ", unidadesDisponibles=" + unidadesDisponibles
				+ ", unidadesPrestadas=" + unidadesPrestadas + "]";
	}

}