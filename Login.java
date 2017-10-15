import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Login implements ActionListener {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Login");
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		frame.add(panel);
		placeComponents(panel);

		frame.setVisible(true);

	}

	private static void placeComponents(JPanel panel) {

		panel.setLayout(null);
		
		JLabel username = new JLabel("Username:");
		username.setBounds(10, 10, 80, 25);
		panel.add(username);

		JTextField userText = new JTextField(20);
		userText.setBounds(100, 10, 160, 25);
		panel.add(userText);

		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setBounds(10, 40, 80, 25);
		panel.add(passwordLabel);

		JPasswordField passwordText = new JPasswordField(20);
		passwordText.setBounds(100, 40, 160, 25);
		panel.add(passwordText);

		JButton loginButton = new JButton("Login");
		loginButton.setBounds(10, 80, 80, 25);
		panel.add(loginButton);
		
		loginButton.addActionListener(new ActionListener()
		{
			  public void actionPerformed(ActionEvent e)
			  {
			String username ="";
		    String password ="";
				
				username = userText.getText().replaceAll("'", "''");
				password = passwordText.getText().replaceAll("'", "''");


					
				  
				  try{
					  
					  Connection conn = null;

			           	 Statement stmt = null;
			            	
			            	   conn =

			         	    	      DriverManager.getConnection("jdbc:mysql://localhost/doctor?" +

			         	    	                                  "user=root&password=");



			         	    	   // Do something with the Connection

			         	    	   stmt = conn.createStatement();

			            	 stmt = conn.createStatement();
			            	 
			            	 String numbersquery = "SELECT users.* from users where username = '"+username+"' and password ='"+password+"'";
 
			            	 System.out.println(numbersquery);
			            	 
			            	 String account;
			            	 account = "ok";
			            	 
			            	   ResultSet assRset = stmt.executeQuery(numbersquery);

			      			       // must use next() before you can access the results
			       while(assRset.next())
			       	            {

			    	   account = assRset.getString("job");

			       	            }
			       if ( account.equals("ok")){
			    	   
			    	   JOptionPane.showMessageDialog(null, "Account not vaild."); 
			       }
			       else{
			    	   if(account.equals("doctor")){
			    		   Doctor doc = new Doctor();
			    	   }
			    	   
			    	   if(account.equals("secretary")){
			    		   Secretary sec = new Secretary();
			    		   
			       	   }
			    	   
			    	   if(account.equals("pharmasist")){
			    		   Pharmasist pha = new Pharmasist();
			    		   
			    	   }
			    	   
			       }
				  }
				  catch(Exception ex){ex.printStackTrace();}
				//  JOptionPane.showMessageDialog(null, "test");
			    // display/center the jdialog when the button is pressed*/
			  
			  }

			
			});
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
		
