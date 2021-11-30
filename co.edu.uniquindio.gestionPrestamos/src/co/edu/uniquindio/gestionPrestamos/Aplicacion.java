package co.edu.uniquindio.gestionPrestamos;

import java.io.IOException;
import java.util.ArrayList;

import co.edu.uniquindio.gestionPrestamos.controller.LoginController;
import co.edu.uniquindio.gestionPrestamos.exception.CustomerExistException;
import co.edu.uniquindio.gestionPrestamos.exception.EmployeeExistException;
import co.edu.uniquindio.gestionPrestamos.exception.ProductExistException;
import co.edu.uniquindio.gestionPrestamos.model.Company;
import co.edu.uniquindio.gestionPrestamos.model.Cliente;
import co.edu.uniquindio.gestionPrestamos.model.Empleado;
import co.edu.uniquindio.gestionPrestamos.model.Loan;
import co.edu.uniquindio.gestionPrestamos.model.Objeto;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Aplicacion extends Application{
	private Company company = new Company("Administracion prestamos.");
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
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}

	public ArrayList<Cliente> obtenerClientes() {
		return company.getCliente();
	}

	public ArrayList<Objeto> obtenerProductos() {
		return company.getObjeto();
	}

	public ArrayList<Empleado> obtenerEmpleados() {
		return company.getEmpleado();
	}

	public ArrayList<Loan> obtenerPrestamos() {
		return company.getPrestamo();
	}
	//Verifica la identificación del cliente
	public boolean verifyIdentificationClient(String documentoCustomer) {
		return company.verfyIdentificationCustomer(documentoCustomer);
	}
	//Verifica el código del cliente
	public boolean verifyCodeProduct(String productCode) {
		return company.verifyCodeProduct(productCode);
	}
	//Verfica el documento del empleado
	public boolean verifyIdentificationEmployee(String employeeIdentification) {
		return company.verifyCodeEmployee(employeeIdentification);
	}
	//Verifica el código del prestamo
	public boolean verifyCodeLoan(String loanCode) {
		return company.verifyCodeLoan(loanCode);
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
	public Cliente registerClient(String nameCustomer, String lastNameCustomer, String customerIdentification,
			String customerAddress, String cellPhoneClient, String clientCity, String customerDepartment,
			String clientCountry, String emailCustomer, String profesioCustomer, String genero) {
		return company.registerClient(nameCustomer, lastNameCustomer, customerIdentification, customerAddress,
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
	public Objeto registerProduct(String codigo, String nombre, String color, String peso, String precioAlquiler,
			String estadoObjeto,  String tipo, String descripcion, int unidadesDisponibles,
			int unidadesPrestadas) {
		return company.registerProduct(codigo,nombre,color,peso,precioAlquiler,
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
	public Empleado registrarEmpleado1(String nameEmployee, String lastNameEmployee, String employeeIdentification,
			String employeeAddress, String cellPhoneEmployee, String employeeCity, String employeeDepartment,
			String employeeCountry, String emailEmployee, String employeeType, String aniosXp) {

		return company.registrarEmpleado(nameEmployee,lastNameEmployee,employeeIdentification,employeeAddress,
				cellPhoneEmployee,employeeCity,employeeDepartment,employeeCountry,emailEmployee,employeeType, aniosXp);
	}
	//Registra el prestamo
	public Loan registerLoan(String loanCode, String loanCondition, String loanValue, String loanDate,
			String expirationDate, Cliente foundCustomer, Empleado foundEmployee, Objeto foundProduct) {

		return company.registerLoan(loanCode,loanCondition,loanValue,loanDate,expirationDate,
				foundCustomer,foundEmployee,foundProduct);
	}

	public void updateCustomer(String nameCustomer, String lastNameCustomer, String customerIdentification,
			String customerAddress, String cellPhoneClient, String clientCity, String customerDepartment,
			String clientCountry, String emailCustomer, String profesioCustomer, String generoCliente) throws CustomerExistException {

		company.udpdateCustomer(nameCustomer,lastNameCustomer,customerIdentification,customerAddress,
				cellPhoneClient,clientCity,customerDepartment,clientCountry,
				emailCustomer,profesioCustomer);
	}

	public void updateProduct(String nameProduct, String productCode, String productWeight,
			String conditionProduct, String productValue, String productDescription, String productColor,
			String totalValue, int unidadesDis, int unidadesPres) throws ProductExistException {

		company.updateProduct(nameProduct,productCode,productWeight,conditionProduct,productValue,
				productDescription,productColor,totalValue, unidadesDis, unidadesPres);

	}

	public void updateEmployee(String nameEmployee, String lastNameEmployee, String employeeIdentification,
			String employeeAddress, String cellPhoneEmployee, String employeeCity, String employeeDepartment,
			String employeeCountry, String emailEmployee, String employeeType) throws EmployeeExistException {

		company.updateEmployee(nameEmployee,lastNameEmployee,employeeIdentification,employeeAddress,
				cellPhoneEmployee,employeeCity,employeeDepartment,employeeCountry,
				emailEmployee,employeeType);


	}

	public Cliente searchCustomer(String customer) {
		return company.obtenerCusotmer(customer);
	}

	public Empleado searchEmployee(String employee) {
		return company.obtenerEmployee(employee);
	}

	public Objeto searchProduct(String product) {
		return company.obtenerProduct(product);
	}


}
