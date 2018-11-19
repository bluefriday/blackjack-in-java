public class blackjack {

	public static void main(String[] args) {

		boolean isGameGo = true;
		int gamerChoice = 0;
		
		//�ϴ� ���� ���� ���ڸ� �ִ� 12���� ī�带 �����شٰ� ����
		//�ϴ� �ߺ��ؼ� ���� �ټ��� �ִٰ� ����

		//���� ���� 
		Deck deck = new Deck();
		Gamer gamer = new Gamer(deck);
		Dealer dealer = new Dealer(deck);

		//���̸Ӵ� �ڽ��� ���ʿ��� ������ ���̸��� ī�带 ��� Ȯ���� �� ����(auto print mode)
		System.out.println("---------------------------------------------");
		System.out.println("������ �����մϴ�.");
		
		while(isGameGo) {
			System.out.println("�ʵ��� ī�带 Ȯ���� �ּ���.");
			System.out.println("");
			gamer.showMyCard();
			dealer.showMyCard();
			
			//������ ���� ���� ���θ� �÷��̾�� ���
			//���̸��� ��
			dealer.askToGamer(deck, gamer);
			if("burst".equals(gamer.status)) {
				//gamer �� bursting �� �Ǹ� �� ��� ���� ����
				//������ ���̸Ӱ� ��� �������̸� ������ �¸��̹Ƿ�, ���̸��� ������ ���� üũ��
				break;
			}
			//������ ��
			dealer.dealerAction(deck);
			if("burst".equals(dealer.status)) {
				//dealer �� bursting �� �Ǹ� �� ��� ���� ����
				break;
			}
			
			//���̸ӿ� ������ ���� ��� ������ �Ѵ� stay���� Ȯ��
			if("stay".equals(gamer.status) && "stay".equals(dealer.status)){
				isGameGo = false;
			}
		}
		
		if( (!"burst".equals(gamer.status)) && (!"burst".equals(dealer.status)) ) {
		//���� �����̷� ī�� �й谡 ����ǰ�, ������ ���̸Ӱ� ��� burst�� �ƴϸ� ������ ���� ����� ���
			dealer.checkGameResult(gamer);
		}
		
		System.out.println("---------------------------------------------");
		System.out.println("������ �����մϴ�.");
		gamer.showMyCard();
		dealer.showMyCard("End of Game");
		System.out.println("---------------------------------------------");
	}

}
