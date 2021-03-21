package com.example.service;

import javax.servlet.http.HttpSession;

import com.example.model.MemberDTO;

public interface AdminService {

	public String loginCheck(MemberDTO dto);

	public void logout(HttpSession session);
}
