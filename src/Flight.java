//Describes attributes in a flight and methods for each instance variables as well as toString method.
import java.text.NumberFormat;

public class Flight {
	private String airlines;
	private int flightNum;
	private Schedule departure;
	private Schedule arrival;
	private double airfare;

	public Flight(){//Constructor to initialize each instance variable
		airlines = new String("?");
	    flightNum = 0;
	    departure = new Schedule();
	    arrival = new Schedule();
	    airfare = 0.0;
	}

	public String getAirlines(){//returns the airlines name of a flight
		return airlines;
	}

	public int getFlightNum(){//returns the flight number of a flight
	    return flightNum;
	}

	public Schedule getDeparture(){//returns the departure schedule of a flight
	    return departure;
	}

	public Schedule getArrival(){//returns the arrival schedule of a flight
	    return arrival;
	}

	public double getAirfare(){//returns the price of a flight
	    return airfare;
	}

	public void setAirlines(String airlinesName){//sets the airlines name of a flight
	    airlines = airlinesName;
	}

	public void setFlightNum(int fNum){//sets the flight number of a flight
	    flightNum = fNum;
	}

	public void setDeparture(String someCity, String someDate, String someTime){//sets the departure schedule of a flight
	    departure.setCity(someCity);
	    departure.setDate(someDate);
	    departure.setTime(someTime);
	}

	public void setArrival(String someCity, String someDate, String someTime){//sets the arrival schedule of a flight
	    arrival.setCity(someCity);
	    arrival.setDate(someDate);
	    arrival.setTime(someTime);
	}

	public void setAirfare(double amount){//sets the price of a flight
	    airfare = amount;
	}

	public String toString(){//returns a string of the whole flight info
	    NumberFormat money = NumberFormat.getCurrencyInstance();
	    String result = "\nAirlines:\t" + airlines + "\n" +
	    		"Number:\t" + flightNum + "\n" +
	            "Departure:\t" + departure + "\n" +
	            "Arrival:\t" + arrival + "\n" +
	            "Airfare:\t" + money.format(airfare) + "\n";
	    result += "\n";
	    return result;
	}
}