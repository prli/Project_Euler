package euler;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;

public class Problem7 {
	
	private final static int INDEX = 10001;

	public static void Main() {
		int indexFound = 1;
		int num = 2;
		while(indexFound<INDEX){
			num++;
			if(getFactors(num).isEmpty()){
				indexFound++;
			}
			
		}
		System.out.println("Problem 7: " + num);
	}
	
	private static ArrayList getFactors(int num){
		ArrayList factors = new ArrayList();
		if(num == 1){
			return factors;
		}
		for(int i=2;i<=Math.sqrt(num);i++){
			if(num%i == 0){
				factors.add(i);
				break;
			}
		}
		return factors;
	}

}
