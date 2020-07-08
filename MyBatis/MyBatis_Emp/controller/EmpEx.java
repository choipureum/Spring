package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dao.EmpDao;
import dto.Emp;
import mybatis.MyBatisConnectionFactory;

public class EmpEx {
	//DB접속 및 SqlSession 생성 팩토리 객체
	private static SqlSessionFactory factory = MyBatisConnectionFactory.getSqlSessionFactory();
	
	public static void main(String[] args) {		
		//마이바티스 수행객체
		SqlSession sqlSession;
				
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
		sc.nextLine();
		System.out.println(">>부서 입사일 입력");
		String input =sc.nextLine();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		Date hiredate=null;
		try {
			hiredate = sdf.parse(input);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		emp.setHiredate(hiredate);
		
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
		
		// sqlSession에 기본적으로 한단계 더 높은 자동화 단계 - Mapper없이 바로가능
//		sqlSession.insert(arg0); - int형 반환(Mapper에서는 반환처리할수없다)-여기서만가능
//		sqlSession.select(arg0, arg1);
//		sqlSession.selectOne()
//		sqlSession.commit();
//		sqlSession.rollback();
		
		
		empDao.deleteByEmpNo(emp2);
		System.out.println("delete 완료");
		
		
		List<Emp>list2=empDao.selectAll();
		for(Emp e:list2) {
			System.out.println(e);
		}
		
	}
}







