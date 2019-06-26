package creditcardapp;

public class Driver {

	public static void main(String[] args) throws CloneNotSupportedException {
		Account account = new Account();
		account.makeCustomCard();
		account.dayAction();
	}

}
