
public class TestPhone {
	
	public void run() { //�޼ҵ� ����
		Phone[] phones = { new Phone("����"), new TelePhone("�α�","����"), new SmartPhone("����","������")}; //phoneŬ���� Ÿ���� �迭
		                 // �迭 �ȿ��� 3���� ���� �� ����
		phones[0].talk(); //phones�迭 0��° �ε����� talk�޼ҵ� 
		((TelePhone) phones[1]).autoAnswering(); //phones�迭�� 1��° �ε����� TelephoneŸ������ ĳ������ �� autoAnswering�޼ҵ�
		(((SmartPhone) (TelePhone) phones[2])).playGame(); //phones�迭�� 2��° �ε����� TelephoneŸ������ SmartphoneŸ������ ĳ������ playGame�޼ҵ�
	} 
}
