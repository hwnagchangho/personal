package com.personal.dao;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.personal.mapper.MemberMapper;
import com.personal.vo.MemberVO;

import lombok.extern.log4j.Log4j;

@Repository
@Log4j
public class MemberDao {
	
	@Autowired
	private MemberMapper memberMapper;

	
	// 로그인 정보 확인
	 public String loginCheck(String loginId, String loginPw){
		 
		 HashMap<String, String> map = new HashMap<String, String>();
		 map.put("loginId", loginId); map.put("loginPw", loginPw);
		 
		 System.out.println(map);
		 
		 String cnt =  memberMapper.loginCheck(map);
		 System.out.println("=========================" + cnt);
		 
		 return cnt;
	 }

	 // 회원 정보 가져오기
	public MemberVO getMember(String loginId) {
		
		return memberMapper.getMember(loginId);
	}

}
