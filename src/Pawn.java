class Pawn extends Piece {

    public Pawn(Color color) {
        super(color, Type.PAWN);
    }

    public boolean isValidFirstMove(Coordinate origin, Coordinate destination) {
        if (origin.orientation(destination) != Orientation.VERTICAL
            || this.isColor(Color.BLACK) && !origin.isPositiveVerticalDisplacement(destination)
            || this.isColor(Color.WHITE) && origin.isPositiveVerticalDisplacement(destination)) {
            return false;
        }
        return origin.distance(destination) == 2 || origin.distance(destination) == 1;
    }

    public boolean isValidMove(Coordinate origin, Coordinate destination) {
        return this.isValidFirstMove(origin, destination) 
            && origin.distance(destination) == 1;
    }

    public boolean isValidCatch(Coordinate origin, Coordinate destination) {
        if (origin.orientation(destination) != Orientation.DIAGONAL
            || this.isColor(Color.BLACK) && !origin.isPositiveVerticalDisplacement(destination)
            || this.isColor(Color.WHITE) && origin.isPositiveVerticalDisplacement(destination)) {
            return false;
        }
        return origin.distance(destination) == 1;
    }
}

