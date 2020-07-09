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
		
//		List res2 = dynamicQueryDao.select2("S");
//		System.out.println(res2);
		
		Emp emp = new Emp();
		emp.setEmpno(1111);
		emp.setEname("");
		
		List res3 = dynamicQueryDao.select3(emp);
		System.out.println(res3);
	}


}
