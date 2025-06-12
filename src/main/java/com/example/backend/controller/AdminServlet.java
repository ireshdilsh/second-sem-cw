package com.example.backend.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Map;

import org.apache.commons.dbcp2.BasicDataSource;

import com.example.backend.model.Admin;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/api/v1/admin")
public class AdminServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        BasicDataSource dataSource = (BasicDataSource) getServletContext().getAttribute("dataSource");

        try {
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }   

    // try {
    // Admin data = mapper.readValue(req.getInputStream(), Admin.class);

    // Connection connection = ds.getConnection();
    // PreparedStatement statement = connection.prepareStatement(
    // "INSERT INTO users (name, email, password) VALUES (?, ?, ?)");

    // statement.setString(1, data.getName());
    // statement.setString(2, data.getEmail());
    // statement.setString(3, data.getPassword());

    // int rows = statement.executeUpdate();

    // resp.setContentType("application/json");
    // mapper.writeValue(resp.getWriter(), Map.of("rowsAffected", rows));
    // } catch (Exception e) {
    // e.printStackTrace();
    // resp.setStatus(500);
    // mapper.writeValue(resp.getWriter(), Map.of("error", "Failed to create
    // admin"));
    // }
    // }

}
