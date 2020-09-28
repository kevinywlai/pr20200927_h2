package com.fbtest.pr20200927_h2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fbtest.pr20200927_h2.repositories.Account;
import com.fbtest.pr20200927_h2.repositories.MessageDAO;
import com.google.gson.Gson;

@RestController
public class MainController {
	
	@Autowired
	MessageDAO messageDAO;
	
	@GetMapping("main")
	public String getMain() {
		
		List<Account> accounts = messageDAO.getAccount();
		
		String a = new Gson().toJson(accounts);
		return a;
	}
	
}
