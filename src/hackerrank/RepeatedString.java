package hackerrank;

//https://www.hackerrank.com/challenges/repeated-string/problem
public class RepeatedString {

    // Complete the repeatedString function below.
    static long repeatedString_naive(String s, long n) {
        long numOfRepeat = 0;
        long index = 0;
        while (index < n) {
            if (s.charAt((int) index % s.length()) == 'a') {
                numOfRepeat++;
            }
            index++;
        }
        return numOfRepeat;
    }

    // Complete the repeatedString function below.
    static long repeatedString_better(String s, long n) {
        long numOfAs = 0;
        long numOfRepeaAInWord = 0;
        for (char c : s.toCharArray()) {
            if (c == 'a') {
                numOfRepeaAInWord++;
            }
        }

        long numOfWordRepeat = n / s.length();
        numOfAs = numOfRepeaAInWord * numOfWordRepeat;

        long remainder = n % s.length();
        for (int i = 0; i < remainder; i++) {
            if (s.charAt(i) == 'a') {
                numOfAs++;
            }
        }

        return numOfAs;
    }
}
