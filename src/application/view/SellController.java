package application.view;

import java.net.URL;
import java.util.ResourceBundle;

import entities.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import utils.ChangeView;

public class SellController implements Initializable {

	@FXML
	private Label customer;

	
	@FXML
	private TableView<?> table;

	@FXML
	private TextField total;

	@FXML
	private TextField discount;
	
	

	public void cancel() {
		ChangeView.change("HomePage", table.getScene());
	}

	public void save() {
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
}
