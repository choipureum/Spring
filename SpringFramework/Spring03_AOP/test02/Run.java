package test02;

import org.springframework.cache.interceptor.CacheableOperation;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Run {
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("test02/applicationContext.xml");
		Develop woman = factory.getBean("woman",Develop.class);
		Develop man = factory.getBean("man",Develop.class);
		
		System.out.println("여학생 입장");
		woman.classWork();
		System.out.println("남학생입장");
		man.classWork();
		
	}
}
