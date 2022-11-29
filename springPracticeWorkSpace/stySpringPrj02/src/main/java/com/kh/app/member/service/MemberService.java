package com.kh.app.member.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kh.app.member.dao.MemberDao;
import com.kh.app.member.vo.MemberVo;

@Component // 이렇게 설정해줘야 controller 쪽이랑 연결된다.
public class MemberService {
	
	@Autowired
	private SqlSessionTemplate sst;
	
	@Autowired
	private MemberDao dao;
	
	public int join(MemberVo vo) {
		
		int result = dao.join(sst,vo);
		
		return 1;
	}
	
}
