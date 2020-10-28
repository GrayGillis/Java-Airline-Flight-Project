// Describes a departure or an arrival information 
// of a flight including a city, time, and date.

public class Schedule {
	private String city;
	private String time;
	private String date;
	
	public Schedule(){//Constructor method to initialize instance variables
		city = new String("?");
		time= new String("?");
		date = new String("?");
	}
	
	public String getCity(){//returns the city of departure or arrival
		return city;
	}
	
	public String getTime(){//returns the time of departure or arrival
		return time;
	}
	
	public String getDate(){//returns a date of departure or arrival
		return date;
	}
	
	public void setCity(String place){//sets the city of departure or arrival
		city = place;
	}
	
	public void setTime(String someTime){//sets the time of departure or arrival
		time = someTime;
	}
	
	public void setDate(String someDate){//sets the date of departure or arrival
		date = someDate;
	}
	
	public String toString(){//returns the string of the city, date, and time
		String result;
		result = city + ", " + date + ", " + time;
		return result;
	}
}