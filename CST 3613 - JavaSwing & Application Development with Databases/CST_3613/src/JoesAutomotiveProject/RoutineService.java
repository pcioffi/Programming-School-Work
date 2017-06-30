package JoesAutomotiveProject;

import javax.swing.*;

import java.awt.event.*;
import java.awt.*;

public class RoutineService extends JPanel {
	public JCheckBox oil, lube, radiator, transmission, inspection, muffler, tire;
	public JLabel routine;
	
	public RoutineService(){
		super.setSize(150, 350);
		routine = new JLabel("Routine's Service");
		this.setLayout(new GridLayout(8,1));
		this.add(routine);
		
		oil = new JCheckBox("Oil Change ($26.00)");
		lube = new JCheckBox("Lube Job ($18.00)");
		radiator = new JCheckBox("Radiator Fluid ($30.00)");
		transmission = new JCheckBox("Transmission Flush ($80.00)");
		inspection = new JCheckBox("Inspection ($15.00)");
		muffler = new JCheckBox("Muffler Replacement ($100.00)");
		tire = new JCheckBox("Tire Rotation ($20.00)");
		
		this.add(oil); this.add(lube); this.add(radiator); this.add(transmission); this.add(inspection);
		this.add(muffler); this.add(tire);
	}
	
	public double getSubtotal(){
		double subtotal = 0;
		
		if ( oil.isSelected() )				subtotal += 26;
		if ( lube.isSelected() )			subtotal += 18;
		if ( radiator.isSelected() )		subtotal += 30;
		if ( transmission.isSelected() )	subtotal += 80;
		if ( inspection.isSelected() )		subtotal += 15;
		if ( muffler.isSelected() )			subtotal += 100;
		if ( tire.isSelected() )			subtotal += 20;
		
		return subtotal;
	}
}
