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

@WebServlet("/api/v1/getComplainByEmail")
public class GetComplainByEmailServlet extends HttpServlet{

    private ComplainModel model;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        ComplainDto dto = mapper.readValue(req.getInputStream(), ComplainDto.class);
        model.getComplainsByEmail(dto.getEmail(), resp, req);
    }

    @Override
    public void init() throws ServletException {
        model = new ComplainModel();
    }

}
