import java.util.concurrent.SynchronousQueue;

interface Printable { 
	void print();
}

public class Lambda3Demo {

	public static void main(String[] args) {
		Printable p; //�������̽� ���� ���� => ���ٽ� ���(�پ��� ����)
		p = () -> { 
			System.out.println("�ȳ�!!"); //���� ���
		};
		p = () -> System.out.println("�ȳ�!!!"); //���� ��� => �� �Լ� ����
		p.print(); //������ �Լ� ���
	}
}  

