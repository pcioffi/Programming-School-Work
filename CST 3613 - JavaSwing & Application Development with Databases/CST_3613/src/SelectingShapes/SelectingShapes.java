package SelectingShapes;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.Random;
import javax.swing.*;
  
public class SelectingShapes extends JFrame
{
    public SelectingShapes()
    {
        super("Selecting Shapes");
        final ComboPanel comboPanel = new ComboPanel();
        String[] shapeItems = {
            "square", "oval", "rectangle", "circle"
        };

        JComboBox shapeBox = new JComboBox(shapeItems);
        shapeBox.addItemListener(new ItemListener()
        {
            public void itemStateChanged(ItemEvent e)
            {
                if(e.getStateChange() == ItemEvent.SELECTED)
                {
                    String item = (String)e.getItem();
                    if(item.equals("square"))
                        comboPanel.makeSquares();
                    if(item.equals("oval"))
                        comboPanel.makeOvals();
                    if(item.equals("rectangle"))
                        comboPanel.makeRectangles();
                    if(item.equals("circle"))
                        comboPanel.makeCircles();
                }
            }
        });
        JPanel southPanel = new JPanel();
        southPanel.add(shapeBox);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().add(comboPanel, "Center");
        getContentPane().add(southPanel, "South");
        setSize(400,400);
        setVisible(true);
    }
  
    private class ComboPanel extends JPanel
    {
        int w, h;
        Random seed;
        static final int
            OVAL = 0,
            RECT = 1;
        int shapeType = -1;
  
        public ComboPanel()
        {
            seed = new Random();
            setBackground(Color.white);
        }
  
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D)g;
            int width = getWidth();
            int height = getHeight();
            int x, y;
            Shape s = null;
            for(int i = 0; i < 20; i++)
            {
                x = seed.nextInt(width - w);
                y = seed.nextInt(height - h);
                switch(shapeType)
                {
                    case OVAL:
                        s = new Ellipse2D.Double(x, y, w, h);
                        break;
                    case RECT:
                        s = new Rectangle2D.Double(x, y, w, h);
                }
                if(shapeType > -1)
                    g2.draw(s);
            }
        }
  
        public void makeSquares()
        {
            shapeType = RECT;
            w = 50;
            h = 50;
            repaint();
        }
  
        public void makeOvals()
        {
            shapeType = OVAL;
            w = 80;
            h = 60;
            repaint();
        }
  
        public void makeRectangles()
        {
            shapeType = RECT;
            w = 80;
            h = 40;
            repaint();
        }
  
        public void makeCircles()
        {
            shapeType = OVAL;
            w = 75;
            h = 75;
            repaint();
        }
    }
  
    public static void main(String[] args)
    {
        new SelectingShapes();
    }
}