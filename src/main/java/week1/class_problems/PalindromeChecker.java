package week1.class_problems;

public class PalindromeChecker {
    public static boolean isPalindromeIterative(String text) {
        int left = 0, right = text.length() - 1;
        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    public static boolean isPalindromeRecursive(String text) {
        if (text.length() <= 1) return true;
        if (text.charAt(0) != text.charAt(text.length() - 1)) return false;
        return isPalindromeRecursive(text.substring(1, text.length() - 1));
    }

    public static boolean isPalindromeArrayReversal(String text) {
        char[] arr = text.toCharArray();
        char[] rev = new char[arr.length];
        for (int i = 0; i < arr.length; i++) {
            rev[i] = arr[arr.length - 1 - i];
        }
        return new String(arr).equals(new String(rev));
    }

    public static void checkAll(String text) {
        boolean it = isPalindromeIterative(text);
        boolean rec = isPalindromeRecursive(text);
        boolean arr = isPalindromeArrayReversal(text);
        System.out.println("\"" + text + "\" -> Iterative: " + (it ? "Palindrome" : "Not Palindrome") +
                " | Recursive: " + (rec ? "Palindrome" : "Not Palindrome") +
                " | Array Reversal: " + (arr ? "Palindrome" : "Not Palindrome"));
    }

    public static void main(String[] args) {
        checkAll("madam");
        checkAll("hello");
    }
}
