
public class SmartPhone extends TelePhone{
	private String game;
	
	public String getGame() { //getter 생성
		return game; //전역변수 리턴
	}

	public void setGame(String game) { //setter 생성
		this.game = game; //매개변수와 전역변수 일치
	}
	
	public SmartPhone() { //기본 생성자 
		this.game = null; //전역변수 초기화
	}
	
	public SmartPhone(String owner, String game) { //매개변수 두개인 생성자
		super(owner,null); //super이용 => owner변수만 입력
		this.game = game; //매개변수 입력
	}
	
	void playGame() { //메소드 
		System.out.println(getOwner()+"는 "+getGame()+" 게임을 하는 중이다.");
	}

	
}
