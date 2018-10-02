import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.sql.Date;
import java.util.Scanner;

public class Assign01_Client {

	public static void main(String[] args) throws IOException{
		Socket client = null; //클라이언트 소켓 변수 초기화
		PrintWriter out = null; //값을 쓸 변수 초기화
		
		try {
			client = new Socket(); //클라이언트 소켓 생성
			System.out.println("에코 서버와 연결 시도.....");
			client.connect(new InetSocketAddress("localhost", 9000), 3000); //소켓을 서버와 연결한다.
			System.out.println("에코 서버와 연결 성공.....");
		} catch (Exception e) {
		}
		
		out = new PrintWriter(client.getOutputStream(), true); //클라이언트 소켓의, 아웃풋스트림으로 출력할 객체 생성 후 저장
		
		Scanner in = new Scanner(System.in); //스캐너에 값 입력
		String msg; //보낼 문자 변수 생성
		
		System.out.println("[클라이언트] 날짜 서버 IP의 주소는?");
		while ((msg = in.nextLine()) != null) { //스캐너 입력 문장 전체가 null이 될때까지
			out.println(msg); //값들을 서버로 내보냄
		}
		
		System.out.println("클라이언트 종료");
		out.close(); //출력 객체 종료
		in.close(); // 스캐너 종료
		client.close(); //클라이언트 소켓 종료
	}
}