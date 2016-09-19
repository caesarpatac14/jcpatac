/**
*
* Created by jcpatac on 9/16/16.
*
**/

public class AccountTester {
	public static void main(String[] args) {
		//Test constructor and toString()
		Account accnt1 = new Account(1234, 1.0); // construct account with account number and balance(1.0)
		Account accnt2 = new Account(5678); // construct account wuth account number; balance is (0.0)

		System.out.println(accnt1); // print account 1 (Balance must be 1.00)
		System.out.println(accnt2); // print account 2 (Balance must be 0.00)

		//Test setters and getters

		accnt1.setBalance(90.00); // set the balance of account 1 to 90.00
		accnt2.setBalance(100.10); // set the balance of account 2 to 100.10

		System.out.println("\nset balance");
		System.out.println(accnt1); // print account 1 (Balance must be 90.00)
		System.out.println(accnt2); // print account 2 (Balance must be 100.10)

		String accnt1Format = String.format("%.2f", accnt1.getBalance());
		String accnt2Format = String.format("%.2f", accnt2.getBalance());
		System.out.println("Balance is: " + accnt1Format); // Balance must be 90.00
		System.out.println("Balance is: " + accnt2Format); // Balance must be 100.10

		//test credit

		accnt1.credit(100.0); // add 100.0 to current balance of account 1
		accnt2.credit(100.0); // add 100.0 to current balance of account 2

		System.out.println("\ncredit 100.00");
		System.out.println(accnt1); // print account 1 (Balance must be 190.00)
		System.out.println(accnt2); // print account 2 (Balance must be 200.10)

		//test debit

		accnt1.debit(50.00); // subtract 50.00 to current balance of account 1
		accnt2.debit(50.00); // subtract 50.10 to current balance of account 2

		System.out.println("\ndebit 50.00");
		System.out.println(accnt1); // print account 1 (Balance must be 140.00)
		System.out.println(accnt2); // print account 2 (Balance must be 150.00)
	}
}

/**
*
* There are two ways to write error-free programs; only the third one works. – Alan J. Perlis
*
**/
