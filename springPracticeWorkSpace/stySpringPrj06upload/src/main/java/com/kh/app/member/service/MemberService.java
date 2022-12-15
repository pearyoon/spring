package com.kh.app.member.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.kh.app.member.dao.MemberDao;
import com.kh.app.member.vo.MemberVo;

@Service
public class MemberService {
	@Autowired
	private SqlSessionTemplate sst;
	
	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private BCryptPasswordEncoder pwdEnc;
	
	public int join(MemberVo vo) {
		
		vo.encode(pwdEnc);

		return memberDao.insertMemberOne(sst, vo);
	}

	public MemberVo login(MemberVo vo) {
		
		MemberVo dbMember = memberDao.selectMemberOneById(sst,vo.getMemberId());
		
		String rawPassword = vo.getMemberPwd();
		String encodedPassword = dbMember.getMemberPwd();
		
		boolean isMatch = pwdEnc.matches(rawPassword, encodedPassword);
		
		if(!isMatch) return null;
		
		return dbMember;
	}

}
