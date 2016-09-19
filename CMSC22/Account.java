/**
*
* Created by jcpatac on 9/16/16.
*
**/

public class Account {
	private int accountNumber;
	private double balance = 0.0;

	public Account(int accountNumber, double balance) {
		this.accountNumber = accountNumber;
		this.balance = balance;
	}

	public Account(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public void credit(double amount) {
		this.balance += amount;
	}

	public void debit(double amount) {
		if (amount <= this.balance) {
			this.balance -= amount;
		}else {
			System.out.println("Amount withdrawn exceeds the current balance!");
		}
	}

	public String toString() {
		String accntNumber = String.format("%d", this.accountNumber);
		String accntBalance = String.format("%.2f", this.balance);
		String account = "A/C no: " + accntNumber + ", " + "Balance = " + accntBalance;
		return account;
	}
}

/**
*
* There are two ways to write error-free programs; only the third one works. – Alan J. Perlis
*
**/
