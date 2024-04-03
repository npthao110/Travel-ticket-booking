package com.viethuynh;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String URL = "jdbc:mysql://localhost:3306/users_table";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "admin";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String fullName = request.getParameter("fullName");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");
        String phone = request.getParameter("phone");
        String role = request.getParameter("role");

        String errorMessage = validateRegistration(email, fullName, password, confirmPassword, phone);
        if (errorMessage.isEmpty()) {
            try (Connection connection = getConnection()) {
            	String insertQuery = "INSERT INTO users (email, full_name, username, password, phone, role) VALUES (?, ?, ?, ?, ?, ?)";

                try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                	preparedStatement.setString(1, email);
                	preparedStatement.setString(2, fullName);
                	preparedStatement.setString(3, username);
                	preparedStatement.setString(4, password);
                	preparedStatement.setString(5, phone);
                	preparedStatement.setString(6, role);

                    preparedStatement.executeUpdate();
                }
                request.setAttribute("successMessage", "Đăng ký thành công!");
                request.getRequestDispatcher("register.jsp").forward(request, response);
            } catch (SQLException e) {
                e.printStackTrace();
                // Handle database connection or data storage errors
            }
        } else {
            request.setAttribute("errorMessage", errorMessage);
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
    }

    private String validateRegistration(String email, String fullName, String password, String confirmPassword, String phoneNumber) {
        StringBuilder errorMessage = new StringBuilder();

        // Kiểm tra email có đúng định dạng không
        if (!email.matches("^\\S+@\\S+\\.\\S+$")) {
            errorMessage.append("Email không hợp lệ. ");
        }

        // Kiểm tra mật khẩu (ví dụ: đủ độ dài, chứa chữ in hoa, chữ in thường, số, ký tự đặc biệt)
        if (!password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()_+\\-={};':\"|,.<>?]).{8,}$")) {
            errorMessage.append("Mật khẩu không đủ mạnh. ");
        }

        // Kiểm tra sự khớp nhau giữa mật khẩu và nhập lại mật khẩu
        if (!password.equals(confirmPassword)) {
            errorMessage.append("Mật khẩu không khớp. ");
        }

        // Kiểm tra số điện thoại có hợp lệ không (ví dụ: chỉ chứa số, đủ độ dài)
        if (!phoneNumber.matches("^\\d{10,12}$")) {
            errorMessage.append("Số điện thoại không hợp lệ. ");
        }

        return errorMessage.toString();
    }


    private Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new SQLException("Error connecting to the database");
        }
    }
}
