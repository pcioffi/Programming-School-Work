package JoesAutomotiveProject;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JoesAutomotiveMain extends JFrame{
	JPanel routineP, nonroutineP;
	JTextField totalTF;
	
	public JoesAutomotiveMain(){
		setTitle("Joe's Automotive");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		super.setSize(100, 200);

		routineP = new RoutineService();
		nonroutineP = new NonRoutineService();

		JButton total = new JButton("Total");
		totalTF = new JTextField();
		totalTF.setEnabled(false);

		// Register an event listener with all 3 buttons.
		total.addActionListener(new ButtonListener());

		this.setLayout(new GridLayout(3,1));
		add(routineP);
		add(nonroutineP);
		pack();
		add(total);
		
		setVisible(true);
	}

	/**
	  Private inner class that handles the event when
	  the user clicks a button.
	*/

	private class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			double routineSub = ((RoutineService) routineP).getSubtotal();
			double nonroutineSub = ((NonRoutineService) nonroutineP).getNonSubtotal();
			
			NumberFormat currency = NumberFormat.getCurrencyInstance();
			double total = routineSub + nonroutineSub;

			JOptionPane.showMessageDialog(null, "" + currency.format(total));
		}
	}

	/**
	   This program creates an instance of the JoesAutomotive
	   class, which causes it to display its window.
	*/

	public static void main(String[] args)
	{
	  new JoesAutomotiveMain();
	}
}
