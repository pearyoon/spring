package com.kh.app.bank.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.app.bank.service.BankService;
@RequestMapping("bank")
@Controller
public class SendController {
	@Autowired
	private BankService bs;
	
	@GetMapping("send")
	public String send() {
		return "bank/send";
	}
	
	@PostMapping("send") 
	public String send(@RequestParam HashMap<String,String> map) {
		
		System.out.println(map);
		
		int result = bs.send(map);
		
		return "redirect:ok";
	}
}
