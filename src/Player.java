class Player {

    private Color color;

    private Board board;

    private int attempCounter;

    public Player(Color color, Board board) {
        this.color = color;
        this.board = board;
    }

	public void move() {
        Coordinate origin = new Coordinate();
        Coordinate destination = new Coordinate();
        boolean error = false;
        do {
            origin.obtain("origin");
            destination.obtain("destination");
            error = this.attempCounter == 0
                ? !this.board.isValidFirstMove(origin, destination, color)
                : !this.board.isValidNoFirstMove(origin, destination, color);
        } while (error);
        this.board.move(origin, destination);
        this.attempCounter++;
	}

	public void show() {
        new Console().write("The " + this.color + "S");
	}
}
