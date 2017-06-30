package AlphabetButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JFileCabinet extends JFrame implements ActionListener {
    final int WIDTH = 500;
    final int HEIGHT = 300;
	private int x;
	private JButton[] alphaButton = new JButton[26];
	private String[] file = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K",
                          	 "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
                          	 "W", "X", "Y", "Z"};
    
	private JPanel panel01 = new JPanel(new GridLayout(1, 6));
	private JPanel panel02 = new JPanel(new GridLayout(1, 6));
	private JPanel panel03 = new JPanel(new GridLayout(1, 6));
	private JPanel panel04 = new JPanel(new GridLayout(1, 6));
	private JPanel panel05 = new JPanel(new GridLayout(1, 6));
	 
	JLabel folderMove = new JLabel("   Folder");
	 
	public JFileCabinet(){
	    super("Alpha File Cabinet");
	    setSize(WIDTH, HEIGHT);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setLayout(new GridLayout(5, 1));
	    add(panel01);
	    add(panel02);
	    add(panel03);
	    add(panel04);
	    add(panel05);
	    
	    for(x = 0; x < file.length; ++x)
	       alphaButton[x] = new JButton(file[x]); 	          
	    for(x = 0; x < 6; ++x)
	       panel01.add(alphaButton[x]);	    
	    for(x = 6; x < 12; ++x)
	       panel02.add(alphaButton[x]);	    
	    for(x = 12; x < 18; ++x)
	       panel03.add(alphaButton[x]);	       
	    for(x = 18; x < 24; ++x)
	       panel04.add(alphaButton[x]);	    
	    for(x = 24; x < 26; ++x)
	       panel05.add(alphaButton[x]);
	    
	    panel05.add(folderMove);
	    
	    for(x = 0; x < alphaButton.length; ++x)
	       alphaButton[x].addActionListener(this);
	       
	    setVisible(true);
	}
	 
	public void actionPerformed(ActionEvent e){
	    Object source = e.getSource();
	    for(x = 0; x < file.length; ++x){
		    if(source == alphaButton[x]){
		       folderMove.setText("   Folder " + file[x]);
		    }
	    }
	}
	 
	public static void main(String[] args){
	    JFileCabinet alphaFileCabinet = new JFileCabinet();
	}
}