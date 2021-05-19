package application.view;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import entities.User;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.SVGPath;
import javafx.util.Callback;
import repo.UserRepo;
import utils.ChangeView;

public class MainviewController implements Initializable {
	@FXML
	private SVGPath home;

	@FXML
	private SVGPath sell;
	@FXML
	private TextField searchkey;

	@FXML
	private TableView<User> table;

	@FXML
	private TableColumn<User, Integer> num;

	@FXML
	private TableColumn<User, String> username;

	@FXML
	private TableColumn<User, Integer> debt;

	@FXML
	private TableColumn<User, String> remark;

	private UserRepo userRepo = UserRepo.getInstance();


	public void search() {
		if (searchkey == null || searchkey.getText().isEmpty()) {
			List<User> list = userRepo.search("");
			for (int i = 0; i < list.size(); i++) {
				table.getItems().add(list.get(i));
			}
		}

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Thread th = new Thread(new Runnable() {
			
			@Override
			public void run() {
				search();
			}
		});
		th.start();
	//	search();
		searchkey.textProperty().addListener((a, b, c) -> search());

		table.setRowFactory(new Callback<TableView<User>, TableRow<User>>() {

			@Override
			public TableRow<User> call(TableView<User> tableview) {
				final TableRow<User> row = new TableRow<>();
				final ContextMenu rowMenu = new ContextMenu();
				MenuItem editItem = new MenuItem("Edit");
				editItem.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {
						table.setEditable(true);
					}
				});
				MenuItem removeItem = new MenuItem("Delete");
				removeItem.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {
						table.getItems().remove(row.getItem());
						userRepo.delete(row.getItem());
					}
				});
				MenuItem history = new MenuItem("History");
				history.setOnAction(e->{
					table.getSelectionModel().getSelectedItem();
				});
				rowMenu.getItems().addAll(editItem, removeItem);

				row.contextMenuProperty()
						.bind(Bindings.when(row.emptyProperty()).then((ContextMenu) null).otherwise(rowMenu));
				
				row.setOnMouseClicked(e->{
					if(e.getClickCount()==2)
						//call the method from sell controller (row.getitem)
						ChangeView.change("Sell", home.getScene());
				});
				return row;
			}
		});

		home.setOnMouseClicked(e->{
			
				ChangeView.change("HomePage", home.getScene());
			}
		);
		sell.setOnMouseClicked(e->{
		
				ChangeView.change("Sell", home.getScene());
			}
		);
		
	}

}
