package com.viethuynh;
import java.util.List;

public interface UserDAO {
	UserDAO userDAO = new UserDAOImpl();
    List<User> getAllUsers(int page, int pageSize);
    int getTotalUsers();
	void addUser(User user);
	boolean deleteUserById(int userId);
	boolean updateUser(int userId, String fullName, String phone, String role);
	User getUserById(int userId);
	List<User> searchUser(String query);
	boolean lockUser(int userId);
	boolean unlockUser(int userId);
}
