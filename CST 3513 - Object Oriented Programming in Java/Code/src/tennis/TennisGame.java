package tennis;

public class TennisGame {
	private String playerOne, playerTwo, scoreOneStr = "love", scoreTwoStr = "love";
	private int scoreOneInt, scoreTwoInt;
	
	//get methods
	public String getPlayerOneName(){
		return playerOne;
	}
	public String getPlayerTwoName(){
		return playerTwo;
	}
	public String getPlayerOneScoreString(){
		return scoreOneStr;
	}
	public String getPlayerTwoScoreString(){
		return scoreTwoStr;
	}
	public int getPlayerOneScoreInt(){
		return scoreOneInt;
	}
	public int getPlayerTwoScoreInt(){
		return scoreTwoInt;
	}
	
	//set methods
	public void setNames(String playerOne, String playerTwo){
		this.playerOne = playerOne;
		this.playerTwo = playerTwo;
	}
	public void setScores(int scoreOneInt, int scoreTwoInt){
		//check if score is in the range of 0-4
		if(scoreOneInt >= 0 && scoreOneInt <= 4 && scoreTwoInt >= 0 && scoreTwoInt <= 4){
			this.scoreOneInt = scoreOneInt;
			switch(scoreOneInt){
			case 0:
				this.scoreOneStr = "love";
				break;
			case 1:
				this.scoreOneStr = "15";
				break;
			case 2:
				this.scoreOneStr = "30";
				break;
			case 3:
				this.scoreOneStr = "40";
				break;
			case 4:
				this.scoreOneStr = "game";
				break;
			default:
				this.scoreOneStr = "error";
				break;
			}
			
			this.scoreTwoInt = scoreTwoInt;
			switch(scoreTwoInt){
			case 0:
				this.scoreTwoStr = "love";
				break;
			case 1:
				this.scoreTwoStr = "15";
				break;
			case 2:
				this.scoreTwoStr = "30";
				break;
			case 3:
				this.scoreTwoStr = "40";
				break;
			case 4:
				this.scoreTwoStr = "game";
				break;
			default:
				this.scoreTwoStr = "error";
				break;
			}
		}
		else{
			this.scoreOneInt = 0;
			this.scoreOneStr = "error";
			
			this.scoreTwoInt = 0;
			this.scoreTwoStr = "error";
		}
		
		//check if both Score One and Score Two are equal to 4
		if(scoreOneInt == 4 && scoreOneInt == scoreTwoInt){
			this.scoreOneInt = 0;
			this.scoreOneStr = "error";
			
			this.scoreTwoInt = 0;
			this.scoreTwoStr = "error";
		}
	}
}
