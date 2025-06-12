package com.example.backend.controller;

import com.example.backend.dao.AdminDao;
import com.example.backend.model.Admin;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpSession;

@WebServlet("/api/v1/admin")
public class AdminServlet extends HttpServlet{

    private AdminDao adminDao;

    public void init() throws jakarta.servlet.ServletException {
        adminDao = new AdminDao();
    };

    protected void doPost(jakarta.servlet.http.HttpServletRequest req, jakarta.servlet.http.HttpServletResponse resp) throws jakarta.servlet.ServletException ,java.io.IOException {
        HttpSession session = req.getSession(false);

        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        Admin admin = new Admin();
        admin.setName(name);
        admin.setEmail(email);
        admin.setPassword(password);

        adminDao.addAdmin(admin);
        // session.setAttribute("admin", admin);
    };
}
