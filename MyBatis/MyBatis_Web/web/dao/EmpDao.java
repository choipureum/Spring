package web.dao;
import java.util.List;
import web.dto.Emp;
public interface EmpDao {
	
	//사원전체조회
	public List<Emp> selectAll();

	public Emp selectByEmpno(int empno);
	
}
