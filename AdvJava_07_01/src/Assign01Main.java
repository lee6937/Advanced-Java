
public class Assign01Main {
	private int alphabet = 'a'; //알파벳 a를 변수에 담음
	public void run() { //자동으로 실행안되니 .run()해야 실행
		Assign01Worker worker = new Assign01Worker(); //Assign01Worker 객체 인스턴스화
		worker.start(); //객체 스타트 실행

		while(worker.isAlive()) { //worker 객체가 살아있는 동안
			
			System.out.println((char)alphabet++); //알파벳의 다음값을 char형으로 형변환해서 출력 => 반복 
			try { //
				Thread.sleep(500); //아무일 없이 시간이 경과되길 기다리는 메소드, 0.5초
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace(); //에러를 출력하는 역할
			}
		}

	}
}	
