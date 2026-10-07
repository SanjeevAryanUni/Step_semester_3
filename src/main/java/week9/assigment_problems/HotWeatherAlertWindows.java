package week9.assigment_problems;

public class HotWeatherAlertWindows {
    /**
     * Counts the number of k-length contiguous blocks whose average >= threshold.
     * Uses sliding window optimization.
     * Time Complexity: O(n) where n is length of readings.
     * Auxiliary Space Complexity: O(1).
     */
    public static int countAlerts(int[] readings, int k, int threshold) {
        if (readings == null || readings.length < k || k <= 0) {
            return 0;
        }

        long requiredSum = (long) k * threshold;
        long windowSum = 0;
        int alertCount = 0;

        for (int i = 0; i < k; i++) {
            windowSum += readings[i];
        }

        if (windowSum >= requiredSum) {
            alertCount++;
        }

        for (int i = k; i < readings.length; i++) {
            windowSum += readings[i] - readings[i - k];
            if (windowSum >= requiredSum) {
                alertCount++;
            }
        }

        return alertCount;
    }

    public static void main(String[] args) {
        int[] readings = {2, 2, 2, 2, 5, 5, 5, 8};
        int k = 3;
        int threshold = 4;

        System.out.println("Expected Output: 3 | Actual: " + countAlerts(readings, k, threshold));
    }
}
