import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class TestArrayList {

	public void run() {
		ArrayList<String> a = new ArrayList<String>(); //ArrayList 객체 생성, 제네릭 사용 String으로 타입 제한

		a.add("이동혁"); //데이터 삽입
		a.add("포도");
		a.add("배");
		a.add("사과");

		int i = 0; //변수 생성
		while (i < a.size()) { //a의 사이즈까지 반복
			if (a.get(i).length() == 2) { //a를 불러와 문자열 길이가 2이면
				System.out.println(a.get(i)); //담긴 값 출력
			}
			i++; //반복하면서
		}

		ArrayList<String> b = new ArrayList<String>(); // 한개 더 추가 생성
		b.add("이동혁"); // 데이터 삽입
		b.add("바나나");

		HashSet<String> c = new HashSet<String>(a); //ArrayList를 HashSet으로 변환
		HashSet<String> d = new HashSet<String>(b);

		c.addAll(d); //내용을 모두 c에 담음
		Iterator<String> it = c.iterator(); //it이라는 Iterator에 변환
		while (it.hasNext()) { //반복하면서 다음값으로 넘겨줌
			System.out.print(it.next() + " "); //두개의 HashSet내용 모두 출력
		}
		System.out.println(""); //줄바꿈
		
		c = new HashSet<String>(a); // 다시 재정의
		c.retainAll(d); //c와 d의 공통적인 부분만 c에 담음
		Iterator<String> it2 = c.iterator(); //it2라는 Iterator로 변환
		while (it2.hasNext()) { //반복하면서 다음값으로 넘겨줌
			System.out.println("교집합은 : " + it2.next()); //교집합 출력
		}

		c = new HashSet<String>(a); // 다시 재정의
		c.addAll(d); //내용을 모두 c에 담음
		Iterator<String> it3 = c.iterator(); //it3라는 Iterator로 변환
		while (it3.hasNext()) { //반복하면서 다음값으로 넘겨줌
			System.out.println("합집합은 : " + it3.next()); //합집합 출력
		}
	}
}
