package leetcode;

//https://leetcode.com/problems/longest-palindromic-substring/
public class longestPalindrome {

    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        String longest = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length(); j >= i; j--) {
                String subStr = s.substring(i, j);
                if (isPalindrome(subStr) && subStr.length() > longest.length()) {
                    longest = subStr;
                }
            }
        }
        return longest;
    }

    public boolean isPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return true;
        }
        int i = 0;
        int j = s.length() - 1;
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
