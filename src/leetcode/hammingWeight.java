package leetcode;

//https://leetcode.com/problems/number-of-1-bits
public class hammingWeight {

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        for (int i = 31; i >= 0; i--) {
            if (n / Math.pow(2, i) >= 1) {
                count++;
            }
        }
        return count;
    }
}
