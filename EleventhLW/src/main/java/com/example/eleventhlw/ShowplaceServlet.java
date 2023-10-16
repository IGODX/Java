package com.example.eleventhlw;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ShowplaceServlet", value = "/ShowplaceServlet")
public class ShowplaceServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Showplace> showplaces = List.of(
                new Showplace("Showplace1", "https://wildeast.blog/wp-content/uploads/2021/01/krywyj-rih-sehenswuerdigkeiten_3342-1024x683.jpeg"),
                new Showplace("Showplace2", "https://wildeast.blog/wp-content/uploads/2021/01/krywyj-rih-sehenswuerdigkeiten_3342-1024x683.jpeg"),
                new Showplace("Showplace3", "https://wildeast.blog/wp-content/uploads/2021/01/krywyj-rih-sehenswuerdigkeiten_3342-1024x683.jpeg")
        );
        request.setAttribute("showplaces", showplaces);
        request.getRequestDispatcher("showplaces.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}