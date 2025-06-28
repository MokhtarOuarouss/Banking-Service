package skypay.test.account;

import java.time.LocalDate;

public class Transaction {
    private String type;
    private int amount;
    private LocalDate date;

    public Transaction(String type, int amount) {
        this.type = type;
        this.amount = amount;
        this.date = LocalDate.now();
    }

    public String getType() {
        return type;
    }

    public int getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getTransactionDetails(int balance) {
        String amountFormatted = type.equals("Withdrawal") ? "-" + amount : "+" + amount;
        return String.format("%s || Amount: %s || Balance: %d", date.toString(), amountFormatted, balance);
    }
}
