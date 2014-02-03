package euler;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class Problem3 {
	private final static BigInteger VALUE = new BigInteger("600851475143");
	private final static BigInteger ZERO = new BigInteger("0");
	private final static BigInteger ONE = new BigInteger("1");
	private final static BigInteger TWO = new BigInteger("2");
	
	private static ArrayList<BigInteger> primeFactors = new ArrayList<BigInteger>();
	private static BigInteger largest = ZERO;
	public static void Main() {
		long startTime = System.currentTimeMillis();
		
		long n = VALUE.longValue();
		int idx = 0;
        long N = n;
        long large = 0;
        for (long i = 2; i*i <= N; i++) {
            boolean flag = false;
            while ((n % i) == 0) {
                flag = true;
                n = n/i;
            }
            if (flag) 
            	large = i; // Pick the last printed value, the answer. One would simply load a stack in other situations, and perform a pop to obtain result.
        }
        
        System.out.println("Problem 3 soln 1: " + large);
        long finishTime1 = System.currentTimeMillis();
		primeFactors = new ArrayList<BigInteger>();
		findFactors(VALUE);
		System.out.println("Problem 3 soln 2: " + largest);
		long finishTime2 = System.currentTimeMillis();
		System.out.println("Problem 3 soln 3: " + findLargestPrimeFactor(VALUE.doubleValue()));
		long finishTime3 = System.currentTimeMillis();
		System.out.println("soln 1 time: " + (finishTime1-startTime) + " ms");
		System.out.println("soln 1 time: " + (finishTime2-finishTime1) + " ms");		
		System.out.println("soln 1 time: " + (finishTime3-finishTime2) + " ms");

	}
	
	private static int findLargestPrimeFactor(double n) {
		for (int i = 2; i <= (int)Math.sqrt(n); i++) {
			if(n%i == 0) {
				return findLargestPrimeFactor(n/i);
			}
		}
		return (int)n;
	}
	
	private static void findFactors(BigInteger num) {
		ArrayList <BigInteger> factors = new ArrayList<BigInteger>();
		//do not count 1 itself or else it will become inf loop
		BigInteger lowFactor = TWO;
		BigInteger highFactor = num;
		while(highFactor.compareTo(lowFactor) == 1){
			if(num.remainder(lowFactor).equals(ZERO)){
				factors.add(lowFactor);
				highFactor = num.divide(lowFactor);
			}
			lowFactor = lowFactor.add(ONE);
		}
		if(factors.isEmpty()){
			if(highFactor.compareTo(largest) == 1){
				largest = highFactor;
			}
			return;
		}
		Iterator<BigInteger> ir = factors.iterator();
		while(ir.hasNext()){
			findFactors(new BigInteger(ir.next().toString()));
		}
	}
}
