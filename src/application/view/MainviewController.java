package application.view;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import entities.User;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.shape.SVGPath;
import javafx.util.Callback;
import repo.UserRepo;
import utils.ChangeView;

public class MainviewController implements Initializable {
	@FXML
	private SVGPath home;

	@FXML
	private TextField searchkey;

	@FXML
	private TableView<User> table;

	@FXML
	private TableColumn<User, String> username;
	
	@FXML
	private TableColumn<User, String> partner;
	
	@FXML
	private TableColumn<User, Integer> debt;

	@FXML
	private TableColumn<User, String> remark;
	
	@FXML
	private TableColumn<User,String> phone;

	@FXML
	private TableColumn<User,String> address;

	private UserRepo userRepo = UserRepo.getInstance();

	public void search() {
		if (searchkey == null || searchkey.getText().isEmpty()) {
			List<User> list = userRepo.search("");
			for (int i = 0; i < list.size(); i++) {
				table.getItems().add(list.get(i));
			}
		}

	}
	
//	private void edit(TableColumn<User, String> tc) {
//		tc.setCellFactory(TextFieldTableCell.forTableColumn());
//		tc.setOnEditCommit(
//				(TableColumn.CellEditEvent<User,String> e) ->
//					(e.getTableView().getItems().get(
//							e.getTablePosition().getRow())
//					).setObject(tc.getText(),e.getNewValue())
//				
//				);
//		
//	}
//	public void changeCellEvent(CellEditEvent edittedcell) {
//		  User u = table.getSelectionModel().getSelectedItem();
//		  u.setObject(edittedcell.getTableColumn().getId(), edittedcell.getNewValue());
//	}
//	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Thread th = new Thread(new Runnable() {

			@Override
			public void run() {
				search();
			}
		});
		th.start();
		// search();
		searchkey.textProperty().addListener((a, b, c) -> search());
		

		table.setRowFactory(new Callback<TableView<User>, TableRow<User>>() {
	
			@Override
			public TableRow<User> call(TableView<User> tableview) {
			
				//TODO 
				final TableRow<User> row = new TableRow<>();
				final ContextMenu rowMenu = new ContextMenu();
				MenuItem editItem = new MenuItem("Edit");
				editItem.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {
						table.setEditable(true);
						username.setCellFactory(TextFieldTableCell.forTableColumn());
						username.setOnEditCommit(e->{
							row.getItem().setUsername(e.getNewValue());
						});
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
				history.setOnAction(e -> {
					// TODO
					ChangeView.change("History", home.getScene(), row.getItem());
				});
				rowMenu.getItems().addAll(editItem, removeItem, history);

				row.contextMenuProperty()
						.bind(Bindings.when(row.emptyProperty()).then((ContextMenu) null).otherwise(rowMenu));

				row.setOnMouseClicked(e -> {
					if (e.getClickCount() == 2)
						ChangeView.change("Sell", home.getScene(), row.getItem());
				});
				return row;
			}
		});

		home.setOnMouseClicked(e -> {

			ChangeView.change("HomePage", home.getScene(), null);
		});

	}

}
