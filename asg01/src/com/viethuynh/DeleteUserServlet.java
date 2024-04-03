package com.viethuynh;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/deleteUser")
public class DeleteUserServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy userId từ request
        int userId = Integer.parseInt(request.getParameter("userId"));

        // Tạo đối tượng UserDAO để gọi phương thức deleteUserById
        UserDAO userDAO = new UserDAOImpl();

        // Thực hiện xóa người dùng có userId từ danh sách hoặc cơ sở dữ liệu
        boolean isDeleted = userDAO.deleteUserById(userId);

        if (isDeleted) {
            // Nếu xóa thành công, chuyển hướng người dùng đến trang danh sách người dùng
            response.sendRedirect("listUsers");
        } else {
            // Xử lý lỗi hoặc thông báo xóa không thành công
            // Ví dụ:
            response.getWriter().println("Xóa người dùng không thành công");
        }
    }
}