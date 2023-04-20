package com.personal.controller;

import java.net.http.HttpRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.personal.service.MemberService;
import com.personal.vo.MemberVO;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
//	로그인
	@GetMapping("/login")
	public String login() {
		return "/member/login";
	}
	
	@PostMapping("/doLogin")
	public String doLogin(String loginId, HttpServletRequest req, Model model) {
		HttpSession session = req.getSession();
		
		MemberVO member = memberService.getMember(loginId);
		
		if(member != null) {
			session.setAttribute("isLogined", member);
			
			model.addAttribute("member", member);
		}
			
		return "home";
	}
//	로그아웃
	@GetMapping("/doLogout")
	public String doLogout(HttpServletRequest req) {
		
		HttpSession session = req.getSession();
		
		if (session.getAttribute("isLogined") != null) {
			session.removeAttribute("isLogined");
		}		
		return "home";
	}
//	로그인 정보 확인
	@PostMapping("/loginCheck")
	@ResponseBody
	public String doLogin(String loginId, String loginPw) throws Exception {
		
		log.info("====================" + loginId);
		
		//로그인 정보 확인
		String cnt = memberService.loginCheck(loginId, loginPw); 	
		
		return cnt;
	}
}
