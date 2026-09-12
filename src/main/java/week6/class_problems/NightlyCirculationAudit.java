package week6.class_problems;

public class NightlyCirculationAudit {
    public static class LibraryMember {
        private static int membersEnrolled = 0;
        public final String memberNumber;
        protected int borrowLimit;
        protected int booksBorrowed;

        public LibraryMember(int borrowLimit) {
            membersEnrolled++;
            this.memberNumber = "LIB-" + (100 + membersEnrolled);
            this.borrowLimit = borrowLimit;
            this.booksBorrowed = 0;
        }

        public void borrowBook() {
            this.booksBorrowed++;
        }

        public void borrowBook(String genre) {
            borrowBook();
        }

        public int getBooksBorrowed() {
            return booksBorrowed;
        }

        public static int getMembersEnrolled() {
            return membersEnrolled;
        }
    }

    public static class FacultyMember extends LibraryMember {
        private String department;

        public FacultyMember(int borrowLimit, String department) {
            super(borrowLimit);
            this.department = department;
        }

        public String getDepartment() {
            return department;
        }
    }

    public static boolean isValidRenewalCode(String code) {
        if (code == null || code.length() != 4) {
            return false;
        }
        if (code.charAt(0) != 'R') {
            return false;
        }
        if (!Character.isDigit(code.charAt(1)) || !Character.isDigit(code.charAt(2))) {
            return false;
        }
        return Character.isUpperCase(code.charAt(3));
    }

    public static String processNightlyAudit(LibraryMember[] members) {
        int processed = 0, nullSkipped = 0, facultyCount = 0, regularCount = 0;
        if (members != null) {
            for (LibraryMember m : members) {
                if (m == null) {
                    nullSkipped++;
                } else {
                    processed++;
                    if (m instanceof FacultyMember) {
                        facultyCount++;
                    } else {
                        regularCount++;
                    }
                }
            }
        }
        return processed + " processed | " + nullSkipped + " null skipped | " + facultyCount + " faculty | " + regularCount + " regular";
    }

    public static void main(String[] args) {
        LibraryMember m1 = new LibraryMember(3);
        System.out.println(m1.memberNumber);
        System.out.println(LibraryMember.getMembersEnrolled());

        System.out.println(isValidRenewalCode("R12A"));
        System.out.println(isValidRenewalCode("R1A"));
        System.out.println(isValidRenewalCode("X12A"));

        m1.borrowBook();
        m1.borrowBook("Fiction");
        System.out.println(m1.getBooksBorrowed());

        LibraryMember[] batch = {
            new FacultyMember(5, "Physics"),
            null,
            new LibraryMember(3)
        };
        System.out.println(processNightlyAudit(batch));
    }
}
