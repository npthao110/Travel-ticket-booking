package com.viethuynh;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;

public class UserDAOImpl implements UserDAO {
    // Mock data
    private static final String URL = "jdbc:mysql://localhost:3306/users_table";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "admin";

    
    public static Connection getConnection() throws SQLException {
        Connection connection = null;
        try {
            // Load driver
            Class.forName("com.mysql.jdbc.Driver");
            // Get connection
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new SQLException("Error connecting to the database");
        }
        return connection;
    }
    
    
    
    
    @Override
    public List<User> getAllUsers(int offset, int limit) {
        List<User> userList = new ArrayList<>();
        String query = "SELECT * FROM users LIMIT ? OFFSET ?";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, limit);
            preparedStatement.setInt(2, offset);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String fullName = resultSet.getString("full_name");
                    String email = resultSet.getString("email");
                    String phone = resultSet.getString("phone");
                    String username = resultSet.getString("username");
                    String role = resultSet.getString("role");
                    String status = resultSet.getString("status");

                    User user = new User(id, fullName, email, phone, username, role, status);
                    userList.add(user);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public int getTotalUsers() {
        int totalUsers = 0;
        String countQuery = "SELECT COUNT(*) AS total FROM users";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(countQuery);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                totalUsers = resultSet.getInt("total");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return totalUsers;
    }

    
    @Override
    public void addUser(User user) {
        String insertQuery = "INSERT INTO users (full_name, email, phone, username, role, status) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            preparedStatement.setString(1, user.getFullName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPhone());
            preparedStatement.setString(4, user.getUsername());
            preparedStatement.setString(5, user.getRole());
            preparedStatement.setString(6, user.getStatus());

            preparedStatement.executeUpdate(); // Execute the insert query
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public boolean deleteUserById(int userId) {
        String deleteQuery = "DELETE FROM users WHERE id = ?";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
            preparedStatement.setInt(1, userId);

            int rowsAffected = preparedStatement.executeUpdate(); // Execute the delete query
            return rowsAffected > 0; // Return true if rows were affected (user was deleted)
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Return false in case of an exception or if no rows were affected
        }
    }

    @Override
    public boolean updateUser(int userId, String fullName, String phone, String role) {
        String updateQuery = "UPDATE users SET full_name = ?, phone = ?, role = ? WHERE id = ?";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
            preparedStatement.setString(1, fullName);
            preparedStatement.setString(2, phone);
            preparedStatement.setString(3, role);
            preparedStatement.setInt(4, userId);

            int rowsAffected = preparedStatement.executeUpdate(); // Execute the update query
            return rowsAffected > 0; // Return true if rows were affected (user was updated)
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Return false in case of an exception or if no rows were affected
        }
    }

    @Override
    public User getUserById(int userId) {
        String selectQuery = "SELECT * FROM users WHERE id = ?";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
            preparedStatement.setInt(1, userId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String fullName = resultSet.getString("full_name");
                    String email = resultSet.getString("email");
                    String phone = resultSet.getString("phone");
                    String username = resultSet.getString("username");
                    String role = resultSet.getString("role");
                    String status = resultSet.getString("status");

                    return new User(id, fullName, email, phone, username, role, status);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Return null if no user with the specified ID is found
    }

    
    @Override
    public List<User> searchUser(String query) {
        List<User> matchedUsers = new ArrayList<>();
        String searchQuery = "SELECT * FROM users WHERE phone LIKE ? OR email LIKE ?";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(searchQuery)) {
            preparedStatement.setString(1, "%" + query + "%");
            preparedStatement.setString(2, "%" + query + "%");

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String fullName = resultSet.getString("full_name");
                    String email = resultSet.getString("email");
                    String phone = resultSet.getString("phone");
                    String username = resultSet.getString("username");
                    String role = resultSet.getString("role");
                    String status = resultSet.getString("status");

                    User user = new User(id, fullName, email, phone, username, role, status);
                    matchedUsers.add(user);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return matchedUsers;
    }

    
    @Override
    public boolean lockUser(int userId) {
        String lockQuery = "UPDATE users SET status = 'Inactive' WHERE id = ?";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(lockQuery)) {
            preparedStatement.setInt(1, userId);

            int rowsAffected = preparedStatement.executeUpdate(); // Execute the lock query
            return rowsAffected > 0; // Return true if rows were affected (user was locked)
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Return false in case of an exception or if no rows were affected
        }
    }

    @Override
    public boolean unlockUser(int userId) {
        String unlockQuery = "UPDATE users SET status = 'Active' WHERE id = ? AND status = 'Inactive'";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(unlockQuery)) {
            preparedStatement.setInt(1, userId);

            int rowsAffected = preparedStatement.executeUpdate(); // Execute the unlock query
            return rowsAffected > 0; // Return true if rows were affected (user was unlocked)
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Return false in case of an exception or if no rows were affected
        }
    }




}
