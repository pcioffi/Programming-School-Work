package tennis;

public class DemoTennisGame {
	public static void main(String[] args){
		/*singles test*/
		//first test
		TennisGame tennisSinglesOne = new TennisGame();
		tennisSinglesOne.setNames("Amy", "Bill");
		tennisSinglesOne.setScores(4, 2);
		print(tennisSinglesOne);
		
		//second test
		TennisGame tennisSinglesTwo = new TennisGame();
		tennisSinglesTwo.setNames("Carl", "Debbie");
		print(tennisSinglesTwo);
		
		//third test
		TennisGame tennisSinglesThree = new TennisGame();
		tennisSinglesThree.setNames("Emily", "Frank");
		tennisSinglesThree.setScores(7, -2);
		print(tennisSinglesThree);
		
		//fourth test
		TennisGame tennisSinglesFour = new TennisGame();
		tennisSinglesFour.setNames("George", "Hannah");
		tennisSinglesFour.setScores(3, 0);
		print(tennisSinglesFour);
		
		/*doubles test*/
		//first test
		DoublesTennisGame tennisDoublesOne = new DoublesTennisGame();	//Tennis Object for doubles
		tennisDoublesOne.setNames("Irene", "Jill", "Ken", "Larry");
		tennisDoublesOne.setScores(4, 1);
		print(tennisDoublesOne);
		
		//second test
		DoublesTennisGame tennisDoublesTwo = new DoublesTennisGame();	//Tennis Object for doubles
		tennisDoublesTwo.setNames("Mike", "Nick", "Olivia", "Pam");
		tennisDoublesTwo.setScores(4, 4);								//produces an error since both players can't win
		print(tennisDoublesTwo);
		
		//third test
		DoublesTennisGame tennisDoublesThree = new DoublesTennisGame();	//Tennis Object for doubles
		tennisDoublesThree.setNames("Quentin", "Rob", "Sandra", "Teresa");
		tennisDoublesThree.setScores(-7, 3);
		print(tennisDoublesThree);
		
		//fourth test
		DoublesTennisGame tennisDoublesFour = new DoublesTennisGame();	//Tennis Object for doubles
		tennisDoublesFour.setNames("Ursula", "Violet", "Will", "Xander");
		tennisDoublesFour.setScores(3, 0);
		print(tennisDoublesFour);
		
	}
	
	//methods for printing classes
	public static void print(TennisGame tennis){
		System.out.println("Tennis game between two players");
		System.out.println(tennis.getPlayerOneName() + " and " + tennis.getPlayerTwoName());
		System.out.println("Score: " + tennis.getPlayerOneScoreInt() + " to " + tennis.getPlayerTwoScoreInt());
		System.out.println("Score: " + tennis.getPlayerOneScoreString() + " to " + tennis.getPlayerTwoScoreString());
		System.out.println();
	}
	public static void print(DoublesTennisGame tennis){
		System.out.println("Tennis game between four players");
		System.out.println(tennis.getPlayerOneName() + " and " + tennis.getPartnerOne()+ " and " + tennis.getPlayerTwoName() + " and " + tennis.getPartnerTwo());
		System.out.println("Score: " + tennis.getPlayerOneScoreInt() + " to " + tennis.getPlayerTwoScoreInt());
		System.out.println("Score: " + tennis.getPlayerOneScoreString() + " to " + tennis.getPlayerTwoScoreString());
		System.out.println();
	}
}
