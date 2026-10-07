package week9.assigment_problems;

public class TicketPriceSlotFinder {
    /**
     * Finds the index of newPrice in sorted distinct array prices,
     * or the index where it should be inserted to maintain sorted order.
     * Time Complexity: O(log n) via Binary Search.
     * Auxiliary Space Complexity: O(1).
     */
    public static int findSlot(int[] prices, int newPrice) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int low = 0;
        int high = prices.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (prices[mid] == newPrice) {
                return mid;
            } else if (prices[mid] < newPrice) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }

    public static void main(String[] args) {
        int[] prices = {120, 150, 200, 260};

        System.out.println("Sample 1 (150): Expected 1 | Actual: " + findSlot(prices, 150));
        System.out.println("Sample 2 (210): Expected 3 | Actual: " + findSlot(prices, 210));
        System.out.println("Sample 3 (300): Expected 4 | Actual: " + findSlot(prices, 300));
    }
}
