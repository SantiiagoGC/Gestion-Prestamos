package co.edu.uniquindio.gestionPrestamos;

import java.io.IOException;

import java.util.ArrayList;

import co.edu.uniquindio.gestionPrestamos.controller.LoginController;
import co.edu.uniquindio.gestionPrestamos.exception.CustomerExistException;
import co.edu.uniquindio.gestionPrestamos.exception.EmployeeExistException;
import co.edu.uniquindio.gestionPrestamos.exception.LoanExistException;
import co.edu.uniquindio.gestionPrestamos.exception.ProductExistException;
import co.edu.uniquindio.gestionPrestamos.model.Empresa;
import co.edu.uniquindio.gestionPrestamos.model.Cliente;
import co.edu.uniquindio.gestionPrestamos.model.Empleado;
import co.edu.uniquindio.gestionPrestamos.model.Prestamo;
import co.edu.uniquindio.gestionPrestamos.model.Objeto;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
/**
 * Representa la clase Aplicacion que extiende de Application. (JavaFX).
 * @author santi, nodier, juan.
 *
 */
public class Aplicacion extends Application{
	
	private Empresa empresa = new Empresa("Administracion prestamos.", "0805");
	private Stage primaryStage;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Administracion prestamos.");
		//Aqui llamamos para mostrar lo que hemos cargado dentro el metodo
		showLoginWindow();
	}

	private void showLoginWindow() {
		//Puede que no exista nada entonces lo hacemos con un try catch
		try {
			FXMLLoader loader = new FXMLLoader();
			//Buscar y cagar el archivo FMXL
			loader.setLocation(Aplicacion.class.getResource("view/LoginOverView.fxml"));

			BorderPane rootLayout = loader.load();
			
			//Cargar controlador
			LoginController loginController = loader.getController();
			loginController.setAplicacion(this);

			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	/**
	 * Metodo get de la empresa
	 * @return retorna empresa
	 */
	public Empresa getCompany() {
		return empresa;
	}
	
	/**
	 * Metodo set de la empresa
	 * @param empresa
	 */
	public void setCompany(Empresa empresa) {
		this.empresa = empresa;
	}

	/**
	 * Metodo para obtener los clientes
	 * @return Los clientes.
	 */
	public ArrayList<Cliente> obtenerClientes() {
		return empresa.getCliente();
	}

	/**
	 * Metodo para obtener los productos
	 * @return Los productos o objetos.
	 */
	public ArrayList<Objeto> obtenerProductos() {
		return empresa.getObjeto();
	}

	/**
	 * Metodo para obtener los empleados
	 * @return Los empleados.
	 */
	public ArrayList<Empleado> obtenerEmpleados() {
		return empresa.getEmpleado();
	}

	/**
	 * Metodo para obtener los prestamos
	 * @return Los prestmaos.
	 */
	public ArrayList<Prestamo> obtenerPrestamos() {
		return empresa.getPrestamo();
	}
	
	//Verifica la identificación del cliente
	public boolean verifyIdentificacionCliente(String documentoCliente) {
		return empresa.verificarIdentificacionCliente(documentoCliente);
	}
	
	//Verifica el código del objeto o producto
	public boolean verifyCodigoProducto(String codigoObjeto) {
		return empresa.verificarCodigoProducto(codigoObjeto);
	}
	
	//Verfica el documento del empleado
	public boolean verifyIdentificacionEmpleado(String identificacionEmpleado) {
		return empresa.verificarIdentificacionEmpleado(identificacionEmpleado);
	}
	
	//Verifica el código del prestamo
	public boolean verifyCodigoPrestamo(String codigoPrestamo) {
		return empresa.verificarCodigoPrestamo(codigoPrestamo);
	}
	
	/**
	 * Metodo para registrar cliente enlazado a empresa
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
	 * @return objeto de tipo Cliente creado.
	 */
	public Cliente registrarACliente(String documento, String nombre, String telefono,
			String celular, String direccion, String ciudadResidencia,
			String departamento,String pais, String mail, String profesion,
			String genero) {
		return empresa.registerCliente(documento, nombre, telefono, celular,
				direccion, ciudadResidencia, departamento, pais, mail, profesion, genero);
	}

	/**
	 * Metodo para registrar un objeto enlazado a empresa
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
	 * @return objeto de tipo Objeto creado.
	 */
	public Objeto registrarAObjeto(String codigo, String nombre, String color, String peso, String precioAlquiler,
			String estadoObjeto,  String tipo, String descripcion, int unidadesDisponibles,
			int unidadesPrestadas) {
		return empresa.registerObjeto(codigo,nombre,color,peso,precioAlquiler,
				estadoObjeto, tipo, descripcion, unidadesDisponibles, unidadesPrestadas);
	}
	
	/**
	 * Metodo para registar un empleado enlazado a empresa
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
	 * @return objeto de tipo Empleado creado.
	 */
	public Empleado registrarAEmpleado(String documento, String nombre, String telefono, String celular, String direccion,
            String ciudadResidencia, String departamento, String pais, String mail,
            String tipoEmpleado, String aniosExperiencia) {

		return empresa.registerEmpleado(documento,nombre,telefono,celular,
				direccion,ciudadResidencia,departamento,pais,mail,tipoEmpleado, aniosExperiencia);
	}
	
	/**
	 * Metodo para crear un prestamo enlazado a empresa
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
	 * @return objeto de tipo Prestamo creado.
	 */
	public Prestamo registrarAPrestamo(String prestamoCodigo, String estadoPrestamo,
			String valorPrestamo, String fechaPrestamo,
			String fechaEntregaPrestamo, Cliente clienteEncontrado,
			Empleado empleadoEncontrado, Objeto productoEncontrado,
			int diasTranscurridos, int diasSolicitados) {

		return empresa.registerPrestamo(prestamoCodigo, estadoPrestamo, valorPrestamo,
				fechaPrestamo, fechaEntregaPrestamo, clienteEncontrado,
				empleadoEncontrado,productoEncontrado, diasTranscurridos, diasSolicitados);
	}

	/**
	 * Metodo para actualizar un cliente enlazado a empresa
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
	public void actualizarAcliente(String documentoAntiguo, String documento, String nombre, String telefono, String celular, String direccion,
			String ciudadResidencia, String departamento, String pais, String mail,
			String profesion, String genero) throws CustomerExistException {

		 empresa.actualizarCliente(documentoAntiguo, documento,nombre,telefono,celular, direccion,
				 ciudadResidencia,departamento,pais,mail,
				 profesion,genero);
	}

	/**
	 * Metodo para actualizar un objeto o producto enlazado a empresa.
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
	public void actualizarAProducto(String codigoAnterior, String codigo, String nombre, String color, String peso, String precioAlquiler,
			String estadoObjeto,  String tipo, String descripcion, int unidadesDisponibles,
			int unidadesPrestadas) throws ProductExistException {

		empresa.actualizarObjeto(codigoAnterior, codigo,nombre,color,peso,precioAlquiler,
				estadoObjeto,tipo,descripcion, unidadesDisponibles, unidadesPrestadas);

	}

	/**
	 * Metodo para actualizar un empleado enlazado a empresa.
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
	public void actualizarAEmpleado(String identificacionAnterior, String documento, String nombre, String telefono, String celular, String direccion,
            String ciudadResidencia, String departamento, String pais, String mail,
            String tipoEmpleado, String aniosExperiencia) throws EmployeeExistException {

		empresa.actualizarEmpleado(identificacionAnterior,documento,nombre,telefono,
				celular,direccion,ciudadResidencia,departamento,
				pais,mail, tipoEmpleado, aniosExperiencia);
	}
	
	/**
	 * Metodo para actualizar un prestamo enlazado a empresa
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
			Cliente cliente, Empleado empleado, Objeto objeto,
			int diasTranscurridos, int diasSolicitados) throws LoanExistException{
		
		empresa.actualizarPrestamo(codigoAnterior, codigo, valor, fechaPrestamo,
				fechaEntrega, estadoPrestamo, cliente, empleado, objeto,
				diasTranscurridos, diasSolicitados);
	}
	
	/**
	 * Metodo para eliminar un cliente enlazado a empresa
	 * @param documentoCliente Representa del documento del cliente
	 * @return Entero con la posicion del cliente en su respectiva lista.
	 */
	public int eliminarACliente(String documentoCliente) {
		return empresa.eliminarCliente(documentoCliente);
	}
	
	/**
	 * Metodo para eliminar un empleado enlazado a empresa
	 * @param documentoEmpleado Representa del documento del empleado
	 * @return Entero con la posicion del empleado en su respectiva lista.
	 */
	public int eliminarAEmpleado(String documentoEmpleado) {
		return empresa.eliminarEmpleado(documentoEmpleado);
	}
	
	/**
	 * Metodo para eliminar un objeto enlazado a empresa
	 * @param codigoObjeto Representa del codigo del objeto
	 * @return Entero con la posicion del objeto en su respectiva lista.
	 */
	public int eliminarAObjeto(String codigoObjeto) {
		return empresa.eliminarObjeto(codigoObjeto);
	}
	
	/**
	 * Metodo para eliminar un prestamo enlazado a empresa
	 * @param codigoPrestamo Representa del codigo del prestamo
	 * @return Entero con la posicion del prestamo en su respectiva lista.
	 */
	public int eliminarAPrestamo(String codigoPrestamo) {
		return empresa.eliminarPrestamo(codigoPrestamo);
	}

	/**
	 * Metodo para buscar un objeto de tipo Cliente, enlazado a empresa.
	 * @param cliente representa en realidad su documento
	 * @return objeto de tipo Cliente.
	 */
	public Cliente buscarCliente(String cliente) {
		return empresa.obtenerCliente(cliente);
	}

	/**
	 * Metodo para buscar un objeto de tipo Empleado, enlazado a empresa.
	 * @param empleado representa en realidad su documento
	 * @return objeto de tipo Empleado.
	 */
	public Empleado buscarEmpleado(String empleado) {
		return empresa.obtenerEmpleado(empleado);
	}

	/**
	 * Metodo para buscar un objeto de tipo Objeto, enlazado a empresa.
	 * @param objeto representa en realidad su codigo
	 * @return objeto de tipo Objeto.
	 */
	public Objeto buscarObjeto(String objeto) {
		return empresa.obtenerObjeto(objeto);
	}
	
	/**
	 * Metodo para saber si el cliente esta en prestamos, enlazado a empresa.
	 * @param cliente objeto de tipo Cliente
	 * @return true en caso de que este en prestamos, false en caso contrario.
	 */
	public boolean obtenerClientePrestamo(Cliente cliente) {
		return empresa.buscarPrestamoConCliente(cliente);
	}
	
	/**
	 * Metodo para saber si el empleado ha realizado prestamos, enlazado a empresa.
	 * @param empleado objeto de tipo Empleado
	 * @return true en caso de haya realizado prestamos, false en caso contrario.
	 */
	public boolean obtenerEmpleadoPrestamo(Empleado empleado) {
		return empresa.buscarPrestamoConEmpleado(empleado);
	}
	
	/**
	 * Metodo para saber si el objeto estan en prestamos, enlazado a empresa.
	 * @param objeto objeto de tipo Objeto
	 * @return true en caso de que este en prestamos, false en caso contrario.
	 */
	public boolean obtenerObjetoPrestamo(Objeto objeto) {
		return empresa.buscarPrestamoConObjeto(objeto);
	}

}
