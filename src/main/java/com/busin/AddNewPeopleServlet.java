package com.busin;

import model.Company;
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

@WebServlet(name = "AddNewPeopleServlet", value = "/addnewpeople-servlet")
public class AddNewPeopleServlet extends HttpServlet {

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
            int new_amount=person.getAmount_of_ppl()+1;

            try (Connection conn = DriverManager.getConnection(url, username, password)){
                String sql = "INSERT INTO people (email, name, company, phone, role,custom_email,id) Values (?, ?, ?, ?, ?, ?, ?)";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                    preparedStatement.setString(1,(String)session.getAttribute("email"));
                    preparedStatement.setString(2,request.getParameter("name"));
                    preparedStatement.setString(3,request.getParameter("company"));
                    preparedStatement.setString(4,request.getParameter("phone"));
                    preparedStatement.setString(5,request.getParameter("role"));
                    preparedStatement.setString(6,request.getParameter("custom_email"));
                    preparedStatement.setInt(7,new_amount);
                    person.setAmount_of_ppl(new_amount);
                    preparedStatement.executeUpdate();
                    session.removeAttribute("person");
                    session.setAttribute("person",person);
                }
                sql="UPDATE users SET amount_of_ppl = ? WHERE email = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql))
                {
                    preparedStatement.setInt(1,new_amount);
                    preparedStatement.setString(2,(String)session.getAttribute("email"));
                    preparedStatement.executeUpdate();
                }



                response.sendRedirect("people-servlet");



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