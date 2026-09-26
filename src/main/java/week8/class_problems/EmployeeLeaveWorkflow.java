package week8.class_problems;

public class EmployeeLeaveWorkflow {
    public static abstract class Employee {
        protected String name;
        protected String role;

        public Employee(String name, String role) {
            this.name = name;
            this.role = role;
        }

        public String getName() { return name; }
        public String getRole() { return role; }
    }

    public static class FullTimeEmployee extends Employee {
        public FullTimeEmployee(String name) { super(name, "FullTime"); }
    }

    public static class PartTimeEmployee extends Employee {
        public PartTimeEmployee(String name) { super(name, "PartTime"); }
    }

    public static class Contractor extends Employee {
        public Contractor(String name) { super(name, "Contractor"); }
    }

    public enum LeaveStatus {
        PENDING, APPROVED, REJECTED
    }

    public static class LeaveRequest {
        private Employee employee;
        private String dateRange;
        private LeaveStatus status;

        public LeaveRequest(Employee employee, String dateRange) {
            this.employee = employee;
            this.dateRange = dateRange;
            this.status = LeaveStatus.PENDING;
            System.out.println("Leave request submitted for " + employee.getName() + " (" + dateRange + "). Status: Pending.");
        }

        public void approve() {
            if (status == LeaveStatus.PENDING) {
                this.status = LeaveStatus.APPROVED;
                System.out.println(employee.getName() + "'s leave request (" + dateRange + ") approved. Status: Approved.");
            }
        }

        public void reject() {
            if (status == LeaveStatus.PENDING) {
                this.status = LeaveStatus.REJECTED;
                System.out.println(employee.getName() + "'s leave request (" + dateRange + ") rejected. Status: Rejected.");
            }
        }

        public void revertToPending() {
            if (status == LeaveStatus.APPROVED || status == LeaveStatus.REJECTED) {
                System.out.println("Cannot change leave request status from " +
                        (status == LeaveStatus.APPROVED ? "Approved" : "Rejected") + " to Pending.");
            }
        }
    }

    public static void main(String[] args) {
        Employee john = new FullTimeEmployee("John");
        Employee jane = new PartTimeEmployee("Jane");

        LeaveRequest req1 = new LeaveRequest(john, "Jan 1-5");
        req1.approve();

        LeaveRequest req2 = new LeaveRequest(jane, "Feb 10-11");
        req2.reject();

        req1.revertToPending();
    }
}
