import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Dealer extends Player {
	
	public Dealer(Deck deck) {
		super(deck);
		this.playerType = "DEALER";
	}

	@Override
	public void showMyCard() {
		int num=0;
		String finalNum="";
		
		//dealer �� ī��� �� ���� ������ ���� ��Ģ���� ��.
		System.out.print(playerType + "�� ī�� : ");
		for(int i=0 ; i<myHand.size() ; i++) {
			num = ((Card)myHand.get(i)).number;
			
			if(i==0) {
				finalNum = "[" + "?" + "" + "?" +"]";
			}else if(num == 11) {
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
	
	//Overload
	public void showMyCard(String gameend) {
	//������ ����� ���� �θ��� method�� ȣ���Ͽ� ���� ����
		super.showMyCard();
	}
	
	public void askToGamer(Deck deck, Gamer gamer) {
		Scanner input = new Scanner(new InputStreamReader(System.in));
		boolean validation=true;
		int gamerChoice=0;
		
		while(validation) {
			try {
				System.out.println("���̸��� �����Դϴ�.");
				System.out.println("(1) hit. ī�带 �� �޽��ϴ�. [1 �Է�]");
				System.out.println("(2) stay. ī�带 �� ���� �ʽ��ϴ�. [2 �Է�]");
				System.out.print("���� > ");
				
				gamerChoice = input.nextInt();
				
				if(gamerChoice==1 || gamerChoice==2) {
					validation = false;
				}
			} catch(InputMismatchException e) {
				continue;
			} catch(Exception e) {
				continue;
			}
		}
		if(gamerChoice == 1) {
			gamer.hit(deck);
		}else {
			gamer.stay();
		}
	}
	
	public void dealerAction(Deck deck) {
		int totalValue = this.countMyScore();
		
		if(totalValue >= 17) {
		//17�� �̻��̸� ������ ī�带 �߰��� �� ����
			System.out.println("DEBUG!! dealer stay");
			super.stay();
		}else {
		//16�� ���ϸ� �׻� ������ ī�带 �߰��ؾ� ��
			super.hit(deck);
		}
			
	}

	public void checkGameResult(Gamer gamer) {
		int gamer_score = gamer.countMyScore();
		int dealer_score = this.countMyScore();
		
		System.out.println("---------------------------------------------");
		
		//21�� �ѱ�� ������ hit �Ҷ����� üũ�Ѵٰ� ����. ��, ������� �Դٴ� �� �Ѵ� ��� �ּ� burst�� �ƴ϶�� ��.
		//�Ѵ� 21���� ��� �����Ͽ���, ������ ���� �� ū �÷��̾��� �¸�
		if(gamer_score > dealer_score) {
			System.out.println("�����մϴ�! ���̸��� �¸��Դϴ�.");
		} else if(gamer_score < dealer_score) {
			System.out.println("������ �¸��Դϴ�.");
		} else {
			System.out.println("���º��Դϴ�.");
		}
	}
}
