package test01.proxy;

public class ManProxy implements Develop{
	
	@Override
	public void classWork() {
		System.out.println("출석카드를 찍는다");

	try {
		new Man().classWork();
	}catch(Exception e) {
		System.out.println("쉬는 날이였다");
	}finally {
		System.out.println("집에 간다");
	}
}
}
