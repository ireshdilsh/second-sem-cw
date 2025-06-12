package com.example.backend.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Map;

import org.apache.commons.dbcp2.BasicDataSource;

import com.example.backend.model.Admin;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpSession;

@WebServlet("/api/v1/admin")
public class AdminServlet extends HttpServlet{
//  protected void doPost(jakarta.servlet.http.HttpServletRequest req, jakarta.servlet.http.HttpServletResponse resp) throws jakarta.servlet.ServletException ,java.io.IOException {
//      ObjectMapper mapper = new ObjectMapper();
//         // Map<String, String> data = mapper.readValue(req.getInputStream(), Map.class);
//         BasicDataSource ds = (BasicDataSource) getServletContext().getAttribute("dataSource");
//         Admin data = new Admin();
//         try {
//             Connection connection = ds.getConnection();
//             PreparedStatement statement = connection
//                     .prepareStatement("INSERT INTO users (name,email,password) VALUES (?, ?, ?)");

//             statement.setString(1, data.getName());
//             statement.setString(2, data.getEmail());
//             statement.setString(3, data.getPassword());
//             // statement.setString(4, data.get("contact"));
//             int rows = statement.executeUpdate();
//             resp.setContentType("application/json");
//             mapper.writeValue(resp.getWriter(), rows);
//         } catch (Exception e) {
//             e.printStackTrace();
//         }
//  };
@Override
protected void doPost(jakarta.servlet.http.HttpServletRequest req, jakarta.servlet.http.HttpServletResponse resp)
        throws jakarta.servlet.ServletException, java.io.IOException {

    ObjectMapper mapper = new ObjectMapper();
    BasicDataSource ds = (BasicDataSource) getServletContext().getAttribute("dataSource");

    try {
        Admin data = mapper.readValue(req.getInputStream(), Admin.class);

        Connection connection = ds.getConnection();
        PreparedStatement statement = connection.prepareStatement(
            "INSERT INTO users (name, email, password) VALUES (?, ?, ?)");

        statement.setString(1, data.getName());
        statement.setString(2, data.getEmail());
        statement.setString(3, data.getPassword());

        int rows = statement.executeUpdate();

        resp.setContentType("application/json");
        mapper.writeValue(resp.getWriter(), Map.of("rowsAffected", rows));
    } catch (Exception e) {
        e.printStackTrace();
        resp.setStatus(500);
        mapper.writeValue(resp.getWriter(), Map.of("error", "Failed to create admin"));
    }
}

}
