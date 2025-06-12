package com.example.backend.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Map;

import org.apache.commons.dbcp2.BasicDataSource;

import com.example.backend.dto.AdminDto;
import com.example.backend.model.AdminModel;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/api/v1/admin")
public class AdminServlet extends HttpServlet {

    private AdminModel model;

    @Override
    public void init() throws ServletException {
        model = new AdminModel();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // try {
        // AdminDto admin = mapper.readValue(req.getInputStream(), AdminDto.class);

        // Connection connection = dataSource.getConnection();
        // PreparedStatement statement = connection.prepareStatement(
        // "INSERT INTO users (name, email, password) VALUES (?, ?, ?)");

        // statement.setString(1, admin.getName());
        // statement.setString(2, admin.getEmail());
        // statement.setString(3, admin.getPassword());

        // int rows = statement.executeUpdate();
        // resp.setContentType("application/json");
        // mapper.writeValue(resp.getWriter(), Map.of("Admin Save Success !", rows));
        // } catch (Exception e) {
        // e.printStackTrace();
        // }
        try {
            ObjectMapper mapper = new ObjectMapper();
            BasicDataSource dataSource = (BasicDataSource) getServletContext().getAttribute("dataSource");
            AdminDto adminDto = mapper.readValue(req.getInputStream(), AdminDto.class);
            model.addNewAdmin(adminDto.getName(), adminDto.getEmail(), adminDto.getPassword(), dataSource, resp, req);
        } catch (StreamReadException e) {
            e.printStackTrace();
        } catch (DatabindException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
