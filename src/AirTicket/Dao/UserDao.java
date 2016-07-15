package AirTicket.Dao;

import AirTicket.Data.User;

public interface UserDao {
	User findByUsername(String username);
}
