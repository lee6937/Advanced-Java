
public class Assign02Main {
	private int alphabet = 'a'; //���ĺ� a�� ������ ����
	public void run() { //�ڵ����� ����ȵǴ� .run�ؾ���
		Thread thread = new Thread(new Assign02Worker()); 
		/*Assign02Worker�� Runnable �������̽� �̹Ƿ�
                  ������ �����带 ����� ������ ���ڿ� �ٿ��־�� �Ѵ�.*/		
		thread.start(); //������ ��ŸƮ ����

		while(thread.isAlive()) { //�����尡 ����ִ� ����
			
			System.out.println((char)alphabet++); //���ĺ��� �������� char������ ����ȯ�ؼ� ��� => �ݺ� 
			try {
				Thread.sleep(500); //�ƹ��� ���� �ð��� ����Ǳ� ��ٸ��� �޼ҵ�, 0.5��
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace(); //������ ����ϴ� ����
			}
		}


	}
}
