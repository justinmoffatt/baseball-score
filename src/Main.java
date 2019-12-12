/*	A simple text based user interface to use the BaseballScore package
*	Justin Moffatt
*	2017-07-21-8:00p
*/

import BaseballScore.*;
import java.util.Scanner;
import Util.Tool;

public class Main extends Manager {
	Scanner scan = new Scanner(System.in);

	public static void main(String[] args){
		Main m = new Main();
		m.drawAddPlayer();
		m.drawActions();
	}

	public void p(String s){
		System.out.println(s);
	}

	public void drawActions(){
		String o = "Actions:\n(1) Strike\n(2) Ball\n(3) Hit\n(4) Runners";
		p(d());
		p(o);
		String next = i();
		if(next.equals("1")){strike();}
		else if(next.equals("2")){ball();}
		else if(next.equals("3")){hit();}
		else if(next.equals("4")){drawSelectRunner();}
		else{p("Invalid input");}
	}

	public void drawSelectRunner(){
		String o = "Select base runner:\n(1) First\n(2) Second\n(3) Third\n";
		p(o);
		String next = i();
		if(next.equals("1")){drawMoveRunner(Base.FIRST.getPlayer());}
		else if(next.equals("2")){drawMoveRunner(Base.SECOND.getPlayer());}
		else if (next.equals("3")){drawMoveRunner(Base.THIRD.getPlayer());}
		else{p("Invalid input");}
	}

	public void drawMoveRunner(Player p){
		p("Select new base:\n(1) First\n(2) Second\n(3) Third\n(4) Home");
		String next = i();
		if(next.equals("1")){moveRunner(p,Base.FIRST);}
		else if(next.equals("2")){moveRunner(p,Base.SECOND);}
		else if(next.equals("3")){moveRunner(p,Base.THIRD);}
		else if(next.equals("4")){moveRunner(p,Base.HOME);}
		else{p("Invalid input");}
	}

	public void drawBatterAdvance(){
		p("Dropped Strike batter to first:\n(1) Yes\n(2) No");
		String next = i();
		if(next.equals("1")){batterAdvance();}
		else if(next.equals("2")){out(game.getBatter());}
		else{p("Invalid input");}
	}

	public String i(){
		return scan.next();
	}

	public String d(){
		String o = "";
		if(Base.SECOND.hasPlayer()){o=o+"----x----\n";}else{o=o+"----o----\n";}
		if(Base.THIRD.hasPlayer()){o=o+"-x-----";}else{o=o+"-o-----";}
		if(Base.FIRST.hasPlayer()){o=o+"x-\n";}else{o=o+"o-\n";}
		o = o + "----o----";
		return o;
	}


	public void drawStrike(){
		p("Batter: " + game.getBatter().getNumber());
		p("Count: " + game.getBalls() + "-" + game.getStrikes());
		drawActions();
	}

	public void drawBall(){
		p("Batter: " + game.getBatter().getNumber());
		p("Count: " + game.getBalls() + "-" + game.getStrikes());
		drawActions();
	}

	public void drawOut(){
		p("Batter: " + game.getBatter().getNumber());
		drawActions();
	}

	public void drawInningEnd(){
		p("Inning: " + game.getInning());
		drawActions();
	}

	public void drawAddPlayer(){
		int i = 1;
		while (i < 10){
			game.addHomePlayer(new Player(i));
			i++;
		}
		while(i<18){
			game.addAwayPlayer(new Player(i));
			i++;
		}
	}

	public void drawSubstitution(){

	}
}