
public class Assign02Worker implements Runnable{
	public void run() { //start�� ���ָ� �˾Ƽ� ������ �� thread��
		for(int i = 0 ; i < 5 ; i++) { //5�� �ݺ���
			System.out.println(i); //���� ���
			try {
				Thread.sleep(1000); //�ƹ��� ���� �ð��� ����Ǳ� ��ٸ��� �޼ҵ�, 1��
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace(); //������ ����ϴ� ����
			}
	
		}
	}
}
