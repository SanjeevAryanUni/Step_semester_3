package week10.class_problems;

import java.util.ArrayList;
import java.util.List;

public class PayrollRegisterSystem {
    public static abstract class Staff {
        protected String name;
        protected String type;

        public Staff(String name, String type) {
            this.name = name;
            this.type = type;
        }

        public String getName() { return name; }
        public String getType() { return type; }
        public abstract int calculatePay();

        public String getPayslip() {
            return "Payslip[name=" + name + ", type=" + type + ", pay=" + calculatePay() + "]";
        }
    }

    public static class FullTimeStaff extends Staff {
        private int salary;

        public FullTimeStaff(String name, int salary) {
            super(name, "FullTime");
            this.salary = salary;
        }

        @Override
        public int calculatePay() {
            return salary;
        }
    }

    public static class PartTimeStaff extends Staff {
        private int hours;
        private int rate;

        public PartTimeStaff(String name, int hours, int rate) {
            super(name, "PartTime");
            this.hours = hours;
            this.rate = rate;
        }

        @Override
        public int calculatePay() {
            return hours * rate;
        }
    }

    public static class InternStaff extends Staff {
        private int stipend;

        public InternStaff(String name, int stipend) {
            super(name, "Intern");
            this.stipend = stipend;
        }

        @Override
        public int calculatePay() {
            return stipend;
        }
    }

    public static class PayrollRegister {
        private List<Staff> staffList = new ArrayList<>();

        public void addStaff(Staff s) {
            staffList.add(s);
        }

        public void processPayroll() {
            int total = 0;
            String topEarner = "";
            int maxPay = -1;

            for (Staff s : staffList) {
                System.out.println(s.getPayslip());
                int pay = s.calculatePay();
                total += pay;
                if (pay > maxPay) {
                    maxPay = pay;
                    topEarner = s.getName();
                }
            }

            System.out.println("Total " + total);
            System.out.println("top earner " + topEarner);
        }
    }

    public static void main(String[] args) {
        PayrollRegister pr = new PayrollRegister();
        pr.addStaff(new FullTimeStaff("Asha", 50000));
        pr.addStaff(new PartTimeStaff("Ravi", 80, 300));
        pr.addStaff(new InternStaff("Neha", 15000));

        pr.processPayroll();
    }
}
