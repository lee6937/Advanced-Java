
public class ControllableTest {
	public void run() {
		String who = "B는";
		Controllable tv = new Controllable() { //인터페이스 객체화
			public void power(String tv,boolean onOff) { //무명 클래스 구현
				String verb = onOff == true ? "켠다." : "끈다."; //true이면 verb변수에 켠다 저장 false이면 끈다 저장
				System.out.println(who + tv +"전원을 " + verb); //문구 출력
			}	
			
		}; //무명클래스는 만들고 단발성으로 사라짐 => 따로 이름을 짓지 않음
		
		tv.power("TV",true); //power함수에 true입력
		tv.power("TV",false); //power함수에 false입력
		tv.repair(); //인터페이스의 디폴트 메소드 
		Controllable.reset(); //정적 메소드임으로 객체 없이 바로 씀
	}
}


