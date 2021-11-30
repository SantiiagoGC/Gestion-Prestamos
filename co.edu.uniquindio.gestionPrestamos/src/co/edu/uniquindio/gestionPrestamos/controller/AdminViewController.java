package co.edu.uniquindio.gestionPrestamos.controller;
import java.net.URL;

import java.util.Observable;
import java.util.ResourceBundle;

import co.edu.uniquindio.gestionPrestamos.Aplicacion;
import co.edu.uniquindio.gestionPrestamos.exception.CustomerExistException;
import co.edu.uniquindio.gestionPrestamos.exception.EmployeeExistException;
import co.edu.uniquindio.gestionPrestamos.exception.ProductExistException;
import co.edu.uniquindio.gestionPrestamos.model.Cliente;
import co.edu.uniquindio.gestionPrestamos.model.Empleado;
import co.edu.uniquindio.gestionPrestamos.model.Loan;
import co.edu.uniquindio.gestionPrestamos.model.Objeto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class AdminViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
	private TextField txtValorPrestamo;

	@FXML
	private TextField txtNombreObjeto;

	@FXML
    private TextField txtObjetos;

    @FXML
    private TextField txtValorObjeto;

    @FXML
    private TextField txtBuscarObjeto;

    @FXML
    private Button btnRegistrarObjeto;

    @FXML
    private TextField txtCliente;

    @FXML
    private TextField txtPaisEmpleado;

    @FXML
    private TextField txtBuscarEmpleado;

    @FXML
    private TextField txtProfesion;

    @FXML
    private TextField txtDocumentoCliente;

    @FXML
    private TextField txtEstadoObjeto;

    @FXML
    private TextField txtTelefonoCliente;

    @FXML
    private Button btnNuevoCliente;

    @FXML
    private Button btnBuscarPrestamo;

    @FXML
    private TextField txtEmailCliente;

    @FXML
    private TextField txtEstadoPrestamo;

    @FXML
    private Button btnRegistrarCliente;

    @FXML
    private TextField txtDepartamentoEmpleado;

    @FXML
    private TextField txtTelefonoEmpleado;

    @FXML
    private TextField txtBuscarPrestamo;

    @FXML
    private TextField txtCódigoPrestamo;

    @FXML
    private TextField txtCodigoObjeto;

    @FXML
    private TextField txtDepartamentoCliente;

    @FXML
    private TextField txtTipoEmpleado;

    @FXML
    private TextField txtBuscarCliente;

    @FXML
    private Button btnActuliazarCliente;

    @FXML
    private Button btnNuevoObjeto;

    @FXML
    private ComboBox<?> choiceBoxCliente;

    @FXML
    private TextField txtNombreEmpleado;

    @FXML
    private Button btnActuliazarPrestamo;

    @FXML
    private Button btnBuscarEmpleado;

    @FXML
    private Button btnNuevoEmpleado;

    @FXML
    private TextField txtCiudadCliente;
    
    @FXML
    private TextField txtGenero;

    @FXML
    private Button btnRegistrarPrestamo;

    @FXML
    private TextField txtDescripcionObjeto;

    @FXML
    private TextField txtDireccionCliente;

    @FXML
    private TextField txtCiudadEmpleado;
    
    @FXML
    private TextField txtAniosExperiencia;

    @FXML
    private TextField txtDireccionEmpleado;

    @FXML
    private TextField txtEmpleado;

    @FXML
    private TextField txtPesoObjeto;

    @FXML
    private TextField txtFechaPrestamo;

    @FXML
    private TextField txtCelularEmpleado;

    @FXML
    private TextField txtNombreCliente;

    @FXML
    private Button btnRegistrarEmpleado;

    @FXML
    private Button btnActuliazarEmpleado;

    @FXML
    private Button btnBuscarCliente;

    @FXML
    private Button btnActuliazarObjeto;

    @FXML
    private Button btnNuevoPrestamo;

    @FXML
    private ComboBox<?> choiceBoxObjeto;

    @FXML
    private ComboBox<?> choiceBoxPrestamo;

    @FXML
	private ComboBox<?> choiceBoxEmpleado;

	@FXML
    private TextField txtEmailEmpleado;

    @FXML
    private TextField txtCelularCliente;

    @FXML
    private TextField txtColorObjeto;
    
    @FXML
    private TextField txtTipoObjeto;
    
    @FXML
    private TextField txtUnidadesDis;

    @FXML
    private TextField txtUnidadesPres;

    @FXML
    private Button btnBuscarObjeto;

    @FXML
    private TextField txtFechaEntrega;

    @FXML
    private TextField txtDocumentoEmpleado;

    @FXML
    private TextField txtPaisCliente;

    @FXML
	private TableView<Cliente> tblListCostumer;

	@FXML
	private TableView<Empleado> tblListEmployee;

	@FXML
	private TableView<Objeto> tblListProduct;

	@FXML
	private TableView<Loan> tblListLoan;

	@FXML
	private TableColumn<Cliente, String> columnNombreCliente;

    @FXML
    private TableColumn<Cliente, String> columnDocumentoCliente;

	@FXML
	private TableColumn<Objeto, String> columnNombreObjeto;

	@FXML
	private TableColumn<Objeto, String> columnCodigoObjeto;

	@FXML
	private TableColumn<Empleado, String> columnNombreEmpleado;


    @FXML
    private TableColumn<Empleado, String> columnDocumentoEmpleado;

	@FXML
	private TableColumn<Loan, String> columnValorPrestamo;

	@FXML
	private TableColumn<Loan, String> columnCodigoPrestamo;

	private Aplicacion aplicacion;
	//Observables
	ObservableList<Cliente> listaClientes = FXCollections.observableArrayList();
	ObservableList<Objeto> listProducts = FXCollections.observableArrayList();
	ObservableList<Empleado> listEmployee = FXCollections.observableArrayList();
	ObservableList<Loan> listLoan = FXCollections.observableArrayList();
	//Variables de seleccion
	private Cliente clienteSeleccionado;
	private Objeto selectedProduct;
	private Empleado selectedEmployee;
	private Loan selectedLoan;

    public void setAplicacion(Aplicacion aplicacion) {
		this.aplicacion = aplicacion;
		loadCustomerList();
		loadProductList();
		loadEmployeeList();
		loadLoanList();
	}
	@FXML
	void initialize() {
    //Datos de la tabla Cliente
    	this.columnNombreCliente.setCellValueFactory(new PropertyValueFactory<>("nombre"));
    	this.columnDocumentoCliente.setCellValueFactory(new PropertyValueFactory<>("documento"));

    	tblListCostumer.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) ->{
    		clienteSeleccionado = newSelection;
    		showCustomerInformation(clienteSeleccionado);
    	});

    	this.columnNombreObjeto.setCellValueFactory(new PropertyValueFactory<>("nombre"));
    	this.columnCodigoObjeto.setCellValueFactory(new PropertyValueFactory<>("codigo"));

    	tblListProduct.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) ->{
    		selectedProduct = newSelection;
    		showProductInformation(selectedProduct);
    	});

    	this.columnNombreEmpleado.setCellValueFactory(new PropertyValueFactory<>("nombre"));
    	this.columnDocumentoEmpleado.setCellValueFactory(new PropertyValueFactory<>("documento"));

    	tblListEmployee.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) ->{
    		selectedEmployee = newSelection;
    		showEmployeeInformation(selectedEmployee);
    	});

    	this.columnValorPrestamo.setCellValueFactory(new PropertyValueFactory<>("valor"));
    	this.columnCodigoPrestamo.setCellValueFactory(new PropertyValueFactory<>("codigo"));

    	tblListLoan.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) ->{
    		selectedLoan = newSelection;
    		showLoanInformation(selectedLoan);
    	});




	}
	@FXML
	void nuevoCliente(ActionEvent event) {
		nuevoCliente();
	}
	@FXML
	void nuevoObjeto(ActionEvent event) {
		nuevoObjeto();
	}
	@FXML
	void nuevoEmpleado(ActionEvent event) {
		nuevoEmpleado();
	}
	@FXML
	void nuevoPrestamo(ActionEvent event) {
		nuevoPrestamo();
	}
	@FXML
	void registrarCliente(ActionEvent event) {
		registrarACliente();
	}
	@FXML
	void registrarObjeto(ActionEvent event) {
		registrarAObjeto();
	}
	@FXML
	void registrarEmpleado(ActionEvent event) {
		registrarAEmpleado();
	}
	@FXML
	void registrarPrestamo(ActionEvent event) {
		registrarLoan();
	}
	@FXML
	void actulizarCliente(ActionEvent event) throws CustomerExistException {
		actualizarCliente();
	}
	@FXML
	void actualizarObjeto(ActionEvent event) throws ProductExistException {
		actualizarObjeto();
	}
	@FXML
	void actualizarEmpleado(ActionEvent event) throws EmployeeExistException {
		actualizarEmpleado();
	}
	@FXML
	void actualizarPrestamo(ActionEvent event) {

	}
	@FXML
	void buscarCliente(ActionEvent event) {

	}
	@FXML
	void buscarObejto(ActionEvent event) {

	}
	@FXML
	void buscarEmpleado(ActionEvent event) {

	}
	@FXML
	void buscarPrestamo(ActionEvent event) {

	}
	//Nos muestra un tipo de alerta
    private void showMessage(String titulo, String header, String contenido, AlertType tipoAlerta) {

        Alert alert = new Alert(tipoAlerta);
        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setContentText(contenido);
        alert.showAndWait();

    }

	private void loadCustomerList() {
		tblListCostumer.getItems().clear();
		tblListCostumer.setItems(obtenerClientes());

	}

	private void loadProductList() {
		tblListProduct.getItems().clear();
		tblListProduct.setItems(obtenerProductos());
	}

	private void loadEmployeeList() {
		tblListEmployee.getItems().clear();
		tblListEmployee.setItems(obtenerEmpleados());
	}

	private void loadLoanList() {
		tblListLoan.getItems().clear();
		tblListLoan.setItems(obtenerPrestamos());
	}

	private ObservableList<Objeto> obtenerProductos() {
		listProducts.addAll(aplicacion.obtenerProductos());
		return listProducts;
	}

	private ObservableList<Empleado> obtenerEmpleados() {
		listEmployee.addAll(aplicacion.obtenerEmpleados());
		return listEmployee;
	}

	private ObservableList<Loan> obtenerPrestamos() {
		listLoan.addAll(aplicacion.obtenerPrestamos());
		return listLoan;
	}

	private ObservableList<Cliente> obtenerClientes() {
		listaClientes.addAll(aplicacion.obtenerClientes());
		return listaClientes;
	}

	private void showCustomerInformation(Cliente client) {
		if (client != null) {
			txtNombreCliente.setText(client.getNombre());
			txtTelefonoCliente.setText(client.getTelefono());
			txtDocumentoCliente.setText(client.getDocumento());
			txtDireccionCliente.setText(client.getDireccion());
			txtCelularCliente.setText(client.getCelular());
			txtCiudadCliente.setText(client.getCiudadResidencia());
			txtDepartamentoCliente.setText(client.getDepartamento());
			txtPaisCliente.setText(client.getPais());
			txtEmailCliente.setText(client.getMail());
			txtProfesion.setText(client.getProfesion());
			txtGenero.setText(client.getGenero());

		}
	}

	private void showProductInformation(Objeto product) {
		if (product != null) {
			txtNombreObjeto.setText(product.getNombre());
			txtCodigoObjeto.setText(product.getCodigo());
			txtPesoObjeto.setText(product.getPeso());
			txtValorObjeto.setText(product.getPrecioAlquiler());
			txtEstadoObjeto.setText(product.getEstadoObjeto().toString());
			txtTipoObjeto.setText(product.getTipo());
			txtDescripcionObjeto.setText(product.getDescripcion());
			txtColorObjeto.setText(product.getColor());
			txtUnidadesDis.setText(String.valueOf(product.getUnidadesDisponibles()));
			txtUnidadesPres.setText(String.valueOf(product.getUnidadesPrestadas()));
		}

	}

	private void showEmployeeInformation(Empleado employee) {
		if (employee != null) {
			txtNombreEmpleado.setText(employee.getNombre());
			txtTelefonoEmpleado.setText(employee.getTelefono());
			txtDocumentoEmpleado.setText(employee.getDocumento());
			txtDireccionEmpleado.setText(employee.getDireccion());
			txtCelularEmpleado.setText(employee.getCelular());
			txtCiudadEmpleado.setText(employee.getCiudadResidencia());
			txtDepartamentoEmpleado.setText(employee.getDepartamento());
			txtPaisEmpleado.setText(employee.getPais());
			txtEmailEmpleado.setText(employee.getMail());
			txtTipoEmpleado.setText(employee.getTipoEmpleado().toString());
			txtAniosExperiencia.setText(employee.getAniosExperiencia());
		}

	}

	private void showLoanInformation(Loan loan) {

		if (loan != null) {
			txtCódigoPrestamo.setText(loan.getCodigo());
			txtEstadoPrestamo.setText(loan.getEstadoPrestamo().toString());
			txtValorPrestamo.setText(loan.getValor());
			txtFechaPrestamo.setText(loan.getFechaPrestamo());
			txtFechaEntrega.setText(loan.getFechaEntrega());
			txtCliente.setText(loan.getCustomer().getNombre());
			txtEmpleado.setText(loan.getEmployee().getNombre());
			txtObjetos.setText(loan.getProduct().getNombre());
		}

	}

	//Metodos
	//limpia la pestaña de cliente
	private void nuevoCliente() {
		txtNombreCliente.setText("");
		txtTelefonoCliente.setText("");
		txtDocumentoCliente.setText("");
		txtDireccionCliente.setText("");
		txtCelularCliente.setText("");
		txtCiudadCliente.setText("");
		txtDepartamentoCliente.setText("");
		txtPaisCliente.setText("");
		txtEmailCliente.setText("");
		txtProfesion.setText("");
		txtGenero.setText("");

	}
	//Limpia la ventana de objeto
	private void nuevoObjeto() {
		txtNombreObjeto.setText("");
		txtCodigoObjeto.setText("");
		txtPesoObjeto.setText("");
		txtValorObjeto.setText("");
		txtEstadoObjeto.setText("");
		txtTipoObjeto.setText("");
		txtDescripcionObjeto.setText("");
		txtColorObjeto.setText("");
		txtUnidadesDis.setText("");
		txtUnidadesPres.setText("");
	}
	//Limpia la ventana de objeto
	private void nuevoEmpleado() {
		txtNombreEmpleado.setText("");
		txtTelefonoEmpleado.setText("");
		txtDocumentoEmpleado.setText("");
		txtDireccionEmpleado.setText("");
		txtCelularEmpleado.setText("");
		txtCiudadEmpleado.setText("");
		txtDepartamentoEmpleado.setText("");
		txtPaisEmpleado.setText("");
		txtEmailEmpleado.setText("");
		txtTipoEmpleado.setText("");
		txtAniosExperiencia.setText("");

	}
	//Limpia la ventana de objeto
	private void nuevoPrestamo() {
		txtCódigoPrestamo.setText("");
		txtEstadoPrestamo.setText("");
		txtValorPrestamo.setText("");
		txtFechaPrestamo.setText("");
		txtFechaEntrega.setText("");
		txtCliente.setText("");
		txtEmpleado.setText("");
		txtObjetos.setText("");

	}
	/**
	 * Registra la información del cliente
	 */
	private void registrarACliente() {
		String nombreCliente = txtNombreCliente.getText();
    	String telefonoCliente = txtTelefonoCliente.getText();
    	String documentoCliente = txtDocumentoCliente.getText();
    	String direccionCliente = txtDireccionCliente.getText();
    	String celularCliente = txtCelularCliente.getText();
    	String ciudadCliente = txtCiudadCliente.getText();
    	String departamentoCliente = txtDepartamentoCliente.getText();
    	String paisCliente = txtPaisCliente.getText();
    	String emailCliente = txtEmailCliente.getText();
    	String profesionCliente = txtProfesion.getText();
    	String generoCliente = txtGenero.getText();

    	if(validData(nombreCliente,telefonoCliente,documentoCliente,
    			direccionCliente,celularCliente,ciudadCliente,departamentoCliente,paisCliente,emailCliente,profesionCliente)){

    		Cliente cliente = null;
    		cliente  = aplicacion.registerClient(nombreCliente,telefonoCliente,documentoCliente,
    				direccionCliente,celularCliente,ciudadCliente,departamentoCliente,paisCliente,emailCliente,profesionCliente, generoCliente);

    		if(cliente != null){
    			listaClientes.add(cliente);
    			showMessage("Notificación.", "Registro completado.", "cliente registrado con exito.", AlertType.INFORMATION);
    		} else{
    			showMessage("Notificación.", "¡Algo ocurrio! El registro no se pudó completar.", "El cliente no se pudo registrado con exito.", AlertType.INFORMATION);
    		}

    	}
	}
	//Registra la información del objeto
	private void registrarAObjeto() {
		String nameProduct = txtNombreObjeto.getText();
    	String productCode = txtCodigoObjeto.getText();
    	String productWeight = txtPesoObjeto.getText();
    	String conditionProduct = txtEstadoObjeto.getText();
    	String productValue = txtValorObjeto.getText();
    	String productDescription = txtDescripcionObjeto.getText();
    	String productColor = txtColorObjeto.getText();
    	String objetoTipo = txtTipoObjeto.getText();
    	String unidadesDis = txtUnidadesDis.getText();
    	String unidadesPres = txtUnidadesPres.getText();
    	    	
    	if(validDataProduct(nameProduct,productCode,productWeight,conditionProduct,productValue,
    			productDescription,productColor,objetoTipo, unidadesDis, unidadesPres)){
    		
        	int unidadesDisponibles = Integer.parseInt(unidadesDis);
        	int unidadesPrestadas = Integer.parseInt(unidadesPres);
    		Objeto objeto = null;
    		objeto = aplicacion.registerProduct(productCode,nameProduct,productColor,productWeight,productValue,
    				conditionProduct,objetoTipo,productDescription, unidadesDisponibles, unidadesPrestadas);

    		if(objeto != null){
    			listProducts.add(objeto);
    			showMessage("Notificación.", "Registro completado.", "producto registrado con exito.", AlertType.INFORMATION);
    		} else{
    			showMessage("Notificación.", "¡Algo ocurrio! El registro no se pudó completar.", "El producto no se pudo registrado con exito.", AlertType.INFORMATION);
    		}
    	}

	}
	//Registra al empleado
	private void registrarAEmpleado() {
		String nameEmployee = txtNombreEmpleado.getText();
    	String lastNameEmployee = txtTelefonoEmpleado.getText();
    	String employeeIdentification = txtDocumentoEmpleado.getText();
    	String employeeAddress = txtDireccionEmpleado.getText();
    	String cellPhoneEmployee = txtCelularEmpleado.getText();
    	String employeeCity = txtCiudadEmpleado.getText();
    	String employeeDepartment = txtDepartamentoEmpleado.getText();
    	String employeeCountry = txtPaisEmpleado.getText();
    	String emailEmployee = txtEmailEmpleado.getText();
    	String employeeType = txtTipoEmpleado.getText();
    	String empleadoExperiencia = txtAniosExperiencia.getText();

    	if(validDataEmployee(nameEmployee,lastNameEmployee,employeeIdentification,
    			employeeAddress,cellPhoneEmployee,employeeCity,employeeDepartment,employeeCountry,emailEmployee,employeeType)){

    		Empleado employee = null;
    		employee  = aplicacion.registrarEmpleado1(nameEmployee,lastNameEmployee,employeeIdentification,
        			employeeAddress,cellPhoneEmployee,employeeCity,employeeDepartment,employeeCountry,emailEmployee,employeeType, empleadoExperiencia);

    		if(employee != null){
    			listEmployee.add(employee);
    			showMessage("Notificación.", "Registro completado.", "empleado registrado con exito.", AlertType.INFORMATION);
    		} else{
    			showMessage("Notificación.", "¡Algo ocurrio! El registro no se pudó completar.", "El empleado no se pudo registrado con exito.", AlertType.INFORMATION);
    		}

    	}

	}
	//Registar los prestamos
	private void registrarLoan() {
		String loanCode = txtCódigoPrestamo.getText();
		String loanCondition = txtEstadoPrestamo.getText();
		String loanValue = txtValorPrestamo.getText();
		String loanDate = txtFechaPrestamo.getText();
		String expirationDate = txtFechaEntrega.getText();
		String customer = txtCliente.getText();
		String employee = txtEmpleado.getText();
		String product = txtObjetos.getText();
		if(validateLoan(loanCode,loanCondition,loanValue,loanDate,expirationDate,
				customer,employee,product)){
			Cliente foundCustomer = aplicacion.searchCustomer(customer);
			Empleado foundEmployee = aplicacion.searchEmployee(employee);
			Objeto foundProduct = aplicacion.searchProduct(product);

			Loan loan = null;
			loan = aplicacion.registerLoan(loanCode,loanCondition,loanValue,loanDate,expirationDate,
				foundCustomer, foundEmployee, foundProduct);

			if(loan != null){
				listLoan.add(loan);
				showMessage("Notificación.", "Registro completado.", "prestamo registrado con exito.", AlertType.INFORMATION);
			} else{
				showMessage("Notificación.", "¡Algo ocurrio! El registro no se pudó completar.", "El prestamo no se pudo registrado con exito.", AlertType.INFORMATION);
			}
		}

	}
	//Actuliza al cliente
	private void actualizarCliente() throws CustomerExistException {
		String nombreCliente = txtNombreCliente.getText();
    	String telefonoCliente = txtTelefonoCliente.getText();
    	String identificacionCliente = txtDocumentoCliente.getText();
    	String direccionCliente = txtDireccionCliente.getText();
    	String celularCliente = txtCelularCliente.getText();
    	String clienteCiudad = txtCiudadCliente.getText();
    	String clienteDepartamento = txtDepartamentoCliente.getText();
    	String clientePais = txtPaisCliente.getText();
    	String emailCliente = txtEmailCliente.getText();
    	String profesionCliente = txtProfesion.getText();
    	String generoCliente = txtGenero.getText();

    	
    	if(clienteSeleccionado != null){
    		if(validDat2(nombreCliente,telefonoCliente,identificacionCliente,
    				direccionCliente,celularCliente,clienteCiudad,clienteDepartamento,clientePais,emailCliente,profesionCliente)){

    			aplicacion.updateCustomer(nombreCliente,telefonoCliente,identificacionCliente,
    					direccionCliente,celularCliente,clienteCiudad,clienteDepartamento,clientePais,emailCliente,profesionCliente, generoCliente);
    			showMessage("Notificación.", "Actualizacion Completada", "Se ha actualizado con exito.", AlertType.INFORMATION);
    			tblListCostumer.refresh();
    		}
    	} else{
			showMessage("Notificación.", "Actualizacion incompleta", "No se ha podido actualizar la información.", AlertType.INFORMATION);

    	}

	}
	//Actuliza el producto
	private void actualizarObjeto() throws ProductExistException {
		String nameProduct = txtNombreObjeto.getText();
    	String productCode = txtCodigoObjeto.getText();
    	String productWeight = txtPesoObjeto.getText();
    	String conditionProduct = txtEstadoObjeto.getText();
    	String productValue = txtValorObjeto.getText();
    	String productDescription = txtDescripcionObjeto.getText();
    	String productColor = txtColorObjeto.getText();
    	String objetoTipo = txtTipoObjeto.getText();
    	String unidadesDis = txtUnidadesDis.getText();
    	String unidadesPres = txtUnidadesPres.getText();
    	
    	if(selectedProduct != null){
    		if(validDataProduct2(nameProduct,productCode,productWeight,conditionProduct,productValue,
    			productDescription,productColor,objetoTipo, unidadesDis, unidadesPres)){
    			
            	int unidadesDisponibles = Integer.parseInt(unidadesDis);
            	int unidadesPrestadas = Integer.parseInt(unidadesPres);
            	
    			aplicacion.updateProduct(nameProduct,productCode,productWeight,conditionProduct,productValue,
    	    	productDescription,productColor,objetoTipo, unidadesDisponibles, unidadesPrestadas);
    			showMessage("Notificación.", "Actualizacion Completada", "Se ha actualizado con exito.", AlertType.INFORMATION);
    			tblListProduct.refresh();
    		}
    	} else{
    		showMessage("Notificación.", "Actualizacion incompleta", "No se ha podido actualizar la información.", AlertType.INFORMATION);
    	}

	}
	//Actualizar al empleado
	private void actualizarEmpleado() throws EmployeeExistException {
		String nameEmployee = txtNombreEmpleado.getText();
    	String lastNameEmployee = txtTelefonoEmpleado.getText();
    	String employeeIdentification = txtDocumentoEmpleado.getText();
    	String employeeAddress = txtDireccionEmpleado.getText();
    	String cellPhoneEmployee = txtCelularEmpleado.getText();
    	String employeeCity = txtCiudadEmpleado.getText();
    	String employeeDepartment = txtDepartamentoEmpleado.getText();
    	String employeeCountry = txtPaisEmpleado.getText();
    	String emailEmployee = txtEmailEmpleado.getText();
    	String employeeType = txtTipoEmpleado.getText();
    	if(selectedEmployee != null){
        	if(validDataEmployee2(nameEmployee,lastNameEmployee,employeeIdentification,
        			employeeAddress,cellPhoneEmployee,employeeCity,employeeDepartment,employeeCountry,emailEmployee,employeeType)){

        		aplicacion.updateEmployee(nameEmployee,lastNameEmployee,employeeIdentification,
        			employeeAddress,cellPhoneEmployee,employeeCity,employeeDepartment,employeeCountry,emailEmployee,employeeType);
    			showMessage("Notificación.", "Actualizacion Completada", "Se ha actualizado con exito.", AlertType.INFORMATION);
    			tblListEmployee.refresh();
        	}
    	} else{
    		showMessage("Notificación.", "Actualizacion incompleta", "No se ha podido actualizar la información.", AlertType.INFORMATION);
    	}

	}
	private boolean validData(String nombreCustomer, String telefonoCliente, String documentoCustomer,
			String direccionCustomer, String celularCustomer, String ciudadCustomer, String departamentoCustomer,
			String paisCustomer, String emailCustomer, String profesioCustomer) {
		String mensaje = "";


	    if(nombreCustomer == null || nombreCustomer.equals("") || nombreCustomer.matches("[0-9]+")){
	        mensaje  += "NOMBRE NO VALIDO.\n";
	    }
	    if(telefonoCliente == null || telefonoCliente.equals("") || telefonoCliente.matches("[a-zA-Z]+")){
	    	mensaje += "TELEFONO NO VALIDO\n";
	    }
	    if(direccionCustomer == null || direccionCustomer.equals("")){
	        mensaje += "DIRECCION NO VALIDA.\n";
	    }
	    if(documentoCustomer == null || documentoCustomer.equals("") || documentoCustomer.matches("[a-zA-Z]+")){
	        mensaje += "CEDULA NO VALIDA.\n";
	    } else{
	    	if (clienteSeleccionado != null ) {
				if (documentoCustomer.equals(clienteSeleccionado.getDocumento())) {
					if (aplicacion.verifyIdentificationClient(documentoCustomer)) {
						mensaje += "¡ESE DOCUMENTO YA EXISTE!";
					}
				}
			}else{
				if(aplicacion.verifyIdentificationClient(documentoCustomer)){
					mensaje += "¡ESA DOCUMENTO YA EXISTE!";
				}
			}
	    }
	    if(celularCustomer == null || celularCustomer.equals("") || celularCustomer.matches("[a-zA-Z]+")){
	    	mensaje += "CELULAR NO VALIDO\n";
	    }
	    if(ciudadCustomer == null || ciudadCustomer.equals("") || ciudadCustomer.matches("[0-9]+")){
	    	mensaje += "CIUDAD NO VALIDA\n";
	    }
	    if(departamentoCustomer == null || departamentoCustomer.equals("")){
	    	mensaje += "DEPARTAMENTO NO VALIDO\n";
	    }
	    if(paisCustomer == null || paisCustomer.equals("") || paisCustomer.matches("[0-9]+")){
	    	mensaje += "PAIS NO VALIDO\n";
	    }
	    if(emailCustomer == null || emailCustomer.equals("") || !emailCustomer.contains("@")){
	    	mensaje += "EMAIL NO VALIDO\n";
	    }
	    if(profesioCustomer == null || profesioCustomer.equals("") || profesioCustomer.matches("[0-9]+")){
	    	mensaje += "PROFESIÓN NO VALIDA\n";
	    }

	    if(mensaje.equals("")){
	        return true;
	    } else{

	    	showMessage("Notificación.", "DATOS INCORRECTOS.", mensaje, AlertType.WARNING);
	        return false;
	    }
	}
	//Valida los para la actulización del cliente
	private boolean validDat2(String nameCustomer, String telefonoCliente, String customerIdentification,
			String customerAddress, String cellPhoneClient, String clientCity, String customerDepartment,
			String clientCountry, String emailCustomer, String profesioCustomer) {
		String mensaje = "";


	    if(nameCustomer == null || nameCustomer.equals("") || nameCustomer.matches("[0-9]+")){
	        mensaje  += "NOMBRE NO VALIDO.\n";
	    }
	    if(telefonoCliente == null || telefonoCliente.equals("") || telefonoCliente.matches("[a-zA-Z]+")){
	    	mensaje += "TELEFONO NO VALIDO\n";
	    }
	    if(customerAddress == null || customerAddress.equals("")){
	        mensaje += "DIRECCION NO VALIDA.\n";
	    }
	    if(customerIdentification == null || customerIdentification.equals("") || customerIdentification.matches("[a-zA-Z]+")){
	        mensaje += "CEDULA NO VALIDA.\n";
	    } else{
	    	if (clienteSeleccionado != null ) {
				if (!customerIdentification.equals(clienteSeleccionado.getDocumento())) {
					if (aplicacion.verifyIdentificationClient(customerIdentification)) {
						mensaje += "¡ESE DOCUMENTO YA EXISTE!";
					}
				}
			}else{
				if(aplicacion.verifyIdentificationClient(customerIdentification)){
					mensaje += "¡ESA DOCUMENTO YA EXISTE!";
				}
			}
	    }
	    if(cellPhoneClient == null || cellPhoneClient.equals("") || cellPhoneClient.matches("[a-zA-Z]+")){
	    	mensaje += "CELULAR NO VALIDO\n";
	    }
	    if(clientCity == null || clientCity.equals("") || clientCity.matches("[0-9]+")){
	    	mensaje += "CIUDAD NO VALIDA\n";
	    }
	    if(customerDepartment == null || customerDepartment.equals("")){
	    	mensaje += "DEPARTAMENTO NO VALIDO\n";
	    }
	    if(clientCountry == null || clientCountry.equals("") || clientCountry.matches("[0-9]+")){
	    	mensaje += "PAIS NO VALIDO\n";
	    }
	    if(emailCustomer == null || emailCustomer.equals("") || !emailCustomer.contains("@")){
	    	mensaje += "EMAIL NO VALIDO\n";
	    }
	    if(profesioCustomer == null || profesioCustomer.equals("") || profesioCustomer.matches("[0-9]+")){
	    	mensaje += "PROFESIÓN NO VALIDA\n";
	    }

	    if(mensaje.equals("")){
	        return true;
	    } else{

	    	showMessage("Notificación.", "DATOS INCORRECTOS.", mensaje, AlertType.WARNING);
	        return false;
	    }
	}
	/**
	 * Valida los datos del producto
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
	private boolean validDataProduct(String nameProduct, String productCode, String productWeight,
			String conditionProduct, String productValue, String productDescription, String productColor,
			String objetoTipo,String unidadesDis, String unidadesPres) {
		
		String mensaje = "";

		if(nameProduct == null || nameProduct.equals("") || nameProduct.matches("[0-9]+")){
			mensaje  += "NOMBRE NO VALIDO.\n";
		}
	    if(productCode == null || productCode.equals("") || productCode.matches("[a-zA-Z]+")){
	        mensaje += "CÓDIGO NO VALIDO.\n";
	    } else{
	    	if (selectedProduct != null ) {
				if (productCode.equals(selectedProduct.getCodigo())){
					if (aplicacion.verifyCodeProduct(productCode)) {
						mensaje += "¡ESE CÓDIGO YA EXISTE!";
					}
				}
			}else{
				if(aplicacion.verifyCodeProduct(productCode)){
					mensaje += "¡ESA CÓDIGO YA EXISTE!";
				}
			}
	    }
	    if(productWeight == null || productWeight.equals("")){
	    	mensaje += "¡PESO NO VALIDO!";
	    }
	    if(conditionProduct == null || conditionProduct.equals("") || conditionProduct.matches("[0-9]+")){
	    	mensaje += "¡CONDICIÓN NO VALIDA!";
	    }
	    if(productValue == null || productValue.equals("") || productValue.matches("[a-zA-z]")){
	    	mensaje += "¡VALOR NO VALIDO!";
	    }
	    if(productDescription == null || productDescription.equals("")){
	    	mensaje += "¡INGRESE LA CONDICIÓN DEL PRODUCTO!";
	    }
		if(productColor == null || productColor.equals("") || productColor.matches("[0-9]+")){
			mensaje  += "COLOR NO VALIDO.\n";
		}
	    if(objetoTipo == null || objetoTipo.equals("") || objetoTipo.matches("[0-9]+")){
	    	mensaje += "¡VALOR TOTAL NO VALIDO!";
	    }
	    if(unidadesDis == null || unidadesDis.equals("") || unidadesDis.matches("[a-zA-Z]+")){
	    	mensaje += "¡UNIDADES DISPONIBLES NO VALIDAS!";
	    }
	    if(unidadesPres == null || unidadesPres.equals("") || unidadesPres.matches("[a-zA-Z]+")){
	    	mensaje += "¡UNIDADES PRESTADAS NO VALIDAS!";
	    }
	    if(mensaje.equals("")){
	        return true;
	    } else{

	    	showMessage("Notificación.", "DATOS INCORRECTOS.", mensaje, AlertType.WARNING);
	        return false;
	    }
	}
	//Vaiida los datos para la actualización
	private boolean validDataProduct2(String nameProduct, String productCode, String productWeight,
			String conditionProduct, String productValue, String productDescription, String productColor,
			String objetoTipo,String unidadesDis, String unidadesPres) {
		String mensaje = "";

		if(nameProduct == null || nameProduct.equals("") || nameProduct.matches("[0-9]+")){
			mensaje  += "NOMBRE NO VALIDO.\n";
		}
	    if(productCode == null || productCode.equals("") || productCode.matches("[a-zA-Z]+")){
	        mensaje += "CÓDIGO NO VALIDO.\n";
	    } else{
	    	if (selectedProduct != null ) {
				if (productCode.equals(selectedProduct.getCodigo())){
					if (aplicacion.verifyCodeProduct(productCode)) {
						mensaje += "¡ESE CÓDIGO YA EXISTE!";
					}
				}
			}else{
				if(aplicacion.verifyCodeProduct(productCode)){
					mensaje += "¡ESA CÓDIGO YA EXISTE!";
				}
			}
	    }
	    if(productWeight == null || productWeight.equals("")){
	    	mensaje += "¡PESO NO VALIDO!";
	    }
	    if(conditionProduct == null || conditionProduct.equals("") || conditionProduct.matches("[0-9]+")){
	    	mensaje += "¡CONDICIÓN NO VALIDA!";
	    }
	    if(productValue == null || productValue.equals("") || productValue.matches("[a-zA-z]")){
	    	mensaje += "¡VALOR NO VALIDO!";
	    }
	    if(productDescription == null || productDescription.equals("")){
	    	mensaje += "¡INGRESE LA CONDICIÓN DEL PRODUCTO!";
	    }
		if(productColor == null || productColor.equals("") || productColor.matches("[0-9]+")){
			mensaje  += "COLOR NO VALIDO.\n";
		}
	    if(objetoTipo == null || objetoTipo.equals("") || objetoTipo.matches("[0-9]+")){
	    	mensaje += "¡VALOR TOTAL NO VALIDO!";
	    }
	    if(unidadesDis == null || unidadesDis.equals("") || unidadesDis.matches("[a-zA-Z]+")){
	    	mensaje += "¡UNIDADES DISPONIBLES NO VALIDAS!";
	    }
	    if(unidadesPres == null || unidadesPres.equals("") || unidadesPres.matches("[a-zA-Z]+")){
	    	mensaje += "¡UNIDADES PRESTADAS NO VALIDAS!";
	    }

	    if(mensaje.equals("")){
	        return true;
	    } else{

	    	showMessage("Notificación.", "DATOS INCORRECTOS.", mensaje, AlertType.WARNING);
	        return false;
	    }
	}
	//Valida la informacion
	private boolean validDataEmployee(String nameEmployee, String telefonoEmpleado, String employeeIdentification,
			String employeeAddress, String cellPhoneEmployee, String employeeCity, String employeeDepartment,
			String employeeCountry, String emailEmployee, String employeeType) {


		String mensaje = "";


	    if(nameEmployee == null || nameEmployee.equals("") || nameEmployee.matches("[0-9]+")){
	        mensaje  += "NOMBRE NO VALIDO.\n";
	    }
	    if(telefonoEmpleado == null || telefonoEmpleado.equals("") || telefonoEmpleado.matches("[a-zA-Z]+")){
	    	mensaje += "TELEFONO NO VALIDO\n";
	    }
	    if(employeeAddress == null || employeeAddress.equals("")){
	        mensaje += "DIRECCION NO VALIDA.\n";
	    }
	    if(employeeIdentification == null || employeeIdentification.equals("") || employeeIdentification.matches("[a-zA-Z]+")){
	        mensaje += "CEDULA NO VALIDA.\n";
	    } else{
	    	if (selectedEmployee != null ) {
				if (employeeIdentification.equals(selectedEmployee.getDocumento())) {
					if (aplicacion.verifyIdentificationEmployee(employeeIdentification)) {
						mensaje += "¡ESE DOCUMENTO YA EXISTE!";
					}
				}
			}else{
				if(aplicacion.verifyIdentificationEmployee(employeeIdentification)){
					mensaje += "¡ESA DOCUMENTO YA EXISTE!";
				}
			}
	    }
	    if(cellPhoneEmployee == null || cellPhoneEmployee.equals("") || cellPhoneEmployee.matches("[a-zA-Z]+")){
	    	mensaje += "CELULAR NO VALIDO\n";
	    }
	    if(employeeCity == null || employeeCity.equals("") || employeeCity.matches("[0-9]+")){
	    	mensaje += "CIUDAD NO VALIDA\n";
	    }
	    if(employeeDepartment == null || employeeDepartment.equals("")){
	    	mensaje += "DEPARTAMENTO NO VALIDO\n";
	    }
	    if(employeeCountry == null || employeeCountry.equals("") || employeeCountry.matches("[0-9]+")){
	    	mensaje += "PAIS NO VALIDO\n";
	    }
	    if(emailEmployee == null || emailEmployee.equals("") || !emailEmployee.contains("@")){
	    	mensaje += "EMAIL NO VALIDO\n";
	    }
	    if(employeeType == null || employeeType.equals("") || employeeType.matches("[a-zA-Z]+") || !employeeType.matches("[0-3]+")){
	    	mensaje += "TIPO DE EMPLEADO NO VALIDO\n";
	    }

	    if(mensaje.equals("")){
	        return true;
	    } else{

	    	showMessage("Notificación.", "DATOS INCORRECTOS.", mensaje, AlertType.WARNING);
	        return false;
	    }
	}
	//Validación de datos para acutlizar al empleado
	private boolean validDataEmployee2(String nameEmployee, String telefonoEmpleado, String employeeIdentification,
			String employeeAddress, String cellPhoneEmployee, String employeeCity, String employeeDepartment,
			String employeeCountry, String emailEmployee, String employeeType) {


		String mensaje = "";


	    if(nameEmployee == null || nameEmployee.equals("") || nameEmployee.matches("[0-9]+")){
	        mensaje  += "NOMBRE NO VALIDO.\n";
	    }
	    if(telefonoEmpleado == null || telefonoEmpleado.equals("") || telefonoEmpleado.matches("[a-zA-Z]+")){
	    	mensaje += "TELEFONO NO VALIDO\n";
	    }
	    if(employeeAddress == null || employeeAddress.equals("")){
	        mensaje += "DIRECCION NO VALIDA.\n";
	    }
	    if(employeeIdentification == null || employeeIdentification.equals("") || employeeIdentification.matches("[a-zA-Z]+")){
	        mensaje += "CEDULA NO VALIDA.\n";
	    } else{
	    	if (selectedEmployee != null ) {
				if (!employeeIdentification.equals(selectedEmployee.getDocumento())) {
					if (aplicacion.verifyIdentificationEmployee(employeeIdentification)) {
						mensaje += "¡ESE DOCUMENTO YA EXISTE!";
					}
				}
			}else{
				if(aplicacion.verifyIdentificationEmployee(employeeIdentification)){
					mensaje += "¡ESA DOCUMENTO YA EXISTE!";
				}
			}
	    }
	    if(cellPhoneEmployee == null || cellPhoneEmployee.equals("") || cellPhoneEmployee.matches("[a-zA-Z]+")){
	    	mensaje += "CELULAR NO VALIDO\n";
	    }
	    if(employeeCity == null || employeeCity.equals("") || employeeCity.matches("[0-9]+")){
	    	mensaje += "CIUDAD NO VALIDA\n";
	    }
	    if(employeeDepartment == null || employeeDepartment.equals("")){
	    	mensaje += "DEPARTAMENTO NO VALIDO\n";
	    }
	    if(employeeCountry == null || employeeCountry.equals("") || employeeCountry.matches("[0-9]+")){
	    	mensaje += "PAIS NO VALIDO\n";
	    }
	    if(emailEmployee == null || emailEmployee.equals("") || !emailEmployee.contains("@")){
	    	mensaje += "EMAIL NO VALIDO\n";
	    }
	    if(employeeType == null || employeeType.equals("") || employeeType.matches("[0-9]+")){
	    	mensaje += "PROFESIÓN NO VALIDA\n";
	    }

	    if(mensaje.equals("")){
	        return true;
	    } else{

	    	showMessage("Notificación.", "DATOS INCORRECTOS.", mensaje, AlertType.WARNING);
	        return false;
	    }
	}
	//Valida los datos del prestamo
	private boolean validateLoan(String loanCode, String loanCondition, String loanValue, String loanDate,
			String expirationDate, String customer, String employee, String product) {

		String mensaje = "";

		if(loanCode == null || loanCode.equals("") || loanCode.matches("[a-zA-Z]")){
			mensaje += "¡CÓDIGO NO VALIDO!";
		} else{
			if(selectedLoan != null){
				if(loanCode.equals(selectedLoan.getCodigo())){
					if(aplicacion.verifyCodeLoan(loanCode)){
						mensaje += "¡ESTE CÓDIGO YA ESTÁ REGISTRADO!";
					}
				}
			} else{
				if(aplicacion.verifyCodeLoan(loanCode)){
					mensaje += "¡ESTE CÓDIGO YA ESTÁ REGISTRADO!";
				}
			}
		}
		if(loanCondition == null || loanCode.equals("")){
			mensaje += "¡CONDICIÓN IVALIDA!";
		}
		if(loanValue == null || loanValue.equals("") || loanValue.matches("[a-zA-Z]")){
			mensaje += "¡VALOR INVALIDO!";
		}
		if(loanDate == null || loanDate.equals("") || loanDate.matches("[a-zA-Z]+")){
			mensaje += "¡FECHA INVALIDA!";
		}
		if(expirationDate == null || expirationDate.equals("") || expirationDate.matches("[a-zA-Z]")){
			mensaje += "¡FECHA DE ENTREGA INVALIDA!";
		}
		if(!aplicacion.verifyIdentificationClient(customer) || customer == null || customer.equals("") || customer.matches(("[a-zA-Z]"))){
			mensaje += "¡CLIENTE INVALIDO!";
		}
		if(!aplicacion.verifyIdentificationEmployee(employee) || employee == null || employee.equals("") || employee.matches(("[a-zA-Z]"))){
			mensaje += "¡EMPLEADO INVALIDO!";
		}
		if(!aplicacion.verifyCodeProduct(product) || product == null || product.equals("")){
			mensaje += "¡PRODUCTO INVALIDO!";
		}

		if(mensaje.equals("")){
			return true;
		} else{

			showMessage("Notificación.", "DATOS INCORRECTOS.", mensaje, AlertType.WARNING);
			return false;
		}
	}

}

