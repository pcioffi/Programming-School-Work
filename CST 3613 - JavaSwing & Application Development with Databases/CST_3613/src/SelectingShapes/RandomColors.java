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

public class RandomColors extends JFrame{
	private JComboBox shapesList;
	private JButton selectColor;
	private JPanel panel;
	private final int circle = 0;
	private final int square = 1;
	private final int oval = 2;
	private final int rectangle = 3;
	private final int size = 400;
	
	private String [] shapesNames = {"Random_Cirles", "Random_Squares", "Random_Ovals", "Random_Rectangles"};
	private Color colors[] = {Color.white, Color.yellow,Color.red,Color.green, Color.blue,
							Color.PINK, Color.gray, Color.lightGray, Color.CYAN,
							Color.black, Color.MAGENTA, Color.darkGray, Color.orange};
	private int select;
	
	public RandomColors(){
		shapesList = new JComboBox(shapesNames);
		shapesList.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				set(shapesList.getSelectedIndex());
				repaint();
			}
		});
		
		getContentPane().add(shapesList, BorderLayout.SOUTH);
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
			
			int color = (int)(Math.random() * colors.length);
			g.setColor(colors[color]);
			
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
		RandomColors s = new RandomColors();
		s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
