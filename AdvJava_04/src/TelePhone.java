
public class TelePhone extends Phone{
	private String when;
	
	
	public String getWhen() { //getter 생성
		return when; //전역변수 리턴
	}

	public void setWhen(String when) { //setter 생성
		this.when = when; //매개변수와 전역변수 일치
	}
	
	public TelePhone() { //기본 생성자
		this.when = null; //전역변수 초기화
	}

	public TelePhone(String owner,String when) { //매개변수 두개인 생성자
		super(owner); //super이용 => 부모클래스의 owner변수 입력
		setWhen(when); //매개변수 입력
		
	}
	
	void autoAnswering() { //메소드
		System.out.println(getOwner()+"은 부재중이다. "+getWhen()+" 전화를 바란다.");
	}

}
