package com.personal.service;

import org.springframework.stereotype.Service;

@Service
public interface MemberService {

	// 로그인 정보 가져오기
	String loginCheck(String userId, String userPw) throws Exception;
}
