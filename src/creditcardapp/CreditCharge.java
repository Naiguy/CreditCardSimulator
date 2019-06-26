package creditcardapp;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class CreditCharge {
	private Date chargeDate;
	private Location location;
	private double amount;
	
	public CreditCharge(Date date, Location location, double amount) {
		this.chargeDate = date;
		this.location = location;
		this.amount = amount;
	}
	
	public CreditCharge(Date date, double amount) throws CloneNotSupportedException {
		this.chargeDate = date.clone();
		this.location = new Location();
		this.amount = amount;
		System.out.println("Current date for charge:" + chargeDate.getDate());
	}
	
	public Date getChargeDate() {
		return chargeDate;
	}
	public void setChargeDate(Date date) {
		this.chargeDate = date;
	}

	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public String printCharge() {
	
		String result = "Date: " + this.chargeDate.getDate() + 
				" | Location: " + this.location.getLocation() +
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
