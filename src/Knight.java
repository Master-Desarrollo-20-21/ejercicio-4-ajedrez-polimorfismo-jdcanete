class Knight extends Piece {

    public Knight(Color color) {
        super(color, Type.KNIGHT);
    }

    public boolean isValidMove(Coordinate origin, Coordinate destination) {
        return origin.distance(destination) == Math.sqrt(5);
    }

    public boolean isValidCatch(Coordinate origin, Coordinate destination) {
        return this.isValidMove(origin, destination);
    }
    
}
