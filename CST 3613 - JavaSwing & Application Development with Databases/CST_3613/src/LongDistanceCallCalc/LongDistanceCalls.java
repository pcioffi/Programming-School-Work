package LongDistanceCallCalc;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class LongDistanceCalls  extends JFrame
{
	private JPanel pnlCallLength, pnlCallTime, pnlCalculate;
	private JLabel lblLengthOfCall;
	private JTextField txtLengthOfCall;
	private JButton btnCalculate;
	private JRadioButton rdbDaytime, rdbEvening, rdbOffPeak;
	private ButtonGroup bgTimeSelection;
	
	private int time;
	
	public LongDistanceCalls()
	{
		setTitle("Long Distance Calls");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(new GridLayout(3,1));

		buildPanels();
		
		add(pnlCallLength);
		add(pnlCallTime);
		add(pnlCalculate);
		
		pack();
		setVisible(true);
	}
	
	private void buildPanels(){
		lblLengthOfCall = new JLabel("Length of call (in minutes)");
		txtLengthOfCall = new JTextField(10);
		
		btnCalculate = new JButton("Calculate");
		btnCalculate.addActionListener(new CalcButtonListener());
		
		rdbDaytime = new JRadioButton("Daytime (6:00 A.M. through 5:59 P.M.)");
		rdbEvening = new JRadioButton("Evening (6:00 P.M. through 11:59 P.M.)");
		rdbOffPeak = new JRadioButton("Off-Peak (12:00 A.M. through 5:59 A.M.)");
		
		bgTimeSelection = new ButtonGroup();
		bgTimeSelection.add(rdbDaytime);
		bgTimeSelection.add(rdbEvening);
		bgTimeSelection.add(rdbOffPeak);
		
		pnlCallLength = new JPanel();
		pnlCallTime = new JPanel();
		pnlCalculate = new JPanel();
		
		pnlCallLength.add(lblLengthOfCall);
		pnlCallLength.add(txtLengthOfCall);
		pnlCallTime.add(rdbDaytime);
		pnlCallTime.add(rdbEvening);
		pnlCallTime.add(rdbOffPeak);
		pnlCalculate.add(btnCalculate);
	}
	
	private class CalcButtonListener implements ActionListener{	
		public void actionPerformed(ActionEvent e){
			int callLength = Integer.parseInt(txtLengthOfCall.getText());
			NumberFormat dollar = NumberFormat.getCurrencyInstance();
			double rate = 0;
			double total = 0;
			
			if(rdbDaytime.isSelected())
				rate = 0.07;
			else if(rdbEvening.isSelected())
				rate = 0.12;
			else if(rdbOffPeak.isSelected())
				rate = 0.05;
			
			total = rate * callLength;
			
			JOptionPane.showMessageDialog(null, "The cost of the call is " +
					dollar.format(total));
		}
	}
	
	public static void main(String args[]){
		LongDistanceCalls lgc = new LongDistanceCalls();
	}
}