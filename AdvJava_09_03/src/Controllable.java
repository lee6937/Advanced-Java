
public interface Controllable { //�������̽�
	default void repair() { //����Ʈ �޼ҵ� => �������̽����� ������
		System.out.println("���� ���Ϳ��� �����ؾ��Ѵ�."); //�ش� ���� ���
	}
	
	static void reset() { //���� �޼ҵ� => ��ü �ʿ� ����
		System.out.println("���� �ʱ�ȭ �� �� ����"); //�ش� ���� ���
	}
	
	void power(String tv, boolean onOff); //�߻� �޼ҵ� => ������ Ŭ�������� ����
} 
