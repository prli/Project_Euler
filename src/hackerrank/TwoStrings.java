package hackerrank;

import java.util.HashSet;
import java.util.Set;

//https://www.hackerrank.com/challenges/two-strings/problem
public class TwoStrings {
    // Complete the twoStrings function below.
    static String twoStrings(String s1, String s2) {
        Set<Character> charSet = new HashSet<>();
        for (char c : s1.toCharArray()) {
            charSet.add(c);
        }
        for (char c : s2.toCharArray()) {
            if (charSet.contains(c)) {
                return "YES";
            }
        }
        return "NO";
    }

}
