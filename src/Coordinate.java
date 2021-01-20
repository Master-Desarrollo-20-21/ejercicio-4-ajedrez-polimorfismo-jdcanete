import java.util.Arrays;

class Coordinate {

    private static final Intervale PLANE[] = { new Intervale(0, 7), new Intervale(0, 7) };

    private int row;

    private int column;

    private Console console;

    public Coordinate() {
        this.console = new Console();
    }

    public Coordinate(int row, int column) {
        this();
        this.row = row;
        this.column = column;
    }

    public void obtain(String message) {
        new Console().write(message + "\n");
        int row = -1;
        int column = -1;
        boolean error = false;
        do {
            row = this.console.readInt("Indicate row: ");
            column = this.console.readInt("Indicate column: ");
            error = !this.validInput(row, column);
            if (error) {
                new Console().write("Error: Out of range. Try again.\n");
            }
        } while (error);
        this.row = row;
        this.column = column;
    }

    private boolean validInput(int row, int column) {
        return PLANE[0].contain(row) && PLANE[1].contain(column);
    }

    public boolean equals(Coordinate coordinate) {
        return this.row == coordinate.row && this.column == coordinate.column;
    }

    public Orientation orientation(Coordinate destination) {
        assert !this.equals(destination);
        int verticalDistance = this.verticalDistance(destination);
        int horizontalDistance = this.horizontalDistance(destination);
        if (verticalDistance == 0) {
            return Orientation.HORIZONTAL;
        }
        if (horizontalDistance == 0) {
            return Orientation.VERTICAL;
        }
        if (verticalDistance == horizontalDistance) {
            return Orientation.DIAGONAL;
        }
        return Orientation.IMPRECISE;
    }

    private int verticalDistance(Coordinate destination) {
        return Math.abs(this.row - destination.row);
    }

    private int horizontalDistance(Coordinate destination) {
        return Math.abs(this.column - destination.column);
    }

    public double distance(Coordinate destination) {
        assert !this.equals(destination);
        int verticalDistance = this.verticalDistance(destination);
        int horizontalDistance = this.horizontalDistance(destination);
        if (verticalDistance == 0) {
            return horizontalDistance;
        }
        if (horizontalDistance == 0) {
            return verticalDistance;
        }
        if (verticalDistance == horizontalDistance) {
            return verticalDistance;
        }
        return Math.sqrt(Math.pow(verticalDistance, 2) + Math.pow(horizontalDistance, 2));
    }

    public Coordinate[] path(Coordinate destination) {
        assert destination!= null && this.distance(destination) > 1 
            && this.orientation(destination) != Orientation.IMPRECISE;
        int verticalDistance = this.verticalDistance(destination);
        int horizontalDistance = this.horizontalDistance(destination);
        int pathSize = verticalDistance > horizontalDistance 
            ? verticalDistance - 1 : horizontalDistance - 1;
        Coordinate[] path = new Coordinate[pathSize];
        Coordinate initial = new Coordinate(this.row, this.column);
        for (int i = 0; i < pathSize; i++) {
            initial.moveOneUnitTo(destination);
            path[i] = new Coordinate(initial.row, initial.column);
        }
        return path;
    }

    private void moveOneUnitTo(Coordinate destination) {
        assert destination!= null && this.distance(destination) > 1;
        if (this.horizontalDistance(destination) > 0) {
            int counter = this.isPositiveHorizontalDisplacement(destination) ? 1 : -1;
            this.column += counter;
        }
        if (this.verticalDistance(destination) > 0) {
            int counter = this.isPositiveVerticalDisplacement(destination) ? 1 : -1;
            this.row += counter;
        }
    }

    public boolean isPositiveHorizontalDisplacement(Coordinate destination) {
        assert this.distance(destination) > 0;
        return destination.column > this.column;
    }

    public boolean isPositiveVerticalDisplacement(Coordinate destination) {
        assert this.distance(destination) > 0;
        return destination.row > this.row;
    }

    public int getRow() {
        return this.row;
    }

    public int getColumn() {
        return this.column;
    }

    @Override
    public String toString() {
        return "Coordinate [row=" + row + ", column=" + column + "]";
    }

    public static void main(String[] args) {
        Coordinate c1 = new Coordinate();
        Coordinate c2 = new Coordinate();
        c1.obtain("origin");
        c2.obtain("destination");
        new Console().write("Equals? : " + c1.equals(c2) + "\n");
        new Console().write(c1.orientation(c2) + "\n");
        Arrays.asList(c1.path(c2)).forEach(System.out::println);

    }

}
