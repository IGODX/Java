package com.example.tenthhw;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "MaxServlet", value = "/MaxServlet")
public class MaxServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String num1Str = request.getParameter("num1");
        String num2Str = request.getParameter("num2");
        String num3Str = request.getParameter("num3");
        String operation = request.getParameter("operation");
        try {
            int num1 = Integer.parseInt(num1Str);
            int num2 = Integer.parseInt(num2Str);
            int num3 = Integer.parseInt(num3Str);


            switch (operation){
                case "maximum":{
                    out.println("Max : "+ Math.max(Math.max(num1, num2), num3));
                 break;
                }
                case "minimum" : {
                    out.println("Min : "+ Math.min(Math.min(num1, num2), num3));
                    break;
                }
                case "average" :{
                    out.println("Avg : "+ (num1 + num2 + num3) / 3);
                    break;
                }
                default: break;
            }
        }
        catch (NumberFormatException e) {
        }
    }
}