public class blackjack {

	public static void main(String[] args) {

		boolean isGameGo = true;
		int gamerChoice = 0;
		
		//일단 문양 없이 숫자만 있는 12개의 카드를 나눠준다고 가정
		//일단 중복해서 나눠 줄수도 있다고 가정

		//게임 시작 
		Deck deck = new Deck();
		Gamer gamer = new Gamer(deck);
		Dealer dealer = new Dealer(deck);

		//게이머는 자신의 차례에서 딜러와 게이머의 카드를 모두 확인할 수 있음(auto print mode)
		System.out.println("---------------------------------------------");
		System.out.println("게임을 시작합니다.");
		
		while(isGameGo) {
			System.out.println("필드의 카드를 확인해 주세요.");
			System.out.println("");
			gamer.showMyCard();
			dealer.showMyCard();
			
			//딜러는 게임 진행 여부를 플레이어에게 물어봄
			//게이머의 턴
			dealer.askToGamer(deck, gamer);
			if("burst".equals(gamer.status)) {
				//gamer 가 bursting 이 되면 그 즉시 게임 종료
				//딜러와 게이머가 모두 버스팅이면 딜러의 승리이므로, 게이머의 로직을 먼저 체크함
				break;
			}
			//딜러의 턴
			dealer.dealerAction(deck);
			if("burst".equals(dealer.status)) {
				//dealer 가 bursting 이 되면 그 즉시 게임 종료
				break;
			}
			
			//게이머와 딜러의 턴이 모두 끝나면 둘다 stay인지 확인
			if("stay".equals(gamer.status) && "stay".equals(dealer.status)){
				isGameGo = false;
			}
		}
		
		if( (!"burst".equals(gamer.status)) && (!"burst".equals(dealer.status)) ) {
		//더블 스테이로 카드 분배가 종료되고, 딜러와 게이머가 모두 burst가 아니면 딜러는 게임 결과를 계산
			dealer.checkGameResult(gamer);
		}
		
		System.out.println("---------------------------------------------");
		System.out.println("게임을 종료합니다.");
		gamer.showMyCard();
		dealer.showMyCard("End of Game");
		System.out.println("---------------------------------------------");
	}

}
