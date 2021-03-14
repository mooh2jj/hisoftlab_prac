package com.example.service;

import javax.servlet.http.HttpSession;

import com.example.model.MemberDTO;

public interface MemberService {

	public String loginCheck(MemberDTO dto, HttpSession session);
	public void logout(HttpSession session);
	
}
