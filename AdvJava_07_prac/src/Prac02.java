public class Prac02 {
	public Prac02() {
		Thread thread = new Prac02Thread() { // prac02thread 객체 생성
			public void run() { // 자동으로 실행되지 않는 run => start 필요
				System.out.println("run3-"); // run3 출력
			}
		};
		thread.start(); // start가 호출되면 run을 부름
		
	}
}
