package com.viethuynh;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/deleteTravel")
public class DeleteTravelServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int travelId = Integer.parseInt(request.getParameter("travelId"));


        TravelDAO travelDAO = new TravelDAOImpl();


        boolean isDeleted = travelDAO.deleteTravelById(travelId);

        if (isDeleted) {

            response.sendRedirect("manageTravels");
        } else {

            response.getWriter().println("Xóa chuyến du lịch không thành công");
        }
    }
}