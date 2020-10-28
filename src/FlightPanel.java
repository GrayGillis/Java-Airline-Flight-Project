//Creating the flight creation tab
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class FlightPanel extends JPanel{
	private ArrayList flightList;
	private JButton button1;
	private SelectPanel selectPanel;
	private JPanel panel1;
	private JTextField text1,text2,text3,text4,text5,text6,text7,text8,text9; 
	private JLabel label1,label2,label3,label4,label5,label6,label7,label8,label9, error;
	private TextArea area1 = new TextArea();
	private int airnumber;
	private double airfare;

	//Constructor initializes components and organize them using certain layouts
	public FlightPanel(ArrayList flightList, SelectPanel selectPanel){
	    this.flightList = flightList;//initialize flightList
	    this.selectPanel = selectPanel;//initialize selectPanel
	    airnumber = 0;//initialize air number
	    airfare = 0.0;//initialize air fare
	    
	    Container content = new Container();//creates new container
	    
	    JPanel wholePanel = new JPanel();
	    wholePanel.setLayout(new BorderLayout());
	    add(wholePanel);//whole panel
	    
	    JPanel leftPanel = new JPanel();
	    leftPanel.setLayout(new BorderLayout());
	    wholePanel.add(leftPanel, BorderLayout.WEST);//setting leftPanel to WEST
	    
	    JPanel panel1 = new JPanel();
	    leftPanel.add(panel1, BorderLayout.NORTH);//setting panel1 to NORTH
	    error = new JLabel();
	    error.setText("");//starts blank
	    error.setForeground(Color.red);//setting the font color to red
	    panel1.add(error);//setting to panel1
	    	    
	    JPanel panel2 = new JPanel();
	    leftPanel.add(panel2, BorderLayout.CENTER);//setting panel2 to the center 
	    panel2.setLayout(new GridLayout(9,2));
	    
	    label1 = new JLabel("Enter a name of airlines ");
	    panel2.add(label1);//label
	    text1 = new JTextField(10);
	    panel2.add(text1);//text field
	    label2 = new JLabel("Enter a flight number ");
	    panel2.add(label2);//label
	    text2 = new JTextField(10);
	    panel2.add(text2);//text field
	    label3 = new JLabel("Enter a departure city ");
	    panel2.add(label3);//label
	    text3 = new JTextField(10);
	    panel2.add(text3);//text field
	    JLabel label4 = new JLabel("Enter a departure day ");
	    panel2.add(label4);//label
	    text4 = new JTextField(10);
	    panel2.add(text4);//text field
	    label5 = new JLabel("Enter a departure time ");
	    panel2.add(label5);//label
	    text5 = new JTextField(10);
	    panel2.add(text5);//text field
	    label6 = new JLabel("Enter an arrival city ");
	    panel2.add(label6);//label
	    text6 = new JTextField(10);
	    panel2.add(text6);//text field
	    label7 = new JLabel("Enter an arrival day ");
	    panel2.add(label7);//label
	    text7 = new JTextField(10);
	    panel2.add(text7);//text field
	    label8 = new JLabel("Enter an arrival time ");
	    panel2.add(label8);//label
	    text8 = new JTextField(10);
	    panel2.add(text8);//text field
	    label9 = new JLabel("Airfare ");
	    panel2.add(label9);//label
	    text9 = new JTextField(10);
	    panel2.add(text9);//text field
	    //all the labels and text fields
	    
	    JPanel panel3 = new JPanel();
	    leftPanel.add(panel3, BorderLayout.SOUTH);//setting pane13 to SOUTH
	    
	    button1 = new JButton("Create a flight");
	    panel3.add(button1);
	    button1.addActionListener (new ButtonListener());//create a flight button on the bottom
	    
	    JPanel rightPanel = new JPanel();
	    wholePanel.add(rightPanel, BorderLayout.EAST);//setting rightPanel to the EAST 
	   
	    area1.setRows(20);//number of rows
	    area1.setColumns(35);//number of columns
	    rightPanel.add(area1);//adding text area to rightPanel
	    area1.setText("No flight");//starts with "no flight"
 
	}

	private class ButtonListener implements ActionListener{//happens when "Create a flight" is pushed
	    public void actionPerformed(ActionEvent event){
	    	if(text1.getText().equals("") || text2.getText().equals("") ||
	    			text3.getText().equals("") || text4.getText().equals("") || 
	    			text5.getText().equals("") || text6.getText().equals("") || 
	    			text7.getText().equals("") || text8.getText().equals("") || 
	    			text9.getText().equals("")){//checks every text field 
        	    	error.setText("Please enter all fields.");//outputs the error
        	}
        	else{
        	    try{//try and catch
        			airnumber = Integer.parseInt(text2.getText());//checks
        			airfare = Double.parseDouble(text9.getText());//checks
        		}
        		catch(NumberFormatException e){//catches the error
        		    error.setText("Please enter a number for its flight number and its airfare");//displays the error		    
        		}
        	    Flight flight5 = new Flight();//new flight object
        	    flight5.setAirfare(airfare);//sets the air fare
        	    flight5.setAirlines(text1.getText());//sets the airlines
        	    flight5.setArrival(text6.getText(),text7.getText(),text8.getText());//sets the arrival
        	    flight5.setDeparture(text3.getText(),text4.getText(),text5.getText());//sets the departure
        	    flight5.setFlightNum(airnumber);//sets the flight number
        	    flightList.add(flight5);//adds flight5 to flightList
        	    String toDisplay = "";
            	for(int i = 0; i < flightList.size(); i++){//begin for loop
            	    toDisplay = toDisplay + flightList.get(i).toString();//shows every flight
            		error.setText("Flight added.");//displays that every time
            	}//end for loop
            	    
            	selectPanel.addCheckBox(flight5);//adds the check box to selectPanel 
            	area1.setText(toDisplay);//displays the check
	        }
	    } //end of actionPerformed method
	} //end of ButtonListener class
}