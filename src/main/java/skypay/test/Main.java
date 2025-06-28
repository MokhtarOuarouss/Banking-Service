package skypay.test;


import skypay.test.account.Account;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Account account = new Account();

        account.deposit(1000);
        account.deposit(2000);
        account.withdraw(500);
        account.withdraw(1000);

        account.printStatement();
    }
}