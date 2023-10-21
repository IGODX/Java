package com.example.thirteenthlw;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "CreateDatabaseServlet", value = "/CreateDatabaseServlet")
public class CreateDatabaseServlet extends HttpServlet {
    private Connection connection;

    private Statement statement;

    public void init() {
        connectToDb();
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
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String command = "CREATE TABLE countries ( id INT PRIMARY KEY AUTO_INCREMENT, " +
                    "countryName VARCHAR(255) not null, " +
                    "population INT not null);";
            statement.execute(command);

            command = "CREATE TABLE cities ( id INT PRIMARY KEY AUTO_INCREMENT, " +
                    "cityName VARCHAR(255) not null, " +
                    "countryID INT NOT NULL, " +
                    "FOREIGN KEY (countryID) REFERENCES countries(id) );";
            statement.execute(command);

            command = "CREATE TABLE countryCapital ( id INT PRIMARY KEY AUTO_INCREMENT, " +
                    "cityId INT not null, " +
                    "countryId INT not null, " +
                    "FOREIGN KEY (cityId) REFERENCES cities(id), " +
                    "FOREIGN KEY (countryId) REFERENCES countries(id) );";
            statement.execute(command);

            command = "CREATE TABLE cityDetails ( id INT PRIMARY KEY AUTO_INCREMENT, " +
                    "cityId INT not null, " +
                    "population INT not null, " +
                    "FOREIGN KEY (cityId) REFERENCES cities(id) );";
            statement.execute(command);

            String sqlToFill = "INSERT INTO countries (countryName, population) VALUES " +
                    "('Ukraine', 440000), " +
                    "('United States of America', 331000), " +
                    "('China', 1402000);";
            statement.execute(sqlToFill);

            sqlToFill = "INSERT INTO cities (cityName, countryID) VALUES ('Kiev', 1), " +
                    "('Washington', 2), " +
                    "('Beijing', 3), " +
                    "('Lviv', 1), " +
                    "('New York', 2), " +
                    "('Shanghai', 3);";
            statement.execute(sqlToFill);

            sqlToFill = "INSERT INTO cityDetails (cityId, population) VALUES " +
                    "(1, 1000000), " +
                    "(2, 5000000), " +
                    "(3, 2500000);";
            statement.execute(sqlToFill);

            sqlToFill = "INSERT INTO countryCapital (cityId, countryId) VALUES (1, 1), " +
                    "(2, 2), " +
                    "(3, 3);";
            statement.execute(sqlToFill);
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}