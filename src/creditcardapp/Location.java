package creditcardapp;

public class Location {
	
	private String country = "United States";
	private String state = "Illinois";
	private String city = "Chicago";
	private String zip = "60613";
	

	public Location(String country, String state, String city, String zip) {
		this.country = country;
		this.state = state;
		this.city = city;
		this.zip = zip;
	}
	
	public Location()
	{
		country = "United States";
		state = "Illinois";
		city = "Chicago";
		zip = "60613";
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZIP() {
		return zip;
	}

	public void setZIP(String zip) {
		this.zip = zip;
	}
	
	public String getLocation() {
		String result = city + ", " + state + " " + country + ", " + zip;
		return result;
	}
	
}
