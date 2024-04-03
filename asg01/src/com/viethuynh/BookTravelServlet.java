package com.viethuynh;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@WebServlet("/BookTravelServlet")
public class BookTravelServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String travelId = request.getParameter("travelId");
        String userId = request.getParameter("userId"); // Assuming you have user authentication
        
        // Perform the booking process
        try {
            // Assuming you have a method in your DAO to handle the booking process
            TravelDAO travelDAO = new TravelDAOImpl();
            boolean isBooked = travelDAO.bookTravel(Integer.parseInt(travelId), Integer.parseInt(userId));
            
            if (isBooked) {
                // Redirect to a success page upon successful booking
                response.sendRedirect("success.jsp");
            } else {
                // Redirect to an error page if the booking fails
                response.sendRedirect("error.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Redirect to an error page if an exception occurs during booking
            response.sendRedirect("error.jsp");
        }
    }
}
