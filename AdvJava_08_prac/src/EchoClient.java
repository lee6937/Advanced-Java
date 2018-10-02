import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {

	public static void main(String[] args) throws IOException{
		Socket client = null; //클라이언트 소켓 변수 초기화
		PrintWriter out = null; //값을 쓸 변수 초기화
		
		try {
			client = new Socket(); //클라이언트 소켓 생성
			System.out.println("에코 서버와 연결 시도.....");
			client.connect(new InetSocketAddress("localhost", 5000), 3000); //소켓을 서버와 연결한다.
			System.out.println("에코 서버와 연결 성공.....");
		} catch (Exception e) {
		}
		
		out = new PrintWriter(client.getOutputStream(), true); //클라이언트 소켓의, 아웃풋스트림으로 출력할 객체 생성 후 저장
		
		Scanner in = new Scanner(System.in); //스캐너에 값 입력
		String msg; //보낼 문자 변수 생성
		
		System.out.println("보낼 메세지가 있나요?");
		while ((msg = in.nextLine()) != null) { //스캐너 입력 문장 전체가 null이 될때까지
			if(msg.equals("잘 있어요.")) //잘 있어요 문장일 시
				break; //서버로 보내지 않음
			out.println(msg); //값들을 서버로 보냄
			System.out.print("보낼 메시지가 있나요?");
		}
		
		System.out.println("클라이언트 종료");
		out.close(); //출력 객체 종료
		in.close(); //스캐너 종료
		client.close(); //클라이언트 소켓 종료
	}

}
