package entities;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String username;
	private int debt;
	private String remark;
	private String phone;
	private String address;
	private int userId;
	private String partner;
	
	private List<Instalment> instalments;
	private List<Voucher> vouchers;
 	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getDebt() {
		return debt;
	}
	public void setDebt(int debt) {
		this.debt = debt;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
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
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getPartner() {
		return partner;
	}
	public void setPartner(String partner) {
		this.partner = partner;
	}
	
	
	

}
