package test01.proxy;

public class Run {
	public static void main(String[] args) {
		Develop woman = new WomanProxy();
		Develop man = new ManProxy();
		
		System.out.println("여학생입장");
		woman.classWork();
		System.out.println("----------");
		System.out.println("남학생입장");
		man.classWork();
	}
}
