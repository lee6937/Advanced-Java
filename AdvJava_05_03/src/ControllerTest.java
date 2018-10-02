
public class ControllerTest {
	
	public void run() { 
		Controller[] c = { new TV(false), new Radio(true) }; //Controller클래스를 배열로 생성, 안에 TV,Radio 객체 생성
		for (Controller controller : c) //Controller클래스의 인스턴스 배열을 for-each문으로 반복하며 
			controller.show(); //하나씩 show문 호출
	}
}
