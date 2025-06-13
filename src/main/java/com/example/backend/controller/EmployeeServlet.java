package com.example.backend.controller;

import java.io.IOException;

import com.example.backend.dto.EmployeeDto;
import com.example.backend.model.EmployeeModel;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/api/v1/employee")
public class EmployeeServlet extends HttpServlet{

    private EmployeeModel model;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       try {
        ObjectMapper mapper = new ObjectMapper();
        EmployeeDto dto = mapper.readValue(req.getInputStream(), EmployeeDto.class);
        model.addNewEmployee(dto.getId(),dto.getName(), dto.getEmail(), dto.getContact(), resp,req);
       } catch (Exception e) {
        e.printStackTrace();
       }
    }

    @Override
    public void init() throws ServletException {
       model = new EmployeeModel();
    }
    
}
