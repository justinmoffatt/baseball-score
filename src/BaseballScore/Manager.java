/* 	Manages a baseball game logic for a Game object and offers interface for UI
*	Justin Moffatt
*	2017-07-20-9:00p
*/

package BaseballScore;

/** 
*	Controls the flow of game using a BaseballScore.Game object; the logic for the game.
*	@author Justin Moffatt
*	@version %G%/%U%
*/
public abstract class Manager{
	
	protected Game game;
	private Player pointer;

	public Manager(){
		this.game = new Game();
	}

	/** 
	*	Handles the game when a hit is called;
	*	code for <code>hit</code> element of <code>drawActions()</code> UI; 
	*/
	protected void hit(){
		pointer = game.getBatter();
		drawMoveRunner(game.getBatter());
	}
	
	/** 
	*	Handles the game when a st'rike is called; 
	*	code for <code>strike</code> element of <code>drawActions()</code> UI; 
	*/
	protected void strike(){
		game.addStrike();

		if(game.getStrikes() == 3){
			if(game.getOuts() < 2 && !Base.FIRST.hasPlayer()){
				drawBatterAdvance();
			}else if(game.getOuts() == 2 && Base.FIRST.hasPlayer()){
				drawBatterAdvance();
			}else{
				out(game.getBatter());
			}
		}else{
			drawStrike();
		}
	}
	/** 
	*	Handles when first base is gained on a dropped 3rd strike;	
	*	code for <code>yes</code> element of <code>drawBatterAdvance()</code> UI with parameter <code>FIRST</code> passed
	*/
	protected void batterAdvance(){
		moveRunner(game.getBatter(), Base.FIRST);
	}

	/** 
	*	Handles the game when a ball is called; 
	*	code for <code>ball</code> element of <code>drawActions()</code> UI; 
	*/
	protected void ball(){
		game.addBall();

		if(game.getBalls() == 4){
			moveRunner(game.getBatter(), Base.FIRST);
		}else{
			drawBall();
		}
	}

	/** 
	*	Handles when an out happens; called internally and externally from UI;
	*	code for <code>out</code> element of <code>drawMoveRunner()</code> UI with parameter <code>player</code> passed
	*	@param player <code>Player</code> player that is called out
	*/
	protected void out(Player player){
		game.addOut();

		if(player.equals(game.getBatter())){
			game.newBatter();
		}

		if(game.getOuts() == 3){
			game.inningEnd();
			drawInningEnd();
		}else{
			drawOut();
		}		
	} 

	/** 
	*	Move a player to a new base; called internally and externally from UI;
	*	code for <code>base number</code> elements of <code>drawMoveRunner()</code> UI;
	*	@param player <code>Player</code> - the player to move
	*	@param base <code>Base</code> - location to move player param to
	*/
	protected void moveRunner(Player player, Base base){
		if(player.equals(game.getBatter())){
			game.newBatter();
		}

		if(base == Base.HOME){
			base.setPlayer(player);
			game.addRun();
			drawActions();
		}else if(base.hasPlayer()){
			Player old = base.getPlayer();
			base.setPlayer(player);
			drawMoveRunner(old);
		}else{
			base.setPlayer(player);
			drawActions();
		}
	}

	// ----- GUI draw abstract methods ----- //
	// these are called by the above and need to be implemented as described to make sense of the game structure defined by the manager
	
	/** 
	*	method called to draw a prompt to select what type of action occurred; strike, ball, hit, base runner change; base runner change should call <code>drawMoveRunner()</code> method
	*/
	public abstract void drawActions();

	/** 
	*	method called to draw a prompt to select a base runner to move; prompt input should call <code>drawRunner()</code> method
	*/
	public abstract void drawSelectRunner();

	/** 
	*	method called to draw a prompt to move the passed runner to a new base or to be called out
	*/
	public abstract void drawMoveRunner(Player player);

	/** 
	*	method called to draw a prompt to ask if the batter advanced on a dropped strike three call
	*/
	public abstract void drawBatterAdvance();

	/** 
	*	method called when less than 3 strikes are applied
	*/
	public abstract void drawStrike();

	/** 
	*	method called when less than 4 balls area applied
	*/
	public abstract void drawBall();

	/** 
	*	method called when less than 3 outs are applied
	*/ 
	public abstract void drawOut();

	/** 
	*	method called when 3 outs are applied and the inning been changed
	*/
	public abstract void drawInningEnd();

	/** 
	*	method should handle collecting and adding players to the team rosters using game.addHomePlayer() and game.addAwayPlayer
	*/
	public abstract void drawAddPlayer();

	/** 
	*	method should handle collecting data and subbing player using game.subHome() and game.subAway()
	*/
	public abstract void drawSubstitution();
}