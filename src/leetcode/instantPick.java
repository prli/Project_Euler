package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

//https://leetcode.com/problems/random-pick-index
public class instantPick {
    private Map<Integer, Queue<Integer>> numMap;
    public instantPick(int[] nums) {
        this.numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!numMap.containsKey(nums[i])) {
                numMap.put(nums[i], new LinkedList<Integer>() {
                });
            }
            numMap.get(nums[i]).add(i);
        }
    }

    //binary search, low space, slower
    //hashmap of all index, return value based on key, fast, higher space
    public int pick(int target) {
        Integer first = numMap.get(target).remove();
        numMap.get(target).add(first);
        return first;
    }

    public static void main(String[] args) {

        instantPick obj = new instantPick(new int[] {1,2,3,3,3});
        int param_1 = obj.pick(1);
    }
}
