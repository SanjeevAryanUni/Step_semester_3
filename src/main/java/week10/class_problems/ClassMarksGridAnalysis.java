package week10.class_problems;

import java.util.ArrayList;
import java.util.List;

public class ClassMarksGridAnalysis {
    public static class StudentRecord {
        public String name;
        public int[] marks;

        public StudentRecord(String name, int[] marks) {
            this.name = name;
            this.marks = marks;
        }

        public int getTotal() {
            int sum = 0;
            for (int m : marks) sum += m;
            return sum;
        }
    }

    public static void analyze(List<StudentRecord> students) {
        if (students == null || students.isEmpty()) return;

        StringBuilder totalsSb = new StringBuilder("Totals ");
        String topperName = "";
        int highestTotal = -1;
        int numSubjects = students.get(0).marks.length;
        double[] subjectTotals = new double[numSubjects];

        for (int i = 0; i < students.size(); i++) {
            StudentRecord s = students.get(i);
            int total = s.getTotal();
            totalsSb.append(s.name).append(" ").append(total);
            if (i < students.size() - 1) {
                totalsSb.append(", ");
            }

            if (total > highestTotal) {
                highestTotal = total;
                topperName = s.name;
            }

            for (int j = 0; j < numSubjects; j++) {
                subjectTotals[j] += s.marks[j];
            }
        }

        System.out.println(totalsSb.toString());

        StringBuilder avgSb = new StringBuilder("averages ");
        for (int j = 0; j < numSubjects; j++) {
            double avg = subjectTotals[j] / students.size();
            avgSb.append(String.format("%.2f", avg));
            if (j < numSubjects - 1) {
                avgSb.append(", ");
            }
        }
        System.out.println(avgSb.toString());

        System.out.println("topper " + topperName + " (" + highestTotal + ")");
    }

    public static void main(String[] args) {
        List<StudentRecord> list = new ArrayList<>();
        list.add(new StudentRecord("Asha", new int[]{78, 85, 90}));
        list.add(new StudentRecord("Ravi", new int[]{88, 92, 79}));
        list.add(new StudentRecord("Neha", new int[]{65, 70, 95}));

        analyze(list);
    }
}
