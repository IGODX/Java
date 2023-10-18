package com.example.eleventhhw;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "ModelDetailsServlet", value = "/ModelDetailsServlet")
public class ModelDetailsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String description = request.getParameter("name");
        Map<String, ModelDetails> modelDetailsMap = new HashMap<>();
        modelDetailsMap.put("Laptop1", new ModelDetails(new ArrayList<>(List.of("https://content1.rozetka.com.ua/goods/images/big/325101635.jpg",
                "https://content.rozetka.com.ua/goods/images/big/353460956.jpg")), "More information about laptop"));
        modelDetailsMap.put("Laptop2", new ModelDetails(new ArrayList<>(List.of("empty", "empty")), "more useful info"));
        var model = modelDetailsMap.get(description);
        request.setAttribute("model", model);
        request.getRequestDispatcher("modelDetails.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}