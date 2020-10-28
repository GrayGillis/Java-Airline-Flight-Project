// Creates a Pane with two tabs, one to make a list of flights and one for 
// a customer to select some, and adds it as its JApplet content and also sets its size.

import javax.swing.*;
import java.util.*;

public class Airline extends JApplet{
	private int APPLET_WIDTH = 800, APPLET_HEIGHT = 400;
	private JTabbedPane tPane;
	private FlightPanel flightPanel;
	private SelectPanel selectPanel;
	private ArrayList flightList;

	public void init(){//initializes the JApplet with a Pane with two tabs
		flightList = new ArrayList();//list of flights to be used in every panel
		
	    selectPanel = new SelectPanel(flightList);
	    flightPanel = new FlightPanel(flightList, selectPanel);
	    
	    tPane = new JTabbedPane();//create a JTabbedPane with two tabs
	    tPane.addTab("Flight Creation", flightPanel);
	    tPane.addTab("Flight Selection", selectPanel);

	    getContentPane().add(tPane);
	    setSize (APPLET_WIDTH, APPLET_HEIGHT); //set JApplet size
	}
}