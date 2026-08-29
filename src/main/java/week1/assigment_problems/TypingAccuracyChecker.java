package week1.assigment_problems;

public class TypingAccuracyChecker {
    public static void checkTypingAccuracy(String original, String typed) {
        int matched = 0;
        int firstMismatchPos = -1;
        char origChar = '\0', typedChar = '\0';
        int minLen = Math.min(original.length(), typed.length());

        for (int i = 0; i < minLen; i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matched++;
            } else if (firstMismatchPos == -1) {
                firstMismatchPos = i + 1;
                origChar = original.charAt(i);
                typedChar = typed.charAt(i);
            }
        }

        double accuracy = ((double) matched / original.length()) * 100;
        System.out.printf("Matched: %d/%d | Accuracy: %.2f%%", matched, original.length(), accuracy);
        if (firstMismatchPos != -1) {
            System.out.printf(" | First Mismatch at position %d ('%c' vs '%c')%n", firstMismatchPos, origChar, typedChar);
        } else {
            System.out.println(" | No Mismatches");
        }
    }

    public static void main(String[] args) {
        checkTypingAccuracy("hello world", "hello worlt");
        checkTypingAccuracy("coding", "coding");
    }
}
