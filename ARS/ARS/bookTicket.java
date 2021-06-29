package ARS;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class bookTicket extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Label L, Fname,Email,Phone,DoB,City,Country,Zip,From,To,Date,seats,Flightcode;
	private TextField fname,email,phone,dob,city,country,zip,date , flightcode;
	private TextArea Flights;
	private Choice from,to,adults,children,infants;
	private Button submit, book;
	//public String l1[] = new String[20];
	public Boolean isIn = false;
	
	public bookTicket() {
		setLayout(new FlowLayout());
		
		L = new Label("Booking");
    	L.setBounds(0,30,840,40);
    	L.setAlignment(Label.CENTER);
    	L.setFont(new java.awt.Font("Arial",Font.BOLD,25));
    	L.setBackground(Color.lightGray);
		add(L);
		
		Fname = new Label("Full Name");
        Fname.setBounds(20,100,80,30);
        Fname.setFont(new java.awt.Font("Arial",Font.BOLD,15));
        add(Fname);

        fname = new TextField();
        fname.setBounds(150,100,250,30);
        fname.setFont(new java.awt.Font("Arial",Font.PLAIN,13));
        add(fname);
        
        Email = new Label("Email");
        Email.setBounds(20,145,80,30);
        Email.setFont(new java.awt.Font("Arial",Font.BOLD,15));
        add(Email);
        
        email = new TextField();
        email.setBounds(150,145,250,30);
        email.setFont(new java.awt.Font("Arial",Font.PLAIN,13));
        add(email);
        
        Phone = new Label("Phone No.");
        Phone.setBounds(20,190,80,30);
        Phone.setFont(new java.awt.Font("Arial",Font.BOLD,15));
        add(Phone);
        
        phone = new TextField();
        phone.setBounds(150,190,250,30);
        phone.setFont(new java.awt.Font("Arial",Font.PLAIN,13));
        add(phone);
        
        DoB = new Label("Birth Date");
        DoB.setBounds(20,235,80,30);
        DoB.setFont(new java.awt.Font("Arial",Font.BOLD,15));
        add(DoB);
        
        dob = new TextField();
        dob.setBounds(150,235,250,30);
        dob.setFont(new java.awt.Font("Arial",Font.PLAIN,13));
        add(dob);
        
        City = new Label("City");
        City.setBounds(20,280,80,30);
        City.setFont(new java.awt.Font("Arial",Font.BOLD,15));
        add(City);
        
        city = new TextField();
        city.setBounds(150,280,250,30);
        city.setFont(new java.awt.Font("Arial",Font.PLAIN,13));
        add(city);
        
        Country = new Label("Country");
        Country.setBounds(20,325,80,30);
        Country.setFont(new java.awt.Font("Arial",Font.BOLD,15));
        add(Country);
        
        country = new TextField();
        country.setBounds(150,325,250,30);
        country.setFont(new java.awt.Font("Arial",Font.PLAIN,13));
        add(country);
        
        Zip = new Label("Zip Code");
        Zip.setBounds(20,370,80,30);
        Zip.setFont(new java.awt.Font("Arial",Font.BOLD,15));
        add(Zip);
        
        zip = new TextField();
        zip.setBounds(150,370,250,30);
        zip.setFont(new java.awt.Font("Arial",Font.PLAIN,13));
        add(zip);
        
        From = new Label("FROM");
        From.setBounds(440,100,60,30);
        From.setFont(new java.awt.Font("Arial",Font.BOLD,15));
        add(From);
        
        To = new Label("TO");
        To.setBounds(640,100,40,30);
        To.setFont(new java.awt.Font("Arial",Font.BOLD,15));
        add(To);
        
			
        from = new Choice();
        for(int i = 0;i<FlightDetails.uniqueSource.length;i++)
        {
        	if(FlightDetails.uniqueSource[i]!= null)
        	{
        		from.addItem(FlightDetails.uniqueSource[i]);
        	}
        }
        from.setBounds(520,105,100,60);
        add(from);
        
        to = new Choice();
        for(int i = 0;i<FlightDetails.uniqueDestination.length;i++)
        {
        	if(FlightDetails.uniqueDestination[i]!= null)
        	{
        		to.addItem(FlightDetails.uniqueDestination[i]);
        	}
        }
        to.setBounds(700,105,100,60);
        add(to);
        
        seats = new Label("  Adults[12+]            Children[2-12]          Infants[0-2]");
        seats.setBounds(440,145,350,30);
        seats.setFont(new java.awt.Font("Arial",Font.ROMAN_BASELINE,15));
        seats.setForeground(Color.BLUE);
        add(seats);
        
        adults = new Choice();
        for(int i=1; i<=6 ; i++)
        {
        	adults.addItem(String.valueOf(i));
        }
        adults.setBounds(440, 175, 100, 30);
        add(adults);
        
        children = new Choice();
        for(int i=0; i<=6 ; i++)
        {
        	children.addItem(String.valueOf(i));
        }
        children.setBounds(570, 175, 100, 30);
        add(children);
        
        infants = new Choice();
        for(int i=0; i<=6 ; i++)
        {
        	infants.addItem(String.valueOf(i));
        }
        infants.setBounds(700, 175, 100, 30);
        add(infants);
        
        Date = new Label("DATE");
        Date.setBounds(440,220,50,30);
        Date.setFont(new java.awt.Font("Arial",Font.BOLD,15));
        add(Date);
        
        date = new TextField();
        date.setFont(new java.awt.Font("Arial",Font.BOLD,15));
        date.setBounds(500, 220, 120, 30);
        add(date);
        
        submit = new Button("Find Flights");
        submit.setFont(new java.awt.Font("Arial",Font.BOLD,14));
        submit.setBounds(650,220,150,30);
        submit.setBackground(Color.ORANGE);
        add(submit);
        submit.addActionListener(this);
        
        Flights = new TextArea("Flights:");
        Flights.setBounds(440,270,370,130);
        Flights.setFont(new java.awt.Font("Arial",Font.PLAIN,14));
        add(Flights);
                
		Flightcode = new Label("Select Flight code from flights and type Here:");
		Flightcode.setBounds(20,410,400,30);
        Flightcode.setFont(new java.awt.Font("Arial",Font.BOLD,15));
        Flightcode.setForeground(Color.MAGENTA);
        add(Flightcode);
		
        flightcode = new TextField();
        flightcode.setBounds(420,410,200,30);
        flightcode.setFont(new java.awt.Font("Arial",Font.PLAIN,15));
        add(flightcode);
        
        book = new Button("BOOK");
        book.setBounds(700,410,100,40);
        book.setFont(new java.awt.Font("Arial",Font.PLAIN,20));
        book.setBackground(Color.BLUE);
        book.setForeground(Color.white);
        book.addActionListener(this);
        add(book);
        		
		setTitle("Ticket Booking");
        setSize(850, 500);
        setLayout(null);
        setBackground(Color.DARK_GRAY);
        setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==submit)
		{
			try
			{
				FlightDetails.Source = new String[50];
				FlightDetails.Destination = new String[50];
				Operations operation = new Operations();
				if(FlightDetails.isInternational)
				{
					if(operation.findInternationalFlights(from.getSelectedItem(), to.getSelectedItem(), date.getText(), this) && FlightDetails.Source[0]!=null) {
						int i=0;
	        			while(i<FlightDetails.totalFlights)
	        			{
	        				Flights.append("\n["+(i+1)+"] - id:"+FlightDetails.Code_flights[i]+" - "+FlightDetails.Source[i]+" --> "
	        				+FlightDetails.Destination[i]+"[ "+FlightDetails.Date[i]+" : "+FlightDetails.Time[i]+" ]");
	        				i++;
	        			}
					}else {
						Flights.append("\nNot Available!");
					}
				}else if(FlightDetails.isDomestic) {
					if(operation.findDomesticFlights(from.getSelectedItem(), to.getSelectedItem(), date.getText(), this) && FlightDetails.Source[0]!=null) {
						int i=0;
	        			while(i<FlightDetails.totalFlights)
	        			{
	        				Flights.append("\n["+(i+1)+"] - id:"+FlightDetails.Code_flights[i]+" - "+FlightDetails.Source[i]+" --> "
	        				+FlightDetails.Destination[i]+"[ "+FlightDetails.Date[i]+" : "+FlightDetails.Time[i]+" ]");
	        				i++;
	        			}
					}else {
						Flights.append("\nNot Available!");
					}
				}
			}catch(Exception e1) {
				JOptionPane.showMessageDialog(this, "Error: "+e1.getMessage());
			}
			
		}
		if(e.getSource()==book) {
			try
			{
				int seats = Integer.valueOf(adults.getSelectedItem())+Integer.valueOf(children.getSelectedItem())+Integer.valueOf(infants.getSelectedItem());
				Operations operation = new Operations();
				if(operation.bookticket(fname.getText(), email.getText(), phone.getText(), dob.getText(), city.getText(), country.getText(), 
						zip.getText(),from.getSelectedItem(),to.getSelectedItem(), flightcode.getText(), date.getText(), seats, this)) {
					JOptionPane.showMessageDialog(this, "Ticket Booked Successfully");
				}
			}catch(Exception e1) {
				JOptionPane.showMessageDialog(this, "Error: "+e1.getMessage());
			}
		}
		
	}

}
