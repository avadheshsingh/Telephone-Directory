
import java.sql.*;
import java.awt.*;

import javax.swing.*;
import javax.swing.text.View;

import java.awt.event.*;
 
public class Telephonedir implements ActionListener {
	String fname,lname,mname,houseno,area,city,district,state,mobileno_string;
	  String finalFetchedresult;
	  DatabaseAdapter adapter;
	  ResultSet resultSet;
	boolean flag=false ;
	/*GUI Components*/
	JFrame f;
	JButton b1;
	JTextField t;
	JComboBox cb;
	JLabel l1,l2,l3,l4;
	JTextArea ta;
	
    /*Constructor that Creates GUI*/
	
	public Telephonedir(String s)
	{	

		//Code for frame
		f=new JFrame(s);
		f.setSize(600,700);
		f.setLayout(null);
		
		//Code for button
		b1=new JButton("Search");
		//b2=new Button("Clear");
		b1.setBounds(150,300,100,30);
		//b2.setBounds(40,150,50,50);
		f.add(b1);
		b1.addActionListener(this);
		
		//Code for text Field
	      t=new JTextField();
	      t.setBounds(200,230,170,30);
	      f.add(t);
	    
	      //Code for combo Box
	      String menu[]={"Number","FName","MName","LName","House no","Area","City","District","State"};
	      cb=new JComboBox(menu);
	      cb.setBounds(200, 130, 170, 30);
	      f.add(cb);
	      
	      //Code for Jlabel
	      l1=new JLabel("Searching by following field: ");
	      l1.setBounds(30,130,170,30);
	      f.add(l1);
	      
	      l3=new JLabel("Enter value for the field: ");
	      l3.setBounds(30,230,170,30);
	      f.add(l3);
	      
	      l4=new JLabel("RESULT :- ");
	      l4.setBounds(30,340,170,30);
	      f.add(l4);
	      
	      
	      
	      
	      JPanel headpanel=new JPanel();
	  	headpanel.setLayout(new BorderLayout());

	  	JLabel head = new JLabel();
	  	head.setText("TELEPHONE DIRECTORY");
	  	head.setBackground(new Color(0,153,153));
	  	head.setForeground(Color.WHITE);
	  	head.setOpaque(true);
	  	head.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.black),BorderFactory.createEmptyBorder(20,20,20,20)));

	  	head.setFont(new Font("times new roman" , 5,40));
	  	head.setHorizontalAlignment(SwingConstants.CENTER);
	  	headpanel.add(head,BorderLayout.NORTH);
	  	headpanel.setBounds(0,0,600, 100);
	  	f.add(headpanel);
	
	      
	 
	      
	      
	      //Code for Text Area
	      ta=new JTextArea();
	      ta.setBounds(30,380,500,250);
	     ta.setEditable(false);
	      f.add(ta);
	     
	      
	      //Frame Properties
	       f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	       f.setVisible(true);
	}
	
	/* Action Listener When Button is Clicked*/
	
	public  void actionPerformed(ActionEvent e)
	{
	 try {
		 String data=" ",query=" ",value=" ";
		 long  mobileno_long;
		 data =(String) cb.getItemAt (cb.getSelectedIndex());             
		 adapter = new DatabaseAdapter();
         value=t.getText();
         
         // If search by number
         System.out.println(data);
         if(data.equals("Number"))
         {
        	 mobileno_long = Long.parseLong(value);
				query = "select * from telephonedir where mnumber = "
						+ mobileno_long;
			
         }
         
         else if(data.equals("FName"))
         {
        	 query = "select * from telephonedir where FNAME='" + value
				+ "'";
        }
         else if(data.equals("MName"))
         {
        	 query = "select * from telephonedir where MNAME='" + value
				+ "'";
        }
         
         else if(data.equals("LName"))
         {
        		query = "select * from telephonedir where lname ='" + value
				+ "'";
          }
         else  if(data.equals("House no"))
         {
        	 query = "select * from telephonedir where hnum = '" + value
				+ "'";
          }
         
         
         else if(data.equals("Area"))
         {
        	 query = "select * from telephonedir where area = '" + value
				+ "'";
          }
         
         else  if(data.equals("City"))
         {
        	 query = "select * from telephonedir where city = '" + value
				+ "'";
          }
         
         else  if(data.equals("District"))
         {
        	 query = "select * from telephonedir where district = '"
					+ value + "'";
          }
         
         else   if(data.equals("State"))
         {
        	 query = "select * from telephonedir where state= '" + value
				+ "'";
          }
         ResultSet	resultSet = adapter.getTableData(query);
       
     	while (resultSet.next()) {
     		
			fname = resultSet.getString(1);
			mname = resultSet.getString(2);
			lname = resultSet.getString(3);
			mobileno_string = String.valueOf(resultSet.getLong(4));
			houseno = resultSet.getString(3);
			area = resultSet.getString(6);
			city = resultSet.getString(7);
			district = resultSet.getString(8);
			state = resultSet.getString(9);
			flag=true;
		
		}
     	 if (flag)
         {
        	 ta.setText("First Name  :- " + fname + "\nMiddle Name :-"
      				+ mname + "\nLast Name  :-" + lname + "\nMobile " + "Number :-"
      				+ mobileno_string + "\nAddress :\n        Area:-" + area
      				+ "\n        City :-" + city + "\n        District :-"
      				+ district + "\n        State :-" + state);
              flag=false;
         }
         else
         {
        	 ta.setText("No any tele info is found..!!");
         }
         
     } catch (Exception k) { }
     finally {
         try {
             adapter.close();
             resultSet.close();
         } catch (SQLException k) {
            
         }
     }
 }
	
	
	public static void main(String[] args){
    	
    	new Telephonedir("Divyansh-1206041");
    	
	}
	}


	





