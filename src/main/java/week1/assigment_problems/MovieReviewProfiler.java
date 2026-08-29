package week1.assigment_problems;

public class MovieReviewProfiler {
    public static void classifyWordLengths(String review) {
        String[] words = review.split("\\s+");
        int shortWords = 0, mediumWords = 0, longWords = 0;

        for (String word : words) {
            String cleaned = word.replaceAll("[^a-zA-Z]", "");
            int len = cleaned.length();
            if (len >= 1 && len <= 4) shortWords++;
            else if (len >= 5 && len <= 8) mediumWords++;
            else if (len >= 9) longWords++;
        }

        System.out.println("Short: " + shortWords + " | Medium: " + mediumWords + " | Long: " + longWords);
    }

    public static void main(String[] args) {
        classifyWordLengths("This movie was absolutely fantastic and thrilling");
    }
}
