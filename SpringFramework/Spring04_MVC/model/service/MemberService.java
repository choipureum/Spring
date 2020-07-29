package com.kh.welcome.member.model.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.welcome.member.model.dao.MemberDao;
import com.kh.welcome.member.model.vo.Member;

@Service
public class MemberService {
	
	@Autowired
	MemberDao memberDao;
	
	public int insertMember(Member member) {
		return memberDao.insertMember(member);
	}
	
	public Member selectMember(Map<String, Object>commandMap) {
		return memberDao.selectMember(commandMap);
	}
	public int myPageUpdate(Member member) {
		return memberDao.myPageUpdate(member);
	}
	public int myPageDelete(Member member) {
		return memberDao.myPageDelete(member);
	}
	public int selectId(String userId) {
		return memberDao.selectId(userId);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
