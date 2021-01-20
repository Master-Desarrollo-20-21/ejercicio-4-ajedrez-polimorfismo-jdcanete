class Intervale {

	private int inferior;

	private int superior;

	public Intervale(int inferior, int superior) {
		this.inferior = inferior;
		this.superior = superior;
	}

	public boolean contain(int x) {
		return x >= inferior && x <= superior;
	}

}
