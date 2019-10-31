package co.grandcircus;

public class Player {

	private String name;
	private int wins;
	private int loses;
	
	
	public Player(String name) {
		this.name = name;
	}

	public Player() {
		super();

	}

	public Player(String name, int wins, int loses) {
		super();
		this.name = name;
		this.wins = wins;
		this.loses = loses;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;

	}

	public int getWins() {
		return wins;
	}

	public void setWins(int wins) {
		this.wins = wins;

	}

	public int getLoses() {
		return loses;
	}

	public void setLoses(int loses) {
		this.loses = loses;
	}

	@Override
	public String toString() {
		return "Player: " + name + " Wins: " + wins + " Loses: " + loses;
	}

}
