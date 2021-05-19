package application.view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;
import utils.ChangeView;

public class HomeController implements Initializable{
	    @FXML
	    private VBox users;

	    @FXML
	    private VBox add;

		@Override
		public void initialize(URL location, ResourceBundle resources) {
		
			users.setOnMouseClicked(e->{
				if(e.getClickCount()==2) {
					ChangeView.change("MainView",add.getScene());
				}
			});
			add.setOnMouseClicked(e->{
				if(e.getClickCount()==2) {
					ChangeView.change("Add",add.getScene());
				}
			});
		}
		
		
		
	

}
