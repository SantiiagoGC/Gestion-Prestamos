package co.edu.uniquindio.gestionPrestamos.model;
/*
 * Clase empresa
 * @author Mauricio y Johan
 */
import java.util.ArrayList;

import co.edu.uniquindio.gestionPrestamos.Aplicacion;
import co.edu.uniquindio.gestionPrestamos.exception.CustomerExistException;
import co.edu.uniquindio.gestionPrestamos.exception.EmployeeExistException;
import co.edu.uniquindio.gestionPrestamos.exception.LoanExistException;
import co.edu.uniquindio.gestionPrestamos.exception.ProductExistException;

/**
 * Clase Empresa con los respectivos metodos
 * @author santi
 *
 */
public class Empresa {

    private String nombre;
    private String nit;
    private ArrayList<Empleado> listaEmpleados = new ArrayList<>();
    private ArrayList<Cliente> listaClientes = new ArrayList<>();
    private ArrayList<Objeto> listaObjetos = new ArrayList<>();
    private ArrayList<Prestamo> listaPrestamos = new ArrayList<>();
   
    /**
     * Constructor Empresa
     * @param nombre
     */
    public Empresa(String nombre, String nit) {
        super();
        this.nombre = nombre;
        startData();
    }
    
    //----------------------------------GETTERS AND SETTERS-------------------------------------------
   public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public ArrayList<Empleado> getEmpleado() {
        return listaEmpleados;
    }
    
    public void setEmpleado(ArrayList<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }
    
    public ArrayList<Cliente> getCliente() {
        return listaClientes;
    }
    
    public void setCliente(ArrayList<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }
    
    public ArrayList<Objeto> getObjeto() {
        return listaObjetos;
    }
    
    public void setObjeto(ArrayList<Objeto> listaObjetos) {
        this.listaObjetos = listaObjetos;
    }
    
    public ArrayList<Prestamo> getPrestamo() {
        return listaPrestamos;
    }
    
    public void setPrestamo(ArrayList<Prestamo> listaPrestamos) {
        this.listaPrestamos = listaPrestamos;
    }
    
    @Override
	public String toString() {
		return "Empresa [nombre=" + nombre + ", nit=" + nit + ", listaEmpleados=" + listaEmpleados + ", listaClientes=" + listaClientes
				+ ", listaObjetos=" + listaObjetos + ", prestamo=" + listaPrestamos + "]";
	}

