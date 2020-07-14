package dept.dao;

import java.util.List;

import dept.dto.Dept;

public interface DeptDao {

	public List<Dept> selectAll();

	public Dept select(int deptno);

	public void insert(Dept dept);

}
