package week5.class_problems;

public class SubclassAccessChecker {
    public static String classifyAccess(String fieldModifier, String accessorContext) {
        if ("SAME_CLASS".equals(accessorContext)) {
            return "ALLOWED";
        }
        if ("SAME_PACKAGE".equals(accessorContext)) {
            if ("private".equals(fieldModifier)) return "DENIED";
            return "ALLOWED";
        }
        if ("DIFFERENT_PACKAGE".equals(accessorContext)) {
            if ("public".equals(fieldModifier)) return "ALLOWED";
            return "DENIED";
        }
        if ("SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE".equals(accessorContext)) {
            if ("protected".equals(fieldModifier) || "public".equals(fieldModifier)) return "ALLOWED";
            return "DENIED";
        }
        if ("SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE".equals(accessorContext)) {
            if ("public".equals(fieldModifier)) return "ALLOWED";
            return "DENIED";
        }
        return "DENIED";
    }

    public static void main(String[] args) {
        System.out.println(classifyAccess("protected", "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"));
        System.out.println(classifyAccess("protected", "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"));
    }
}
