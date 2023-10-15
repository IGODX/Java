package com.example.tenthlw;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "GuessNumberServlet", value = "/GuessNumberServlet")
public class GuessNumberServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String compareValue = request.getParameter("compare");
        int number = Integer.parseInt(request.getParameter("number"));
        int left = Integer.parseInt(request.getParameter("left"));
        int right = Integer.parseInt(request.getParameter("right"));
        PrintWriter out = response.getWriter();
        switch (compareValue) {
            case "Greater": {
                left = number + 1;
                break;
            }
            case "Smaller": {
                right = number - 1;
                break;
            }
            case "Equals": {
                out.println("<h1>You have won! The number was " + number + "</h1>");
                return;
            }
        }

        int middle = left + (right - left) / 2;
        printForm(out, middle, left, right);
    }



    private void printForm(PrintWriter out, int middle,int left, int right){
        out.println("    <form action=\"GuessNumberServlet\" method=\"POST\">\n" +
                "        <input type=\"hidden\" name=\"number\" value=\"" + middle + "\">\n" +
                "        <input type=\"hidden\" name=\"left\" value=\"" + left + "\">\n" +
                "        <input type=\"hidden\" name=\"right\" value=\"" + right + "\">\n" +
                "        <label>The number is " + middle + "</label>\n" +
                "        <input type=\"submit\" name=\"compare\" value=\"Greater\">\n" +
                "        <input type=\"submit\" name=\"compare\" value=\"Smaller\">\n" +
                "        <input type=\"submit\" name=\"compare\" value=\"Equals\">\n" +
                "    </form>" +
                "<a href=\"index.jsp\">Go back</a>");
    }

}