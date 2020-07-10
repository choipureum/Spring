package dynamic.controller;

import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dynamic.dao.DynamicQueryDao;
import mybatis.MyBatisConnectionFactory;
import web.dto.Emp;

/**
 * Servlet implementation class DynamicQueryController
 */
@WebServlet("/dynamic/list")
public class DynamicQueryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SqlSessionFactory factory = MyBatisConnectionFactory.getSqlSessionFactory();
	private SqlSession sqlSession;
	private DynamicQueryDao dynamicQueryDao;
	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		sqlSession = factory.openSession(true);
		dynamicQueryDao = sqlSession.getMapper(DynamicQueryDao.class);
//		
//		//해쉬맵을 List로 묶어서 반환
//		List list = dynamicQueryDao.select();
//		for(Object object : list) {
//			System.out.println(object);
//		}
//		
//		req.setAttribute("list", list);
//		req.getRequestDispatcher("/WEB-INF/views/query.jsp").forward(req, resp);
		
		//--------------------------------------
//		List res2 = dynamicQueryDao.select2("S");
//		System.out.println(res2);
		
		//-----------------------------
//		Emp emp = new Emp();
//		emp.setEmpno(7369);
//		emp.setEname("KING");
//		
//		List res3 = dynamicQueryDao.select3(emp);
//		System.out.println(res3);
		
//		HashMap<String,Object>map = new HashMap<>();
//		map.put("category", "ename"); //이름으로 검색을 누른상태
//		map.put("keyword", "SMITH"); //smith가 입력됨
//
//		List<Emp>res4 = dynamicQueryDao.select4(map);
//		System.out.println(res4);
//		
//		map.put("category", "job"); 
//		map.put("keyword", "SALESMAN"); 
//		
//		List<Emp>res5 = dynamicQueryDao.select4(map);
//		System.out.println(res5);
		
		
		//----------------------------------------
		req.getRequestDispatcher("/WEB-INF/views/queryCheckbox.jsp").forward(req, resp);		
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//전달값이 여러개일때는 values로 받아야한다
		String[] data=req.getParameterValues("deptno");
	
		//배열같은 것은 파라미터로 바로 넣으면 않좋음 -> 해쉬맵을 넣어주자
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("deptnoArr", data);
		List<Emp>list=dynamicQueryDao.selectCheckbox(map);
		
		for(Emp emp:list) {
			System.out.println(emp);
		}
	}

}















