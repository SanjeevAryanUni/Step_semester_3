package week1.class_problems;

public class BmiCalculator {
    public static String getBmiStatus(double bmi) {
        if (bmi < 18.5) return "Underweight";
        else if (bmi < 25.0) return "Normal";
        else if (bmi < 30.0) return "Overweight";
        else return "Obese";
    }

    public static void printWellnessReport(double[] heights, double[] weights) {
        for (int i = 0; i < heights.length; i++) {
            double bmi = weights[i] / (heights[i] * heights[i]);
            String status = getBmiStatus(bmi);
            System.out.printf("Person %d — Height: %.2f m, Weight: %.0f kg | BMI: %.2f | Status: %s%n",
                    (i + 1), heights[i], weights[i], bmi, status);
        }
    }

    public static void main(String[] args) {
        double[] heights = {1.75, 1.60};
        double[] weights = {70.0, 90.0};
        printWellnessReport(heights, weights);
    }
}
