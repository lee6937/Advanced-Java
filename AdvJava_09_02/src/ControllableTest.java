
public class ControllableTest {
	public void run() {
		String who = "B��";
		Controllable tv = new Controllable() { //�������̽� ��üȭ
			public void power(String tv,boolean onOff) { //���� Ŭ���� ����
				String verb = onOff == true ? "�Ҵ�." : "����."; //true�̸� verb������ �Ҵ� ���� false�̸� ���� ����
				System.out.println(who + tv +"������ " + verb); //���� ���
			}	
			
		}; //����Ŭ������ ����� �ܹ߼����� ����� => ���� �̸��� ���� ����
		
		tv.power("TV",true); //power�Լ��� true�Է�
		tv.power("TV",false); //power�Լ��� false�Է�
		tv.repair(); //�������̽��� ����Ʈ �޼ҵ� 
		Controllable.reset(); //���� �޼ҵ������� ��ü ���� �ٷ� ��
	}
}


