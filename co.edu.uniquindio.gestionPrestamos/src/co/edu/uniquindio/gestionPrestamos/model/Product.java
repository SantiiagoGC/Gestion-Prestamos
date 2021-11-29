package co.edu.uniquindio.gestionPrestamos.model;

/**
 * Representa la clase Objeto
 * @author Mauricio y Johan
 *
 */
public class Product {

    private String codigo;
    private String nombre;
    private String color;
    private String peso;
    private String valorUnitario;
    private String valorTotal;
    private ConditionProduct estadoObjeto;
	private String foto;
    private String tipo;
    private String descripcion;
	private String precioAlquiler;
	private String unidadesDisponibles;
	private String unidadesPrestadas;
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
    public Product(String codigo, String nombre, String color, String peso, String valorUnitario, String valorTotal,
			ConditionProduct estadoObjeto, String tipo, String descripcion) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.color = color;
		this.peso = peso;
		this.valorUnitario = valorUnitario;
		this.valorTotal = valorTotal;
		this.estadoObjeto = estadoObjeto;
		this.tipo = tipo;
		this.descripcion = descripcion;
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
    public String getValorUnitario() {
        return valorUnitario;
    }
    public void setValorUnitario(String valorUnitario) {
        this.valorUnitario = valorUnitario;
    }
    public String getValorTotal() {
        return valorTotal;
    }
    public void setValorTotal(String valorTotal) {
        this.valorTotal = valorTotal;
    }

    public ConditionProduct getEstadoObjeto() {
        return estadoObjeto;
    }

    public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public void setEstadoObjeto(ConditionProduct estadoObjeto) {
        this.estadoObjeto = estadoObjeto;
    }
	
    public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getPrecioAlquiler() {
		return precioAlquiler;
	}

	public void setPrecioAlquiler(String precioAlquiler) {
		this.precioAlquiler = precioAlquiler;
	}

	public String getUnidadesDisponibles() {
		return unidadesDisponibles;
	}

	public void setUnidadesDisponibles(String unidadesDisponibles) {
		this.unidadesDisponibles = unidadesDisponibles;
	}

	public String getUnidadesPrestadas() {
		return unidadesPrestadas;
	}

	public void setUnidadesPrestadas(String unidadesPrestadas) {
		this.unidadesPrestadas = unidadesPrestadas;
	}

	@Override
	public String toString() {
		return "Product [codigo=" + codigo + ", nombre=" + nombre + ", color=" + color + ", peso=" + peso
				+ ", valorUnitario=" + valorUnitario + ", valorTotal=" + valorTotal + ", estadoObjeto=" + estadoObjeto
				+ ", foto=" + foto + ", tipo=" + tipo + ", descripcion=" + descripcion + ", precioAlquiler="
				+ precioAlquiler + ", unidadesDisponibles=" + unidadesDisponibles + ", unidadesPrestadas="
				+ unidadesPrestadas + "]";
	}



}