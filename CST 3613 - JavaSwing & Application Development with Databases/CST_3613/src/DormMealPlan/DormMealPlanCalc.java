package DormMealPlan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.NumberFormat;

public class DormMealPlanCalc extends JFrame implements ActionListener {
	JComboBox dormCB, mealCB;
	String[] dormSA = {"Allen Hall ($1,500)", "Pike Hall ($1,600)", "Farthing Hall ($1,200)", "University Suites ($1,800)"};
	String[] mealSA = {"7 Meals Per Week ($560)", "14 Meals Per Week ($1,095)", "Unlimited Meals ($1,500)"};
	JLabel dormL, mealL, totalL;
	JButton totalB;
	JTextField totalTF;
	int total;
	JPanel dormP, mealP, totalP;
	
	public DormMealPlanCalc(){
		setTitle("Dorm and Meal Plan");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(275,200);
		setLayout(new FlowLayout());
		
		dormCB = new JComboBox(dormSA);
		mealCB = new JComboBox(mealSA);
		
		dormL = new JLabel("Dorms");
		dormP = new JPanel();
		dormP.setLayout(new GridLayout(2,1));
		dormP.setPreferredSize(new Dimension(250,50));
		dormP.add(dormL);
		dormP.add(dormCB);
		
		mealL = new JLabel("Meals");
		mealP = new JPanel();
		mealP.setLayout(new GridLayout(2,1));
		mealP.setPreferredSize(new Dimension(250,50));
		mealP.add(mealL);
		mealP.add(mealCB);
		
		totalB = new JButton("Calculate");
		totalB.addActionListener(this);
		totalB.setPreferredSize(new Dimension(100,25));
		totalTF = new JTextField();
		totalTF.setPreferredSize(new Dimension(100,25));
		totalTF.setEditable(false);
		totalP = new JPanel();
		totalP.setLayout(new FlowLayout());
		totalP.setPreferredSize(new Dimension(250,35));
		totalP.add(totalB);
		totalP.add(totalTF);
			
		add(dormP);
		add(mealP);
		add(totalP);
		
		setVisible(true);
	}
	
	public static void main(String args[]){
		new DormMealPlanCalc();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		total = 0;
		
		//checks the dorm combo box selection
		if(dormCB.getSelectedItem() == dormSA[0])
			total += 1500;
		else if(dormCB.getSelectedItem() == dormSA[1])
			total += 1600;
		else if(dormCB.getSelectedItem() == dormSA[2])
			total += 1200;
		else if(dormCB.getSelectedItem() == dormSA[3])
			total += 1800;
		
		//checks the meal combo box selection
		if(mealCB.getSelectedItem() == mealSA[0])
			total += 560;
		else if(mealCB.getSelectedItem() == mealSA[1])
			total += 1095;
		else if(mealCB.getSelectedItem() == mealSA[2])
			total += 1500;
		
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		totalTF.setText("" + currency.format(total));
	}
}
