package co.edu.uniquindio.gestionPrestamos.controller;

import co.edu.uniquindio.gestionPrestamos.Aplicacion;
import co.edu.uniquindio.gestionPrestamos.exception.ProductExistException;
import co.edu.uniquindio.gestionPrestamos.model.Objeto;
import co.edu.uniquindio.gestionPrestamos.model.Prestamo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

public class InventoryController {

	 @FXML
	 private TextField txtestadoObjetoInventario;

	 @FXML
	 private TextField txtnombreObjetoInventario;

	 @FXML
	 private TextField txtcodigoObjetoInventario;

	 @FXML
	 private TextField txtpesoObjetoInventario;

	 @FXML
	 private TextField txtvalorObjetoInventario;

	 @FXML
	 private TextField txtdescripcionObjetoInventario;

	 @FXML
	 private TextField txtcolorObjetoInventario;

	 @FXML
	 private TextField txtUnidadesDisInven;

	 @FXML
	 private TextField txtUnidadesPrestadasInven;
	 
	 @FXML
	 private TextField txtTipoObjetoInven;

	 @FXML
	 private TableView<Objeto> tblListInventory;

	 @FXML
	 private TableColumn<Objeto, String> columnNombreInventario;

	 @FXML
	 private TableColumn<Objeto, String> columnCodigoInventory;

	 @FXML
	 private TextField txtBuscarInventario;

	 @FXML
	 private Button btnBuscarInventario;

	 @FXML
	 private ComboBox<?> comboBoxInventario;

	 @FXML
	 private Button btnActualizarInventario;

	 @FXML
	 private Button btnRegistarInventario;

	 @FXML
	 private Button btnNuevoInventario;
	 
	 @FXML
	 private Button btnEliminarInventario;

    @FXML
    void buscarInventario(ActionEvent event) {

    }

    @FXML
    void actualizarInventario(ActionEvent event) throws ProductExistException {
    	actualizarInventario();
    }

    @FXML
    void registarInventario(ActionEvent event) {
    	registarInventario();
    }

    @FXML
    void nuevoInventario(ActionEvent event) {
    	nuevoInventario();
    }
    
    @FXML
    void eliminarInventario(ActionEvent event) {
    	eliminarInventario();
    }
    
    private Aplicacion aplicacion;
	ObservableList<Objeto> listaProductos = FXCollections.observableArrayList();
	private Objeto objetoSeleccionado;


    public void setAplicacion(Aplicacion aplicacion) {
		this.aplicacion = aplicacion;
		cargarListaPrestamos();

	}
    
    @FXML
    void initialize() {
    	//Datos de la tabla Objeto
    	this.columnNombreInventario.setCellValueFactory(new PropertyValueFactory<>("nombre"));
    	this.columnCodigoInventory.setCellValueFactory(new PropertyValueFactory<>("codigo"));

    	tblListInventory.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
    		objetoSeleccionado = newSelection;
    		mostrarInformacionObjeto(objetoSeleccionado);
    });
   }
    
	private void cargarListaPrestamos() {
		tblListInventory.getItems().clear();
		tblListInventory.setItems(obtenerObjetos());
	}
	
	private ObservableList<Objeto> obtenerObjetos() {
		listaProductos.addAll(aplicacion.obtenerProductos());
		return listaProductos;
	}
    
	private void nuevoInventario() {
		txtnombreObjetoInventario.setText("");
		txtcodigoObjetoInventario.setText("");
		txtpesoObjetoInventario.setText("");
		txtvalorObjetoInventario.setText("");
		txtestadoObjetoInventario.setText("");
		txtTipoObjetoInven.setText("");
		txtdescripcionObjetoInventario.setText("");
		txtcolorObjetoInventario.setText("");
		txtUnidadesDisInven.setText("");
		txtUnidadesPrestadasInven.setText("");
		btnRegistarInventario.setDisable(false);
		//btnAEliminarObjeto
		btnActualizarInventario.setDisable(true);
		tblListInventory.getSelectionModel().clearSelection();
	}
    
	private void mostrarInformacionObjeto(Objeto producto) {
		if (producto != null) {
			txtnombreObjetoInventario.setText(producto.getNombre());
			txtcodigoObjetoInventario.setText(producto.getCodigo());
			txtpesoObjetoInventario.setText(producto.getPeso());
			txtvalorObjetoInventario.setText(producto.getPrecioAlquiler());
			txtestadoObjetoInventario.setText(producto.getEstadoObjeto().toString());
			txtTipoObjetoInven.setText(producto.getTipo());
			txtdescripcionObjetoInventario.setText(producto.getDescripcion());
			txtcolorObjetoInventario.setText(producto.getColor());
			txtUnidadesDisInven.setText(String.valueOf(producto.getUnidadesDisponibles()));
			txtUnidadesPrestadasInven.setText(String.valueOf(producto.getUnidadesPrestadas()));
			btnRegistarInventario.setDisable(true);
			btnActualizarInventario.setDisable(false);
		}

	}
    
    
    private void showMessage(String titulo, String header, String contenido, AlertType tipoAlerta) {

        Alert alert = new Alert(tipoAlerta);
        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setContentText(contenido);
        alert.showAndWait();

    }
    
    private void registarInventario() {
		String nombreObjeto = txtnombreObjetoInventario.getText();
		String codigoObjeto = txtcodigoObjetoInventario.getText();
		String pesoObjeto = txtpesoObjetoInventario.getText();
		String estadoObjeto = txtestadoObjetoInventario.getText();
		String valorObjeto = txtvalorObjetoInventario.getText();
		String descripcionObjeto = txtdescripcionObjetoInventario.getText();
		String objetoColor = txtcolorObjetoInventario.getText();
		String objetoTipo = txtTipoObjetoInven.getText();
		String unidadesDis = txtUnidadesDisInven.getText();
		String unidadesPres = txtUnidadesPrestadasInven.getText();

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
    
    private void actualizarInventario() throws ProductExistException {
		String nameProduct = txtnombreObjetoInventario.getText();
		String productCode = txtcodigoObjetoInventario.getText();
		String productWeight = txtpesoObjetoInventario.getText();
		String conditionProduct = txtestadoObjetoInventario.getText();
		String productValue = txtvalorObjetoInventario.getText();
		String productDescription = txtdescripcionObjetoInventario.getText();
		String productColor = txtcolorObjetoInventario.getText();
		String objetoTipo = txtTipoObjetoInven.getText();
		String unidadesDis = txtUnidadesDisInven.getText();
		String unidadesPres = txtUnidadesPrestadasInven.getText();

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
				tblListInventory.refresh();
			}
		} else {
			showMessage("Notificación.", "Actualizacion incompleta", "No se ha podido actualizar la información.",
					AlertType.INFORMATION);
		}

	}
    
	private void eliminarInventario() {
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
    
}
