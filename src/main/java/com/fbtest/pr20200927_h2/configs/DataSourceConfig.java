package com.fbtest.pr20200927_h2.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@Configuration
@ComponentScan("com.fbtest.pr20200927_h2")
public class DataSourceConfig {
	
	@Bean(name="testdb")
	public DataSource dataSource(){
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:file:./testdb");
		dataSource.setUsername("sa");
		dataSource.setPassword("");
		
		return dataSource;
		
	}

}
