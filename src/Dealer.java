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
		
		//dealer 의 카드는 한 장을 가리는 것을 원칙으로 함.
		System.out.print(playerType + "의 카드 : ");
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
	//게임이 종료된 경우는 부모의 method를 호출하여 전부 공개
		super.showMyCard();
	}
	
	public void askToGamer(Deck deck, Gamer gamer) {
		Scanner input = new Scanner(new InputStreamReader(System.in));
		boolean validation=true;
		int gamerChoice=0;
		
		while(validation) {
			try {
				System.out.println("게이머의 차례입니다.");
				System.out.println("(1) hit. 카드를 더 받습니다. [1 입력]");
				System.out.println("(2) stay. 카드를 더 받지 않습니다. [2 입력]");
				System.out.print("선택 > ");
				
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
		//17점 이상이면 딜러는 카드를 추가할 수 없음
			System.out.println("DEBUG!! dealer stay");
			super.stay();
		}else {
		//16점 이하면 항상 딜러는 카드를 추가해야 함
			super.hit(deck);
		}
			
	}

	public void checkGameResult(Gamer gamer) {
		int gamer_score = gamer.countMyScore();
		int dealer_score = this.countMyScore();
		
		System.out.println("---------------------------------------------");
		
		//21을 넘기는 조건은 hit 할때마다 체크한다고 가정. 즉, 여기까지 왔다는 건 둘다 모두 최소 burst는 아니라는 것.
		//둘다 21이하 라는 전제하에서, 숫자의 합이 더 큰 플레이어의 승리
		if(gamer_score > dealer_score) {
			System.out.println("축하합니다! 게이머의 승리입니다.");
		} else if(gamer_score < dealer_score) {
			System.out.println("딜러의 승리입니다.");
		} else {
			System.out.println("무승부입니다.");
		}
	}
}
