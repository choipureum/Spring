package dynamic.dao;

import java.util.HashMap;
import java.util.List;

import web.dto.Emp;

public interface DynamicQueryDao {
	public List <HashMap<String,Object>> select();

	public List select2(String ename);

	public List select3(Emp emp);
}
