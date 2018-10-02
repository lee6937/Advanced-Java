
public abstract class Controller {
	
	public boolean power; //boolean �� ���� ����
	
	public Controller(boolean power) { //������
		this.power = power; //���������� �Ű����� ��ġ
	}
	
	public void show() { //�޼ҵ� ����
		if(power)//power�� true�϶� 
			System.out.println(getName()+"�� �������ϴ�."); //���
		else //false�϶�
			System.out.println(getName()+"�� �������ϴ�."); //���
	}
	
	public abstract String getName(); //�߻� �޼ҵ� ����

}
