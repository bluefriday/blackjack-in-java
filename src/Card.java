
public class Card {
	public int number;			//1~13
	public boolean isNotNumber;	//11(J), 12(Q), 13(K) �� ��� true
	public char type;			//�����̵�, ���̾�, �ϵ�, Ŭ�ι�
	
	public Card(int number) {
		this.number = number;
	}
	
	public Card(int number, boolean isNotNumber, char type) {
		this(number);
		this.isNotNumber = isNotNumber;
		this.type = type;
	}
}
