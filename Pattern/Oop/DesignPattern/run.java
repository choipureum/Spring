package builder;

import builder.practice.PracticeBuilder;

public class run {
	public static void main(String[] args) {
		String result= new PracticeBuilder().add(4).add(5).substract(3).build().toString();	
		System.out.println(result);
	}
}
