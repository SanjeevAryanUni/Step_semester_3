package week3.assigment_problems;

public class EmployeeConstructorDemo {
    public static class Employee {
        String empId;
        String empName;
        double salary;
        boolean isIntern;

        public Employee(String empId, String empName, double salary) {
            this.empId = empId;
            this.empName = empName;
            this.salary = salary;
            this.isIntern = false;
        }

        public Employee(String empId, String empName) {
            this(empId, empName, 0.0);
            this.isIntern = true;
        }

        public void printProfile() {
            System.out.println(empId + " | " + empName + " | Rs " + salary + " | Intern: " + isIntern);
        }
    }

    public static void main(String[] args) {
        Employee permanentEmp = new Employee("E-101", "Divya", 65000);
        Employee internEmp = new Employee("E-102", "Arjun");

        permanentEmp.printProfile();
        internEmp.printProfile();
    }
}
