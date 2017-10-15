import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.ResultSet;



public class Doctor implements ActionListener {
	
	static JTextArea note1;
	static JTextArea note2;
	static JTextArea note3;
	
	static int patient_id1 =0;
	
	static int patient_id2 =0;

	static int patient_id3 =0;

	public Doctor() {
		
		
		JFrame frame = new JFrame("Doctor");
		frame.setSize(900, 900);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		frame.add(panel);
		placeComponents(panel);

		frame.setVisible(true);
		
		

	}
		
		private static void placeComponents(JPanel panel)  {

			panel.setLayout(null);

			JLabel fontAppt = new JLabel("Appointments:");
			fontAppt.setBounds(10, 10, 80, 25);
			panel.add(fontAppt);
			
			JLabel date = new JLabel("Date:");
			date.setBounds(10, 100, 80, 25);
			panel.add(date);
			
			JLabel pname = new JLabel("Name:");
			pname.setBounds(300, 100, 80, 25);
			panel.add(pname);
			
			JLabel notes = new JLabel("Notes:");
			notes.setBounds(500, 100, 80, 25);
			panel.add(notes);

			JTextField date1 = new JTextField(20);
			date1.setBounds(10, 130, 160, 25);
			date1.setEnabled(false);
			panel.add(date1);
			
			
			JTextField date2 = new JTextField(20);
			date2.setBounds(10, 200, 160, 25);
			date2.setEnabled(false);
			panel.add(date2);
			
			JTextField date3 = new JTextField(20);
			date3.setBounds(10, 270, 160, 25);
			date3.setEnabled(false);
			panel.add(date3);

			
			
			JTextField name = new JTextField(40);
			name.setBounds(300, 130, 160, 25);
			name.setEnabled(false);
			panel.add(name);
			
			JTextField name2 = new JTextField(40);
			name2.setBounds(300, 200, 160, 25);
			name2.setEnabled(false);
			panel.add(name2);
			
			JTextField name3 = new JTextField(40);
			name3.setBounds(300, 270, 160, 25);
			name3.setEnabled(false);
			panel.add(name3);
			
			
			note1 = new JTextArea(5,160);
			note1.setBounds(500, 130, 360, 40);
			panel.add(note1);
			
			 note2 = new JTextArea(5,160);
			note2.setBounds(500, 200, 360, 40);
			panel.add(note2);
			
			 note3 = new JTextArea(5,160);
			note3.setBounds(500, 270, 360, 40);
			panel.add(note3);
	
			JButton submitButton = new JButton("Submit");
			submitButton.setBounds(500, 320, 80, 25);
			panel.add(submitButton);
			
			submitButton.addActionListener(new ActionListener()
			{
				  public void actionPerformed(ActionEvent e)
				  {
					String notes1 ="";
					String notes2 ="";
					String notes3 ="";
					
					notes1 = note1.getText().replaceAll("'", "''");
					notes2 = note2.getText().replaceAll("'", "''");
					notes3 = note3.getText().replaceAll("'", "''");


					  
					
					  
					  try{
						  
						  Connection conn = null;

				           	 Statement stmt = null;
				            	
				            	   conn =

				         	    	      DriverManager.getConnection("jdbc:mysql://localhost/doctor?" +

				         	    	                                  "user=root&password=");



				         	    	   // Do something with the Connection

				         	    	   stmt = conn.createStatement();

				            	 stmt = conn.createStatement();
				            	 
				            	 if(patient_id1 !=0){
				            		 String sql = "update  patient set notes ='"+notes1+"' where patient.ID="+patient_id1;
				     				System.out.println(sql);
				     						     boolean res = stmt.execute(sql);
				            		 
				            	 }
				            	 
				            	 if(patient_id2 !=0){
				            		 String sql = "update  patient set notes ='"+notes2+"' where patient.ID="+patient_id2;
				     				System.out.println(sql);
				     						     boolean res = stmt.execute(sql);
				            		 
				            	 }
				            	 
				            	 if(patient_id3 !=0){
				            		 String sql = "update  patient set notes ='"+notes3+"' where patient.ID="+patient_id3;
				     				System.out.println(sql);
				     						     boolean res = stmt.execute(sql);
				            		 
				            	 }
						
	  
						  
					  }
					  catch(Exception ex){ex.printStackTrace();}
					  JOptionPane.showMessageDialog(null, "test");
				    // display/center the jdialog when the button is pressed
				  
				  }

				
				});

		
			String patientname1 ="";
			String patientname2 ="";
			String patientname3 ="";
			
			String app_date1 ="";
			String app_date2 ="";
			String app_date3 ="";
			
			patient_id1 =0;
			
			patient_id2 =0;

			patient_id3 =0;
			
			String notes1 ="";
			String notes2 ="";
			String notes3 ="";
			

			
			String numbersquery = "SELECT patient.* from patient order by app_date asc";

            System.out.println(numbersquery);
            try{
            	
            	Connection conn = null;

           	 Statement stmt = null;
            	
            	   conn =

         	    	      DriverManager.getConnection("jdbc:mysql://localhost/doctor?" +

         	    	                                  "user=root&password=");



         	    	   // Do something with the Connection

         	    	   stmt = conn.createStatement();

            	 stmt = conn.createStatement();
            ResultSet assRset = stmt.executeQuery(numbersquery);

            int counter =0;

// must use next() before you can access the results
while(assRset.next())
	            {
	counter++;
	if(counter==1){
		patient_id1 = assRset.getInt("ID");
		app_date1 =assRset.getString("app_date");
		patientname1 = assRset.getString("full_name");
		notes1 = assRset.getString("notes");
	}
	
	if(counter==2){
		patient_id2 = assRset.getInt("ID");
		app_date2 =assRset.getString("app_date");
		patientname2 = assRset.getString("full_name");
		notes2 = assRset.getString("notes");
	}
	
	if(counter==3){
		patient_id3 = assRset.getInt("ID");
		app_date3 =assRset.getString("app_date");
		patientname3 = assRset.getString("full_name");
		notes3 = assRset.getString("notes");
	}

    }


name.setText(patientname1);
name2.setText(patientname2);
name3.setText(patientname3);

date1.setText(app_date1);
date2.setText(app_date2);

date3.setText(app_date3);

note1.setText(notes1);
note2.setText(notes2);
note3.setText(notes3);





}
catch(Exception e)
	{
e.printStackTrace();
 //   System.out.println("Error Select Banl Calc Numbers in SQL");
//JOptionPane.showMessageDialog(null, "Broken Calc");
 	}


}//End of selectStatementAssets

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}


	}

		
		
		
		
		
		
		

