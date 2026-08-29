package week4.class_problems;

public class AccountBatchPayments {
    public static class FeeAccount {
        public void pay(double amount) {
            System.out.println("Paid in one go (day-scholar account)");
        }
    }

    public static class HostelFeeAccount extends FeeAccount {
        @Override
        public void pay(double amount) {
            System.out.println("Paid in two installments (hostel account)");
        }
    }

    public static void processPayment(FeeAccount account, double amount) {
        account.pay(amount);
    }

    public static void main(String[] args) {
        FeeAccount[] accounts = new FeeAccount[] {
            new HostelFeeAccount(),
            new HostelFeeAccount(),
            new FeeAccount(),
            new FeeAccount()
        };

        int hostelCount = 0, dayScholarCount = 0;
        for (FeeAccount acc : accounts) {
            processPayment(acc, 60000);
            if (acc instanceof HostelFeeAccount) {
                hostelCount++;
            } else {
                dayScholarCount++;
            }
        }

        System.out.println("Hostel accounts processed: " + hostelCount + " | Day-scholar accounts processed: " + dayScholarCount);
    }
}
