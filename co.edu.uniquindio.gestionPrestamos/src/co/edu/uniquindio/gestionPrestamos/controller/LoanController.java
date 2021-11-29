package co.edu.uniquindio.gestionPrestamos.controller;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.gestionPrestamos.Aplicacion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class LoanController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtEmpleadoPrestamoPrestar;

    @FXML
    private Button btnRegistarPrestar;

    @FXML
    private Button btnNuevoPrestar;

    @FXML
    private TableColumn<?, ?> columnCodigoPrestar;

    @FXML
    private TableColumn<?, ?> columnValorPrestar;

    @FXML
    private TextField txtcodigoPrestamoPrestar;

    @FXML
    private Button btnActualizarPrestar;

    @FXML
    private TextField txtBuscarPrestar;

    @FXML
    private TextField txtFechaEntregaPrestamoPrestar;

    @FXML
    private TextField txtFechaPrestamoPrestar;

    @FXML
    private TextField txtValorPrestamoPrestar;

    @FXML
    private ComboBox<?> comboBoxPrestar;

    @FXML
    private Button btnBuscarPrestar;

    @FXML
    private TableView<?> tblListPrestar;

    @FXML
    private TextField txtEstadoPrestamoPrestar;

    @FXML
    private TextField txtclientePrestamoPrestar;

	private Aplicacion aplicacion;

    @FXML
    void buscarPrestar(ActionEvent event) {

    }

    @FXML
    void actualizarPrestar(ActionEvent event) {

    }

    @FXML
    void registarPrestar(ActionEvent event) {

    }

    @FXML
    void nuevoPrestar(ActionEvent event) {

    }

    @FXML
    void initialize() {
    }

	public void setAplicacion(Aplicacion aplicacion) {
		this.aplicacion = aplicacion;
	}
}

