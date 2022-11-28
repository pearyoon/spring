package com.kh.app.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kh.app.member.vo.MemberVo;
@Controller
public class MemberController {
	
	@RequestMapping(value = "join" , method = RequestMethod.GET)	
	public String join() {
		return "member/join";
	}
	
	@RequestMapping(value = "join" , method = RequestMethod.POST)
	public String join(MemberVo vo) {
		
		System.out.println(vo);
		
		return "";
	}
}
