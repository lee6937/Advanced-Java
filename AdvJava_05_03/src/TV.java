
public class TV extends Controller{ //Controller ���, �ڽ� Ŭ����
	
	
	public TV(boolean power) { //������
		super(power); //�θ��� power���� ���
	}

	@Override
	public String getName() { //�θ� �߻�޼ҵ� ��üȭ
		return "TV"; //���� ��
	}

}
