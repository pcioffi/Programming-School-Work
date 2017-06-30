package SunriseSpecialtyCatering;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import java.awt.*;

public class SideDishesPanel extends JPanel{
	JCheckBox saladCB, mixedCB, potatoCB, riceCB, beanCB, breadCB;
	
	public SideDishesPanel(){
		Border border = BorderFactory.createLineBorder(Color.WHITE);
		Font font = new Font("Serif", Font.BOLD + Font.ITALIC, 16);
		this.setBorder(BorderFactory.createTitledBorder(border, "Side Dishes", TitledBorder.CENTER, 0, font));
		this.setPreferredSize(new Dimension(200,200));
		this.setLayout(new GridLayout(3,2));
		
		saladCB = new JCheckBox("Salad");
		mixedCB = new JCheckBox("Mixed_Vegetables");
		potatoCB = new JCheckBox("Potatoes");
		riceCB = new JCheckBox("Rice_Dishes");
		beanCB = new JCheckBox("Beans");
		breadCB = new JCheckBox("Bread");
		
		this.add(saladCB);
		this.add(mixedCB);
		this.add(potatoCB);
		this.add(riceCB);
		this.add(beanCB);
		this.add(breadCB);
	}
	
	public double getSubtotal(){
		double subtotal = 0;
		
		if(saladCB.isSelected() == true)
			subtotal += 6.5;
		if(mixedCB.isSelected() == true)
			subtotal += 9.5;
		if(potatoCB.isSelected() == true)
			subtotal += 5.5;
		if(riceCB.isSelected() == true)
			subtotal += 7.75;
		if(beanCB.isSelected() == true)
			subtotal += 6.75;
		if(breadCB.isSelected() == true)
			subtotal += 4;
		
		return subtotal;
	}
}
