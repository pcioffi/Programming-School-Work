package ShadeDesigner;

import javax.swing.*;
import java.awt.*;

public class ColorsPanel extends JPanel{
	JLabel colorLbl;
	JList colorLst;
	String[] colorS = {"Natural: Add $5", "Blue: Add $0", "Teal: Add $0", "Red: Add $0", "Green: Add $0"};
	
	public ColorsPanel(){
		this.setBorder(BorderFactory.createTitledBorder(""));
		this.setLayout(new BorderLayout());
		
		colorLbl = new JLabel("Sizes:");
		colorLst = new JList(colorS);
		colorLst.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		this.add(colorLbl, new BorderLayout().NORTH);
		this.add(colorLst);
	}
	
	public double getSubtotal(){
		double subtotal = 0;
		
		if(colorLst.getSelectedIndex() == 0)
			subtotal += 5;
		else if(colorLst.getSelectedIndex() == 1)
			subtotal += 0;
		else if(colorLst.getSelectedIndex() == 2)
			subtotal += 0;
		else if(colorLst.getSelectedIndex() == 3)
			subtotal += 0;
		else if(colorLst.getSelectedIndex() == 4)
			subtotal += 0;
		
		return subtotal;
	}
}
