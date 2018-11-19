import java.util.ArrayList;

public class Player {
	String playerType;
	String status;
	public ArrayList<Card> myHand;	//dealer �� �����ϰ� �ִ� �ڽ��� deck
	
	Player(Deck deck){
		//default constructor
		//�ʱ⿡ �÷��̾�(���̸�, ����)�� ���ӿ� �����ϸ鼭 �⺻������ 2���� ī�带 ����. �� �κ��� �����ڿ� �ִ°� ����
		this.status = "hit";
		myHand = new ArrayList<Card>();
		myHand.add(deck.pickOneCard());
		myHand.add(deck.pickOneCard());
	}
	
	public void hit(Deck deck) {
		
		Card givenCard = deck.pickOneCard();
		
		//ī�带 �� �� �޾Ƽ� �ڽ��� deck�� �ִ´�.
		myHand.add(givenCard);

		//���� ī�带 ���� �������� 21�� �ʰ��ϸ� ������ ���� ����
		if(this.countMyScore() > 21) {
			this.status = "burst";
			System.out.println("---------------------------------------------");
			System.out.println(playerType + "�� �й�. (ī�� ���� 21�� �ʰ��Ͽ����ϴ�.)");
		} else {
			this.status="hit";
		}
		
	}
	
	public void stay() {
		//�ƹ��� �ൿ�� ���� �ʴ´�.
		this.status="stay";
	}
	
	public void showMyCard() {
		int num=0;
		String finalNum="";
		
		System.out.print(playerType + "�� ī�� :");
		
		for(int i=0 ; i<myHand.size() ; i++) {
			num = ((Card)myHand.get(i)).number;
			if(num == 11) {
				finalNum = "[" + ((Card)myHand.get(i)).type + "" + "J" +"]";
			}else if(num == 12){
				finalNum = "[" + ((Card)myHand.get(i)).type + "" + "Q" +"]";
			}else if(num == 13){
				finalNum = "[" + ((Card)myHand.get(i)).type + "" + "K" +"]";
			}else {
				finalNum = "[" + ((Card)myHand.get(i)).type + "" + num +"]";
			}
			
			System.out.print(finalNum+" ");
		}
		
		System.out.println();
	}
	
	public int countMyScore() {
		int score = 0;
		int num = 0;
		
		for(int i=0 ; i<myHand.size() ; i++) {
			num = ((Card)myHand.get(i)).number; 

			if(num>10) {
				num=10;
			}
			
			score += num;
		}
		return score;
	}
}
