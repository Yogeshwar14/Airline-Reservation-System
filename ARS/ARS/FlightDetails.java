package ARS;

import java.util.List;

public class FlightDetails{
	public static int totalFlights;
	public static int flightID;
	public static String flightCode;
	public static String source;
	public static String destination;
	public static String date;
	public static String time;
	public static int capacity;
	public static int seats_booked;
	public static int available_seats;
	public static String status;
	public static int ID_flights[] = new int[50];
	public static String Code_flights[] = new String[50];
	public static String Source[] = new String[50];
	public static String Destination[] = new String[50];
	public static String Date[] = new String[50];
	public static String Time[] = new String[50];
	public static String uniqueSource[] = new String[20];
	public static String uniqueDestination[] = new String[20];
	public static String Status[] = new String[50];
	public static int Capacity[] = new int[50];
	public static int reserved_seats[] = new int[50];
	public static int Available_seats[] = new int[50];
	
	public static boolean isInternational = false;
	public static boolean isDomestic = false;
}