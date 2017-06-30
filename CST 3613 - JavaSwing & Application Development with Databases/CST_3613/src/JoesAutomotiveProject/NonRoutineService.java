package JoesAutomotiveProject;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class NonRoutineService extends JPanel{
	public JTextField parts, hours;
	public JLabel partsL, hoursL, nonroutine;
	public JPanel partsP, hoursP;
	
	public NonRoutineService(){
		super.setSize(50, 100);
		nonroutine = new JLabel("Non-Routine Service");
		this.setLayout(new GridLayout(3,1));
		this.add(nonroutine);
		
		partsP = new JPanel(new GridLayout(1,2));
		hoursP = new JPanel(new GridLayout(1,2));
		
		partsP.setSize(10,10);
		hoursP.setSize(10,10);
		
		partsP.add(partsL = new JLabel("Parts Charged"));
		partsP.add(parts = new JTextField());
		
		hoursP.add(hoursL = new JLabel("Hours of Labor"));
		hoursP.add(hours = new JTextField());
				
		this.add(partsP);
		this.add(hoursP);
	}
	
	public double getNonSubtotal(){
		double partsD = Double.parseDouble(parts.getText().toString());
		int hoursD = Integer.parseInt(hours.getText().toString());
		double subtotal = partsD + (hoursD * 20);
		
		return subtotal;
	}
}
