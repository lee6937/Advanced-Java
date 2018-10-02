
public class Student<T> implements Comparable<T> { //Comparable로 티타입 두개 비교 가능
	private String name; //이름 변수 생성
	private int score; //성적 변수 생성
	
	public Student(String name,int score) { //생성자 
		this.name = name; // 전역변수와 매개변수 일치
		this.score = score; // 전역변수와 매개변수 일치
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
	public int compareTo(T t) { //Comparable인터페이스로 메소드 재정의
		Student s = (Student) t; //t값을 Student객체로
		return this.score < s.score ? -1 : (this.score > s.score ? 1 : 0); //Student객체의 성적 비교 true이면 물음표 다음값 리턴 / 아니면 콜론 뒤에 값 리턴
	}
	
}