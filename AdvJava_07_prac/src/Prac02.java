public class Prac02 {
	public Prac02() {
		Thread thread = new Prac02Thread() { // prac02thread ��ü ����
			public void run() { // �ڵ����� ������� �ʴ� run => start �ʿ�
				System.out.println("run3-"); // run3 ���
			}
		};
		thread.start(); // start�� ȣ��Ǹ� run�� �θ�
		
	}
}
