package com.viethuynh;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/lockUser")
public class LockUserServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));

        // Gọi hàm khóa tài khoản từ DAO hoặc Service
        // Ví dụ:
        UserDAO userDAO = new UserDAOImpl();
        boolean isLocked = userDAO.lockUser(userId);

        // Trả về phản hồi tùy thuộc vào việc thực hiện khóa tài khoản thành công hay không
        if (isLocked) {
        	response.sendRedirect("listUsers");
        } else {
            response.getWriter().write("Khóa tài khoản không thành công");
        }
    }
}