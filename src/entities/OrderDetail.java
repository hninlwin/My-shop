package entities;

import java.io.Serializable;

public class OrderDetail implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int id;
	private int count;
	private int total;
	
	private Item item;
	private Voucher voucher;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public Voucher getVoucher() {
		return voucher;
	}
	public void setVoucher(Voucher voucher) {
		this.voucher = voucher;
	}
	
	
	

}
