package com.example.eleventhhw;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "ModelsServlet", value = "/ModelsServlet")
public class ModelsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<LaptopModel> laptops = new ArrayList<>(List.of(
                new LaptopModel("Laptop1",
                        "https://scdn.comfy.ua/89fc351a-22e7-41ee-8321-f8a9356ca351/https://cdn.comfy.ua/media/catalog/product/c/0/c07951362.jpg_1_.jpg/w_600"),
                new LaptopModel("Laptop2",
                        "https://content2.rozetka.com.ua/goods/images/big/325101633.jpg")
                ));
        request.setAttribute("laptops", laptops);
        request.getRequestDispatcher("models.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}