package com.viethuynh;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/updateUser")
public class UpdateUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));
        String fullName = request.getParameter("fullName");
        String phone = request.getParameter("phone");
        String role = request.getParameter("role");


        // Gọi hàm update từ UserDAO hoặc Service để cập nhật thông tin người dùng
        // Ví dụ:
        UserDAO userDAO = new UserDAOImpl();
        boolean isUpdated = userDAO.updateUser(userId, fullName, phone, role);

        if (isUpdated) {
            // Nếu cập nhật thành công, chuyển hướng người dùng đến trang thông tin người dùng hoặc trang danh sách người dùng
            response.sendRedirect("listUsers");
        } else {
            // Xử lý lỗi hoặc thông báo cập nhật không thành công
            response.getWriter().println("Cập nhật thông tin không thành công");
        }
    }
}