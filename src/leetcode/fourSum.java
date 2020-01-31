package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//https://leetcode.com/problems/4sum/
public class fourSum {

    //for 2 sum, stick all into hashmap, for each in hashmap, find diff in map
    //for 3 sum, stick all 2 sums into hashmap, for each hashmap, find diff in map
    //for 4 sum, stick all 3 sums into hashmap, for each hashmap, find diff in map
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<Integer> set = new ArrayList<>();
        for (int n : nums) {
            set.add(n);
        }
        List<List<Integer>> unsorted = sum(set, target, 4);
        List<List<Integer>> sorted = unsorted.stream()
                .map(a -> a.stream().sorted().collect(Collectors.toList()))
                .distinct()
                .collect(Collectors.toList());
        return sorted;
    }

    private List<List<Integer>> sum(List<Integer> numSet, int target, int numOfSums) {
        List<List<Integer>> res = new ArrayList<>();
        for (Integer n : numSet) {
            if (numOfSums == 2) {
                List<Integer> tuples = new ArrayList<>();
                if (numSet.contains(target - n)) {
                    tuples.add(n);
                    tuples.add(target - n);
                    res.add(tuples);
                }
            } else {
                List<Integer> tempSet = new ArrayList<>(numSet);
                tempSet.remove(n);
                res = sum(tempSet, target - n, numOfSums - 1);
                for (List<Integer> l : res) {
                    l.add(n);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {

        int[] nums = new int[] {1, 0, -1, 0, -2, 2};
        List<List<Integer>> res = new fourSum().fourSum(nums, 0);
    }
}
