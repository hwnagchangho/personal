package com.personal.vo;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class MemberVO {
	
	private int mno;
	private String loginId;
	private String loginPw;
	private String name;
	private String nickName;
	private String email;
	private String authLevel;
	private String regDate;
	private String updateDate;

}
