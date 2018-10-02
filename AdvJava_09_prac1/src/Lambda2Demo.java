interface Negative {
	int neg(int x);
}

public class Lambda2Demo {

	public static void main(String[] args) { //람다식 표현은 인터페이스를 구현하는 식으로 많이 쓰인다.
		Negative n; //인터페이스 형식의 변수 생성
		n = (int x) -> { //매개변수 int형 x가 있고
			return -x; //-x를 리턴한다. 
		};
		n = (x) -> { //매개변수 x가 있고 => 타입 언급 안해줘도 됨
			return -x; //-x를 리턴한다.
		};
		n = x -> { //하나의 매개변수만 있다면 괄호 생략 가능
			return -x; //-x를 리턴한다.
		};
		n = (int x) -> -x; //하나의 실행문만 있다면 중괄호도 생략 가능하다.
		n = (x) -> -x; 
		n = x -> -x;	
	} //전부 같은 일을 하는 람다식
} 
