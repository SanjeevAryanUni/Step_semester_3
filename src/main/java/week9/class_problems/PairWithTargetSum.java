package week9.class_problems;

import java.util.HashSet;
import java.util.Set;

public class PairWithTargetSum {
    /**
     * Approach 1: Hash-based Complement Lookup (Optimal)
     * Time Complexity: O(n)
     * Auxiliary Space Complexity: O(n)
     */
    public static boolean hasPairWithSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return false;
        }

        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            int complement = target - num;
            if (seen.contains(complement)) {
                return true;
            }
            seen.add(num);
        }
        return false;
    }

    /**
     * Approach 2: Brute-Force Pair Search
     * Time Complexity: O(n^2)
     * Auxiliary Space Complexity: O(1)
     */
    public static boolean hasPairWithSumBruteForce(int[] nums, int target) {
        if (nums == null || nums.length < 2) return false;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        System.out.println("Sample 1: Expected true | Actual: " + hasPairWithSum(nums1, target1));

        int[] nums2 = {3, 4, 6};
        int target2 = 20;
        System.out.println("Sample 2: Expected false | Actual: " + hasPairWithSum(nums2, target2));
    }
}