	private void startData() {
    	
		Cliente cliente1 = new Cliente("102598", "Irelia", "756990", "3135874578", "Cll 13", "Jonia", "No aplica", "Jonia", "irelia@gmail.com",  "No aplica", "Femenino");
		getCliente().add(cliente1);

		Cliente cliente2 = new Cliente("1874", "Anna", "756888", "3215478524", "Cll 167", "Armenia", "Quindio", "Colombia", "Anna@gmail.com",  "Estudiante", "Masculino");
		getCliente().add(cliente2);
		
		Objeto objeto1 = new Objeto("258749", "100 años de soledad", "Negro", "2.5 kilogramos", "20000", "Disponible",  "Libro", "Libro negro escrito por Gabriel", 0,20);
		getObjeto().add(objeto1);
		
		Objeto objeto2 = new Objeto("1234", "Martillo", "Negro", "1.5 kg", "25000", "Dispinible", "Herramienta", "Martillo punta de acero", 20, 0);
		getObjeto().add(objeto2);

		Empleado empleado1 = new Empleado("1684", "Luis", "42424", "3254589875", "Crr 21", "Armenia", "Quindio", "Colombia", "Luis@gmail.com",  "Empleado","5 años");
		getEmpleado().add(empleado1);
		
		Empleado empleado2 = new Empleado("10100", "Marcela", "767321", "3234327001", "Crr 11a", "La tebaida", "Quindio", "Colombia", "Marcela@gmail.com",  "Jefe de inventario","0 años");
		getEmpleado().add(empleado2);
		
		Prestamo prestamo1 = new Prestamo("1258", "20000", "12", "18", "Falta por entregar", cliente1, empleado1, objeto1, 6, 3);
		getPrestamo().add(prestamo1);
		
		Prestamo prestamo2 = new Prestamo("1234", "50000", "14","22", "Falta por entregar", cliente2, empleado1, objeto1, 6, 2);
		getPrestamo().add(prestamo2);

	}
    //Verifica el documento no este repetido.
	public boolean verfyIdentificationCustomer(String documentoCustomer) {
		Cliente clientAux = null;
		for(int  i = 0; i < listaClientes.size(); i++) {
			clientAux = listaClientes.get(i);
			if (clientAux.getDocumento().equals(documentoCustomer)) {
				return true;
			}
		}
		return false;
	}
	//Verifica el códig del cliente
	public boolean verifyCodeProduct(String productCode) {
		Objeto objetoAux = null;
		for(int  i = 0; i < listaObjetos.size(); i++) {
			objetoAux = listaObjetos.get(i);
			if (objetoAux.getCodigo().equals(productCode)) {
				return true;
			}
		}
		return false;
	}
	//Verifica el código del empleado
	public boolean verifyCodeEmployee(String employeeIdentification) {
		Empleado empleadoAux = null;
		for(int  i = 0; i < listaEmpleados.size(); i++) {
			empleadoAux = listaEmpleados.get(i);
			if (empleadoAux.getDocumento().equals(employeeIdentification)) {
				return true;
			}
		}
		return false;
	}
	//Verfica el códgo del prestamo
	public boolean verifyCodeLoan(String loanCode) {
		Prestamo loanAux = null;
		for (int i = 0; i < listaPrestamos.size(); i++) {
			loanAux = listaPrestamos.get(i);
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
	public Cliente registerCliente(String nameCustomer, String telefonoEmpleado, String customerIdentification,
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
		client.setPais(clientCountry);
		client.setMail(emailCustomer);
		client.setProfesion(profesioCustomer);
		client.setGenero(genero);
		listaClientes.add(client);
		
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
	public Objeto registerObjeto(String codigo, String nombre, String color, String peso, String precioAlquiler,
			String estadoObjeto, String tipo, String descripcion, int unidadesDisponibles,
			int unidadesPrestadas) {
		Objeto product = new Objeto(codigo, nombre, color, peso, precioAlquiler, estadoObjeto, tipo, descripcion, unidadesDisponibles, unidadesPrestadas);
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
		listaObjetos.add(product);
		
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
	public Empleado registerEmpleado(String documento, String nombre, String telefono, String celular, String direccion,
            String ciudadResidencia, String departamento, String pais, String mail,
            String tipoEmpleado, String aniosExperiencia) {

		Empleado employee = new Empleado(documento,nombre,
				telefono,celular,direccion,ciudadResidencia,
				departamento, pais, mail, tipoEmpleado, aniosExperiencia);
		employee.setNombre(nombre);
		employee.setTelefono(telefono);
		employee.setDocumento(documento);
		employee.setDireccion(direccion);
		employee.setCelular(celular);
		employee.setCiudadResidencia(ciudadResidencia);
		employee.setDepartamento(departamento);
		employee.setPais(pais);
		employee.setMail(mail);
		employee.setAniosExperiencia(aniosExperiencia);
		employee.setTipoEmpleado(tipoEmpleado);
		listaEmpleados.add(employee);
		
		return employee;
	}
	//Registra el prestamo
	public Prestamo registerPrestamo(String loanCode, String loanCondition, String loanValue, String loanDate,
			String expirationDate, Cliente foundCustomer, Empleado foundEmployee, Objeto foundProduct, int diasSolicitados, int diasTranscurridos) {

		Prestamo loan = new Prestamo(loanCode, loanValue, loanDate, expirationDate, loanCondition, foundCustomer, foundEmployee, foundProduct, diasSolicitados, diasTranscurridos);
		loan.setCodigo(loanCode);
		loan.setValor(loanValue);
		loan.setFechaPrestamo(loanDate);
		loan.setFechaEntrega(expirationDate);
		loan.setEstadoPrestamo(loanCondition);
		loan.setCliente(foundCustomer);
		loan.setEmpleado(foundEmployee);
		loan.setObjeto(foundProduct);
		loan.setDiasSolicitados(diasSolicitados);
		loan.setDiasTranscurridos(diasTranscurridos);
		listaPrestamos.add(loan);
		
		return loan;
	}
	//Actuliza la info
	public void udpdateCustomer(String documentoAntiguo, String documento, String nombre, String telefono, String celular, String direccion,
			String ciudadResidencia, String departamento, String pais, String mail,
			String profesion, String genero) throws CustomerExistException {

		Cliente customer = obtenerCliente(documentoAntiguo);
		
		if(customer != null){
			customer.setNombre(nombre);
			customer.setTelefono(telefono);
			customer.setDocumento(documento);
			customer.setDireccion(direccion);
			customer.setCelular(celular);
			customer.setCiudadResidencia(ciudadResidencia);
			customer.setDepartamento(departamento);
			customer.setPais(pais);
			customer.setMail(mail);
			customer.setProfesion(profesion);	
			customer.setGenero(genero);
		} else{
			throw new CustomerExistException("No existe el cliente");
		}

	}
	public void actualizarObjeto(String codigoAnterior, String codigo, String nombre, String color, String peso, String precioAlquiler,
			String estadoObjeto, String tipo, String descripcion, int unidadesDisponibles,
			int unidadesPrestadas) throws ProductExistException {

		Objeto producto = obtenerObjeto(codigoAnterior);
		if(producto != null){
			producto.setNombre(nombre);
			producto.setCodigo(codigo);
			producto.setPeso(peso);
			producto.setEstadoObjeto(estadoObjeto);
			producto.setTipo(tipo);
			producto.setPrecioAlquiler(precioAlquiler);
			producto.setDescripcion(descripcion);
			producto.setColor(color);
			producto.setUnidadesDisponibles(unidadesDisponibles);
			producto.setUnidadesPrestadas(unidadesPrestadas);
		} else{
			throw new ProductExistException("No existe el producto.");
		}

	}
	//Actualiza al empleado
	public void updateEmployee(String documentoAnterior, String documento, String nombre, String telefono, String celular, String direccion,
            String ciudadResidencia, String departamento, String pais, String mail,
            String tipoEmpleado, String aniosExperiencia) throws EmployeeExistException {

		Empleado empleado = obtenerEmpleado(documentoAnterior);
		if(empleado != null){
			empleado.setNombre(nombre);
			empleado.setTelefono(telefono);
			empleado.setDocumento(documento);
			empleado.setDireccion(direccion);
			empleado.setCelular(celular);
			empleado.setCiudadResidencia(ciudadResidencia);
			empleado.setDepartamento(departamento);
			empleado.setPais(pais);
			empleado.setMail(mail);
			empleado.setAniosExperiencia(aniosExperiencia);
			empleado.setTipoEmpleado(tipoEmpleado);
		} else{
			throw new EmployeeExistException("El empleado no existe");
		}

	}
	
	public void actualizarPrestamo(String codigoAnterior, String codigo, String valor, String fechaPrestamo, String fechaEntrega, String estadoPrestamo,
			Cliente cliente, Empleado empleado, Objeto objeto, int diasTranscurridos, int diasSolicitados) throws LoanExistException {
		
		Prestamo prestamo = obtenerPrestamo(codigoAnterior);
		if(prestamo != null) {
			prestamo.setCodigo(codigo);
			prestamo.setValor(valor);
			prestamo.setFechaPrestamo(fechaPrestamo);
			prestamo.setFechaEntrega(fechaEntrega);
			prestamo.setEstadoPrestamo(estadoPrestamo);
			prestamo.setCliente(cliente);
			prestamo.setEmpleado(empleado);
			prestamo.setObjeto(objeto);
			prestamo.setDiasTranscurridos(diasTranscurridos);
			prestamo.setDiasSolicitados(diasSolicitados);
		} else {
			throw new LoanExistException("El prestamo no existe");
		}
		
	}
	
	public Cliente obtenerCliente(String identificacionCliente) {
		
		for (int i = 0; i < listaClientes.size(); i++) {
			if(listaClientes.get(i).getDocumento().equals(identificacionCliente)) {
				return listaClientes.get(i);
			}
			
		}
		return null;
	}
	
	public Objeto obtenerObjeto(String productCode) {

		for (Objeto product : listaObjetos) {
			if(product.getCodigo().equals(productCode)){
				return product;
			}
		}
		return null;
	}
	
	//Obtiene al empleado a tráves de su documento
	public Empleado obtenerEmpleado(String employeeIdentification) {

		for (Empleado employee : listaEmpleados) {
			if(employee.getDocumento().equals(employeeIdentification)){
				return employee;
			}
		}
		return null;
	}
	
	public Prestamo obtenerPrestamo(String codigoPrestamo) {
		for (Prestamo prestamo : listaPrestamos) {
			if(prestamo.getCodigo().equals(codigoPrestamo)) {
				return prestamo;
			}
		}
		return null;
	}
	
	public int eliminarCliente(String documentoCliente) {
		Cliente cliente = obtenerCliente(documentoCliente);
		int i = buscarPosicionCliente(cliente);
		
		if(i != -1) {
			listaClientes.remove(i);
		}
		
		return i;
	}
	

	private int buscarPosicionCliente(Cliente cliente) {
		
		for (int i = 0; i < listaClientes.size(); i++) {
			if(listaClientes.get(i).equals(cliente)) {
				return i;
			}
			
		}
		
		return -1;
	}
	
	public int eliminarEmpleado(String documentoEmpleado) {
		Empleado empleado = obtenerEmpleado(documentoEmpleado);
		int i = buscarPosicionEmpleado(empleado);
		
		if(i != -1) {
			listaEmpleados.remove(i);
		}
		
		return i;
	}

	private int buscarPosicionEmpleado(Empleado empleado) {
		
		for (int i = 0; i < listaEmpleados.size(); i++) {
			if(listaEmpleados.get(i).equals(empleado)) {
				return i;
			}
		}
		
		return -1;
	}
	
	public int eliminarObjeto(String codigo) {
		Objeto objeto = obtenerObjeto(codigo);
		int i= buscarPosicionObjeto(objeto);
		
		if(i != -1) {
			listaObjetos.remove(i);
		}
		
		return i;
	}

	private int buscarPosicionObjeto(Objeto objeto) {
		
		for(int i = 0; i < listaObjetos.size(); i++) {
			if(listaObjetos.get(i).equals(objeto)) {
				return i;
			}
		}
		return -1;
	}
	
	public int eliminarPrestamo(String codigoPrestamo) {
		Prestamo prestamo = obtenerPrestamo(codigoPrestamo);
		int i = buscarPosicionPrestamo(prestamo);
		
		if(i != -1) {
			listaPrestamos.remove(i);
		}
		
		return i;
	}

	private int buscarPosicionPrestamo(Prestamo prestamo) {
		
		for (int i = 0; i < listaPrestamos.size(); i++) {
			if(listaPrestamos.get(i).equals(prestamo)) {
				return i;
			}
		}
		
		return 0;
	}


}
