package LamertsVacationRental;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
 
public class JVacationRental extends JFrame implements ActionListener {
 
   JRadioButton loc1;
   JRadioButton loc2;
   JRadioButton loc3;
   JCheckBox meals;
   JCheckBox none;
   JRadioButton room1;
   JRadioButton room2;
   JRadioButton room3;
   JTextField finaltotal = new JTextField(8);
   final int parkside = 600, poolside = 750, lakeside = 825;
   final int plusmeals = 200, onebed = 0, twobed = 75, threebed = 150;
   int total = 0;
 
   public JVacationRental() {
       super("Lamberts Vacation Rentals");
       setSize(200, 350);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
       JPanel panel = new JPanel();
       add(panel);
       JLabel vacation = new JLabel("Lamberts Vacation Rental");
       JLabel price = new JLabel("The price for your vacation is: ");
 
       loc1 = new JRadioButton("Parkside $600");
       loc2 = new JRadioButton("Poolside $750");
       loc3 = new JRadioButton("Lakeside $825");
       meals = new JCheckBox("Include meals for $200");
       none = new JCheckBox("Do NOT include meals");
       room1 = new JRadioButton("One Bedroom");
       room2 = new JRadioButton("Two bedrooms (add $75)");
       room3 = new JRadioButton("Three bedrooms (add $150)");
 
       ButtonGroup location = new ButtonGroup();
       location.add(loc1);
       location.add(loc2);
       location.add(loc3);
       panel.add(vacation);
       panel.add(loc1);
       panel.add(loc2);
       panel.add(loc3);
       ButtonGroup addmeals = new ButtonGroup();
       addmeals.add(meals);
       addmeals.add(none);
       panel.add(meals);
       panel.add(none);
       ButtonGroup bedrooms = new ButtonGroup();
       bedrooms.add(room1);
       bedrooms.add(room2);
       bedrooms.add(room3);
       panel.add(room1);
       panel.add(room2);
       panel.add(room3);
       panel.add(price);
       finaltotal.setEditable(false);
       panel.add(finaltotal);

       loc1.addActionListener(this);
       loc2.addActionListener(this);
       loc3.addActionListener(this);
       meals.addActionListener(this);
       none.addActionListener(this);
       room1.addActionListener(this);
       room2.addActionListener(this);
       room3.addActionListener(this);
       
       setVisible(true);
   }
 
   public void actionPerformed(ActionEvent e) {
 
       if(loc1.isSelected()) {
           total = parkside;
       }
       else if(loc2.isSelected()) {
           total = poolside;
       }
       if(loc3.isSelected()) {
           total = lakeside;
       }
       if(room1.isSelected()) {
           total += onebed;
       }
       else if(room2.isSelected()) {
           total += twobed;
       }
       if(room3.isSelected()) {
           total += threebed;
       }
       if(meals.isSelected()) {
           total += plusmeals;
       }
       else if(none.isSelected()) {
           total -= 0;
       }
 
       finaltotal.setText("$" + total);
   }
   
   public static void main(String[] args) {
       new JVacationRental();
   }
}