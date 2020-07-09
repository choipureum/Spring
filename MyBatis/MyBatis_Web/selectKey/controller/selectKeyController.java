package selectKey.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import selectKey.dto.test_member;
import selectKey.service.SelectKeyService;
import selectKey.service.SelectKeyServiceImpl;

@WebServlet("/mybatis/selectKey")
public class selectKeyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private SelectKeyService selectKeyService = new SelectKeyServiceImpl();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/insertForm.jsp").forward(req, resp);		
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//insert처리
		String id=req.getParameter("id");
		String pw=req.getParameter("pw");
		
		test_member test= new test_member();
		test.setId(id);
		test.setPw(pw);		
		selectKeyService.insertForm(test);
		
		req.setAttribute("list", test);
		req.getRequestDispatcher("/resources/Complete.jsp").forward(req, resp);
	}
}
