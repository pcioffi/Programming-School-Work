package RandomNumberGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class RandomNumberGameGUI extends JFrame implements ActionListener{
	private JLabel oneL, twoL, threeL, vicinityL;
    private JTextField inputTF;
    private JPanel introP, inputFieldP;
    private JButton gamestartB;
    private int number, input;
    
    private final Color RED = new Color(215,90,90);
    private final Color BLUE = new Color(90,90,215);
    private final Color GREEN = new Color(90,215,90);

    public RandomNumberGameGUI() {
    	super("Random-Number Guessing Game");
    	setSize(250,250);
    	setLocationRelativeTo(null);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setLayout(new FlowLayout());
    	
    	number = 0;
    	
    	oneL = new JLabel("I have a number between 1 and 1000");
    	twoL = new JLabel("Can you guess my number?");
    	threeL = new JLabel("Please enter your first guess:");
    	
    	introP = new JPanel();
    	introP.setLayout(new FlowLayout());
    	introP.setPreferredSize(new Dimension(250,75));
    	introP.add(oneL);
    	introP.add(twoL);
    	introP.add(threeL);
    	
    	inputTF = new JTextField();
    	inputTF.setPreferredSize(new Dimension(200,35));
    	inputTF.setHorizontalAlignment(JTextField.CENTER);
    	inputTF.addActionListener(this);
    	inputTF.setEnabled(false);
    	inputTF.setToolTipText("1-1000");
    	vicinityL = new JLabel();
    	
    	inputFieldP = new JPanel();
    	inputFieldP.setLayout(new FlowLayout());
    	inputFieldP.setPreferredSize(new Dimension(200,85));
    	inputFieldP.add(inputTF);
    	inputFieldP.add(vicinityL);
    	
    	gamestartB = new JButton("Start Game");
    	gamestartB.addActionListener(new newGameListener());

    	add(introP);
    	add(inputFieldP);
    	add(gamestartB);

    	setVisible(true);
    }
    
	@Override
	public void actionPerformed(ActionEvent arg0) {
		int input = Integer.parseInt(inputTF.getText());
		int difference = number - input;
		
		if(input == number){
			vicinityL.setText("Correct!");
			gamestartB.setText("New Game");
		}
		else if(input < number){
			vicinityL.setText("Too Low!");
		}
		else{
			vicinityL.setText("Too High!");
		}
		
		if(difference == 0){
			getContentPane().setBackground(GREEN);
	    	introP.setBackground(GREEN);
	    	inputFieldP.setBackground(GREEN);
	    	
	    	inputTF.setEnabled(false);
		}
		else if((difference > -50 && difference < 50)){
			getContentPane().setBackground(RED);
	    	introP.setBackground(RED);
	    	inputFieldP.setBackground(RED);
		}
		else{
			getContentPane().setBackground(BLUE);
	    	introP.setBackground(BLUE);
	    	inputFieldP.setBackground(BLUE);
		}
	}
	
	private class newGameListener implements ActionListener {
	    @Override
		public void actionPerformed(ActionEvent e) {
	    	getContentPane().setBackground(null);
	    	introP.setBackground(null);
	    	inputFieldP.setBackground(null);
	    	
	    	inputTF.setEnabled(true);
	    	inputTF.setText("");
	    	vicinityL.setText("");
	    	
	    	Random r = new Random();
	    	number = r.nextInt(1000) + 1;
	    	
	    	gamestartB.setText("Reset Game");
	    }
	}
	
    public static void main(String args[]){
    	new RandomNumberGameGUI();
    }
}
