package oop.assigment_problems;

public class EmployeeStaticDemo {
    public static class Employee {
        String empName;
        double salary;
        static String companyName = "Bright Horizon Technologies";
        static int employeeCount = 0;

        public Employee(String empName, double salary) {
            this.empName = empName;
            this.salary = salary;
            employeeCount++;
        }

        public static void printCompanyInfo() {
            System.out.println(companyName);
            System.out.println("Employees on record: " + employeeCount);
        }
    }

    public static void main(String[] args) {
        new Employee("Alice", 50000);
        new Employee("Bob", 60000);
        new Employee("Charlie", 70000);

        Employee.printCompanyInfo();
    }
}
