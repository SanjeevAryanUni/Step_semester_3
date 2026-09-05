package week5.class_problems;

import java.util.Arrays;

public class BookingReceiptDemo {
    public static class BookingReceipt {
        private final String bookingId;
        private final String[] seatNumbers;

        public BookingReceipt(String bookingId, String[] seatNumbers) {
            this.bookingId = bookingId;
            this.seatNumbers = (seatNumbers != null) ? seatNumbers.clone() : new String[0];
        }

        public String getBookingId() {
            return bookingId;
        }

        public String[] getSeatNumbers() {
            return seatNumbers.clone();
        }

        public BookingReceipt withUpdatedSeat(int index, String newSeat) {
            String[] updatedSeats = seatNumbers.clone();
            if (index >= 0 && index < updatedSeats.length) {
                updatedSeats[index] = newSeat;
            }
            return new BookingReceipt(bookingId, updatedSeats);
        }
    }

    public static class GroupBookingReceipt extends BookingReceipt {
        private final int groupSize;

        public GroupBookingReceipt(String bookingId, String[] seatNumbers, int groupSize) {
            super(bookingId, seatNumbers);
            this.groupSize = groupSize;
        }

        public int getGroupSize() {
            return groupSize;
        }
    }

    public static String processNightlySettlement(BookingReceipt[] receipts) {
        int processed = 0, nullSkipped = 0, groupCount = 0, individualCount = 0;
        if (receipts != null) {
            for (BookingReceipt r : receipts) {
                if (r == null) {
                    nullSkipped++;
                } else {
                    processed++;
                    if (r instanceof GroupBookingReceipt) {
                        groupCount++;
                    } else {
                        individualCount++;
                    }
                }
            }
        }
        return processed + " processed | " + nullSkipped + " null skipped | " + groupCount + " group | " + individualCount + " individual";
    }

    public static void main(String[] args) {
        BookingReceipt b = new BookingReceipt("CH-1001", new String[]{"A1", "A2"});
        String[] seats = b.getSeatNumbers();
        seats[0] = "X";
        System.out.println(b.getSeatNumbers()[0]);

        BookingReceipt updated = b.withUpdatedSeat(1, "A3");
        System.out.println(Arrays.toString(b.getSeatNumbers()));
        System.out.println(Arrays.toString(updated.getSeatNumbers()));

        BookingReceipt[] batch = new BookingReceipt[] {
            new GroupBookingReceipt("CH-2002", new String[]{"B1", "B2"}, 2),
            null,
            new BookingReceipt("CH-3003", new String[]{"C1"})
        };
        System.out.println(processNightlySettlement(batch));
    }
}
