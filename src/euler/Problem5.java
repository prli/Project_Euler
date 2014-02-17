package euler;

public class Problem5 {
//	2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
//
//	What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
	final static int RANGE = 20;
	public static void Main() {
		int num = 20;

		while(true){
			if(divisbleByAll(RANGE, num)){
				System.out.println("Problem 5: " + num);
				break;
			}else{
				num+=RANGE;
			}
		}
		
	}
	
	private static boolean divisbleByAll(int range, int num){
		for(int j = 2; j <=range; j++){
			if( num%j != 0){
				return false;
			}
		}
		return true;
	}

}
