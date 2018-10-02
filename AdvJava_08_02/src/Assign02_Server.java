import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

public class Assign02_Server extends Thread{ //접속 요청이 들어왔을 때 활동할 Thread
	protected static boolean cont = true; //서버 생성을 위한 변수 생성 => true로 계속 열려있음.
	protected Socket connection = null; //소켓 연결 변수 생성
	
	public static void main(String[] args) throws IOException {
	ServerSocket server = null; //서버 소켓 변수 초기화
	
	server = new ServerSocket(9000); //서버 소켓 포트 9000으로 생성 후 저장
	System.out.println("서버 소켓 생성");
	
	while(cont) { //서버 종료하기 전까지 계속 열려있음 => true이니까
		System.out.println("연결 대기 중.....");
		new Assign02_Server(server.accept()); //클라이언트 연결 요청을 받아 server객체 생성
	}
	server.close(); //cont을 false로 해줘야 서버 종료
	}

	private Assign02_Server(Socket clientSocket) { //생성자
		connection = clientSocket; //클라이언트 소켓과 서버 소켓을 연결
		start(); //thread의 run실행
	}
	
	public void run() {
		BufferedReader in; //버퍼리더 생성
		
		System.out.println("대문자 변환 서버 실행중...");
		try {
			in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			//입출력 스트림 생성, 버퍼리더의 인풋스트림을 이용해서 서버 소켓의 데이터를 get해서 저장
			String msg; //데이터 담을 변수 생성
			
			System.out.println("서버 문자열 입력 대기");
			while((msg = in.readLine()) != null) { //BufferedReader안에있는 데이터들을 끄집어 오는 역할 => readLine
				String alphbet = msg.toUpperCase(); //받은 값들을 대문자로 변경 후 저장
				PrintWriter out = new PrintWriter(connection.getOutputStream(), true); 
				//서버 소켓을 아웃스트림할 출력 객체 생성
				out.println(alphbet); //아웃스트림으로 출력 => 대문자로 변경된 값들 클라이언트로 전송
				System.out.println("서버 문자열 클라이언트로 전송");
			}
			
			in.close(); //버퍼 리더 종료
			connection.close(); //연결 종료
		} catch (IOException e) {
			
		}
	}
}