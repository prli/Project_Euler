package leetcode;

//https://leetcode.com/problems/container-with-most-water/
public class maxArea {

    public int maxArea(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = 0; j < height.length; j++) {
                int area = Math.min(height[i], height[j]) * Math.abs(i - j);
                if (area > max) {
                    max = area;
                }
            }
        }
        return max;
    }
}
