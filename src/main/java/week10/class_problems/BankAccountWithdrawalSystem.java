package week10.class_problems;

import java.util.HashMap;
import java.util.Map;

public class BankAccountWithdrawalSystem {
    public static abstract class Account {
        protected String id;
        protected double balance;

        public Account(String id, double balance) {
            this.id = id;
            this.balance = balance;
        }

        public String getId() { return id; }
        public double getBalance() { return balance; }

        public abstract void withdraw(double amount);
    }

    public static class SavingsAccount extends Account {
        private static final double MIN_BALANCE = 1000.0;

        public SavingsAccount(String id, double balance) {
            super(id, balance);
        }

        @Override
        public void withdraw(double amount) {
            if (balance - amount < MIN_BALANCE) {
                System.out.printf("%s rejected: minimum balance %.0f%n", id, MIN_BALANCE);
            } else {
                balance -= amount;
                System.out.printf("%s balance %.0f%n", id, balance);
            }
        }
    }

    public static class CurrentAccount extends Account {
        private static final double OVERDRAFT_LIMIT = 5000.0;

        public CurrentAccount(String id, double balance) {
            super(id, balance);
        }

        @Override
        public void withdraw(double amount) {
            if (balance - amount < -OVERDRAFT_LIMIT) {
                System.out.printf("%s rejected: overdraft limit %.0f%n", id, OVERDRAFT_LIMIT);
            } else {
                balance -= amount;
                System.out.printf("%s balance %.0f%n", id, balance);
            }
        }
    }

    public static class Bank {
        private Map<String, Account> accounts = new HashMap<>();

        public void createSavings(String id, double initialBalance) {
            accounts.put(id, new SavingsAccount(id, initialBalance));
        }

        public void createCurrent(String id, double initialBalance) {
            accounts.put(id, new CurrentAccount(id, initialBalance));
        }

        public void withdraw(String id, double amount) {
            Account acc = accounts.get(id);
            if (acc == null) {
                System.out.println("Account not found");
                return;
            }
            acc.withdraw(amount);
        }
    }

    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.createSavings("S1", 5000);
        bank.withdraw("S1", 4500);
        bank.createCurrent("C1", 2000);
        bank.withdraw("C1", 6000);
        bank.withdraw("S1", 3000);
        bank.withdraw("C1", 2000);
    }
}
