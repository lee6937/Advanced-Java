
public class Assign01Main {
	private int alphabet = 'a'; //���ĺ� a�� ������ ����
	public void run() { //�ڵ����� ����ȵǴ� .run()�ؾ� ����
		Assign01Worker worker = new Assign01Worker(); //Assign01Worker ��ü �ν��Ͻ�ȭ
		worker.start(); //��ü ��ŸƮ ����

		while(worker.isAlive()) { //worker ��ü�� ����ִ� ����
			
			System.out.println((char)alphabet++); //���ĺ��� �������� char������ ����ȯ�ؼ� ��� => �ݺ� 
			try { //
				Thread.sleep(500); //�ƹ��� ���� �ð��� ����Ǳ� ��ٸ��� �޼ҵ�, 0.5��
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace(); //������ ����ϴ� ����
			}
		}

	}
}	
