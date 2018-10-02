import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Echo2Server extends Thread{ //���� ��û�� ������ �� Ȱ���� Thread
	protected static boolean cont = true; //���� Ȯ�� ���� ����
	protected Socket connection = null; //���� ���� ���� ����
	
	public static void main(String[] args) throws IOException {
	ServerSocket server = null; //���� ���� ���� �ʱ�ȭ
	
	server = new ServerSocket(5000); //���� ���� ��Ʈ 5000���� ���� �� ����
	System.out.println("���� ���� ����");
	
	while(cont) {
		System.out.println("���� ��� ��.....");
		new Echo2Server(server.accept()); //Ŭ���̾�Ʈ ���� ��û�� �޾� server��ü ����
	}
	server.close(); //���� ������ �ݴ´�.
	}

	private Echo2Server(Socket clientSocket) { //������
		connection = clientSocket; //Ŭ���̾�Ʈ ������ ����
		start(); //thread�� run����
	}
	
	public void run() {
		BufferedReader in; //���۸��� ����
		
		System.out.println("Ŭ���̾�Ʈ�� ����� ���� ���ο� ������ ����");
		try {
			in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			//����� ��Ʈ�� ����, ���۸����� ��ǲ��Ʈ���� �̿��ؼ� �����͸� get�ؼ� ����
			String msg; //������ ���� ���� ����
			
			while((msg = in.readLine()) != null) { //���۸������� �����͵��� ������ ��, ������� ������
				System.out.println("���� �޽��� �޾Ƹ� :" + msg); //���� �޼��� ���
			}
			
			in.close(); //���۸��� ����
			connection.close(); //���� ����
		} catch (IOException e) {
			
		}
	}
}
