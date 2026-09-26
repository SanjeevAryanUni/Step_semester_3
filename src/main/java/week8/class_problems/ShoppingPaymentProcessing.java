package week8.class_problems;

import java.util.*;

public class ShoppingPaymentProcessing {
    public interface PaymentMethod {
        boolean processPayment(double amount);
        String getMethodName();
    }

    public static class CreditCardPayment implements PaymentMethod {
        @Override
        public boolean processPayment(double amount) {
            return true;
        }
        @Override
        public String getMethodName() { return "Credit Card"; }
    }

    public static class PayPalPayment implements PaymentMethod {
        private boolean shouldSucceed;
        public PayPalPayment(boolean shouldSucceed) { this.shouldSucceed = shouldSucceed; }
        @Override
        public boolean processPayment(double amount) {
            return shouldSucceed;
        }
        @Override
        public String getMethodName() { return "PayPal"; }
    }

    public static class BankTransferPayment implements PaymentMethod {
        @Override
        public boolean processPayment(double amount) { return true; }
        @Override
        public String getMethodName() { return "Bank Transfer"; }
    }

    public static class Product {
        private String name;
        private double price;
        public Product(String name, double price) { this.name = name; this.price = price; }
        public String getName() { return name; }
        public double getPrice() { return price; }
    }

    public static class Customer {
        private String name;
        public Customer(String name) { this.name = name; }
        public String getName() { return name; }
    }

    public enum OrderStatus {
        PENDING, PAID
    }

    public static class Order {
        private Customer customer;
        private Map<Product, Integer> items = new HashMap<>();
        private OrderStatus status;

        public Order(Customer customer) {
            this.customer = customer;
            this.status = OrderStatus.PENDING;
            System.out.println("Order created for " + customer.getName() + ".");
        }

        public void addProduct(Product p, int qty) {
            items.put(p, items.getOrDefault(p, 0) + qty);
        }

        public double calculateTotal() {
            double total = 0;
            for (Map.Entry<Product, Integer> entry : items.entrySet()) {
                total += entry.getKey().getPrice() * entry.getValue();
            }
            return total;
        }

        public boolean pay(PaymentMethod method) {
            if (items.isEmpty()) {
                System.out.println("Cannot process payment for an empty order.");
                return false;
            }
            System.out.println("Payment initiated via " + method.getMethodName() + " for Order " + customer.getName().substring(customer.getName().length() - 1) + ".");
            boolean success = method.processPayment(calculateTotal());
            if (success) {
                this.status = OrderStatus.PAID;
                System.out.println("Payment for Order " + customer.getName().substring(customer.getName().length() - 1) + " successful. Order status: Paid.");
                return true;
            } else {
                System.out.println("Payment for Order " + customer.getName().substring(customer.getName().length() - 1) + " failed. Order status: Pending.");
                return false;
            }
        }
    }

    public static void main(String[] args) {
        Customer x = new Customer("Customer X");
        Customer y = new Customer("Customer Y");
        Customer z = new Customer("Customer Z");

        Product a = new Product("Product A", 50.0);
        Product b = new Product("Product B", 30.0);
        Product c = new Product("Product C", 40.0);

        Order orderX = new Order(x);
        orderX.addProduct(a, 2);
        orderX.addProduct(b, 1);
        orderX.pay(new CreditCardPayment());

        Order orderY = new Order(y);
        orderY.pay(new CreditCardPayment());

        Order orderZ = new Order(z);
        orderZ.addProduct(c, 1);
        orderZ.pay(new PayPalPayment(false));
    }
}
