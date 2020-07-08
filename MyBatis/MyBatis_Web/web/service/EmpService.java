package web.service;

import java.util.List;

import web.dto.Emp;

public interface EmpService {

	public List<Emp> getList();
	//하나 조회
	public Emp selectOne(int empno);

}
