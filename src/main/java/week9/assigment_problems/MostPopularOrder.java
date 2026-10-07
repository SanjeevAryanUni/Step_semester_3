package week9.assigment_problems;

import java.util.HashMap;
import java.util.Map;

public class MostPopularOrder {
    public static class OrderCount {
        public final String item;
        public final int count;

        public OrderCount(String item, int count) {
            this.item = item;
            this.count = count;
        }

        @Override
        public String toString() {
            return "(\"" + item + "\", " + count + ")";
        }
    }

    /**
     * Finds the most frequently ordered item. Breaks ties by earliest appearance.
     * Time Complexity: O(n) where n is the number of orders.
     * Auxiliary Space Complexity: O(u) where u is the number of unique items.
     */
    public static OrderCount mostPopular(String[] orders) {
        if (orders == null || orders.length == 0) {
            return new OrderCount("", 0);
        }

        Map<String, Integer> freqMap = new HashMap<>();
        for (String item : orders) {
            freqMap.put(item, freqMap.getOrDefault(item, 0) + 1);
        }

        String bestItem = "";
        int maxCount = -1;

        for (String item : orders) {
            int count = freqMap.get(item);
            if (count > maxCount) {
                maxCount = count;
                bestItem = item;
            }
        }

        return new OrderCount(bestItem, maxCount);
    }

    public static void main(String[] args) {
        String[] orders1 = {"dosa", "idli", "vada", "dosa", "idli", "dosa", "tea"};
        System.out.println("Sample 1: " + mostPopular(orders1));

        String[] orders2 = {"tea", "coffee", "coffee", "tea"};
        System.out.println("Sample 2: " + mostPopular(orders2));
    }
}
