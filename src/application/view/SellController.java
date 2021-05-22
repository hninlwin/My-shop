package application.view;

import java.net.URL;
import java.util.ResourceBundle;

import entities.OrderDetail;
import entities.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import utils.ChangeView;

public class SellController implements Initializable {

	@FXML
	private Label customer;
	public static String sname;
	
	@FXML
	private TableView<OrderDetail> table;

	@FXML
    private TableColumn<?, ?> tcname;

    @FXML
    private TableColumn<?, ?> tccount;

    @FXML
    private TableColumn<?, ?> tcprice;

    @FXML
    private TableColumn<?, ?> subTotal;

    @FXML
    private TextField name;

    @FXML
    private TextField count;

    @FXML
    private TextField price;

    @FXML
    private TextField discount;

    public void add() {
    	

    }

	
	

	public void cancel() {
		ChangeView.change("MainView", table.getScene(),null);
	}

	public void save() {
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		customer.setText(sname);
		
		table.setEditable(true);
		
	}
}
