public class Prac02Thread extends Thread{ //thread�� ��ӹ��� Ŭ���� => thread������ �� start�� �ҷ��ָ� �˾Ƽ� ����
	public Prac02Thread() { //������
		System.out.println("Prac02Thread-"); //��� ����
	}
	public void run() { //run �Լ�
		System.out.println("run1-"); //��¹���
	}
	public void run(String s) { //�Ű����� ���� run �Լ�
		System.out.println("run2-"); //��¹���
	}

}
