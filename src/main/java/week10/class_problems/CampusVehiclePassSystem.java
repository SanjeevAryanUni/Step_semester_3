package week10.class_problems;

import java.util.HashMap;
import java.util.Map;

public class CampusVehiclePassSystem {
    public interface Chargeable {
        String bookChargingBay();
    }

    public static abstract class Vehicle {
        protected String passNumber;
        protected String ownerName;
        protected String typeName;
        protected int fee;

        public Vehicle(String passNumber, String ownerName, String typeName, int fee) {
            this.passNumber = passNumber;
            this.ownerName = ownerName;
            this.typeName = typeName;
            this.fee = fee;
        }

        public String getPassNumber() { return passNumber; }
        public String getTypeName() { return typeName; }
        public int getFee() { return fee; }
    }

    public static class Bike extends Vehicle {
        public Bike(String passNumber, String ownerName) {
            super(passNumber, ownerName, "Bike", 300);
        }
    }

    public static class Car extends Vehicle {
        public Car(String passNumber, String ownerName) {
            super(passNumber, ownerName, "Car", 1000);
        }
    }

    public static class EBike extends Vehicle implements Chargeable {
        public EBike(String passNumber, String ownerName) {
            super(passNumber, ownerName, "EBike", 300);
        }

        @Override
        public String bookChargingBay() {
            return passNumber + " charging bay allotted";
        }
    }

    public static class ECar extends Vehicle implements Chargeable {
        public ECar(String passNumber, String ownerName) {
            super(passNumber, ownerName, "ECar", 1000);
        }

        @Override
        public String bookChargingBay() {
            return passNumber + " charging bay allotted";
        }
    }

    public static class VehicleSystem {
        private Map<String, Vehicle> registry = new HashMap<>();

        public void registerVehicle(String type, String passNumber, String owner) {
            Vehicle v;
            switch (type.toLowerCase()) {
                case "bike": v = new Bike(passNumber, owner); break;
                case "car": v = new Car(passNumber, owner); break;
                case "ebike":
                case "e-bike": v = new EBike(passNumber, owner); break;
                case "ecar":
                case "e-car": v = new ECar(passNumber, owner); break;
                default: throw new IllegalArgumentException("Unknown type: " + type);
            }
            registry.put(passNumber, v);
            System.out.printf("%s (%s) pass fee %d%n", v.getPassNumber(), v.getTypeName(), v.getFee());
        }

        public void charge(String passNumber) {
            Vehicle v = registry.get(passNumber);
            if (v == null) {
                System.out.println("Vehicle not found");
                return;
            }
            if (v instanceof Chargeable) {
                System.out.println(((Chargeable) v).bookChargingBay());
            } else {
                System.out.println(passNumber + " rejected: charging unsupported");
            }
        }
    }

    public static void main(String[] args) {
        VehicleSystem vs = new VehicleSystem();
        vs.registerVehicle("Bike", "KA01", "Asha");
        vs.registerVehicle("ECar", "KA02", "Ravi");
        vs.charge("KA02");
        vs.charge("KA01");
    }
}
