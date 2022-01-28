package com.busin;

import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(displayName = "supportServlet", value = "/support-servlet")
public class SupportServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {}
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String path = "./SupportPage.html";
        response.sendRedirect(path);
    }

    public void destroy() {
    }
}