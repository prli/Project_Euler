package hackerrank;

import java.util.HashSet;
import java.util.Set;

//https://www.hackerrank.com/challenges/sock-merchant/problem
public class SockMerchant {
    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
        int totalPairs = 0;
        Set<Integer> set = new HashSet<>();
        for (int sockColor : ar) {
            if (set.contains(sockColor)) {
                totalPairs++;
                set.remove(sockColor);
            } else {
                set.add(sockColor);
            }
        }
        return totalPairs;
    }
}
