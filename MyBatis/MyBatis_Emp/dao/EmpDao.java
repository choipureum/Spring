package dao;

import java.util.List;

import dto.Emp;

public interface EmpDao {
		
	public List<Emp> selectAll();
	
	public void insertEmp(Emp emp);
	
	public Emp selectByEmpNo(Emp emp);
	
	public void deleteByEmpNo(Emp emp);
	

}
