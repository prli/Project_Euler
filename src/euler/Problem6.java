package euler;

public class Problem6 {
	
	final static int RANGE = 100;
	public static void Main() {
		System.out.println("Problem 6: " + Integer.toString((getSqrOfSum(RANGE)-getSumOfSqr(RANGE))));
	}
	
	private static int getSqrOfSum(int range){
		int result = 0;
		for(int i=1;i<=range;i++){
			result += i;
		}
		return result*result;
	}
	
	private static int getSumOfSqr(int range){
		int sum = 0;
		for(int i=1;i<=range;i++){
			sum += i*i;
		}
		return sum;
	}

}
