
public class Radio extends Controller{ //Controller ���, �ڽ� Ŭ����

	
	public Radio(boolean power) { //������
		super(power); //�θ��� power���� ���
	}

	@Override
	public String getName() { //�θ� �߻�޼ҵ� ��üȭ 
		return "����"; //���� ��
	}

}
