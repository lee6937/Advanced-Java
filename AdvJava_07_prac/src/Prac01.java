public class Prac01 implements Runnable { //runnable => run함수를 구현해주어야 함

	public Prac01() {
		Thread thread = new Thread(() -> System.out.println("Hi!")) ; //thread생성  (람다식)
		thread.start(); // start를 하면 thread의 run메소드 실행 
	}

	@Override
	public void run() { //스레드 메소드 run을 다시 재정의
		System.out.println("Hello"); //hello 출력
	}
}