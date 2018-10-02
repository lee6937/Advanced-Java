import java.util.concurrent.SynchronousQueue;

interface Printable { 
	void print();
}

public class Lambda3Demo {

	public static void main(String[] args) {
		Printable p; //인터페이스 변수 생성 => 람다식 사용(다양한 형태)
		p = () -> { 
			System.out.println("안녕!!"); //문구 출력
		};
		p = () -> System.out.println("안녕!!!"); //문구 출력 => 두 함수 동일
		p.print(); //마지막 함수 출력
	}
}  

