import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Echo2Server extends Thread{ //접속 요청이 들어왔을 때 활동할 Thread
	protected static boolean cont = true; //연결 확인 변수 생성
	protected Socket connection = null; //소켓 연결 변수 생성
	
	public static void main(String[] args) throws IOException {
	ServerSocket server = null; //서버 소켓 변수 초기화
	
	server = new ServerSocket(5000); //서버 소켓 포트 5000으로 생성 후 저장
	System.out.println("서버 소켓 생성");
	
	while(cont) {
		System.out.println("연결 대기 중.....");
		new Echo2Server(server.accept()); //클라이언트 연결 요청을 받아 server객체 생성
	}
	server.close(); //서버 소켓을 닫는다.
	}

	private Echo2Server(Socket clientSocket) { //생성자
		connection = clientSocket; //클라이언트 소켓을 연결
		start(); //thread의 run실행
	}
	
	public void run() {
		BufferedReader in; //버퍼리더 생성
		
		System.out.println("클라이언트와 통신을 위한 새로운 스레드 생성");
		try {
			in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			//입출력 스트림 생성, 버퍼리더의 인풋스트림을 이용해서 데이터를 get해서 저장
			String msg; //데이터 담을 변수 생성
			
			while((msg = in.readLine()) != null) { //버퍼리더안의 데이터들을 끄집어 옴, 비어있을 때까지
				System.out.println("읽은 메시지 메아리 :" + msg); //읽은 메세지 출력
			}
			
			in.close(); //버퍼리더 종료
			connection.close(); //연결 종료
		} catch (IOException e) {
			
		}
	}
}
