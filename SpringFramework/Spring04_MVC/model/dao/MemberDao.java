package com.kh.welcome.member.model.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.welcome.member.model.vo.Member;

@Repository
//@Repository 어노테이션
//해당 클래스를 Dao 역할을 하는 Bean으로 등록
//SqlException을 DataAccessException으로 전환해준다.
public class MemberDao {

	@Autowired
	SqlSessionTemplate session;
	
	//select 쿼리 session.insert(네임스페이스.태그id , 매핑시킬 객체)
		// 1개
		//selectOne(네임스페이스.태그id , 매핑시킬 객체)
		// 여러개
		//selectList(네임스페이스.태그id , 매핑시킬 객체)
	//insert 쿼리	//이하동문
	//update 쿼리	//매핑시킬 객체가 필요하지 않으면 생략
	//delete 쿼리
	
	
	public int insertMember(Member member) {
		System.out.println("dao >>>>>>>> : " + member);
		return session.insert("MEMBER.insertMember", member);
	}
	
	public Member selectMember(Map<String,Object> commandMap) {
		return session.selectOne("MEMBER.selectMember",commandMap);
	}
	public int selectId(String userId) {
		return session.selectOne("MEMBER.selectId",userId);
	}
	public int myPageUpdate(Member member) {
		return session.update("MEMBER.myPageUpdate",member);
	}
	public int myPageDelete(Member member) {
		return session.delete("MEMBER.myPageDelete",member);
	}
	
	
	
}
