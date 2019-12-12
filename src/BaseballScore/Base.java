/* 	Defines the bases
*	Justin Moffatt
*	2017-07-20-9:00p
*/

package BaseballScore;

/** 
*	Definition of a base/location that a player can occupy 
*	@author Justin Moffatt
*	@version %G%/%U%
*/
public enum Base{
	
	HOME_BAT(0,"batting"),
	FIRST(1,"first"),
	SECOND(2,"second"),
	THIRD(3,"third"),
	HOME(4,"home"),
	NONE(5,"none");

	private final int number;
	private final String name;
	private Player player;

	Base(int number, String name){
		this.number = number;
		this.name = name;
		this.player = null;
	}

	/** 
	*	Returns the base asked for by a given int
	*	@param number <code>int</code> - the integer for the base wanted
	*	@return <code>Base</code> matching the given parameter
	*/
	public Base getBase(int number){
		switch(number){
			case 0: return HOME_BAT;
			case 1: return FIRST;
			case 2: return SECOND;
			case 3: return THIRD;
			case 4: return HOME;
			default: return NONE;
		}
	}

	/** 
	*	Returns the base asked for by a given string
	*	@param name <code>String</code> - the string for the base wanted
	*	@return <code>Base</code> matching the given parameter
	*/
	public Base getBase(String name){
		switch(name.toLowerCase()){
			case "batting": return HOME_BAT;
			case "first": return FIRST;
			case "second": return SECOND;
			case "third": return THIRD;
			case "home": return HOME;
			default: return NONE;
		}
	}

	/** 
	*	Returns the name of the base
	*	@return <code>String</code> name of the <code>Base</code>
	*/
	public String getName(){
		return new String(this.name);
	}

	/** 
	*	Returns the number value of the base
	*	@return <code>int</code> number of the <code>Base</code>
	*/
	public int getNumber(){
		return new Integer(this.number);
	}

	/** 
	*	Returns the player on this base
	*	@return <code>Player</code> on this base
	*/
	public Player getPlayer(){
		return this.player;
	}

	/** 
	*	Returns if this base has a runner
	*	@return <code>boolean</code> true if the base is occupied
	*/
	public boolean hasPlayer(){
		if(this.player == null){
			return false;
		}else{
			return true;
		}
	}

	/** 
	*	Sets the player on this base and returns the current player on this base
	*	@param player <code>Player</code> - the player to put on this base
	*/
	protected void setPlayer(Player player){
		for(Base b:Base.values()){
			if(player.equals(b.getPlayer())){
				b.removePlayer();
				break;
			}
		}
		this.player = player;
	}

	/** 
	*	Removes the current player from this base and sets it empty
	*/
	protected void removePlayer(){
		this.player = null;
	}
}