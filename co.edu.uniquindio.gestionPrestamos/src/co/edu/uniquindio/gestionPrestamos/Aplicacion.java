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

public class Aplicacion extends Application{
	private Empresa empresa = new Empresa("Administracion prestamos.", "0805");
	private Stage primaryStage;
	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Administracion prestamos.");
		//aqui llamamos para mostrar lo que hemos cargado dentro el metodo
		showLoginWindow();
	}

	private void showLoginWindow() {
		//Puede que no exista nada entonces lo hacemos con un try catch
		try {
			FXMLLoader loader = new FXMLLoader();
			//Buscar y cagar el archivo FMXL
			loader.setLocation(Aplicacion.class.getResource("view/LoginOverView.fxml"));

			BorderPane rootLayout = loader.load();

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
	public Empresa getCompany() {
		return empresa;
	}
	public void setCompany(Empresa empresa) {
		this.empresa = empresa;
	}

	public ArrayList<Cliente> obtenerClientes() {
		return empresa.getCliente();
	}

	public ArrayList<Objeto> obtenerProductos() {
		return empresa.getObjeto();
	}

	public ArrayList<Empleado> obtenerEmpleados() {
		return empresa.getEmpleado();
	}

	public ArrayList<Prestamo> obtenerPrestamos() {
		return empresa.getPrestamo();
	}
	//Verifica la identificación del cliente
	public boolean verifyIdentificationClient(String documentoCustomer) {
		return empresa.verfyIdentificationCustomer(documentoCustomer);
	}
	//Verifica el código del cliente
	public boolean verifyCodeProduct(String productCode) {
		return empresa.verifyCodeProduct(productCode);
	}
	//Verfica el documento del empleado
	public boolean verifyIdentificationEmployee(String employeeIdentification) {
		return empresa.verifyCodeEmployee(employeeIdentification);
	}
	//Verifica el código del prestamo
	public boolean verifyCodeLoan(String loanCode) {
		return empresa.verifyCodeLoan(loanCode);
	}
	
	/**
	 * Registra al cliente
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
	public Cliente registrarACliente(String nameCustomer, String lastNameCustomer, String customerIdentification,
			String customerAddress, String cellPhoneClient, String clientCity, String customerDepartment,
			String clientCountry, String emailCustomer, String profesioCustomer, String genero) {
		return empresa.registerCliente(nameCustomer, lastNameCustomer, customerIdentification, customerAddress,
				cellPhoneClient, clientCity, customerDepartment, clientCountry, emailCustomer, profesioCustomer, genero);
	}
	/**
	 * Registra al producto
	 * @param nameProduct
	 * @param productCode
	 * @param productWeight
	 * @param conditionProduct
	 * @param productValue
	 * @param productDescription
	 * @param productColor
	 * @param totalValue
	 * @param unidadesPres 
	 * @param unidadesDis 
	 * @return
	 */
	public Objeto registrarAObjeto(String codigo, String nombre, String color, String peso, String precioAlquiler,
			String estadoObjeto,  String tipo, String descripcion, int unidadesDisponibles,
			int unidadesPrestadas) {
		return empresa.registerObjeto(codigo,nombre,color,peso,precioAlquiler,
				estadoObjeto, tipo, descripcion, unidadesDisponibles, unidadesPrestadas);
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
	public Empleado registrarAEmpleado(String documento, String nombre, String telefono, String celular, String direccion,
            String ciudadResidencia, String departamento, String pais, String mail,
            String tipoEmpleado, String aniosExperiencia) {

		return empresa.registerEmpleado(documento,nombre,telefono,celular,
				direccion,ciudadResidencia,departamento,pais,mail,tipoEmpleado, aniosExperiencia);
	}
	//Registra el prestamo
	public Prestamo registrarAPrestamo(String loanCode, String loanCondition, String loanValue, String loanDate,
			String expirationDate, Cliente foundCustomer, Empleado foundEmployee, Objeto foundProduct, int diasSolicitados, int diasTranscurridos) {

		return empresa.registerPrestamo(loanCode,loanCondition,loanValue,loanDate,expirationDate,
				foundCustomer,foundEmployee,foundProduct, diasSolicitados, diasTranscurridos);
	}

	public void actualizarAcliente(String documentoAntiguo, String documento, String nombre, String telefono, String celular, String direccion,
			String ciudadResidencia, String departamento, String pais, String mail,
			String profesion, String genero) throws CustomerExistException {

		 empresa.udpdateCustomer(documentoAntiguo, documento,nombre,telefono,celular, direccion,
				 ciudadResidencia,departamento,pais,mail,
				 profesion,genero);
	}

	public void updateProduct(String codigoAnterior, String codigo, String nombre, String color, String peso, String precioAlquiler,
			String estadoObjeto,  String tipo, String descripcion, int unidadesDisponibles,
			int unidadesPrestadas) throws ProductExistException {

		empresa.actualizarObjeto(codigoAnterior, codigo,nombre,color,peso,precioAlquiler,
				estadoObjeto,tipo,descripcion, unidadesDisponibles, unidadesPrestadas);

	}

	public void updateEmployee(String identificacionAnterior, String documento, String nombre, String telefono, String celular, String direccion,
            String ciudadResidencia, String departamento, String pais, String mail,
            String tipoEmpleado, String aniosExperiencia) throws EmployeeExistException {

		empresa.updateEmployee(identificacionAnterior,documento,nombre,telefono,
				celular,direccion,ciudadResidencia,departamento,
				pais,mail, tipoEmpleado, aniosExperiencia);
	}
	
	public void actualizarPrestamo(String codigoAnterior, String codigo, String valor, String fechaPrestamo, String fechaEntrega, String estadoPrestamo,
			Cliente cliente, Empleado empleado, Objeto objeto, int diasTranscurridos, int diasSolicitados) throws LoanExistException{
		empresa.actualizarPrestamo(codigoAnterior, codigo, valor, fechaPrestamo, fechaEntrega, estadoPrestamo, cliente, empleado, objeto, diasTranscurridos, diasSolicitados);
	}
	
	public int eliminarCliente(String documentoCliente) {
		return empresa.eliminarCliente(documentoCliente);
	}
	
	public int eliminarEmpleado(String documentoEmpleado) {
		return empresa.eliminarEmpleado(documentoEmpleado);
	}
	
	public int eliminarObjeto(String codigoObjeto) {
		return empresa.eliminarObjeto(codigoObjeto);
	}
	
	public int eliminarPrestamo(String codigoPrestamo) {
		return empresa.eliminarPrestamo(codigoPrestamo);
	}

	public Cliente buscarCliente(String cliente) {
		return empresa.obtenerCliente(cliente);
	}

	public Empleado buscarEmpleado(String empleado) {
		return empresa.obtenerEmpleado(empleado);
	}

	public Objeto buscarObjeto(String objeto) {
		return empresa.obtenerObjeto(objeto);
	}

}
