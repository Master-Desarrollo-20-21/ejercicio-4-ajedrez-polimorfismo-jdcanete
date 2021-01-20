class Bishop extends Piece {

    public Bishop(Color color) {
        super(color, Type.BISHOP);
    }

    public boolean isValidMove(Coordinate origin, Coordinate destination) {
        Orientation orientation = origin.orientation(destination);
        return orientation == Orientation.DIAGONAL;
    }

    public boolean isValidCatch(Coordinate origin, Coordinate destination) {
        return this.isValidMove(origin, destination);
    }
}