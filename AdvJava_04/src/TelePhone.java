
public class TelePhone extends Phone{
	private String when;
	
	
	public String getWhen() { //getter ����
		return when; //�������� ����
	}

	public void setWhen(String when) { //setter ����
		this.when = when; //�Ű������� �������� ��ġ
	}
	
	public TelePhone() { //�⺻ ������
		this.when = null; //�������� �ʱ�ȭ
	}

	public TelePhone(String owner,String when) { //�Ű����� �ΰ��� ������
		super(owner); //super�̿� => �θ�Ŭ������ owner���� �Է�
		setWhen(when); //�Ű����� �Է�
		
	}
	
	void autoAnswering() { //�޼ҵ�
		System.out.println(getOwner()+"�� �������̴�. "+getWhen()+" ��ȭ�� �ٶ���.");
	}

}
