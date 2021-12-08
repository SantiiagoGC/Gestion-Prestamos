package co.edu.uniquindio.gestionPrestamos.controller;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Observable;
import java.util.ResourceBundle;
import co.edu.uniquindio.gestionPrestamos.Aplicacion;
import co.edu.uniquindio.gestionPrestamos.exception.CustomerExistException;
import co.edu.uniquindio.gestionPrestamos.exception.EmployeeExistException;
import co.edu.uniquindio.gestionPrestamos.exception.LoanExistException;
import co.edu.uniquindio.gestionPrestamos.exception.ProductExistException;
import co.edu.uniquindio.gestionPrestamos.model.Cliente;
import co.edu.uniquindio.gestionPrestamos.model.Empleado;
import co.edu.uniquindio.gestionPrestamos.model.Prestamo;
import co.edu.uniquindio.gestionPrestamos.model.Objeto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * Representa el controlador de la vista de administrador
 * @author santi, juan, nodier.
 *
 */
public class AdminViewController {

	//-------------------------VARIABLES FXML-------------------------------------//
	
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
	private TextField txtDiasTranscurridos;

	@FXML
	private TextField txtDiasSolicitados;
	
    @FXML
    private Button btnEliminarAPrestamo;
    
    @FXML
    private ComboBox<String> comboBoxEstadoPres;
    
    @FXML
    private DatePicker dpFechaPrestamo;

    @FXML
    private DatePicker dpFechaEntrega;

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
    private Button btnAEliminarCliente;
	
	@FXML
	private RadioButton rdBoton1;
	 
	@FXML
	private ToggleGroup generoC;

	@FXML
	private RadioButton rdBoton2;

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
    private Button btnEliminarAEmpleado;

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
	private ComboBox<String> choiceBoxEmpleado;

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
    private Button btnEliminarAObjeto;

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
	private TableView<Prestamo> tblListLoan;
	
    @FXML
    private TableColumn<Objeto, String> columnNombrePrestamo1;

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
	private TableColumn<Prestamo, String> columnValorPrestamo;

	@FXML
	private TableColumn<Prestamo, String> columnCodigoPrestamo;

	private Aplicacion aplicacion;
	
	//------------------------------------------------------------------------//
	
	//Listas Observables
	ObservableList<Cliente> listaClientes = FXCollections.observableArrayList();
	ObservableList<Objeto> listaProductos = FXCollections.observableArrayList();
	ObservableList<Empleado> listaEmpleados = FXCollections.observableArrayList();
	ObservableList<Prestamo> listaPrestamos = FXCollections.observableArrayList();
	
	// Variables de seleccion
	private Cliente clienteSeleccionado;
	private Objeto objetoSeleccionado;
	private Empleado empleadoSeleccionado;
	private Prestamo prestamoSeleccionado;

	//APLICACION
	public void setAplicacion(Aplicacion aplicacion) {
		this.aplicacion = aplicacion;
		cargarListaClientes();
		cargarListaObjetos();
		cargarListaEmpleados();
		cargarListaPrestamos();
	}

