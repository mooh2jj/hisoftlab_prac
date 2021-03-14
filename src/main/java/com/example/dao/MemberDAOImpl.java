package com.example.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.model.MemberDTO;

@Repository
public class MemberDAOImpl implements MemberDAO {

	@Autowired
	SqlSession sqlsession;
	
	@Override
	public String loginCheck(MemberDTO dto) {
		
		return sqlsession.selectOne("member.login_check", dto);
	}

}
