package application.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;

public class Main extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("HomePage.fxml"));
		Stage stage = new Stage();
		Scene scene = new Scene(loader.load());
		//scene.getStylesheets().add("application/view/application.css");
		stage.setScene(scene);
		stage.show();
		
//		scene.setOnKeyPressed(e->{
//			if((new KeyCodeCombination(KeyCode.W,KeyCombination.CONTROL_ANY)).match(e)){
//			scene.getWindow().hide();
//			}
//		});
	}

}
