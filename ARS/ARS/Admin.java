package ARS;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JOptionPane;

public class Admin extends Frame implements ActionListener{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private Label l3;
    private Label UID;
    private TextField uid;
    private Label APass;
    private TextField apass;
    private Button Log;

    public Admin(){
        setLayout(new FlowLayout());

        l3 = new Label("Admin Log In");
        l3.setFont(new java.awt.Font("Arial",Font.BOLD,30));
        l3.setBounds(100,50,100,40);
        add(l3);

        UID = new Label("Admin ID");
        UID.setBounds(50,110,80,30);
        UID.setFont(new java.awt.Font("Arial",Font.BOLD,15));
        add(UID);

        uid = new TextField();
        uid.setBounds(140,110,150,30);
        uid.setFont(new java.awt.Font("Arial",Font.BOLD,15));
        add(uid);

        APass = new Label("Password");
        APass.setBounds(50,150,80,30);
        APass.setFont(new java.awt.Font("Arial",Font.BOLD,15));
        add(APass);

        apass = new TextField();
        apass.setBounds(140,150,150,30);
        apass.setFont(new java.awt.Font("Arial",Font.BOLD,15));
        apass.setEchoChar('*');
        add(apass);

        Log = new Button("Log In");
        Log.setBounds(120,200,80,30);
        Log.setBackground(Color.darkGray);
        add(Log);

        Log.addActionListener(this);
        setTitle("Admin");
        setSize(350, 400);
        setLayout(null);
        setBackground(Color.lightGray);
        setVisible(true);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
    	if(e.getSource()==Log)
		{	
			Operations operation = new Operations();
    		try{
    			String UIDStr = uid.getText();
    			String ApasswordStr = apass.getText();
				if(operation.isAdmin(UIDStr, ApasswordStr, this)){
					JOptionPane.showMessageDialog(this, "Admin Login Successful!!");
					LoginSession.isloggedin=true;
        			Mainpage.logout.setVisible(true);
        			String str = null;
        			if(LoginSession.isAdmin)
        			{
        				str = "ADMIN: ";
        			}
        			Mainpage.user.setText(str + LoginSession.name);
        			Mainpage.user.setVisible(true);
        			Mainpage.btn.setVisible(false);
        			Mainpage.adminopt.setVisible(true);
        			this.dispose();
				}else {
    	    		JOptionPane.showMessageDialog(this, "Incorrect UID/Password!");
    	    	}
	    	}catch(Exception e1) {
	    		JOptionPane.showMessageDialog(this, "Admin Login Error: "+e1.getMessage());
	    	}
		}
        
    }
    
}
