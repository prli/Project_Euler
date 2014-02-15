package euler;

public class Problem4 {
	//999 * 999 is max
	final static int maxLimit = 998001;
	//100 * 100 is min
	final static int minLimit = 10000;
	public static void Main() {
		int max = 0;
		for(int i = 999; i > 100; i--){
			for(int j = 999; j > 100; j--){
				if(isPalindrome(Integer.toString(i*j)) && (i*j > max)){
					max = i*j;
				}
			}
		}
		System.out.println("Problem 4: " + max);
	}
	
	private static String getNextPolindrome(int maxLimit){
		String polindrome = new String();
		boolean found = false;
		int product = 0;
		while(!found){
			
			if(isPalindrome(Integer.toString(product))){
				polindrome = Integer.toString(product);
				found = true;
			}
		}
		return polindrome;
	}
	
	private static boolean isPalindrome(String num){
		boolean isPanlidrome = true;
		int head = 0;
		int tail = num.length() - 1;
		while(head < tail){
			char a = num.charAt(head);
			char b = num.charAt(tail);
			if(num.charAt(head) != num.charAt(tail)){
				isPanlidrome = false;
				break;
			}
			head++;
			tail--;
		}
		return isPanlidrome;
	}

}
