package com.viethuynh;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/getUserDetails")
public class GetUserDetailsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));

        // Gọi hàm getUserById từ UserDAO hoặc Service để lấy thông tin người dùng
        // Ví dụ:
        UserDAO userDAO = new UserDAOImpl();
        User user = userDAO.getUserById(userId);

        // Set thông tin người dùng vào attributes của request để chuyển đến trang cập nhật
        request.setAttribute("user", user);
        System.out.println("User ID: " + user.getId());
        request.getRequestDispatcher("userUpdateForm.jsp").forward(request, response);
    }
}
