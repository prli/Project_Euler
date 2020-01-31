package hackerrank;

import java.util.HashMap;
import java.util.Map;

//https://www.hackerrank.com/challenges/ctci-ransom-note/problem
public class RansomNote {
    // Complete the checkMagazine function below.
    static void checkMagazine (String[] magazine, String[] note) {
        Map<String, Integer> wordFreq = new HashMap<>();
        for (String s : note) {
            if (wordFreq.get(s) == null) {
                wordFreq.put(s, 1);
            } else {
                wordFreq.put(s, wordFreq.get(s) + 1);
            }
        }

        for (String s : magazine) {
            if (wordFreq.get(s) != null) {
                wordFreq.put(s, wordFreq.get(s) - 1);
            }
        }

        for (Integer i : wordFreq.values()) {
            if (i > 0) {
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
    }

    public static void main(String[] args) {

        String[] magazine = "apgo clm w lxkvg mwz elo bg elo lxkvg elo apgo apgo w elo bg".split(" ");
        String[] note = "elo lxkvg bg mwz clm w".split(" ");
        checkMagazine(magazine, note);
    }
}
