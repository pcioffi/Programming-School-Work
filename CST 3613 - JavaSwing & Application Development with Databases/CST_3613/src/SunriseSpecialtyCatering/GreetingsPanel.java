package SunriseSpecialtyCatering;

import javax.swing.*;
import java.awt.*;

public class GreetingsPanel extends JPanel{
	JLabel greetingL;
	
	public GreetingsPanel(){
		Font font = new Font("Serif", Font.BOLD + Font.ITALIC, 24);
		greetingL = new JLabel("Welcome to Sunrise Specialty Catering");
		greetingL.setFont(font);
		
		this.add(greetingL);
	}
}
