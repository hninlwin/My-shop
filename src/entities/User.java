package entities;

import java.io.Serializable;
import java.util.List;

import javafx.beans.property.SimpleStringProperty;

public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private SimpleStringProperty username;
	private int debt;
	private SimpleStringProperty remark;
	private SimpleStringProperty phone;
	private SimpleStringProperty address;
	private int userId;
	private SimpleStringProperty partner;
	
	private List<Instalment> instalments;
	private List<Voucher> vouchers;
 	
	public String getUsername() {
		return username.get();
	}
	public void setUsername(String username) {
		this.username =new SimpleStringProperty(username) ;
	}
	public int getDebt() {
		return debt;
	}
	public void setDebt(int debt) {
		this.debt = debt;
	}
	public String getRemark() {
		return remark.get();
	}
	public void setRemark(String remark) {
		this.remark = new SimpleStringProperty(remark);
	}
	
	public List<Voucher> getVouchers() {
		return vouchers;
	}
	public void setVouchers(List<Voucher> vouchers) {
		this.vouchers = vouchers;
	}
	public List<Instalment> getInstalments() {
		return instalments;
	}
	public void setInstalments(List<Instalment> instalments) {
		this.instalments = instalments;
	}
	public String getPhone() {
		return phone.get();
	}
	public void setPhone(String phone) {
		this.phone = new SimpleStringProperty(phone);
	}
	public String getAddress() {
		return address.get();
	}
	public void setAddress(String address) {
		this.address = new SimpleStringProperty(address);
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getPartner() {
		return partner.get();
	}
	public void setPartner(String partner) {
		this.partner = new SimpleStringProperty(partner);
	}

	
	public void setObject(String s,Object object) {
		//TODO update also in user repo DB
		if(s.equals("username"))
			this.username=new SimpleStringProperty((String) object);
		else if(s.equals("partner"))
			this.partner=new SimpleStringProperty((String) object);
		else if(s.equals("remark"))
			this.remark=new SimpleStringProperty((String) object);
		else if(s.equals("address"))
			this.address=new SimpleStringProperty((String) object);
		else {
			this.phone=new SimpleStringProperty((String) object);
		}
		
	}
	

}
