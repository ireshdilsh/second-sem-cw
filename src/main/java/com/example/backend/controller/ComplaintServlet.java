package com.example.backend.controller;

import java.io.IOException;

import com.example.backend.model.ComplainModel;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/api/v1/complains")
public class ComplaintServlet extends HttpServlet{

    private ComplainModel model;

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
    }

    @Override
    public void init() throws ServletException {
        model = new ComplainModel();
    }   

}
