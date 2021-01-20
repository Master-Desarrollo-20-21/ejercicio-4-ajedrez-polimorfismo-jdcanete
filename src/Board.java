class Board {

    private static final int MAX_PLAYERS = 2;

    private static final int DIMENSION = 8;

    private Square[][] squares;

    public Board() {
        this.squares = new Square[DIMENSION][DIMENSION];
        for (int i = 0; i < MAX_PLAYERS; i++) {
            Color color = i == 0 ? Color.BLACK : Color.WHITE;
            squares[i * 7][0] = new Square(new Rook(color));
            squares[i * 7][1] = new Square(new Knight(color));
            squares[i * 7][2] = new Square(new Bishop(color));
            squares[i * 7][3] = new Square(new Queen(color));
            squares[i * 7][4] = new Square(new King(color));
            squares[i * 7][5] = new Square(new Bishop(color));
            squares[i * 7][6] = new Square(new Knight(color));
            squares[i * 7][7] = new Square(new Rook(color));
            for (int j = 0; j < DIMENSION; j++) {
                squares[i * 5 + 1][j] = new Square(new Pawn(color));
            }
        }
        for (int i = 2; i < DIMENSION - 2; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                squares[i][j] = new Square();
            }
        }
    }

	public boolean checkmate() {
        int countKings = 0;
        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                if (squares[i][j].hasPiece() && squares[i][j].hasPiece(Type.KING)) {
                    countKings++;
                }
            }
        }
		return countKings == 1;
    }

    private boolean isPreValidMove(Square originSquare, Square destinationSquare, Color color) {
        assert originSquare != null && destinationSquare != null && color != null;
        if (!originSquare.hasPiece()
            || originSquare.hasPiece() && !originSquare.hasPiece(color)
            || destinationSquare.hasPiece() && destinationSquare.hasPiece(color)) {
            return false;
        }
        return true;
    }

    public boolean isValidFirstMove(Coordinate origin, Coordinate destination, Color color) {
        assert origin != null && destination != null && color != null;
        Square originSquare = this.getSquare(origin);
        Square destinationSquare = this.getSquare(destination);
        if (!this.isPreValidMove(originSquare, destinationSquare, color)) {
            return false;
        }
        if (originSquare.hasPiece(Type.PAWN)) {
            return ((Pawn)originSquare.take()).isValidFirstMove(origin, destination);
        }
        Piece piece = originSquare.take();
        return originSquare.hasPiece(Type.KNIGHT) && piece.isValidMove(origin, destination);
    }

    public boolean isValidNoFirstMove(Coordinate origin, Coordinate destination, Color color) {
        assert origin != null && destination != null && color != null;
        Square originSquare = this.getSquare(origin);
        Square destinationSquare = this.getSquare(destination);
        if (!this.isPreValidMove(originSquare, destinationSquare, color)) {
            return false;
        }
        Piece piece = originSquare.take();
        if (destinationSquare.hasPiece() && !piece.isValidCatch(origin, destination)
            || !destinationSquare.hasPiece() && !piece.isValidMove(origin, destination)) {
            return false;
        }
        return originSquare.hasPiece(Type.KNIGHT) || originSquare.hasPiece(Type.KING) 
            || origin.distance(destination) < 2 || !this.isPathBlocked(origin, destination);
    }

    private boolean isPathBlocked(Coordinate origin, Coordinate destination) {
        Coordinate[] path = origin.path(destination);
        for (int i = 0; i < path.length; i++) {
            if (this.getSquare(path[i]).hasPiece()) {
                return true;
            }
        }
        return false;
    }
    
	public void move(Coordinate origin, Coordinate destination) {
        Piece piece = squares[origin.getRow()][origin.getColumn()].take();
        squares[origin.getRow()][origin.getColumn()].clean();
        squares[destination.getRow()][destination.getColumn()].put(piece);
    }

    private Square getSquare(Coordinate coordinate) {
        return squares[coordinate.getRow()][coordinate.getColumn()];
    }

    public void show() {
        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                squares[i][j].show();
            }
            new Console().write("\n");
        }
    }


}
