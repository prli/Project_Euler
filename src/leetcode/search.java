package leetcode;

//https://leetcode.com/problems/search-in-rotated-sorted-array/
public class search {
    public int search(int[] nums, int target) {
        return search(nums, 0, nums.length - 1, target);
    }

    public int search(int[] nums, int left, int right, int target) {

        int mid = (left + right)/2;
        if (nums.length == 1) {
            if (nums[mid] == target) {
                return mid;
            } else {
                return -1;
            }
        }

        if (nums[left] < nums[mid]) {
            if (nums[left] <= target && target <= nums[mid]) {
                return search(nums, left, mid, target);
            } else {
                return search(nums, mid, right, target);
            }
        } else {
            if (nums[mid] <= target && target <= nums[right]) {
                return search(nums, mid, right, target);
            } else {
                return search(nums, left, mid, target);
            }
        }
    }
}
