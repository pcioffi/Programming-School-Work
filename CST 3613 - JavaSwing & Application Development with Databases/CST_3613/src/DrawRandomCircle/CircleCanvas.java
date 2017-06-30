package DrawRandomCircle;

import java.awt.Graphics;

import javax.swing.JPanel;

public class CircleCanvas extends JPanel {
    public int radius;

    public CircleCanvas() {
//    	radius = (int)(Math.floor(Math.random() * (100 - 10)) + 10);
    	radius = 10;
        setSize(100,100);
    }

    public void setRadius(int radius){
    	this.radius = radius;
    }
    
    public void paintComponent(Graphics g) {
	    g.drawOval(0, 0, radius, radius);
	}

    public int getDiameter() {
    	return (2 * radius);
    }

    public int getCircumference() {
    	return (int)(2 * Math.PI * radius);
    }

    public int getArea() {
    	return (int)(radius * radius * Math.PI);
    }

    public int getRadius() {
	   return radius;
    }
}