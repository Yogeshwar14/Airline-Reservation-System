package ARS;
import java.awt.*;
import java.awt.event.*;
//import javax.swing.JTextField;

import javax.swing.JOptionPane;

public class Loginpage extends Frame implements ActionListener {
	private static final long serialVersionUID = 1L;
    private Label l2;
    private Label Uname,Email;
    private TextField uname,email;
    private Label Pass , CPass;
    private TextField pass, confirmpass;
    private Button login;
    private Button register,Fregister;

    public Loginpage(){
        setLayout(new FlowLayout());

        l2 = new Label("Log In");
        l2.setFont(new java.awt.Font("Arial",Font.BOLD,30));
        l2.setBounds(150,50,150,40);
        add(l2);

        Uname = new Label("User Name");
        Uname.setBounds(20,110,80,30);
        Uname.setFont(new java.awt.Font("Arial",Font.BOLD,15));
        add(Uname);

        uname = new TextField();
        uname.setBounds(200,110,250,30);
        uname.setFont(new java.awt.Font("Arial",Font.PLAIN,13));
        add(uname);
        
        Email = new Label("Email");
        Email.setBounds(20,150,80,30);
        Email.setFont(new java.awt.Font("Arial",Font.BOLD,15));
        Email.setVisible(false);
        add(Email);
        
        email = new TextField();
        email.setBounds(200,150,250,30);
        email.setFont(new java.awt.Font("Arial",Font.PLAIN,13));
        email.setVisible(false);
        add(email);

        Pass = new Label("Password");
        Pass.setBounds(20,150,80,30);
        Pass.setFont(new java.awt.Font("Arial",Font.BOLD,15));
        add(Pass);

        pass = new TextField();
        pass.setBounds(200,150,250,30);
        pass.setFont(new java.awt.Font("Arial",Font.PLAIN,13));
        pass.setEchoChar('*');
        add(pass);
        
        CPass = new Label("Confirm\n Password");
        CPass.setBounds(20,230,150,30);
        CPass.setFont(new java.awt.Font("Arial",Font.BOLD,15));
        add(CPass);
        CPass.setVisible(false);
        
        confirmpass = new TextField();
        confirmpass.setBounds(200,230,250,30);
        confirmpass.setFont(new java.awt.Font("Arial",Font.PLAIN,13));
        confirmpass.setEchoChar('*');
        add(confirmpass);
        confirmpass.setVisible(false);

        login = new Button("Log In");
        login.setBounds(150,200,80,30);
        login.setBackground(Color.darkGray);
        add(login);
        login.addActionListener(this);
        register = new Button("Not Registered Yet!");
        register.setBounds(250,200,150,30);
        add(register);
        register.addActionListener(this);
        register.setBackground(Color.BLUE);
        
        Fregister = new Button("Register");
        Fregister.setBounds(100,280,150,30);
        add(Fregister);
        Fregister.addActionListener(this);
        Fregister.setVisible(false);


        setTitle("Login");
        setSize(500, 350);
        setLayout(null);
        setBackground(Color.gray);
        setVisible(true);

        
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==login)
        {
        	System.out.println("Logging in..");
        	Operations operation = new Operations();
        	try {
        		String userNameStr = uname.getText();
        		String passwordStr = pass.getText();
        		//System.out.println("u: "+userNameStr+"\n p:"+passwordStr);
        		
        		if(operation.isLogin(userNameStr, passwordStr, this))
        		{
        			JOptionPane.showMessageDialog(this, "Login Successful!");
        			LoginSession.isloggedin=true;
        			Mainpage.logout.setVisible(true);
        			Mainpage.user.setText(LoginSession.name);
        			Mainpage.user.setVisible(true);
        			Mainpage.btn.setVisible(false);
        			Mainpage.report.setVisible(true);
        			
        			this.dispose();
        		}else {
        			JOptionPane.showMessageDialog(this, "Invalid Username/Password!");
        		}
        	}catch(Exception ex) {
        		JOptionPane.showMessageDialog(this, "Please type Correct credentials!");
        	}
        }
        if(e.getSource()==register)
        {
        	System.out.println("Register");
        	l2.setText("Register");
        	Pass.setBounds(20,190,80,30);
        	pass.setBounds(200,190,250,30);
        	CPass.setVisible(true);
        	confirmpass.setVisible(true);
        	login.setVisible(false);
        	Fregister.setVisible(true);
        	register.setVisible(false);
        	Email.setVisible(true);
        	email.setVisible(true);
        	
        	
        }
        if(e.getSource()==Fregister)
        {
        	try {
	        	String userNameStr = uname.getText();
	        	String emailStr = email.getText();
	    		String passwordStr = pass.getText();
	    		String CpasswordStr = confirmpass.getText();
	    		if(passwordStr.length()>8 && (passwordStr.contains("@") || passwordStr.contains("#") || passwordStr.contains("$") || passwordStr.contains("&"))) {
	    			if(passwordStr.equals(CpasswordStr))
		        	{	
		    			Operations operation = new Operations();
		        		if(operation.Register(userNameStr, emailStr, passwordStr, this))
		        		{
		        			JOptionPane.showMessageDialog(this, "Registration successful! Logged in as :"+ userNameStr);
		        			LoginSession.isloggedin=true;
		        			Mainpage.logout.setVisible(true);
		        			Mainpage.user.setText(LoginSession.name);
		        			Mainpage.user.setVisible(true);
		        			Mainpage.btn.setVisible(false);
		        			Mainpage.report.setVisible(true);
		        			this.dispose();
		        		}
		        	}else {
		        		JOptionPane.showMessageDialog(this, "Please retype confirmation password correctly!");
		        	}
	    		}else {
	    			JOptionPane.showMessageDialog(this, "    Weak Password! \n!Should be more than 8 characters \n!Should contain special characters like '@','#','$','&')");
	    		}
        	}catch(Exception e1) {
        		JOptionPane.showMessageDialog(this, "Registration Error: "+e1.getMessage());
        	}
        }
        
    }

    
}
