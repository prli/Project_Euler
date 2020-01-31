package hackerrank;

//https://www.hackerrank.com/challenges/crush/problem
public class ArrayManipulation {
    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {
        int max = 0;
        int[] arr = new int[n];
        for(int i = 0; i < queries.length; i++) {
            for (int j = queries[i][0] - 1; j < queries[i][1]; j++) {
                arr[j] = arr[j] + queries[i][2];
            }
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
}
