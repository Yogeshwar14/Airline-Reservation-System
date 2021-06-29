package ARS;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Reservation extends JFrame implements ActionListener{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Image img = Toolkit.getDefaultToolkit().getImage("D:\\SDP_Sem4\\SDP_ARS\\air5.jpg");
	private Label l1, password,ticketID;
	private Button book,review, cancel,intern,dom,closetickets, cancelTicket ,closeCancellation;
	private TextField pass,ticketid;
	private TextArea tickets;
    public Reservation() {
    	setLayout(new FlowLayout());
    	this.setContentPane(new JPanel() {
			private static final long serialVersionUID = 1L;

			@Override
            public void paintComponent(Graphics g) {
               super.paintComponent(g);
               g.drawImage(img, 0, 0, null);
            }
    	});
		l1 = new Label("Reservation");
    	l1.setBounds(0,50,840,40);
    	l1.setAlignment(Label.CENTER);
    	l1.setFont(new java.awt.Font("Arial",Font.BOLD,25));
    	l1.setBackground(Color.lightGray);
    	
    	closetickets = new Button("Close");
        closetickets.setBounds(660,60,100,30);
        closetickets.setBackground(Color.red);
        closetickets.setVisible(false);
        add(closetickets);
    	 	
    	book = new Button("Booking");
        book.setFont(new java.awt.Font("Helvatica",Font.BOLD,15));
        book.setBounds(250,200,300,60);
        book.setBackground(Color.white);
        
        tickets = new TextArea("Tickets:");
        tickets.setBounds(60,100,500,300);
        tickets.setFont(new java.awt.Font("Helvatica",Font.BOLD,13));
        tickets.setVisible(false);
        add(tickets);
        
        
        intern = new Button("International");
        intern.setFont(new java.awt.Font("Helvatica",Font.BOLD,15));
        intern.setBounds(250,200,300,60);
        intern.setBackground(Color.white);
        intern.setForeground(Color.blue);
        intern.setVisible(false);
        
        dom = new Button("Domestic");
        dom.setFont(new java.awt.Font("Helvatica",Font.BOLD,15));
        dom.setBounds(250,270,300,60);
        dom.setBackground(Color.white);
        dom.setForeground(Color.blue);
        dom.setVisible(false);
        
        review = new Button("Review");
        review.setFont(new java.awt.Font("Helvatica",Font.BOLD,15));
        review.setBounds(250,270,300,60);
        review.setBackground(Color.white);
        
        cancel = new Button("Cancellation");
        cancel.setFont(new java.awt.Font("Helvatica",Font.BOLD,15));
        cancel.setBounds(250,340,300,60);
        cancel.setBackground(Color.white);
        
        ticketID = new Label("Ticket Code");
        ticketID.setBounds(220, 200, 150, 30);
        ticketID.setFont(new java.awt.Font("Arial",Font.BOLD,20));
        ticketID.setVisible(false);
        
        password = new Label("Password");
        password.setBounds(220, 240, 150, 30);
        password.setFont(new java.awt.Font("Arial",Font.BOLD,20));
        password.setVisible(false);
    	
        ticketid = new TextField();
        ticketid.setBounds(380, 200, 250, 30);
        ticketid.setFont(new java.awt.Font("Arial",Font.BOLD,20));
        ticketid.setVisible(false);
        
        pass = new TextField();
        pass.setBounds(380, 240, 250, 30);
        pass.setFont(new java.awt.Font("Arial",Font.BOLD,20));
        pass.setEchoChar('*');
        pass.setVisible(false);
        
        cancelTicket = new Button("Confirm Cancellation");
        cancelTicket.setBounds(280,280,200,30);
        cancelTicket.setBackground(Color.BLUE);
        cancelTicket.setVisible(false);
        
        closeCancellation = new Button("Close");
        closeCancellation.setBounds(660,100,100,30);
        closeCancellation.setBackground(Color.BLUE);
        closeCancellation.setVisible(false);
        
        
        add(l1);add(book);add(review);add(cancel); 
        add(intern);add(dom);
        add(ticketID);add(password);add(ticketid);add(pass);add(cancelTicket);add(closeCancellation);
        
        book.addActionListener(this);
        review.addActionListener(this);
        cancel.addActionListener(this);
        intern.addActionListener(this);
        dom.addActionListener(this);
        closetickets.addActionListener(this);
        cancelTicket.addActionListener(this);
        closeCancellation.addActionListener(this);
        
        setTitle("Reservation");
        setSize(850, 500);
        setLayout(null);
        setBackground(Color.DARK_GRAY);
        setVisible(true);
     
        }
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==book) {
			book.setVisible(false);
			review.setVisible(false);
			cancel.setVisible(false);
			intern.setVisible(true);
			dom.setVisible(true);
		}
		
		if(e.getSource()==intern) {
			

			Operations operation1 = new Operations();
			
			int next =1;
	        if(operation1.getInternationalFlights(null))
	        {
	        	//-> From-Choice
	        	
	        	if(FlightDetails.uniqueSource[0] == null)
				{
	        		FlightDetails.uniqueSource[0]=FlightDetails.Source[0];
				}
	        	for(int j=0;j<FlightDetails.Source.length;j++)
	        	{
	        		if(FlightDetails.Source[j]!=null)
	        		{
	        			Boolean isIn = false;
    		        	for(int i1=0;i1<FlightDetails.uniqueSource.length;i1++)
    					{
    		        		//System.out.println(i1+FlightDetails.uniqueSource[i1]+"- "+j+FlightDetails.Source[j]+FlightDetails.Source.length);
							if(FlightDetails.uniqueSource[i1]==null)
							{
								isIn = false;
								break;
							}
    		        		if(FlightDetails.uniqueSource[i1].equals(FlightDetails.Source[j]) && FlightDetails.Source[j]!=null)
    						{
    							isIn = true;
    							break;
    						}else {
    							isIn = false;
    						}
    						
    					}
    					if(isIn == false)
    					{
    						FlightDetails.uniqueSource[next]= FlightDetails.Source[j];
    						//System.out.println(+FlightDetails.uniqueSource[next]);
    						next++;
    					}
	        		}
	        	}
	        	
	        	//For -> to-choice
	        	
	        	
	        	
	        	next = 1;
	        	if(FlightDetails.uniqueDestination[0] == null)
				{
	        		FlightDetails.uniqueDestination[0]=FlightDetails.Destination[0];
				}
	        	for(int j=0;j<FlightDetails.Destination.length;j++)
	        	{
	        		if(FlightDetails.Destination[j]!=null)
	        		{
	        			Boolean isIn = false;
    		        	for(int i1=0;i1<FlightDetails.uniqueDestination.length;i1++)
    					{
    		        		//System.out.println(i1+FlightDetails.uniqueDestination[i1]+"- "+j+FlightDetails.Destination[j]+FlightDetails.Destination.length);
							if(FlightDetails.uniqueDestination[i1]==null)
							{
								isIn = false;
								break;
							}
    		        		if(FlightDetails.uniqueDestination[i1].equals(FlightDetails.Destination[j]) && FlightDetails.Destination[j]!=null)
    						{
    							isIn = true;
    							break;
    						}else {
    							isIn = false;
    						}
    						
    					}
    					if(isIn == false)
    					{
    						FlightDetails.uniqueDestination[next]= FlightDetails.Destination[j];
    						//System.out.println(+FlightDetails.uniqueSource[next]);
    						next++;
    					}
	        		}
	        	}
	        	
	        }
	        
	        for(int i=0;i<10;i++)
	        {
	        	System.out.println(FlightDetails.uniqueDestination[i]);
	        }
	        FlightDetails.isInternational = true;
	        bookTicket book = new bookTicket();
			book.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                	FlightDetails.isInternational = false;
                    book.dispose();
                    FlightDetails.uniqueDestination = new String[50];
                    FlightDetails.uniqueSource = new String[50];
                }
            });
		}
		
		if(e.getSource()==dom) {

			Operations operation1 = new Operations();
			int next =1;
	        if(operation1.getDomesticFlights(null))
	        {
	        	//for -> From-Choice
	        	
	        	
	        	if(FlightDetails.uniqueSource[0] == null)
				{
	        		FlightDetails.uniqueSource[0]=FlightDetails.Source[0];
				}
	        	for(int j=0;j<FlightDetails.Source.length;j++)
	        	{
	        		if(FlightDetails.Source[j]!=null)
	        		{
	        			Boolean isIn = false;
    		        	for(int i1=0;i1<FlightDetails.uniqueSource.length;i1++)
    					{
    		        		//System.out.println(i1+FlightDetails.uniqueSource[i1]+"- "+j+FlightDetails.Source[j]+FlightDetails.Source.length);
							if(FlightDetails.uniqueSource[i1]==null)
							{
								isIn = false;
								break;
							}
    		        		if(FlightDetails.uniqueSource[i1].equals(FlightDetails.Source[j]) && FlightDetails.Source[j]!=null)
    						{
    							isIn = true;
    							break;
    						}else {
    							isIn = false;
    						}
    						
    					}
    					if(isIn == false)
    					{
    						FlightDetails.uniqueSource[next]= FlightDetails.Source[j];
    						//System.out.println(+FlightDetails.uniqueSource[next]);
    						next++;
    					}
	        		}
	        	}
	        	//For -> to-choice
	        	next = 1;
	        	if(FlightDetails.uniqueDestination[0] == null)
				{
	        		FlightDetails.uniqueDestination[0]=FlightDetails.Destination[0];
				}
	        	for(int j=0;j<FlightDetails.Destination.length;j++)
	        	{
	        		if(FlightDetails.Destination[j]!=null)
	        		{
	        			Boolean isIn = false;
    		        	for(int i1=0;i1<FlightDetails.uniqueDestination.length;i1++)
    					{
    		        		//System.out.println(i1+FlightDetails.uniqueDestination[i1]+"- "+j+FlightDetails.Destination[j]+FlightDetails.Destination.length);
							if(FlightDetails.uniqueDestination[i1]==null)
							{
								isIn = false;
								break;
							}
    		        		if(FlightDetails.uniqueDestination[i1].equals(FlightDetails.Destination[j]) && FlightDetails.Destination[j]!=null)
    						{
    							isIn = true;
    							break;
    						}else {
    							isIn = false;
    						}
    						
    					}
    					if(isIn == false)
    					{
    						FlightDetails.uniqueDestination[next]= FlightDetails.Destination[j];
    						//System.out.println(+FlightDetails.uniqueSource[next]);
    						next++;
    					}
	        		}
	        	}
	        	
	        }
	        
	        for(int i=0;i<10;i++)
	        {
	        	System.out.println(FlightDetails.uniqueDestination[i]);
	        }
			FlightDetails.isDomestic = true;
	        bookTicket book = new bookTicket();
			book.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    book.dispose();
                    FlightDetails.isDomestic = false;
                    FlightDetails.uniqueDestination = new String[50];
                    FlightDetails.uniqueSource = new String[50];
                }
            });
		}
		
		if(e.getSource()==review) {
			l1.setText("Tickets Review");
			book.setVisible(false);
			review.setVisible(false);
			cancel.setVisible(false);
			closetickets.setVisible(true);
			tickets.setVisible(true);
			try
			{
				Operations operation = new Operations();
				if(operation.getTickets(this)) {
					if(Tickets.flightCode[0]!=null)
					{
						for(int i=0;i<Tickets.totalTickets;i++) {
						tickets.append("\n["+(i+1)+"]\n\tTicket Code:"+Tickets.ticket_code[i]
								+"\n\tFrom: ["+Tickets.from[i]+"] --- To: [ "+Tickets.to[i]+"]\n\tFloght Code: [ "
								+Tickets.flightCode[i]+" ]\n\tFlight Date: ["
								+Tickets.flightDate[i]+"]\n\tBooking Date: ["
								+Tickets.bookingDate[i]+"]\n\tSeats Booked: [ "
								+Tickets.seats[i]+" ]\n\t<"+Tickets.status[i]+">");
						}
					}else {
						tickets.append("\n No Tickets Available!");
					}
				}
				
			}catch(Exception e1) {
				JOptionPane.showMessageDialog(this, "Error : "+e1.getMessage());
			}
			
		}
		
		if(e.getSource()==closetickets) {
			l1.setText("Reservation");
			book.setVisible(true);
			review.setVisible(true);
			cancel.setVisible(true);
			closetickets.setVisible(false);
			tickets.setVisible(false);
			tickets.setText("Tickets:\n");
		}
		
		if(e.getSource()==cancel) {
			l1.setText("Cancellation");
			book.setVisible(false);
			review.setVisible(false);
			cancel.setVisible(false);
			ticketID.setVisible(true);
			password.setVisible(true);
			ticketid.setVisible(true);
			pass.setVisible(true);
			cancelTicket.setVisible(true);
			closeCancellation.setVisible(true);
		}
		
		if(e.getSource()==closeCancellation) {
			l1.setText("Reservation");
			book.setVisible(true);
			review.setVisible(true);
			cancel.setVisible(true);
			ticketID.setVisible(false);
			password.setVisible(false);
			ticketid.setVisible(false);
			pass.setVisible(false);
			cancelTicket.setVisible(false);
			closeCancellation.setVisible(false);
		}
		
		if(e.getSource()==cancelTicket) {
			try
			{
				String ticketCodeStr = ticketid.getText();
				String passStr = pass.getText();
				Operations operation = new Operations();
				if(operation.cancelTicket(LoginSession.name, passStr, ticketCodeStr, this))
				{
					JOptionPane.showMessageDialog(this, "Ticket Cancelled");
				}
			}catch(Exception e1) {
				JOptionPane.showMessageDialog(this,"Error : "+e1.getMessage());
			}
		}
	}
}