package com.kh.app.member.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
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
	
	@GetMapping("login")
	public String login() {
		return "member/login";
	}
	@PostMapping("login")
	public String login(String save ,MemberVo vo, HttpSession session, HttpServletResponse resp) {
		
		MemberVo loginMember = ms.login(vo);
		
		
		if(loginMember == null) {
			return "fail";
		}
		
		session.setAttribute("loginMember", loginMember);
		
		Cookie cookie = new Cookie("saveId", loginMember.getMemberId());
		cookie.setPath("/app");
		
		if(save == null) {
			cookie.setMaxAge(0);
		}
		
		resp.addCookie(cookie);
		
		return "redirect:/main";
	}
}
