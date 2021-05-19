package entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Voucher implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int id;
	private LocalDate saleDate;
	
	private List<OrderDetail> details;
	
	public Voucher() {
		details = new ArrayList<OrderDetail>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getSaleDate() {
		return saleDate;
	}

	public void setSaleDate(LocalDate saleDate) {
		this.saleDate = saleDate;
	}

	public List<OrderDetail> getDetails() {
		return details;
	}

	public void setDetails(List<OrderDetail> details) {
		this.details = details;
	}

	
}
