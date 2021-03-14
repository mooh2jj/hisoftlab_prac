package com.example.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.model.MemberDTO;
import com.example.service.MemberService;

@Controller
@RequestMapping("/member/**")
public class MemberController {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	MemberService memberService; 
	
	@RequestMapping("login.do")
	public String login() {
		logger.info("login.do start...");
		return "member/login";
	}
	
	@RequestMapping("login_check.do")
	public String login_check(Model model, MemberDTO dto, HttpSession session) {
		
		String name = memberService.loginCheck(dto, session);
		// 로그인 성공 => 이름값이 넘어옴, 실패 => null이 들어옴.
		logger.info("name:" + name);
		String returnURL = "";
		if(name != null) {	// 로그인 성공하면 시작 페이지로 이동
			returnURL = "home";
		} else {			// 로그인 실패하면 login 페이지로 다시 되돌아감
			model.addAttribute("message", "error");
			returnURL = "member/login";
		}
		
		return returnURL;
	}
	
	
	@RequestMapping("logout.do")
	public String logout(Model model, HttpSession session) {
		
		logger.info("logout.do start...");
		memberService.logout(session);
		model.addAttribute("message", "logout");
		return "member/login";
	}
}
