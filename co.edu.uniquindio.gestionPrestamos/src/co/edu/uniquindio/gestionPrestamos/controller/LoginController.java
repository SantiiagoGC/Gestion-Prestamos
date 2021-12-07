package co.edu.uniquindio.gestionPrestamos.controller;


import co.edu.uniquindio.gestionPrestamos.Aplicacion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {
	
	private Stage primaryStage;

    @FXML
    private TextField txtUser;

    @FXML
    private Button bttinLogin;

    @FXML
    private PasswordField txtPassword;
    //Aplicacion
	private Aplicacion aplicacion;

    @FXML
    void loginAction(ActionEvent event) {
    	login();
    }

	public void setAplicacion(Aplicacion aplicacion) {
		this.aplicacion = aplicacion;
	}

	private void login() {
		String user = txtUser.getText();
		String password = txtPassword.getText();
		if (user.isEmpty() || password.isEmpty()) {
			showMessage("Notificacion.", "Algun espacio esta vacio.", "Por favor ingrese algo en los capos.", AlertType.ERROR);
		} else {
			if (user.equals("Admin") && password.equals("12345")) {
				showMessage("Notifica�n", "Bienvenido Admin.", "Sea bienvenido Administrador.", AlertType.INFORMATION);
				showAdminLogin();
			} else {
				if (user.equals("Empleado") && password.equals("12345")) {
					showEmployee();
				} else {
					if(user.equals("Inventario") && password.equals("12345")) {
						showInventory();
					} else {
						showMessage("Notifica�n", "Datos incorrectos", "No se ha encontrado un usuario con esa informaci�n.", AlertType.ERROR);
					}
				}
			}
		}
	}
	private void showInventory() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("view/InventoryView.fxml"));

			Parent root = loader.load();

			InventoryController inventoryController = loader.getController();
			inventoryController.setAplicacion(aplicacion);

			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.setScene(scene);
			stage.showAndWait();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void showEmployee() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("view/LoanView.fxml"));

			Parent root = loader.load();

			LoanController loanController = loader.getController();
			loanController.setAplicacion(aplicacion);

			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.setScene(scene);
			stage.showAndWait();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void showAdminLogin() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("view/AdminView.fxml"));

			Parent root = loader.load();

			AdminViewController adminViewController = loader.getController();
			adminViewController.setAplicacion(aplicacion);

			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.setScene(scene);
			stage.showAndWait();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	//Nos muestra un tipo de alerta
    private void showMessage(String titulo, String header, String contenido, AlertType tipoAlerta) {

        Alert alert = new Alert(tipoAlerta);
        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setContentText(contenido);
        alert.showAndWait();

    }

}