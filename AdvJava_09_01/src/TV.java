
public class TV implements Controllable {
	String who;
	
	public TV(String who) { //�Ű����� ������
		this.who = who; //���������� �Ű����� ���Ͻ�
	}
	
	public void power(boolean onOff) { 
		String verb = onOff == true ? "�Ҵ�." : "����."; //true�̸� verb������ �Ҵ� ���� false�̸� ���� ����
		System.out.println(who + "TV ������ " + verb); //���� ���
	}
}
