package ARS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Operations {
	//private static final char[] resultset = null;

	public boolean isLogin(String username, String password, Loginpage loginpage) {
		try {
			Connection myConn = MysqlConnection.getconnection();
			String mySQLquerry = 
					"SELECT idLogin , Username FROM logininfo WHERE Username = '"+
							username+
							"'AND Password ='"+
							password+"'";
			PreparedStatement preparedstatement = myConn.prepareStatement(mySQLquerry);
			ResultSet resultset = preparedstatement.executeQuery();
			
			while(resultset.next()) {
				LoginSession.ID = resultset.getInt("idLogin");
				LoginSession.name = resultset.getString("Username");
				return true;
			}
		
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(loginpage, "Database Login Error : "+ e.getMessage());
		}
		return false;
	}
	
	public boolean Register(String username,String email , String password, Loginpage loginpage) {
		
		try {
			Connection myConn2 = MysqlConnection.getconnection();
			String mySQLquerry2 = "insert into logininfo(Username,email,Password) values('"+username+"','"+email+"','"+password+"')";
			
			PreparedStatement preparedstatement = myConn2.prepareStatement(mySQLquerry2);
			int i = preparedstatement.executeUpdate();
			
			if(i!=0)
			{
				System.out.println(i);
				LoginSession.name = username;
				return true;
			}
			
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(loginpage,"Database Register Error : "+ e.getMessage() );
		}
		
		return false;
	}
	
	public boolean isAdmin(String UID, String password,Admin admin) {
		try {
			Connection myConn3 = MysqlConnection.getconnection();
			
			String mySQLquerry3 = 
					"SELECT idAdmin , adminName FROM admininfo WHERE AdminKey = '"+
							UID+
							"'AND adminPassword ='"+
							password+"'";
			PreparedStatement preparedstatement = myConn3.prepareStatement(mySQLquerry3);
			ResultSet resultset = preparedstatement.executeQuery();
			
			while(resultset.next()) {
				LoginSession.ID = resultset.getInt("idAdmin");
				LoginSession.name = resultset.getString("adminName");
				LoginSession.isAdmin = true;
				return true;
			}
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(admin, "Database Error : "+ e.getMessage());
		}
		return false;
	}
	
	public boolean userList(AdminOption admopt)
	{
		try {
			Connection myConn = MysqlConnection.getconnection();
			
			String mySQLquerry = 
					"SELECT idLogin , Username,email FROM logininfo ";
			PreparedStatement preparedstatement = myConn.prepareStatement(mySQLquerry);
			ResultSet resultset = preparedstatement.executeQuery();
			
			int i=0;
			while(resultset.next()) {
				AdminResponce.ID[i] = resultset.getInt("idLogin");
				AdminResponce.Users[i] = resultset.getString("Username");
				AdminResponce.Email[i] = resultset.getString("email");
				//System.out.println(AdminResponce.ID[i] + " " + AdminResponce.Users[i]);
				i+=1;
				AdminResponce.totalUsers = i;
			}
			return true;
			
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(admopt, "Database Error : "+ e.getMessage());
		}
		return false;	
	}
	
	public boolean reportQuerry(String username, String report , ReportQuerry qry)
	{
		try {
			Connection myconn5 = MysqlConnection.getconnection();
			
			String mySQLquerry5 = "insert into reports(user,Report_Querry) values('"+username+"','"+report+"')";
			
			PreparedStatement preparedstatement = myconn5.prepareStatement(mySQLquerry5);
			int i = preparedstatement.executeUpdate();
			
			if(i!=0)
			{
				JOptionPane.showMessageDialog(qry, "Thank you for reporting! Developers will shortly look into this matter.");
				return true;
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(qry, "Database Error : "+ e.getMessage());
		}
		
		
		return false;
	}
	
	public boolean getQuerry(AdminOption admopt)
	{
		try {
			
			Connection myConn = MysqlConnection.getconnection();
			
			String mySQLquerry = 
					"SELECT idReport, user,Report_Querry FROM reports ";
			PreparedStatement preparedstatement = myConn.prepareStatement(mySQLquerry);
			ResultSet resultset = preparedstatement.executeQuery();
			
			int i=0;
			while(resultset.next()) {
				AdminResponce.ID[i] = resultset.getInt("idReport");
				AdminResponce.Users[i] = resultset.getString("user");
				AdminResponce.querry[i] = resultset.getString("Report_Querry");
				//System.out.println(AdminResponce.ID[i] + " " + AdminResponce.Users[i]);
				i+=1;
				AdminResponce.totalUsers = i;
			}
			return true;
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(admopt, "Database Error : "+ e.getMessage());
		}
		return false;
	}
	
	public boolean addFlight(String from, String to, String date, String time,int capacity,String status ,AdminOption admopt)
	{
		try 
		{
			int seats = 0; 
			String flightID = "FL"+from.charAt(0)+to.charAt(0)+date.substring(0, 2)+time.substring(0, 2)+"T";
			Connection myConn2 = MysqlConnection.getconnection();
			String mySQLquerry2 = "insert into flights(Flight_code,Source,Destination,Date,Time,Capacity,Reserved_Seats,Seats_Available,status) values('"
			+flightID+"','"+from+"','"+to+"','"+date+"','"+time+"','"+capacity+"','"+seats+"','"+capacity+"','"+status+"')";
			
			PreparedStatement preparedstatement = myConn2.prepareStatement(mySQLquerry2);
			int i = preparedstatement.executeUpdate();
			
			if(i!=0)
			{
				JOptionPane.showMessageDialog(admopt,"Flight Added Successfully");
				return true;
			}
			
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(admopt,"Database Error : "+ e.getMessage() );
		}
		return false;
	}
	
	public boolean getFlightDetails(AdminOption admopt)
	{
		try
		{
			Connection myconn6 = MysqlConnection.getconnection();
			String mySQLquerry = 
					"SELECT idFlight,Flight_code,Source,Destination,Date,Time,status,Seats_Available,Capacity,Reserved_Seats FROM flights ";
			PreparedStatement preparedstatement = myconn6.prepareStatement(mySQLquerry);
			ResultSet resultset = preparedstatement.executeQuery();
			int i=0;
			while(resultset.next()) {
				FlightDetails.ID_flights[i] = resultset.getInt("idFlight");
				FlightDetails.Code_flights[i] = resultset.getString("Flight_code");
				FlightDetails.Source[i] = resultset.getString("Source");
				FlightDetails.Destination[i] = resultset.getString("Destination");
				FlightDetails.Date[i] = resultset.getString("Date");
				FlightDetails.Time[i] = resultset.getString("Time");
				FlightDetails.Status[i] = resultset.getString("status");
				FlightDetails.Available_seats[i] = (int)Integer.valueOf(resultset.getString("Seats_Available"));
				FlightDetails.reserved_seats[i] = (int)Integer.valueOf(resultset.getString("Reserved_Seats"));
				FlightDetails.Capacity[i] = (int)Integer.valueOf(resultset.getString("Capacity"));
				
				i+=1;
				FlightDetails.totalFlights = i;
			}
			return true;
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(admopt,"Database Error : "+ e.getMessage() );
		}
		
		return false;
	}
	
	public boolean getInternationalFlights(AdminOption admopt)
	{
		try
		{
			Connection myconn6 = MysqlConnection.getconnection();
			String mySQLquerry = 
					"SELECT idFlight,Flight_code,Source,Destination,Date,Time,status FROM flights WHERE status = 'International'";
			PreparedStatement preparedstatement = myconn6.prepareStatement(mySQLquerry);
			ResultSet resultset = preparedstatement.executeQuery();
			int i=0;
			while(resultset.next()) {
				FlightDetails.ID_flights[i] = resultset.getInt("idFlight");
				FlightDetails.Code_flights[i] = resultset.getString("Flight_code");
				FlightDetails.Source[i] = resultset.getString("Source");
				FlightDetails.Destination[i] = resultset.getString("Destination");
				FlightDetails.Date[i] = resultset.getString("Date");
				FlightDetails.Time[i] = resultset.getString("Time");
				FlightDetails.Status[i] = resultset.getString("status");
				
				i+=1;
				FlightDetails.totalFlights = i;
			}
			return true;
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(admopt,"Database Error : "+ e.getMessage() );
		}
		
		return false;
	}
	
	public boolean getDomesticFlights(AdminOption admopt)
	{
		try
		{
			Connection myconn6 = MysqlConnection.getconnection();
			String mySQLquerry = 
					"SELECT idFlight,Flight_code,Source,Destination,Date,Time,status FROM flights where status = 'Domestic'";
			PreparedStatement preparedstatement = myconn6.prepareStatement(mySQLquerry);
			ResultSet resultset = preparedstatement.executeQuery();
			int i=0;
			while(resultset.next()) {
				FlightDetails.ID_flights[i] = resultset.getInt("idFlight");
				FlightDetails.Code_flights[i] = resultset.getString("Flight_code");
				FlightDetails.Source[i] = resultset.getString("Source");
				FlightDetails.Destination[i] = resultset.getString("Destination");
				FlightDetails.Date[i] = resultset.getString("Date");
				FlightDetails.Time[i] = resultset.getString("Time");
				FlightDetails.Status[i] = resultset.getString("status");
				
				i+=1;
				FlightDetails.totalFlights = i;
			}
			return true;
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(admopt,"Database Error : "+ e.getMessage() );
		}
		
		return false;
	}
	
	public boolean findDomesticFlights(String from,String to, String date,bookTicket bktkt)
	{
		try
		{
			Connection myconn6 = MysqlConnection.getconnection();
			String mySQLquerry = 
					"SELECT idFlight,Flight_code,Source,Destination,Date,Time,status FROM flights where status = 'Domestic' AND Source = '"
							+from+"'AND Destination = '"+to+"'AND Date = '"+date+"' ";
			PreparedStatement preparedstatement = myconn6.prepareStatement(mySQLquerry);
			ResultSet resultset = preparedstatement.executeQuery();
			int i=0;
			while(resultset.next()) {
				FlightDetails.ID_flights[i] = resultset.getInt("idFlight");
				FlightDetails.Code_flights[i] = resultset.getString("Flight_code");
				FlightDetails.Source[i] = resultset.getString("Source");
				FlightDetails.Destination[i] = resultset.getString("Destination");
				FlightDetails.Date[i] = resultset.getString("Date");
				FlightDetails.Time[i] = resultset.getString("Time");
				FlightDetails.Status[i] = resultset.getString("status");
				
				i+=1;
				FlightDetails.totalFlights = i;
			}
			return true;
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(bktkt,"Database Error : "+ e.getMessage() );
		}
		
		return false;
	}
	
	public boolean findInternationalFlights(String from,String to, String date,bookTicket bktkt)
	{
		try
		{
			Connection myconn6 = MysqlConnection.getconnection();
			String mySQLquerry = 
					"SELECT idFlight,Flight_code,Source,Destination,Date,Time,status FROM flights where status = 'International' AND Source = '"
							+from+"' AND Destination = '"+to+"' AND Date = '"+date+"' ";
			PreparedStatement preparedstatement = myconn6.prepareStatement(mySQLquerry);
			ResultSet resultset = preparedstatement.executeQuery();
			int i=0;
			while(resultset.next()) {
				FlightDetails.ID_flights[i] = resultset.getInt("idFlight");
				FlightDetails.Code_flights[i] = resultset.getString("Flight_code");
				FlightDetails.Source[i] = resultset.getString("Source");
				FlightDetails.Destination[i] = resultset.getString("Destination");
				FlightDetails.Date[i] = resultset.getString("Date");
				FlightDetails.Time[i] = resultset.getString("Time");
				FlightDetails.Status[i] = resultset.getString("status");
				
				i+=1;
				FlightDetails.totalFlights = i;
			}
			return true;
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(bktkt,"Database Error : "+ e.getMessage() );
		}
		
		return false;
	}
	
	public boolean bookticket(String name,String email,String phone,String dob,String city, String country, String zip,String from,String to,String flightcode,String fdate,int seats,bookTicket bktkt) {
		try
		{
			int cancelled =0;
			int seatsAvailable=0;
			String ticketID = "Tk" + from.charAt(0) +to.charAt(0) + name.toLowerCase()+ String.valueOf(seats)+"T";
			Connection conn = MysqlConnection.getconnection() ;
			String mySQLquerry1 = "insert into users(Name,Email,Phone,DOB,City,Country,zipcode) values('"
					+name+"','"+email+"','"+phone+"','"+dob+"','"+city+"','"+country+"','"+zip+"')";
			
			String mySQLquerry2 = "insert into tickets(user,Ticket_Code,flightcode,bookingDate,FlightDate,source,destination,Seats,Cancelled) values ('"
						+LoginSession.name+"','"+ticketID+"','"+flightcode+"','"+java.time.LocalDate.now() +"','"+fdate+"','"+from+"','"+to+"','"+seats+"','"+cancelled+"')";
			
			String mySQLquerry3 = "SELECT * FROM flights where Flight_code = '"+flightcode+"'";
			
			
			PreparedStatement preparedstatement1 = conn.prepareStatement(mySQLquerry1);
			PreparedStatement preparedstatement2 = conn.prepareStatement(mySQLquerry2);
			PreparedStatement preparedstatement3 = conn.prepareStatement(mySQLquerry3);

			
			int i = preparedstatement1.executeUpdate();
			
			if(i!=0)
			{
				System.out.println("Personal Data Added Successfully!\n");
			}
			
			int j = preparedstatement2.executeUpdate();
			if(j!=0)
			{
				System.out.println("Ticket added!\n");
			}
			ResultSet resultset = preparedstatement3.executeQuery();
			while(resultset.next()) {
				/*FlightDetails.flightID = resultset.getInt("idFlight");
				FlightDetails.flightCode = resultset.getString("Flight_code");
				FlightDetails.source = resultset.getString("Source");
				FlightDetails.destination = resultset.getString("Destination");
				FlightDetails.date = resultset.getString("Date");
				FlightDetails.time = resultset.getString("Time");
				FlightDetails.status = resultset.getString("status");*/
				FlightDetails.capacity = resultset.getInt("Capacity");
				FlightDetails.available_seats = resultset.getInt("Seats_Available");
				FlightDetails.seats_booked = resultset.getInt("Reserved_Seats");
			}
			int reservedSeats = FlightDetails.seats_booked + seats;
			seatsAvailable = FlightDetails.capacity - reservedSeats;
			String mySQLquerry4 = "SELECT Capacity,Reserved_seats,Seats_Available FROM flights where Flight_code = '"+flightcode+"'";
			String mySQLquerry5 ="UPDATE flights SET Reserved_Seats = '"+reservedSeats+"', Seats_Available = '"+seatsAvailable+"' WHERE Flight_code = '"+flightcode+"'";
			PreparedStatement preparedstatement4 = conn.prepareStatement(mySQLquerry4);
			PreparedStatement preparedstatement5 = conn.prepareStatement(mySQLquerry5);
			ResultSet resultset2 = preparedstatement4.executeQuery();
			while(resultset2.next()) {
				System.out.println("Reserved: "+resultset2.getInt("Reserved_Seats")+"\nAvailable: "+resultset2.getInt("Seats_Available"));
			}
			
			int k =preparedstatement5.executeUpdate();
			if(k!=0)
			{
				System.out.println("Flight seats Updated!\n");
			}
			return true;
			
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(bktkt,"Database Error : "+ e.getMessage() );
		}
		return false;		
	}
	
	public boolean getReservations(AdminOption admopt)
	{
		try
		{
			int cancelled = 0;
			Connection myconn = MysqlConnection.getconnection();
			String mySQLquerry = 
					"SELECT * from tickets where cancelled = '"+cancelled+"'";
			PreparedStatement preparedstatement = myconn.prepareStatement(mySQLquerry);
			ResultSet resultset = preparedstatement.executeQuery();
			int i=0;
			while(resultset.next()) {
				Tickets.user[i] = resultset.getString("user");
				Tickets.flightDate[i] = resultset.getString("FlightDate");
				Tickets.flightCode[i] = resultset.getString("flightcode");
				Tickets.seats[i] = resultset.getInt("Seats");
				Tickets.ticket_code[i] = resultset.getString("Ticket_Code");
				
				i+=1;
				Tickets.totalTickets = i;
			}
			return true;
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(admopt,"Database Error : "+ e.getMessage() );
		}
		
		return false;
	}
	
	public boolean getTickets(Reservation resv)
	{
		try
		{
			Connection myconn = MysqlConnection.getconnection();
			String mySQLquerry = 
					"SELECT * from tickets where user = '"+LoginSession.name+"'";
			PreparedStatement preparedstatement = myconn.prepareStatement(mySQLquerry);
			ResultSet resultset = preparedstatement.executeQuery();
			int i=0;
			while(resultset.next()) {
				Tickets.user[i] = resultset.getString("user");
				Tickets.flightDate[i] = resultset.getString("FlightDate");
				Tickets.flightCode[i] = resultset.getString("flightcode");
				Tickets.from[i] = resultset.getString("source");
				Tickets.to[i] = resultset.getString("destination");
				Tickets.seats[i] = resultset.getInt("Seats");
				Tickets.bookingDate[i] = resultset.getString("bookingDate");
				Tickets.ticket_code[i] = resultset.getString("Ticket_Code");
				if(resultset.getInt("Cancelled")==1) {
					Tickets.status[i] = "CANCELLED";
				}else {
					Tickets.status[i] = "SCHEDULED";
				}
				i+=1;
				Tickets.totalTickets = i;
			}
			return true;
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(resv,"Database Error : "+ e.getMessage() );
		}
		return false;
	}
	
	public boolean cancelTicket(String user , String password , String ticketID , Reservation resv)
	{
		try
		{
			int cancelled = 1;
			int iscancel = 0;
			//Implicitly invoking current class method isLogin using 'this'
			if(this.isLogin(user, password, null))
			{
				int seats = 0;
				String flightID = null;
				Connection myConn = MysqlConnection.getconnection();
				String mySQLquerry2 = "UPDATE tickets SET Cancelled = "+ cancelled+ " where Ticket_Code = '"+ticketID+"' AND user = '"+user+"'";
				String mySQLquerry3 = "SELECT * FROM tickets where Ticket_Code = '"+ticketID+"' AND user = '"+user+"'";
				
				
				PreparedStatement preparedstatement2 = myConn.prepareStatement(mySQLquerry2);
				PreparedStatement preparedstatement3 = myConn.prepareStatement(mySQLquerry3);
				
				ResultSet resultset3 = preparedstatement3.executeQuery();
				while(resultset3.next()) {
					seats = resultset3.getInt("Seats");
					iscancel = resultset3.getInt("Cancelled");
					flightID = resultset3.getString("flightcode");
				}
				
				String mySQLquerry1 = "SELECT * FROM flights where Flight_code = '"+flightID+"'";
				PreparedStatement preparedstatement1 = myConn.prepareStatement(mySQLquerry1);
				ResultSet resultset01 = preparedstatement1.executeQuery();
				while(resultset01.next()) {
					FlightDetails.capacity = resultset01.getInt("Capacity");
					FlightDetails.available_seats = resultset01.getInt("Seats_Available");
					FlightDetails.seats_booked = resultset01.getInt("Reserved_Seats");
				}
				
				
				if(iscancel == 1) {
					JOptionPane.showMessageDialog(resv,"Already Cancelled!");
					return false;
				}
				
				int reservedSeats = FlightDetails.seats_booked - seats;
				int seatsAvailable = FlightDetails.capacity - reservedSeats;
				String mySQLquerry4 = "SELECT Capacity,Reserved_seats,Seats_Available FROM flights where Flight_code = '"+flightID+"'";
				String mySQLquerry5 ="UPDATE flights SET Reserved_Seats = '"+reservedSeats+"', Seats_Available = '"+seatsAvailable+"' WHERE Flight_code = '"+flightID+"'";
				PreparedStatement preparedstatement4 = myConn.prepareStatement(mySQLquerry4);
				PreparedStatement preparedstatement5 = myConn.prepareStatement(mySQLquerry5);
				ResultSet resultset4 = preparedstatement4.executeQuery();
				while(resultset4.next()) {
					System.out.println("Before Cancellation: "+resultset4.getInt("Reserved_Seats")+"\nAvailable: "+resultset4.getInt("Seats_Available"));
				}
				
				int k =preparedstatement5.executeUpdate();
				if(k!=0)
				{
					System.out.println("Flight seats Updated!\n");
				}
				
				
				int k1 = preparedstatement2.executeUpdate();
				if(k1!=0) {
					System.out.println("Ticket Cancelled!");
					return true;
				}
				
			}else {
				JOptionPane.showMessageDialog(resv,"Invalid Credentials!");
			}
			
			
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(resv,"Database Error : "+ e.getMessage() );
		}
		
		
		return false;
	}
	
	public boolean getCancelledTickets(AdminOption admopt)
	{
		try
		{
			int cancelled = 1;
			Connection myconn = MysqlConnection.getconnection();
			String mySQLquerry = 
					"SELECT * from tickets where Cancelled = "+cancelled +";";
			PreparedStatement preparedstatement = myconn.prepareStatement(mySQLquerry);
			ResultSet resultset = preparedstatement.executeQuery();
			int i=0;
			while(resultset.next()) {
				Tickets.user[i] = resultset.getString("user");
				Tickets.flightDate[i] = resultset.getString("FlightDate");
				Tickets.flightCode[i] = resultset.getString("flightcode");
				Tickets.seats[i] = resultset.getInt("Seats");
				Tickets.ticket_code[i] = resultset.getString("Ticket_Code");
				
				i+=1;
				Tickets.totalTickets = i;
			}
			return true;
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(admopt,"Database Error : "+ e.getMessage() );
		}
		
		return false;
	}
	
}
