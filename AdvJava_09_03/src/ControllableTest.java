public class ControllableTest {
	public void run() {
		String who = "B는"; //변수 입력
		Controllable tv = (String tv1, boolean onOff) -> { //람다식
			
			String verb = onOff == true ? "켠다." : "끈다."; //true이면 verb변수에 켠다 저장 false이면 끈다 저장
			System.out.println(who + tv1 +"전원을 " + verb); //문구 출력
			
		};
		
		tv.power("TV",true); //power함수에 true입력
		tv.power("TV",false); //power함수에 false입력
		tv.repair(); //인터페이스의 디폴트 메소드 
		Controllable.reset(); //정적 메소드임으로 객체 없이 바로 씀
	}
}
