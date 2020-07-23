package test02;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyAdvice implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		//target 객체의 메서드가 반환하는 값을 받기 위한 변수
		Object target = null;
		System.out.println("출석카드를 찍는다");
		try {
			//target객체의 메서드실행
			target = invocation.proceed();
		}catch(Exception e) {
			System.out.println("쉬는 날이였다");
		}finally {
			System.out.println("집에 간다");
		}
		
		return target;
	}
}
