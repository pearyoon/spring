package com.kh.app.member.comtroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.kh.app.member.service.MemberService;
import com.kh.app.member.vo.MemberVo;

@Controller
public class MemberController {

	private MemberService ms;
	
	// 컨트롤러가 태어날 때 부터 MemberService를 갖고 태어날 수 있도록 만들어준다. (생성자)
	@Autowired
	public MemberController(MemberService ms) {
		this.ms = ms;
	}
	
	@GetMapping("member/join")
	public String join() {
		return "member/join";
	}
	
	@PostMapping("member/join")
	public String join(MemberVo vo) {
		
		int result = ms.join(vo);
		
		return "main";
	}
}	
