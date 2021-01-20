class Rook extends Piece {

    public Rook(Color color) {
        super(color, Type.ROOK);
    }

    public boolean isValidMove(Coordinate origin, Coordinate destination) {
        Orientation orientation = origin.orientation(destination);
        return (orientation == Orientation.HORIZONTAL 
            || orientation == Orientation.VERTICAL);
    }

    public boolean isValidCatch(Coordinate origin, Coordinate destination) {
        return this.isValidMove(origin, destination);
    }
}
