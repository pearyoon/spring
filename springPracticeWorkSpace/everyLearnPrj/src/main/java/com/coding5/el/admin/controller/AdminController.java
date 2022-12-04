package com.coding5.el.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@RequestMapping("admin")
@Controller
public class AdminController {
	@GetMapping("login")
	public String login() {
		return "admin/login";
	}
	
	@GetMapping("main")
	public String main() {
		return "admin/main";
	}
}
