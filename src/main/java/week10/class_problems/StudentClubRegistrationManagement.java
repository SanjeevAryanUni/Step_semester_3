package week10.class_problems;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class StudentClubRegistrationManagement {
    public static class Student {
        private String rollNumber;
        private String name;

        public Student(String rollNumber, String name) {
            this.rollNumber = rollNumber;
            this.name = name;
        }

        public String getRollNumber() { return rollNumber; }
        public String getName() { return name; }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Student student = (Student) o;
            return Objects.equals(rollNumber, student.rollNumber);
        }

        @Override
        public int hashCode() {
            return Objects.hash(rollNumber);
        }
    }

    public static class ClubRegistration {
        private Set<Student> members = new HashSet<>();

        public void add(String rollNumber, String name) {
            Student s = new Student(rollNumber, name);
            if (members.add(s)) {
                System.out.println("Added");
            } else {
                System.out.println("duplicate rejected");
            }
        }

        public void printMemberCount() {
            System.out.println("member count " + members.size());
        }

        public void contains(String rollNumber, String name) {
            Student s = new Student(rollNumber, name);
            System.out.println("contains: " + members.contains(s));
        }
    }

    public static void main(String[] args) {
        ClubRegistration club = new ClubRegistration();
        club.add("21CS01", "Asha");
        club.add("21CS01", "Asha");
        club.add("21CS02", "Ravi");
        club.printMemberCount();
        club.contains("21CS02", "Ravi");
        club.contains("21CS03", "Priya");
    }
}
