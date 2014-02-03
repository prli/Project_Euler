package euler;

public class Problem2 {
	
	private static final int LIMIT = 4000000;

	public static void Main() {
		int sum = 0;
		int[] term = new int[3];
		term[0] = 1;
		term[1] = 2;
		sum = sum + term[1];
		do{
			if(term[2]%2 == 0){
				sum = sum + term[2];
			}
			term[2] = term[0] + term[1];
			term[0] = term[1];
			term[1] = term[2];
		}while(term[2] < LIMIT);
		System.out.println("Problem 2: " + sum);
	}

}
