package com.personal.dao;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.personal.mapper.MemberMapper;

import lombok.extern.log4j.Log4j;

@Repository
@Log4j
public class MemberDao {
	
	@Autowired
	private MemberMapper memberMapper;

	public String loginCheck(String userId, String userPw) throws Exception {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("userId", userId);
		map.put("userPw", userPw);
		
		System.out.println(map);
		
		String n = memberMapper.loginCheck(map); 
		System.out.println("=========================" + n);
		return n; 
	}

}
