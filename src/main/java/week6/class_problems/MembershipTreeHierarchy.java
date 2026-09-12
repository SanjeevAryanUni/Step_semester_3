package week6.class_problems;

public class MembershipTreeHierarchy {
    public static class LibraryMember {
        protected String memberId;
        protected int borrowLimit;
        protected int booksBorrowed;

        public LibraryMember(String memberId, int borrowLimit) {
            this.memberId = memberId;
            this.borrowLimit = borrowLimit;
            this.booksBorrowed = 0;
        }

        public int getBooksBorrowed() {
            return booksBorrowed;
        }

        public void setBooksBorrowed(int count) {
            this.booksBorrowed = count;
        }

        public String displayInfo() {
            return "General Member | Books Borrowed: " + booksBorrowed;
        }
    }

    public static class StudentMember extends LibraryMember {
        protected String course;

        public StudentMember(String memberId, int borrowLimit, String course) {
            super(memberId, borrowLimit);
            this.course = course;
        }

        @Override
        public String displayInfo() {
            return "Student Member | Course: " + course + " | Books Borrowed: " + booksBorrowed;
        }
    }

    public static class HonorsStudentMember extends StudentMember {
        private int bonusLimit;

        public HonorsStudentMember(String memberId, int borrowLimit, String course, int bonusLimit) {
            super(memberId, borrowLimit, course);
            this.bonusLimit = bonusLimit;
        }

        @Override
        public String displayInfo() {
            return "Honors Student Member | Course: " + course + " | Bonus Limit: " + bonusLimit + " | Books Borrowed: " + booksBorrowed;
        }
    }

    public static class FacultyMember extends LibraryMember {
        private String department;

        public FacultyMember(String memberId, int borrowLimit, String department) {
            super(memberId, borrowLimit);
            this.department = department;
        }

        @Override
        public String displayInfo() {
            return "Faculty Member | Department: " + department + " | Books Borrowed: " + booksBorrowed;
        }
    }

    public static String classifyGeneration(LibraryMember member) {
        if (member instanceof HonorsStudentMember) {
            return "Multilevel descendant (3 generations deep)";
        } else if (member instanceof FacultyMember) {
            return "Hierarchical sibling (independent branch)";
        }
        return "Standard Member";
    }

    public static int getTotalBooksBorrowed(LibraryMember[] members) {
        int total = 0;
        for (LibraryMember m : members) {
            if (m != null) {
                total += m.getBooksBorrowed();
            }
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(new LibraryMember("STU1", 3).displayInfo());
        System.out.println(new StudentMember("STU2", 3, "CSE").displayInfo());
        System.out.println(new HonorsStudentMember("STU3", 3, "ECE", 2).displayInfo());
        System.out.println(new FacultyMember("STU4", 5, "Physics").displayInfo());

        HonorsStudentMember honors = new HonorsStudentMember("STU3", 3, "ECE", 2);
        FacultyMember faculty = new FacultyMember("STU4", 5, "Physics");
        System.out.println(classifyGeneration(honors));
        System.out.println(classifyGeneration(faculty));

        StudentMember sm = new StudentMember("STU2", 3, "CSE");
        sm.setBooksBorrowed(2);
        honors.setBooksBorrowed(1);
        faculty.setBooksBorrowed(3);

        LibraryMember[] list = {sm, honors, faculty};
        System.out.println(getTotalBooksBorrowed(list));
    }
}
