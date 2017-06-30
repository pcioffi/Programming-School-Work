package ConstructionCompany;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.NumberFormat;

public class ConstructionCompanyCalc extends JFrame implements ItemListener{
	JCheckBox aspenRB, brittanyRB, colonialRB, dartmoorRB;
	JRadioButton twobedRB, threebedRB, fourbedRB;
	JRadioButton zeroGRB, oneGRB, twoGRB, threeGRB, fourGRB;
	ButtonGroup modelBG, bedroomBG, garageBG;
	JPanel modelP, bedroomP, garageP, totalP;
	JLabel totalL;
	JTextField totalTF;
	int total;
	
	public ConstructionCompanyCalc(){
		setTitle("Contract Order");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(450,400);
		setLayout(new FlowLayout());
		
		//intialize RadioGroups
		modelBG = new ButtonGroup();
		bedroomBG = new ButtonGroup();
		garageBG = new ButtonGroup();
		
		//initialize buttons & add listeners
		aspenRB = new JCheckBox("Aspen ($100,000)");			aspenRB.addItemListener(this);
		brittanyRB = new JCheckBox("Brittany ($120,000)");		brittanyRB.addItemListener(this);
		colonialRB = new JCheckBox("Colonial ($180,000)");		colonialRB.addItemListener(this);
		dartmoorRB = new JCheckBox("Dartmoor ($250,000)");		dartmoorRB.addItemListener(this);
		
		twobedRB = new JRadioButton("Two ($21,000)");			twobedRB.addItemListener(this);
		threebedRB = new JRadioButton("Three ($31,500)");		threebedRB.addItemListener(this);
		fourbedRB = new JRadioButton("Four ($42,000)");			fourbedRB.addItemListener(this);
		
		zeroGRB = new JRadioButton("Zero ($0)");				zeroGRB.addItemListener(this);
		oneGRB = new JRadioButton("One ($7,775)");				oneGRB.addItemListener(this);
		twoGRB = new JRadioButton("Two ($15,550)");				twoGRB.addItemListener(this);
		threeGRB = new JRadioButton("Three ($23,325)");			threeGRB.addItemListener(this);
		fourGRB = new JRadioButton("Four ($31,100)");			fourGRB.addItemListener(this);
		
		//add buttons to buttongroups
		modelBG.add(aspenRB);
		modelBG.add(brittanyRB);
		modelBG.add(colonialRB);
		modelBG.add(dartmoorRB);
		
		bedroomBG.add(twobedRB);
		bedroomBG.add(threebedRB);
		bedroomBG.add(fourbedRB);
		
		garageBG.add(zeroGRB);
		garageBG.add(oneGRB);
		garageBG.add(twoGRB);
		garageBG.add(threeGRB);
		garageBG.add(fourGRB);
		
		//setup panels
		modelP = new JPanel();
		modelP.setBorder(BorderFactory.createTitledBorder("Model"));
		modelP.setLayout(new GridLayout(2,2));
		modelP.setPreferredSize(new Dimension(400,100));
		modelP.add(aspenRB);
		modelP.add(brittanyRB);
		modelP.add(colonialRB);
		modelP.add(dartmoorRB);
		
		bedroomP = new JPanel();
		bedroomP.setBorder(BorderFactory.createTitledBorder("Bedroom"));
		bedroomP.setLayout(new GridLayout(1,3));
		bedroomP.setPreferredSize(new Dimension(400,100));
		bedroomP.add(twobedRB);
		bedroomP.add(threebedRB);
		bedroomP.add(fourbedRB);
		
		garageP = new JPanel();
		garageP.setBorder(BorderFactory.createTitledBorder("Garage"));
		garageP.setLayout(new GridLayout(2,3));
		garageP.setPreferredSize(new Dimension(400,100));
		garageP.add(zeroGRB);
		garageP.add(oneGRB);
		garageP.add(twoGRB);
		garageP.add(threeGRB);
		garageP.add(fourGRB);
		
		totalL = new JLabel("Total: ");
		totalTF = new JTextField();
		totalTF.setEditable(false);
		totalP = new JPanel();
		totalP.setLayout(new GridLayout(1,2));
		totalP.setPreferredSize(new Dimension(200,25));
		totalP.add(totalL);
		totalP.add(totalTF);
		
		add(modelP);
		add(bedroomP);
		add(garageP);
		add(totalP);
		
		setVisible(true);
	}
	public static void main(String args[]){
		new ConstructionCompanyCalc();
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		Object source = e.getSource();
		int select = e.getStateChange();
		//aspenRB, brittanyRB, colonialRB, dartmoorRB, twobedRB, threebedRB, fourbedRB, zeroGRB, oneGRB, twoGRB, threeGRB, fourGRB;
		
		//models
		if(source == aspenRB)
			if(select == ItemEvent.SELECTED)
				total += 100000;
			else
				total -= 100000;
		else if(source == brittanyRB)
			if(select == ItemEvent.SELECTED)
				total += 120000;
			else
				total -= 120000;
		else if(source == colonialRB)
			if(select == ItemEvent.SELECTED)
				total += 180000;
			else
				total -= 180000;
		else if(source == dartmoorRB)
			if(select == ItemEvent.SELECTED)
				total += 250000;
			else
				total -= 250000;
		
		//bedrooms
		else if(source == twobedRB)
			if(select == ItemEvent.SELECTED)
				total += 21000;
			else
				total -= 21000;
		else if(source == threebedRB)
			if(select == ItemEvent.SELECTED)
				total += 31500;
			else
				total -= 31500;
		else if(source == fourbedRB)
			if(select == ItemEvent.SELECTED)
				total += 42000;
			else
				total -= 42000;
		
		//garages
		if(source == zeroGRB)
			if(select == ItemEvent.SELECTED)
				total += 0;
			else
				total -= 0;
		else if(source == oneGRB)
			if(select == ItemEvent.SELECTED)
				total += 7775;
			else
				total -= 7775;
		else if(source == twoGRB)
			if(select == ItemEvent.SELECTED)
				total += 15550;
			else
				total -= 15550;
		else if(source == threeGRB)
			if(select == ItemEvent.SELECTED)
				total += 23325;
			else
				total -= 23325;
		else if(source == fourGRB)
			if(select == ItemEvent.SELECTED)
				total += 31100;
			else
				total -= 31100;
		
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		totalTF.setText("" + currency.format(total));
		
	}
}
