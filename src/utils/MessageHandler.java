package utils;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class MessageHandler {
	private static Alert alert = new Alert(AlertType.WARNING);

	public static final void showMessage(String s) {

		alert.setContentText(s);
		alert.setResizable(false);
		// alert.setHeaderText(null);
		alert.show();
		bringToFront();
	}

	public static void bringToFront() {
		Stage window = (Stage) alert.getDialogPane().getScene().getWindow();
		window.setAlwaysOnTop(true);
	}
}
