package week4.assigment_problems;

public class CanteenPaymentDispatch {
    public static class Payment {
        public double pay(double amount) {
            System.out.println("Paid (cash): Rs " + amount);
            return amount;
        }
    }

    public static class CardPayment extends Payment {
        public double payWithProcessingFee(double amount) {
            double total = amount * 1.02;
            System.out.println("Charged (card, incl. fee): Rs " + String.format("%.1f", total));
            return total;
        }
    }

    public static double processTransaction(Payment payment, double amount) {
        if (payment instanceof CardPayment) {
            return ((CardPayment) payment).payWithProcessingFee(amount);
        } else {
            return payment.pay(amount);
        }
    }

    public static void main(String[] args) {
        Payment[] payments = new Payment[] {
            new CardPayment(),
            new Payment(),
            new CardPayment(),
            new Payment(),
            new CardPayment()
        };
        double[] amounts = {100, 50, 200, 75, 120};

        double totalCollected = 0;
        for (int i = 0; i < payments.length; i++) {
            totalCollected += processTransaction(payments[i], amounts[i]);
        }
        System.out.println("Total Collected: Rs " + String.format("%.1f", totalCollected));
    }
}
