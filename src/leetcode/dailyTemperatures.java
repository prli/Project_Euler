package leetcode;

//https://leetcode.com/problems/daily-temperatures/
public class dailyTemperatures {
    //naive
    //count from cur to end of T, if bigger, return index of 2nd loop
    public int[] dailyTemperatures(int[] T) {
        int[] resArr = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            for (int j = i; j < T.length; j++) {
                if (T[j] > T[i]) {
                    resArr[i] = j - i;
                    break;
                }
            }
        }
        return resArr;
    }
}
