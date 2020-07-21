package poly;

public class Accounting {
	
	private int balance; //잔고
	private int salesPrice; //매출
	private int expences; //지출
	
	public Accounting() {}
	private static Accounting accounting =null;
	//싱글톤 처리
	public static Accounting getAccounting() {
		if(accounting==null) {
			accounting = new Accounting();
		}
		return accounting;
	}
	
	
	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int getSalesPrice() {
		return salesPrice;
	}

	public void setSalesPrice(int salesPrice) {
		this.salesPrice = salesPrice;
	}

	public int getExpences() {
		return expences;
	}

	public void setExpences(int expences) {
		this.expences = expences;
	}
	
	//매출등록을 담당하는 메서드
    public int registerSales(int payPrice) {		
		balance += payPrice;
		salesPrice += payPrice;
		return balance;		
	}
	
	//지출등록을 담당하는 메서드
	public boolean registerExpences(int expencesPrice) {
		if(balance > expencesPrice) {
			balance -= expencesPrice;
			expences += expencesPrice;
			return true;
		}else {
			return false;
		}		
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
