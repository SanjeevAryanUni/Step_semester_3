package week5.assigment_problems;

import java.util.Arrays;

public class LoanReceiptDemo {
    public static final class LoanReceipt {
        private final String memberId;
        private final String[] bookIds;

        public LoanReceipt(String memberId, String[] bookIds) {
            this.memberId = memberId;
            this.bookIds = (bookIds != null) ? bookIds.clone() : new String[0];
        }

        public String getMemberId() {
            return memberId;
        }

        public String[] getBookIds() {
            return bookIds.clone();
        }

        public LoanReceipt withCorrectedBookId(int index, String newId) {
            String[] updated = bookIds.clone();
            if (index >= 0 && index < updated.length) {
                updated[index] = newId;
            }
            return new LoanReceipt(memberId, updated);
        }
    }

    public static class ReferenceOnlyLoanReceipt extends LoanReceipt {
        private final String roomNumber;

        public ReferenceOnlyLoanReceipt(String memberId, String[] bookIds, String roomNumber) {
            super(memberId, bookIds);
            this.roomNumber = roomNumber;
        }

        public String getRoomNumber() {
            return roomNumber;
        }
    }

    public static class CirculationLedger {
        static String branchCode;
        static {
            branchCode = "CENTRAL-REF";
        }

        public static String processNightlyCirculation(LoanReceipt[] receipts) {
            int processed = 0, nullSkipped = 0, refOnlyCount = 0, regularCount = 0;
            if (receipts != null) {
                for (LoanReceipt r : receipts) {
                    if (r == null) {
                        nullSkipped++;
                    } else {
                        processed++;
                        if (r instanceof ReferenceOnlyLoanReceipt) {
                            refOnlyCount++;
                        } else {
                            regularCount++;
                        }
                    }
                }
            }
            return processed + " processed | " + nullSkipped + " null skipped | " + refOnlyCount + " reference-only | " + regularCount + " regular";
        }
    }

    public static void main(String[] args) {
        LoanReceipt r = new LoanReceipt("LIB-8841", new String[]{"BK-100", "BK-101"});
        String[] ids = r.getBookIds();
        ids[0] = "HACKED";
        System.out.println(r.getBookIds()[0]);

        LoanReceipt corrected = r.withCorrectedBookId(1, "BK-102");
        System.out.println(Arrays.toString(r.getBookIds()));
        System.out.println(Arrays.toString(corrected.getBookIds()));

        LoanReceipt[] batch = new LoanReceipt[] {
            new ReferenceOnlyLoanReceipt("LIB-001", new String[]{"BK-200"}, "Reading Room 3"),
            null,
            new LoanReceipt("LIB-002", new String[]{"BK-201"})
        };
        System.out.println(CirculationLedger.processNightlyCirculation(batch));
    }
}
