package week8.class_problems;

public class VehicleRentalSystem {
    public static abstract class Vehicle {
        protected String id;
        protected String category;
        protected double dailyRate;
        protected boolean isRented;

        public Vehicle(String id, String category, double dailyRate) {
            this.id = id;
            this.category = category;
            this.dailyRate = dailyRate;
            this.isRented = false;
        }

        public String getId() { return id; }
        public String getCategory() { return category; }
        public double getDailyRate() { return dailyRate; }
        public boolean isRented() { return isRented; }
        public void setRented(boolean rented) { isRented = rented; }

        public abstract double calculateRentalCharge(int days);
    }

    public static class Sedan extends Vehicle {
        public Sedan(String id) { super(id, "Sedan", 50.0); }
        @Override
        public double calculateRentalCharge(int days) { return dailyRate * days; }
    }

    public static class SUV extends Vehicle {
        public SUV(String id) { super(id, "SUV", 80.0); }
        @Override
        public double calculateRentalCharge(int days) { return dailyRate * days; }
    }

    public static class Truck extends Vehicle {
        public Truck(String id) { super(id, "Truck", 100.0); }
        @Override
        public double calculateRentalCharge(int days) { return dailyRate * days; }
    }

    public static class Customer {
        private String name;
        public Customer(String name) { this.name = name; }
        public String getName() { return name; }
    }

    public static class RentalSystem {
        public static boolean rentVehicle(Customer customer, Vehicle vehicle, int days) {
            if (vehicle.isRented()) {
                System.out.println(vehicle.getCategory() + " " + vehicle.getId() + " is currently unavailable.");
                return false;
            }
            vehicle.setRented(true);
            double charge = vehicle.calculateRentalCharge(days);
            System.out.printf("%s %s rented successfully by %s. Rental charge: $%.2f.%n",
                    vehicle.getCategory(), vehicle.getId(), customer.getName(), charge);
            return true;
        }

        public static void returnVehicle(Customer customer, Vehicle vehicle) {
            if (vehicle.isRented()) {
                vehicle.setRented(false);
                System.out.println(vehicle.getCategory() + " " + vehicle.getId() + " returned by " + customer.getName() + ".");
            }
        }
    }

    public static void main(String[] args) {
        Customer c1 = new Customer("Customer 1");
        Customer c2 = new Customer("Customer 2");
        Customer c3 = new Customer("Customer 3");

        Vehicle sedanA = new Sedan("A");
        Vehicle suvB = new SUV("B");

        RentalSystem.rentVehicle(c1, sedanA, 3);
        RentalSystem.rentVehicle(c2, sedanA, 2);
        RentalSystem.returnVehicle(c1, sedanA);
        RentalSystem.rentVehicle(c3, suvB, 5);
    }
}
