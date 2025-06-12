package com.example.backend.db;

import org.apache.commons.dbcp2.BasicDataSource;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class DataSource implements ServletContextListener {

  @Override
  public void contextDestroyed(ServletContextEvent sce) {
    try {
      ServletContext context = sce.getServletContext();
      BasicDataSource dataSource = (BasicDataSource) context.getAttribute("dataSource");
      dataSource.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void contextInitialized(ServletContextEvent sce) {
    ServletContext context = sce.getServletContext();
    BasicDataSource ds = new BasicDataSource();
    ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
    ds.setUrl("jdbc:mysql://localhost:3306/sem2");
    ds.setUsername("root");
    ds.setPassword("1234");
    ds.setInitialSize(50);
    ds.setMaxTotal(100);

    context.setAttribute("dataSource", ds);
  }
}
