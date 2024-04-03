package com.viethuynh;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/getTravelDetails")
public class GetTravelDetailsServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int travelId = Integer.parseInt(request.getParameter("travelId"));

        // Gọi hàm getUserById từ UserDAO hoặc Service để lấy thông tin người dùng
        // Ví dụ:
        TravelDAO travelDAO = new TravelDAOImpl();
        Travel travel = travelDAO.getTravelById(travelId);

        // Set thông tin người dùng vào attributes của request để chuyển đến trang cập nhật
        request.setAttribute("travel", travel);
        request.getRequestDispatcher("travelUpdateForm.jsp").forward(request, response);
    }
}
