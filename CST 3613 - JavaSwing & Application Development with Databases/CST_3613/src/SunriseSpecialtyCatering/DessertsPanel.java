package SunriseSpecialtyCatering;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import java.awt.*;

public class DessertsPanel extends JPanel{
	JRadioButton noneRB, cakeRB, pieRB, puddingRB;
	ButtonGroup dessertdishBG;
	
	public DessertsPanel(){
		Border border = BorderFactory.createLineBorder(Color.BLUE);
		Font font = new Font("Serif", Font.BOLD + Font.ITALIC, 16);
		this.setBorder(BorderFactory.createTitledBorder(border, "Desserts", TitledBorder.CENTER, 0, font));
		this.setPreferredSize(new Dimension(200,300));
		this.setLayout(new GridLayout(4,1));
		
		noneRB = new JRadioButton("No_Dessert");
		cakeRB = new JRadioButton("Chocolate_Cake");
		pieRB = new JRadioButton("Apple_Pie");
		puddingRB = new JRadioButton("Butterscotch_Pudding");
		
		dessertdishBG = new ButtonGroup();
		dessertdishBG.add(noneRB);
		dessertdishBG.add(cakeRB);
		dessertdishBG.add(pieRB);
		dessertdishBG.add(puddingRB);
		
		this.add(noneRB);
		this.add(cakeRB);
		this.add(pieRB);
		this.add(puddingRB);
	}
	
	public double getSubtotal(){
		double subtotal = 0;
		
		if(noneRB.isSelected() == true)
			subtotal += 0;
		else if(cakeRB.isSelected() == true)
			subtotal += 2.25;
		else if(pieRB.isSelected() == true)
			subtotal += 1.5;
		else if(puddingRB.isSelected() == true)
			subtotal += 2.5;
		
		return subtotal;
	}
}
