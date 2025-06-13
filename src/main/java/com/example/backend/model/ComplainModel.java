package com.example.backend.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

}
