package com.example.backend.db;

import org.apache.commons.dbcp2.BasicDataSource;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class DataSource implements ServletContextListener{
    public default void contextDestroyed(jakarta.servlet.ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        BasicDataSource dataSource = (BasicDataSource) context.getAttribute("dataSource");
        dataSource.close();
    }

    public default void contextInitialized(jakarta.servlet.ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        BasicDataSource dataSource = new BasicDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/sem2");
        ds.setUsername("root");
        ds.setPassword("1234");
        ds.setInitialSize(50);
        ds.setMaxTotal(100);

        context.setAttribute("dataSource", dataSource);
    }
}
