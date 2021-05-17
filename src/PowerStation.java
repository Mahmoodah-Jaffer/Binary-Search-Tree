/**
Store datetime, voltage and power in an object called PowerStation
@author Mahmoodah Jaffer - JFFMAH001
@since 25 February 2019
*/
public class PowerStation{

/**
PowerStation class takes in given datetime, power and voltage and stores it so that it can be used as an object
*/

	private String datetime;
	private String power;
	private String voltage;

	public PowerStation(String dt, String p, String v){
	/**
	Method PowerStation class takes in given datetime, power and voltage
	@para dt String
	@para p String
	@para v String
	@Returns none
	*/
		this.datetime = dt;
		this.power = p;
		this.voltage = v; 
	}

	public String getDateTime(){
	/**
	Method getDateTime returns datetime
	@para none
	@Returns String datetime
	*/
		return datetime;
	}

	public String getPower(){
	/**
	Method getPower returns power
	@para none
	@Returns String power
	*/
		return power;
	}

	public String getVoltage(){
	/**
	Method getVoltage returns voltage
	@para none
	@Returns String voltage
	*/
		return voltage;
	}

	public String toString(){
	/**
	Method toString converts PowerStation Class to string
	@para none
	@Returns String 
	*/
		return "Date/time: " + datetime + " Power: " + power + " Voltage: " + voltage;
	}

}