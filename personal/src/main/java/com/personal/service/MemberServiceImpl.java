package com.personal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personal.dao.MemberDao;
import com.personal.vo.MemberVO;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberDao memberDao;
	
	// 로그인 정보 확인
	@Override
	public String loginCheck(String loginId, String loginPw){		
		
		System.out.print("*****" + loginId);
		return	memberDao.loginCheck(loginId,loginPw);
	}
	
	 // 회원 정보 가져오기
	@Override
	public MemberVO getMember(String loginId) {
		return memberDao.getMember(loginId);
	}
	
}