	@FXML
	void initialize() {
		//Datos de la tabla Cliente
		this.columnNombreCliente.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		this.columnDocumentoCliente.setCellValueFactory(new PropertyValueFactory<>("documento"));

		tblListCostumer.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
			clienteSeleccionado = newSelection;
			mostrarInformacionCliente(clienteSeleccionado);
		});

		//Datos de la tabla Objeto
		this.columnNombreObjeto.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		this.columnCodigoObjeto.setCellValueFactory(new PropertyValueFactory<>("codigo"));

		tblListProduct.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
			objetoSeleccionado = newSelection;
			mostrarInformacionObjeto(objetoSeleccionado);
		});

		//Datos de la tabla Empleado
		this.columnNombreEmpleado.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		this.columnDocumentoEmpleado.setCellValueFactory(new PropertyValueFactory<>("documento"));

		tblListEmployee.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
			empleadoSeleccionado = newSelection;
			mostrarInformacionEmpleado(empleadoSeleccionado);
		});

		//Datos de la tabla Prestamo
		this.columnNombrePrestamo1.setCellValueFactory(new PropertyValueFactory<>("nombreObjeto"));
		this.columnValorPrestamo.setCellValueFactory(new PropertyValueFactory<>("valor"));
		this.columnCodigoPrestamo.setCellValueFactory(new PropertyValueFactory<>("codigo"));

		
		tblListLoan.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
			prestamoSeleccionado = newSelection;
			mostrarInformacionPrestamo(prestamoSeleccionado);
		});
		
		//Creando los items del comboBox de los tipos de empleados
		ArrayList<String> listaTipoEmpleado = new ArrayList<>();
		Collections.addAll(listaTipoEmpleado, new String[] {"Jefe de inventario","Empleado"});
		
		choiceBoxEmpleado.getItems().addAll(listaTipoEmpleado);
		
		//Creando los items del comboBox de los tipos estados de los prestamos
		ArrayList<String> listaEstadoPrestamo = new ArrayList<>();
		Collections.addAll(listaEstadoPrestamo, new String[] {"Falta por entregar","Entregado"});
		
		comboBoxEstadoPres.getItems().addAll(listaEstadoPrestamo);
		}

	//----------------------------METODOS JAVAFX----------------------------------//
	
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
		registrarCliente();
	}

	@FXML
	void registrarObjeto(ActionEvent event) {
		registrarObjeto();
	}

	@FXML
	void registrarEmpleado(ActionEvent event) {
		registrarEmpleado();
	}

	@FXML
	void registrarPrestamo(ActionEvent event) {
		registrarPrestamo();
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
	void actualizarPrestamo(ActionEvent event) throws LoanExistException {
		actualizarPrestamo();
	}

	@FXML
	void buscarCliente(ActionEvent event) {
		buscarCliente();
	}

	@FXML
	void buscarObejto(ActionEvent event) {
		buscarObejto();

	}

	@FXML
	void buscarEmpleado(ActionEvent event) {
		buscarEmpleado();
	}

	@FXML
	void buscarPrestamo(ActionEvent event) {
		buscarPrestamo();
	}
	
	@FXML
	void eliminarCliente(ActionEvent event) {
		eliminarCliente();
	}
	
	@FXML
	void eliminarEmpleado(ActionEvent event) {
		eliminarEmpleado();
	}
	
	@FXML
	void eliminarObjeto(ActionEvent event) {
		eliminarObjeto();
	}
	
	@FXML
	void eliminarPrestamo(ActionEvent event) {
		eliminarPrestamo();
	}

	//-----------------------------------------------------------------------------//
	
	//Nos muestra un tipo de alerta
	private void showMessage(String titulo, String header, String contenido, AlertType tipoAlerta) {

		Alert alert = new Alert(tipoAlerta);
		alert.setTitle(titulo);
		alert.setHeaderText(header);
		alert.setContentText(contenido);
		alert.showAndWait();

	}
	
	//Carga la lista de los clientes
	private void cargarListaClientes() {
		tblListCostumer.getItems().clear();
		tblListCostumer.setItems(obtenerClientes());

	}

	//Carga la lista de los objetos
	private void cargarListaObjetos() {
		tblListProduct.getItems().clear();
		tblListProduct.setItems(obtenerProductos());
	}

	//Carga la lista de los empleados
	private void cargarListaEmpleados() {
		tblListEmployee.getItems().clear();
		tblListEmployee.setItems(obtenerEmpleados());
	}

	//Carga la lista de los prestamos
	private void cargarListaPrestamos() {
		tblListLoan.getItems().clear();
		tblListLoan.setItems(obtenerPrestamos());
	}

	//Se le añade a la ObservableList de Objeto los objetos de los ArrayList
	private ObservableList<Objeto> obtenerProductos() {
		listaProductos.addAll(aplicacion.obtenerProductos());
		return listaProductos;
	}

	//Se le añade a la ObservableList de Empleado los empleados de los ArrayList
	private ObservableList<Empleado> obtenerEmpleados() {
		listaEmpleados.addAll(aplicacion.obtenerEmpleados());
		return listaEmpleados;
	}
	
	//Se le añade a la ObservableList de Prestamo los prestamos de los ArrayList
	private ObservableList<Prestamo> obtenerPrestamos() {
		listaPrestamos.addAll(aplicacion.obtenerPrestamos());
		return listaPrestamos;
	}

	//Se le añade a la ObservableList de Cliente los clientes de los ArrayList
	private ObservableList<Cliente> obtenerClientes() {
		listaClientes.addAll(aplicacion.obtenerClientes());
		return listaClientes;
	}
	
	/**
	 * Metodo para que al seleccionar un cliente este se rellene el formulario 
	 * con sus respectivos datos
	 * @param cliente objeto de tipo Cliente
	 */
	private void mostrarInformacionCliente(Cliente cliente) {
		if (cliente != null) {
			txtNombreCliente.setText(cliente.getNombre());
			txtTelefonoCliente.setText(cliente.getTelefono());
			txtDocumentoCliente.setText(cliente.getDocumento());
			txtDireccionCliente.setText(cliente.getDireccion());
			txtCelularCliente.setText(cliente.getCelular());
			txtCiudadCliente.setText(cliente.getCiudadResidencia());
			txtDepartamentoCliente.setText(cliente.getDepartamento());
			txtPaisCliente.setText(cliente.getPais());
			txtEmailCliente.setText(cliente.getMail());
			txtProfesion.setText(cliente.getProfesion());
			//txtGenero.setText(cliente.getGenero());
			btnRegistrarCliente.setDisable(true);
			btnAEliminarCliente.setDisable(false);
			btnActuliazarCliente.setDisable(false);
			
			if(cliente.getGenero().equalsIgnoreCase("Masculino")) {
				rdBoton1.setSelected(true);
			}else {
				rdBoton2.setSelected(true);
			}
			//rdBoton1.setText(cliente.getGenero());
			//System.out.println(rdBoton1.getText());
		}
	}

	/**
	 * Metodo para que al seleccionar un objeto se rellene el formulario 
	 * con sus respectivos datos
	 * @param producto
	 */
	private void mostrarInformacionObjeto(Objeto producto) {
		if (producto != null) {
			txtNombreObjeto.setText(producto.getNombre());
			txtCodigoObjeto.setText(producto.getCodigo());
			txtPesoObjeto.setText(producto.getPeso());
			txtValorObjeto.setText(producto.getPrecioAlquiler());
			txtEstadoObjeto.setText(producto.getEstadoObjeto().toString());
			txtTipoObjeto.setText(producto.getTipo());
			txtDescripcionObjeto.setText(producto.getDescripcion());
			txtColorObjeto.setText(producto.getColor());
			txtUnidadesDis.setText(String.valueOf(producto.getUnidadesDisponibles()));
			txtUnidadesPres.setText(String.valueOf(producto.getUnidadesPrestadas()));
			btnRegistrarObjeto.setDisable(true);
			btnActuliazarObjeto.setDisable(false);
		//	btnEliminarObjeto.setDisable(true);
		}

	}

	/**
	 * Metodo para que al seleccionar un empleado se rellene el formulario 
	 * con sus respectivos datos
	 * @param empleado
	 */
	private void mostrarInformacionEmpleado(Empleado empleado) {
		if (empleado != null) {
			txtNombreEmpleado.setText(empleado.getNombre());
			txtTelefonoEmpleado.setText(empleado.getTelefono());
			txtDocumentoEmpleado.setText(empleado.getDocumento());
			txtDireccionEmpleado.setText(empleado.getDireccion());
			txtCelularEmpleado.setText(empleado.getCelular());
			txtCiudadEmpleado.setText(empleado.getCiudadResidencia());
			txtDepartamentoEmpleado.setText(empleado.getDepartamento());
			txtPaisEmpleado.setText(empleado.getPais());
			txtEmailEmpleado.setText(empleado.getMail());
			//txtTipoEmpleado.setText(empleado.getTipoEmpleado());
			txtAniosExperiencia.setText(empleado.getAniosExperiencia());
			choiceBoxEmpleado.getSelectionModel().select(empleado.getTipoEmpleado());
			btnRegistrarEmpleado.setDisable(true);
			btnActuliazarEmpleado.setDisable(false);

		}

	}

	/**
	 * Metodo para que al seleccionar un prestamo se rellene el formulario 
	 * con sus respectivos datos
	 * @param prestamo
	 */
	private void mostrarInformacionPrestamo(Prestamo prestamo) {

		if (prestamo != null) {
			txtCódigoPrestamo.setText(prestamo.getCodigo());
			comboBoxEstadoPres.getSelectionModel().select(prestamo.getEstadoPrestamo());
			//txtEstadoPrestamo.setText(prestamo.getEstadoPrestamo());
			txtValorPrestamo.setText(prestamo.getValor());
			//txtFechaPrestamo.setText(prestamo.getFechaPrestamo());
			dpFechaPrestamo.setValue(LocalDate.parse(prestamo.getFechaPrestamo()));
			//txtFechaEntrega.setText(prestamo.getFechaEntrega());
			dpFechaEntrega.setValue(LocalDate.parse(prestamo.getFechaEntrega()));
			txtCliente.setText(prestamo.getCliente().getNombre()+ " " + "CC: " + prestamo.getCliente().getDocumento());
			txtEmpleado.setText(prestamo.getEmpleado().getNombre()+ " " + "CC: " + prestamo.getEmpleado().getDocumento());
			txtObjetos.setText(prestamo.getObjeto().getNombre()+ " " + "Codigo: " + prestamo.getObjeto().getCodigo());
			txtDiasSolicitados.setText(String.valueOf(prestamo.getDiasSolicitados()));
			txtDiasTranscurridos.setText(String.valueOf(prestamo.getDiasTranscurridos()));
			btnRegistrarPrestamo.setDisable(true);
			btnActuliazarPrestamo.setDisable(false);
		}

	}

	// limpia la ventana del cliente
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
		//txtGenero.setText("");
		btnRegistrarCliente.setDisable(false);
		btnAEliminarCliente.setDisable(true);
		btnActuliazarCliente.setDisable(true);
		generoC.selectToggle(null);
		tblListCostumer.getSelectionModel().clearSelection();

	}

	// Limpia la ventana del objeto
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
		btnRegistrarObjeto.setDisable(false);
		//btnAEliminarObjeto
		btnActuliazarObjeto.setDisable(true);
		tblListProduct.getSelectionModel().clearSelection();
	}

	// Limpia la ventana del empleado
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
		//txtTipoEmpleado.setText("");
		txtAniosExperiencia.setText("");
		btnRegistrarEmpleado.setDisable(false);
		btnActuliazarEmpleado.setDisable(true);
		choiceBoxEmpleado.getSelectionModel().select(null);
		tblListEmployee.getSelectionModel().clearSelection();

	}

	// Limpia la ventana del prestamo
	private void nuevoPrestamo() {
		txtCódigoPrestamo.setText("");
		comboBoxEstadoPres.getSelectionModel().select(null);
		txtValorPrestamo.setText("");
		//txtFechaPrestamo.setText("");
		dpFechaPrestamo.setValue(null);
		//txtFechaEntrega.setText("");
		dpFechaEntrega.setValue(null);
		txtCliente.setText("");
		txtEmpleado.setText("");
		txtObjetos.setText("");
		txtDiasSolicitados.setText("");
		txtDiasTranscurridos.setText("");
		txtBuscarPrestamo.setText("");
		btnRegistrarPrestamo.setDisable(false);
		btnActuliazarPrestamo.setDisable(true);
		tblListLoan.getSelectionModel().clearSelection();
	}

	/**
	 * Consultar cliente 
	 */
	private void buscarCliente(){
		String documento = txtBuscarCliente.getText();
		Cliente clienteEncontrado = null;
		clienteEncontrado = aplicacion.consultarAcliente(documento);
		
		if(clienteEncontrado != null) {
		showMessage("ENCONTRADO.", "Cliente encontrado.", "Es: "+clienteEncontrado.toString(),
				AlertType.INFORMATION);
		}else {
			showMessage("NO ENCONTRADO.", "Cliente no encontrado.", "Por favor verifique los datos",
					AlertType.WARNING);
		}
		
	}
	
	/**
	 * Consultar empleado
	 */
	private void buscarEmpleado(){
		String documento = txtBuscarEmpleado.getText();
		Empleado empleadoEncontrado = null;
		empleadoEncontrado = aplicacion.consultarAempleado(documento);
		
		if(empleadoEncontrado != null) {
		showMessage("ENCONTRADO.", "Empleado encontrado.", "Es: "+empleadoEncontrado.toString(),
				AlertType.INFORMATION);
		}else {
			showMessage("NO ENCONTRADO.", "Empleado no encontrado.", "Por favor verifique los datos",
					AlertType.WARNING);
		}
		
	}
	
	/**
	 * Consultar objeto
	 */
	private void buscarObejto() {
		String datos = txtBuscarObjeto.getText();
		//Objeto objetoEncontrado = null;
		String valoresEncontrados="";
		valoresEncontrados = aplicacion.consultarAobjeto(datos);
		
		if(valoresEncontrados != null && valoresEncontrados != "") {
		showMessage("ENCONTRADO.", "Objeto encontrado.", "Es: "+valoresEncontrados+" ",
				AlertType.INFORMATION);
		}else {
			showMessage("NO ENCONTRADO.", "Objeto no encontrado.", "Por favor verifique los datos",
					AlertType.WARNING);
		}
	}
	
	/**
	 * Consultar prestamo
	 */
	private void buscarPrestamo() {
		String codigo = txtBuscarPrestamo.getText();
		Prestamo prestamoEncontrado = null;
		prestamoEncontrado = aplicacion.consultarAprestamo(codigo);
		
		if(prestamoEncontrado != null) {
			showMessage("ENCONTRADO.", "Prestamo encontrado.", "Es: "+prestamoEncontrado.toString()+" ",
					AlertType.INFORMATION);
		}else {
			showMessage("NO ENCONTRADO.", "Prestamo no encontrado.", "Por favor verifique los datos",
					AlertType.WARNING);
		}
		
	}
	
	/**
	 * Registra la información del cliente
	 */
	private void registrarCliente() {
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
		String generoCliente = ((RadioButton)generoC.getSelectedToggle()).getText();
	

		if (validarDatosCliente(nombreCliente, telefonoCliente, documentoCliente, direccionCliente, celularCliente,
				ciudadCliente, departamentoCliente, paisCliente, emailCliente, profesionCliente,generoCliente)) {

			Cliente cliente = null;
			cliente = aplicacion.registrarACliente(nombreCliente, telefonoCliente, documentoCliente, direccionCliente,
					celularCliente, ciudadCliente, departamentoCliente, paisCliente, emailCliente, profesionCliente,
					generoCliente);

			if (cliente != null) {
				listaClientes.add(cliente);
				showMessage("Notificación.", "Registro completado.", "Cliente registrado con exito.",
						AlertType.INFORMATION);
			} else {
				showMessage("Notificación.", "¡Algo ocurrio! El registro no se pudó completar.",
						"El cliente no se pudo registrado con exito.", AlertType.INFORMATION);
			}

		}
	}

	/**
	 * Registra informacion del objeto
	 */
	private void registrarObjeto() {
		String nombreObjeto = txtNombreObjeto.getText();
		String codigoObjeto = txtCodigoObjeto.getText();
		String pesoObjeto = txtPesoObjeto.getText();
		String estadoObjeto = txtEstadoObjeto.getText();
		String valorObjeto = txtValorObjeto.getText();
		String descripcionObjeto = txtDescripcionObjeto.getText();
		String objetoColor = txtColorObjeto.getText();
		String objetoTipo = txtTipoObjeto.getText();
		String unidadesDis = txtUnidadesDis.getText();
		String unidadesPres = txtUnidadesPres.getText();

		if (validarDatosObjeto(nombreObjeto, codigoObjeto, pesoObjeto, estadoObjeto, valorObjeto, descripcionObjeto,
				objetoColor, objetoTipo, unidadesDis, unidadesPres)) {

			int unidadesDisponibles = Integer.parseInt(unidadesDis);
			int unidadesPrestadas = Integer.parseInt(unidadesPres);
			Objeto objeto = null;
			objeto = aplicacion.registrarAObjeto(codigoObjeto, nombreObjeto, objetoColor, pesoObjeto, valorObjeto,
					estadoObjeto, objetoTipo, descripcionObjeto, unidadesDisponibles, unidadesPrestadas);

			if (objeto != null) {
				listaProductos.add(objeto);
				showMessage("Notificación.", "Registro completado.", "Producto registrado con exito.",
						AlertType.INFORMATION);
			} else {
				showMessage("Notificación.", "¡Algo ocurrio! El registro no se pudó completar.",
						"El producto no se pudo registrado con exito.", AlertType.INFORMATION);
			}
		}

	}

	/**
	 * Registra la informacion del empleado
	 */
	private void registrarEmpleado() {
		String nombreEmpleado = txtNombreEmpleado.getText();
		String telefonoEmpleado = txtTelefonoEmpleado.getText();
		String identificacionEmpleado = txtDocumentoEmpleado.getText();
		String direccionEmpleado = txtDireccionEmpleado.getText();
		String celularEmpleado = txtCelularEmpleado.getText();
		String ciudadEmpleado = txtCiudadEmpleado.getText();
		String departamentoEmpleado = txtDepartamentoEmpleado.getText();
		String paisEmpleado = txtPaisEmpleado.getText();
		String emailEmpleado = txtEmailEmpleado.getText();
		//String tipoEmpleado = txtTipoEmpleado.getText();
		String aniosXp = txtAniosExperiencia.getText();
		String tipoEmpleado = choiceBoxEmpleado.getSelectionModel().getSelectedItem();

		if (validarDatosEmpleado(identificacionEmpleado, nombreEmpleado, telefonoEmpleado, celularEmpleado,
				direccionEmpleado, ciudadEmpleado, departamentoEmpleado, paisEmpleado, emailEmpleado, tipoEmpleado,
				aniosXp)) {

			Empleado employee = null;
			employee = aplicacion.registrarAEmpleado(identificacionEmpleado, nombreEmpleado, telefonoEmpleado,
					celularEmpleado, direccionEmpleado, ciudadEmpleado, departamentoEmpleado, paisEmpleado,
					emailEmpleado, tipoEmpleado, aniosXp);

			if (employee != null) {
				listaEmpleados.add(employee);
				showMessage("Notificación.", "Registro completado.", "Empleado registrado con exito.",
						AlertType.INFORMATION);
			} else {
				showMessage("Notificación.", "¡Algo ocurrio! El registro no se pudó completar.",
						"El empleado no se pudo registrado con exito.", AlertType.INFORMATION);
			}

		}

	}

	/**
	 * Registra la informacion del prestamo
	 */
	private void registrarPrestamo() {
		String prestamoCodigo = txtCódigoPrestamo.getText();
		String prestamoEstado = comboBoxEstadoPres.getSelectionModel().getSelectedItem();
		//String prestamoEstado = txtEstadoPrestamo.getText();
		String valorPrestamo = txtValorPrestamo.getText();
		//String fechaPrestamo = txtFechaPrestamo.getText();
		String fechaPrestamo = dpFechaPrestamo.getValue().toString();
		//String fechaEntrega = txtFechaEntrega.getText();
		String fechaEntrega = dpFechaEntrega.getValue().toString();
		String cliente = txtCliente.getText();
		String empleado = txtEmpleado.getText();
		String producto = txtObjetos.getText();
		String diasSolicitados = txtDiasSolicitados.getText();
		String diasTranscurridos = txtDiasTranscurridos.getText();

		if (validarDatosPrestamo(prestamoCodigo, prestamoEstado, valorPrestamo, fechaPrestamo, fechaEntrega, cliente,
				empleado, producto, diasSolicitados, diasTranscurridos)) {

			Cliente clienteEncontrado = aplicacion.buscarCliente(cliente);
			Empleado empleadoEncontrado = aplicacion.buscarEmpleado(empleado);
			Objeto objetoEncontrado = aplicacion.buscarObjeto(producto);

			int diasTrans = Integer.parseInt(diasTranscurridos);
			int diasSoli = Integer.parseInt(diasSolicitados);

			Prestamo loan = null;

			if (objetoEncontrado.getUnidadesDisponibles() > 0) {
				loan = aplicacion.registrarAPrestamo(prestamoCodigo, prestamoEstado, valorPrestamo, fechaPrestamo,
						fechaEntrega, clienteEncontrado, empleadoEncontrado, objetoEncontrado, diasTrans, diasSoli);

				objetoEncontrado.setUnidadesDisponibles(objetoEncontrado.getUnidadesDisponibles() - 1);
				objetoEncontrado.setUnidadesPrestadas(objetoEncontrado.getUnidadesPrestadas() + 1);

				if (loan != null) {
					listaPrestamos.add(loan);
					showMessage("Notificación.", "Registro completado.", "Prestamo registrado con exito.",
							AlertType.INFORMATION);
				} else {
					showMessage("Notificación.", "¡Algo ocurrio! El registro no se pudó completar.",
							"El prestamo no se pudo registrado con exito.", AlertType.INFORMATION);
				}

			} else {
				showMessage("Notificación.", "¡Algo ocurrio!", "No hay unidades disponibles.", AlertType.INFORMATION);

			}

		}

	}

	/**
	 * Metodo para actualizar los datos de clientes
	 * @throws CustomerExistException en caso de que el cliente no exista esta
	 * exception saltara.
	 */
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
		//String generoCliente = txtGenero.getText();
		String generoCliente = ((RadioButton)generoC.getSelectedToggle()).getText();

		if (clienteSeleccionado != null) {
			if (validarDatosCliente2(nombreCliente, telefonoCliente, identificacionCliente, direccionCliente,
					celularCliente, clienteCiudad, clienteDepartamento, clientePais, emailCliente, profesionCliente)) {

				aplicacion.actualizarAcliente(clienteSeleccionado.getDocumento(), identificacionCliente, nombreCliente,
						telefonoCliente, celularCliente, direccionCliente, clienteCiudad,
						clienteDepartamento, clientePais, emailCliente, profesionCliente, generoCliente);

				tblListCostumer.refresh();

				showMessage("Notificación.", "Actualizacion Completada", "Se ha actualizado con exito.",
						AlertType.INFORMATION);
			}
		} else {
			showMessage("Notificación.", "Actualizacion incompleta", "No se ha podido actualizar el cliente",
					AlertType.INFORMATION);

		}

	}

	/**
	 * Metodo para actualizar los datos de los objetos o productos
	 * @throws ProductExistException en caso de que el objeto no exista esta
	 * excepcion saltara.
	 */
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

		if (objetoSeleccionado != null) {
			if (validarDatosObjeto2(nameProduct, productCode, productWeight, conditionProduct, productValue,
					productDescription, productColor, objetoTipo, unidadesDis, unidadesPres)) {

				int unidadesDisponibles = Integer.parseInt(unidadesDis);
				int unidadesPrestadas = Integer.parseInt(unidadesPres);

				aplicacion.actualizarAProducto(objetoSeleccionado.getCodigo(), productCode, nameProduct, productColor,
						productWeight, productValue, conditionProduct, objetoTipo, productDescription,
						unidadesDisponibles, unidadesPrestadas);

				showMessage("Notificación.", "Actualizacion Completada", "Se ha actualizado con exito.",
						AlertType.INFORMATION);
				tblListProduct.refresh();
			}
		} else {
			showMessage("Notificación.", "Actualizacion incompleta", "No se ha podido actualizar la información.",
					AlertType.INFORMATION);
		}

	}

	// Actualizar al empleado
	private void actualizarEmpleado() throws EmployeeExistException {
		String nombreEmpleado = txtNombreEmpleado.getText();
		String telefonoEmpleado = txtTelefonoEmpleado.getText();
		String identificacionEmpleado = txtDocumentoEmpleado.getText();
		String direccionEmpleado = txtDireccionEmpleado.getText();
		String celularEmpleado = txtCelularEmpleado.getText();
		String ciudadEmpleado = txtCiudadEmpleado.getText();
		String departamentoEmpleado = txtDepartamentoEmpleado.getText();
		String paisEmpleado = txtPaisEmpleado.getText();
		String emailEmpleado = txtEmailEmpleado.getText();
		//String tipoEmpleado = txtTipoEmpleado.getText();
		String aniosXp = txtAniosExperiencia.getText();
		String tipoEmpleado = choiceBoxEmpleado.getSelectionModel().getSelectedItem();

		if (empleadoSeleccionado != null) {
			if (validarDatosEmpleado2(identificacionEmpleado, nombreEmpleado, telefonoEmpleado, celularEmpleado,
					direccionEmpleado, ciudadEmpleado, departamentoEmpleado, paisEmpleado, emailEmpleado, tipoEmpleado,
					aniosXp)) {

				aplicacion.actualizarAEmpleado(empleadoSeleccionado.getDocumento(), identificacionEmpleado, nombreEmpleado,
						telefonoEmpleado, celularEmpleado, direccionEmpleado, ciudadEmpleado, departamentoEmpleado,
						paisEmpleado, emailEmpleado, tipoEmpleado, aniosXp);
				showMessage("Notificación.", "Actualizacion Completada", "Se ha actualizado con exito.",
						AlertType.INFORMATION);
				tblListEmployee.refresh();
			}
		} else {
			showMessage("Notificación.", "Actualizacion incompleta", "No se ha podido actualizar la información.",
					AlertType.INFORMATION);
		}

	}

	//Actualizar un prestamo
	private void actualizarPrestamo() throws LoanExistException {
		String prestamoCodigo = txtCódigoPrestamo.getText();
		String prestamoEstado = comboBoxEstadoPres.getSelectionModel().getSelectedItem();
		String valorPrestamo = txtValorPrestamo.getText();
		String fechaPrestamo = dpFechaPrestamo.getValue().toString();
		String fechaEntrega = dpFechaEntrega.getValue().toString();
		String cliente = txtCliente.getText();
		String empleado = txtEmpleado.getText();
		String producto = txtObjetos.getText();
		String diasSolicitados = txtDiasSolicitados.getText();
		String diasTranscurridos = txtDiasTranscurridos.getText();
		
		if (prestamoSeleccionado != null) {
			if (validarDatosPrestamo2(prestamoCodigo, prestamoEstado, valorPrestamo, fechaPrestamo, fechaEntrega, cliente,
				empleado, producto, diasSolicitados, diasTranscurridos)) {
				
					int diasTrans = Integer.parseInt(diasTranscurridos);
					int diasSoli = Integer.parseInt(diasSolicitados);
			
					Cliente clienteEncontrado = aplicacion.buscarCliente(cliente);
					Empleado empleadoEncontrado = aplicacion.buscarEmpleado(empleado);
					Objeto objetoEncontrado = aplicacion.buscarObjeto(producto);
					
					if(objetoEncontrado.getUnidadesDisponibles() > 0) {

					aplicacion.actualizarPrestamo(prestamoSeleccionado.getCodigo(), prestamoCodigo, valorPrestamo, fechaPrestamo, fechaEntrega,
					prestamoEstado, clienteEncontrado, empleadoEncontrado, objetoEncontrado, diasTrans, diasSoli);

					showMessage("Notificación.", "Actualizacion Completada", "Se ha actualizado con exito.",
							AlertType.INFORMATION);
					tblListLoan.refresh();
		}else {
			showMessage("Notificación.", "Actualizacion incompletada", "No hay unidades disponibles.",
					AlertType.INFORMATION);
		}
			}
	} else {
		showMessage("Notificación.", "Actualizacion incompleta", "No se ha podido actualizar la información.",
				AlertType.INFORMATION);
	}
		}
	
	/**
	 * Metodo para eliminar cliente
	 */
	private void eliminarCliente() {
		if(clienteSeleccionado != null) {
			int i = 0;
			boolean clienteTienePrestamos = aplicacion.obtenerClientePrestamo(clienteSeleccionado);
			i = aplicacion.eliminarACliente(clienteSeleccionado.getDocumento());
			if(clienteTienePrestamos == false) {
			if(i>=0) {
				listaClientes.remove(i);
				showMessage("Notificación.", "Eliminacion Completada", "Se ha eliminado con exito.",
						AlertType.INFORMATION);
			}
		}else {
			showMessage("Notificación.", "Eliminacion incompleta", "El cliente tiene prestamos activos.",
					AlertType.WARNING);
		}
			}
		else {
			showMessage("Notificación.", "Eliminacion incompleta", "Seleccione un cliente.",
					AlertType.WARNING);
		}
	}
	
	/**
	 * Metodo para eliminar un empleado
	 */
	private void eliminarEmpleado() {
		if(empleadoSeleccionado != null) {
			int i = 0;
			boolean empleadoTienePrestamos = aplicacion.obtenerEmpleadoPrestamo(empleadoSeleccionado);
			i = aplicacion.eliminarAEmpleado(empleadoSeleccionado.getDocumento());
			if(empleadoTienePrestamos == false) {
			if(i >= 0) {
				listaEmpleados.remove(i);
				showMessage("Notificación.", "Eliminacion Completada", "Se ha eliminado con exito.",
						AlertType.INFORMATION);
			}
		}else {
			showMessage("Notificación.", "Eliminacion incompleta", "El empleado ha realizado prestamos.",
					AlertType.WARNING);
		}
			}else {
			showMessage("Notificación.", "Eliminacion incompleta", "Seleccione un empleado.",
					AlertType.WARNING);
		}
	}
	
	/**
	 * Metodo para eliminar un objeto
	 */
	private void eliminarObjeto() {
		if(objetoSeleccionado != null) {
			int i = 0;
			boolean objetoTienePrestamos = aplicacion.obtenerObjetoPrestamo(objetoSeleccionado);
			i = aplicacion.eliminarAObjeto(objetoSeleccionado.getCodigo());
			if(objetoTienePrestamos == false) {
			if(i >= 0) {
				listaProductos.remove(i);
				showMessage("Notificación.", "Eliminacion Completada", "Se ha eliminado con exito.",
						AlertType.INFORMATION);
			}
		}else {
			showMessage("Notificación.", "Eliminacion incompleta", "El objeto esta en algun prestamo.",
					AlertType.WARNING);
		}
			}else {
			showMessage("Notificación.", "Eliminacion incompleta", "Seleccione un objeto.",
					AlertType.WARNING);
		}
	}
	
	/**
	 * Metodo para eliminar un prestamo
	 */
	private void eliminarPrestamo() {
		if(prestamoSeleccionado != null) {
			if(prestamoSeleccionado.getEstadoPrestamo().equalsIgnoreCase("Entregado")) {
			int i = 0;
			i = aplicacion.eliminarAPrestamo(prestamoSeleccionado.getCodigo());
			if(i >= 0) {
				prestamoSeleccionado.getObjeto().setUnidadesDisponibles(prestamoSeleccionado.getObjeto().getUnidadesDisponibles() +1);
				prestamoSeleccionado.getObjeto().setUnidadesPrestadas(prestamoSeleccionado.getObjeto().getUnidadesPrestadas() -1);
				listaPrestamos.remove(i);
				
				showMessage("Notificación.", "Eliminacion Completada", "Se ha eliminado con exito.",
						AlertType.INFORMATION);
			}
		}else {
			showMessage("Notificación.", "Eliminacion incompleta", "Este prestamo se encuentra activo.",
					AlertType.INFORMATION);
		}
			}else {
			showMessage("Notificación.", "Eliminacion incompleta", "Seleccione un prestamo.",
					AlertType.WARNING);
		}
	}

	/**
	 * Metodo para verificar los datos del cliente.
	 * @param nombreCustomer nombre del cliente.
	 * @param telefonoCliente telefono del cliente.
	 * @param documentoCustomer documento del cliente.
	 * @param direccionCustomer direccion del cliente.
	 * @param celularCustomer celular del cliente .
	 * @param ciudadCustomer ciudad del cliente.
	 * @param departamentoCustomer departamento del cliente.
	 * @param paisCustomer pasis del cliente.
	 * @param emailCustomer email del cliente.
	 * @param profesioCustomer profesion del cliente.
	 * @param generoCliente genero del cliente.
	 * @return true en caso de datos correctos, false en caso de datos incorrectos 
	 * mas la ubicacion del error.
	 */
	private boolean validarDatosCliente(String nombreCustomer, String telefonoCliente, String documentoCustomer,
			String direccionCustomer, String celularCustomer, String ciudadCustomer, String departamentoCustomer,
			String paisCustomer, String emailCustomer, String profesioCustomer, String generoCliente) {
		String mensaje = "";

		if (nombreCustomer == null || nombreCustomer.equals("") || nombreCustomer.matches("[0-9]+")) {
			mensaje += "NOMBRE NO VALIDO.\n";
		}
		if (telefonoCliente == null || telefonoCliente.equals("") || telefonoCliente.matches("[a-zA-Z]+")) {
			mensaje += "TELEFONO NO VALIDO\n";
		}
		if (direccionCustomer == null || direccionCustomer.equals("")) {
			mensaje += "DIRECCION NO VALIDA.\n";
		}
		if (documentoCustomer == null || documentoCustomer.equals("") || documentoCustomer.matches("[a-zA-Z]+")) {
			mensaje += "CEDULA NO VALIDA.\n";
		} else {
			if (clienteSeleccionado != null) {
				if (!documentoCustomer.equals(clienteSeleccionado.getDocumento())) {
					if (aplicacion.verifyIdentificacionCliente(documentoCustomer)) {
						mensaje += "¡ESE DOCUMENTO YA EXISTE!";
					}
				}
			} else {
				if (aplicacion.verifyIdentificacionCliente(documentoCustomer)) {
					mensaje += "¡ESA DOCUMENTO YA EXISTE!";
				}
			}
		}
		if (celularCustomer == null || celularCustomer.equals("") || celularCustomer.matches("[a-zA-Z]+")) {
			mensaje += "CELULAR NO VALIDO\n";
		}
		if (ciudadCustomer == null || ciudadCustomer.equals("") || ciudadCustomer.matches("[0-9]+")) {
			mensaje += "CIUDAD NO VALIDA\n";
		}
		if (departamentoCustomer == null || departamentoCustomer.equals("")) {
			mensaje += "DEPARTAMENTO NO VALIDO\n";
		}
		if (paisCustomer == null || paisCustomer.equals("") || paisCustomer.matches("[0-9]+")) {
			mensaje += "PAIS NO VALIDO\n";
		}
		if (emailCustomer == null || emailCustomer.equals("") || !emailCustomer.contains("@")) {
			mensaje += "EMAIL NO VALIDO\n";
		}
		if (profesioCustomer == null || profesioCustomer.equals("") || profesioCustomer.matches("[0-9]+")) {
			mensaje += "PROFESIÓN NO VALIDA\n";
		}
		
		if (mensaje.equals("")) {
			return true;
		} else {

			showMessage("Notificación.", "DATOS INCORRECTOS.", mensaje, AlertType.WARNING);
			return false;
		}
	}

	// Valida los datos para la actulización del cliente
	private boolean validarDatosCliente2(String nameCustomer, String telefonoCliente, String customerIdentification,
			String customerAddress, String cellPhoneClient, String clientCity, String customerDepartment,
			String clientCountry, String emailCustomer, String profesioCustomer) {
		String mensaje = "";

		if (nameCustomer == null || nameCustomer.equals("") || nameCustomer.matches("[0-9]+")) {
			mensaje += "NOMBRE NO VALIDO.\n";
		}
		if (telefonoCliente == null || telefonoCliente.equals("") || telefonoCliente.matches("[a-zA-Z]+")) {
			mensaje += "TELEFONO NO VALIDO\n";
		}
		if (customerAddress == null || customerAddress.equals("")) {
			mensaje += "DIRECCION NO VALIDA.\n";
		}
		if (customerIdentification == null || customerIdentification.equals("")
				|| customerIdentification.matches("[a-zA-Z]+")) {
			mensaje += "CEDULA NO VALIDA.\n";
		} else {
			if (clienteSeleccionado != null) {
				if (!customerIdentification.equals(clienteSeleccionado.getDocumento())) {
					if (aplicacion.verifyIdentificacionCliente(customerIdentification)) {
						mensaje += "¡ESE DOCUMENTO YA EXISTE!";
					}
				}
			} else {
				if (aplicacion.verifyIdentificacionCliente(customerIdentification)) {
					mensaje += "¡ESA DOCUMENTO YA EXISTE!";
				}
			}
		}
		if (cellPhoneClient == null || cellPhoneClient.equals("") || cellPhoneClient.matches("[a-zA-Z]+")) {
			mensaje += "CELULAR NO VALIDO\n";
		}
		if (clientCity == null || clientCity.equals("") || clientCity.matches("[0-9]+")) {
			mensaje += "CIUDAD NO VALIDA\n";
		}
		if (customerDepartment == null || customerDepartment.equals("")) {
			mensaje += "DEPARTAMENTO NO VALIDO\n";
		}
		if (clientCountry == null || clientCountry.equals("") || clientCountry.matches("[0-9]+")) {
			mensaje += "PAIS NO VALIDO\n";
		}
		if (emailCustomer == null || emailCustomer.equals("") || !emailCustomer.contains("@")) {
			mensaje += "EMAIL NO VALIDO\n";
		}
		if (profesioCustomer == null || profesioCustomer.equals("") || profesioCustomer.matches("[0-9]+")) {
			mensaje += "PROFESIÓN NO VALIDA\n";
		}

		if (mensaje.equals("")) {
			return true;
		} else {

			showMessage("Notificación.", "DATOS INCORRECTOS.", mensaje, AlertType.WARNING);
			return false;
		}
	}

	/**
	 * Metodo para validar los datos de un objeto o producto
	 * @param nameProduct nombre del objeto
	 * @param productCode codigo del objeto
	 * @param productWeight peso del objeto
	 * @param conditionProduct estado del objeto
	 * @param productValue valor del objeto
	 * @param productDescription descripcion del objeto
	 * @param productColor color del objeto
	 * @param objetoTipo tipo del objeto
	 * @param unidadesDis unidades disponibles del objeto
	 * @param unidadesPres unidades prestadas del objeto
	 * @return true en caso de datos correctos, false en caso de datos incorrectos 
	 * mas la ubicacion del error.
	 */
	private boolean validarDatosObjeto(String nameProduct, String productCode, String productWeight,
			String conditionProduct, String productValue, String productDescription, String productColor,
			String objetoTipo, String unidadesDis, String unidadesPres) {

		String mensaje = "";

		if (nameProduct == null || nameProduct.equals("") || nameProduct.matches("[0-9]+")) {
			mensaje += "NOMBRE NO VALIDO.\n";
		}
		if (productCode == null || productCode.equals("") || productCode.matches("[a-zA-Z]+")) {
			mensaje += "CÓDIGO NO VALIDO.\n";
		} else {
			if (objetoSeleccionado != null) {
				if (productCode.equals(objetoSeleccionado.getCodigo())) {
					if (aplicacion.verifyCodigoProducto(productCode)) {
						mensaje += "¡ESE CÓDIGO YA EXISTE!";
					}
				}
			} else {
				if (aplicacion.verifyCodigoProducto(productCode)) {
					mensaje += "¡ESA CÓDIGO YA EXISTE!";
				}
			}
		}
		if (productWeight == null || productWeight.equals("")) {
			mensaje += "¡PESO NO VALIDO!";
		}
		if (conditionProduct == null || conditionProduct.equals("") || conditionProduct.matches("[0-9]+")) {
			mensaje += "¡CONDICIÓN NO VALIDA!";
		}
		if (productValue == null || productValue.equals("") || productValue.matches("[a-zA-z]")) {
			mensaje += "¡VALOR NO VALIDO!";
		}
		if (productDescription == null || productDescription.equals("")) {
			mensaje += "¡INGRESE LA CONDICIÓN DEL PRODUCTO!";
		}
		if (productColor == null || productColor.equals("") || productColor.matches("[0-9]+")) {
			mensaje += "COLOR NO VALIDO.\n";
		}
		if (objetoTipo == null || objetoTipo.equals("") || objetoTipo.matches("[0-9]+")) {
			mensaje += "¡VALOR TOTAL NO VALIDO!";
		}
		if (unidadesDis == null || unidadesDis.equals("") || unidadesDis.matches("[a-zA-Z]+")) {
			mensaje += "¡UNIDADES DISPONIBLES NO VALIDAS!";
		}
		if (unidadesPres == null || unidadesPres.equals("") || unidadesPres.matches("[a-zA-Z]+")) {
			mensaje += "¡UNIDADES PRESTADAS NO VALIDAS!";
		}
		if (mensaje.equals("")) {
			return true;
		} else {

			showMessage("Notificación.", "DATOS INCORRECTOS.", mensaje, AlertType.WARNING);
			return false;
		}
	}

	// Vaiida los datos para la actualización de un objeto
	private boolean validarDatosObjeto2(String nameProduct, String productCode, String productWeight,
			String conditionProduct, String productValue, String productDescription, String productColor,
			String objetoTipo, String unidadesDis, String unidadesPres) {
		String mensaje = "";

		if (nameProduct == null || nameProduct.equals("") || nameProduct.matches("[0-9]+")) {
			mensaje += "NOMBRE NO VALIDO.\n";
		}
		if (productCode == null || productCode.equals("") || productCode.matches("[a-zA-Z]+")) {
			mensaje += "CÓDIGO NO VALIDO.\n";
		} else {
			if (objetoSeleccionado != null) {
				if (!productCode.equals(objetoSeleccionado.getCodigo())) {
					if (aplicacion.verifyCodigoProducto(productCode)) {
						mensaje += "¡ESE CÓDIGO YA EXISTE!";
					}
				}
			}
		}
		if (productWeight == null || productWeight.equals("")) {
			mensaje += "¡PESO NO VALIDO!";
		}
		if (conditionProduct == null || conditionProduct.equals("") || conditionProduct.matches("[0-9]+")) {
			mensaje += "¡CONDICIÓN NO VALIDA!";
		}
		if (productValue == null || productValue.equals("") || productValue.matches("[a-zA-z]")) {
			mensaje += "¡VALOR NO VALIDO!";
		}
		if (productDescription == null || productDescription.equals("")) {
			mensaje += "¡INGRESE LA CONDICIÓN DEL PRODUCTO!";
		}
		if (productColor == null || productColor.equals("") || productColor.matches("[0-9]+")) {
			mensaje += "COLOR NO VALIDO.\n";
		}
		if (objetoTipo == null || objetoTipo.equals("") || objetoTipo.matches("[0-9]+")) {
			mensaje += "¡VALOR TOTAL NO VALIDO!";
		}
		if (unidadesDis == null || unidadesDis.equals("") || unidadesDis.matches("[a-zA-Z]+")) {
			mensaje += "¡UNIDADES DISPONIBLES NO VALIDAS!";
		}
		if (unidadesPres == null || unidadesPres.equals("") || unidadesPres.matches("[a-zA-Z]+")) {
			mensaje += "¡UNIDADES PRESTADAS NO VALIDAS!";
		}

		if (mensaje.equals("")) {
			return true;
		} else {

			showMessage("Notificación.", "DATOS INCORRECTOS.", mensaje, AlertType.WARNING);
			return false;
		}
	}

	/**
	 * Metodo para validar los datos de un empleado
	 * @param documento del empleado
	 * @param nombre del empleado
	 * @param telefono del empleado
	 * @param celular del empleado
	 * @param direccion del empleado
	 * @param ciudadResidencia del empleado
	 * @param departamento del empleado
	 * @param pais del empleado
	 * @param mail del empleado
	 * @param tipoEmpleado del empleado
	 * @param aniosExperiencia del empleado
	 * @return true en caso de datos correctos, false en caso de datos incorrectos 
	 * mas la ubicacion del error.
	 */
	private boolean validarDatosEmpleado(String documento, String nombre, String telefono, String celular,
			String direccion, String ciudadResidencia, String departamento, String pais, String mail,
			String tipoEmpleado, String aniosExperiencia) {

		String mensaje = "";

		if (nombre == null || nombre.equals("") || nombre.matches("[0-9]+")) {
			mensaje += "NOMBRE NO VALIDO.\n";
		}
		if (telefono == null || telefono.equals("") || telefono.matches("[a-zA-Z]+")) {
			mensaje += "TELEFONO NO VALIDO\n";
		}
		if (direccion == null || direccion.equals("")) {
			mensaje += "DIRECCION NO VALIDA.\n";
		}
		if (documento == null || documento.equals("") || documento.matches("[a-zA-Z]+")) {
			mensaje += "CEDULA NO VALIDA.\n";
		} else {
			if (empleadoSeleccionado != null) {
				if (!documento.equals(empleadoSeleccionado.getDocumento())) {
					if (aplicacion.verifyIdentificacionEmpleado(documento)) {
						mensaje += "¡ESE DOCUMENTO YA EXISTE!";
					}
				}
			} else {
				if (aplicacion.verifyIdentificacionEmpleado(documento)) {
					mensaje += "¡ESA DOCUMENTO YA EXISTE!";
				}
			}
		}
		if (celular == null || celular.equals("") || celular.matches("[a-zA-Z]+")) {
			mensaje += "CELULAR NO VALIDO\n";
		}
		if (ciudadResidencia == null || ciudadResidencia.equals("") || ciudadResidencia.matches("[0-9]+")) {
			mensaje += "CIUDAD NO VALIDA\n";
		}
		if (departamento == null || departamento.equals("")) {
			mensaje += "DEPARTAMENTO NO VALIDO\n";
		}
		if (pais == null || pais.equals("") || pais.matches("[0-9]+")) {
			mensaje += "PAIS NO VALIDO\n";
		}
		if (mail == null || mail.equals("") || !mail.contains("@")) {
			mensaje += "EMAIL NO VALIDO\n";
		}
		if (tipoEmpleado == null || tipoEmpleado.equals("") || tipoEmpleado.matches("[0-9]+")) {
			mensaje += "PROFESIÓN NO VALIDA\n";
		}
		if (aniosExperiencia == null || aniosExperiencia.equals("")) {
			mensaje += "AÑOS DE EXPERIENCIA NO VALIDOS.\n";
		}

		if (mensaje.equals("")) {
			return true;
		} else {

			showMessage("Notificación.", "DATOS INCORRECTOS.", mensaje, AlertType.WARNING);
			return false;
		}
	}

	// Validación de datos para actualizar al empleado
	private boolean validarDatosEmpleado2(String documento, String nombre, String telefono, String celular,
			String direccion, String ciudadResidencia, String departamento, String pais, String mail,
			String tipoEmpleado, String aniosExperiencia) {

		String mensaje = "";

		if (nombre == null || nombre.equals("") || nombre.matches("[0-9]+")) {
			mensaje += "NOMBRE NO VALIDO.\n";
		}
		if (telefono == null || telefono.equals("") || telefono.matches("[a-zA-Z]+")) {
			mensaje += "TELEFONO NO VALIDO\n";
		}
		if (celular == null || celular.equals("") || celular.matches("[a-zA-Z]+")) {
			mensaje += "CELULAR NO VALIDO\n";
		}
		if (direccion == null || direccion.equals("")) {
			mensaje += "DIRECCION NO VALIDA.\n";
		}
		if (documento == null || documento.equals("") || documento.matches("[a-zA-Z]+")) {
			mensaje += "CEDULA NO VALIDA.\n";
		} else {
			if (empleadoSeleccionado != null) {
				if (!documento.equals(empleadoSeleccionado.getDocumento())) {
					if (aplicacion.verifyIdentificacionEmpleado(documento)) {
						mensaje += "¡ESE DOCUMENTO YA EXISTE!";
					}
				}
			}
		}
		if (ciudadResidencia == null || ciudadResidencia.equals("") || ciudadResidencia.matches("[0-9]+")) {
			mensaje += "CIUDAD NO VALIDA\n";
		}
		if (departamento == null || departamento.equals("")) {
			mensaje += "DEPARTAMENTO NO VALIDO\n";
		}
		if (pais == null || pais.equals("") || pais.matches("[0-9]+")) {
			mensaje += "PAIS NO VALIDO\n";
		}
		if (mail == null || mail.equals("") || !mail.contains("@")) {
			mensaje += "EMAIL NO VALIDO\n";
		}
		if (tipoEmpleado == null || tipoEmpleado.equals("") || tipoEmpleado.matches("[0-9]+")) {
			mensaje += "PROFESIÓN NO VALIDA\n";
		}
		if (aniosExperiencia == null || aniosExperiencia.equals("")) {
			mensaje += "AÑOS DE EXPERIENCIA NO VALIDOS.\n";
		}

		if (mensaje.equals("")) {
			return true;
		} else {

			showMessage("Notificación.", "DATOS INCORRECTOS.", mensaje, AlertType.WARNING);
			return false;
		}
	}

	/**
	 * Metodo para velidar los datos del prestamo
	 * @param loanCode codigo del prestamo
	 * @param loanCondition estado del prestamo
	 * @param loanValue valor del prestamo
	 * @param loanDate fecha del prestamo
	 * @param expirationDate fecha de entrega del prestamo 
	 * @param customer cliente que realizo el prestamo
	 * @param employee empleado que realizo el prestamo
	 * @param product producto que fue prestado
	 * @param diasSolicitados dias solicitados 
	 * @param diasTranscurridos dias transcurridos
	 * @return true en caso de datos correctos, false en caso de datos incorrectos 
	 * mas la ubicacion del error.
	 */
	private boolean validarDatosPrestamo(String loanCode, String loanCondition, String loanValue, String loanDate,
			String expirationDate, String customer, String employee, String product, String diasSolicitados,
			String diasTranscurridos) {

		String mensaje = "";
		String estado1 = "Entregado";
		String estado2 = "Falta por entregar";
		if (loanCode == null || loanCode.equals("") || loanCode.matches("[a-zA-Z]")) {
			mensaje += "¡CÓDIGO NO VALIDO!";
		} else {
			if (prestamoSeleccionado != null) {
				if (!loanCode.equals(prestamoSeleccionado.getCodigo())) {
					if (aplicacion.verifyCodigoPrestamo(loanCode)) {
						mensaje += "¡ESTE CÓDIGO YA ESTÁ REGISTRADO!";
					}
				}
			} else {
				if (aplicacion.verifyCodigoPrestamo(loanCode)) {
					mensaje += "¡ESTE CÓDIGO YA ESTÁ REGISTRADO!";
				}
			}
		}
		if (!loanCondition.equalsIgnoreCase(estado1) || loanCondition == null || loanCondition.equals("")) {
			if (!loanCondition.equalsIgnoreCase(estado2)) {
				mensaje += "¡ESTADO INVALIDO!";
			}
		}
		if (loanValue == null || loanValue.equals("") || loanValue.matches("[a-zA-Z]")) {
			mensaje += "¡VALOR INVALIDO!";
		}
		if (loanDate == null || loanDate.equals("") ) {
			mensaje += "¡FECHA INVALIDA!";
		}
		if (expirationDate == null || expirationDate.equals("") ) {
			mensaje += "¡FECHA DE ENTREGA INVALIDA!";
		}
		if (!aplicacion.verifyIdentificacionCliente(customer) || customer == null || customer.equals("")
				|| customer.matches(("[a-zA-Z]"))) {
			mensaje += "¡CLIENTE INVALIDO!";
		}
		if (!aplicacion.verifyIdentificacionEmpleado(employee) || employee == null || employee.equals("")
				|| employee.matches(("[a-zA-Z]"))) {
			mensaje += "¡EMPLEADO INVALIDO!";
		}
		if (!aplicacion.verifyCodigoProducto(product) || product == null || product.equals("")) {
			mensaje += "¡PRODUCTO INVALIDO!";
		}
		if (diasSolicitados == null || diasSolicitados.equals("") || diasSolicitados.matches("[a-zA-Z]+")) {
			mensaje += "¡DATOS INVALIDOS!";
		}
		if (diasTranscurridos == null || diasTranscurridos.equals("") || diasTranscurridos.matches("[a-zA-Z]+")) {
			mensaje += "¡DATOS INVALIDOS!";
		}

		if (mensaje.equals("")) {
			return true;
		} else {

			showMessage("Notificación.", "DATOS INCORRECTOS.", mensaje, AlertType.WARNING);
			return false;
		}
	}

	//Valida los datos para la actualizacion de un prestamo
	private boolean validarDatosPrestamo2(String loanCode, String loanCondition, String loanValue, String loanDate,
			String expirationDate, String customer, String employee, String product, String diasSolicitados,
			String diasTranscurridos) {

		String mensaje = "";
		String estado1 = "Entregado";
		String estado2 = "Falta por entregar";
		if (loanCode == null || loanCode.equals("") || loanCode.matches("[a-zA-Z]")) {
			mensaje += "¡CÓDIGO NO VALIDO!";
		} else {
			if (prestamoSeleccionado != null) {
				if (!loanCode.equals(prestamoSeleccionado.getCodigo())) {
					if (aplicacion.verifyCodigoPrestamo(loanCode)) {
						mensaje += "¡ESTE CÓDIGO YA ESTÁ REGISTRADO!";
					}
				}
			}
		}
		if (!loanCondition.equalsIgnoreCase(estado1) || loanCondition == null || loanCondition.equals("")) {
			if (!loanCondition.equalsIgnoreCase(estado2)) {
				mensaje += "¡ESTADO INVALIDO!";
			}
		}
		if (loanValue == null || loanValue.equals("") || loanValue.matches("[a-zA-Z]")) {
			mensaje += "¡VALOR INVALIDO!";
		}
		if (loanDate == null || loanDate.equals("") || loanDate.matches("[a-zA-Z]+")) {
			mensaje += "¡FECHA INVALIDA!";
		}
		if (expirationDate == null || expirationDate.equals("") || expirationDate.matches("[a-zA-Z]")) {
			mensaje += "¡FECHA DE ENTREGA INVALIDA!";
		}
		if (!aplicacion.verifyIdentificacionCliente(customer) || customer == null || customer.equals("")
				|| customer.matches(("[a-zA-Z]"))) {
			mensaje += "¡CLIENTE INVALIDO!";
		}
		if (!aplicacion.verifyIdentificacionEmpleado(employee) || employee == null || employee.equals("")
				|| employee.matches(("[a-zA-Z]"))) {
			mensaje += "¡EMPLEADO INVALIDO!";
		}
		if (!aplicacion.verifyCodigoProducto(product) || product == null || product.equals("")) {
			mensaje += "¡PRODUCTO INVALIDO!";
		}
		if (diasSolicitados == null || diasSolicitados.equals("") || diasSolicitados.matches("[a-zA-Z]+")) {
			mensaje += "¡DATOS INVALIDOS!";
		}
		if (diasTranscurridos == null || diasTranscurridos.equals("") || diasTranscurridos.matches("[a-zA-Z]+")) {
			mensaje += "¡DATOS INVALIDOS!";
		}

		if (mensaje.equals("")) {
			return true;
		} else {

			showMessage("Notificación.", "DATOS INCORRECTOS.", mensaje, AlertType.WARNING);
			return false;
		}
	}
}
