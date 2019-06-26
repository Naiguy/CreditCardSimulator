package creditcardapp;

import javax.swing.JOptionPane;

public class Test {

	public static void main(String[] args) throws Exception {
		// Scenario1

		Account account = new Account();
		account.makeScenarioCard();
		account.chargePrimaryCard(500);
		JOptionPane.showMessageDialog(null, "Scenario 1: charge added: " + 500);
		account.addDays(30);
		JOptionPane.showMessageDialog(null,"On " + account.getCurrentDate().getDate() + ", your balance due is: " + account.getBalanceDue());
		/***********************************************************/
		account.destroyCards();
		account.makeScenarioCard();
		account.chargePrimaryCard(500);
		JOptionPane.showMessageDialog(null, "it is " + account.getCurrentDate().getDate());
		JOptionPane.showMessageDialog(null, "Scenario 2: charge added: 500");
		account.addDays(15);
		JOptionPane.showMessageDialog(null, "it is " + account.getCurrentDate().getDate());
		account.payPrimaryCard(200);
		JOptionPane.showMessageDialog(null, "payment added: 200");
		account.addDays(10);
		JOptionPane.showMessageDialog(null, "it is " + account.getCurrentDate().getDate());
		account.chargePrimaryCard(100);
		JOptionPane.showMessageDialog(null, "charge added: 100");
		account.addDays(5);
		JOptionPane.showMessageDialog(null,"On " + account.getCurrentDate().getDate() + ", your balance due is: " + account.getBalanceDue());
		/*
		 * Original Scenario 2:
		 * 
		 * A customer opens a credit card with a $1,000.00 limit at a 35% APR.
		 * The customer charges $500 on opening day (outstanding balance becomes $500).
		 * 15 days after opening, the customer pays $200 (outstanding balance becomes $300).
		 * 25 days after opening, the customer charges another $100 (outstanding balance becomes $400).
		 * The total outstanding balance owed 30 days after opening should be $411.99.
		 * (500 * 0.35 / 365 * 15) + (300 * 0.35 / 365 * 10) + (400 * 0.35 / 365 * 5) = 11.99
		 * 
		 * Addressed Issues:
		 * One line asks for 30 days after
		 * The total days asked for is 40 (15+25).
		 * The math at the bottom states 15 days after the first charge, 
		 * 10 days after payment, and 5 days after last charge.
		 * 
		 * To simplify, I used the 30 day total of 15,10,5.
		 * 
		 */
		
		

	}

}
