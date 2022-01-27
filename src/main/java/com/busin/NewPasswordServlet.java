package com.busin;

import model.Person;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "NewPasswordServlet", value = "/newpassword-servlet")
public class NewPasswordServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        HttpSession session = request.getSession();
        try{
            String url = "jdbc:mysql://localhost/usersdb?serverTimezone=Europe/Moscow&useSSL=false";
            String username = "root";
            String password = "superpassword";
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            Person person=(Person)session.getAttribute("person");
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                String sql="UPDATE users SET password = ? WHERE email = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql))
                {
                    preparedStatement.setString(1,request.getParameter("new_password"));
                    person.setPassword(request.getParameter("new_password"));
                    preparedStatement.setString(2,(String)session.getAttribute("email"));
                    preparedStatement.executeUpdate();
                }
                session.removeAttribute("person");
                session.setAttribute("person",person);
                response.sendRedirect("settings-servlet");
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