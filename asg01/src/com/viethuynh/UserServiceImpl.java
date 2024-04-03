package com.viethuynh;


import java.util.List;
public class UserServiceImpl implements UserService {
    private UserDAO userDAO; // Inject UserDAO instance
    
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
    
    @Override
    public List<User> getAllUsers(int page, int pageSize) {
        return userDAO.getAllUsers((page - 1) * pageSize, pageSize);
    }

    @Override
    public int getTotalUsers() {
        return userDAO.getTotalUsers();
    }
}