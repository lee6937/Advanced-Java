
public class Phone {
	protected String owner;
	
	public String getOwner() { //getter 생성
		return owner; //전역변수 리턴
	}
	
	public void setOwner(String owner) { //setter 생성
		this.owner = owner; //매개변수와 전역변수 일치
	}
	public Phone() { // 기본 생성자
		this.owner = null; // 전역변수 초기화
	}
	
	public Phone(String owner) { // 매개변수 하나인 생성자
		setOwner(owner); // 매개변수 값 입력
	}
	
	void talk() { //메소드
		System.out.println(getOwner()+"은 통화중이다.");
	}
}
