class Chess {

    public void play() {
        do {
            new Game().play();
        } while (this.resume());
    }

    public static void main(String[] args) {
        new Chess().play();
    }

    private boolean resume() {
        Console console = new Console();
        String ans = null;
        do {
           ans = console.read("Do you continue? (y/n): ");
        } while (!ans.trim().equalsIgnoreCase("y") && !ans.trim().equalsIgnoreCase("n"));
        return ans.trim().equalsIgnoreCase("y");
    }
}