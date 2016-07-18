package AirTicket.Dao;

import AirTicket.Data.User;

public interface UserDao {
	User findByUsername(String username);
	User findById(int id);
	int addUser(User user);
}
