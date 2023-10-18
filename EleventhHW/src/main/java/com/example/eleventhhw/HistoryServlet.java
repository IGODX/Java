package com.example.eleventhhw;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "HistoryServlet", value = "/HistoryServlet")
public class HistoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ManufacturerHistory manufacturerHistory = new ManufacturerHistory(
            "HP was founded by Bill Hewlett and Dave Packard in 1939. Their first product was an audio oscillator and one of their first customers Walt Disney. Disney used the oscillator to test audio equipment in the 12 specially equipped theaters showing Fantasia in 1940. HP entered the computer market with the HP 2116A in 1966.",
            new ArrayList<>(List.of("https://www.hp.com/us-en/shop/tech-takes/history-of-hp",
                    "https://www.britannica.com/topic/Hewlett-Packard-Company")));
    request.setAttribute("manufacturerHistory", manufacturerHistory);
        request.getRequestDispatcher("manufacturerHistory.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}