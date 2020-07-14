package dept.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dept.dto.Dept;
import mybatis.MyBatisConnectionFactory;

public class DeptDaoImpl implements DeptDao{
	private String namespace = "dept.dao.DeptDao.";
	//마이바티스 객체 생성
	private SqlSessionFactory factory = MyBatisConnectionFactory.getSqlSessionFactory();
	
	@Override
	public List<Dept> selectAll() {
		//마이바티스 수행 객체
		SqlSession sqlSession = factory.openSession(true);
		//DB조회 결과
		List<Dept>deptList=sqlSession.selectList(namespace+"selectAll"); //Mapper
		//가능
//		sqlSession.commit();
//		sqlSession.clearCache();
//		sqlSession.close();
		return deptList;
	}
	@Override
	public Dept select(int deptno) {
		SqlSession sqlSession = factory.openSession(true);
		// selectone은 뒤에 매개변수를 써주어야 나온다
		Dept dept=sqlSession.selectOne(namespace+"select",deptno); //Mapper				
		sqlSession.close();
		return dept;
	}
	
	@Override
	public void insert(Dept dept) {
		SqlSession sqlSession = factory.openSession(true);
		// selectone은 뒤에 매개변수를 써주어야 나온다
		int res=sqlSession.insert(namespace+"insert",dept); //Mapper		
		
		if(res>0) {
			sqlSession.commit();
			System.out.println("삽입성공");
		}
		else {
			sqlSession.rollback();			
		}
		sqlSession.close();
	}
}









