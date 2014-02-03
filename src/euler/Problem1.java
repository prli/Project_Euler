package euler;

public class Problem1 {
	private static final int LIMIT = 10;

	public static void Main(){
		int sum = 0;
		for(int i=1;i<LIMIT;i++){
			if(i%3 == 0 || i%5 == 0){
				sum += i;
			}
		}
		System.out.println("Problem 1 answer: " + sum);
	}
}
