package hackerrank;

//https://www.hackerrank.com/challenges/jumping-on-the-clouds/problem
public class JumpingOnTheClouds {
    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c) {
        int jumps = 0;
        int cur = 0;
        while (cur != c.length - 1) {
            if (cur + 2 < c.length && c[cur + 2] != 1) {
                cur += 2;
            } else {
                cur++;
            }
            jumps++;
        }

        return jumps;
    }
}
