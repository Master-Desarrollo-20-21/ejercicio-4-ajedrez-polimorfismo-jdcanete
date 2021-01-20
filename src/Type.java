enum Type { 
    KING('\u2654', '\u265A'), 
    QUEEN('\u2655', '\u265B'), 
    PAWN('\u2659', '\u265F'), 
    ROOK('\u2656', '\u265C'), 
    KNIGHT('\u2658', '\u265E'), 
    BISHOP ('\u2657', '\u265D');

    private char blackUnicode;

    private char whiteUnicode;

    private Type(char blackUnicode, char whiteUnicode) {
        this.blackUnicode = blackUnicode;
        this.whiteUnicode = whiteUnicode;
    }

    public char getUnicode(Color color) {
        if (color == Color.BLACK) {
            return blackUnicode;
        }
        return whiteUnicode;
    }

}