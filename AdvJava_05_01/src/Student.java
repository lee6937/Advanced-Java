
public class Student<T> implements Comparable<T> { //Comparable�� ƼŸ�� �ΰ� �� ����
	private String name; //�̸� ���� ����
	private int score; //���� ���� ����
	
	public Student(String name,int score) { //������ 
		this.name = name; // ���������� �Ű����� ��ġ
		this.score = score; // ���������� �Ű����� ��ġ
	}

	public String getName() { //getter 
		return name; 
	}

	public void setName(String name) { //setter
		this.name = name;
	}

	public int getScore() { //getter
		return score;
	}

	public void setScore(int score) { //setter
		this.score = score;
	}
	
	@Override
	public int compareTo(T t) { //Comparable�������̽��� �޼ҵ� ������
		Student s = (Student) t; //t���� Student��ü��
		return this.score < s.score ? -1 : (this.score > s.score ? 1 : 0); //Student��ü�� ���� �� true�̸� ����ǥ ������ ���� / �ƴϸ� �ݷ� �ڿ� �� ����
	}
	
}