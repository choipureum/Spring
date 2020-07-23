package test01;

public class Run {
	public static void main(String[] args) {
		Woman woman = new Woman();
		Man man = new Man();
		
		System.out.println("여학생입장");
		woman.classWork();
		System.out.println("----------");
		System.out.println("남학생입장");
		man.classWork();
	}
}
