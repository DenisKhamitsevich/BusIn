package com.busin;

import model.Company;
import model.People;
import model.Person;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "PeopleServlet", value = "/people-servlet")
public class PeopleServlet extends HttpServlet {

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
                String sql = "SELECT * FROM people WHERE email=? ORDER BY id DESC";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                    preparedStatement.setString(1,(String)session.getAttribute("email"));
                    ResultSet resultSet = preparedStatement.executeQuery();
                    ArrayList<People> people=new ArrayList<>();
                    while(resultSet.next())
                    {
                        People man=new People(resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),
                                resultSet.getString(5),resultSet.getString(6),resultSet.getInt(7));
                        people.add(man);
                    }
                    session.setAttribute("people", people);
                    response.sendRedirect("./People.jsp");
                }



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