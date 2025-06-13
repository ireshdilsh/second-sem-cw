package com.example.backend.model;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;

import org.apache.commons.dbcp2.BasicDataSource;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EmployeeModel {

    public void addNewEmployee(String id, String name, String email, int contact, HttpServletResponse resp,
            HttpServletRequest req) {

        BasicDataSource dataSource = (BasicDataSource) req.getServletContext().getAttribute("dataSource");
        ObjectMapper mapper = new ObjectMapper();
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO employee (id, name, email, contact) VALUES (?, ?, ?, ?)");
            statement.setString(1, id);
            statement.setString(2, name);
            statement.setString(3, email);
            statement.setInt(4, contact);
            int rows = statement.executeUpdate();
            resp.setContentType("application/json");
            mapper.writeValue(resp.getWriter(), Map.of("Employee Save Success !", rows));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void signin(String email, HttpServletRequest req, HttpServletResponse resp) {
        BasicDataSource dataSource = (BasicDataSource) req.getServletContext().getAttribute("dataSource");
        ObjectMapper mapper = new ObjectMapper();

        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM employee WHERE email = ?");

            statement.setString(1, email);

            ResultSet resultSet = statement.executeQuery();
            resp.setContentType("application/json");
            PrintWriter out = resp.getWriter();

            if (resultSet.next()) {
                resp.setStatus(HttpServletResponse.SC_OK);
                mapper.writeValue(out, Map.of(
                        "code", "200",
                        "status", "Login Success",
                        "message", "You have been logged in successfully"));
            } else {
                resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                mapper.writeValue(out, Map.of(
                        "code", "401",
                        "status", "Login Failed",
                        "message", "You have been logged in failed"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

// 070 2235 650
