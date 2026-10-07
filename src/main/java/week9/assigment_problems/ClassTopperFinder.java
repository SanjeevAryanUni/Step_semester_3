package week9.assigment_problems;

public class ClassTopperFinder {
    public static class Result {
        public final int rowIndex;
        public final int totalMarks;

        public Result(int rowIndex, int totalMarks) {
            this.rowIndex = rowIndex;
            this.totalMarks = totalMarks;
        }

        @Override
        public String toString() {
            return "(" + rowIndex + ", " + totalMarks + ")";
        }
    }

    /**
     * Finds the student with the highest total marks across subjects.
     * Time Complexity: O(m * n) where m is students and n is subjects.
     * Auxiliary Space Complexity: O(1).
     */
    public static Result findTopper(int[][] marks) {
        if (marks == null || marks.length == 0) {
            return new Result(-1, 0);
        }

        int maxTotal = -1;
        int bestRowIndex = -1;

        for (int i = 0; i < marks.length; i++) {
            int currentTotal = 0;
            for (int j = 0; j < marks[i].length; j++) {
                currentTotal += marks[i][j];
            }
            // Strictly greater to keep the smallest row index on ties
            if (currentTotal > maxTotal) {
                maxTotal = currentTotal;
                bestRowIndex = i;
            }
        }

        return new Result(bestRowIndex, maxTotal);
    }

    public static void main(String[] args) {
        int[][] marks = {
            {78, 85, 90},
            {88, 92, 79},
            {65, 70, 95}
        };

        Result result = findTopper(marks);
        System.out.println("Expected: (1, 259) | Actual: " + result);
    }
}
