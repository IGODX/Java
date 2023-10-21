package com.example.twelvthlw;

import java.io.*;
import java.sql.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "ShowNotebookServlet", value = "/ShowNotebookServlet")
public class ShowNotebookServlet extends HttpServlet {
    private Connection connection;
    private Statement statement;
    public void init() {
        connectToDb();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        showAllNotebooks(request, out);
        showAllCountries(request, out);
        showCountryNamesAndNumberOfNotebooks(request, out);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    private void showAllNotebooks(HttpServletRequest request,  PrintWriter out){
        String command = "SELECT * FROM `notebook`;";
        out.println("<h2>showAllNotebooks</h2>");
        try {
            ResultSet resultSet = statement.executeQuery(command);
            while(resultSet.next()) {
                String manufacturer = resultSet.getString("manufacturer");
                String manufacturerId = resultSet.getString("id");
                String notebookName = resultSet.getString("notebookName");
                String numberOfPages = resultSet.getString("numberOfPages");
                String isCoverSoft = resultSet.getString("isCoverSoft");
                String pageAppearanceId = resultSet.getString("pageAppearanceId");
                String countryId = resultSet.getString("countryId");
                out.println("<div style='margin-bottom: 50px;'>");
                out.println("<h3>Manufacturer " + manufacturer + "</h3>");
                out.println("<p>Notebook name " + notebookName + "</p>");
                out.println("<p>Number of pages " + numberOfPages + "</p>");
                out.println("<p>Is cover soft " + isCoverSoft + "</p>");
                out.println("<p>Is cover soft" + isCoverSoft + "</p>");
                out.println("<p>Page appearance id " + pageAppearanceId + "</p>");
                out.println("<p>Country id " + countryId + "</p>");
                out.println("<form action='DeleteNotebookServlet' method='POST'>");
                out.println("<input type='hidden' name='id' value='" + manufacturerId + "'>");
                out.println("<input type='submit' value='Delete'");
                out.println("</form>");
                out.println("<a href='EditNotebookServlet?id="+ manufacturerId + "'>Edit</a>");
                out.println("</div>");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void showAllCountries(HttpServletRequest request,  PrintWriter out){
        String command = "SELECT * FROM `country`;";
        out.println("<h2>showAllCountries</h2>");
        try {
            ResultSet resultSet = statement.executeQuery(command);
            while(resultSet.next()) {
                String countryName = resultSet.getString("countryName");
                out.println("<div style='margin-bottom: 50px;'>");
                out.println("<p>Country name : " + countryName + "</p>");
                out.println("</div>");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void connectToDb(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/notebook", "root", "");
            statement = connection.createStatement();
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void showCountryNamesAndNumberOfNotebooks(HttpServletRequest request,  PrintWriter out){
        String command = "SELECT country.countryName, COUNT(notebook.id) AS notebookCount " +
                                           "FROM country " +
                                           "LEFT JOIN notebook ON country.id = notebook.countryId " +
                                           "GROUP BY country.countryName";
        out.println("<h2>showCountryNamesAndNumberOfNotebooks</h2>");
        try {
            ResultSet resultSet = statement.executeQuery(command);
            while(resultSet.next()) {
                String countryName = resultSet.getString("countryName");
                int notebookCount = resultSet.getInt("notebookCount");
                out.println("<div style='margin-bottom: 50px;'>");
                out.println("<p>Country name : " + countryName + "</p>");
                out.println("<p>Notebook count : " + notebookCount + "</p>");
                out.println("</div>");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void showManufacturerNameAndNumberOfNotebooks(HttpServletRequest request,  PrintWriter out) {

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
}