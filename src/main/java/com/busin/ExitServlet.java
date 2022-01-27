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

@WebServlet(name = "ExitServlet", value = "/exit-servlet")
public class ExitServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        HttpSession session = request.getSession();
        try{
            session.invalidate();
            response.sendRedirect("./index.jsp");
        }
        catch(Exception ex){
            writer.println("Connection failed...");
        }
        finally {
            writer.close();
        }
    }
}