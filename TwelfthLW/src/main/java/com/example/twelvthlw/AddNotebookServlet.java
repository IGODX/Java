package com.example.twelvthlw;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "AddNotebookServlet", value = "/AddNotebookServlet")
public class AddNotebookServlet extends HttpServlet {
    private Connection connection;
    private Statement statement;

    @Override
    public void init() throws ServletException {
        connectToDb();
    }

    private boolean connectToDb(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/notebook", "root", "");
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
        String command = "SELECT * FROM `pageappearance`;";
        ArrayList<NotebookAppearance> notebookAppearances = new ArrayList<>();
        ArrayList<Country> countries = new ArrayList<>();
        try {
            ResultSet resultSet = statement.executeQuery(command);
            while (resultSet.next()) {
                String appearance = resultSet.getString("appearance");
                String appearanceId = resultSet.getString("id");
                NotebookAppearance notebookAppearance = new NotebookAppearance(appearanceId, appearance);
                notebookAppearances.add(notebookAppearance);
            }
            command = "SELECT * FROM `country`;";
            resultSet = statement.executeQuery(command);
            while (resultSet.next()) {
                String countryName = resultSet.getString("countryName");
                String countryId = resultSet.getString("id");
                Country country = new Country(countryId, countryName);
                countries.add(country);
            }
            request.setAttribute("notebookAppearances", notebookAppearances);
            request.setAttribute("countries", countries);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        request.getRequestDispatcher("addNotebook.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String manufacturer = request.getParameter("manufacturer");
        String notebookName = request.getParameter("notebookName");
        String numberOfPages = request.getParameter("numberOfPages");
        String isCoverSoft = request.getParameter("isCoverSoft");
        String pageAppearanceId = request.getParameter("pageAppearanceId");
        String countryId = request.getParameter("countryId");

        String insertSql = "INSERT INTO notebook (manufacturer, notebookName, numberOfPages, isCoverSoft, pageAppearanceId, countryId) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        try( PreparedStatement preparedStatement = connection.prepareStatement(insertSql)) {
            preparedStatement.setString(1, manufacturer);
            preparedStatement.setString(2, notebookName);
            preparedStatement.setInt(3, Integer.parseInt(numberOfPages));
            preparedStatement.setInt(4, Integer.parseInt(isCoverSoft));
            preparedStatement.setInt(5, Integer.parseInt(pageAppearanceId));
            preparedStatement.setInt(6, Integer.parseInt(countryId));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    public void destroy() {
        super.destroy();
        disconnectFromDb();
    }
}