package hackerrank;

//https://www.hackerrank.com/challenges/ctci-array-left-rotation/problem
public class ArraysLeftRotation {
    // Complete the rotLeft function below.
    static int[] rotLeft(int[] a, int d) {
        int aLength = a.length;
        int[] rotated = new int[aLength];
        for (int i = 0; i < a.length; i++) {
            rotated[i] = a[(i + d) % aLength];
        }
        return rotated;
    }
}
