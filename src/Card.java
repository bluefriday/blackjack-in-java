
public class Card {
	public int number;			//1~13
	public boolean isNotNumber;	//11(J), 12(Q), 13(K) 일 경우 true
	public char type;			//스페이드, 다이아, 하드, 클로버
	
	public Card(int number) {
		this.number = number;
	}
	
	public Card(int number, boolean isNotNumber, char type) {
		this(number);
		this.isNotNumber = isNotNumber;
		this.type = type;
	}
}
