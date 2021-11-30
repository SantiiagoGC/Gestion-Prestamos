package co.edu.uniquindio.gestionPrestamos.model;
/*
 * Clase empresa
 * @author Mauricio y Johan
 */
import java.util.ArrayList;

import co.edu.uniquindio.gestionPrestamos.Aplicacion;
import co.edu.uniquindio.gestionPrestamos.exception.CustomerExistException;
import co.edu.uniquindio.gestionPrestamos.exception.EmployeeExistException;
import co.edu.uniquindio.gestionPrestamos.exception.ProductExistException;

public class Company {

    private String nombre;
    private ArrayList<Empleado> empleado = new ArrayList<>();
    private ArrayList<Cliente> cliente = new ArrayList<>();
    private ArrayList<Objeto> objeto = new ArrayList<>();
    private ArrayList<Loan> prestamo = new ArrayList<>();
    /*
     * Constructor
     * @param nombre
     */
    public Company(String nombre) {
        super();
        this.nombre = nombre;
        startData();
    }
	//Setters y Getters-------------------------------------------------------------------------------------
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public ArrayList<Empleado> getEmpleado() {
        return empleado;
    }
    public void setEmpleado(ArrayList<Empleado> empleado) {
        this.empleado = empleado;
    }
    public ArrayList<Cliente> getCliente() {
        return cliente;
    }
    public void setCliente(ArrayList<Cliente> cliente) {
        this.cliente = cliente;
    }
    public ArrayList<Objeto> getObjeto() {
        return objeto;
    }
    public void setObjeto(ArrayList<Objeto> objeto) {
        this.objeto = objeto;
    }
    public ArrayList<Loan> getPrestamo() {
        return prestamo;
    }
    public void setPrestamo(ArrayList<Loan> prestamo) {
        this.prestamo = prestamo;
    }
    @Override
    public String toString() {
        return "Empresa [nombre=" + nombre + ", empleado=" + empleado + ", cliente=" + cliente + ", objeto=" + objeto
                + ", prestamo=" + prestamo + "]";
    }
    private void startData() {
		Cliente customer = new Cliente("102598", "Irelia", "756990", "3135874578", "Cll 13", "Jonia", "No aplica", "Jonia", "irelia@gmail.com",  "No aplica", "Trans");
		getCliente().add(customer);

		customer = new Cliente("1874", "Anna", "756888", "3215478524", "Cll 167", "Armenia", "Quindio", "Colombia", "Anna@gmail.com",  "Estudiante", "Femenino");
		getCliente().add(customer);
		
		Objeto product = new Objeto("258749", "100 años de soleda", "Negro", "2.5 kilogramos", "20000", "Disponible",  "Libro", "Libro negro escrito por Gabriel",20,10);
		getObjeto().add(product);
		
		Empleado employee = new Empleado("1684", "Luis", "42424", "3254589875", "Crr 21", "Armenia", "Quindio", "Colombia", "Luis@gmail.com",  TypeEmployee.PRESTADOR,"5 años");
		getEmpleado().add(employee);
		
		Loan loan = new Loan("1258", "20000", "12", "18", ConditionLoan.FALTA_POR_ENTREGAR, customer, employee, product);
		getPrestamo().add(loan);
	}
    //Verifica el documento no este repetido.
	public boolean verfyIdentificationCustomer(String documentoCustomer) {
		Cliente clientAux = null;
		for(int  i = 0; i < cliente.size(); i++) {
			clientAux = cliente.get(i);
			if (clientAux.getDocumento().equals(documentoCustomer)) {
				return true;
			}
		}
		return false;
	}
	//Verifica el códig del cliente
	public boolean verifyCodeProduct(String productCode) {
		Objeto objetoAux = null;
		for(int  i = 0; i < objeto.size(); i++) {
			objetoAux = objeto.get(i);
			if (objetoAux.getCodigo().equals(productCode)) {
				return true;
			}
		}
		return false;
	}
	//Verifica el código del empleado
	public boolean verifyCodeEmployee(String employeeIdentification) {
		Empleado empleadoAux = null;
		for(int  i = 0; i < empleado.size(); i++) {
			empleadoAux = empleado.get(i);
			if (empleadoAux.getDocumento().equals(employeeIdentification)) {
				return true;
			}
		}
		return false;
	}
	//Verfica el códgo del prestamo
	public boolean verifyCodeLoan(String loanCode) {
		Loan loanAux = null;
		for (int i = 0; i < prestamo.size(); i++) {
			loanAux = prestamo.get(i);
			if(loanAux.getCodigo().equals(loanCode)){
				return true;
			}
		}
		return false;
	}

