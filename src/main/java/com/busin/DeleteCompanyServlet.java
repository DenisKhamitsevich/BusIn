package com.busin;

import model.Company;
import model.Person;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "DeleteCompanyServlet", value = "/deletecompany-servlet")
public class DeleteCompanyServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        HttpSession session = request.getSession();
        Cookie[] cookies = request.getCookies();
        String cookieName = "company";
        Cookie cookie = null;
        for(Cookie temp: cookies) {
            if(cookieName.equals(temp.getName())) {
                cookie = temp;
                break;
            }
        }
        String cookieValue=cookie.getValue();

        try{
            String url = "jdbc:mysql://localhost/usersdb?serverTimezone=Europe/Moscow&useSSL=false";
            String username = "root";
            String password = "superpassword";
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                String sql = "DELETE FROM companies WHERE id=?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                    preparedStatement.setString(1,cookieValue);
                    preparedStatement.executeUpdate();
                }
                sql="UPDATE users SET amount_of_com = ? WHERE email = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql))
                {
                    Person person=(Person)session.getAttribute("person");
                    int new_amount=person.getAmount_of_com()-1;
                    preparedStatement.setInt(1,new_amount);
                    preparedStatement.setString(2,(String)session.getAttribute("email"));
                    preparedStatement.executeUpdate();
                    person.setAmount_of_com(new_amount);
                    session.removeAttribute("person");
                    session.setAttribute("person",person);
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