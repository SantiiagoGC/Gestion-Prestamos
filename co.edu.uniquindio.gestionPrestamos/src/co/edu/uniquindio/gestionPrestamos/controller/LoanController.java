package co.edu.uniquindio.gestionPrestamos.controller;

import java.net.URL;

import java.util.ResourceBundle;

import co.edu.uniquindio.gestionPrestamos.Aplicacion;
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
    private TableColumn<Prestamo, String> columnCodigoPrestar;

    @FXML
    private TableColumn<Prestamo, String> columnValorPrestar;

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
    private TableView<Prestamo> tblListPrestar;

    @FXML
    private TextField txtEstadoPrestamoPrestar;

    @FXML
    private TextField txtclientePrestamoPrestar;
    
	private Aplicacion aplicacion;
	ObservableList<Prestamo> listLoans = FXCollections.observableArrayList();
	private Prestamo selectedLoan;

	public void setAplicacion(Aplicacion aplicacion) {
		this.aplicacion = aplicacion;
		loadLoanList();
	}
	
	@FXML
	void initialize() {

		this.columnValorPrestar.setCellValueFactory(new PropertyValueFactory<>("valor"));
		this.columnCodigoPrestar.setCellValueFactory(new PropertyValueFactory<>("codigo"));

		tblListPrestar.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
			selectedLoan = newSelection;
			showLoanInformation(selectedLoan);
		});
		
		this.columnValorPrestar.setCellValueFactory(new PropertyValueFactory<>("valor"));
		this.columnCodigoPrestar.setCellValueFactory(new PropertyValueFactory<>("codigo"));

		tblListPrestar.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
			selectedLoan = newSelection;
			showLoanInformation(selectedLoan);
		});

	} 
	
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
    
	private void showMessage(String titulo, String header, String contenido, AlertType tipoAlerta) {

		Alert alert = new Alert(tipoAlerta);
		alert.setTitle(titulo);
		alert.setHeaderText(header);
		alert.setContentText(contenido);
		alert.showAndWait();

	}
	
	private void loadLoanList() {
		tblListPrestar.getItems().clear();
		tblListPrestar.setItems(obtenerPrestamos());
	}
	
    
	private ObservableList<Prestamo> obtenerPrestamos() {
		listLoans.addAll(aplicacion.obtenerPrestamos());
		return listLoans;
	}
	
	private void showLoanInformation(Prestamo loan) {

		if (loan != null) {
			txtcodigoPrestamoPrestar.setText(loan.getCodigo());
			txtEstadoPrestamoPrestar.setText(loan.getEstadoPrestamo().toString());
			txtValorPrestamoPrestar.setText(loan.getValor());
			txtFechaPrestamoPrestar.setText(loan.getFechaPrestamo());
			txtFechaEntregaPrestamoPrestar.setText(loan.getFechaEntrega());
			txtclientePrestamoPrestar.setText(loan.getCliente().getNombre());
			txtEmpleadoPrestamoPrestar.setText(loan.getEmpleado().getNombre());

		}

	}
	
}

