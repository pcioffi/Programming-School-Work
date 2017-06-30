package ShadeDesigner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

public class ShadesDesignerMain extends JFrame implements ActionListener{
	JLabel mainL;
	JPanel styleP, sizeP, colorP, mainP, buttonP;
	Button calcB, exitB;
	JTextField totalTF;
	double total;
	
	NumberFormat currency = NumberFormat.getCurrencyInstance();
	
	public ShadesDesignerMain(){
		setTitle("Shape Designer Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(650,225);
		setLayout(new FlowLayout());
		setLocationRelativeTo(null);
		
		mainL = new JLabel("Shape Designer");
		styleP = new StylesPanel();
		sizeP = new SizesPanel();
		colorP = new ColorsPanel();
		mainP = new JPanel();
		
		mainP.setLayout(new GridLayout(1,3));
		mainP.setPreferredSize(new Dimension(600,110));
		mainP.add(styleP);
		mainP.add(sizeP);
		mainP.add(colorP);
		
		calcB = new Button("Calculate Charges");
		exitB = new Button("Exit");
		totalTF = new JTextField("" + currency.format(50));
		totalTF.setEditable(false);
		totalTF.setPreferredSize(new Dimension(100,25));
		
		calcB.addActionListener(this);
		exitB.addActionListener(new ExitListener());
		
		buttonP = new JPanel();
		buttonP.setLayout(new FlowLayout());
		buttonP.setPreferredSize(new Dimension(300,35));
		buttonP.add(calcB);
		buttonP.add(totalTF);
		buttonP.add(exitB);
		
		add(mainL, new BorderLayout().NORTH);
		add(mainP, new BorderLayout().CENTER);
		add(buttonP, new BorderLayout().SOUTH);
		
		setVisible(true);
	}
	
	public static void main(String args[]){
		new ShadesDesignerMain();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		total = 0;
		
		double styleST = ((StylesPanel) styleP).getSubtotal();
		double sizeST = ((SizesPanel) sizeP).getSubtotal();
		double colorST = ((ColorsPanel) colorP).getSubtotal();
		
		total = styleST + sizeST + colorST + 50;
		totalTF.setText("" + currency.format(total));
	}
	
	private class ExitListener implements ActionListener {
	    @Override
		public void actionPerformed(ActionEvent e) {
	        System.exit(0);
	    }
	}
}