	/**
	 * Registra el producto
	 * @param nameCustomer
	 * @param lastNameCustomer
	 * @param customerIdentification
	 * @param customerAddress
	 * @param cellPhoneClient
	 * @param clientCity
	 * @param customerDepartment
	 * @param clientCountry
	 * @param emailCustomer
	 * @param profesioCustomer
	 * @return
	 */
	public Cliente registerClient(String nameCustomer, String telefonoEmpleado, String customerIdentification,
		String customerAddress, String cellPhoneClient, String clientCity, String customerDepartment,
		String clientCountry, String emailCustomer, String profesioCustomer, String genero) {
		Cliente client = new Cliente(customerIdentification, nameCustomer,
				telefonoEmpleado, cellPhoneClient, customerAddress,
				clientCity, customerDepartment, clientCountry, emailCustomer,
				profesioCustomer, genero);
		client.setNombre(nameCustomer);
		client.setTelefono(telefonoEmpleado);
		client.setDocumento(customerIdentification);
		client.setDireccion(customerAddress);
		client.setCelular(cellPhoneClient);
		client.setCiudadResidencia(clientCity);
		client.setDepartamento(customerDepartment);
		client.setCiudadResidencia(clientCountry);
		client.setMail(emailCustomer);
		client.setProfesion(profesioCustomer);
		client.setGenero(genero);
		return client;
	}
	/**
	 * Regristra el producto
	 * @param nameProduct
	 * @param productCode
	 * @param productWeight
	 * @param conditionProduct
	 * @param productValue
	 * @param productDescription
	 * @param productColor
	 * @param totalValue
	 * @return
	 */
	public Objeto registerProduct(String codigo, String nombre, String color, String peso, String precioAlquiler,
			String estadoObjeto, String tipo, String descripcion, int unidadesDisponibles,
			int unidadesPrestadas) {
		Objeto product = new Objeto(codigo, nombre, color, peso, precioAlquiler, null, tipo, descripcion, unidadesDisponibles, unidadesPrestadas);
		product.setNombre(nombre);
		product.setCodigo(codigo);
		product.setPeso(peso);
		product.setEstadoObjeto(estadoObjeto);
		product.setTipo(tipo);
		product.setPrecioAlquiler(precioAlquiler);
		product.setDescripcion(descripcion);
		product.setColor(color);
		product.setUnidadesDisponibles(unidadesDisponibles);
		product.setUnidadesPrestadas(unidadesPrestadas);
		return product;
	}
	/**
	 * Registra al empleado
	 * @param nameEmployee
	 * @param lastNameEmployee
	 * @param employeeIdentification
	 * @param employeeAddress
	 * @param cellPhoneEmployee
	 * @param employeeCity
	 * @param employeeDepartment
	 * @param employeeCountry
	 * @param emailEmployee
	 * @param employeeType
	 * @return
	 */
	public Empleado registrarEmpleado(String nameEmployee, String telefonoEmpleado, String employeeIdentification,
			String employeeAddress, String cellPhoneEmployee, String employeeCity, String employeeDepartment,
			String employeeCountry, String emailEmployee, String employeeType, String aniosXp) {

		Empleado employee = new Empleado(employeeIdentification,nameEmployee,
				telefonoEmpleado,cellPhoneEmployee,employeeAddress,employeeCity,
				employeeDepartment, employeeCountry, emailEmployee, null, aniosXp);
		employee.setNombre(nameEmployee);
		employee.setTelefono(telefonoEmpleado);
		employee.setDocumento(employeeIdentification);
		employee.setDireccion(employeeAddress);
		employee.setCelular(cellPhoneEmployee);
		employee.setCiudadResidencia(employeeCity);
		employee.setDepartamento(employeeDepartment);
		employee.setPais(employeeCountry);
		employee.setMail(emailEmployee);
		employee.setAniosExperiencia(aniosXp);
		int tipoEmpleado = Integer.parseInt(employeeType);
		if (tipoEmpleado == TypeEmployee.AMINISTRADOR.getTypeEmployee()) {
			employee.setTipoEmpleado(TypeEmployee.AMINISTRADOR);
		}
		if(tipoEmpleado == TypeEmployee.JEFE_DE_INVENTARIO.getTypeEmployee()) {
			employee.setTipoEmpleado(TypeEmployee.JEFE_DE_INVENTARIO);
		}
		if (tipoEmpleado == TypeEmployee.PRESTADOR.getTypeEmployee()) {
			employee.setTipoEmpleado(TypeEmployee.PRESTADOR);
		}
		/*if(employeeType.equalsIgnoreCase("Administrador")){
			employee.setTipoEmpleado(TypeEmployee.AMINISTRADOR);
		} else{
			employee.setTipoEmpleado(TypeEmployee.JEFE_DE_INVENTARIO);
		}*/
		return employee;
	}
	//Registra el prestamo
	public Loan registerLoan(String loanCode, String loanCondition, String loanValue, String loanDate,
			String expirationDate, Cliente foundCustomer, Empleado foundEmployee, Objeto foundProduct) {

		Cliente clienteAux = null;
		Loan loan = new Loan(loanCode, loanValue, loanDate, expirationDate, null, foundCustomer, foundEmployee, foundProduct);
		loan.setCodigo(loanCode);
		loan.setValor(loanValue);
		loan.setFechaPrestamo(loanDate);
		loan.setFechaEntrega(expirationDate);
		int loanCondition2 = Integer.parseInt(loanCondition);
		if (loanCondition2 == ConditionLoan.ENTREGADO.getConditionLoan()) {
			loan.setEstadoPrestamo(ConditionLoan.ENTREGADO);
		}
		if(loanCondition2 == ConditionLoan.FALTA_POR_ENTREGAR.getConditionLoan()) {
			loan.setEstadoPrestamo(ConditionLoan.FALTA_POR_ENTREGAR);
		}
		loan.setCustomer(foundCustomer);
		loan.setEmployee(foundEmployee);
		loan.setProduct(foundProduct);
		return loan;
	}
	//Actuliza la info
	public void udpdateCustomer(String nameCustomer, String telefonoEmpleado, String customerIdentification,
			String customerAddress, String cellPhoneClient, String clientCity, String customerDepartment,
			String clientCountry, String emailCustomer, String profesioCustomer) throws CustomerExistException {

		Cliente customer = obtenerCusotmer(customerIdentification);
		if(customer != null){
			customer.setNombre(nameCustomer);
			customer.setTelefono(telefonoEmpleado);
			customer.setDocumento(customerIdentification);
			customer.setDireccion(customerAddress);
			customer.setCelular(cellPhoneClient);
			customer.setCiudadResidencia(clientCity);
			customer.setDepartamento(customerDepartment);
			//clientCountry
			customer.setPais(clientCountry);
			customer.setMail(emailCustomer);
			customer.setProfesion(profesioCustomer);
		} else{
			throw new CustomerExistException("No existe el cliente");
		}

	}
	public void updateProduct(String codigo, String nombre, String color, String peso, String precioAlquiler,
			String estadoObjeto, String tipo, String descripcion, int unidadesDisponibles,
			int unidadesPrestadas) throws ProductExistException {

		Objeto product = obtenerProduct(codigo);
		if(product != null){
			product.setNombre(nombre);
			product.setCodigo(codigo);
			product.setPeso(peso);
			product.setEstadoObjeto(estadoObjeto);
			product.setTipo(tipo);
			product.setPrecioAlquiler(precioAlquiler);
			product.setDescripcion(descripcion);
			product.setColor(color);
			product.setUnidadesDisponibles(unidadesDisponibles);
			product.setUnidadesPrestadas(unidadesPrestadas);
		} else{
			throw new ProductExistException("No existe el producto.");
		}

	}
	//Actualiza al empleado
	public void updateEmployee(String nameEmployee, String telefonoEmpleado, String employeeIdentification,
			String employeeAddress, String cellPhoneEmployee, String employeeCity, String employeeDepartment,
			String employeeCountry, String emailEmployee, String employeeType) throws EmployeeExistException {

		Empleado employee = obtenerEmployee(employeeIdentification);
		if(employee != null){
			employee.setNombre(nameEmployee);
			employee.setTelefono(telefonoEmpleado);
			employee.setDocumento(employeeIdentification);
			employee.setDireccion(employeeAddress);
			employee.setCelular(cellPhoneEmployee);
			employee.setCiudadResidencia(employeeCity);
			employee.setDepartamento(employeeDepartment);
			employee.setPais(employeeCountry);
			employee.setMail(emailEmployee);
			//employee.setTipoEmpleado(TypeEmployee.PRESTADOR);
			int tipoEmpleado = Integer.parseInt(employeeType);
			if (tipoEmpleado == TypeEmployee.AMINISTRADOR.getTypeEmployee()) {
				employee.setTipoEmpleado(TypeEmployee.AMINISTRADOR);
			}
			if(tipoEmpleado == TypeEmployee.JEFE_DE_INVENTARIO.getTypeEmployee()) {
				employee.setTipoEmpleado(TypeEmployee.JEFE_DE_INVENTARIO);
			}
			if (tipoEmpleado == TypeEmployee.PRESTADOR.getTypeEmployee()) {
				employee.setTipoEmpleado(TypeEmployee.PRESTADOR);
			}
		} else{
			throw new EmployeeExistException("El empleado no existe");
		}

	}
	public Cliente obtenerCusotmer(String customerIdentification) {

		for (Cliente customer : cliente) {
			if(customer.getDocumento().equals(customerIdentification)){
				return customer;
			}
		}
		return null;
	}
	public Objeto obtenerProduct(String productCode) {

		for (Objeto product : objeto) {
			if(product.getCodigo().equals(productCode)){
				return product;
			}
		}
		return null;
	}
	//Obtiene al empleado a tráves de su documento
	public Empleado obtenerEmployee(String employeeIdentification) {

		for (Empleado employee : empleado) {
			if(employee.getDocumento().equals(employeeIdentification)){
				return employee;
			}
		}
		return null;
	}


}
