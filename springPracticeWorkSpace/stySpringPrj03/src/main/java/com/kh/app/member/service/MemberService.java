package com.kh.app.member.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.app.member.dao.MemberDao;
import com.kh.app.member.vo.MemberVo;

@Service
public class MemberService {
	@Autowired
	private MemberDao dao;
	
	@Autowired
	private SqlSessionTemplate sst;
	
	public int join(MemberVo vo) {
		return dao.join(sst, vo);
	}

	public MemberVo login(MemberVo vo) {
		return dao.login(sst,vo);
	}
	
}
