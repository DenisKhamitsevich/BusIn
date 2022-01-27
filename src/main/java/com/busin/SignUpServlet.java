package com.busin;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "SighUpServlet", value = "/signup-servlet")
public class SignUpServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {}
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(-1);
        try{
            String url = "jdbc:mysql://localhost/usersdb?serverTimezone=Europe/Moscow&useSSL=false";
            String username = "root";
            String password = "superpassword";
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                String sql = "SELECT * FROM users WHERE email=?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                    preparedStatement.setString(1, request.getParameter("email"));
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if(resultSet.next())
                    {
                       response.sendRedirect("./SignUpError.html");
                    }
                    else
                    {
                        sql = "INSERT INTO users (email, password, name, surname,amount_of_com,amount_of_ppl,amount_of_deals) Values (?, ?, ?, ?, ?, ?, ?)";
                        try(PreparedStatement preparedStatementR = conn.prepareStatement(sql)){
                            preparedStatementR.setString(1, request.getParameter("email"));
                            preparedStatementR.setString(2, request.getParameter("password"));
                            preparedStatementR.setString(3, request.getParameter("name"));
                            preparedStatementR.setString(4, request.getParameter("surname"));
                            preparedStatementR.setInt(5,0);
                            preparedStatementR.setInt(6,0);
                            preparedStatementR.setInt(7,0);
                            preparedStatementR.executeUpdate();
                        }
                        session.setAttribute("email",request.getParameter("email"));
                        response.sendRedirect("mainpage-servlet");
                    }
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