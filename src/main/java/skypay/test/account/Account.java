package skypay.test.account;

import skypay.test.exception.InsufficientFundsException;
import skypay.test.exception.InvalidAmountException;
import java.util.ArrayList;

public class Account implements AccountService {

    private ArrayList<Transaction> transactions = new ArrayList<>();
    private int balance = 0;

    @Override
    public void deposit(int amount) {
        try {
            if (amount <= 0) {
                throw new InvalidAmountException("The deposit amount must be greater than zero");
            }
            balance += amount;
            transactions.add(new Transaction("Deposit", amount));
        } catch (InvalidAmountException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void withdraw(int amount) {
        try {
            if (amount <= 0) {
                throw new InvalidAmountException("Withdrawal amount must be greater than zero");
            }
            if (amount > balance) {
                throw new InsufficientFundsException("There are not enough funds to complete the withdrawal.");
            }
            balance -= amount;
            transactions.add(new Transaction("Withdrawal", amount));
        } catch (InvalidAmountException | InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void printStatement() {
        int currentBalance = 0;

        System.out.println("Date | Transaction | Amount | Balance");
        for (Transaction transaction : transactions) {
            currentBalance = currentBalance + (transaction.getType().equals("Deposit") ? transaction.getAmount() : - transaction.getAmount());
            System.out.println(transaction.getTransactionDetails(currentBalance));
        }
    }
}
