public class Turn {

	private final Player[] players;

	private Player currentPlayer;

	private int nextIndex;

	public Turn(Player[] players) {
		this.players = players;
	}

	public Player next() {
		this.currentPlayer = players[nextIndex];
		nextIndex = (nextIndex + 1) % 2;
		return this.currentPlayer;
	}

	public void show() {
		Console console = new Console();
		console.write("Turn: ");
		this.players[nextIndex].show();
		console.write(" move.\n");
	}

}
