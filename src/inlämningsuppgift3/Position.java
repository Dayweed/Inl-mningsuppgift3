package inlämningsuppgift3;

public class Position {
	private int first;
	private int second;
	
	public Position() {}
	
	public Position (int first, int second) {
		this.first = first;
		this.second = second;
	}
	
	public int setFirstPosition(int first) {
		this.first = first;
		return first;
	}
	
	public int setSecondPosition(int second) {
		this.second = second;
		return second;
	}
	
	public int getFirstPosition() {
		return first;
	}
	
	public int getSecondPosition() {
		return second;
	}
}
