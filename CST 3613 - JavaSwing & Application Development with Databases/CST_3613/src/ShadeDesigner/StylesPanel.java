package ShadeDesigner;

import javax.swing.*;
import java.awt.*;

public class StylesPanel extends JPanel{
	JLabel styleLbl;
	JList styleLst;
	String[] styleS = {"Regular Shades: Add $0", "Folding Shades: Add $10", "Roman Shades: Add $15"};
	
	public StylesPanel(){
		this.setBorder(BorderFactory.createTitledBorder(""));
		this.setLayout(new BorderLayout());
		
		styleLbl = new JLabel("Styles:");
		styleLst = new JList(styleS);
		styleLst.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		this.add(styleLbl, new BorderLayout().NORTH);
		this.add(styleLst);
	}
	
	public double getSubtotal(){
		double subtotal = 0;
		
		if(styleLst.getSelectedIndex() == 0)
			subtotal += 0;
		else if(styleLst.getSelectedIndex() == 1)
			subtotal += 10;
		else if(styleLst.getSelectedIndex() == 2)
			subtotal += 15;
		
		return subtotal;
	}
}
