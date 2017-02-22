
public class TennisGame2 implements TennisGame
{
    public int player1Points = 0;
    public int player2Points = 0;
    
    public String P1res = "";
    public String P2res = "";
    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String convertScoreToLiteral(){
        String literal = "";
        literal = isTiedNotDeuce(literal);
        
        literal = isDeuce(literal);
        
        literal = player1IsWinning(literal);
        
        
        literal = player2IsWinnig(literal);
        
        literal = player1Wins(literal);
        
        literal = player2Wins(literal);
        
        literal = advantagePlayer1(literal);
        
        literal = advantagePlayer2(literal);
        
       
        literal = playerWins(literal);
        return literal;
    }
    

	private String playerWins(String score) {
		if (isGamePoint(player1Points, player2Points) && differenceOfTwoPoints(player2Points, player1Points))
        {
            score = "Win for player2";
        }
		if (isGamePoint(player2Points, player1Points) && differenceOfTwoPoints(player1Points, player2Points))
        {
            score = "Win for player1";
        }
		return score;
	}

	


	

	private boolean isGamePoint(int player1Points, int player2Points) {
		return player2Points>=4 && player1Points>=0;
	}
	
	private boolean differenceOfTwoPoints(int player1Points, int player2Points) {
		return (player1Points-player2Points)>=2;
	}

	private String advantagePlayer2(String score) {
		if (player2Points > player1Points && player1Points >= 3)
        {
            score = "Advantage player2";
        }
		return score;
	}

	private String advantagePlayer1(String score) {
		if (player1Points > player2Points && player2Points >= 3)
        {
            score = "Advantage player1";
        }
		return score;
	}

	private String player2Wins(String score) {
		if (player2Points>player1Points && player2Points < 4)
        {
            if (player2Points==2)
                P2res="Thirty";
            if (player2Points==3)
                P2res="Forty";
            if (player1Points==1)
                P1res="Fifteen";
            if (player1Points==2)
                P1res="Thirty";
            score = P1res + "-" + P2res;
        }
		return score;
	}

	private String player1Wins(String score) {
		if (player1Points>player2Points && player1Points < 4)
        {
            if (player1Points==2)
                P1res="Thirty";
            if (player1Points==3)
                P1res="Forty";
            if (player2Points==1)
                P2res="Fifteen";
            if (player2Points==2)
                P2res="Thirty";
            score = P1res + "-" + P2res;
        }
		return score;
	}

	private String player2IsWinnig(String score) {
		if (player2Points > 0 && player1Points==0)
        {
            if (player2Points==1)
                P2res = "Fifteen";
            if (player2Points==2)
                P2res = "Thirty";
            if (player2Points==3)
                P2res = "Forty";
            
            P1res = "Love";
            score = P1res + "-" + P2res;
        }
		return score;
	}

	private String player1IsWinning(String score) {
		if (player1Points > 0 && player2Points==0)
        {
            if (player1Points==1)
                P1res = "Fifteen";
            if (player1Points==2)
                P1res = "Thirty";
            if (player1Points==3)
                P1res = "Forty";
            
            P2res = "Love";
            score = P1res + "-" + P2res;
        }
		return score;
	}

	private String isDeuce(String score) {
		if (player1Points==player2Points && player1Points>=3)
            score = "Deuce";
		return score;
	}

	private String isTiedNotDeuce(String score) {
		if (player1Points == player2Points && player1Points < 4)
        {
            if (player1Points==0)
                score = "Love";
            if (player1Points==1)
                score = "Fifteen";
            if (player1Points==2)
                score = "Thirty";
            score += "-All";
        }
		return score;
	}
    
    public void SetP1Score(int number){
        
        for (int i = 0; i < number; i++)
        {
            P1Score();
        }
            
    }
    
    public void SetP2Score(int number){
        
        for (int i = 0; i < number; i++)
        {
            P2Score();
        }
            
    }
    
    public void P1Score(){
        player1Points++;
    }
    
    public void P2Score(){
        player2Points++;
    }

    public void wonPoint(String player) {
        if (player == "player1")
            P1Score();
        else
            P2Score();
    }
}