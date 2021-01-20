class King extends Piece {

    public King(Color color) {
        super(color, Type.KING);
    }

    public boolean isValidMove(Coordinate origin, Coordinate destination) {
        return origin.distance(destination) == 1;
    }

    public boolean isValidCatch(Coordinate origin, Coordinate destination) {
       return this.isValidMove(origin, destination);
    }
}
