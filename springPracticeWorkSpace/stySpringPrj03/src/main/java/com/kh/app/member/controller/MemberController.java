package com.kh.app.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.app.member.service.MemberService;
import com.kh.app.member.vo.MemberVo;
@RequestMapping("member")
@Controller
public class MemberController {
	@Autowired
	private MemberService ms;
	
	@GetMapping("join")
	public String join() {
		return "member/join";
	}
	
	@PostMapping("join")
	public String join(MemberVo vo, Model model) {
		
		int result = ms.join(vo);
		
		model.addAttribute("msg","회원가입");
		
		if(result == 1) {
			return "common/success";
		}else {
			return "common/error";
		}
		
	}
	
	@GetMapping("login")
	public String login() {
		return "member/login";
	}
	
	@PostMapping("login")
	public String login(MemberVo vo, HttpSession ss ,Model model) {
		
		MemberVo loginMember = ms.login(vo);
		System.out.println(loginMember);
		if(loginMember != null) {
			ss.setAttribute("loginMember", loginMember);
			return "redirect:/main";
		} else {
			model.addAttribute("msg", "로그인");
			return "common/error";
		}
		
	}
}
