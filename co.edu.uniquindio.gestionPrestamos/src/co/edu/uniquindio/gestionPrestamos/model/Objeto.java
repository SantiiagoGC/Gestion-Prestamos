package co.edu.uniquindio.gestionPrestamos.model;

/**
 * Representa la clase Objeto
 * @author santi, juan, nodier.
 *
 */
public class Objeto {

	//Variables de la clase Objeto
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
	 * Metodo constructor de la clase Objeto
	 * @param codigo Representa el codigo del objeto
	 * @param nombre Representa el nombre del objeto
	 * @param color Representa el color del objeto
	 * @param peso Representa el peso del objeto
	 * @param precioAlquiler Representa el precio de alquiler del objeto
	 * @param estadoObjeto Representa el estado del objeto
	 * @param tipo Representa el tipo de objeto
	 * @param descripcion Representa la descripcion del objeto
	 * @param unidadesDisponibles Representa las unidades disponibles del objeto
	 * @param unidadesPrestadas Representa las unidades prestadas del objeto
	 */
	public Objeto(String codigo, String nombre, String color, String peso,
			String precioAlquiler, String estadoObjeto,  String tipo,
			String descripcion, int unidadesDisponibles, int unidadesPrestadas) {
		
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
	
	//------------------------------GETTERS AND SETTERS-----------------------------//

	/**
	 * Metodo get de la descripcion del objeto 		
	 * @return String con la descripcion del objeto
	 */
    public String getDescripcion() {
		return descripcion;
	}

    /**
     * Metodo set de la descripcion del objeto
     * @param descripcion
     */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Metodo get del codigo del objeto
	 * @return String con el codigo del objeto
	 */
	public String getCodigo() {
        return codigo;
    }
	
	/**
	 * Metodo set del codigo del objeto
	 * @param codigo
	 */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    /**
     * Metodo get del nombre del objeto
     * @return String con el nombre del objeto
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * Metodo set del nombre del objeto
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * Metodo get del color del objeto
     * @return String con el color del objeto
     */
    public String getColor() {
        return color;
    }
    
    /**
     * Metodo set del color del objeto
     * @param color
     */
    public void setColor(String color) {
        this.color = color;
    }
    
    /**
     * Metodo get del peso del objeto
     * @return String con el peso del objeto
     */
    public String getPeso() {
        return peso;
    }
    
    /**
     * Metodo set del peso del objeto
     * @param peso
     */
    public void setPeso(String peso) {
        this.peso = peso;
    }

    /**
     * Metodo get del estado del objeto
     * @return String con el estado del objeto
     */
    public String getEstadoObjeto() {
        return estadoObjeto;
    }
    
	/**
	 * Metodo set del estado del objeto
	 * @param estadoObjeto
	 */
	public void setEstadoObjeto(String estadoObjeto) {
        this.estadoObjeto = estadoObjeto;
    }

    /**
     * Metodo get del tipo de objeto
     * @return String con el tipo de objeto
     */
    public String getTipo() {
		return tipo;
	}
    
    /**
     * Metodo set del tipo de objeto
     * @param tipo
     */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * Metodo get del precio del alquiler
	 * @return String con el precio del alquiler
	 */
	public String getPrecioAlquiler() {
		return precioAlquiler;
	}

	/**
	 * Metodo set del precio del alquiler
	 * @param precioAlquiler
	 */
	public void setPrecioAlquiler(String precioAlquiler) {
		this.precioAlquiler = precioAlquiler;
	}
	
	/**
	 * Metodo get de las unidades disponibles
	 * @return int con las unidades disponibles
	 */
	public int getUnidadesDisponibles() {
		return unidadesDisponibles;
	}
	
	/**
	 * Metodo set de las unidades disponibles
	 * @param unidadesDisponibles
	 */
	public void setUnidadesDisponibles(int unidadesDisponibles) {
		this.unidadesDisponibles = unidadesDisponibles;
	}
	
	/**
	 * Metodo get de las unidades prestadas
	 * @return int con las unidades prestadas
	 */
	public int getUnidadesPrestadas() {
		return unidadesPrestadas;
	}

	/**
	 * Metodo set de las unidades prestadas
	 * @param unidadesPrestadas
	 */
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