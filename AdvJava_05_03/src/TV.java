
public class TV extends Controller{ //Controller 상속, 자식 클래스
	
	
	public TV(boolean power) { //생성자
		super(power); //부모의 power변수 상속
	}

	@Override
	public String getName() { //부모 추상메소드 구체화
		return "TV"; //리턴 값
	}

}
