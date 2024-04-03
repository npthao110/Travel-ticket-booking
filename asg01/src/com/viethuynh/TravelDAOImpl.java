package com.viethuynh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TravelDAOImpl implements TravelDAO {
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
    public List<Travel> getAllTravels() {
        List<Travel> travelList = new ArrayList<>();
        String query = "SELECT * FROM travel"; // Assuming your table name is 'travel'

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String travelName = resultSet.getString("travel_name");
                String price = resultSet.getString("price");
                String imageDescription = resultSet.getString("imageDescription");
                String detailDescription = resultSet.getString("detailDescription");
                String startDate = resultSet.getString("start_date");
                String endDate = resultSet.getString("end_date");
                String address = resultSet.getString("address");
                
                Travel travel = new Travel(id, travelName, price, imageDescription, detailDescription, startDate, endDate, address);
                travelList.add(travel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return travelList;
    }
    
    @Override
    public void addTravel(Travel travel) {
        try (Connection connection = getConnection()) {
            String query = "INSERT INTO travel (travel_name, price, imageDescription, detailDescription, start_date, end_date, address) VALUES (?, ?, ?, ?, ?, ?, ?)";
            
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, travel.getName());
                preparedStatement.setString(2, travel.getPrice());
                preparedStatement.setString(3, travel.getImageDescription());
                preparedStatement.setString(4, travel.getDetailDescription());
                preparedStatement.setString(5, travel.getStartDate());
                preparedStatement.setString(6, travel.getEndDate());
                preparedStatement.setString(7, travel.getAddress());

                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    

    
    @Override
    public boolean deleteTravelById(int travelId) {
        String query = "DELETE FROM travel WHERE id = ?";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, travelId);
            int rowsAffected = preparedStatement.executeUpdate();
            
            return rowsAffected > 0; // Trả về true nếu có bản ghi bị xóa, ngược lại trả về false
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    
    @Override
    public List<Travel> searchTravel(String query) {
        List<Travel> matchedTravel = new ArrayList<>();
        String searchQuery = "SELECT * FROM travel WHERE travel_name LIKE ?";
        
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(searchQuery)) {
            
            preparedStatement.setString(1, "%" + query + "%");
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String travelName = resultSet.getString("travel_name");
                    String price = resultSet.getString("price");
                    String imageDescription = resultSet.getString("imageDescription");
                    String detailDescription = resultSet.getString("detailDescription");
                    String startDate = resultSet.getString("start_date");
                    String endDate = resultSet.getString("end_date");
                    String address = resultSet.getString("address");

                    Travel travel = new Travel(id, travelName, price, imageDescription, detailDescription, startDate, endDate, address);
                    matchedTravel.add(travel);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return matchedTravel;
    }

    
    @Override
    public boolean updateTravel(int travelId, String name, String price, String address) {
        String query = "UPDATE travel SET travel_name = ?, price = ?, address = ? WHERE id = ?";
        
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, price);
            preparedStatement.setString(3, address);
            preparedStatement.setInt(4, travelId);

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0; // Trả về true nếu có bản ghi được cập nhật, ngược lại trả về false
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Travel getTravelById(int travelId) {
        Travel travel = null;
        String query = "SELECT * FROM travel WHERE id = ?";
        
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            
            preparedStatement.setInt(1, travelId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String travelName = resultSet.getString("travel_name");
                    String price = resultSet.getString("price");
                    String imageDescription = resultSet.getString("imageDescription");
                    String detailDescription = resultSet.getString("detailDescription");
                    String startDate = resultSet.getString("start_date");
                    String endDate = resultSet.getString("end_date");
                    String address = resultSet.getString("address");

                    travel = new Travel(id, travelName, price, imageDescription, detailDescription, startDate, endDate, address);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return travel;
    }
    
    
    public boolean bookTravel(int travelId, int userId) {
        // Your logic to insert a record into bookings and user_booking tables
        // Execute SQL queries to perform booking
        
        // Example code using PreparedStatement
        String insertBookingsQuery = "INSERT INTO bookings (user_id, travel_id) VALUES (?, ?)";
        String insertUserBookingQuery = "INSERT INTO user_booking (user_id, booking_id) VALUES (?, LAST_INSERT_ID())";
        
        try (Connection connection = getConnection();
             PreparedStatement bookingStatement = connection.prepareStatement(insertBookingsQuery);
             PreparedStatement userBookingStatement = connection.prepareStatement(insertUserBookingQuery)) {
            
            // Set parameters for the bookings table
            bookingStatement.setInt(1, userId);
            bookingStatement.setInt(2, travelId);
            
            // Execute the bookings table insertion
            int rowsInserted = bookingStatement.executeUpdate();
            
            if (rowsInserted > 0) {
                // Set parameters for the user_booking table
                userBookingStatement.setInt(1, userId);
                
                // Execute the user_booking table insertion
                int userBookingRowsInserted = userBookingStatement.executeUpdate();
                
                return userBookingRowsInserted > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return false;
    }


   


}
