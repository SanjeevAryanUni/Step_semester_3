package week11.assigment_problems;

import java.util.Arrays;

public class AttendanceDisorderScore {
    /**
     * Problem 3: The Attendance Disorder Score
     * Counts disorder pairs (inversions) where i < j and roll[i] > roll[j].
     * Uses modified Merge Sort.
     * 
     * Time Complexity: O(n log n)
     * Extra Space Complexity: O(n) for the temporary merge array
     * Stability: Stable
     */
    public static long countInversions(int[] roll) {
        if (roll == null || roll.length <= 1) {
            return 0;
        }
        int[] temp = new int[roll.length];
        return mergeSortAndCount(roll, temp, 0, roll.length - 1);
    }

    private static long mergeSortAndCount(int[] arr, int[] temp, int left, int right) {
        long count = 0;
        if (left < right) {
            int mid = left + (right - left) / 2;

            count += mergeSortAndCount(arr, temp, left, mid);
            count += mergeSortAndCount(arr, temp, mid + 1, right);
            count += mergeAndCount(arr, temp, left, mid, right);
        }
        return count;
    }

    private static long mergeAndCount(int[] arr, int[] temp, int left, int mid, int right) {
        int i = left;     // Left subarray pointer
        int j = mid + 1;  // Right subarray pointer
        int k = left;     // Merged array pointer
        long count = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                // All remaining elements in left half (from i to mid) are greater than arr[j]
                count += (mid - i + 1);
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= right) {
            temp[k++] = arr[j++];
        }

        for (i = left; i <= right; i++) {
            arr[i] = temp[i];
        }

        return count;
    }

    public static void main(String[] args) {
        int[] roll1 = {2, 4, 1, 3, 5};
        System.out.println("Sample 1 Output: " + countInversions(roll1)); // Expected: 3

        int[] roll2 = {5, 4, 3, 2, 1};
        System.out.println("Sample 2 Output: " + countInversions(roll2)); // Expected: 10
    }
}
