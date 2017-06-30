package SunriseSpecialtyCatering;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import java.awt.*;

public class MainDishesPanel extends JPanel{
	JRadioButton beefRB, chickenRB, salmonRB, pastaRB;
	ButtonGroup maindishBG;
	
	public MainDishesPanel(){
		Border border = BorderFactory.createLineBorder(Color.RED);
		Font font = new Font("Serif", Font.BOLD + Font.ITALIC, 16);
		this.setBorder(BorderFactory.createTitledBorder(border, "Main Dishes", TitledBorder.CENTER, 0, font));
		this.setPreferredSize(new Dimension(200,300));
		this.setLayout(new GridLayout(4,1));
		
		beefRB = new JRadioButton("Beef_Meat_Loaf");
		chickenRB = new JRadioButton("BBQ_Chicken_Pieces");
		salmonRB = new JRadioButton("Grilled_Salmon");
		pastaRB = new JRadioButton("Pasta_Prima_Vera");
		
		maindishBG = new ButtonGroup();
		maindishBG.add(beefRB);
		maindishBG.add(chickenRB);
		maindishBG.add(salmonRB);
		maindishBG.add(pastaRB);
		
		this.add(beefRB);
		this.add(chickenRB);
		this.add(salmonRB);
		this.add(pastaRB);
	}
	
	public double getSubtotal(){
		double subtotal = 0;
		
		if(beefRB.isSelected() == true)
			subtotal += 70;
		else if(chickenRB.isSelected() == true)
			subtotal += 60;
		else if(salmonRB.isSelected() == true)
			subtotal += 20;
		else if(pastaRB.isSelected() == true)
			subtotal += 40;
		
		return subtotal;
	}
}
