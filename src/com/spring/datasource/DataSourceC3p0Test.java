package com.spring.datasource;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DataSourceC3p0Test {
public static void main(String[] args) throws SQLException {
	 ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext4.xml");
     DataSource dataSource = app.getBean(DataSource.class);
     Connection connection = dataSource.getConnection();
     System.out.println(connection);//com.mchange.v2.c3p0.impl.NewProxyConnection@36f0f1be
     connection.close();
}
}
