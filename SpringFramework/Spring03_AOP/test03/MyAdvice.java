package test03;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.JoinPoint;

public class MyAdvice{

	//JoinPoint타겟객체에 대한 정보를 담고있다
		//스프링에서 AOP를 사용하기 위해서 반드시 매개변수로 넣어줘야 하는 객체
	public void before(JoinPoint join) {
		System.out.println(join.getTarget().getClass());
		System.out.println(join.getSignature());
		System.out.println(join);
		System.out.println(join.getArgs());
		
		System.out.println("출석카드를 찍는다.");
	}
	public void after(JoinPoint join) {
		System.out.println("집에 간다.");
	}
	
}
