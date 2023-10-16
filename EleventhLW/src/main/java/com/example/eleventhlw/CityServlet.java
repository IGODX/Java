package com.example.eleventhlw;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CityServlet", value = "/CityServlet")
public class CityServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        City city = new City("Kriviy Rih",
                "Ukraine",
                "https://upload.wikimedia.org/wikipedia/commons/9/96/Kryvyi_Rih_Old_Town_%28cropped%29.jpg",
                42, "Kryvyi Rih (/ˈkrɪviː ˈriː/; Ukrainian: Кривий Ріг, IPA: [krɪˌwɪj ˈr⁽ʲ⁾iɦ]), also transliterated as Krivoy Rog (Russian: Кривой Рог),[4] is a city in central Ukraine. It hosts the administration of Kryvyi Rih Raion and its subordinate Kryvyi Rih urban hromada in Dnipropetrovsk Oblast.[5] The city is part of the Kryvyi Rih Metropolitan Region. Its population is estimated at 603,904 (2022 estimate),[6] making it the seventh-most populous city in Ukraine and the second largest by area. Kryvyi Rih is claimed to be the longest city in Europe.[7][8]\n" +
                "\n" +
                "Located at the confluence of the Saksahan and Inhulets rivers, Kryvyi Rih was founded as a military staging post in 1775. Urban-industrial growth followed Belgian, French and British investment in the exploitation of the area's rich iron-ore deposits, generally called Kryvbas, in the 1880s. Kryvyi Rih gained city status after the October Revolution in 1919.\n" +
                "\n" +
                "Stalin-era industrialisation built Kryvorizhstal in 1934, the largest integrated metallurgical works in the Soviet Union. After a brutal German occupation in World War II, Kryvyi Rih experienced renewed growth through to the 1970s. The economic dislocation associated with the break-up of the Soviet Union contributed to high unemployment and a large-scale exodus from the city in the 1990s. The privatization of Kryvorizhstal in 2005 was followed by increased foreign and private investment which helped finance urban regeneration. Beginning in 2017, there were major labour protests and strikes.");
        request.setAttribute("city", city);
        request.getRequestDispatcher("city.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}