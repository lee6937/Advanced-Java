
public interface Controllable { //�������̽�
	
	default void repair() { //����Ʈ �޼ҵ� => �������̽����� ������
		System.out.println("���� ���Ϳ��� �����ؾ��Ѵ�.");
	}
	static void reset() { //���� �޼ҵ� => ��ü �ʿ� ����
		System.out.println("���� �ʱ�ȭ �� �� ����");
	}
	void power(boolean onOff); //�߻� �޼ҵ� => ������ Ŭ�������� ����
	
}
