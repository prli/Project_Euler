package hackerrank;

//https://www.hackerrank.com/challenges/counting-valleys/problem
public class CountingValleys {
    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {
        int numOfValleys = 0;
        int seaLevel = 0;
        boolean isInValley = false;
        for (char c : s.toCharArray()) {

            if (c == 'U') {
                seaLevel++;
            } else {
                seaLevel--;
            }

            if (seaLevel < 0) {
                if (!isInValley) {
                    numOfValleys++;
                    isInValley = true;
                }
            } else {
                isInValley = false;
            }
        }
        return numOfValleys;
    }
}
