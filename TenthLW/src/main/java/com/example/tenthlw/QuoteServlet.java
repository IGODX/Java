package com.example.tenthlw;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "quoteServlet", value = "/quote-servlet")
public class QuoteServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<div>Any fool can write code that a computer can understand. Good programmers write code that humans can\n" +
                "understand</div>");
        out.println("</body></html>");
    }

}
