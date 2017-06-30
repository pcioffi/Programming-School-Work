package KochsCottageRental;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class KochsCottage extends JFrame implements ItemListener {
	final int ONE_BEDROOM = 600;
	final int TWO_BEDROOM = 850;
	final int ROW_BOAT = 60;
    final int WIDTH = 400;
    final int HEIGHT = 200;
	int totalPrice = 0;
	Font titleFont = new Font("Arial", Font.BOLD, 18);
	Font subTitleFont = new Font("Arial", Font.ITALIC, 14);
 

	JCheckBox oneBedroom = new JCheckBox("One-bedroom cottage for one week is $" + ONE_BEDROOM + ".", false);
	JCheckBox twoBedroom = new JCheckBox("Two-bedroom cottage for one week is $" + TWO_BEDROOM + ".", false);
	JCheckBox rowBoat = new JCheckBox("One week rowboat rental is $" + ROW_BOAT + ".", false);

	ButtonGroup aGroup = new ButtonGroup();
  
	JLabel kochCottageLabel = new JLabel("Koch's Cottages Weekend Getaway");
	JLabel priceLabel = new JLabel("Your total price for one week stay is:");
	JTextField totPrice = new JTextField(5);
	JLabel optionExplainLabel = new JLabel("Please check the options you want for your vacation!");
 
	public KochsCottage(){
	    super("Koch's Cottages Vacation");
	    setSize(WIDTH, HEIGHT);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setLayout(new FlowLayout());
    
	    add(kochCottageLabel);
	    kochCottageLabel.setFont(titleFont);
	    add(optionExplainLabel);
	    optionExplainLabel.setFont(subTitleFont);
   
	    aGroup.add(oneBedroom);
	    aGroup.add(twoBedroom);
	    
	    add(oneBedroom);
	    add(twoBedroom);
	    add(rowBoat);
	    add(priceLabel);
	    add(totPrice);
	
	    totPrice.setEditable(false);
	    totPrice.setText("$" + totalPrice);
	    oneBedroom.addItemListener(this);
	    twoBedroom.addItemListener(this);
	    rowBoat.addItemListener(this);     
	    
	    setVisible(true);
	}
 
	public void itemStateChanged(ItemEvent event){
	    Object source = event.getSource();
	    int select = event.getStateChange();
	     
	    if(source == oneBedroom)
	       if(select == ItemEvent.SELECTED)
	          totalPrice += ONE_BEDROOM;
	       else
	          totalPrice -= ONE_BEDROOM;
	    else if(source == twoBedroom){
	       if(select == ItemEvent.SELECTED)
	          totalPrice += TWO_BEDROOM;
	       else
	          totalPrice -= TWO_BEDROOM;
	    }
	    else if (source == rowBoat){
	       if(select == ItemEvent.SELECTED)
	          totalPrice += ROW_BOAT;
	       else
	          totalPrice -= ROW_BOAT;
	    }
	    
	    totPrice.setText("$" + totalPrice);
	}
 
	public static void main(String[] args){
		KochsCottage aFrame = new KochsCottage();
	}
}