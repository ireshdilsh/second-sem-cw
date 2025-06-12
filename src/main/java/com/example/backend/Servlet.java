package com.example.backend;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

@WebServlet("/hi")
public class Servlet extends HttpServlet{
    protected void doGet(jakarta.servlet.http.HttpServletRequest req, jakarta.servlet.http.HttpServletResponse resp) throws jakarta.servlet.ServletException ,java.io.IOException {
        resp.getWriter().println("This Project Working");
    };
}
