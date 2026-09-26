package week8.assigment_problems;

import java.util.*;

public class CampusPremiereTicketCounter {
    public interface Seat {
        String getSeatNumber();
        double getPrice();
    }

    public static class RegularSeat implements Seat {
        private String seatNumber;
        public RegularSeat(String seatNumber) { this.seatNumber = seatNumber; }
        @Override public String getSeatNumber() { return seatNumber; }
        @Override public double getPrice() { return 150.00; }
    }

    public static class PremiumSeat implements Seat {
        private String seatNumber;
        public PremiumSeat(String seatNumber) { this.seatNumber = seatNumber; }
        @Override public String getSeatNumber() { return seatNumber; }
        @Override public double getPrice() { return 250.00; }
    }

    public static class ReclinerSeat implements Seat {
        private String seatNumber;
        public ReclinerSeat(String seatNumber) { this.seatNumber = seatNumber; }
        @Override public String getSeatNumber() { return seatNumber; }
        @Override public double getPrice() { return 400.00; }
    }

    public static class Customer {
        private String name;
        public Customer(String name) { this.name = name; }
        public String getName() { return name; }
    }

    public static class Booking {
        private Customer customer;
        private List<Seat> seats;
        private double total;

        public Booking(Customer customer, List<Seat> seats) {
            this.customer = customer;
            this.seats = new ArrayList<>(seats);
            double sum = 0;
            for (Seat s : seats) sum += s.getPrice();
            this.total = sum;
        }

        public Customer getCustomer() { return customer; }
        public List<Seat> getSeats() { return Collections.unmodifiableList(seats); }
        public double getTotal() { return total; }
    }

    public static class Show {
        private String showTime;
        private Map<String, Seat> bookedSeats = new HashMap<>();

        public Show(String showTime) {
            this.showTime = showTime;
        }

        public Booking bookSeats(Customer customer, List<Seat> requestedSeats) {
            if (requestedSeats == null || requestedSeats.isEmpty() || requestedSeats.size() > 6) {
                return null;
            }
            for (Seat s : requestedSeats) {
                if (bookedSeats.containsKey(s.getSeatNumber())) {
                    System.out.println("Seat " + s.getSeatNumber() + " is already booked for this show.");
                    return null;
                }
            }
            for (Seat s : requestedSeats) {
                bookedSeats.put(s.getSeatNumber(), s);
            }
            Booking booking = new Booking(customer, requestedSeats);
            List<String> names = new ArrayList<>();
            for (Seat s : requestedSeats) names.add(s.getSeatNumber());
            System.out.printf("Booking confirmed for %s: %s. Total: ₹%.2f.%n",
                    customer.getName(), String.join(", ", names), booking.getTotal());
            return booking;
        }

        public void cancelBooking(Booking booking, boolean beforeShowStarts) {
            if (booking == null) return;
            if (!beforeShowStarts) {
                System.out.println("Cannot cancel booking after show has started.");
                return;
            }
            List<String> names = new ArrayList<>();
            for (Seat s : booking.getSeats()) {
                bookedSeats.remove(s.getSeatNumber());
                names.add(s.getSeatNumber());
            }
            System.out.println(booking.getCustomer().getName() + "'s booking cancelled. Seats " +
                    String.join(", ", names) + " released.");
        }
    }

    public static void main(String[] args) {
        Show show7PM = new Show("7 PM");
        Customer asha = new Customer("Asha");
        Customer ravi = new Customer("Ravi");
        Customer neha = new Customer("Neha");

        List<Seat> ashaSeats = Arrays.asList(new RegularSeat("A1"), new RegularSeat("A2"), new PremiumSeat("F5"));
        Booking ashaBooking = show7PM.bookSeats(asha, ashaSeats);

        show7PM.bookSeats(ravi, Collections.singletonList(new RegularSeat("A2")));

        show7PM.bookSeats(ravi, Collections.singletonList(new ReclinerSeat("R1")));

        show7PM.cancelBooking(ashaBooking, true);

        show7PM.bookSeats(neha, Collections.singletonList(new RegularSeat("A2")));
    }
}
