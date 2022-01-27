package com.busin;

import model.Person;

import java.io.*;
import java.sql.*;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "SettingsServlet", value = "/settings-servlet")
public class SettingsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        HttpSession session = request.getSession();
        try{
            String url = "jdbc:mysql://localhost/usersdb?serverTimezone=Europe/Moscow&useSSL=false";
            String username = "root";
            String password = "superpassword";
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                String sql = "SELECT * FROM users WHERE email=?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                    preparedStatement.setString(1, (String)session.getAttribute("email"));
                    ResultSet resultSet = preparedStatement.executeQuery();
                    resultSet.next();
                    session.setAttribute("name",resultSet.getString(3));
                    session.setAttribute("surname",resultSet.getString(4));
                }
                response.sendRedirect("./Settings.jsp");




            }
        }
        catch(Exception ex){
            writer.println("Connection failed...");
            writer.println(ex);
        }
        finally {
            writer.close();
        }
    }
}