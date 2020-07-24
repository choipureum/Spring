package test05.com.edu.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test05.com.edu.entity.Figure;
import test05.com.edu.entity.Rectangle;
import test05.com.edu.entity.Triangle;

public class Run {
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("test05/com/edu/main/applicationContext.xml");	
		
	
		Figure rec =(Figure)factory.getBean("r");			
		Figure tri=(Figure)factory.getBean("t");
		
		//Type
		//메서드의 시그니처 정보와 필드변수 정보를 가지고있다
		//상속을 통해서 Type을 공유한다는 것은 접근 가능한 메서드의 시그니처와
		// 필드변수도 같이 공유한다는 것, 다형성이 가능해지는 이유이다
		rec.viewSize();
		System.out.println("------");
		tri.viewSize();
		
	}
}
