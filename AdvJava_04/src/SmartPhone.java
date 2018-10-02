
public class SmartPhone extends TelePhone{
	private String game;
	
	public String getGame() { //getter ����
		return game; //�������� ����
	}

	public void setGame(String game) { //setter ����
		this.game = game; //�Ű������� �������� ��ġ
	}
	
	public SmartPhone() { //�⺻ ������ 
		this.game = null; //�������� �ʱ�ȭ
	}
	
	public SmartPhone(String owner, String game) { //�Ű����� �ΰ��� ������
		super(owner,null); //super�̿� => owner������ �Է�
		this.game = game; //�Ű����� �Է�
	}
	
	void playGame() { //�޼ҵ� 
		System.out.println(getOwner()+"�� "+getGame()+" ������ �ϴ� ���̴�.");
	}

	
}
