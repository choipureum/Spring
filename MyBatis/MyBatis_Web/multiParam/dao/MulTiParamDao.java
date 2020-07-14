package multiparam.dao;

import java.util.HashMap;

import org.apache.ibatis.annotations.Param;

import web.dto.Emp;

public interface MultiParamDao {
	
	public void insert(Emp emp);

	//여러개의 파라미터를 보내고자 할때
	public void insert2(
			//해쉬맵으로 처리하는게 낫다
			@Param("e1") int empno, 
			@Param("e2") String ename, 
			@Param("e3") String job);

	//하나의 DTO로 표현하기 힘든 여러개의 인자를 HashMap으로 묶어서 전달
	public void insert3(HashMap<String, Object> map);
}
