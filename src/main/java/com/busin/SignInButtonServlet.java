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

@WebServlet(name = "SignInButtonServlet", value = "/signinbutton-servlet")
public class SignInButtonServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        HttpSession session = request.getSession();
        try{
            Person person=(Person)session.getAttribute("person");
            if(person==null)
                response.sendRedirect("./SignIn.html");
            else
                response.sendRedirect("./MainPage.jsp");

        }
        catch(Exception ex){
            writer.println("Connection failed...");
        }
        finally {
            writer.close();
        }
    }
}