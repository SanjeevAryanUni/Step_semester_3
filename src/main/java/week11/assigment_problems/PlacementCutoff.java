package week11.assigment_problems;

public class PlacementCutoff {
    /**
     * Problem 4: The Placement Cutoff
     * Finds the k-th highest mark using Quickselect (Quick Sort partition).
     * Reuses partition step with last element as pivot and recurses/loops only into
     * the target half.
     * 
     * The k-th highest element in a list of size n belongs at index (n - k) in 0-based ascending order.
     * Duplicate marks count separately.
     * 
     * Complexity Requirements:
     *   - Time Complexity:
     *       * Average Case: O(n)
     *       * Worst Case: O(n^2) (rare with bad pivots, e.g. strictly decreasing array)
     *   - Extra Space Complexity: O(1) iterative in-place
     *   - Stability: Not stable (quicksort partitioning does not preserve relative order of duplicates)
     */
    public static int kthHighest(int[] marks, int k) {
        if (marks == null || k < 1 || k > marks.length) {
            throw new IllegalArgumentException("Invalid k or empty array");
        }

        int targetIndex = marks.length - k;
        int left = 0;
        int right = marks.length - 1;

        while (left <= right) {
            int pivotIndex = partition(marks, left, right);

            if (pivotIndex == targetIndex) {
                return marks[pivotIndex];
            } else if (pivotIndex < targetIndex) {
                left = pivotIndex + 1;
            } else {
                right = pivotIndex - 1;
            }
        }

        return marks[left];
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[right]; // Last element as pivot
        int i = left;

        for (int j = left; j < right; j++) {
            if (arr[j] <= pivot) {
                swap(arr, i, j);
                i++;
            }
        }

        swap(arr, i, right);
        return i;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] marks1 = {72, 95, 60, 88, 79};
        System.out.println("Sample 1 Output: " + kthHighest(marks1, 2)); // Expected: 88

        int[] marks2 = {50, 90, 90, 70};
        System.out.println("Sample 2 Output: " + kthHighest(marks2, 2)); // Expected: 90
    }
}
