package week2.class_problems;

import java.util.Arrays;
import java.util.List;

public class FileExtensionValidator {
    private static final List<String> ACCEPTED_EXTENSIONS = Arrays.asList("pdf", "docx", "zip");

    public static String validateFileExtension(String filename) {
        int dotIndex = filename.lastIndexOf('.');
        if (dotIndex != -1 && dotIndex < filename.length() - 1) {
            String ext = filename.substring(dotIndex + 1).toLowerCase();
            if (ACCEPTED_EXTENSIONS.contains(ext)) {
                return "Accepted";
            }
        }
        return "Rejected — invalid file type";
    }

    public static void main(String[] args) {
        System.out.println(validateFileExtension("Assignment1.PDF"));
        System.out.println(validateFileExtension("notes.txt"));
    }
}
