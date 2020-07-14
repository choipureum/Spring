package dept.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dept.dto.Dept;
import dept.dao.DeptDao;
import dept.dao.DeptDaoImpl;

@WebServlet("/dept/list")
public class DeptListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DeptDao deptDao = new DeptDaoImpl();
  
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Dept>deptList = deptDao.selectAll();
		req.setAttribute("deptList", deptList);
		
		req.getRequestDispatcher("/WEB-INF/views/deptList.jsp").forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	}

}
