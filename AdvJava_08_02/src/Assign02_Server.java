import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

public class Assign02_Server extends Thread{ //���� ��û�� ������ �� Ȱ���� Thread
	protected static boolean cont = true; //���� ������ ���� ���� ���� => true�� ��� ��������.
	protected Socket connection = null; //���� ���� ���� ����
	
	public static void main(String[] args) throws IOException {
	ServerSocket server = null; //���� ���� ���� �ʱ�ȭ
	
	server = new ServerSocket(9000); //���� ���� ��Ʈ 9000���� ���� �� ����
	System.out.println("���� ���� ����");
	
	while(cont) { //���� �����ϱ� ������ ��� �������� => true�̴ϱ�
		System.out.println("���� ��� ��.....");
		new Assign02_Server(server.accept()); //Ŭ���̾�Ʈ ���� ��û�� �޾� server��ü ����
	}
	server.close(); //cont�� false�� ����� ���� ����
	}

	private Assign02_Server(Socket clientSocket) { //������
		connection = clientSocket; //Ŭ���̾�Ʈ ���ϰ� ���� ������ ����
		start(); //thread�� run����
	}
	
	public void run() {
		BufferedReader in; //���۸��� ����
		
		System.out.println("�빮�� ��ȯ ���� ������...");
		try {
			in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			//����� ��Ʈ�� ����, ���۸����� ��ǲ��Ʈ���� �̿��ؼ� ���� ������ �����͸� get�ؼ� ����
			String msg; //������ ���� ���� ����
			
			System.out.println("���� ���ڿ� �Է� ���");
			while((msg = in.readLine()) != null) { //BufferedReader�ȿ��ִ� �����͵��� ������ ���� ���� => readLine
				String alphbet = msg.toUpperCase(); //���� ������ �빮�ڷ� ���� �� ����
				PrintWriter out = new PrintWriter(connection.getOutputStream(), true); 
				//���� ������ �ƿ���Ʈ���� ��� ��ü ����
				out.println(alphbet); //�ƿ���Ʈ������ ��� => �빮�ڷ� ����� ���� Ŭ���̾�Ʈ�� ����
				System.out.println("���� ���ڿ� Ŭ���̾�Ʈ�� ����");
			}
			
			in.close(); //���� ���� ����
			connection.close(); //���� ����
		} catch (IOException e) {
			
		}
	}
}