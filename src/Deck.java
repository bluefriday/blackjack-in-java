import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Deck {
	//13개의 카드를 가지고 있음
	//j, q, k도 모두 일단 11, 12, 13으로 표현
	//1부터 13까지으 카드를 섞어서 덱에 넣는 메소드 필요
	//그 중에서 하나를 꺼내서 사용자에게 주는 메소드 필요
	List<Card> cardSet = new ArrayList<Card>();
	
	public Deck() {
		boolean isNotNumber=false;
		
		for(int i=1 ; i<=13 ; i++) {
			//11 이상일 경우 숫자가 아님을 표시
			if(i==11)	{isNotNumber=true; }
			else 		{isNotNumber=false;	}
			
			this.cardSet.add(new Card(i,isNotNumber,'♠'));
		}
		for(int i=1 ; i<=13 ; i++) {
			//11 이상일 경우 숫자가 아님을 표시
			if(i==11)	{isNotNumber=true; }
			else 		{isNotNumber=false;	}
			
			this.cardSet.add(new Card(i,isNotNumber,'◆'));
		}
		for(int i=1 ; i<=13 ; i++) {
			//11 이상일 경우 숫자가 아님을 표시
			if(i==11)	{isNotNumber=true; }
			else 		{isNotNumber=false;	}
			
			this.cardSet.add(new Card(i,isNotNumber,'♥'));
		}
		for(int i=1 ; i<=13 ; i++) {
			//11 이상일 경우 숫자가 아님을 표시
			if(i==11)	{isNotNumber=true; }
			else 		{isNotNumber=false;	}
			
			this.cardSet.add(new Card(i,isNotNumber,'♣'));
		}
	}
	
	public Card pickOneCard() {
		//임의로 한 개의 카드를 추출
		int random = new Random().nextInt(this.cardSet.size());
		//무작위성을 보장하기 위해 상위 객체의 shuffle 기능 사용
		Collections.shuffle(cardSet);
		
		Iterator itr = this.cardSet.iterator();
		
		if(itr.hasNext()) {
			Card pickedCard = (Card)itr.next();
			//추출한 카드는 덱에서 삭제
			this.cardSet.remove(pickedCard);
			
			//추출한 카드를 반환
			return pickedCard;
		} else {
			return new Card(0);
		}
		
	}
}
