import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;







import java.sql.ResultSet;




public class Secretary implements ActionListener {
	
	static Connection conn = null;

	static Statement stmt = null;

	ResultSet rs = null;
	
	public Secretary() {
		
		
		

    	try {

    	   conn =

    	      DriverManager.getConnection("jdbc:mysql://localhost/doctor?" +

    	                                  "user=root&password=");



    	   // Do something with the Connection

    	   stmt = conn.createStatement();

    	  

    	  // boolean res = stmt.execute("INSERT INTO `doctor`.`comments` (`sid`, `question`, `ans`) VALUES (' "+ta.getText() +" ', '"+ta.getText() +"', 'e');");

    	 

    	}catch(Exception e ){System.out.println(e);}


		
		
		JFrame frame = new JFrame("Secretary");
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		frame.add(panel);
		placeComponents(panel);

		frame.setVisible(true);

	}
	 
	private static void placeComponents(JPanel panel) {

		panel.setLayout(null);

		JLabel patientDate = new JLabel("Date: (YYYY-MM-DD)");
		patientDate.setBounds(10, 10, 180, 25);
		panel.add(patientDate);

		JTextField userText1 = new JTextField(20);
		userText1.setBounds(200, 10, 160, 25);
		panel.add(userText1);

		JLabel patientName = new JLabel("Full Name:");
		patientName.setBounds(10, 40, 800, 25);
		panel.add(patientName);

		JTextField userText2 = new JTextField(20);
		userText2.setBounds(200, 40, 160, 25);
		panel.add(userText2);

		JLabel patientAge = new JLabel("Age:");
		patientAge.setBounds(10, 70, 80, 25);
		panel.add(patientAge);
		
		JTextField userText3 = new JTextField(20);
		userText3.setBounds(200, 70, 160, 25);
		panel.add(userText3);
		
		JLabel patientTel = new JLabel("Telephone:");
		patientTel.setBounds(10, 100, 80, 25);
		panel.add(patientTel);

		JTextField userText4 = new JTextField(20);
		userText4.setBounds(200, 100, 160, 25);
		panel.add(userText4);
		
		JLabel patientAddress = new JLabel("Address:");
		patientAddress.setBounds(10, 130, 80, 25);
		panel.add(patientAddress);

		JTextField userText5 = new JTextField(25);
		userText5.setBounds(200, 130, 160, 25);
		panel.add(userText5);
		
		JButton submitButton = new JButton("Submit");
		submitButton.setBounds(10, 160, 80, 25);
		panel.add(submitButton);
		
		submitButton.addActionListener(new ActionListener()
		{
			  public void actionPerformed(ActionEvent e)
			  {
				  String ID;
				  String date;
				  String full_name;
				  String age;
				  String tel;
				  String address;
				  
				  date= userText1.getText();
				  full_name= userText2.getText().replaceAll("'", "''");
				  age= userText3.getText();
				  tel= userText4.getText();

				  address= userText5.getText();
				  
				  try{
					 String sql = "INSERT INTO patient (app_date, full_name, age, telephone, address) VALUES (' "+date+" ', '"+full_name +"',"+age+",'"+tel+"','"+address+"');";
			System.out.println(sql);
					     boolean res = stmt.execute(sql);
  
					  
				  }
				  catch(Exception ex){System.out.println(e);}
			    // display/center the jdialog when the button is pressed
			  
			  }

			
			});
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}


}