package application.view;

import entities.User;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import repo.UserRepo;
import utils.ChangeView;
import utils.MessageHandler;
import utils.MyShopException;

public class AddUser {

    @FXML
    private TextField username;

    @FXML
    private TextField partner;

    @FXML
    private TextField phone;

    @FXML
    private TextArea remark;

    @FXML
    private TextArea address;
    
    private UserRepo userRepo = UserRepo.getInstance();

    public void cancel() {
    	//username.getScene().getWindow().hide();
    	ChangeView.change("HomePage", username.getScene());
    }

    public void save() {
    	
    	if(username.getText()=="") {
    		MessageHandler.showMessage("Customer Name is required!");
    		throw new MyShopException("Customer Name is null");
    	}
    	User u = new User();
    	u.setUsername(username.getText());
    	u.setPartner(partner.getText());
    	u.setPhone(phone.getText());
    	u.setAddress(address.getText());
    	u.setRemark(remark.getText());
    	u.setPartner(partner.getText());
    	u.setDebt(0);
    	
    	Thread th = new Thread(new Runnable() {
			
			@Override
			public void run() {
				userRepo.save(u);
			}
		});
    	ChangeView.change("HomePage", username.getScene());
    	th.start();
    }
    
  
}
