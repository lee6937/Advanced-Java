
public class TestSubject {

	public void run() {
		Subject<Student<Integer>> englishSubject = new Subject<Student<Integer>>(); //Integer타입의 Student타입의 Subject클래스를 인스턴스화
		englishSubject.inputStudent("DONGHYUK", 90); //학생 이름과 성적 값 입력
		englishSubject.inputStudent("YOONGDO", 80); //학생 이름과 성적 값 입력
		englishSubject.inputStudent("KYUNGCHUL", 99); //학생 이름과 성적 값 입력
		System.out.println(englishSubject.maxScoreStudent().getScore()); //가장 성적이 높은 학생의 성적 출력
		
		try { //예외처리를 위한 try,catch
			System.out.println(englishSubject.fineScore("YOONGD").intValue()); //실행문 Integer을 int형으로 바꿔서 출력
		} catch(NullPointerException e) { // nullpoint에러 일때 => null이 리턴되었을때
			System.out.println("예외 처리"); // 이번 구문 실행
		}
		
	}
}
