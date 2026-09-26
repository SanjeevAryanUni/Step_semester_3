package week8.class_problems;

import java.util.*;

public class HotelBookingSystem {
    public static abstract class Room {
        protected String roomNumber;
        protected String type;
        protected double pricePerNight;

        public Room(String roomNumber, String type, double pricePerNight) {
            this.roomNumber = roomNumber;
            this.type = type;
            this.pricePerNight = pricePerNight;
        }

        public String getRoomNumber() { return roomNumber; }
        public String getType() { return type; }
        public abstract double calculatePrice(int nights);
    }

    public static class StandardRoom extends Room {
        public StandardRoom(String roomNumber) { super(roomNumber, "Standard Room", 100.0); }
        @Override public double calculatePrice(int nights) { return pricePerNight * nights; }
    }

    public static class DeluxeRoom extends Room {
        public DeluxeRoom(String roomNumber) { super(roomNumber, "Deluxe Room", 150.0); }
        @Override public double calculatePrice(int nights) { return pricePerNight * nights; }
    }

    public static class Suite extends Room {
        public Suite(String roomNumber) { super(roomNumber, "Suite", 250.0); }
        @Override public double calculatePrice(int nights) { return pricePerNight * nights; }
    }

    public static class Customer {
        private String name;
        public Customer(String name) { this.name = name; }
        public String getName() { return name; }
    }

    public static class Reservation {
        private Customer customer;
        private Room room;
        private String dateRange;
        private int startDay, endDay;
        private double price;
        private boolean active;

        public Reservation(Customer customer, Room room, String dateRange, int startDay, int endDay, int nights) {
            this.customer = customer;
            this.room = room;
            this.dateRange = dateRange;
            this.startDay = startDay;
            this.endDay = endDay;
            this.price = room.calculatePrice(nights);
            this.active = true;
        }

        public Customer getCustomer() { return customer; }
        public Room getRoom() { return room; }
        public String getDateRange() { return dateRange; }
        public double getPrice() { return price; }
        public boolean isActive() { return active; }
        public void cancel() { this.active = false; }

        public boolean overlaps(int start, int end) {
            return active && !(end <= startDay || start >= endDay);
        }
    }

    public static class Hotel {
        private List<Reservation> reservations = new ArrayList<>();

        public boolean isAvailable(Room room, int start, int end) {
            for (Reservation res : reservations) {
                if (res.getRoom().getRoomNumber().equals(room.getRoomNumber()) && res.overlaps(start, end)) {
                    return false;
                }
            }
            return true;
        }

        public Reservation reserve(Customer customer, Room room, String dateRange, int start, int end, int nights) {
            if (!isAvailable(room, start, end)) {
                System.out.println(room.getType() + " " + room.getRoomNumber() + " is not available from " + dateRange + ".");
                return null;
            }
            Reservation res = new Reservation(customer, room, dateRange, start, end, nights);
            reservations.add(res);
            System.out.printf("Reservation confirmed for %s, %s %s (%s). Price: $%.2f.%n",
                    customer.getName(), room.getType(), room.getRoomNumber(), dateRange, res.getPrice());
            return res;
        }

        public void cancel(Reservation res) {
            if (res != null && res.isActive()) {
                res.cancel();
                System.out.println("Reservation for " + res.getCustomer().getName() + ", " +
                        res.getRoom().getType() + " " + res.getRoom().getRoomNumber() + " (" +
                        res.getDateRange() + ") cancelled successfully.");
            }
        }
    }

    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        Customer a = new Customer("Customer A");
        Customer b = new Customer("Customer B");
        Customer c = new Customer("Customer C");

        Room room101 = new StandardRoom("101");
        Room room201 = new DeluxeRoom("201");

        if (hotel.isAvailable(room101, 1, 5)) {
            System.out.println("Standard Room 101 is available from Jan 1 to Jan 5.");
        }

        Reservation resA = hotel.reserve(a, room101, "Jan 1-5", 1, 5, 4);
        hotel.reserve(b, room101, "Jan 3-7", 3, 7, 4);
        hotel.cancel(resA);
        hotel.reserve(c, room201, "Feb 10-12", 41, 43, 2);
    }
}
