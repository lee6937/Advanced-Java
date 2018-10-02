
public interface Controllable { //인터페이스
	
	default void repair() { //디폴트 메소드 => 인터페이스에서 구현함
		System.out.println("서비스 센터에서 수리해야한다.");
	}
	static void reset() { //정적 메소드 => 객체 필요 없음
		System.out.println("내가 초기화 할 수 있음");
	}
	void power(boolean onOff); //추상 메소드 => 내용은 클래스에서 구현
	
}
