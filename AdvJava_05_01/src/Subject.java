
public class Subject<T extends Comparable>{ //Comparable 가능한 클래스만 받도록 타입 매개변수 제한
	
	public int size; //변수 size 생성
	T s[]; //T 타입의 배열 생성
	
	public Subject() {
		s = (T[]) new Comparable[10]; // Comparable 객체 생성, 티타입의 배열로 캐스팅 
		this.size= 0; //사이즈 0으로 초기화
	}
	
	public void inputStudent(String name, int score) { //이름과 성적 입력 메소드 생성
			s[size] = (T) new Student(name, score); //배열의 사이즈와 같은 인덱스에 티타입의 student객체 생성
			this.size++;// 사이즈 업
	}
	
	public T maxScoreStudent() { //최고 성적 출력 메소드 생성
		T maxStudent = s[0]; //배열의 첫번째 인덱스값을 maxStudent변수에 입력
		for(int i =1; i < this.size; i++) { //size까지 반복
			if(((Student)maxStudent).compareTo(s[i])<0) { //maxStudent를 Student객체 타입으로 캐스팅 후 비교해주고 값이 0보다 작으면
				maxStudent = s[i]; //s[i]값의 성적이 크므로 그 값을 maxStudent에 입력
			}
		}
		return maxStudent; // 반복 후 최고 성적 리턴
	}

	public Integer fineScore(String a) { // 이름을 입력하면 성적을 출력하는 메소드 생성
		int score = 0; //변수 생성
		for(int i =0 ; i < this.size; i++) {// size까지 반복
			if(((Student)s[i]).getName().equals(a)) {//getName메소드 호출을 위해 배열을 Student로 캐스팅 한 후 매개변수와 비교
				score = ((Student)s[i]).getScore(); // 변수에 찾은 배열의 성적값 입력
				return score; // 성적값 리턴
			}
		}
		return null; //못찾으면 null 리턴
	}
	
}
