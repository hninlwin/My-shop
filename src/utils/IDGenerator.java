package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class IDGenerator {
	
	public static final int generate() {
		int i=0;
		String sql ="select num from idTable limit 1";
		String del = "delete from idTable where num=?";
		try(Connection con = ConnectionManager.getConnection();){
		
			ResultSet rs = con.createStatement().executeQuery(sql);
			
			if(rs.next()) {//TODO rs.next
					i= rs.getInt(1);
					PreparedStatement pre = con.prepareStatement(del);
					pre.setInt(1, i);
					pre.execute();
					
			}
			else {
				 ResultSet r=con.prepareStatement("select MAX(user_id) from user").executeQuery();
				//returning 0 prob
				 r.next();
				 i=r.getInt(1)+1;
//				 i=3;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

}
