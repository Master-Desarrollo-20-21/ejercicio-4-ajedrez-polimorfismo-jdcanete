class Game {

    private Turn turn;

    private Player[] players;

    private Board board;

    public Game() {
        this.board = new Board();
        this.players = new Player[]{ 
            new Player(Color.WHITE, board), 
            new Player(Color.BLACK, board) };
        this.turn = new Turn(players);
    }

	public void play() {
        Player currentPlayer = null;
        do {
            this.board.show();
            this.turn.show();
            currentPlayer = turn.next();
            currentPlayer.move();
        } while (!board.checkmate());
        this.declareVictory(currentPlayer);
	}

    private void declareVictory(Player currentPlayer) {
        Console console = new Console();
        console.write("Checkmate!\nThe winner is ");
        currentPlayer.show();
        console.write("\n");
    }

}
