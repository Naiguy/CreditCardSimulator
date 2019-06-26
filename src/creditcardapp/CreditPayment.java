package creditcardapp;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class CreditPayment {
	private double amount;
	private Date date;
	
	public CreditPayment(Date date, double amount) throws CloneNotSupportedException {
		this.amount = amount;
		this.date = date.clone();
	}
	
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	public String printPayment() {
		String result = "Date: " + this.date.getDate() + 
				" | Amount: " + displayDollar(this.getAmount());
		return result;
	}
	
	
	public String displayDollar (double amount) {
		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		return formatter.format(amount);
	}
	
	public String displayNeat (double value) {
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format(value);
		
	}

}
