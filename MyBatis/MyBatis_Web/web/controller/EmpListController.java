package web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dto.Emp;
import web.service.EmpService;
import web.service.EmpServiceImpl;

@WebServlet("/emp/list")
public class EmpListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private EmpService empService = new EmpServiceImpl();
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//사원 전체조회
		List<Emp>list = empService.getList();
		//조회된 결과 (List<Emp>를 Request 컨텍스트 영역에 추가
		req.setAttribute("list", list);
		//View 지정 및 forward -JSP
		req.getRequestDispatcher("/WEB-INF/views/empList.jsp").forward(req, resp);
	
	}
}
