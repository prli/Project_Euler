package hackerrank;

//https://www.hackerrank.com/challenges/new-year-chaos/problem
public class NewYearChaos {

    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {
        int swaps = 0;
        for (int i = q.length - 1; i >= 0; i--) {
            if (q[i] - 1 - i > 2) {
                System.out.println("Too chaotic");
                return;
            }

            if (q[i] - 1 != i) {
                for (int j = i; j < q.length; j++) {
                    if (q[i] > q[j]) {
                        swaps++;
                    }
                }
            }
        }
        System.out.println(swaps);
    }
}

//1 2 3 4 5 6 7 8
//1 2 3 5 4 6 7 8
//1 2 5 3 4 6 7 8
//1 2 5 3