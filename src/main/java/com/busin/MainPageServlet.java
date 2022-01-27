package com.busin;

import model.Person;

import java.io.*;
import java.sql.*;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "MainPageServlet", value = "/mainpage-servlet")
public class MainPageServlet extends HttpServlet {

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
                    Date currentdate=new Date();
                    String result="";
                    int hours=currentdate.getHours();
                    Person person=new Person(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),
                            resultSet.getString(4),resultSet.getInt(5),resultSet.getInt(6),
                            resultSet.getInt(7)
                    );
                    session.setAttribute("person",person);
                    if((hours<=11)&&(hours>=4))
                        result="Доброе утро";
                    else
                        if((hours<17)&&(hours>11))
                            result="Добрый день";
                        else
                            result="Добрый вечер";

                    session.setAttribute("part_of_the_day",result);
                }
                response.sendRedirect("./MainPage.jsp");




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