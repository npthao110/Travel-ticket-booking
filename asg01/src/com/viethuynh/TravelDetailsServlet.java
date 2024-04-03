package com.viethuynh;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TravelDetailsServlet")
public class TravelDetailsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Lấy tham số id từ URL
        String id = request.getParameter("id");

        // Xử lý logic để lấy thông tin chi tiết của chuyến đi có id tương ứng từ cơ sở dữ liệu
        // Ví dụ: sử dụng TravelDAO để lấy thông tin từ cơ sở dữ liệu
        TravelDAO travelDAO = new TravelDAOImpl(); // Thay bằng implement của DAO thực tế
        Travel travel = travelDAO.getTravelById(Integer.parseInt(id));

        // Đặt thông tin chuyến đi vào request attribute để chuyển tới traveldetails.jsp
        request.setAttribute("travel", travel);

        // Chuyển hướng đến traveldetails.jsp
        request.getRequestDispatcher("traveldetails.jsp").forward(request, response);
    }
}
