
public class ControllerTest {
	
	public void run() { 
		Controller[] c = { new TV(false), new Radio(true) }; //ControllerŬ������ �迭�� ����, �ȿ� TV,Radio ��ü ����
		for (Controller controller : c) //ControllerŬ������ �ν��Ͻ� �迭�� for-each������ �ݺ��ϸ� 
			controller.show(); //�ϳ��� show�� ȣ��
	}
}
