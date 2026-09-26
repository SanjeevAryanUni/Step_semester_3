package week8.assigment_problems;

public class HostelLaundryQueue {
    public interface WashType {
        String getName();
        int getDurationMinutes();
        double getCharge();
    }

    public static class QuickWash implements WashType {
        @Override public String getName() { return "Quick"; }
        @Override public int getDurationMinutes() { return 30; }
        @Override public double getCharge() { return 20.00; }
    }

    public static class NormalWash implements WashType {
        @Override public String getName() { return "Normal"; }
        @Override public int getDurationMinutes() { return 45; }
        @Override public double getCharge() { return 30.00; }
    }

    public static class HeavyWash implements WashType {
        @Override public String getName() { return "Heavy"; }
        @Override public int getDurationMinutes() { return 60; }
        @Override public double getCharge() { return 45.00; }
    }

    public static class DelicateWash implements WashType {
        @Override public String getName() { return "Delicate"; }
        @Override public int getDurationMinutes() { return 40; }
        @Override public double getCharge() { return 35.00; }
    }

    public static class Student {
        private String name;
        public Student(String name) { this.name = name; }
        public String getName() { return name; }
    }

    public static class WashingMachine {
        private String id;
        private boolean busy;

        public WashingMachine(String id) {
            this.id = id;
            this.busy = false;
        }

        public String getId() { return id; }
        public boolean isBusy() { return busy; }

        public boolean startWash(Student student, WashType washType) {
            if (busy) {
                System.out.println("Machine " + id + " is currently busy.");
                return false;
            }
            this.busy = true;
            System.out.printf("%s wash started on %s for %s (%d min). Charge: ₹%.2f.%n",
                    washType.getName(), id, student.getName(), washType.getDurationMinutes(), washType.getCharge());
            return true;
        }

        public void completeCycle() {
            if (busy) {
                this.busy = false;
                System.out.println(id + " cycle completed. " + id + " is now free.");
            }
        }
    }

    public static void main(String[] args) {
        WashingMachine m1 = new WashingMachine("M1");
        WashingMachine m2 = new WashingMachine("M2");

        Student asha = new Student("Asha");
        Student ravi = new Student("Ravi");
        Student neha = new Student("Neha");

        m1.startWash(asha, new QuickWash());
        m1.startWash(ravi, new HeavyWash());
        m2.startWash(ravi, new HeavyWash());
        m1.completeCycle();
        m1.startWash(neha, new NormalWash());
    }
}
