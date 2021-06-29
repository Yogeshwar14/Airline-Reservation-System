package ARS;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.Border;

public class AdminOption extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Label l1,From,To,Date,Time,Capacity,Status;
	private Button users,flights,resvs,addflight,getquerry,submitflight,cancelled;
	private JTextArea resText;
	private JScrollPane sp;
	private TextField from,to,date,time,capacity;
	private Choice status;
	
	public AdminOption() {
	
		setLayout(new FlowLayout());
		
		l1 = new Label("Database Operations");
		l1.setFont(new java.awt.Font("Helvatica",Font.BOLD,25));
		l1.setBounds(0,20,800,40);
		l1.setAlignment(Label.CENTER);
		
		
		Border border = BorderFactory.createLineBorder(Color.orange);
	    
		resText = new JTextArea("Responces Will be captured Here!!");
		
		resText.setBounds(350,70,420,350);
		resText.setFont(new java.awt.Font("Helvatica",Font.BOLD,15));
		resText.setBackground(Color.WHITE);
		
		resText.setBorder(BorderFactory.createCompoundBorder(border,
	            BorderFactory.createEmptyBorder(10, 10, 50, 10)));
		
		resText.setEditable(false);
		sp = new JScrollPane(resText);
		sp.setBounds(350, 70, 420, 350);
		//sp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		users = new Button("Users");
		users.setFont(new java.awt.Font("Helvatica",Font.BOLD,17));
		users.setBounds(30,70,280,50);
		users.setBackground(Color.LIGHT_GRAY);
		users.setVisible(true);
		
		flights = new Button("Flights");
		flights.setFont(new java.awt.Font("Helvatica",Font.BOLD,17));
		flights.setBounds(30,120,280,50);
		flights.setBackground(Color.LIGHT_GRAY);
		flights.setVisible(true);
		
		resvs = new Button("Reservations");
		resvs.setFont(new java.awt.Font("Helvatica",Font.BOLD,17));
		resvs.setBounds(30,170,280,50);
		resvs.setBackground(Color.LIGHT_GRAY);
		resvs.setVisible(true);
		
		addflight = new Button("Add Flight");
		addflight.setFont(new java.awt.Font("Helvatica",Font.BOLD,16));
		addflight.setBounds(30,220,280,50);
		addflight.setBackground(Color.BLUE);
		addflight.setForeground(Color.WHITE);
		addflight.setVisible(true);
		
		
		cancelled = new Button("Cancelled Tickets");
		cancelled.setFont(new java.awt.Font("Helvatica",Font.BOLD,17));
		cancelled.setBounds(30,270,280,50);
		cancelled.setBackground(Color.orange);
		cancelled.setVisible(true);
		
		getquerry = new Button("User Reports");
		getquerry.setFont(new java.awt.Font("Helvatica",Font.BOLD,17));
		getquerry.setBounds(30,320,280,50);
		getquerry.setBackground(Color.orange);
		getquerry.setVisible(true);
		
		From = new Label("From");
        From.setBounds(350,70,80,30);
        From.setFont(new java.awt.Font("Arial",Font.BOLD,15));
        From.setVisible(false);

        from = new TextField();
        from.setBounds(450,70,250,30);
        from.setFont(new java.awt.Font("Arial",Font.PLAIN,13));
        from.setVisible(false);
		
        To = new Label("To");
        To.setBounds(350,110,80,30);
        To.setFont(new java.awt.Font("Arial",Font.BOLD,15));
        To.setVisible(false);

        to = new TextField();
        to.setBounds(450,110,250,30);
        to.setFont(new java.awt.Font("Arial",Font.PLAIN,13));
        to.setVisible(false);
        
        Date = new Label("Date");
        Date.setBounds(350,150,80,30);
        Date.setFont(new java.awt.Font("Arial",Font.BOLD,15));
        Date.setVisible(false);

        date = new TextField();
        date.setBounds(450,150,250,30);
        date.setFont(new java.awt.Font("Arial",Font.PLAIN,13));
        date.setVisible(false);
        
        Time = new Label("Time");
        Time.setBounds(350,190,80,30);
        Time.setFont(new java.awt.Font("Arial",Font.BOLD,15));
        Time.setVisible(false);

        time = new TextField();
        time.setBounds(450,190,250,30);
        time.setFont(new java.awt.Font("Arial",Font.PLAIN,13));
        time.setVisible(false);
        
        Capacity = new Label("Capacity");
        Capacity.setBounds(350,230,80,30);
        Capacity.setFont(new java.awt.Font("Arial",Font.BOLD,15));
        Capacity.setVisible(false);

        capacity = new TextField();
        capacity.setBounds(450,230,250,30);
        capacity.setFont(new java.awt.Font("Arial",Font.PLAIN,13));
        capacity.setVisible(false);
        
        Status = new Label("Status");
        Status.setBounds(350,270,80,30);
        Status.setFont(new java.awt.Font("Arial",Font.BOLD,15));
        Status.setVisible(false);
        
        status = new Choice();
        status.addItem("Domestic");
        status.addItem("International");
        status.setBounds(450,275,250,60);
        status.setFont(new java.awt.Font("Arial",Font.PLAIN,14));
        status.setVisible(false);
        
        submitflight = new Button("Add Flight");
        submitflight.setBackground(Color.blue);
        submitflight.setFont(new java.awt.Font("Arial",Font.PLAIN,13));
        submitflight.setBounds(500,310,80,30);
        submitflight.setVisible(false);
        
        
        
		add(l1);add(users);add(flights);add(addflight);/*add(resText);*/add(resvs);add(getquerry);add(From);add(from);
		add(To);add(to);add(Date);add(date);add(Time);add(time);add(Capacity);add(capacity);add(submitflight);
		add(Status);add(status);add(sp);
		add(cancelled);
		
		
		users.addActionListener(this);
		flights.addActionListener(this);
		addflight.addActionListener(this);
		resvs.addActionListener(this);
		getquerry.addActionListener(this);
		submitflight.addActionListener(this);
		cancelled.addActionListener(this);
		
		setTitle("Admin Options");
        setSize(850, 500);
        setLayout(null);
        setBackground(Color.DARK_GRAY);
        setVisible(true);
	}
	
	public void hideAddElements() {
		sp.setVisible(true);
		From.setVisible(false);
		from.setVisible(false);
		To.setVisible(false);
		to.setVisible(false);
		Date.setVisible(false);
		date.setVisible(false);
		Time.setVisible(false);
		time.setVisible(false);
		Capacity.setVisible(false);
		capacity.setVisible(false);
		submitflight.setVisible(false);
		Status.setVisible(false);
		status.setVisible(false);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==users)
		{
			sp.setVisible(true);
			hideAddElements();
			try 
			{
			
			Operations operation = new Operations();
			
			if(operation.userList(this))
			{
				System.out.println("Users!");
				resText.setText("Users here");
				
				int i=0;
				while(i < AdminResponce.totalUsers)
				{
					resText.append("\n[" +AdminResponce.ID[i] + "]:" + AdminResponce.Users[i] + " - '" + AdminResponce.Email[i] + "'");
					System.out.println("\n[" +AdminResponce.ID[i] + "]:" + AdminResponce.Users[i]);
					i+=1;
				}
			}else {
				JOptionPane.showMessageDialog(this, "Couldn't load Users!");
				}
			}catch(Exception e1) {
				JOptionPane.showMessageDialog(this, "Error: "+e1.getMessage());
			}
		}
		
		if(e.getSource()==flights)
		{
			sp.setVisible(true);
			hideAddElements();
			System.out.println("Flights!");
			try 
			{
			
			Operations operation = new Operations();
			
			if(operation.getFlightDetails(this))
			{
				resText.setText("Flights");
				
				int i=0;
				while(i < FlightDetails.totalFlights)
				{
					resText.append("\n["+FlightDetails.ID_flights[i]+"] - "+FlightDetails.Code_flights[i]+" - "
					+FlightDetails.Source[i] + "-->"+FlightDetails.Destination[i]+"["+FlightDetails.Date[i]+" : "+FlightDetails.Time[i]);
					resText.append("\nCapacity: ["+FlightDetails.Capacity[i]+"] Reserved: ["+FlightDetails.reserved_seats[i]+"] Available: ["
					+FlightDetails.Available_seats[i]+"]\n");
					i+=1;
				}
			}else {
				JOptionPane.showMessageDialog(this, "Couldn't load Flights!");
				}
			}catch(Exception e1) {
				JOptionPane.showMessageDialog(this, "Error: "+e1.getMessage());
			}
		}
		
		if(e.getSource()==addflight)
		{
			System.out.println("addflight!");
			resText.setText("Adding flight");
			sp.setVisible(false);
			From.setVisible(true);
			from.setVisible(true);
			To.setVisible(true);
			to.setVisible(true);
			Date.setVisible(true);
			date.setVisible(true);
			Time.setVisible(true);
			time.setVisible(true);
			Capacity.setVisible(true);
			capacity.setVisible(true);
			submitflight.setVisible(true);
			Status.setVisible(true);
			status.setVisible(true);
		}
		
		if(e.getSource()==submitflight)
		{
			String fromStr = from.getText();
			String toStr = to.getText();
			String dateStr = date.getText();
			String timestr = time.getText();
			String statusStr = status.getSelectedItem();
			if(fromStr.isEmpty() || toStr.isEmpty() || dateStr.isEmpty() || timestr.isEmpty() || capacity.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(this,"Give total Flight details");
			}else {
				try
				{
					int cap = Integer.parseInt(capacity.getText());
					Operations operation = new Operations();
					
					if(operation.addFlight(fromStr, toStr, dateStr, timestr, cap,statusStr , this)) {
						from.setText("");
						to.setText("");
						date.setText("");
						time.setText("");
						capacity.setText("");
						sp.setVisible(true);
					}
					
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(this, "Error: "+e1.getMessage());
				}
			}
		}
		
		
		if(e.getSource()==resvs)
		{
			hideAddElements();
			sp.setVisible(true);
			System.out.println("Reservations:");
			resText.setText("Reservations here");
			try
			{
				Operations operation = new Operations();
				if(operation.getReservations(this)) {
					for(int i= 0;i< Tickets.totalTickets;i++)
					{
						resText.append("\n["+(i+1)+"] \n\tUser:"
								+Tickets.user[i]+"\n\tTicket:"
								+Tickets.ticket_code[i]+" \n\tFlight: "
								+Tickets.flightCode[i]+" \n\tDate: "
								+Tickets.flightDate[i]+"\n\tSeats: "
								+Tickets.seats[i]);
					}
				}
			}catch(Exception e1) {
				JOptionPane.showMessageDialog(this, "Error: "+e1.getMessage());
			}
			
		}
		
		if(e.getSource()==getquerry)
		{
			hideAddElements();
			sp.setVisible(true);
			System.out.println("Reports!");
			resText.setText("Reports here\n");
			
			try 
			{
			
			Operations operation = new Operations();
			
			if(operation.getQuerry(this))
			{
				
				int i=0;
				while(i < AdminResponce.totalUsers)
				{
					resText.append("\n[" +AdminResponce.ID[i] + "]:" + AdminResponce.Users[i] + " - '" + AdminResponce.querry[i] + "'");
					System.out.println("\n[" +AdminResponce.ID[i] + "]:" + AdminResponce.Users[i]);
					i+=1;
				}
			}else {
				JOptionPane.showMessageDialog(this, "Couldn't load User Reports!");
				}
			}catch(Exception e1) {
				JOptionPane.showMessageDialog(this, "Error: "+e1.getMessage());
			}
		}
		
		if(e.getSource()==cancelled) {
			hideAddElements();
			sp.setVisible(true);
			System.out.println("Cancelled Reservations:");
			resText.setText("Cancelled Tickets here");
			try
			{
				Operations operation = new Operations();
				if(operation.getCancelledTickets(this)) {
					for(int i= 0;i< Tickets.totalTickets;i++)
					{
						resText.append("\n["+(i+1)+"] \n\tUser:"
								+Tickets.user[i]+"\n\tTicket:"
								+Tickets.ticket_code[i]+" \n\tFlight: "
								+Tickets.flightCode[i]+" \n\tDate: "
								+Tickets.flightDate[i]+"\n\tSeats: "
								+Tickets.seats[i]);
					}
				}
			}catch(Exception e1) {
				JOptionPane.showMessageDialog(this, "Error: "+e1.getMessage());
			}
		}
	}

}
