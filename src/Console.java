import java.util.Scanner;

class Console {

	private static final Scanner SCANNER = new Scanner(System.in);

	public String read(String string) {
		System.out.print(string);
		return SCANNER.next();
	}

	public int readInt(String string) {
		System.out.print(string);
		return SCANNER.nextInt();
	}

	public void write(String string) {
		System.out.print(string);
	}

	public void write(char unicode) {
		this.write(unicode + "");
	}

}
