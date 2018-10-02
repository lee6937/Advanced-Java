
public abstract class Controller {
	
	public boolean power; //boolean 형 변수 생성
	
	public Controller(boolean power) { //생성자
		this.power = power; //전역변수와 매개변수 일치
	}
	
	public void show() { //메소드 생성
		if(power)//power가 true일때 
			System.out.println(getName()+"가 켜졌습니다."); //출력
		else //false일때
			System.out.println(getName()+"가 꺼졌습니다."); //출력
	}
	
	public abstract String getName(); //추상 메소드 생성

}
