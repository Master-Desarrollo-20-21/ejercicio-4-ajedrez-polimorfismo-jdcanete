class Square {

    private Piece piece;

	public Square(Piece piece) {
        this.piece = piece;
	}

	public Square() {
	}

	public Piece take() {
        assert this.piece != null;
		return this.piece;
	}

	public void clean() {
        assert this.piece != null;
        this.piece = null;
	}

	public void put(Piece piece) {
        this.piece = piece;
	}

	public boolean hasPiece(Color color) {
        assert this.hasPiece();
		return this.piece.isColor(color);
	}

	public boolean hasPiece() {
		return this.piece != null;
	}
	
	public boolean hasPiece(Type type) {
        assert this.hasPiece();
        return this.piece.isType(type);
	}

	public void show() {
        Console console = new Console();
        if (!this.hasPiece()) {
            console.write("[ ]");
        } else {
            console.write("[");
            this.piece.show();
            console.write("]");
        }
	}

}
