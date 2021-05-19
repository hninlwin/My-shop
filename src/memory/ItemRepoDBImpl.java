package memory;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Item;
import repo.ItemRepo;
import utils.ConnectionManager;

public class ItemRepoDBImpl implements ItemRepo{
	private static final ItemRepo INSTANCE = new ItemRepoDBImpl();
	private static final String SELECT = "select * from item where 1=1";

	public static ItemRepo getInstance() {
		return INSTANCE;
	}
	ItemRepoDBImpl(){}
	
	@Override
	public List<Item> search(String name) {
		StringBuilder query = new StringBuilder(SELECT);
		List<Object> params = new ArrayList<Object>();
		List<Item> items = new ArrayList<Item>();
		
		if(null != name && !name.isEmpty()) {
			query.append(" and name=?");
			params.add(name);
		}
		
		try(Connection con = ConnectionManager.getConnection();
				PreparedStatement s = con.prepareStatement(query.toString())){
			
			for(int i=0;i<params.size();i++)
				s.setObject(i+1,params.get(i));
			
			ResultSet rs = s.executeQuery();
			
			while(rs.next())
				items.add(getItems(rs));
			
		}catch(Exception e) {
			e.printStackTrace();
		}
				
		return items;
	}
	private Item getItems(ResultSet rs) throws SQLException {
		Item i = new Item();
		i.setItemName(rs.getString("name"));
		i.setPrice(rs.getInt("price"));
		return i;
	}
	@Override
	public void add(Item i) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void add(String path) {
//		try {
//			Files.lines(Paths.get(path))
//			.skip(1)
//			.map(l->l.split("\t"))
//			.map(Item::new)
//			.forEach(item->add(item));
//			
//		}catch(IOException e) {
//			e.printStackTrace();
//		}
	}
	
	
}
