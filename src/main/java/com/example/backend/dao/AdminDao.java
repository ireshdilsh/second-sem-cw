package com.example.backend.dao;

import com.example.backend.model.Admin;
import org.apache.commons.dbcp2.BasicDataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class AdminDao {
            BasicDataSource ds = (BasicDataSource) getServletContext().getAttribute("dataSource");
        String sql = "INSERT INTO admin (name, email, password) VALUES (?, ?, ?)";
    
    try (Connection conn = dataSource.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        
        ps.setString(1, admin.getName());
        ps.setString(2, admin.getEmail());
        ps.setString(3, admin.getPassword());

        ps.executeUpdate();

    } catch (Exception e) {
        e.printStackTrace();
    }
}
