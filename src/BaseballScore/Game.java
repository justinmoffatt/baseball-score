/* 	Game framework for baseball score counter
*	Justin Moffatt
*	2017-07-26-6:30p
*/

package BaseballScore;

import java.util.ArrayList;

/**	
*	Game object structure for a baseball game
*	@author Justin Moffatt
*	@version %G%/%U%
*/
public class Game{

	private int balls;
	private int strikes;
	private int outs;
	private int inning;
	private int scoreHome;
	private int scoreAway;
	private boolean inningTop;
	private ArrayList<Player> teamHome;
	private ArrayList<Player> teamAway;

	public Game(){
		this.outs = 0;
		this.inning = 1;
		this.scoreHome = 0;
		this.scoreAway = 0;
		this.inningTop = true;
		this.scoreAway = 0;
		this.scoreHome = 0;
		teamHome = new ArrayList<Player>();
		teamAway = new ArrayList<Player>();
	}

	/**	
	*	returns copy of the current batter
	*	@return <code>Player</code> of the current batter
	*/
	public Player currentBatter(){
		if(this.inningTop){
			return new Player(teamAway.get(0));
		}else{
			return new Player(teamHome.get(0));
		}
	}

	/**	
	*	returns exact instance of the current batter
	*	@return <code>Player</code> instance of the current batter
	*/
	public Player getBatter(){
		if(this.inningTop){
			return teamAway.get(0);
		}else{
			return teamHome.get(0);
		}
	}

	/** 
	*	Returns the current amount of balls the player has
	*	@return <code>Integer</code> copy of the ball count
	*/
	public int getBalls(){
		return new Integer(this.balls);
	}

	/** 
	*	Returns the current amount of strikes the player has
	*	@return <code>Integer</code> copy of the Strike count
	*/
	public int getStrikes(){
		return new Integer(this.strikes);
	}

	/** 
	*	Returns the current count for the player
	*	@return <code>Integer</code> array copy of the count in format: {balls, strikes}
	*/
	public int[] getCount(){
		return new int[] {new Integer(this.balls), new Integer(this.strikes)};
	}

	/** 
	*	Returns the current amount of outs in the game
	*	@return <code>Integer</code> copy of the amount of outs
	*/
	public int getOuts(){
		return new Integer(this.outs);
	}

	/** 
	*	Returns the current inning
	*	@return <code>Integer</code> copy of the current inning data
	*/
	public int getInning(){
		return new Integer(this.inning);
	}

	/** 
	*	Returns if the inning is in the top half
	*	@return <code>Boolean</code> copy of true if inning is top half
	*/
	public boolean isTop(){
		return new Boolean(this.inningTop);
	}

	/**	
	*	Returns an array of the current score
	*	@return <code>Integer</code> array copy in format: {away score, home score}
	*/
	protected int[] getScore(){
		int[] r = new int[2];
		r[0] = new Integer(this.scoreAway);
		r[1] = new Integer(this.scoreHome);
		return r;
	}

	/** 
	*	Adds one strike to total strike tally
	*/
	protected void addStrike(){
		this.strikes++;
	}

	/** 
	*	Adds one ball to total ball tally
	*/
	protected void addBall(){
		this.balls++;
	}

	/**	
	*	Forces the balls and strikes to 0
	*/
	protected void resetCount(){
		this.balls = 0;
		this.strikes = 0;
		
	}

	/** 
	*	Adds an out - duh
	*/
	protected void addOut(){
		this.outs ++;
	}


	/** 
	*	Adds a player to the end of the home team line up
	*	@param player <code>Player</code> - player to add
	*/
	public void addHomePlayer(Player player){
		teamHome.add(player);
	}

	/** 
	*	Adds a player to the end of the away team line up
	*	@param player <code>Player</code> - the player to add
	*/
	public void addAwayPlayer(Player player){
		teamAway.add(player);
	}

	/** 
	*adds a run to the away team
	*/
	protected void addRun(){
		if(this.inningTop){
			this.scoreAway ++;
		}else{
			this.scoreHome ++;
		}
	}

	/** 
	*	resets out count and updates inning
	*/
	protected void inningEnd(){
		this.outs = 0;
		if(this.inningTop){
			this.inningTop = false;
		}else{
			this.inningTop = true;
			this.inning ++;
		}
	}

	/**
	*	Gets a new batter and updates/moves the batting order
	*	@return <code>Player</code> instance of the next batter in order
	*/
	protected Player newBatter(){
		ArrayList<Player> current;
		if(this.inningTop){
			current = teamAway;
		}else{
			current = teamHome;
		}
		this.resetCount();
		Player old = current.remove(0);
		current.add(old);
		return current.get(0);
	}

	/**	
	*	Makes a roster sub swapping player a with new player b
	*	@param a <code>Player</code> - the current player
	*	@param b <code>Player</code> - the new player to move into the current player's spot
	*/
	public void subHome(Player a, Player b){
		int i = teamHome.indexOf(a);
		teamHome.set(i,b);
	}
	
	/**	
	*	Makes a roster sub swapping player a with new player b
	*	@param a <code>Player</code> - the current player
	*	@param b <code>Player</code> - the new player to move into the current player's spot
	*/
	public void subAway(Player a, Player b){
		int i = teamAway.indexOf(a);
		teamAway.set(i,b);
	}
}