
public class TV implements Controllable {
	String who;
	
	public TV(String who) { //매개변수 생성자
		this.who = who; //전역변수와 매개변수 동일시
	}
	
	public void power(boolean onOff) { 
		String verb = onOff == true ? "켠다." : "끈다."; //true이면 verb변수에 켠다 저장 false이면 끈다 저장
		System.out.println(who + "TV 전원을 " + verb); //문구 출력
	}
}
