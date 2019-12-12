/*	Player class definition
*	Justin Moffatt		
*	2017-07-20-9:00p
*/

package BaseballScore;

/** 
*	An object representing a player and their current state at bat or on base. Requires a name and/or number for an id
*	@author Justin Moffatt
*	@version %G%/%U%
*/
public class Player{
	private int number;
	private String name;
	
	public Player(int number){
		this.number = number;
		this.name = null;
	}

	public Player(int number, String name){
		this.number = number;
		this.name = name;
	}

	public Player(String name, int number){
		this.number = number;
		this.name = name;
	}

	public Player(String name){
		this.name = name;
		this.number = 0;
	}

	public Player(Player player){
		this.name = player.getName();
		this.number = player.getNumber();
	}

	public boolean equals(Player player){
		if(player == null){
			return false;
		}
		
		if(this.number == player.number && this.name == player.name){
			return true;
		}
		
		return false;
	}

	/** 
	*	Returns the player's name
	*	@return <code>String</code> copy of the player's name
	*/
	public String getName(){
		return new String(this.name);
	}

	/** 
	*	Returns the player's number
	*	@return <code>int</code> copy of the player's number
	*/
	public int getNumber(){
		return new Integer(this.number);
	}
}