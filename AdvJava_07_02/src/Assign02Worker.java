
public class Assign02Worker implements Runnable{
	public void run() { //start만 해주면 알아서 실행이 됨 thread라서
		for(int i = 0 ; i < 5 ; i++) { //5번 반복문
			System.out.println(i); //숫자 출력
			try {
				Thread.sleep(1000); //아무일 없이 시간이 경과되길 기다리는 메소드, 1초
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace(); //에러를 출력하는 역할
			}
	
		}
	}
}
