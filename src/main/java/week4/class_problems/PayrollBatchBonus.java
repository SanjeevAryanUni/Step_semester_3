package week4.class_problems;

public class PayrollBatchBonus {
    public static class Employee {
        String empId;
        double salary;

        public Employee(String empId, double salary) {
            this.empId = empId;
            this.salary = salary;
        }

        public void raiseSalary(double salary) {
            this.salary += salary;
        }

        public void printFinalSalary() {
            System.out.println(empId + " | Final Salary: Rs " + salary);
        }
    }

    public static void main(String[] args) {
        Employee[] employees = new Employee[] {
            new Employee("E-101", 40000),
            new Employee("E-102", 55000),
            new Employee("E-103", 62000),
            new Employee("E-104", 48000)
        };

        for (Employee emp : employees) {
            emp.raiseSalary(5000);
            emp.printFinalSalary();
        }
    }
}
