package com.fbtest.pr20200927_h2.repositories;

import java.util.List;

import java.util.stream.Collectors;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Qualifier;

@Repository
public class MessageDAO {
//	@Autowired
//    private JdbcTemplate jdbcTemplate;
	
	
	private JdbcTemplate jdbcTemplate;	
	
	@Autowired
	public MessageDAO(@Qualifier("testdb") DataSource  dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource); 
	}
	
	
	
	public List<Account> getAccount(){
		return jdbcTemplate.queryForList("select * from t_account ").stream()
				.map(row -> new Account(
					row.get("name").toString())
				)
				.collect(Collectors.toList());
	}
	
	public int insertAccount(String name) {
		return jdbcTemplate.update(" insert into t_account values( ? ) ", new Object[] {name});
	}
}
