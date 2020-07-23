package bean.test04;
import java.util.*;

public class BeanTest {
	private MyClass myClass;
	
	public BeanTest() {
		System.out.println("빈테스트 기본 생성자");
	}
	public BeanTest(Date date) {
		System.out.println("날씨 생성자(date: "+date+")");
	}
	public void setMyClass(MyClass myClass) {
		this.myClass= myClass;
		System.out.println("setMyClass 호출 "+myClass);
	}
	public void setNumber(int num) {
		System.out.println("setNumber 호출 "+num);
	}
	
	//Array
	//List
	//Set
	//Map
	//Properties
	//Collection에 객체 넣기
	
	//Array
	public void setArray(String [] arr) {
		System.out.println("setArray 호출 : "+ Arrays.toString(arr));
	}
	//List
	public void setList(List<String>list) {
		System.out.println("setList 호출 : "+list);
	}
	//Set
	public void setSet(Set<String>set) {
		System.out.println("setSet 호출 : "+set);
	}
	//Map
	public void setMap(Map<String,String>map) {
		System.out.println("setMap 호출 : "+map);
	}
	//Properties
	public void setProperties(Properties properties) {
		System.out.println("setProperties 호츨 : "+properties);
	}
	//Collection 
	public void setScore(List<Score>list) {
		System.out.println("setScore 호출");
		for(Score sc : list) {
			System.out.println(sc);
		}
	}
	
	
}	











