package entities;


public class Item {
	//private int id;
	private String name;
	//private Category category;
	private int price;
	
	
	public String getItemName() {
		return name;
	}
	public void setItemName(String itemName) {
		this.name = itemName;
	}

	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	

	
	public Item() {}
}
