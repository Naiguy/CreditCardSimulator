package creditcardapp;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Account {
	private ArrayList<CreditCard> cards = new ArrayList<CreditCard>();
	private String firstName = "Jane";
	private String lastName = "Doe";
	private Date currentDate = new Date();
	private CreditCardGenerator cardMaker = new CreditCardGenerator();
	
	//randomcomment
	
	public Account() {}
	
	public Date getCurrentDate() {
		return currentDate;
	}

	public void addCard(CreditCard card) {
		cards.add(card);
	}
	
	public void removeCard(CreditCard card) {
		cards.remove(card);
	}
	
	public void nextDay() {
		currentDate.nextDay();
		for (CreditCard card : this.cards) {
			card.dayTick();
		}
	}
	
	public void addDays(int days) {
		for (int i=0;i<days;i++) {
			this.nextDay();
		}	
	}
	
	public void chargePrimaryCard(double amount) throws CloneNotSupportedException {
		cards.get(0).addCharge(currentDate, amount);
	}
	
	public void payPrimaryCard(double amount) throws CloneNotSupportedException {
		cards.get(0).addPayment(currentDate, amount);
	}
	
	public String getBalanceDue() {
		return cards.get(0).printOutstandingBalance();
	}

	
	public String printPrimaryPayments() {
		return cards.get(0).printPayments();
	}
	
	public String printPrimaryCharges() {
		return cards.get(0).printCharges();
	}
	
	public void choosePrimaryCard(CreditCard card) {
		cards.remove(card);
		cards.add(card);
	}
	
	public void makeCustomCard() throws CloneNotSupportedException {
		cards.add(cardMaker.generateCard(currentDate));
	}
	
	public void makeScenarioCard() throws CloneNotSupportedException {
		cards.add(cardMaker.autoGenerateCard(.35, 1000, currentDate));
	}
	
	public void destroyCards() {
		cards.clear();
	}
	
	
	public void dayAction() throws CloneNotSupportedException {
		Object[] options = {"Quit",
							"Use Card",
							"Pay off Card", 
							"View Charges", 
							"View Payments",
							"Skip Ahead in Days",
							"Next Day"
							};
		int n = JOptionPane.showOptionDialog(null,
		            		"Hello, " + firstName + " " + lastName + ",\n" +
							"Please choose your action for " + 
		            		currentDate.getDate() + "\n" + 
		            		"Your current outstanding balance is " + 
		            		this.getBalanceDue(),
		            "ATM",
		            JOptionPane.YES_NO_CANCEL_OPTION,
		            JOptionPane.DEFAULT_OPTION,
		            null,
		            options,
		            options[6]); 
		
		if (n==0) {
			System.exit(0);
		}
		if (n==1) {
			useCard();
		}
		if (n==2) {
			payOffCard();
		}
		if (n==3) {
			viewCharges();
		}
		if (n==4) {
			viewPayments();
		}
		if (n==5) {
			skipAhead();
		}
		if (n==6) {
			nextDay();
			dayAction();
		}
	}
	
	public void useCard() throws CloneNotSupportedException {
		double amount = 0;
		try
        {
			amount = Double.parseDouble(JOptionPane.showInputDialog("How much are you spending?"));
			chargePrimaryCard(amount);
        } catch(NumberFormatException e) 
			{
            e.printStackTrace();
			}
		dayAction();
	}
	
	public void payOffCard() throws CloneNotSupportedException {
		double amount = 0;
		try
        {
			amount = Double.parseDouble(JOptionPane.showInputDialog("How much would you like to pay off?"));
			payPrimaryCard(amount);
        } catch(NumberFormatException e) 
			{
            e.printStackTrace();
			}
		dayAction();
	}
	
	public void viewCharges() throws CloneNotSupportedException {
		JOptionPane.showMessageDialog(null, printPrimaryCharges());
		dayAction();
	}
	
	public void viewPayments() throws CloneNotSupportedException {
		JOptionPane.showMessageDialog(null, printPrimaryPayments());
		dayAction();
	}
	
	public void skipAhead() throws CloneNotSupportedException {
		int days=1;
		try
        {
			days = Integer.parseInt(JOptionPane.showInputDialog("How many days would you like to traverse?"));
        } catch(NumberFormatException e) 
			{
            e.printStackTrace();
        	}
		this.addDays(days);
		dayAction();
	}
	
	
		
	
	
}
