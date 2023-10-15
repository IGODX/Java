package com.example.tenthlw;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
@WebServlet(name = "MaxNumberServlet", value = "/Max-Number-Servlet")
public class MaxNumberServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String number1Str = request.getParameter("number1");
        String number2Str = request.getParameter("number2");
        String number3Str = request.getParameter("number3");

        try {
            double number1 = Double.parseDouble(number1Str);
            double number2 = Double.parseDouble(number2Str);
            double number3 = Double.parseDouble(number3Str);

            double max = Math.max(Math.max(number1, number2), number3);

            response.getWriter().println("<h2>Max : " + max+ "</h2>");

        } catch (NumberFormatException e) {
        }
    }
}