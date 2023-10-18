package com.example.eleventhhw;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "ManufacturerServlet", value = "/ManufacturerServlet")
public class ManufacturerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LaptopManufacturer manufacturer = new LaptopManufacturer(
                "HP",
                "EU",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/2/29/HP_New_Logo_2D.svg/2048px-HP_New_Logo_2D.svg.png",
                1000,
                "HP manufacturer"
        );
        request.setAttribute("manufacturer", manufacturer);
        request.getRequestDispatcher("manufacturerInform.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}