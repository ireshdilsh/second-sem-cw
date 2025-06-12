package com.example.backend.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Map;

import org.apache.commons.dbcp2.BasicDataSource;

import com.example.backend.dto.AdminDto;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AdminModel {

    public void addNewAdmin(String name, String email, String password, BasicDataSource dataSource,
            HttpServletResponse resp, HttpServletRequest req) {

        ObjectMapper mapper = new ObjectMapper();
        // dataSource = (BasicDataSource)
        // getServletContext().getAttribute("dataSource");

        try {
            // AdminDto admin = mapper.readValue(req.getInputStream(), AdminDto.class);

            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO users (name, email, password) VALUES (?, ?, ?)");

            statement.setString(1, name);
            statement.setString(2, email);
            statement.setString(3, password);

            int rows = statement.executeUpdate();
            resp.setContentType("application/json");
            mapper.writeValue(resp.getWriter(), Map.of("Admin Save Success !", rows));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
