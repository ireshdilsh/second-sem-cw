package com.example.backend.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbcp2.BasicDataSource;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ComplainModel {

    public void addNewComplain(String name, String email, String message, HttpServletResponse resp,
            HttpServletRequest req) {

        ObjectMapper mapper = new ObjectMapper();
        BasicDataSource dataSource = (BasicDataSource) req.getServletContext().getAttribute("dataSource");
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO  complains (name, email, message) VALUES (?, ?, ?)");
            statement.setString(1, name);
            statement.setString(2, email);
            statement.setString(3, message);
            int rows = statement.executeUpdate();
            resp.setContentType("application/json");
            mapper.writeValue(resp.getWriter(), Map.of("Complain Save Success !", rows));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getAllComplains(HttpServletRequest req, HttpServletResponse resp) {
        BasicDataSource dataSource = (BasicDataSource) req.getServletContext().getAttribute("dataSource");
        try {
            Connection connection = dataSource.getConnection();
            ResultSet rst = connection.prepareStatement("SELECT * FROM complains").executeQuery();
            List<Map<String,String>>list = new ArrayList<>();
            while (rst.next()) {
                Map<String,String>map = new java.util.HashMap<>();
                map.put("name", rst.getString("name"));
                map.put("email", rst.getString("email"));
                map.put("message", rst.getString("message"));
                list.add(map);
            }
            ObjectMapper mapper = new ObjectMapper();
            resp.setContentType("application/json");
            mapper.writeValue(resp.getWriter(), list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteComplain(String email, HttpServletResponse resp, HttpServletRequest req) {
       ObjectMapper mapper = new ObjectMapper();
        BasicDataSource dataSource = (BasicDataSource) req.getServletContext().getAttribute("dataSource");
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("DELETE FROM complains WHERE email = ?");
            statement.setString(1, email);
            int rows = statement.executeUpdate();
            resp.setContentType("application/json");
            mapper.writeValue(resp.getWriter(), Map.of("Complain Delete Success !", rows));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
