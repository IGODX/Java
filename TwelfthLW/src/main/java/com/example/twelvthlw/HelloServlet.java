package com.example.twelvthlw;

import java.io.*;
import java.sql.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    private Connection connection;
    private Statement statement;

    public void init() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "");
            String sql = "CREATE TABLE IF NOT EXISTS myuser ( id INT NOT NULL AUTO_INCREMENT, firstname VARCHAR(50) NOT NULL, surname VARCHAR(50) NOT NULL, PRIMARY KEY (id) );";
            statement = connection.createStatement();
            statement.execute(sql);
            String sqlToFill = "insert into myuser(firstname, surname) values('Bojko1', 'Dmytro1'), ('Kalushko1', 'Lena1')";
            statement.execute(sqlToFill);
        }
                catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        String sql = "SELECT * FROM myuser";
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()) {
                String firstname = resultSet.getString("firstname");
                String lastname = resultSet.getString("surname");
                out.println("<p>" + firstname + " " + lastname + "</p>");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        out.println("</body></html>");
    }

    public void destroy() {
    }
}