package repo;

import java.util.List;

import entities.Category;
import entities.Item;
import memory.ItemRepoDBImpl;

public interface ItemRepo {
	public static ItemRepo getINSTANCE() {
		return ItemRepoDBImpl.getInstance();
	}
	
	List<Item> search(String name);
	
	void add(Item i);
	void add(String path);

}
