package com.viethuynh;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/userview")
public class UserTravelServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TravelDAO travelDAO = new TravelDAOImpl();
        List<Travel> travels = travelDAO.getAllTravels();

        request.setAttribute("travels", travels);
        request.getRequestDispatcher("userview.jsp").forward(request, response);
    }
}