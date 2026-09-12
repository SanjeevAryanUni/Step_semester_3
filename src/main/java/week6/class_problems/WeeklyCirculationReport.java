package week6.class_problems;

public class WeeklyCirculationReport {
    public static class LibraryMember {
        protected String memberId;
        protected int borrowLimit;
        protected int booksBorrowed;

        public LibraryMember(String memberId, int borrowLimit) {
            this.memberId = memberId;
            this.borrowLimit = borrowLimit;
            this.booksBorrowed = 0;
        }

        public String displayInfo() {
            return "General | Books: " + booksBorrowed;
        }
    }

    public static class StudentMember extends LibraryMember {
        private String course;

        public StudentMember(String memberId, int borrowLimit, String course) {
            super(memberId, borrowLimit);
            this.course = course;
        }

        public String getCourse() {
            return course;
        }

        @Override
        public String displayInfo() {
            return "Student | Course: " + course + " | Books: " + booksBorrowed;
        }
    }

    public static String batchPrint(LibraryMember[] members) {
        StringBuilder sb = new StringBuilder();
        for (LibraryMember m : members) {
            if (m != null) {
                sb.append(m.displayInfo());
                if (m instanceof StudentMember) {
                    StudentMember sm = (StudentMember) m;
                    sb.append(" [Course via downcast: ").append(sm.getCourse()).append("]");
                }
                sb.append(" | ");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LibraryMember[] members = {
            new LibraryMember("LB5", 3),
            new StudentMember("STU6", 3, "ECE")
        };
        System.out.println(batchPrint(members));
    }
}
