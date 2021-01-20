class Queen extends Piece {

    public Queen(Color color) {
        super(color, Type.QUEEN);
    }

    public boolean isValidMove(Coordinate origin, Coordinate destination) {
        Orientation orientation = origin.orientation(destination);
        return orientation == Orientation.HORIZONTAL 
            || orientation == Orientation.VERTICAL
            || orientation == Orientation.DIAGONAL;
    }

    public boolean isValidCatch(Coordinate origin, Coordinate destination) {
        return this.isValidMove(origin, destination);
    }
}
