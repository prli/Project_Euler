package euler;

public class Problem4 {
	//999 * 999 is max
	final static int maxLimit = 998001;
	public static void Main() {
		int term1 = 999;
		int term2 = 999;
		int product = 0;
		boolean palindromeFound = false;
		while(term1 > 99 && !palindromeFound){
			int i = 0;
			while(i < 10 && term2 > 99){
				term2 = term2 - i++;
				product = term1 * term2;
				if(isPalindrome(String.valueOf(product))){
					palindromeFound = true;
					System.out.println("Problem 4: " + product);
					break;
				}
			}
			term1--;
		}
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
