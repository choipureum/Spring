package web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.service.EmpService;
import web.service.EmpServiceImpl;
import web.dto.Emp;

@WebServlet("/emp/detail")
public class EmpDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmpService empService = new EmpServiceImpl();
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int empno=Integer.parseInt(req.getParameter("empno"));
		
		Emp emp=empService.selectOne(empno);
	
		req.setAttribute("list",emp);
		req.getRequestDispatcher("/WEB-INF/views/EmpDetailView.jsp").forward(req, resp);
	}
}
