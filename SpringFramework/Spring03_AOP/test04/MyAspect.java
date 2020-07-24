package test04;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

//해당 클래스가 Aspect 역할을 하게끔 만들어주는 어노테이션
@Aspect
public class MyAspect {
	
	
	//@Before -> @After -> @AfterReturning -> 만약 예외발생 -> @AfterThrowing
	
		
	@Before("execution(public * *(..))")
	public void before(JoinPoint join) {
		System.out.println("출석카드를 찍다");
	}
	@AfterThrowing("execution(public * *(..))")
	public void throwing(JoinPoint join) {
		System.out.println("쉬는날 이었다");
	}
	//결과가 반환된이후 실행(2가지 값넣기)
	//Before, AfterThrowing, After와는 달리 어노테이션에 pointcut과 결과를 반환받을 변수명 두가지를 지정해줘야함
	@AfterReturning(pointcut="execution(public * *(..))",returning="returnVal")
	public void returning(JoinPoint join,Object returnVal) {
		System.out.println(returnVal+"공부하는 날이었다");
	}
	//타깃객체의 메서드를 실행 -> 결과값을 반환하기 직전에 실행
	// 즉 return 값을 가지고 오지 않는다
	@After("execution(public * *(..))")
	public void after(JoinPoint join) {
		System.out.println("집에간다");
	}
	
}
