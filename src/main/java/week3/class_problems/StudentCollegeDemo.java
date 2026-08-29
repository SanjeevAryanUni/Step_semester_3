package week3.class_problems;

public class StudentCollegeDemo {
    public static class Student {
        String name;
        int attendance;
        static String collegeName = "SRM Institute of Science and Technology";
        static int studentCount = 0;

        public Student(String name, int attendance) {
            this.name = name;
            this.attendance = attendance;
            studentCount++;
        }

        public static void printCollegeInfo() {
            System.out.println(collegeName);
            System.out.println("Students created: " + studentCount);
        }
    }

    public static void main(String[] args) {
        new Student("Ravi", 85);
        new Student("Anitha", 92);

        Student.printCollegeInfo();
    }
}
