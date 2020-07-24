package test04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Run {
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("test04/applicationContext.xml");
		Develop man = (Develop) factory.getBean("woman");
		Develop woman = (Develop) factory.getBean("man");
		
		System.out.println("여학생입장");
		woman.classWork();
		System.out.println();
		System.out.println("남학생입장");
		man.classWork();
	}
}
