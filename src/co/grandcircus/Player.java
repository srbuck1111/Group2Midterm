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

	public void addWin() { // incrementing wins
		this.wins++;
	}

	public void addLoss() {// incrementing losses
		this.loses++;
	}

	public String toPlayer() { // printing the array list of players, wins, and loses in a better looking
								// format
		return String.format("Name: %-12s Wins: %-6d Losses: %-6d Win Percentage: %-3.2f", name, wins, loses, (((double) wins/((double) wins + (double) loses)) * 100));
	}

	@Override
	public String toString() {// printing the same list in a different format to the players.txt file
		return name + "," + wins + "," + loses;
	}

}
