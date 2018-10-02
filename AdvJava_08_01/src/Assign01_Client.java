import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.sql.Date;
import java.util.Scanner;

public class Assign01_Client {

	public static void main(String[] args) throws IOException{
		Socket client = null; //Ŭ���̾�Ʈ ���� ���� �ʱ�ȭ
		PrintWriter out = null; //���� �� ���� �ʱ�ȭ
		
		try {
			client = new Socket(); //Ŭ���̾�Ʈ ���� ����
			System.out.println("���� ������ ���� �õ�.....");
			client.connect(new InetSocketAddress("localhost", 9000), 3000); //������ ������ �����Ѵ�.
			System.out.println("���� ������ ���� ����.....");
		} catch (Exception e) {
		}
		
		out = new PrintWriter(client.getOutputStream(), true); //Ŭ���̾�Ʈ ������, �ƿ�ǲ��Ʈ������ ����� ��ü ���� �� ����
		
		Scanner in = new Scanner(System.in); //��ĳ�ʿ� �� �Է�
		String msg; //���� ���� ���� ����
		
		System.out.println("[Ŭ���̾�Ʈ] ��¥ ���� IP�� �ּҴ�?");
		while ((msg = in.nextLine()) != null) { //��ĳ�� �Է� ���� ��ü�� null�� �ɶ�����
			out.println(msg); //������ ������ ������
		}
		
		System.out.println("Ŭ���̾�Ʈ ����");
		out.close(); //��� ��ü ����
		in.close(); // ��ĳ�� ����
		client.close(); //Ŭ���̾�Ʈ ���� ����
	}
}