
public class Subject<T extends Comparable>{ //Comparable ������ Ŭ������ �޵��� Ÿ�� �Ű����� ����
	
	public int size; //���� size ����
	T s[]; //T Ÿ���� �迭 ����
	
	public Subject() {
		s = (T[]) new Comparable[10]; // Comparable ��ü ����, ƼŸ���� �迭�� ĳ���� 
		this.size= 0; //������ 0���� �ʱ�ȭ
	}
	
	public void inputStudent(String name, int score) { //�̸��� ���� �Է� �޼ҵ� ����
			s[size] = (T) new Student(name, score); //�迭�� ������� ���� �ε����� ƼŸ���� student��ü ����
			this.size++;// ������ ��
	}
	
	public T maxScoreStudent() { //�ְ� ���� ��� �޼ҵ� ����
		T maxStudent = s[0]; //�迭�� ù��° �ε������� maxStudent������ �Է�
		for(int i =1; i < this.size; i++) { //size���� �ݺ�
			if(((Student)maxStudent).compareTo(s[i])<0) { //maxStudent�� Student��ü Ÿ������ ĳ���� �� �����ְ� ���� 0���� ������
				maxStudent = s[i]; //s[i]���� ������ ũ�Ƿ� �� ���� maxStudent�� �Է�
			}
		}
		return maxStudent; // �ݺ� �� �ְ� ���� ����
	}

	public Integer fineScore(String a) { // �̸��� �Է��ϸ� ������ ����ϴ� �޼ҵ� ����
		int score = 0; //���� ����
		for(int i =0 ; i < this.size; i++) {// size���� �ݺ�
			if(((Student)s[i]).getName().equals(a)) {//getName�޼ҵ� ȣ���� ���� �迭�� Student�� ĳ���� �� �� �Ű������� ��
				score = ((Student)s[i]).getScore(); // ������ ã�� �迭�� ������ �Է�
				return score; // ������ ����
			}
		}
		return null; //��ã���� null ����
	}
	
}
