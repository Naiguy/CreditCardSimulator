package creditcardapp;

import javax.swing.JOptionPane;

public class CreditCardGenerator { //helper class
	
	CreditCardGenerator() {}
	
	
	public double promptValue(String message, double backup) {
		double result = backup;
		String input = JOptionPane.showInputDialog(message);
		try {
			result = Double.parseDouble(input);
			return result;
			}
		catch(Exception e) {
			System.out.println("error input. value set to " + backup);
			return result;
		}
	}
	
	public String generateCardNumber() {
		int gen = 0;
		int min = 0;
		int max = 9;
		String result = "";
		for (int i = 0; i<16;i++) {
		gen = (int)(Math.random()*((max-min)))+min;
		result = result + Integer.toString(gen);
		}
		return result;
	}

	public CreditCard generateCard(Date openDate) throws CloneNotSupportedException {
		double apr = promptValue("please input APR as %", 35) * .01;
		double limit = promptValue("please input $ Credit Limit", 3000);
		String cardNum = this.generateCardNumber();
		CreditCard card = new CreditCard(apr, limit, openDate, cardNum);
		return card;
	}
	
	public CreditCard autoGenerateCard(double apr, double limit, Date openDate) throws CloneNotSupportedException {
		System.out.println("apr = " + (apr*100) + "% , limit = " + limit);
		String cardNum = this.generateCardNumber();
		CreditCard card = new CreditCard(apr, limit, openDate, cardNum);
		return card;
	}

}
