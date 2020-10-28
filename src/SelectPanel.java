//Creating the flight selection tab
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.ArrayList;
import java.text.NumberFormat;

public class SelectPanel extends JPanel{
	private ArrayList flightList;
	private JPanel panel1, panel2;
	private JScrollPane scrollpane1;
	private JTextField textfield1;
	private JLabel label1;
	private double check;
		  
	public SelectPanel(ArrayList flightList){//SelectPanel constructor
		this.flightList = flightList;//initialize flightList
		// organize components for purchase panel	 	
		
		label1 = new JLabel("Current Total Purchase");//initialize label1
		textfield1 = new JTextField("$0.00");//sets initial total to $0
		
		setLayout(new BorderLayout());//sets layout	 	
		check = 0.0;//initialize check
			 	
	 	panel1 = new JPanel();//setting the layout
	 	panel1.add(label1);//adds label1 to panel1
	 	panel1.add(textfield1);//adds textfield1 to panel1
	 	textfield1.setPreferredSize(new Dimension(100,25));//sets the size to a bigger dimension
	 	
	 	panel2 = new JPanel();
	 	scrollpane1 = new JScrollPane(panel2);//having a scroll for panel2
	 	panel2.setLayout(new GridLayout(9,1));//setting the layout
	 	
	 	add(panel1, BorderLayout.SOUTH);//adding panel1 to south
	 	add(scrollpane1, BorderLayout.CENTER);//adding scrollpane1 to center	
	}//end of constructor

	public void addCheckBox(Flight flight1){//creates a check box for selecting flights
		JCheckBox chk1 = new JCheckBox(flight1.toString());//creates new check box object
		chk1.addItemListener(new CheckBoxListener());//adds the object to the CheckBoxListener
		panel2.add(chk1);//adds the object to panel2
	}

	private class CheckBoxListener implements ItemListener{//compute the total amount when a check box is checked or unchecked
		public void itemStateChanged(ItemEvent event){
			for(int i=0; i<flightList.size(); i++){//begin for loop
				if((((JCheckBox) panel2.getComponent(i)).isSelected())){//checks for the component in panel2
					check += ((Flight)flightList.get(i)).getAirfare();//increments check
    			}
    	   }//end for loop
    	   textfield1.setText("$"+check);//displays the amount of money selected from check box
		}
	} 
}