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

@WebServlet(name = "CompaniesServlet", value = "/companies-servlet")
public class CompaniesServlet extends HttpServlet {

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
                String sql = "SELECT * FROM companies WHERE email=? ORDER BY id DESC";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                    preparedStatement.setString(1,(String)session.getAttribute("email"));
                    ResultSet resultSet = preparedStatement.executeQuery();
                    ArrayList<Company> companies=new ArrayList<>();
                    while(resultSet.next())
                    {
                        Company company=new Company(resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),
                                resultSet.getString(5),resultSet.getString(6),resultSet.getInt(7));
                        companies.add(company);
                    }
                    session.setAttribute("companies", companies);
                    response.sendRedirect("./Companies.jsp");


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