package ARS;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;

public class ReportQuerry extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextArea querry;
	private Button submit;

	public ReportQuerry() {
		setLayout(new FlowLayout());
		
		Border border = BorderFactory.createLineBorder(Color.orange);
		querry = new JTextArea("Type Your Issue Here..");
		
		querry.setBounds(20,20,520,300);
		querry.setFont(new java.awt.Font("Helvatica",Font.PLAIN,15));
		querry.setBackground(Color.WHITE);
		
		querry.setBorder(BorderFactory.createCompoundBorder(border,
	            BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		
		
		submit = new Button("Submit");
		submit.setFont(new java.awt.Font("Helvatica",Font.BOLD,17));
		submit.setBounds(450,350,100,30);
		submit.setBackground(Color.ORANGE);
		
		add(querry);add(submit);
		
		
		submit.addActionListener(this);
		setTitle("Report Querry");
        setSize(600, 500);
        setLayout(null);
        setBackground(Color.DARK_GRAY);
        setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==submit)
		{
			try {
				String userStr = LoginSession.name;
				String querryStr = querry.getText();
				
				Operations operation = new Operations();
				if(operation.reportQuerry(userStr, querryStr, this))
				{
					this.dispose();
				}
			}catch(Exception e1) {
				JOptionPane.showMessageDialog(this , "Error : "+ e1.getMessage());
			}
		}
		
	}

}
