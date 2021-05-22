package memory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.User;
import repo.UserRepo;
import utils.ConnectionManager;
import utils.IDGenerator;

public class UserRepoDBImpl implements UserRepo {

	private final static UserRepo INSTANCE = new UserRepoDBImpl();
	private final static String SELECT = "select * from user";
	private final static String INSERT = "insert into user(username,remark,user_id,phone,address,partner,debt) values (?,?,?,?,?,?,?)";
	private final static String DELETE = "delete from user where user_id=?";
	private final static String INSERTID = "insert into useridTable values (?)";

	public static UserRepo getINSTANCE() {
		return INSTANCE;
	}

	public UserRepoDBImpl() {
	}

	@Override
	public List<User> search(String username) {
		List<User> users = new ArrayList<User>();
		StringBuilder query = new StringBuilder(SELECT);

		if (username != "") {
			query.append(" where username like '" + username + "%'");
		}
		query.append(" order by username");

		try (Connection c = ConnectionManager.getConnection()) {

			ResultSet rs = c.prepareStatement(query.toString()).executeQuery();
			while (rs.next()) {
				User u = new User();
				u.setUsername(rs.getString("username"));
				u.setDebt(rs.getInt("debt"));
				u.setRemark(rs.getString("remark"));
				u.setPhone(rs.getString("phone"));
				u.setAddress(rs.getString("address"));
				u.setUserId(rs.getInt("user_id"));
				users.add(u);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return users;
	}

	@Override
	public void save(User user) {
		int i = IDGenerator.generate();
		if (i != 0)
			user.setUserId(i);
		try (Connection con = ConnectionManager.getConnection()) {
			PreparedStatement pre = con.prepareStatement(INSERT);

			pre.setObject(1, user.getUsername());
			
			pre.setObject(2, user.getRemark().equals("\n\n")? null:user.getRemark());//
			
			pre.setObject(3, user.getUserId());
			
			pre.setObject(4, user.getPhone().isEmpty()? null:user.getPhone());
			
			pre.setObject(5, user.getAddress().equals("\n\n\n")? null:user.getAddress());//
			pre.setObject(6, user.getPartner().isEmpty()? null:user.getPartner());
			pre.setObject(7, user.getDebt());

			pre.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(User user) {
		
		try ( Connection c = ConnectionManager.getConnection();
				PreparedStatement prep = c.prepareStatement(DELETE);
				PreparedStatement p2 = c.prepareStatement(INSERTID)) {
			
			prep.setInt(1, user.getUserId());
			p2.setInt(1, user.getUserId());
			
			try {
				prep.execute();
				p2.execute();
				c.commit();
			
			}catch(SQLException s) {
				c.rollback();
				s.printStackTrace();
			}
			
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
