package com.personal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personal.dao.MemberDao;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberDao memberDao;
	
	@Override
	public String loginCheck(String userId, String userPw) throws Exception {		
		
		System.out.print(userId);
		return	memberDao.loginCheck(userId, userPw);
	}
	
}
