package repo;

import java.util.List;

import entities.User;
import memory.UserRepoDBImpl;

public interface UserRepo {
	
	public static UserRepo getInstance() {
		return UserRepoDBImpl.getINSTANCE();
	}
	List<User> search(String username);
	
	void save(User user);
	
	void delete(User user);  

}
