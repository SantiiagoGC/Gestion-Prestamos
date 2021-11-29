package co.edu.uniquindio.gestionPrestamos.controller;

import co.edu.uniquindio.gestionPrestamos.Aplicacion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class InventoryController {

    @FXML
    private TextField txtpesoObjetoInventario;

    @FXML
    private TextField txtcodigoObjetoInventario;

    @FXML
    private Button btnBuscarInventario;

    @FXML
    private TextField txtdescripcionObjetoInventario;

    @FXML
    private TableColumn<?, ?> columnCodigoInventory;

    @FXML
    private TableView<?> tblListInventory;

    @FXML
    private TextField txtBuscarInventario;

    @FXML
    private Button btnActualizarInventario;

    @FXML
    private TextField txtestadoObjetoInventario;

    @FXML
    private TextField txtvalorObjetoInventario;

    @FXML
    private ComboBox<?> comboBoxInventario;

    @FXML
    private Button btnRegistarInventario;

    @FXML
    private TextField txtcolorObjetoInventario;

    @FXML
    private TableColumn<?, ?> columnNombreInventario;

    @FXML
    private Button btnNuevoInventario;

    @FXML
    private TextField txtnombreObjetoInventario;

    @FXML
    void buscarInventario(ActionEvent event) {

    }

    @FXML
    void actualizarInventario(ActionEvent event) {

    }

    @FXML
    void registarInventario(ActionEvent event) {

    }

    @FXML
    void nuevoInventario(ActionEvent event) {

    }
    private Aplicacion aplicacion;

    public void setAplicacion(Aplicacion aplicacion) {
		this.aplicacion = aplicacion;
	}
    private void showMessage(String titulo, String header, String contenido, AlertType tipoAlerta) {

        Alert alert = new Alert(tipoAlerta);
        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setContentText(contenido);
        alert.showAndWait();

    }
}
