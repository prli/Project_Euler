package hackerrank;

//4
//4 3 1 2
//https://www.hackerrank.com/challenges/minimum-swaps-2/problem
public class MinimumSwaps2 {
    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {
        int minSwaps = 0;
        int i = 0;
        while (i != arr.length - 1) {
            if (i + 1 != arr[i]) {
                int temp = arr[arr[i] - 1]; //temp = arr[4 - 1] = arr[3] = 2
                arr[arr[i] - 1] = arr[i]; //arr[3] = arr[0] = 4
                arr[i] = temp; //arr[0] = temp = 2
                minSwaps++;
            } else {
                i++;
            }
        }
        return minSwaps;
    }
}
