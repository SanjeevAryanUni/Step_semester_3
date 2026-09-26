package week8.assigment_problems;

public class AssignmentSubmissionPortal {
    public static class Student {
        private String name;
        public Student(String name) { this.name = name; }
        public String getName() { return name; }
    }

    public static abstract class Assignment {
        protected String title;
        protected int maxMarks;
        protected int dueDay; // e.g., 10 for Mar 10

        public Assignment(String title, int maxMarks, int dueDay) {
            this.title = title;
            this.maxMarks = maxMarks;
            this.dueDay = dueDay;
        }

        public String getTitle() { return title; }
        public int getMaxMarks() { return maxMarks; }
        public int getDueDay() { return dueDay; }

        public abstract int calculateLatePenaltyPercentage(int daysLate);
    }

    public static class CodingAssignment extends Assignment {
        public CodingAssignment(String title, int maxMarks, int dueDay) {
            super(title, maxMarks, dueDay);
        }

        @Override
        public int calculateLatePenaltyPercentage(int daysLate) {
            if (daysLate <= 0) return 0;
            return Math.min(100, daysLate * 10);
        }
    }

    public static class WrittenAssignment extends Assignment {
        public WrittenAssignment(String title, int maxMarks, int dueDay) {
            super(title, maxMarks, dueDay);
        }

        @Override
        public int calculateLatePenaltyPercentage(int daysLate) {
            if (daysLate <= 0) return 0;
            return Math.min(100, daysLate * 20);
        }
    }

    public enum Status {
        SUBMITTED, GRADED
    }

    public static class Submission {
        private Student student;
        private Assignment assignment;
        private int submissionDay;
        private Status status;
        private int finalMarks;

        public Submission(Student student, Assignment assignment, int submissionDay) {
            this.student = student;
            this.assignment = assignment;
            this.submissionDay = submissionDay;
            this.status = Status.SUBMITTED;

            int daysLate = Math.max(0, submissionDay - assignment.getDueDay());
            if (daysLate == 0) {
                System.out.println(student.getName() + "'s submission for '" + assignment.getTitle() + "' received (on time). Status: Submitted.");
            } else {
                System.out.println(student.getName() + "'s submission for '" + assignment.getTitle() + "' received (" + daysLate + " days late). Status: Submitted.");
            }
        }

        public boolean grade(int rawMarks) {
            if (status == Status.GRADED) {
                return false;
            }
            int daysLate = Math.max(0, submissionDay - assignment.getDueDay());
            int penaltyPct = assignment.calculateLatePenaltyPercentage(daysLate);
            this.finalMarks = (int) Math.round(rawMarks * (1.0 - (penaltyPct / 100.0)));
            this.status = Status.GRADED;

            if (penaltyPct == 0) {
                System.out.println(student.getName() + " graded: " + finalMarks + "/" + assignment.getMaxMarks() + ". Status: Graded.");
            } else {
                System.out.println(student.getName() + " graded: " + finalMarks + "/" + assignment.getMaxMarks() + " after " + penaltyPct + "% late penalty. Status: Graded.");
            }
            return true;
        }

        public boolean resubmit(int newSubmissionDay) {
            if (status == Status.GRADED) {
                System.out.println("Cannot resubmit: '" + assignment.getTitle() + "' has already been graded.");
                return false;
            }
            this.submissionDay = newSubmissionDay;
            return true;
        }
    }

    public static void main(String[] args) {
        Assignment coding = new CodingAssignment("Linked List Lab", 50, 10);
        Assignment written = new WrittenAssignment("Design Essay", 50, 12);

        Student asha = new Student("Asha");
        Student ravi = new Student("Ravi");

        Submission subAsha = new Submission(asha, coding, 10);
        Submission subRavi = new Submission(ravi, written, 14);

        subAsha.grade(45);
        subRavi.grade(40);

        subAsha.resubmit(11);
    }
}
