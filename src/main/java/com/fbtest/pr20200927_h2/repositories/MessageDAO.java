package com.fbtest.pr20200927_h2.repositories;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MessageDAO {
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	public List<Account> getAccount(){
		return jdbcTemplate.queryForList("select * from t_account ").stream()
				.map(row -> new Account(
					row.get("name").toString())
				)
				.collect(Collectors.toList());
	}
}
