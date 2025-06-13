package com.example.backend.controller;

import java.io.IOException;

import org.apache.commons.dbcp2.BasicDataSource;

import com.example.backend.dto.AdminDto;
import com.example.backend.model.AdminModel;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/api/v1/admin/signin")
public class AdminServletSignin extends HttpServlet {

    private AdminModel model;

    @Override
    public void init() throws ServletException {
        model = new AdminModel();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            ObjectMapper mapper = new ObjectMapper();
            BasicDataSource dataSource = (BasicDataSource) getServletContext().getAttribute("dataSource");
            AdminDto adminDto = mapper.readValue(req.getInputStream(), AdminDto.class);
            model.signin(adminDto.getEmail(), adminDto.getPassword(), req, resp, dataSource);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
