package com.viethuynh;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/saveUser")
public class SaveUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy thông tin từ form
        String fullName = request.getParameter("fullName");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String username = request.getParameter("username");
        String role = request.getParameter("role");
        String status = request.getParameter("status");

        // Tạo một đối tượng User từ dữ liệu form
        User newUser = new User(fullName, email, phone, username, role, status);

        // Gọi phương thức addUser từ UserDAO để thêm người dùng mới vào danh sách
        UserDAO userDAO = new UserDAOImpl(); // Tạo một đối tượng UserDAO
        userDAO.addUser(newUser);

        // Chuyển hướng người dùng đến trang danh sách người dùng sau khi thêm
        response.sendRedirect(request.getContextPath() + "/listUsers");
    }
    

}
