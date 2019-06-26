package creditcardapp;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Date implements Cloneable{
	Calendar calendar = new GregorianCalendar();
	private int year;
	private int month;
	private int day;
	
	
	public Date(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	public Date() {
		year = calendar.get(Calendar.YEAR);
		month = calendar.get(Calendar.MONTH);
		day = calendar.get(Calendar.DAY_OF_MONTH);
	}
	
	public Date clone() throws CloneNotSupportedException { 
		return (Date) super.clone(); 
		}

	public void nextDay() {
		this.calendar.roll(Calendar.DAY_OF_MONTH, true);
		this.update();
	}
	
	public void update() {
		year = calendar.get(Calendar.YEAR);
		month = calendar.get(Calendar.MONTH);
		day = calendar.get(Calendar.DAY_OF_MONTH);
	}

	public String getDate() {
		String result = 
			String.format("%02d", month) + "/" + 
			String.format("%02d", day) + "/" + 
			String.format("%02d", year);  
		return result;
	}
	

}
