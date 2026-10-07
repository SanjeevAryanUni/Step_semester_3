package week9.class_problems;

public class WarehouseGridSummary {
    public static class Summary {
        public final int totalItems;
        public final int maxRow;
        public final int maxCol;

        public Summary(int totalItems, int maxRow, int maxCol) {
            this.totalItems = totalItems;
            this.maxRow = maxRow;
            this.maxCol = maxCol;
        }

        @Override
        public String toString() {
            return "(" + totalItems + ", (" + maxRow + ", " + maxCol + "))";
        }
    }

    /**
     * Calculates total items in 2D grid and finds coordinates (row, col) of the max item bin.
     * Time Complexity: O(m * n) where m is rows and n is columns.
     * Auxiliary Space Complexity: O(1).
     */
    public static Summary warehouseSummary(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return new Summary(0, -1, -1);
        }

        int totalItems = 0;
        int maxItems = -1;
        int maxRow = 0;
        int maxCol = 0;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                int count = grid[r][c];
                totalItems += count;
                // Strictly greater ensures the first encountered in row-major order is preserved on ties
                if (count > maxItems) {
                    maxItems = count;
                    maxRow = r;
                    maxCol = c;
                }
            }
        }

        return new Summary(totalItems, maxRow, maxCol);
    }

    public static void main(String[] args) {
        int[][] grid = {
            {4, 9, 2},
            {7, 1, 6},
            {3, 12, 5}
        };

        System.out.println("Expected: (49, (2, 1)) | Actual: " + warehouseSummary(grid));
    }
}
