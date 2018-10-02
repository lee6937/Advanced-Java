public class Prac02Thread extends Thread{ //thread를 상속받은 클래스 => thread시작할 때 start를 불러주면 알아서 실행
	public Prac02Thread() { //생성자
		System.out.println("Prac02Thread-"); //출력 문구
	}
	public void run() { //run 함수
		System.out.println("run1-"); //출력문구
	}
	public void run(String s) { //매개변수 포함 run 함수
		System.out.println("run2-"); //출력문구
	}

}
