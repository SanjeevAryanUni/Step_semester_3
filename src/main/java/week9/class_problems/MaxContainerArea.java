package week9.class_problems;

public class MaxContainerArea {
    /**
     * Finds the maximum area between two boundaries using the Two-Pointer technique.
     * Time Complexity: O(n)
     * Auxiliary Space Complexity: O(1)
     *
     * Brute Force Alternative: Checks all pairs O(n^2) time, O(1) space.
     * Optimal is preferable for large inputs (e.g. n=10^5) because O(n) completes in milliseconds
     * whereas O(n^2) would take 10^10 operations (seconds/minutes).
     */
    public static int maxContainerArea(int[] heights) {
        if (heights == null || heights.length < 2) {
            return 0;
        }

        int left = 0;
        int right = heights.length - 1;
        int maxArea = 0;

        while (left < right) {
            int width = right - left;
            int minHeight = Math.min(heights[left], heights[right]);
            int currentArea = minHeight * width;
            if (currentArea > maxArea) {
                maxArea = currentArea;
            }

            // Move the pointer at the shorter wall inward
            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("Expected: 49 | Actual: " + maxContainerArea(heights));
    }
}
