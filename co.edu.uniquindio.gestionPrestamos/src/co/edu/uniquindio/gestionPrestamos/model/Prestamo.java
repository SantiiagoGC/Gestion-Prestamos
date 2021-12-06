package co.edu.uniquindio.gestionPrestamos.model;

import java.util.ArrayList;

/**
 * Representa la clase Prestamo
 * @author santi, juan, nodier
 *
 */
public class Prestamo {

	//VARIBALES DE LA CLASE
    private String codigo;
    private String estadoPrestamo;
    private String valor;
    private String fechaPrestamo;
    private String fechaEntrega;
    private Cliente cliente;
    private Empleado empleado;
    private Objeto objeto;
    private int diasTranscurridos;
    private int diasSolicitados;
    
    /**
     * Constructor de la clase Prestamo
     * @param codigo este dato representa el codigo del prestamo
     * @param valor este dato represta el valor del prestamo
     * @param fechaPrestamo este dato representa la fecha del prestamo
     * @param fechaEntrega este dato representa la fecha de entrega del prestamo
     * @param estadoPrestamo este dato representa el estado del prestamo
     * @param cliente este dato representa el cliente que realizo el prestamo
     * @param empleado este dato representa el empleado que realizo el prestamo
     * @param objeto este dato representa el objeto que se presto
     * @param diasTranscurridos este dato representa los dias transcurridos desde el prestamos
     * @param diasSolicitados este dato respresenta los dias solicitados para el prestamo
     */
    public Prestamo(String codigo, String valor, String fechaPrestamo, String fechaEntrega, String estadoPrestamo,
			Cliente cliente, Empleado empleado, Objeto objeto, int diasTranscurridos, int diasSolicitados) {
		super();
		this.codigo = codigo;
		this.valor = valor;
		this.fechaPrestamo = fechaPrestamo;
		this.fechaEntrega = fechaEntrega;
		this.estadoPrestamo = estadoPrestamo;
		this.cliente = cliente;
		this.empleado = empleado;
		this.objeto = objeto;
		this.diasTranscurridos = diasTranscurridos;
		this.diasSolicitados = diasSolicitados;
	}
	
    /**
     * Metodo get del codigo del Prestamo
     * @return un String con el codigo
     */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * Metodo set del codigo del Prestamo
	 * @param codigo
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * Metodo get del estado del prestamo
	 * @return un String con el estado del prestamo
	 */
	public String getEstadoPrestamo() {
		return estadoPrestamo;
	}

	/**
	 * Metodo set del estado del prestamo
	 * @param estadoPrestamo 
	 */
	public void setEstadoPrestamo(String estadoPrestamo) {
		this.estadoPrestamo = estadoPrestamo;
	}

	/**
	 * Metodo get del velor del prestamo
	 * @return un String con el valor del prestamo
	 */
	public String getValor() {
		return valor;
	}

	/**
	 * Metodo set del valor del prestamo
	 * @param valor
	 */
	public void setValor(String valor) {
		this.valor = valor;
	}

	/**
	 * Metodo get de la fecha en que se realizo el prestamo
	 * @return un String con la fecha del prestamo
	 */
	public String getFechaPrestamo() {
		return fechaPrestamo;
	}

	/**
	 * Metodo set del la fecha del prestamo
	 * @param fechaPrestamo
	 */
	public void setFechaPrestamo(String fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}

	/**
	 * Metodo get de la fecha de entrega del prestamo
	 * @return un String con la fecha de entrega del prestamo
	 */
	public String getFechaEntrega() {
		return fechaEntrega;
	}

	/**
	 * Metodo set de la fecha de entrega del prestamo
	 * @param fechaEntrega
	 */
	public void setFechaEntrega(String fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	/**
	 * Metodo get del Cliente que hizo el prestamo
	 * @return cliente un objeto de tipo Cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * Metodo set del Cliente que hizo el prestamo
	 * @param cliente
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	/**
	 * Metodo get del Empleado que hizo el prestamo
	 * @return empleado un objeto de tipo Empleado
	 */
	public Empleado getEmpleado() {
		return empleado;
	}

	/**
	 * Metodo set del Empleado que hizo el prestamo
	 * @param empleado
	 */
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	/**
	 * Metodo get del Objeto que sera prestado
	 * @return objeto un objeto de tipo Objeto
	 */
	public Objeto getObjeto() {
		return objeto;
	}

	/**
	 * Metodo set del Objeto del prestamo
	 * @param objeto
	 */
	public void setObjeto(Objeto objeto) {
		this.objeto = objeto;
	}

	/**
	 * Metodo get de los dias transcurridos
	 * @return los dias transcurridos
	 */
	public int getDiasTranscurridos() {
		return diasTranscurridos;
	}

	/**
	 * Metodo set de los dias transcurridos
	 * @param diasTranscurridos
	 */
	public void setDiasTranscurridos(int diasTranscurridos) {
		this.diasTranscurridos = diasTranscurridos;
	}

	/**
	 * Metodo get de los dias solicitados
	 * @return los dias solicitados
	 */
	public int getDiasSolicitados() {
		return diasSolicitados;
	}

	/**
	 * Metodo set de los dias solicitados
	 * @param diasSolicitados
	 */
	public void setDiasSolicitados(int diasSolicitados) {
		this.diasSolicitados = diasSolicitados;
	}

}
