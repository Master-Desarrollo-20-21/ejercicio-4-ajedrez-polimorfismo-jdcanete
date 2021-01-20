abstract class Piece {

    private Type type;

    private final Color color;

    public Piece(Color color, Type type) {
        this.type = type;
        this.color = color;
    }

    public void show() {
        new Console().write(this.type.getUnicode(color));
    }

    public abstract boolean isValidMove(Coordinate origin, Coordinate destination);
    
	public abstract boolean isValidCatch(Coordinate origin, Coordinate destination);

	public boolean isColor(Color color) {
		return this.color == color;
    }
    
    public boolean isType(Type type) {
        return this.type == type;
    }

}
