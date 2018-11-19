import java.util.ArrayList;

public class Player {
	String playerType;
	String status;
	public ArrayList<Card> myHand;	//dealer 가 소유하고 있는 자신의 deck
	
	Player(Deck deck){
		//default constructor
		//초기에 플레이어(게이머, 딜러)는 게임에 입장하면서 기본적으로 2장의 카드를 받음. 이 부분은 생성자에 넣는게 맞음
		this.status = "hit";
		myHand = new ArrayList<Card>();
		myHand.add(deck.pickOneCard());
		myHand.add(deck.pickOneCard());
	}
	
	public void hit(Deck deck) {
		
		Card givenCard = deck.pickOneCard();
		
		//카드를 한 장 받아서 자신의 deck에 넣는다.
		myHand.add(givenCard);

		//만약 카드를 받은 시점에서 21을 초과하면 무조건 게임 종료
		if(this.countMyScore() > 21) {
			this.status = "burst";
			System.out.println("---------------------------------------------");
			System.out.println(playerType + "의 패배. (카드 값이 21을 초과하였습니다.)");
		} else {
			this.status="hit";
		}
		
	}
	
	public void stay() {
		//아무런 행동도 하지 않는다.
		this.status="stay";
	}
	
	public void showMyCard() {
		int num=0;
		String finalNum="";
		
		System.out.print(playerType + "의 카드 :");
		
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
