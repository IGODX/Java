package com.example.twelvthlw;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "EditNotebookServlet", value = "/EditNotebookServlet")
public class EditNotebookServlet extends HttpServlet {
    private Connection connection;
    private Statement statement;
    public void init() {
        connectToDb();
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
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String command = "SELECT * FROM `notebook` where id = " + id;
        ArrayList<NotebookAppearance> notebookAppearances = new ArrayList<>();
        ArrayList<Country> countries = new ArrayList<>();
        try {
            ResultSet resultSet = statement.executeQuery(command);
            Notebook notebook = new Notebook();
            while(resultSet.next()) {

                notebook.setManufacturer(resultSet.getString("manufacturer"));
                notebook.setId(resultSet.getInt("id"));
                notebook.setNotebookName(resultSet.getString("notebookName"));
                notebook.setNumberOfPages(resultSet.getInt("numberOfPages"));
                notebook.setCoverSoft(resultSet.getBoolean("isCoverSoft"));
                notebook.setPageAppearanceId(resultSet.getInt("pageAppearanceId"));
                notebook.setCountryId(resultSet.getInt("countryId"));
            }
            command = "SELECT * FROM `pageappearance`;";
            resultSet = statement.executeQuery(command);
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
            request.setAttribute("notebook", notebook);
            request.setAttribute("countries", countries);
            request.getRequestDispatcher("editNotebook.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String manufacturer = request.getParameter("manufacturer");
        String notebookName = request.getParameter("notebookName");
        int numberOfPages = Integer.parseInt(request.getParameter("numberOfPages"));
        int isCoverSoft = Integer.parseInt(request.getParameter("isCoverSoft"));
        int pageAppearanceId = Integer.parseInt(request.getParameter("pageAppearanceId"));
        int countryId = Integer.parseInt(request.getParameter("countryId"));
        String command = "UPDATE `notebook` SET `manufacturer`=?, `notebookName`=?, `numberOfPages`=?, `isCoverSoft`=?, `pageAppearanceId`=?, `countryId`=? WHERE id=?";

            try(PreparedStatement preparedStatement = connection.prepareStatement(command)) {

                preparedStatement.setString(1, manufacturer);
                preparedStatement.setString(2, notebookName);
                preparedStatement.setInt(3, numberOfPages);
                preparedStatement.setInt(4, isCoverSoft);
                preparedStatement.setInt(5, pageAppearanceId);
                preparedStatement.setInt(6, countryId);
                preparedStatement.setInt(7, id);
                preparedStatement.executeUpdate();
                response.sendRedirect("index.jsp");
            } catch (SQLException e){
                    throw new RuntimeException(e);
                }
            }
}