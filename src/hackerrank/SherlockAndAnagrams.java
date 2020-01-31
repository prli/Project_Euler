package hackerrank;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Set;

//https://www.hackerrank.com/challenges/sherlock-and-anagrams/problem
public class SherlockAndAnagrams {

    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {
        Map<String, Integer> subStringSet = new HashMap<>();
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                char[] subStr = s.substring(i, j + 1).toCharArray();
                Arrays.sort(subStr);
                String str = new String(subStr);
                Integer subStrCount = Optional.ofNullable(subStringSet.get(str)).orElse(0);
                if (subStringSet.containsKey(str)) {
                    res = res + subStrCount;
                }
                subStringSet.put(str, subStrCount + 1);
            }
        }

        return res;
    }

    public static void main(String[] args) {

        String s = "kkkk";
        int result = sherlockAndAnagrams(s);
    }

}
