package CelsiusToFahrenheitConvert;

import javax.swing.*;
import java.awt.event.*;

public class CelsiusToFahrenheit extends JFrame{
	private JPanel panel;
	private JLabel celsiusLabel;
	private JTextField celsiusTextField;
	private JButton convButton;
	
	private final int WINDOW_WIDTH = 300;
	private final int WINDOW_HEIGHT = 100;

	public CelsiusToFahrenheit(){
		setTitle("Celsius to Fahrenheit");
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
		buildPanel();
		add(panel);

		setVisible(true);
	}

	private void buildPanel(){
		celsiusLabel = new JLabel("Temperature in C");
      
		celsiusTextField = new JTextField(3);
      
		convButton = new JButton("Convert to F");
		convButton.addActionListener(new CalcButtonListener());


		panel = new JPanel();

	    panel.add(celsiusLabel);
	    panel.add(celsiusTextField);
	    panel.add(convButton);
	}

	private class CalcButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			double celsius;
			double fahrenheit;

			celsius = Double.parseDouble(celsiusTextField.getText());
			fahrenheit = ((9 * celsius) / 5) + 32;

			JOptionPane.showMessageDialog(null, "Fahrenheit: " + fahrenheit + "F");
		}
	}
	
	public static void main(String[] args){
		CelsiusToFahrenheit ctf = new CelsiusToFahrenheit();
	}
}