package tennis;

public class DoublesTennisGame extends TennisGame{
	private String partnerOne, partnerTwo;
	
	//get methods
	public String getPartnerOne(){
		return partnerOne;
	}
	public String getPartnerTwo(){
		return partnerTwo;
	}
	
	//override parent class method 'setNames()'
	public void setNames(String playerOne, String partnerOne, String playerTwo, String partnerTwo){
		super.setNames(playerOne, playerTwo);
		this.partnerOne = partnerOne;
		this.partnerTwo = partnerTwo;
	}
}