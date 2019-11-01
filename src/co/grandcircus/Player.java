package co.grandcircus;

public class Player {

	private String name;
	private int wins;
	private int losses;
	
	
	public Player(String name) {
		this.name = name;
	}

	public Player() {
		super();

	}

	public Player(String name, int wins, int losses) {
		super();
		this.name = name;
		this.wins = wins;
		this.losses = losses;
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
		return losses;
	}

	public void setLoses(int loses) {
		this.losses = loses;
	}
	
	public void addWin() {
		this.wins++;
	}
	
	public void addLoss() {
		this.losses++;
	}
	
	@Override
	public String toString() {
		return name + "," + wins + "," + losses;
	}

}
