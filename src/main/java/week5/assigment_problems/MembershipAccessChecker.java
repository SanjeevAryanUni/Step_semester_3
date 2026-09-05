package week5.assigment_problems;

import java.util.LinkedHashMap;
import java.util.Map;

public class MembershipAccessChecker {
    public static class LibraryMember {
        private String membershipPin;
        String branchCode; // default
        protected double finesOwed;
        public String displayName;

        public LibraryMember(String membershipPin, String branchCode, double finesOwed, String displayName) {
            this.membershipPin = membershipPin;
            this.branchCode = branchCode;
            this.finesOwed = finesOwed;
            this.displayName = displayName;
        }
    }

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
        return "DENIED";
    }

    public static String summarizeByModifier(String[][] attempts) {
        String[] modifiers = {"private", "default", "protected", "public"};
        Map<String, int[]> stats = new LinkedHashMap<>();
        for (String mod : modifiers) {
            stats.put(mod, new int[]{0, 0}); // allowed, denied
        }

        for (String[] attempt : attempts) {
            String mod = attempt[0];
            String ctx = attempt[1];
            String result = classifyAccess(mod, ctx);
            if (stats.containsKey(mod)) {
                if ("ALLOWED".equals(result)) stats.get(mod)[0]++;
                else stats.get(mod)[1]++;
            }
        }

        StringBuilder sb = new StringBuilder();
        int idx = 0;
        for (String mod : modifiers) {
            int[] counts = stats.get(mod);
            sb.append(mod).append(": ").append(counts[0]).append(" allowed / ").append(counts[1]).append(" denied");
            if (idx < modifiers.length - 1) {
                sb.append(" | ");
            }
            idx++;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(classifyAccess("private", "SAME_CLASS"));
        System.out.println(classifyAccess("protected", "DIFFERENT_PACKAGE"));

        String[][] batch = {
            {"private", "SAME_CLASS"},
            {"private", "SAME_PACKAGE"},
            {"default", "SAME_PACKAGE"},
            {"default", "DIFFERENT_PACKAGE"},
            {"protected", "SAME_PACKAGE"},
            {"protected", "SAME_CLASS"},
            {"public", "DIFFERENT_PACKAGE"}
        };
        System.out.println(summarizeByModifier(batch));
    }
}
