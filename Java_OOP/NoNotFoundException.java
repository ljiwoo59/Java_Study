public class NoNotFoundException extends Exception {
	int no;
	
	public NoNotFoundException (int no) {
		super("No such model number. - " + no);
	}

	public int getNo() {
		return no;
	}
}
