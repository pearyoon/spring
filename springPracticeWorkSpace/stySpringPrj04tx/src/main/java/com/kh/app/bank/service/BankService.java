package com.kh.app.bank.service;

import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.app.bank.dao.BankDao;
@Service
public class BankService {
	@Autowired
	private SqlSessionTemplate sst;
	@Autowired
	private BankDao dao;
	
	@Transactional
	public int send(HashMap<String, String> map) {
		
		int result1 = dao.minus(sst,map);
		
		int result2 = 0;
		
		if(result1 == 1) {
			result2 = dao.plus(sst,map);
		}
		
		return result1 * result2;
	}

}
