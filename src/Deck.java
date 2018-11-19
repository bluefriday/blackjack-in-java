import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Deck {
	//13���� ī�带 ������ ����
	//j, q, k�� ��� �ϴ� 11, 12, 13���� ǥ��
	//1���� 13������ ī�带 ��� ���� �ִ� �޼ҵ� �ʿ�
	//�� �߿��� �ϳ��� ������ ����ڿ��� �ִ� �޼ҵ� �ʿ�
	List<Card> cardSet = new ArrayList<Card>();
	
	public Deck() {
		boolean isNotNumber=false;
		
		for(int i=1 ; i<=13 ; i++) {
			//11 �̻��� ��� ���ڰ� �ƴ��� ǥ��
			if(i==11)	{isNotNumber=true; }
			else 		{isNotNumber=false;	}
			
			this.cardSet.add(new Card(i,isNotNumber,'��'));
		}
		for(int i=1 ; i<=13 ; i++) {
			//11 �̻��� ��� ���ڰ� �ƴ��� ǥ��
			if(i==11)	{isNotNumber=true; }
			else 		{isNotNumber=false;	}
			
			this.cardSet.add(new Card(i,isNotNumber,'��'));
		}
		for(int i=1 ; i<=13 ; i++) {
			//11 �̻��� ��� ���ڰ� �ƴ��� ǥ��
			if(i==11)	{isNotNumber=true; }
			else 		{isNotNumber=false;	}
			
			this.cardSet.add(new Card(i,isNotNumber,'��'));
		}
		for(int i=1 ; i<=13 ; i++) {
			//11 �̻��� ��� ���ڰ� �ƴ��� ǥ��
			if(i==11)	{isNotNumber=true; }
			else 		{isNotNumber=false;	}
			
			this.cardSet.add(new Card(i,isNotNumber,'��'));
		}
	}
	
	public Card pickOneCard() {
		//���Ƿ� �� ���� ī�带 ����
		int random = new Random().nextInt(this.cardSet.size());
		//���������� �����ϱ� ���� ���� ��ü�� shuffle ��� ���
		Collections.shuffle(cardSet);
		
		Iterator itr = this.cardSet.iterator();
		
		if(itr.hasNext()) {
			Card pickedCard = (Card)itr.next();
			//������ ī��� ������ ����
			this.cardSet.remove(pickedCard);
			
			//������ ī�带 ��ȯ
			return pickedCard;
		} else {
			return new Card(0);
		}
		
	}
}
