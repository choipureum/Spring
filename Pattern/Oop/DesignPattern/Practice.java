package builder;
import java.util.*;


public class practice {
	 private int sum;

	 private practice() {} 
	 
	 private practice(PracticeBuilder builder){
	      sum = builder.sum;
	   };
 
	   public static class PracticeBuilder{
	      
	      private int sum = 0;
	     
	      public PracticeBuilder add(int val) {
	    	 sum += val;
	         return this;
	      }
	      public PracticeBuilder substract(int val) {
	         sum-= val;
	         return this;
	      }
	      
	      public practice build() {
	         return new practice(this);
	      }     
	   }

	@Override
	public String toString() {
		return "practice [sum=" + sum + "]";
	}
	   
		
	
	
	
}
