package co.edu.uniquindio.gestionPrestamos.model;

import java.util.ArrayList;


/**
 * Representa a la clase prestamo
 * @author Mauricio y Johan
 *
 */
public class Loan {

    //Declaración de variables
    private String codigo;
    private String valor;
    private String fechaPrestamo;
    private String fechaEntrega;
    private ConditionLoan estadoPrestamo;
    //private ArrayList<Customer> cliente = new ArrayList<>();
    //private ArrayList<Employee> empleado = new ArrayList<>();
    //private ArrayList<LoanDetail> detallePrestamo = new ArrayList<>();
    private Cliente customer;
    private Empleado employee;
    private Objeto product;
	//Constructor
    public Loan(String codigo, String valor, String fechaPrestamo, String fechaEntrega, ConditionLoan estadoPrestamo,
			Cliente customer, Empleado employee, Objeto product) {
		super();
		this.codigo = codigo;
		this.valor = valor;
		this.fechaPrestamo = fechaPrestamo;
		this.fechaEntrega = fechaEntrega;
		this.estadoPrestamo = estadoPrestamo;
		this.customer = customer;
		this.employee = employee;
		this.product = product;
	}
	/**
	 * Getters and setters
	 * @return
	 */
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public String getFechaPrestamo() {
		return fechaPrestamo;
	}
	public void setFechaPrestamo(String fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}
	public String getFechaEntrega() {
		return fechaEntrega;
	}
	public void setFechaEntrega(String fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}
	public ConditionLoan getEstadoPrestamo() {
		return estadoPrestamo;
	}
	public void setEstadoPrestamo(ConditionLoan estadoPrestamo) {
		this.estadoPrestamo = estadoPrestamo;
	}
	public Cliente getCustomer() {
		return customer;
	}
	public void setCustomer(Cliente customer) {
		this.customer = customer;
	}
	public Empleado getEmployee() {
		return employee;
	}
	public void setEmployee(Empleado employee) {
		this.employee = employee;
	}
	public Objeto getProduct() {
		return product;
	}
	public void setProduct(Objeto product) {
		this.product = product;
	}



}
