package co.edu.uniquindio.gestionPrestamos.controller;

import java.net.URL;
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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
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
	private TextField txtDiasTranscurridos;

	@FXML
	private TextField txtDiasSolicitados;
	
    @FXML
    private Button btnEliminarAPrestamo;

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
	// Observables
	ObservableList<Cliente> listaClientes = FXCollections.observableArrayList();
	ObservableList<Objeto> listaProductos = FXCollections.observableArrayList();
	ObservableList<Empleado> listEmployee = FXCollections.observableArrayList();
	ObservableList<Prestamo> listLoan = FXCollections.observableArrayList();
	
	// Variables de seleccion
	private Cliente clienteSeleccionado;
	private Objeto selectedProduct;
	private Empleado selectedEmployee;
	private Prestamo selectedLoan;

	public void setAplicacion(Aplicacion aplicacion) {
		this.aplicacion = aplicacion;
		loadCustomerList();
		loadProductList();
		loadEmployeeList();
		loadLoanList();
	}

	@FXML
	void initialize() {
		// Datos de la tabla Cliente
		this.columnNombreCliente.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		this.columnDocumentoCliente.setCellValueFactory(new PropertyValueFactory<>("documento"));

		tblListCostumer.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
			clienteSeleccionado = newSelection;
			mostrarInformacionCliente(clienteSeleccionado);
		});

		this.columnNombreObjeto.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		this.columnCodigoObjeto.setCellValueFactory(new PropertyValueFactory<>("codigo"));

		tblListProduct.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
			selectedProduct = newSelection;
			mostrarInformacionObjeto(selectedProduct);
		});

		this.columnNombreEmpleado.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		this.columnDocumentoEmpleado.setCellValueFactory(new PropertyValueFactory<>("documento"));

		tblListEmployee.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
			selectedEmployee = newSelection;
			mostrarInformacionEmpleado(selectedEmployee);
		});

		this.columnValorPrestamo.setCellValueFactory(new PropertyValueFactory<>("valor"));
		this.columnCodigoPrestamo.setCellValueFactory(new PropertyValueFactory<>("codigo"));

		tblListLoan.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
			selectedLoan = newSelection;
			mostrarInformacionPrestamo(selectedLoan);
		});
		
		ArrayList<String> listaTipoEmpleado = new ArrayList<>();
		Collections.addAll(listaTipoEmpleado, new String[] {"Jefe de inventario","Empleado"});
		
		choiceBoxEmpleado.getItems().addAll(listaTipoEmpleado);
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

	// Nos muestra un tipo de alerta
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
		listaProductos.addAll(aplicacion.obtenerProductos());
		return listaProductos;
	}

	private ObservableList<Empleado> obtenerEmpleados() {
		listEmployee.addAll(aplicacion.obtenerEmpleados());
		return listEmployee;
	}

	private ObservableList<Prestamo> obtenerPrestamos() {
		listLoan.addAll(aplicacion.obtenerPrestamos());
		return listLoan;
	}

	private ObservableList<Cliente> obtenerClientes() {
		listaClientes.addAll(aplicacion.obtenerClientes());
		return listaClientes;
	}

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

	private void mostrarInformacionPrestamo(Prestamo prestamo) {

		if (prestamo != null) {
			txtCódigoPrestamo.setText(prestamo.getCodigo());
			txtEstadoPrestamo.setText(prestamo.getEstadoPrestamo());
			txtValorPrestamo.setText(prestamo.getValor());
			txtFechaPrestamo.setText(prestamo.getFechaPrestamo());
			txtFechaEntrega.setText(prestamo.getFechaEntrega());
			txtCliente.setText(prestamo.getCliente().getNombre());
			txtEmpleado.setText(prestamo.getEmpleado().getNombre());
			txtObjetos.setText(prestamo.getObjeto().getNombre());
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
		txtEstadoPrestamo.setText("");
		txtValorPrestamo.setText("");
		txtFechaPrestamo.setText("");
		txtFechaEntrega.setText("");
		txtCliente.setText("");
		txtEmpleado.setText("");
		txtObjetos.setText("");
		txtDiasSolicitados.setText("");
		txtDiasTranscurridos.setText("");
		btnRegistrarPrestamo.setDisable(false);
		btnActuliazarPrestamo.setDisable(true);
		tblListLoan.getSelectionModel().clearSelection();
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
				listEmployee.add(employee);
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
		String prestamoEstado = txtEstadoPrestamo.getText();
		String valorPrestamo = txtValorPrestamo.getText();
		String fechaPrestamo = txtFechaPrestamo.getText();
		String fechaEntrega = txtFechaEntrega.getText();
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
					listLoan.add(loan);
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
	 * 
	 * @throws CustomerExistException en caso de que el cliente no exista esta
	 *                                exception saltara.
	 * 
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
	 * 
	 * @throws ProductExistException en caso de que el objeto no exista esta
	 *                               excepcion saltara.
	 * 
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

		if (selectedProduct != null) {
			if (validarDatosObjeto2(nameProduct, productCode, productWeight, conditionProduct, productValue,
					productDescription, productColor, objetoTipo, unidadesDis, unidadesPres)) {

				int unidadesDisponibles = Integer.parseInt(unidadesDis);
				int unidadesPrestadas = Integer.parseInt(unidadesPres);

				aplicacion.updateProduct(selectedProduct.getCodigo(), productCode, nameProduct, productColor,
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

		if (selectedEmployee != null) {
			if (validarDatosEmpleado2(identificacionEmpleado, nombreEmpleado, telefonoEmpleado, celularEmpleado,
					direccionEmpleado, ciudadEmpleado, departamentoEmpleado, paisEmpleado, emailEmpleado, tipoEmpleado,
					aniosXp)) {

				aplicacion.updateEmployee(selectedEmployee.getDocumento(), identificacionEmpleado, nombreEmpleado,
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

	private void actualizarPrestamo() throws LoanExistException {
		String prestamoCodigo = txtCódigoPrestamo.getText();
		String prestamoEstado = txtEstadoPrestamo.getText();
		String valorPrestamo = txtValorPrestamo.getText();
		String fechaPrestamo = txtFechaPrestamo.getText();
		String fechaEntrega = txtFechaEntrega.getText();
		String cliente = txtCliente.getText();
		String empleado = txtEmpleado.getText();
		String producto = txtObjetos.getText();
		String diasSolicitados = txtDiasSolicitados.getText();
		String diasTranscurridos = txtDiasTranscurridos.getText();
		
		if (selectedLoan != null) {
			if (validarDatosPrestamo2(prestamoCodigo, prestamoEstado, valorPrestamo, fechaPrestamo, fechaEntrega, cliente,
				empleado, producto, diasSolicitados, diasTranscurridos)) {
			
			int diasTrans = Integer.parseInt(diasTranscurridos);
			int diasSoli = Integer.parseInt(diasSolicitados);
			
			Cliente clienteEncontrado = aplicacion.buscarCliente(cliente);
			Empleado empleadoEncontrado = aplicacion.buscarEmpleado(empleado);
			Objeto objetoEncontrado = aplicacion.buscarObjeto(producto);

			aplicacion.actualizarPrestamo(selectedLoan.getCodigo(), prestamoCodigo, valorPrestamo, fechaPrestamo, fechaEntrega,
					prestamoEstado, clienteEncontrado, empleadoEncontrado, objetoEncontrado, diasTrans, diasSoli);

			showMessage("Notificación.", "Actualizacion Completada", "Se ha actualizado con exito.",
					AlertType.INFORMATION);
			tblListLoan.refresh();
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
			i = aplicacion.eliminarCliente(clienteSeleccionado.getDocumento());
			if(i>=0) {
				listaClientes.remove(i);
				showMessage("Notificación.", "Eliminacion Completada", "Se ha eliminado con exito.",
						AlertType.INFORMATION);
			}
		}else {
			showMessage("Notificación.", "Eliminacion incompleta", "Seleccione un cliente.",
					AlertType.WARNING);
		}
	}
	
	private void eliminarEmpleado() {
		if(selectedEmployee != null) {
			int i = 0;
			i = aplicacion.eliminarEmpleado(selectedEmployee.getDocumento());
			if(i >= 0) {
				listEmployee.remove(i);
				showMessage("Notificación.", "Eliminacion Completada", "Se ha eliminado con exito.",
						AlertType.INFORMATION);
			}
		}else {
			showMessage("Notificación.", "Eliminacion incompleta", "Seleccione un cliente.",
					AlertType.WARNING);
		}
	}
	
	private void eliminarObjeto() {
		if(selectedProduct != null) {
			int i = 0;
			i = aplicacion.eliminarObjeto(selectedProduct.getCodigo());
			if(i >= 0) {
				listaProductos.remove(i);
				showMessage("Notificación.", "Eliminacion Completada", "Se ha eliminado con exito.",
						AlertType.INFORMATION);
			}
		}else {
			showMessage("Notificación.", "Eliminacion incompleta", "Seleccione un cliente.",
					AlertType.WARNING);
		}
	}
	
	private void eliminarPrestamo() {
		if(selectedLoan != null) {
			int i = 0;
			i = aplicacion.eliminarPrestamo(selectedLoan.getCodigo());
			if(i >= 0) {
				listLoan.remove(i);
				showMessage("Notificación.", "Eliminacion Completada", "Se ha eliminado con exito.",
						AlertType.INFORMATION);
			}
		}else {
			showMessage("Notificación.", "Eliminacion incompleta", "Seleccione un cliente.",
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
					if (aplicacion.verifyIdentificationClient(documentoCustomer)) {
						mensaje += "¡ESE DOCUMENTO YA EXISTE!";
					}
				}
			} else {
				if (aplicacion.verifyIdentificationClient(documentoCustomer)) {
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

	// Valida los para la actulización del cliente
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
					if (aplicacion.verifyIdentificationClient(customerIdentification)) {
						mensaje += "¡ESE DOCUMENTO YA EXISTE!";
					}
				}
			} else {
				if (aplicacion.verifyIdentificationClient(customerIdentification)) {
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
	 * Valida los datos del producto
	 * 
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
			if (selectedProduct != null) {
				if (productCode.equals(selectedProduct.getCodigo())) {
					if (aplicacion.verifyCodeProduct(productCode)) {
						mensaje += "¡ESE CÓDIGO YA EXISTE!";
					}
				}
			} else {
				if (aplicacion.verifyCodeProduct(productCode)) {
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

	// Vaiida los datos para la actualización
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
			if (selectedProduct != null) {
				if (!productCode.equals(selectedProduct.getCodigo())) {
					if (aplicacion.verifyCodeProduct(productCode)) {
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

	// Valida la informacion
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
			if (selectedEmployee != null) {
				if (!documento.equals(selectedEmployee.getDocumento())) {
					if (aplicacion.verifyIdentificationEmployee(documento)) {
						mensaje += "¡ESE DOCUMENTO YA EXISTE!";
					}
				}
			} else {
				if (aplicacion.verifyIdentificationEmployee(documento)) {
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

	// Validación de datos para acutlizar al empleado
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
			if (selectedEmployee != null) {
				if (!documento.equals(selectedEmployee.getDocumento())) {
					if (aplicacion.verifyIdentificationEmployee(documento)) {
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

	private boolean validarDatosPrestamo(String loanCode, String loanCondition, String loanValue, String loanDate,
			String expirationDate, String customer, String employee, String product, String diasSolicitados,
			String diasTranscurridos) {

		String mensaje = "";
		String estado1 = "Entregado";
		String estado2 = "Falta por entregar";
		if (loanCode == null || loanCode.equals("") || loanCode.matches("[a-zA-Z]")) {
			mensaje += "¡CÓDIGO NO VALIDO!";
		} else {
			if (selectedLoan != null) {
				if (!loanCode.equals(selectedLoan.getCodigo())) {
					if (aplicacion.verifyCodeLoan(loanCode)) {
						mensaje += "¡ESTE CÓDIGO YA ESTÁ REGISTRADO!";
					}
				}
			} else {
				if (aplicacion.verifyCodeLoan(loanCode)) {
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
		if (loanDate == null || loanDate.equals("") || loanDate.matches("[a-zA-Z]+")) {
			mensaje += "¡FECHA INVALIDA!";
		}
		if (expirationDate == null || expirationDate.equals("") || expirationDate.matches("[a-zA-Z]")) {
			mensaje += "¡FECHA DE ENTREGA INVALIDA!";
		}
		if (!aplicacion.verifyIdentificationClient(customer) || customer == null || customer.equals("")
				|| customer.matches(("[a-zA-Z]"))) {
			mensaje += "¡CLIENTE INVALIDO!";
		}
		if (!aplicacion.verifyIdentificationEmployee(employee) || employee == null || employee.equals("")
				|| employee.matches(("[a-zA-Z]"))) {
			mensaje += "¡EMPLEADO INVALIDO!";
		}
		if (!aplicacion.verifyCodeProduct(product) || product == null || product.equals("")) {
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

	private boolean validarDatosPrestamo2(String loanCode, String loanCondition, String loanValue, String loanDate,
			String expirationDate, String customer, String employee, String product, String diasSolicitados,
			String diasTranscurridos) {

		String mensaje = "";
		String estado1 = "Entregado";
		String estado2 = "Falta por entregar";
		if (loanCode == null || loanCode.equals("") || loanCode.matches("[a-zA-Z]")) {
			mensaje += "¡CÓDIGO NO VALIDO!";
		} else {
			if (selectedLoan != null) {
				if (!loanCode.equals(selectedLoan.getCodigo())) {
					if (aplicacion.verifyCodeLoan(loanCode)) {
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
		if (!aplicacion.verifyIdentificationClient(customer) || customer == null || customer.equals("")
				|| customer.matches(("[a-zA-Z]"))) {
			mensaje += "¡CLIENTE INVALIDO!";
		}
		if (!aplicacion.verifyIdentificationEmployee(employee) || employee == null || employee.equals("")
				|| employee.matches(("[a-zA-Z]"))) {
			mensaje += "¡EMPLEADO INVALIDO!";
		}
		if (!aplicacion.verifyCodeProduct(product) || product == null || product.equals("")) {
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
