package com.personal.mapper;

import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import com.personal.vo.MemberVO;

@Mapper
public interface MemberMapper {
	
	public String loginCheck(HashMap<String, String> map);

	public MemberVO getMember(String loginId);

	/* public MemberVO loginCheck(String loginId, String loginPw); */

	
}
