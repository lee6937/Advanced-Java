
public class Phone {
	protected String owner;
	
	public String getOwner() { //getter ����
		return owner; //�������� ����
	}
	
	public void setOwner(String owner) { //setter ����
		this.owner = owner; //�Ű������� �������� ��ġ
	}
	public Phone() { // �⺻ ������
		this.owner = null; // �������� �ʱ�ȭ
	}
	
	public Phone(String owner) { // �Ű����� �ϳ��� ������
		setOwner(owner); // �Ű����� �� �Է�
	}
	
	void talk() { //�޼ҵ�
		System.out.println(getOwner()+"�� ��ȭ���̴�.");
	}
}
