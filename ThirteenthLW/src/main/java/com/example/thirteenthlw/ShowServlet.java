package com.example.thirteenthlw;

import java.io.*;
import java.sql.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "ShowServlet", value = "/ShowServlet")
public class ShowServlet extends HttpServlet {
    private Connection connection;
    private Statement statement;
    public void init() {
        connectToDb();
    }
    private void disconnectFromDb(){
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void destroy() {
        super.destroy();
        disconnectFromDb();
    }
    private void connectToDb(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/countries", "root", "");
            statement = connection.createStatement();
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        try {
            showAllCountries(out);
            showAllCities(out, 1);
            showAllCapitals(out);
            showThreeCountriesWithMostNumberOfCities(out);
            ShowThreeCountriesWithTheSmallestNumberOfPopulation(out);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void showAllCountries(PrintWriter out) throws SQLException {
        String command = "SELECT * FROM `countries`;";
        ResultSet resultSet = statement.executeQuery(command);
        while(resultSet.next()){
            String countryName =resultSet.getString("countryName");
            String id =resultSet.getString("id");
            out.println("<form method='post' action='DeleteCountryServlet'>");
            out.println("<input type='hidden' name='id' value='" + id + "'>");
            out.println("<h3>" + countryName + "</h3>");
            out.println("<input type='submit' value='Delete'>");
            out.println("</form>");
        }
    }

    private void showAllCities(PrintWriter out, int id){
        String command = "SELECT cityName FROM `cities` WHERE countryId = ?;";
        out.println("<h2>All cities of Ukraine</h2>");
        try( PreparedStatement preparedStatement = connection.prepareStatement(command)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String cityName = resultSet.getString("cityName");
                out.println("<h3>" + cityName + "</h3>");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void showAllCapitals(PrintWriter out){
        String command = "SELECT cities.cityName FROM countrycapital LEFT JOIN cities ON countrycapital.cityId = cities.id;";
        out.println("<h2>All capitals</h2>");
        try {
            ResultSet resultSet = statement.executeQuery(command);
            while (resultSet.next()) {
                String cityName = resultSet.getString("cityName");
                out.println("<h3>" + cityName + "</h3>");
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    private void showThreeCountriesWithMostNumberOfCities(PrintWriter out){
        String command = "SELECT countries.countryName, COUNT(cities.id) AS cityCount FROM countries " +
                "LEFT JOIN cities ON countries.id = cities.countryId " +
                "GROUP BY countries.countryName " +
                "ORDER BY cityCount DESC " +
                "LIMIT 3;";
        try {
            ResultSet resultSet = statement.executeQuery(command);
            while (resultSet.next()) {
                String countryName = resultSet.getString("countryName");
                int cityCount = resultSet.getInt("cityCount");
                out.println("<h3>" + countryName + " count: " + cityCount + "</h3>");
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    private void ShowThreeCountriesWithTheSmallestNumberOfPopulation(PrintWriter out){
        String command = "SELECT countries.countryName, SUM(countries.population) AS totalPopulation FROM countries " +
                "GROUP BY countries.countryName " +
                "ORDER BY totalPopulation ASC " +
                "LIMIT 3;";
        try {
            ResultSet resultSet = statement.executeQuery(command);
            while (resultSet.next()) {
                String countryName = resultSet.getString("countryName");
                int totalPopulation = resultSet.getInt("totalPopulation");
                out.println("<h3>" + countryName + " count: " + totalPopulation + "</h3>");
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}