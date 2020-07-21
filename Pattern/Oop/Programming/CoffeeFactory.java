package poly;

public class CoffeeFactory {

		public CoffeeFactory() {
		}

		public Coffee createCoffee(String type) {
			Coffee coffee=null;
			
			switch(type) {
				case "p" : 
					coffee= new PremiumCoffee();
					break;
				
				case "n":
					coffee= new Coffee();
				default :
					System.out.println("잘못입력하셨습니다!");
				}
			return coffee;
		}

}
