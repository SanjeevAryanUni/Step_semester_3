package week9.assigment_problems;

import java.util.Arrays;

public class MergeTokenQueues {
    /**
     * Merges two sorted lists of token numbers into a single sorted list.
     * Time Complexity: O(m + n) where m and n are the lengths of counterA and counterB.
     * Space Complexity: O(m + n) to store the merged output.
     */
    public static int[] mergeTokens(int[] counterA, int[] counterB) {
        if (counterA == null) counterA = new int[0];
        if (counterB == null) counterB = new int[0];

        int m = counterA.length;
        int n = counterB.length;
        int[] merged = new int[m + n];

        int i = 0, j = 0, k = 0;

        while (i < m && j < n) {
            if (counterA[i] <= counterB[j]) {
                merged[k++] = counterA[i++];
            } else {
                merged[k++] = counterB[j++];
            }
        }

        while (i < m) {
            merged[k++] = counterA[i++];
        }

        while (j < n) {
            merged[k++] = counterB[j++];
        }

        return merged;
    }

    public static void main(String[] args) {
        int[] counterA1 = {3, 8, 15, 20};
        int[] counterB1 = {5, 8, 12};
        System.out.println("Sample 1 Output: " + Arrays.toString(mergeTokens(counterA1, counterB1)));

        int[] counterA2 = {};
        int[] counterB2 = {4, 9};
        System.out.println("Sample 2 Output: " + Arrays.toString(mergeTokens(counterA2, counterB2)));
    }
}
