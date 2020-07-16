package web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import web.dto.Dept;
import web.service.DeptService;

@Controller
public class DeptController {
	private Logger logger = LoggerFactory.getLogger(DeptController.class);
	@Autowired
	private DeptService deptService;	
	
	@RequestMapping(value="/dept/list", method=RequestMethod.GET)
	public void deptList(Model model) {
		logger.info("/dept/list[GET]");
		List<Dept>list=deptService.getList();
		model.addAttribute("list", list);
	}
}
