package week11.assigment_problems;

public class ContestLeaderboard {
    public static class Entry {
        public String name;
        public int marks; // 0 to 100

        public Entry(String name, int marks) {
            this.name = name;
            this.marks = marks;
        }

        @Override
        public String toString() {
            return name + " " + marks;
        }
    }

    /**
     * Problem 5: The Contest Leaderboard
     * Sorts entries from highest marks to lowest using Counting Sort without comparisons.
     * Preserves original submission order for equal marks (Stable).
     * 
     * Key transformation: key = 100 - marks (0 to 100).
     * Higher marks get smaller keys (rank higher).
     * 
     * Time Complexity: O(n + 101) where n is number of entries
     * Extra Space Complexity: O(n + 101) for frequency array and output array
     * Stability: Stable (iterates input right-to-left when placing into output)
     */
    public static Entry[] leaderboard(Entry[] entries) {
        if (entries == null || entries.length <= 1) {
            return entries;
        }

        int n = entries.length;
        int maxKey = 100;
        int[] count = new int[maxKey + 1];

        // Step 1: Count occurrences of each key (key = 100 - marks)
        for (Entry e : entries) {
            int key = 100 - e.marks;
            count[key]++;
        }

        // Step 2: Build cumulative counts
        for (int i = 1; i <= maxKey; i++) {
            count[i] += count[i - 1];
        }

        // Step 3: Place entries into output array from right to left to preserve stability
        Entry[] output = new Entry[n];
        for (int i = n - 1; i >= 0; i--) {
            Entry e = entries[i];
            int key = 100 - e.marks;
            int pos = count[key] - 1;
            output[pos] = e;
            count[key]--;
        }

        return output;
    }

    public static void main(String[] args) {
        Entry[] entries = {
            new Entry("Asha", 90),
            new Entry("Ravi", 75),
            new Entry("Neha", 90),
            new Entry("Kiran", 100),
            new Entry("Meera", 75)
        };

        Entry[] result = leaderboard(entries);

        // Expected Output: Kiran 100, Asha 90, Neha 90, Ravi 75, Meera 75
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
            if (i < result.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}
