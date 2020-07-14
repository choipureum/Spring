package multiparam.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import multiparam.dao.MultiParamDao;
import mybatis.MyBatisConnectionFactory;
import web.dto.Emp;

@WebServlet("/multi/param")
public class MultiParamController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SqlSessionFactory factory = MyBatisConnectionFactory.getSqlSessionFactory();
	private SqlSession sqlSession;
	private MultiParamDao multiParamDao;
		
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		sqlSession = factory.openSession(true);
		multiParamDao = sqlSession.getMapper(MultiParamDao.class);
		
//		Emp emp = new Emp();
//		emp.setEmpno(5000);
//		emp.setEname("A");
//		emp.setJob("STUDENT");
//		multiParamDao.insert(emp);
		
		//여러개의 파라미터 전달
//		multiParamDao.insert2(5006,"D",null);
		
		//해시맵을 파라미터 전달하는 방법
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("empno",5010);
		map.put("ename", "I");
		map.put("job", "III");
		multiParamDao.insert3(map);
		
				
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	}

}
