package com.kh.app.member.dao;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.app.member.vo.MemberVo;

public interface MemberDao {
	
	public MemberVo selectOneById(SqlSessionTemplate sst, MemberVo vo);
	
}
