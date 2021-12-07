package co.edu.uniquindio.gestionPrestamos.model;

import java.util.ArrayList;
import co.edu.uniquindio.gestionPrestamos.exception.CustomerExistException;
import co.edu.uniquindio.gestionPrestamos.exception.EmployeeExistException;
import co.edu.uniquindio.gestionPrestamos.exception.LoanExistException;
import co.edu.uniquindio.gestionPrestamos.exception.ProductExistException;

/**
 * Representa la clase Empresa
 * @author santi
 */
public class Empresa {

	//Variables de la empresa y ArrayList donde se almacenaras los respectivos datos.
	private String nombre;
	private String nit;
	private ArrayList<Empleado> listaEmpleados = new ArrayList<>();
	private ArrayList<Cliente> listaClientes = new ArrayList<>();
	private ArrayList<Objeto> listaObjetos = new ArrayList<>();
	private ArrayList<Prestamo> listaPrestamos = new ArrayList<>();

	/**
	 * Metodo contructor de la clase Empresa
	 * @param nombre String con el nombre de la empresa
	 * @param nit    String con el nit de la empresa
	 */
	public Empresa(String nombre, String nit) {
		super();
		this.nombre = nombre;
		startData();
	}

	// ----------------------------------GETTERS AND SETTERS---------------------------------------//

	/**
	 * Metodo get del parametro nombre
	 * @return el nombre de la empresa
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Metodo set del parametro nombre
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Metodo get del parametro nit
	 * @return el nit de la empresa
	 */
	public String getNit() {
		return nit;
	}

	/**
	 * Metodo set del parametro nombre
	 * @param nit
	 */
	public void setNit(String nit) {
		this.nit = nit;
	}

	/**
	 * Metodo get del ArryList de los empleados
	 * @return lista de empleados
	 */
	public ArrayList<Empleado> getEmpleado() {
		return listaEmpleados;
	}

	/**
	 * Metodo set para Lista de empleados
	 * @param listaEmpleados
	 */
	public void setEmpleado(ArrayList<Empleado> listaEmpleados) {
		this.listaEmpleados = listaEmpleados;
	}

	/**
	 * Metodo get del ArrayList de los clientes
	 * @return lista de clientes
	 */
	public ArrayList<Cliente> getCliente() {
		return listaClientes;
	}

