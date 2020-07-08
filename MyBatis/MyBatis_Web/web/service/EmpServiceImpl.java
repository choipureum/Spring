package web.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import web.dao.EmpDao;
import mybatis.MyBatisConnectionFactory;
import web.dto.Emp;

public class EmpServiceImpl implements EmpService{
	private static SqlSessionFactory factory = MyBatisConnectionFactory.getSqlSessionFactory();	
	EmpDao empDao;
	
	@Override
	public List<Emp> getList() {	
		//멤버필드에서 한번에 처리하면 안된다-(트랜잭션처리)
		SqlSession sqlSession = factory.openSession(true);	
		empDao = sqlSession.getMapper(EmpDao.class);		
		List<Emp>list =empDao.selectAll();
		return list;
	}
	@Override
	public Emp selectOne(int empno) {
		SqlSession sqlSession = factory.openSession(true);	
		empDao = sqlSession.getMapper(EmpDao.class);		
		Emp emp =empDao.selectByEmpno(empno);
	
		return emp;
	}
}
