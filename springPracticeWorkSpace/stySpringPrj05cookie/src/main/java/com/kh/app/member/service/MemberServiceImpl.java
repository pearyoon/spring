package com.kh.app.member.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.kh.app.member.dao.MemberDao;
import com.kh.app.member.vo.MemberVo;
@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	private SqlSessionTemplate sst;
	
	@Autowired
	private MemberDao dao;
	
	@Autowired
	private BCryptPasswordEncoder enc;
	
	@Override
	public MemberVo login(MemberVo vo) {
		
		MemberVo dbMember = dao.selectOneById(sst, vo);
		
		boolean isMatch = enc.matches(vo.getMemberPwd(), dbMember.getMemberPwd());
		
		if(isMatch) {
			return dbMember;
		}
		
		return null;
	}

}
