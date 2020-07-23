package bean.test04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Run {
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("bean/test04/applicationContext.xml");
		
		//factory.getBean의 두번째 매개변수에 원하는 클래스객체를 넣어주면 원하는타입으로 객체반환가능
		BeanTest bean = factory.getBean("beanTest",BeanTest.class); 
	
	}
}
