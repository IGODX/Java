package com.example.tenthlw;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "FormServlet", value = "/FormServlet")
public class FormServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String fullName = request.getParameter("fullName");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        int age = Integer.parseInt(request.getParameter("age"));
        String gender = request.getParameter("gender");
        boolean subscribe = request.getParameter("subscribe") != null;


        request.setAttribute("fullName", fullName);
        request.setAttribute("phone", phone);
        request.setAttribute("email", email);
        request.setAttribute("age", age);
        request.setAttribute("gender", gender);
        request.setAttribute("subscribe", subscribe);

        RequestDispatcher dispatcher = request.getRequestDispatcher("resultForm.jsp");
        dispatcher.forward(request, response);
    }
}