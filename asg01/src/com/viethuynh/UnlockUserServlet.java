package com.viethuynh;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/unlockUser")
public class UnlockUserServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));

        // Gọi hàm unlockUser từ UserDAO hoặc Service để mở khóa tài khoản người dùng
        UserDAO userDAO = new UserDAOImpl();
        boolean isUnlocked = userDAO.unlockUser(userId);

        if (isUnlocked) {
            // Nếu mở khóa thành công, chuyển hướng người dùng đến trang thông tin người dùng hoặc trang danh sách người dùng
            response.sendRedirect("listUsers");
        } else {
            // Xử lý lỗi hoặc thông báo mở khóa không thành công
            response.getWriter().println("Mở khóa tài khoản không thành công");
        }
    }
}
