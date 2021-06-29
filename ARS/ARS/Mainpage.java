package ARS;
import java.awt.*;
import java.awt.event.*;
//import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;


public class Mainpage extends JFrame implements ActionListener {
    /**
     *
     */
	Image img = Toolkit.getDefaultToolkit().getImage("D:\\SDP_Sem4\\SDP_ARS\\air5.jpg");
    private static final long serialVersionUID = -2833624948635559541L;
    private Label l1;    // Declaring a Label component 
    private Button adm,details,resv,closeDetails,international,domestic;
    public static Button logout,btn,adminopt,report;   // Declaring Button component
    public static Label user;
    public JTextArea Details;
    
	
    //Main page Constructor to setup GUI components and event handlers
    
    public Mainpage(){
    	
    	setLayout(new FlowLayout());
    	this.setContentPane(new JPanel() {
			private static final long serialVersionUID = 1L;

			@Override
            public void paintComponent(Graphics g) {
               super.paintComponent(g);
               g.drawImage(img, 0, 0, this);
            }
    	});
        
        l1 = new Label("Welcome to Airline Manager!!");
        l1.setFont(new java.awt.Font("Helvatica",Font.BOLD,30));
        l1.setAlignment(Label.CENTER);
        l1.setBounds(0,120,840,40);
        
        btn = new Button("Login");
        btn.setBounds(660,40,100,30);
        btn.setBackground(Color.WHITE);
        adm = new Button("Admin");
        adm.setBounds(30,400,100,30);
        adm.setBackground(Color.gray);
        
        report = new Button("Report");
        report.setBounds(660,40,100,30);
        report.setBackground(Color.red);
        report.setVisible(false);

        details = new Button("Flight Details");
        details.setFont(new java.awt.Font("Helvatica",Font.BOLD,15));
        details.setBounds(250,200,300,60);
        details.setBackground(Color.white);
        
        international = new Button("International Flights");
        international.setFont(new java.awt.Font("Helvatica",Font.BOLD,18));
        international.setBounds(250,200,300,60);
        international.setBackground(Color.white);
        international.setForeground(Color.red);
        international.setVisible(false);
        
        domestic = new Button("Domestic");
        domestic.setFont(new java.awt.Font("Helvatica",Font.BOLD,18));
        domestic.setBounds(250,260,300,60);
        domestic.setBackground(Color.white);
        domestic.setForeground(Color.RED);
        domestic.setVisible(false);
        
        Border border = BorderFactory.createLineBorder(Color.orange);
        
        Details = new JTextArea("Flights");
        Details.setBounds(150,30,500,400);
        Details.setBackground(Color.WHITE);
        Details.setFont(new java.awt.Font("Helvatica",Font.BOLD,16));
        Details.setVisible(false);
        Details.setEditable(false);
        Details.setBorder(BorderFactory.createCompoundBorder(border,
	            BorderFactory.createEmptyBorder(20, 20, 20, 20)));
        
        closeDetails = new Button("Close");
        closeDetails.setBounds(660, 80, 100, 30);
        closeDetails.setBackground(Color.red);
        closeDetails.setVisible(false);

        resv = new Button("Reservation");
        resv.setFont(new java.awt.Font("Helvatica",Font.BOLD,15));
        resv.setBounds(250,260,300,60);
        resv.setBackground(Color.white);
        
        adminopt = new Button("Admin Options");
        adminopt.setFont(new java.awt.Font("Helvatica",Font.BOLD,15));
        adminopt.setBounds(250,320,300,60);
        adminopt.setBackground(Color.white);
        adminopt.setVisible(false);

        logout = new Button("LogOut");
        logout.setBounds(660,400,100,30);
        logout.setBackground(Color.WHITE);
        logout.setVisible(false);
        
        user = new Label("CurrentUser");
        user.setFont(new java.awt.Font("Helvatica",Font.BOLD,12));
        user.setAlignment(Label.CENTER);
        user.setBounds(660,340,100,30);
        user.setVisible(false);
        
       
        add(l1);add(btn);add(adm);add(details);add(resv);add(logout);add(user);add(adminopt);add(report);add(Details);add(closeDetails);
        add(international);add(domestic);


        btn.addActionListener(this);
        adm.addActionListener(this);
        logout.addActionListener(this);
        resv.addActionListener(this);
        adminopt.addActionListener(this);
        report.addActionListener(this);
        details.addActionListener(this);
        closeDetails.addActionListener(this);
        international.addActionListener(this);
        domestic.addActionListener(this);
        // Will override action performed afterwords
        setTitle("Airline reservation System");
        setLayout(null);
        setSize(850, 500);
        setBackground(Color.GRAY);
        setVisible(true);
    }

