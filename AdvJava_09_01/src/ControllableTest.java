
public class ControllableTest {
	public void run() { 
		Controllable tv = new TV("A��"); //�Ű����� �Է��� ������ ����, Controllable �������̽� ����
		tv.power(true);  //true �Է� power�޼ҵ�
		tv.power(false); //false �Է��� power�޼ҵ�
		tv.repair(); //�������̽��� repair�޼ҵ� 
		Controllable.reset(); //���� �޼ҵ������� ��ü ���� �ٷ� ��
	}
}
