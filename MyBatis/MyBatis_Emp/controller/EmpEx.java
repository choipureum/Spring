package controller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dao.EmpDao;
import dto.Emp;
import mybatis.MyBatisConnectionFactory;

public class EmpEx {
	public static void main(String[] args) {		
		//마이바티스 수행객체
		SqlSession sqlSession;
		//DB접속 및 SqlSession 생성 팩토리 객체
		SqlSessionFactory factory = MyBatisConnectionFactory.getSqlSessionFactory();		
		//마이바티스 수행객체
		sqlSession = factory.openSession(true); 
		//마이바티스의 매퍼와 자바프로그램의 DAO 인터페이스 매핑(연결)
		EmpDao empDao = sqlSession.getMapper(EmpDao.class);	
		
		
		
		//예제 퀴즈 실행
		List<Emp>list=empDao.selectAll();
		for(Emp emp:list) {
			System.out.println(emp);
		}
		//2번 인서트
		Scanner sc = new Scanner(System.in);
		System.out.println(">>부서 인서트하기 예제");
		Emp emp = new Emp();
		System.out.println(">>부서번호 입력:");
		emp.setDeptno(sc.nextInt());
		System.out.println(">>사원번호 입력:");
		emp.setEmpno(sc.nextInt());
		System.out.println(">>부서comm 입력:");
		emp.setComm(sc.nextInt());	
		emp.setHiredate(new Date());
		System.out.println(">>직업 입력:");
		sc.nextLine();
		emp.setJob(sc.nextLine());
		System.out.println(">>MGr 입력:");
		emp.setMgr(sc.nextInt());
		System.out.println(">>Sal 입력:");
		emp.setSal(sc.nextInt());
		System.out.println(">>부서이름 입력:");
		emp.setEname(sc.next());
		
		empDao.insertEmp(emp);
		System.out.println("insert완료");
		
		Emp emp2=empDao.selectByEmpNo(emp); 
		System.out.println(emp2);
		
		
		
		empDao.deleteByEmpNo(emp2);
		System.out.println("delete 완료");
		
		
		List<Emp>list2=empDao.selectAll();
		for(Emp e:list2) {
			System.out.println(e);
		}
		
	}
}



