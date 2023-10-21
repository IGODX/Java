package com.example.twelvthlw;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "NotebookServlet", value = "/NotebookServlet")
public class NotebookServlet extends HttpServlet {
    public void init() {
       try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/notebook", "root", "")) {
            String sql = "";
            String sqlToFill = "";
            Statement statement = connection.createStatement();
                sql = "CREATE TABLE IF NOT EXISTS pageappearance( id INT NOT NULL AUTO_INCREMENT, " +
                    "appearance VARCHAR(30) not null, " +
                    "PRIMARY KEY (id) );";

            statement.execute(sql);
            sql = "CREATE TABLE IF NOT EXISTS country( id INT NOT NULL AUTO_INCREMENT, " +
                    "countryName VARCHAR(30) not null, " +
                    "PRIMARY KEY (id) );";
            statement.execute(sql);
            sqlToFill = "insert into country(countryName) values('Ukraine'), ('USA'), ('China');";
            statement.execute(sqlToFill);
            sqlToFill = "insert into pageappearance(appearance) values('cell'), ('ruler'), ('empty');";
            statement.execute(sqlToFill);
            sql = "CREATE TABLE IF NOT EXISTS notebook ( id INT NOT NULL AUTO_INCREMENT, " +
                    "manufacturer VARCHAR(50) NOT NULL, " +
                    "notebookName VARCHAR(50) NOT NULL, " +
                    "numberOfPages INT NOT NULL, " +
                    "isCoverSoft TINYINT NOT NULL, " +
                    "pageAppearanceId INT, "+
                    "countryId INT NOT NULL, " +
                    "PRIMARY KEY (id), " +
                    "FOREIGN KEY (countryId) REFERENCES country(id), " +
                    "FOREIGN KEY (pageAppearanceId) REFERENCES pageappearance(id) );";

            statement.execute(sql);
            sqlToFill = "INSERT INTO notebook (manufacturer, notebookName, numberOfPages, isCoverSoft, countryId, pageAppearanceId) VALUES " +
                    "('Manufacturer1', 'Notebook1', 100, 1, 1, 1), " +
                    "('Manufacturer2', 'Notebook2', 200, 0, 2, 2), " +
                    "('Manufacturer3', 'Notebook3', 150, 1, 3, 3);";
            statement.execute(sqlToFill);
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}