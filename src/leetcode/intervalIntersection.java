package leetcode;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/interval-list-intersections/
public class intervalIntersection {

    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int a = 0;
        int b = 0;
        List<int[]> intersections = new ArrayList<>();
        while (a < A.length || b < B.length) {
            if (A[a][1] < B[b][0]) {
                a++;
                continue;
            }
            if (B[b][1] < A[a][0]) {
                b++;
                continue;
            }
            intersections.add(new int[]{Math.max(A[a][0], B[b][0]), Math.min(A[a][1], B[b][1])});

            if (a < A.length) {
                if (A[a][0] < B[b][0]) {
                    a++;
                }
            } else {
                b++;
            }
        }

        return intersections.toArray(new int[0][]);
    }
}
