package com.spring.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
@Configuration
public class JdbcConfig {
@Autowired 
DataSource dataSource;
@Bean
public JdbcTemplate jdbcTemplate(){
	JdbcTemplate jdbcTemplate = new JdbcTemplate();
	jdbcTemplate.setDataSource(dataSource);
	return jdbcTemplate;
}
}
