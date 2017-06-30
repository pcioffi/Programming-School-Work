package CellPhonePackages;

import java.awt.*;
import java.awt.event.*;
import java.text.NumberFormat;

import javax.swing.*;

public class CellPhonePackageMenu extends JFrame {
	private JLabel packagecostL, phonecostL, optioncostL, totalL;
    private JTextField packageTF, phoneTF, optionTF, totalTF;
    private JPanel costP, packageP, phoneP, optionP, totalP;
    private double pack, phone, option;

    private JMenuBar menuBar;
    private JMenu fileMenu, textMenu, cellMenu, addMenu;
    private JMenuItem exitItem;
    private JRadioButtonMenuItem plan1, plan2, plan3, phone1, phone2, phone3;
    private JCheckBoxMenuItem option1, option2;
    
    NumberFormat currency = NumberFormat.getCurrencyInstance();

    public CellPhonePackageMenu() {
    	super("Cell Phone Package");
    	setSize(450,190);
    	setLocationRelativeTo(null);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    	//setting up the display panels for the labels and textfields
    	costP = new JPanel();
    	costP.setLayout(new FlowLayout());
    	
    	packagecostL = new JLabel("Package Cost: ");
    	phonecostL = new JLabel("Phone Cost: ");
    	optioncostL = new JLabel("Option Cost: ");
    	totalL = new JLabel("Total: ");
    	
    	packageTF = new JTextField();
    	packageTF.setEditable(false);
    	packageTF.setPreferredSize(new Dimension(200,25));
    	phoneTF = new JTextField();
    	phoneTF.setEditable(false);
    	phoneTF.setPreferredSize(new Dimension(200,25));
    	optionTF = new JTextField();
    	optionTF.setEditable(false);
    	optionTF.setPreferredSize(new Dimension(200,25));
    	totalTF = new JTextField();
    	totalTF.setEditable(false);
    	totalTF.setPreferredSize(new Dimension(200,25));
    	
    	packageTF.setText(currency.format(pack) + " per month");
        phoneTF.setText(currency.format(phone) + " flat payment");
        optionTF.setText(currency.format(option) + " per month");
        totalTF.setText(currency.format(phone) + " (+ " + (currency.format(pack + option)) + " per month)");
    	
    	packageP = new JPanel();
    	packageP.setLayout(new GridLayout(1,2));
    	packageP.add(packagecostL);
    	packageP.add(packageTF);
    	phoneP = new JPanel();
    	phoneP.setLayout(new GridLayout(1,2));
    	phoneP.add(phonecostL);
    	phoneP.add(phoneTF);
    	optionP = new JPanel();
    	optionP.setLayout(new GridLayout(1,2));
    	optionP.add(optioncostL);
    	optionP.add(optionTF);
    	totalP = new JPanel();
    	totalP.setLayout(new GridLayout(1,2));
    	totalP.add(totalL);
    	totalP.add(totalTF);
    	
    	costP.add(packageP);
    	costP.add(phoneP);
    	costP.add(optionP);
    	costP.add(totalP);
    	
      	add(costP);

      	//instantiate menubar
      	menuBar = new JMenuBar();
      	
      	//making the first menu item
      	fileMenu = new JMenu("File");
      	exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(new ExitListener());
        fileMenu.add(exitItem);
        
        //making the second menu item
        textMenu = new JMenu("Packages");
    	ButtonGroup groupPack = new ButtonGroup();
    	
        plan1 = new JRadioButtonMenuItem("300 minutes:$45 per month");
        plan1.addActionListener(new PlanListener());
        plan2 = new JRadioButtonMenuItem("800 minutes:$65 per month");
        plan2.addActionListener(new PlanListener());
        plan3 = new JRadioButtonMenuItem("1500 minutes:$99 per month");
        plan3.addActionListener(new PlanListener());

        groupPack.add(plan1);
        groupPack.add(plan2);
        groupPack.add(plan3);

        textMenu.add(plan1);
        textMenu.add(plan2);
        textMenu.add(plan3);
        
        //making the third menu item
        addMenu = new JMenu("Phones");
        ButtonGroup groupPhone = new ButtonGroup();
    	
        phone1 = new JRadioButtonMenuItem("Model 100:$29.95");
        phone1.addActionListener(new PlanListener());
        phone2 = new JRadioButtonMenuItem("Model 110:$49.95");
        phone2.addActionListener(new PlanListener());
        phone3 = new JRadioButtonMenuItem("Model 200:$99.95");
        phone3.addActionListener(new PlanListener());

        groupPhone.add(phone1);
        groupPhone.add(phone2);
        groupPhone.add(phone3);

        addMenu.add(phone1);
        addMenu.add(phone2);
        addMenu.add(phone3);
        
        //making the fourth menu item
        cellMenu = new JMenu("Add ons");
		
        option1 = new JCheckBoxMenuItem("Voice mail option");
        option1.addActionListener(new PlanListener());
        option2 = new JCheckBoxMenuItem("Text message option");
        option2.addActionListener(new PlanListener());
		
		cellMenu.add(option1);
		cellMenu.add(option2);
        
        //putting the menubar into the frame
        menuBar.add(fileMenu);
        menuBar.add(textMenu);
        menuBar.add(addMenu);
        menuBar.add(cellMenu);

        setJMenuBar(menuBar);
      	
      	setVisible(true);
    }

	private class ExitListener implements ActionListener {
	    public void actionPerformed(ActionEvent e){
	    	System.exit(0);
	    }
    }

    private class PlanListener implements ActionListener {
    	public void actionPerformed(ActionEvent e) {
	        if(e.getSource() == plan1){
	        	if(plan1.isSelected())
	        		pack = 45;
	        	else
	        		pack = 0;
	        }
	        else if(e.getSource() == plan2){
	        	if(plan2.isSelected())
	        		pack = 65;
	        	else
	        		pack = 0;
	        }
	        else if(e.getSource() == plan3){
	        	if(plan3.isSelected())
	        		pack = 99;
	        	else
	        		pack = 0;
	        }
	        
	        if(e.getSource() == phone1){
	        	if(phone1.isSelected())
	        		phone = 29.95;
	        	else
	        		phone = 0;
	        }
	        else if(e.getSource() == phone2){
	        	if(phone2.isSelected())
	        		phone = 49.95;
	        	else
	        		phone = 0;
	        }
	        else if(e.getSource() == phone3){
	        	if(phone3.isSelected())
	        		phone = 99.95;
	        	else
	        		phone = 0;
	        }
	        
	        if(e.getSource() == option1){
	        	if(option1.isSelected())
	        		option += 5;
	        	else
	        		option -= 5;
	        }
	        else if(e.getSource() == option2){
	        	if(option2.isSelected())
	        		option += 10;
	        	else
	        		option -= 10;
	        }
	        
	        packageTF.setText(currency.format(pack) + " per month");
	        phoneTF.setText(currency.format(phone) + " flat payment");
	        optionTF.setText(currency.format(option) + " per month");
	        totalTF.setText(currency.format(phone) + " (+ " + (currency.format(pack + option)) + " per month)");
    	}
    }

    public static void main(String[] args) {
    	new CellPhonePackageMenu();
    }
}