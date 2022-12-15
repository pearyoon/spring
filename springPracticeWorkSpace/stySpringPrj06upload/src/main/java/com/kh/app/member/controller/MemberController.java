package com.kh.app.member.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.kh.app.common.file.FileUploader;
import com.kh.app.member.service.MemberService;
import com.kh.app.member.vo.MemberVo;
@RequestMapping("member")
@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("join")
	public String join() {
		return "member/join";
	}
	
	@PostMapping("join")
	public String join(MemberVo vo, HttpServletRequest req) {
		
		// 파일 저장
		String changeName = "";
		if(!vo.isEmpty()) {
			changeName = FileUploader.upload(vo, req);
		}
		
		vo.setChangeName(changeName);
		int result = memberService.join(vo);
		
		if(result != 1) return "error";
	
		
		return "main";
	}
	
	@GetMapping("login")
	public String login() {
		
		return "member/login";
	}
	
	@PostMapping("login")
	public String login(MemberVo vo , HttpSession session) {
		

		
		MemberVo loginMember = memberService.login(vo);
		session.setAttribute("loginMember", loginMember);
		
		if(loginMember == null) return "error";
		
		return "main";
	}
	
}
