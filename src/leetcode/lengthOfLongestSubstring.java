package leetcode;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class lengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        // given string of n length, increase by 1 if set does not contain
        // if true, start over and return max(prevMax, curMax)

        // given string of n length, increase by 1 if set does not contain
        // if true, start from index + 1 of offending char, hashmap should only contain value from index + 1 of offending char
        Map<Character, Integer> charSet = new HashMap<>();
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            if (!charSet.containsKey(key)) {
                charSet.put(key, i);
            } else {
                Map<Character, Integer> newCharSet = new HashMap<>();
                for (Map.Entry<Character, Integer> entry : charSet.entrySet()) {
                    if (entry.getValue() > charSet.get(key)) {
                        newCharSet.put(entry.getKey(), entry.getValue());
                    }
                }
                newCharSet.put(key, i);
                charSet = newCharSet;
            }
            maxLength = Math.max(maxLength, charSet.size());
        }
        return maxLength;
    }
    public static void main(String[] args) {

        String s = "abcabcbb";
        int result = new lengthOfLongestSubstring().lengthOfLongestSubstring(s);
    }


}
