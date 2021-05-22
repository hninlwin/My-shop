package utils;

import java.io.IOException;

import application.view.HistoryController;
import application.view.HomeController;
import application.view.SellController;
import entities.User;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;

public class ChangeView {

	public static final void change(String s,Scene scene,User customer) {
		FXMLLoader loader = new FXMLLoader(HomeController.class.getResource(s+".fxml"));
		try {
			//hide first window
			scene.getWindow().hide();
			
			if(customer!=null) {
				if(s.equals("Sell")) {
					 SellController d = (SellController)loader.getController();
					 d.name=customer.getUsername();
				}
				else {
					HistoryController d = (HistoryController)loader.getController();
					d.name=customer.getUsername();
				}
			}
			//load new window
			Parent root = loader.load();
			Stage stage = new Stage();
			stage.setScene(new Scene(root));
			stage.show();

			stage.getScene().setOnKeyPressed(e->{
				if(new KeyCodeCombination(KeyCode.W, KeyCombination.CONTROL_ANY).match(e)) {
					Platform.exit();
				}
			});
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
