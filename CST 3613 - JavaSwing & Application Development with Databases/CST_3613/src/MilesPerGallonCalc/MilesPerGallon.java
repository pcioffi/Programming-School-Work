package MilesPerGallonCalc;

import javax.swing.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class MilesPerGallon extends JFrame{
	private JPanel panel;
	private JLabel mpgCalc;
	private JLabel milesTrav;
	private JLabel galUsed;
	private JTextField mileTextField;
	private JTextField galTextField;
	private JButton calcButton;
	
	private final int WINDOW_WIDTH = 225;
	private final int WINDOW_HEIGHT = 150;

	public MilesPerGallon(){
		setTitle("MPG Calculator");
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
		buildPanel();
		add(panel);

		setVisible(true);
	}

	private void buildPanel(){     
		mpgCalc = new JLabel("MPG Calculator");
		milesTrav = new JLabel("Enter miles travelled");
		galUsed = new JLabel("Enter gallons used    ");
      
		mileTextField = new JTextField(6);
		galTextField = new JTextField(6);
      
		calcButton = new JButton("Calculate MPG");
		calcButton.addActionListener(new CalcButtonListener());

		panel = new JPanel();
	    panel.add(mpgCalc);
	    panel.add(milesTrav);
	    panel.add(mileTextField);
	    panel.add(galUsed);
	    panel.add(galTextField);
	    panel.add(calcButton);
	}

	private class CalcButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			double miles;
			double gallons;
			double mpg;

			miles = Double.parseDouble(mileTextField.getText());
			gallons = Double.parseDouble(galTextField.getText());
			mpg = miles/gallons;

			DecimalFormat formatter = new DecimalFormat("#0.00");

			JOptionPane.showMessageDialog(null, "Miles Per Gallon: " + formatter.format(mpg));
		}
	}
	
	public static void main(String[] args){
		MilesPerGallon mpg = new MilesPerGallon();
	}
}