	/**
	 * Metodo set para Lista de clientes
	 * @param listaClientes
	 */
	public void setCliente(ArrayList<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

	/**
	 * Metodo get del ArrayList de los objetos o productos
	 * @return lista de objetos
	 */
	public ArrayList<Objeto> getObjeto() {
		return listaObjetos;
	}

	/**
	 * Metodo set para Lista de objetos
	 * @param listaObjetos
	 */
	public void setObjeto(ArrayList<Objeto> listaObjetos) {
		this.listaObjetos = listaObjetos;
	}

	/**
	 * Metodo get del ArrayList de los prestamos
	 * @return lista de prestamos
	 */
	public ArrayList<Prestamo> getPrestamo() {
		return listaPrestamos;
	}

	/**
	 * Metodo set para Lista de prestamos
	 * @param listaPrestamos
	 */
	public void setPrestamo(ArrayList<Prestamo> listaPrestamos) {
		this.listaPrestamos = listaPrestamos;
	}

	@Override
	public String toString() {
		return "Empresa [nombre=" + nombre + ", nit=" + nit + ", listaEmpleados=" + listaEmpleados + ", listaClientes="
				+ listaClientes + ", listaObjetos=" + listaObjetos + ", prestamo=" + listaPrestamos + "]";
	}

	/**
	 * Metodo para cargar datos de prueba
	 */
	private void startData() {

		Cliente cliente1 = new Cliente("102598", "Irelia", "756990", "3135874578", "Cll 13", "Jonia", "No aplica",
				"Jonia", "irelia@gmail.com", "No aplica", "Femenino");
		getCliente().add(cliente1);

		Cliente cliente2 = new Cliente("1874", "Anna", "756888", "3215478524", "Cll 167", "Armenia", "Quindio",
				"Colombia", "Anna@gmail.com", "Estudiante", "Masculino");
		getCliente().add(cliente2);

		Cliente cliente3 = new Cliente("187444", "Blanca", "7568288", "3215478524", "Cll 167", "Armenia", "Quindio",
				"Colombia", "Anna@gmail.com", "Estudiante", "Masculino");
		getCliente().add(cliente3);

		Objeto objeto1 = new Objeto("258749", "100 años de soledad", "Negro", "2.5 kilogramos", "20000", "Disponible",
				"Libro", "Libro negro escrito por Gabriel", 0, 1);
		getObjeto().add(objeto1);

		Objeto objeto2 = new Objeto("1234", "Martillo", "Negro", "1.5 kg", "25000", "Dispinible", "Herramienta",
				"Martillo punta de acero", 19, 1);
		getObjeto().add(objeto2);
		
		/**
		Objeto objeto3 = new Objeto("12343", "Martillo", "Negro", "1.5 kg", "25000", "Dispinible", "Herramienta",
				"Martillo punta de acero", 19, 1);
		getObjeto().add(objeto3);*/

		Empleado empleado1 = new Empleado("1684", "Luis", "42424", "3254589875", "Crr 21", "Armenia", "Quindio",
				"Colombia", "Luis@gmail.com", "Empleado", "5 años");
		getEmpleado().add(empleado1);

		Empleado empleado2 = new Empleado("10100", "Marcela", "767321", "3234327001", "Crr 11a", "La tebaida",
				"Quindio", "Colombia", "Marcela@gmail.com", "Jefe de inventario", "0 años");
		getEmpleado().add(empleado2);

		/**Prestamo prestamo1 = new Prestamo("1258", "20000", "6/12/2021", "10/12/2021", "Falta por entregar", cliente1, empleado1,
				objeto1, 2, 5);
		getPrestamo().add(prestamo1);

		Prestamo prestamo2 = new Prestamo("1234", "50000", "14/12/2021", "18/12/2021", "Entregado", cliente2, empleado1,
				objeto2, 2, 6);
		getPrestamo().add(prestamo2);*/

	}

	/**
	 * Metodo para verificar el documento de un cliente 
	 * @param documentoCliente String con el documento del cliente
	 * @return true en caso de encontrarlo, false en caso contrario.
	 */
	public boolean verificarIdentificacionCliente(String documentoCliente) {
		Cliente clienteAux = null;
		for (int i = 0; i < listaClientes.size(); i++) {
			clienteAux = listaClientes.get(i);
			if (clienteAux.getDocumento().equals(documentoCliente)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Metodo para verificar el codigo de un objeto o producto
	 * @param codigoProducto String con el codigo del objeto
	 * @return true en caso de encontrarlo, false en caso contrario.
	 */
	public boolean verificarCodigoProducto(String codigoProducto) {
		Objeto objetoAux = null;
		for (int i = 0; i < listaObjetos.size(); i++) {
			objetoAux = listaObjetos.get(i);
			if (objetoAux.getCodigo().equals(codigoProducto)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Metodo para verificar la identificacion de un empleado
	 * @param identificacionEmpleado String con la identificacion del empelado
	 * @return true en caso de encontrarlo, false en caso contrario.
	 */
	public boolean verificarIdentificacionEmpleado(String identificacionEmpleado) {
		Empleado empleadoAux = null;
		for (int i = 0; i < listaEmpleados.size(); i++) {
			empleadoAux = listaEmpleados.get(i);
			if (empleadoAux.getDocumento().equals(identificacionEmpleado)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Metodo para verificar el codigo de un prestamo
	 * @param prestamoCodigo String con el codigo del prestamo
	 * @return true en caso de encontrarlo, false en caso contrario.
	 */
	public boolean verificarCodigoPrestamo(String prestamoCodigo) {
		Prestamo loanAux = null;
		for (int i = 0; i < listaPrestamos.size(); i++) {
			loanAux = listaPrestamos.get(i);
			if (loanAux.getCodigo().equals(prestamoCodigo)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Metodo para crear y registrar un cliente
	 * @param documento Representa el documento del cliente
	 * @param nombre Representa el nombre del cliente
	 * @param telefono Representa el telefono del cliente
	 * @param celular Representa el celular del cliente
	 * @param direccion Representa la direccion del cliente
	 * @param ciudadResidencia Representa ciudad del cliente
	 * @param departamento Representa el departamento del cliente
	 * @param pais Representa el pais del cliente
	 * @param mail Representa el email del cliente
	 * @param profesion Representa la profesion del cliente
	 * @param genero Representa el genero del cliente
	 * @return Un cliente creado.
	 */
	public Cliente registerCliente(String documento, String nombre, String telefono,
			String celular, String direccion, String ciudadResidencia,
			String departamento,String pais, String mail, String profesion,
			String genero) {

		
		Cliente client = new Cliente(documento, nombre, telefono, celular,
				direccion, ciudadResidencia, departamento, pais, mail, profesion,
				genero);

		client.setNombre(nombre);
		client.setTelefono(telefono);
		client.setDocumento(documento);
		client.setDireccion(direccion);
		client.setCelular(celular);
		client.setCiudadResidencia(ciudadResidencia);
		client.setDepartamento(departamento);
		client.setPais(pais);
		client.setMail(mail);
		client.setProfesion(profesion);
		client.setGenero(genero);
		listaClientes.add(client);

		return client;
	}

	/**
	 * Metodo para crear y registrar un producto o objeto
	 * @param codigo Este parametro representa el codigo del objeto
	 * @param nombre Este parametro representa el nombre del objeto
	 * @param color Este parametro representa el color del objeto
	 * @param peso Este parametro representa el peso del objeto
	 * @param precioAlquiler Este parametro representa el precio del objeto
	 * @param estadoObjeto Este parametro representa el estado del obeto
	 * @param tipo Este parametro representa el tipo de objeto
	 * @param descripcion Este parametro representa una descripcion del objeto
	 * @param unidadesDisponibles Este parametro representa las unidades disponibles del objeto
	 * @param unidadesPrestadas Este parametro representa las unidades prestadas del objeto
	 * @return Un objeto creado.
	 */
	public Objeto registerObjeto(String codigo, String nombre, String color,
			String peso, String precioAlquiler, String estadoObjeto, String tipo,
			String descripcion, int unidadesDisponibles, int unidadesPrestadas) {
		
		Objeto producto = new Objeto(codigo, nombre, color, peso, precioAlquiler,
				estadoObjeto, tipo, descripcion,unidadesDisponibles, unidadesPrestadas);
		
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
		listaObjetos.add(producto);

		return producto;
	}

	/**
	 * Metodo para crear y registrar un empleado
	 * @param documento Este parametro representa el documento del empleado
	 * @param nombre Este parametro representa el nombre del empleado
	 * @param telefono Este parametro representa el telefono del empleado
	 * @param celular Este parametro representa el celular del empleado
	 * @param direccion Este parametro representa la dirrecion del empleado
	 * @param ciudadResidencia Este parametro representa la ciudad del empleado
	 * @param departamento Este parametro representa el departamento del empleado
	 * @param pais Este parametro representa el pais del empleado
	 * @param mail Este parametro representa el email del empleado
	 * @param tipoEmpleado Este parametro representa el tipo de empleado
	 * @param aniosExperiencia Este parametro representa los anios de xp del empleado
	 * @return Un empleado creado.
	 */
	public Empleado registerEmpleado(String documento, String nombre, String telefono,
			String celular, String direccion, String ciudadResidencia,
			String departamento, String pais, String mail, String tipoEmpleado,
			String aniosExperiencia) {

		Empleado employee = new Empleado(documento, nombre, telefono, celular,
				direccion, ciudadResidencia, departamento, pais, mail,
				tipoEmpleado, aniosExperiencia);
		
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

	/**
	 * Metodo para crear y registar un prestamo
	 * @param prestamoCodigo Este parametro representa el codigo del prestamos
	 * @param estadoPrestamo Este parametro representa el estado del prestamo
	 * @param valorPrestamo Este parametro representa el valor del prestamo
	 * @param fechaPrestamo Este parametro representa la fecha que se hizo el prestamo
	 * @param fechaEntregaPrestamo Este parametro representa la fecha de entrega del prestamo
	 * @param clienteEncontrado Este parametro representa el cliente que hizo el prestamo
	 * @param empleadoEncontrado Este parametro representa el empleado que hizo el prestamo
	 * @param productoEncontrado Este parametro representa el producto o objeto, que fue prestado
	 * @param diasTranscurridos Este parametro representa los dias transcurridos
	 * @param diasSolicitados Este parametro representa los dias solicitados
	 * @return Un prestamo creado.
	 */
	public Prestamo registerPrestamo(String prestamoCodigo, String estadoPrestamo,
			String valorPrestamo, String fechaPrestamo,
			String fechaEntregaPrestamo, Cliente clienteEncontrado,
			Empleado empleadoEncontrado, Objeto productoEncontrado,
			int diasTranscurridos, int diasSolicitados) {

		Prestamo loan = new Prestamo(prestamoCodigo, valorPrestamo, fechaPrestamo,
				fechaEntregaPrestamo, estadoPrestamo, clienteEncontrado,
				empleadoEncontrado, productoEncontrado, diasTranscurridos,
				diasSolicitados);
		
		loan.setCodigo(prestamoCodigo);
		loan.setValor(valorPrestamo);
		loan.setFechaPrestamo(fechaPrestamo);
		loan.setFechaEntrega(fechaEntregaPrestamo);
		loan.setEstadoPrestamo(estadoPrestamo);
		loan.setCliente(clienteEncontrado);
		loan.setEmpleado(empleadoEncontrado);
		loan.setObjeto(productoEncontrado);
		loan.setDiasTranscurridos(diasTranscurridos);
		loan.setDiasSolicitados(diasSolicitados);
		listaPrestamos.add(loan);

		return loan;
	}

	/**
	 * Metodo para actualizar un cliente
	 * @param documentoAntiguo Representa el documento antiguo del cliente
	 * @param documento Representa el documento del cliente
	 * @param nombre Representa el nombre del cliente
	 * @param telefono Representa el telefono del cliente
	 * @param celular Representa el celular del cliente
	 * @param direccion Representa la direccion del cliente
	 * @param ciudadResidencia Representa ciudad del cliente
	 * @param departamento Representa el departamento del cliente
	 * @param pais Representa el pais del cliente
	 * @param mail Representa el email del cliente
	 * @param profesion Representa la profesion del cliente
	 * @param genero Representa el genero del cliente
	 * @throws CustomerExistException en caso en que el cliente no exista esta 
	 * Exception saltara.
	 */
	public void actualizarCliente(String documentoAntiguo, String documento, String nombre, String telefono,
			String celular, String direccion, String ciudadResidencia, String departamento, String pais, String mail,
			String profesion, String genero) throws CustomerExistException {

		Cliente customer = obtenerCliente(documentoAntiguo);

		if (customer != null) {
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
		} else {
			throw new CustomerExistException("No existe el cliente");
		}

	}

	/**
	 * Metodo para actualizar un objeto
	 * @param codigoAnterior Este parametro representa el codigo anterior del objeto
	 * @param codigo Este parametro representa el codigo del objeto
	 * @param nombre Este parametro representa el nombre del objeto
	 * @param color Este parametro representa el color del objeto
	 * @param peso Este parametro representa el peso del objeto
	 * @param precioAlquiler Este parametro representa el precio del objeto
	 * @param estadoObjeto Este parametro representa el estado del obeto
	 * @param tipo Este parametro representa el tipo de objeto
	 * @param descripcion Este parametro representa una descripcion del objeto
	 * @param unidadesDisponibles Este parametro representa las unidades disponibles del objeto
	 * @param unidadesPrestadas Este parametro representa las unidades prestadas del objeto
	 * @throws ProductExistException en caso de que el objeto no exista esta
	 * Exception saltara.
	 */
	public void actualizarObjeto(String codigoAnterior, String codigo, String nombre, String color, String peso,
			String precioAlquiler, String estadoObjeto, String tipo, String descripcion, int unidadesDisponibles,
			int unidadesPrestadas) throws ProductExistException {

		Objeto producto = obtenerObjeto(codigoAnterior);
		if (producto != null) {
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
		} else {
			throw new ProductExistException("No existe el producto.");
		}

	}

	/**
	 * Metodo para actualizar un empleado
	 * @param documentoAnterior Este parametro representa del documento anterios del empleado
	 * @param documento Este parametro representa el documento del empleado
	 * @param nombre Este parametro representa el nombre del empleado
	 * @param telefono Este parametro representa el telefono del empleado
	 * @param celular Este parametro representa el celular del empleado
	 * @param direccion Este parametro representa la dirrecion del empleado
	 * @param ciudadResidencia Este parametro representa la ciudad del empleado
	 * @param departamento Este parametro representa el departamento del empleado
	 * @param pais Este parametro representa el pais del empleado
	 * @param mail Este parametro representa el email del empleado
	 * @param tipoEmpleado Este parametro representa el tipo de empleado
	 * @param aniosExperiencia Este parametro representa los anios de xp del empleado
	 * @throws EmployeeExistException en caso de que el empleado no exista esta
	 * Exception saltara.
	 */
	public void actualizarEmpleado(String documentoAnterior, String documento, String nombre, String telefono,
			String celular, String direccion, String ciudadResidencia, String departamento, String pais, String mail,
			String tipoEmpleado, String aniosExperiencia) throws EmployeeExistException {

		Empleado empleado = obtenerEmpleado(documentoAnterior);
		if (empleado != null) {
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
		} else {
			throw new EmployeeExistException("El empleado no existe");
		}

	}

	/**
	 * Metodo para actualizar un prestamo
	 * @param codigoAnterior Este dato representa el codigo anterior del prestamo
	 * @param codigo Este dato representa el codigo del prestamo
	 * @param valor Este dato representa el valor del prestamo
	 * @param fechaPrestamo Este dato representa la fecha del prestamo
	 * @param fechaEntrega Este dato representa la fecha de entrega del prestamo
	 * @param estadoPrestamo Este dato representa el estado del prestamo
	 * @param cliente Este dato representa el cliente que realizo el prestamo
	 * @param empleado Este dato representa el empleado que realizo el prestamo
	 * @param objeto Este dato representa el objeto que fue prestado
	 * @param diasTranscurridos Este dato representa los dias transcurridos desde el prestamo
	 * @param diasSolicitados Este dato representa los dias solicitados 
	 * @throws LoanExistException en caso de que el prestamo no exista esta
	 * Exception saltara.
	 */
	public void actualizarPrestamo(String codigoAnterior, String codigo, String valor,
			String fechaPrestamo, String fechaEntrega, String estadoPrestamo,
			Cliente cliente, Empleado empleado, Objeto objeto, int diasTranscurridos,
			int diasSolicitados) throws LoanExistException {

		Prestamo prestamo = obtenerPrestamo(codigoAnterior);
		if (prestamo != null) {
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

	/**
	 * Metodo para obtener un cliente por su identificacion
	 * @param identificacionCliente Representa la identificacion del cliente
	 * @return El cliente encontrado o Null en caso de no ser encontrado
	 */
	public Cliente obtenerCliente(String identificacionCliente) {

		for (int i = 0; i < listaClientes.size(); i++) {
			if (listaClientes.get(i).getDocumento().equals(identificacionCliente)) {
				return listaClientes.get(i);
			}

		}
		return null;
	}

	/**
	 * Metodo para obtener un objeto por su codigo
	 * @param productCode Represnta el codigo del objeto
	 * @return El objeto encontrado o Null en caso de no ser encontrado
	 */
	public Objeto obtenerObjeto(String codigoObjeto) {

		for (Objeto producto : listaObjetos) {
			if (producto.getCodigo().equals(codigoObjeto)) {
				return producto;
			}
		}
		return null;
	}

	/**
	 * Metodo para obtener un empleado por su identificacion
	 * @param identificacionEmpleado Representa la identificacion del empleado
	 * @return El empleado encontrado o Null en caso de no ser encontrado
	 */
	public Empleado obtenerEmpleado(String identificacionEmpleado) {

		for (Empleado empleado : listaEmpleados) {
			if (empleado.getDocumento().equals(identificacionEmpleado)) {
				return empleado;
			}
		}
		return null;
	}

	/**
	 * Metodo para obtener un prestamo por su codigo
	 * @param codigoPrestamo Representa el codigo del prestamo
	 * @return El prestamo encontrado o Null en caso de no ser encontrado
	 */
	public Prestamo obtenerPrestamo(String codigoPrestamo) {
		for (Prestamo prestamo : listaPrestamos) {
			if (prestamo.getCodigo().equals(codigoPrestamo)) {
				return prestamo;
			}
		}
		return null;
	}

	/**
	 * Metodo para eliminar un cliente en caso de ser encontrada
	 * su posicion por la variable i en caso contrario no lo hara pero
	 *  seguira retornando la i.
	 * @param documentoCliente Representa el documento del cliente
	 * @return i Entero que representa la posicion del cliente en la lista de clientes.
	 */
	public int eliminarCliente(String documentoCliente) {
		Cliente cliente = obtenerCliente(documentoCliente);
		int i = buscarPosicionCliente(cliente);

		if (i != -1) {
			listaClientes.remove(i);
		}

		return i;
	}

	/**
	 * Metodo para buscar la posicion del cliente, en la lista de clientes
	 * @param cliente Representa un objeto de tipo Cliente
	 * @return la posicion del cliente i o -1 en caso de no encontrarlo.
	 */
	private int buscarPosicionCliente(Cliente cliente) {

		for (int i = 0; i < listaClientes.size(); i++) {
			if (listaClientes.get(i).equals(cliente)) {
				return i;
			}

		}

		return -1;
	}

	/**
	 * Metodo para eliminar un empleado en caso de ser encontrada
	 * su posicion por la variable i en caso contrario no lo hara pero
	 * seguira retornando la i.
	 * @param documentoEmpleado Representa el documento del empleado
	 * @return i Entero que representa la posicion del empleado en la lista de empleados.
	 */
	public int eliminarEmpleado(String documentoEmpleado) {
		Empleado empleado = obtenerEmpleado(documentoEmpleado);
		int i = buscarPosicionEmpleado(empleado);

		if (i != -1) {
			listaEmpleados.remove(i);
		}

		return i;
	}

	/**
	 * Metodo para buscar la posicion del empleado, en la lista de empelados
	 * @param empleado Representa un objeto de tipo Empleado
	 * @return la posicion del empleado i o -1 en caso de no encontrarlo.
	 */
	private int buscarPosicionEmpleado(Empleado empleado) {

		for (int i = 0; i < listaEmpleados.size(); i++) {
			if (listaEmpleados.get(i).equals(empleado)) {
				return i;
			}
		}

		return -1;
	}

	/**
	 * Metodo para eliminar un objeto en caso de ser encontrada
	 * su posicion por la variable i en caso contrario no lo hara pero
	 * seguira retornando la i.
	 * @param codigo Representa el codigo del objeto
	 * @return i Entero que representa la posicion del objeto en la lista de objetos.
	 */
	public int eliminarObjeto(String codigo) {
		Objeto objeto = obtenerObjeto(codigo);
		int i = buscarPosicionObjeto(objeto);

		if (i != -1) {
			listaObjetos.remove(i);
		}

		return i;
	}

	/**
	 * Metodo para buscar la posicion del objeto, en la lista de objetos
	 * @param objeto Representa un objeto de tipo Objeto
	 * @return la posicion del objeto i o -1 en caso de no encontrarlo.
	 */
	private int buscarPosicionObjeto(Objeto objeto) {

		for (int i = 0; i < listaObjetos.size(); i++) {
			if (listaObjetos.get(i).equals(objeto)) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Metodo para eliminar un prestamo en caso de ser encontrada
	 * su posicion por la variable i en caso contrario no lo hara pero
	 * seguira retornando la i.
	 * @param codigoPrestamo Representa el codigo del prestamo
	 * @return i Entero que representa la posicion del prestamo en la lista de prestamos.
	 */
	public int eliminarPrestamo(String codigoPrestamo) {
		Prestamo prestamo = obtenerPrestamo(codigoPrestamo);
		int i = buscarPosicionPrestamo(prestamo);

		if (i != -1) {
			listaPrestamos.remove(i);
		}

		return i;
	}

	/**
	 * Metodo para buscar la posicion del prestamo, en la lista de prestamos
	 * @param prestamo Representa un objeto de tipo Prestamo
	 * @return la posicion del prestamo i o -1 en caso de no encontrarlo.
	 */
	private int buscarPosicionPrestamo(Prestamo prestamo) {

		for (int i = 0; i < listaPrestamos.size(); i++) {
			if (listaPrestamos.get(i).equals(prestamo)) {
				return i;
			}
		}

		return 0;
	}

	/**
	 * Metodo para verificar que el cliente haya o no realizado prestamos, en 
	 * caso de que no, este cliente podra ser eliminado.
	 * @param cliente un objeto de tipo Cliente
	 * @return true en caso de haber realizado prestamos, false en el caso contrario.
	 */
	public boolean buscarPrestamoConCliente(Cliente cliente) {
		for (int i = 0; i < listaPrestamos.size(); i++) {
			if (listaPrestamos.get(i).getCliente().equals(cliente)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Metodo para verificar que el empleado haya o no realizado prestamos, en 
	 * caso de que no, este empleado podra ser eliminado.
	 * @param empleado un objeto de tipo Empleado
	 * @return true en caso de haber ralizado prestamos, false en caso contrario.
	 */
	public boolean buscarPrestamoConEmpleado(Empleado empleado) {
		for (int i = 0; i < listaPrestamos.size(); i++) {
			if (listaPrestamos.get(i).getEmpleado().equals(empleado)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Metodo para verificar que el objeto este o no en algun prestamos, en
	 * caso de que no, este objeto podra ser eliminado.
	 * @param objeto un objeto de tipo Objeto
	 * @return true en caso de estar en prestamos, false en caso contrario.
	 */
	public boolean buscarPrestamoConObjeto(Objeto objeto) {
		for (int i = 0; i < listaPrestamos.size(); i++) {
			if (listaPrestamos.get(i).getObjeto().equals(objeto)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Metodo para consultar un cliente
	 * @param documento
	 * @return
	 */
	public Cliente consultarCliente(String documento) {
		for (int i = 0; i < listaClientes.size(); i++) {
			if (listaClientes.get(i).getDocumento().equals(documento)) {
				return listaClientes.get(i);
			}
		}
		return null;
	}
	
	/**
	 * Metodo para consultar un empleado
	 * @param documento
	 * @return
	 */
	public Empleado consultarEmpleado(String documento) {
		for (int i = 0; i < listaEmpleados.size(); i++) {
			if (listaEmpleados.get(i).getDocumento().equals(documento)) {
				return listaEmpleados.get(i);
			}
		}
		return null;
	}
	
	public String consultarObjeto(String datos) {
		
		String datos1 ="";
	
		for (int i = 0; i < listaObjetos.size(); i++) {
			if (listaObjetos.get(i).getCodigo().equals(datos) ||
					listaObjetos.get(i).getNombre().equals(datos)) {
				
				datos1="Nombre: " + listaObjetos.get(i).getNombre() + "\nCodigo: "
				+ listaObjetos.get(i).getCodigo() + ".";
				return datos1;
			}
		}
		return null;
	}
	
}
