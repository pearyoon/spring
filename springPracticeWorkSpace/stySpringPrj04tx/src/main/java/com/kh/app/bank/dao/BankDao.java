package com.kh.app.bank.dao;

import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BankDao {

	public int minus(SqlSessionTemplate sst, HashMap<String, String> map) {
		return sst.update("bankMapper.minus",map);
	}

	public int plus(SqlSessionTemplate sst, HashMap<String, String> map) {
		return sst.update("bankMapper.plus",map);
	}

}
