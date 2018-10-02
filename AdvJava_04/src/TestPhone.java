
public class TestPhone {
	
	public void run() { //메소드 생성
		Phone[] phones = { new Phone("대한"), new TelePhone("민국","내일"), new SmartPhone("만세","갤러그")}; //phone클래스 타입의 배열
		                 // 배열 안에는 3가지 값이 들어가 있음
		phones[0].talk(); //phones배열 0번째 인덱스의 talk메소드 
		((TelePhone) phones[1]).autoAnswering(); //phones배열의 1번째 인덱스를 Telephone타입으로 캐스팅한 후 autoAnswering메소드
		(((SmartPhone) (TelePhone) phones[2])).playGame(); //phones배열의 2번째 인덱스를 Telephone타입으로 Smartphone타입으로 캐스팅후 playGame메소드
	} 
}
