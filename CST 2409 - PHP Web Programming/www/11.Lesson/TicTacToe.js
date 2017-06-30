// fileName: TicTacToe.js

function TicTacToe(pMoves){
	this.moves = pMoves;
	
	{
	alert("aaa");
	}
	
	this.getWinner = function(){
		return true;
	}
	
	this.getWhoWon = function(){
			return "X";
	}
	
	this.getWinningCombo = function(){
		alert(this.moves);
		
		var theWinner = {p1:1, p2:6, p3:7};
		return theWinner;
	}
}