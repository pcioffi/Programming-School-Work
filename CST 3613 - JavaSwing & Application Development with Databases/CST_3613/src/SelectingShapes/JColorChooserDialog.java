package SelectingShapes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JColorChooserDialog extends JFrame{
	
	
	
	private JComboBox shapesList;
	private JButton selectColor;
	private JPanel panel;
	private final int circle = 0;
	private final int square = 1;
	private final int oval = 2;
	private final int rectangle = 3;
	private final int size = 400;
	
	private String [] shapesNames = {"Random_Cirles", "Random_Squares", "Random_Ovals", "Random_Rectangles"};
	private Color color;
	private int select;
	
	public JColorChooserDialog(){
		shapesList = new JComboBox(shapesNames);
		shapesList.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				set(shapesList.getSelectedIndex());
				repaint();
			}
		});
		
		selectColor = new JButton("select a color");
		selectColor.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				color = JColorChooser.showDialog(null, "Select Color", Color.RED);
				repaint();
			}
		});
		
		panel = new JPanel();
		panel.setLayout(new GridLayout(1, 2));
		panel.add(shapesList);
		panel.add(selectColor);
		
		
		getContentPane().add(panel, BorderLayout.SOUTH);
		setSize(size + 20, size + 70);
		setVisible(true);
		
	}
	public void paint(Graphics g){
		int first, second;
		int h, w, diameter;
		super.paint(g);
		for (int count = 1; count <= 20; count++){
			first = (int)(Math.random()*size) + 10;
			second = (int)(Math.random()*size)+25;
			w = (int)(Math.random()*(size - first));
			h = (int)(Math.random() *(size - second));
			diameter = w;
			if(w > h)
				diameter = h;
			g.setColor(color);
			
			switch(select){
			case circle: g.drawOval(first, second, diameter, diameter);
			break;
			case square: g.drawRect(first, second, diameter, diameter);
			break;
			case oval: g.drawOval(first, second, w, h);
			break;
			case rectangle: g.drawRect(first, second, w, h);
			break;
			}
		}
		
	}
	
	public void set(int s){
		select = s;
		
	}
	public static void main(String[] args){
		JColorChooserDialog s = new JColorChooserDialog();
		s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
