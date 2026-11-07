package week11.assigment_problems;

import java.util.Arrays;

public class NoticeBoardShuffle {
    /**
     * Problem 1: The Notice Board Shuffle
     * Sorts the array in ascending order using Bubble Sort with early exit.
     * Stops as soon as a full sweep makes no swap.
     * 
     * @param scores The array of test scores to sort in place
     * @return int[] array of [passes, swaps]
     * 
     * Complexity Requirements:
     *   - Time Complexity:
     *       * Best Case: O(n) when already sorted (only 1 pass needed, 0 swaps)
     *       * Average / Worst Case: O(n^2)
     *   - Extra Space Complexity: O(1) in-place
     *   - Stability: Stable (adjacent equal elements are never swapped)
     * 
     * Explanation for already-sorted board:
     *   On an already-sorted array, the first pass checks every adjacent pair (scores[j] > scores[j+1]),
     *   finds all in correct order, makes 0 swaps, and keeps the 'swapped' flag false.
     *   The algorithm detects this and terminates immediately after just 1 pass.
     */
    public static int[] bubbleStats(int[] scores) {
        if (scores == null || scores.length <= 1) {
            return new int[]{0, 0};
        }

        int n = scores.length;
        int passes = 0;
        int swaps = 0;

        for (int i = 0; i < n - 1; i++) {
            passes++;
            boolean swapped = false;

            for (int j = 0; j < n - 1 - i; j++) {
                if (scores[j] > scores[j + 1]) {
                    int temp = scores[j];
                    scores[j] = scores[j + 1];
                    scores[j + 1] = temp;
                    swaps++;
                    swapped = true;
                }
            }

            // Early exit if no swaps occurred in this full sweep
            if (!swapped) {
                break;
            }
        }

        return new int[]{passes, swaps};
    }

    public static void main(String[] args) {
        int[] scores1 = {5, 1, 4, 2, 8};
        int[] stats1 = bubbleStats(scores1);
        System.out.println(Arrays.toString(scores1) + "  passes = " + stats1[0] + ", swaps = " + stats1[1]);
        // Expected: [1, 2, 4, 5, 8]  passes = 3, swaps = 4

        int[] scores2 = {1, 2, 3, 4};
        int[] stats2 = bubbleStats(scores2);
        System.out.println(Arrays.toString(scores2) + "  passes = " + stats2[0] + ", swaps = " + stats2[1]);
        // Expected: [1, 2, 3, 4]  passes = 1, swaps = 0
    }
}
