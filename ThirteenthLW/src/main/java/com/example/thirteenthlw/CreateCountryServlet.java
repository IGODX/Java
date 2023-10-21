package com.example.thirteenthlw;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "CreateCountryServlet", value = "/CreateCountryServlet")
public class CreateCountryServlet extends HttpServlet {
    public void init() throws ServletException {
        connectToDb();
    }
    private Connection connection;
    private Statement statement;
    private boolean connectToDb(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/countries", "root", "");
            statement = connection.createStatement();
            return true;
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    private boolean disconnectFromDb(){
        try {
            connection.close();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("CreateCountry/createCountry.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String countryName = request.getParameter("countryName");
        int population = Integer.parseInt(request.getParameter("population"));
        String command = "INSERT INTO `countries`(`countryName`, `population`) VALUES (?, ?)";
        try( PreparedStatement preparedStatement = connection.prepareStatement(command)) {
            preparedStatement.setString(1, countryName);
            preparedStatement.setInt(2, population);
            preparedStatement.executeUpdate();
            response.sendRedirect("index.jsp");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}