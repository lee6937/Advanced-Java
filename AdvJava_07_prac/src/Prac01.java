public class Prac01 implements Runnable { //runnable => run�Լ��� �������־�� ��

	public Prac01() {
		Thread thread = new Thread(() -> System.out.println("Hi!")) ; //thread����  (���ٽ�)
		thread.start(); // start�� �ϸ� thread�� run�޼ҵ� ���� 
	}

	@Override
	public void run() { //������ �޼ҵ� run�� �ٽ� ������
		System.out.println("Hello"); //hello ���
	}
}