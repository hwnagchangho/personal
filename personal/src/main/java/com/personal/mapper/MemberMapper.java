package com.personal.mapper;

import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
	
	public String loginCheck(HashMap<String, String> map) throws Exception;
	
}
