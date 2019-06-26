package creditcardapp;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

import javax.swing.JOptionPane;
/*
 * 
 * Example:
 * 
 * 
 * 
 * 
 */


public class CreditCard {
	private double apr; //decimal form
	private double creditLimit;
	private double outstandingBalance;
	private double interestToAdd;
	private Date openingDate;
	private int dayCount;
	private String cardNumber;
	
	
	private ArrayList<CreditCharge> charges;
	private ArrayList<CreditPayment> payments;
	
	
	public CreditCard() {
		//default credit card
		charges = new ArrayList<CreditCharge>();
		payments = new ArrayList<CreditPayment>();
		apr = .35;
		setCreditLimit(1000);
		outstandingBalance=0;
		interestToAdd=0;
		
	}
	
	public CreditCard(double apr, double creditLimit) {
		charges = new ArrayList<CreditCharge>();
		payments = new ArrayList<CreditPayment>();
		this.apr = apr;
		this.setCreditLimit(creditLimit);
		outstandingBalance=0;
		interestToAdd=0;
		this.setOpeningDate(new Date());
	}
	
	public CreditCard(
					double apr, 
					double creditLimit, 
					Date openingDate,
					String cardNumber) throws CloneNotSupportedException {
		this.apr = apr;
		this.setCreditLimit(creditLimit);
		this.outstandingBalance = 0;
		this.interestToAdd = 0;
		this.setOpeningDate(openingDate.clone());
		this.dayCount = 0;
		this.setCardNumber(cardNumber);
		this.charges = new ArrayList<CreditCharge>();
		this.payments = new ArrayList<CreditPayment>();
	}

	public void addCharge (Date date, double amount) throws CloneNotSupportedException {
		if (this.getCreditLimit()>(this.getOutstandingBalance()+amount-0.01)) {
			CreditCharge charge = new CreditCharge(date, amount);
			charges.add(charge);
			this.outstandingBalance += amount;
		}
		else JOptionPane.showMessageDialog(null, "You've reached your credit limit");
	}
	
	public void addPayment(Date date, double amount) throws CloneNotSupportedException {
		if (this.getOutstandingBalance()>=amount) {
			CreditPayment payment = new CreditPayment(date, amount);
			payments.add(payment);
			this.outstandingBalance -= amount;
		}
		else JOptionPane.showMessageDialog(null, "You cannot pay more than you owe");
	}
	
	public void dayTick() {
		dayCount++;
		accrueInterest();
		if (dayCount == 30) {
			compoundInterest();
			dayCount = 0;
		}
	}
	
	public double getOutstandingBalance() {
		return outstandingBalance;
	}
	
	public String printOutstandingBalance() {
		return displayDollar(outstandingBalance);
	}
	
	public void accrueInterest() {
		interestToAdd = outstandingBalance * (apr/365) + interestToAdd;	
	}
	
	public void compoundInterest() {
		outstandingBalance = outstandingBalance + interestToAdd;
		interestToAdd = 0;
	}
	
	public String displayDollar (double amount) {
		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		return formatter.format(amount);
	}
	
	public String displayNeat (double value) {
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format(value);
	}

	public String printCharges() {
		String result = "";
		for (CreditCharge charge : this.charges) {
			result += charge.printCharge() + "\n";
		}
		return result;
	}
	
	public String printPayments() {
		String result = "";
		for (CreditPayment payment : this.payments) {
			result += payment.printPayment() + "\n";
		}
		return result;
	}

	public double getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(double creditLimit) {
		this.creditLimit = creditLimit;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public Date getOpeningDate() {
		return openingDate;
	}

	public void setOpeningDate(Date openingDate) {
		this.openingDate = openingDate;
	}

	


	
}
