import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class TestArrayList {

	public void run() {
		ArrayList<String> a = new ArrayList<String>(); //ArrayList ��ü ����, ���׸� ��� String���� Ÿ�� ����

		a.add("�̵���"); //������ ����
		a.add("����");
		a.add("��");
		a.add("���");

		int i = 0; //���� ����
		while (i < a.size()) { //a�� ��������� �ݺ�
			if (a.get(i).length() == 2) { //a�� �ҷ��� ���ڿ� ���̰� 2�̸�
				System.out.println(a.get(i)); //��� �� ���
			}
			i++; //�ݺ��ϸ鼭
		}

		ArrayList<String> b = new ArrayList<String>(); // �Ѱ� �� �߰� ����
		b.add("�̵���"); // ������ ����
		b.add("�ٳ���");

		HashSet<String> c = new HashSet<String>(a); //ArrayList�� HashSet���� ��ȯ
		HashSet<String> d = new HashSet<String>(b);

		c.addAll(d); //������ ��� c�� ����
		Iterator<String> it = c.iterator(); //it�̶�� Iterator�� ��ȯ
		while (it.hasNext()) { //�ݺ��ϸ鼭 ���������� �Ѱ���
			System.out.print(it.next() + " "); //�ΰ��� HashSet���� ��� ���
		}
		System.out.println(""); //�ٹٲ�
		
		c = new HashSet<String>(a); // �ٽ� ������
		c.retainAll(d); //c�� d�� �������� �κи� c�� ����
		Iterator<String> it2 = c.iterator(); //it2��� Iterator�� ��ȯ
		while (it2.hasNext()) { //�ݺ��ϸ鼭 ���������� �Ѱ���
			System.out.println("�������� : " + it2.next()); //������ ���
		}

		c = new HashSet<String>(a); // �ٽ� ������
		c.addAll(d); //������ ��� c�� ����
		Iterator<String> it3 = c.iterator(); //it3��� Iterator�� ��ȯ
		while (it3.hasNext()) { //�ݺ��ϸ鼭 ���������� �Ѱ���
			System.out.println("�������� : " + it3.next()); //������ ���
		}
	}
}
