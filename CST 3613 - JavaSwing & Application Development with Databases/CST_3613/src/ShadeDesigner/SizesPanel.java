package ShadeDesigner;

import javax.swing.*;
import java.awt.*;

public class SizesPanel extends JPanel{
	JLabel sizeLbl;
	JList sizeLst;
	String[] sizesS = {"25 Inches Wide: Add $0", "27 Inches Wide: Add $2", "32 Inches Wide: Add $4", "40 Inches Wide: Add $6"};
	
	public SizesPanel(){
		this.setBorder(BorderFactory.createTitledBorder(""));
		this.setLayout(new BorderLayout());
		
		sizeLbl = new JLabel("Sizes:");
		sizeLst = new JList(sizesS);
		sizeLst.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		this.add(sizeLbl, new BorderLayout().NORTH);
		this.add(sizeLst);
	}
	
	public double getSubtotal(){
		double subtotal = 0;
		
		if(sizeLst.getSelectedIndex() == 0)
			subtotal += 0;
		else if(sizeLst.getSelectedIndex() == 1)
			subtotal += 2;
		else if(sizeLst.getSelectedIndex() == 2)
			subtotal += 4;
		else if(sizeLst.getSelectedIndex() == 3)
			subtotal += 6;
		
		return subtotal;
	}
}
