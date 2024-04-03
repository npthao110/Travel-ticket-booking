package com.viethuynh;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SearchUserServlet")
public class SearchUserServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchQuery = request.getParameter("searchQuery");

        // Gọi hàm searchUser từ UserDAO để tìm kiếm thông tin người dùng
        UserDAO userDAO = new UserDAOImpl();
        List<User> users = userDAO.searchUser(searchQuery);

        // Lưu danh sách người dùng tìm được vào attributes của request để hiển thị trên trang JSP
        request.setAttribute("searchedUsers", users);
        request.getRequestDispatcher("userSearchResult.jsp").forward(request, response);
    }
}
