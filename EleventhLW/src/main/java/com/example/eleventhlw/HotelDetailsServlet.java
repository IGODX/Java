package com.example.eleventhlw;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HotelDetailsServlet", value = "/HotelDetailsServlet")
public class HotelDetailsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HotelManager manager = new HotelManager();
        String hotelName = request.getParameter("hotelName");
        var hotelDetails =  manager.getHotelDetails(hotelName);
        request.setAttribute("hotelDetails", hotelDetails);
        request.getRequestDispatcher("hotelDetails.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}