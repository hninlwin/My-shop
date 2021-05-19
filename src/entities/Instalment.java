package entities;

import java.io.Serializable;
import java.time.LocalDate;

public class Instalment implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int id;
	private LocalDate payDate;
	private int payAmount;
	private User user;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDate getPayDate() {
		return payDate;
	}
	public void setPayDate(LocalDate payDate) {
		this.payDate = payDate;
	}
	public int getPayAmount() {
		return payAmount;
	}
	public void setPayAmount(int payAmount) {
		this.payAmount = payAmount;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	

}
