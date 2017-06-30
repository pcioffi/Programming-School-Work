package DrawRandomCircle;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.event.*;

public class DrawRandomCircleGUI extends JFrame implements ChangeListener {
	private CircleCanvas theCanvas;
    private JTextArea display;
    private JSlider inputS;
    private JPanel contentP;

    public DrawRandomCircleGUI() {
    	super("Random Draw Circle");
    	setSize(200, 250);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setLocationRelativeTo(null);
    	
        theCanvas = new CircleCanvas();
        display = new JTextArea(5, 30);
        display.setPreferredSize(new Dimension(200,50));
        display.setEditable(false);

        display.setText("The Radius is: " + theCanvas.getRadius() +
                        "\nThe Diameter is: " + theCanvas.getDiameter()
                        + "\nThe Area is: " + theCanvas.getArea() +
                        "\nThe Circumference is: " +
                        theCanvas.getCircumference());

        inputS = new JSlider(JSlider.HORIZONTAL, 10, 100, 10);
        inputS.setPreferredSize(new Dimension(200,35));
        inputS.addChangeListener(this);
        inputS.setMajorTickSpacing(50);
        inputS.setMinorTickSpacing(10);
        inputS.setPaintTicks(true);
        
        contentP = new JPanel();
        contentP.setPreferredSize(new Dimension(200,50));
        contentP.add(display, new BorderLayout().NORTH);
        contentP.add(inputS, new BorderLayout().SOUTH);
        
        getContentPane().add(theCanvas, BorderLayout.CENTER);
        getContentPane().add(display, BorderLayout.SOUTH);
        getContentPane().add(inputS, BorderLayout.SOUTH);
        
        setVisible(true);
    }

    public static void main( String args[] ) {
        new DrawRandomCircleGUI();
    }

	@Override
	public void stateChanged(ChangeEvent e) {
		JSlider source = (JSlider) e.getSource();
		if(source.getValueIsAdjusting()){
			int setRadius = source.getValue();
			theCanvas.setRadius(setRadius);
			theCanvas.repaint();
		}
	}
}
