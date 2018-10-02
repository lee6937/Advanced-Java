
public class Assign02Main {
	private int alphabet = 'a'; //알파벳 a를 변수에 담음
	public void run() { //자동으로 실행안되니 .run해야함
		Thread thread = new Thread(new Assign02Worker()); 
		/*Assign02Worker는 Runnable 인터페이스 이므로
                  별도의 쓰레드를 만들고 쓰레드 인자에 붙여주어야 한다.*/		
		thread.start(); //쓰레드 스타트 실행

		while(thread.isAlive()) { //쓰레드가 살아있는 동안
			
			System.out.println((char)alphabet++); //알파벳의 다음값을 char형으로 형변환해서 출력 => 반복 
			try {
				Thread.sleep(500); //아무일 없이 시간이 경과되길 기다리는 메소드, 0.5초
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace(); //에러를 출력하는 역할
			}
		}


	}
}
