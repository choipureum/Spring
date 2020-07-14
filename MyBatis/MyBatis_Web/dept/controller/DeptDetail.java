package dept.controller;
import dept.dto.Dept;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dept.dao.DeptDao;
import dept.dao.DeptDaoImpl;

@WebServlet("/dept/detail")
public class DeptDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DeptDao deptDao = new DeptDaoImpl();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String param = req.getParameter("deptno");
		int deptno=0;
		
		if(param!=null && !"".equals(param)) {
			deptno=Integer.parseInt(param);
		}
				
		Dept dept=deptDao.select(deptno);
		System.out.println(dept);
		req.setAttribute("dept", dept);
		req.getRequestDispatcher("/WEB-INF/views/deptDetail.jsp").forward(req, resp);
	
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}

}
