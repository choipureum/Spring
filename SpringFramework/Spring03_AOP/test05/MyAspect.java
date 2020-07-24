package test05.com.edu.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
@Aspect
public class MyAspect {
	@Before("execution(public * viewSize(..))")
	public void before(JoinPoint join) {
		System.out.println("도형의 넓이를 출력한다");
	}
	
}
