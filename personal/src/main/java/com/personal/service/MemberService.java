package com.personal.service;

import org.springframework.stereotype.Service;

import com.personal.vo.MemberVO;

@Service
public interface MemberService {

	// 로그인 정보 확인
	String loginCheck(String loginId, String loginPw);

	 // 회원 정보 가져오기
	MemberVO getMember(String loginId);

}