    public static void main(String[] args){
        Mainpage app = new Mainpage();

        // ActionEvent handler - Called back upon button-click.

        app.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btn)
        {
            Loginpage login = new Loginpage();
            login.addWindowListener(new WindowAdapter() {

                @Override
                public void windowClosing(WindowEvent e) {
                    login.dispose();
                }
            });
        }   
        if(e.getSource()==adm)
        {
            Admin Adm = new Admin();
            Adm.addWindowListener(new WindowAdapter() {

                @Override
                public void windowClosing(WindowEvent e) {
                    Adm.dispose();
                }
            });
        }

        if(e.getSource()==resv)
        {
        	if(LoginSession.isloggedin==false)
        	{
        		JOptionPane.showMessageDialog(this, "Login Needed for Reservation");
        	}else {
        			
        		
	            Reservation Resv = new Reservation();
	            Resv.addWindowListener(new WindowAdapter() {
	
	                @Override
	                public void windowClosing(WindowEvent e) {
	                    Resv.dispose();
	                }
	            });
        	}
        }
        
        if(e.getSource()==details)
        {
        	closeDetails.setVisible(true);
        	international.setVisible(true);
        	domestic.setVisible(true);
        	details.setVisible(false);
        	resv.setVisible(false);
        }
        
        if(e.getSource()==international)
        {
        	Details.setVisible(true);
        	l1.setVisible(false);
        	details.setVisible(false);
        	resv.setVisible(false);
        	closeDetails.setVisible(true);
        	adminopt.setVisible(false);
        	try
        	{
        		Operations operation = new Operations();
        		if(operation.getInternationalFlights(null)) {
        			int i=0;
        			while(i<FlightDetails.totalFlights)
        			{
        				Details.append("\n["+(i+1)+"] - "+FlightDetails.Source[i]+" --> "
        			+FlightDetails.Destination[i]+"[ "+FlightDetails.Date[i]+" : "+FlightDetails.Time[i]+" ]");
        				i++;
        			}
        		}
        	}catch(Exception e1) {
        		JOptionPane.showMessageDialog(this, "Error :" +e1.getMessage());
        	}
        }
        
        if(e.getSource()==domestic)
        {
        	Details.setVisible(true);
        	l1.setVisible(false);
        	details.setVisible(false);
        	resv.setVisible(false);
        	closeDetails.setVisible(true);
        	adminopt.setVisible(false);
        	try
        	{
        		Operations operation = new Operations();
        		if(operation.getDomesticFlights(null)) {
        			int i=0;
        			while(i<FlightDetails.totalFlights)
        			{
        				Details.append("\n["+(i+1)+"] - "+FlightDetails.Source[i]+" --> "
        			+FlightDetails.Destination[i]+"[ "+FlightDetails.Date[i]+" : "+FlightDetails.Time[i]+" ]");
        				i++;
        			}
        		}
        	}catch(Exception e1) {
        		JOptionPane.showMessageDialog(this, "Error :" +e1.getMessage());
        	}
        }
        
        if(e.getSource()==closeDetails)
        {
        	Details.setVisible(false);
        	Details.setText("Flights");
        	l1.setVisible(true);
        	details.setVisible(true);
        	resv.setVisible(true);
        	closeDetails.setVisible(false);
        	international.setVisible(false);
        	domestic.setVisible(false);
        	if(LoginSession.isAdmin)
        	{
        		adminopt.setVisible(true);
        	}
        }
        
        if(e.getSource()==logout)
        {
        	JOptionPane.showMessageDialog(this, "Session Logged Out!");
        	Logout.logOut(this);
        	btn.setVisible(true);
        	logout.setVisible(false);
        	user.setVisible(false);
        	adminopt.setVisible(false);
        }
        
        if(e.getSource()==adminopt) 
        {
        	if(LoginSession.isAdmin== true)
        	{
        		AdminOption adminoption = new AdminOption();
	        	adminoption.addWindowListener(new WindowAdapter() {
	
	                @Override
	                public void windowClosing(WindowEvent e) {
	                    adminoption.dispose();
	                }
	            });
        	}else {
        		JOptionPane.showMessageDialog(this, "Admin Login Required!");
        	}
        }
        
        if(e.getSource()==report)
        {
        	ReportQuerry report = new ReportQuerry();
        	report.addWindowListener(new WindowAdapter() {

                @Override
                public void windowClosing(WindowEvent e) {
                    report.dispose();
                }
            });
        }
    }

    
}