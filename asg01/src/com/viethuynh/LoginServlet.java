package com.viethuynh;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Load the JDBC driver when the servlet initializes
    public void init() throws ServletException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new ServletException("Error loading JDBC driver", e);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Kết nối cơ sở dữ liệu và kiểm tra thông tin đăng nhập
        User u = validateLoginAndGetRole(email, password);
        if (u == null) {
        	request.setAttribute("errorMessage", "Sai email hoặc mật khẩu");
            request.getRequestDispatcher("login2.jsp").forward(request, response);
            return;
        }
        
        request.getSession(true).setAttribute("logedInUser", u);
        switch(u.getRole()) {
	        case "User":
	            response.sendRedirect("index.jsp"); // Chuyển hướng đến trang user view
	        	break;
	        case "Admin":
	        	response.sendRedirect("listUsers"); // Chuyển hướng đến trang list users
	        	break;
        }
    }

    private User validateLoginAndGetRole(String email, String password) {
        // Code kiểm tra và lấy vai trò từ cơ sở dữ liệu ở đây
        // Ví dụ: sử dụng JDBC để kết nối và truy vấn từ MySQL
        String URL = "jdbc:mysql://localhost:3306/users_table";
        String USERNAME = "root";
        String PASSWORD = "admin";

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            String query = "SELECT * FROM Users WHERE email=? AND password=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, email);
                preparedStatement.setString(2, password);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                    	User u = new User();
                    	u.setId(resultSet.getInt("id"));
                    	u.setFullName(resultSet.getString("full_name"));
                    	u.setEmail(resultSet.getString("email"));
                    	u.setPhone(resultSet.getString("phone"));
                    	u.setUsername(resultSet.getString("username"));
                    	u.setRole(resultSet.getString("role"));
                    	u.setStatus(resultSet.getString("status"));
                        return u;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Trả về giá trị sai để xử lý lỗi hoặc không có kết quả
    }
}
