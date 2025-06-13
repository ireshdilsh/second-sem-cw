package com.example.backend.controller;

import java.io.IOException;

import com.example.backend.dto.ComplainDto;
import com.example.backend.model.ComplainModel;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/api/v1/complains")
public class ComplaintServlet extends HttpServlet {

    private ComplainModel model;

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            ObjectMapper mapper = new ObjectMapper();
            ComplainDto dto = mapper.readValue(req.getInputStream(), ComplainDto.class);
            model.addNewComplain(dto.getName(), dto.getEmail(), dto.getMessage(), resp, req);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void init() throws ServletException {
        model = new ComplainModel();
    }

}
