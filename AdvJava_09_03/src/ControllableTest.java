public class ControllableTest {
	public void run() {
		String who = "B��"; //���� �Է�
		Controllable tv = (String tv1, boolean onOff) -> { //���ٽ�
			
			String verb = onOff == true ? "�Ҵ�." : "����."; //true�̸� verb������ �Ҵ� ���� false�̸� ���� ����
			System.out.println(who + tv1 +"������ " + verb); //���� ���
			
		};
		
		tv.power("TV",true); //power�Լ��� true�Է�
		tv.power("TV",false); //power�Լ��� false�Է�
		tv.repair(); //�������̽��� ����Ʈ �޼ҵ� 
		Controllable.reset(); //���� �޼ҵ������� ��ü ���� �ٷ� ��
	}
}
