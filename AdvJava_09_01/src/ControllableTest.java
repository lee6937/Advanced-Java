
public class ControllableTest {
	public void run() { 
		Controllable tv = new TV("A는"); //매개변수 입력한 생성자 생성, Controllable 인터페이스 구현
		tv.power(true);  //true 입력 power메소드
		tv.power(false); //false 입력한 power메소드
		tv.repair(); //인터페이스의 repair메소드 
		Controllable.reset(); //정적 메소드임으로 객체 없이 바로 씀
	}
}
