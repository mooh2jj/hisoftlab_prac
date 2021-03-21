package com.example.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.model.MemberDTO;
import com.example.service.AdminService;

@Controller
@RequestMapping("/admin/**")
public class AdminController {

	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	AdminService adminService;
	
	@RequestMapping("login.do")
	public String login() {
		
		return "admin/login";
		
	}
	
	
	@RequestMapping("login_check.do")
	public String login_check(Model model, MemberDTO dto, HttpSession session) {
		
		String name = adminService.loginCheck(dto);
		// 로그인 성공 => 이름값이 넘어옴, 실패 => null이 들어옴.
		System.out.println("name: "+ name);
		String returnURL = "";
		if(name != null) {	// 로그인 성공하면 시작 페이지로 이동
			session.setAttribute("admin_userid", dto.getUserid());
			session.setAttribute("admin_name", name);
			session.setAttribute("userid", dto.getUserid());
			session.setAttribute("name", name);
			model.addAttribute("message", "success");
			returnURL = "admin/admin";
		} else {			// 로그인 실패하면 login 페이지로 다시 되돌아감
			model.addAttribute("message", "error");
			returnURL = "admin/login";
		}
		
		return returnURL;
	}
	
	
	@RequestMapping("logout.do")
	public String logout(Model model, HttpSession session) {
		
		logger.info("logout.do start...");
		adminService.logout(session);
		model.addAttribute("message", "logout");
		return "redirect:/admin/login.do";
	}

}
