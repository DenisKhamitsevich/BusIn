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

@WebServlet(name = "AddNewCompanyServlet", value = "/addnewcompany-servlet")
public class AddNewCompanyServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {}
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter writer = response.getWriter();
        HttpSession session = request.getSession();
        try{
            String url = "jdbc:mysql://localhost/usersdb?serverTimezone=Europe/Moscow&useSSL=false";
            String username = "root";
            String password = "superpassword";
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            Person person=(Person)session.getAttribute("person");
            int new_amount=person.getAmount_of_com()+1;

            try (Connection conn = DriverManager.getConnection(url, username, password)){
                String sql = "INSERT INTO companies (email, company_name, company_site, company_phone,company_address,company_location,id) Values (?, ?, ?, ?, ?, ?, ?)";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                    preparedStatement.setString(1,(String)session.getAttribute("email"));
                    preparedStatement.setString(2,request.getParameter("name"));
                    preparedStatement.setString(3,request.getParameter("site"));
                    preparedStatement.setString(4,request.getParameter("phone"));
                    preparedStatement.setString(5,request.getParameter("address"));
                    preparedStatement.setString(6,request.getParameter("location"));
                    preparedStatement.setInt(7,new_amount);
                    person.setAmount_of_com(new_amount);
                    preparedStatement.executeUpdate();
                    session.removeAttribute("person");
                    session.setAttribute("person",person);
                }
                sql="UPDATE users SET amount_of_com = ? WHERE email = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql))
                {
                    preparedStatement.setInt(1,new_amount);
                    preparedStatement.setString(2,(String)session.getAttribute("email"));
                    preparedStatement.executeUpdate();
                }



                response.sendRedirect("companies-servlet");



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