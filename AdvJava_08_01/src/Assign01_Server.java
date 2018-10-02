import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Assign01_Server extends Thread{ //���� ��û�� ������ �� Ȱ���� thread
	protected static boolean cont = true; //���� Ȯ�� ���� ����
	protected Socket connection = null; //���� ���� ���� ����
	
	public static void main(String[] args) throws IOException {
	ServerSocket server = null; //���� ���� ���� �ʱ�ȭ
	
	server = new ServerSocket(9000);//���� ���� ��Ʈ 9000���� ���� �� ����
	System.out.println("���� ���� ����");
	
	while(cont) {
		System.out.println("���� ��� ��.....");
		new Assign01_Server(server.accept()); //Ŭ���̾�Ʈ ���� ��û�� �޾� server��ü ����
	}
	server.close(); //���� ������ �ݴ´�.
	}

	private Assign01_Server(Socket clientSocket) { //������
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
			String weather = new Date().toString() ; //��¥�� �ð��� ������ ����
			
			while((msg = in.readLine()) != null) { //���۸������� �����͵��� ������ ��, ������� ������
				System.out.println("[����]" + weather); //��¥�� �ð� ���� ���
			}
			
			in.close(); //���۸��� ����
			connection.close(); //���� ����
		} catch (IOException e) {
			
		}
	}
}