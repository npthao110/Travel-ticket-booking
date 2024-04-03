package com.viethuynh;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/listUsers")
public class ListUsersServlet extends HttpServlet {
    private UserService userService; // Inject UserService instance
    private UserDAO UserDAO;
    private static final long serialVersionUID = 1L;
   

    public ListUsersServlet() {
        this.UserDAO = new UserDAOImpl();
        this.userService = new UserServiceImpl(UserDAO); 
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int page = 1;
        int pageSize = 10; // Số người dùng trên mỗi trang

        if (request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }

        List<User> userList = userService.getAllUsers(page, pageSize);
        int totalUsers = userService.getTotalUsers();
        int totalPages = (int) Math.ceil((double) totalUsers / pageSize);

        request.setAttribute("userList", userList);
        request.setAttribute("totalUsers", totalUsers);
        request.setAttribute("totalPages", totalPages);
        request.getRequestDispatcher("listUsers.jsp").forward(request, response);
    }
}
