import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Assign02_Client extends JFrame {

	private JPanel contentPane; //�г� ����
	private static JTextField textField; //�ҹ��ڸ� �Է��� textfield ����
	private static JTextArea textArea; //�빮�ڸ� ����� textarea ����
	
	/**
	 * Launch the application.
	 * @throws IOException 
	 */
	
	public Assign02_Client() {
		setTitle("Client"); //���� Client�� ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //���� �����ϵ���
		setBounds(100, 100, 450, 300); //�ٿ�� ����
		contentPane = new JPanel(); //�г� �߰�
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(31, 25, 338, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(31, 61, 338, 152);
		contentPane.add(textArea);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() { //��ư�� ������ �� �׼Ǹ����� ����
			public void actionPerformed(ActionEvent e) { //�׼Ǹ����� �̺�Ʈ ����

				Socket client = null; //Ŭ���̾�Ʈ ���� �ʱ�ȭ
				PrintWriter out = null; //��� ���� �ʱ�ȭ
				
				try {
					client = new Socket(); //���� ��ü ����
					System.out.println("���� ������ ���� �õ�.....");
					client.connect(new InetSocketAddress("localhost", 9000), 3000); //9000��Ʈ�� ���� ����  => 9000�� ��Ʈ�ѹ� 3000�� ���� �ѹ�
					System.out.println("���� ������ ���� ����.....");
				} catch (Exception e1) {
				}
				
				try {
					out = new PrintWriter(client.getOutputStream(), true); //Ŭ���̾�Ʈ ������ �ƿ�ǲ��Ʈ�� ��� ��ü ���� �� ����
					
					String msg; //���� ����
					msg = textField.getText(); //������ textField�� �Է°��� ����
					
					out.println(msg); //�Է°��� �ƿ�ǲ��Ʈ������ ����
					
					BufferedReader in_ = new BufferedReader(new InputStreamReader(client.getInputStream())); //���� ���� ���� �� �������� ���� ���� ��ǲ��Ʈ���� ���� ����
					System.out.println("Ŭ���̾�Ʈ ���� �Է� ���");

					String msg_ = in_.readLine(); //�������� ���۵� ���� ������ ����
						
					textArea.setText(msg_); //����� ���� textArea�� �Է� => �빮�ڷ� �ٲ� ���� ȭ�鿡
					
					System.out.println("Ŭ���̾�Ʈ ����");
					out.close(); //��� ��ü ����
					in_.close(); //���� ���� ����
					client.close(); //Ŭ���̾�Ʈ ���� ����
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		btnNewButton.setBounds(383, 24, 35, 27); 
		contentPane.add(btnNewButton);
		
	}
	
	public static void main(String[] args) throws IOException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					JOptionPane pane = new JOptionPane(); //JOptionPane��ü ����
					pane.setVisible(true); //���̵��� ����
					String string = JOptionPane.showInputDialog("Server IP Address?");
					if(string.contains("localhost")) {  // localhost�� �Է����� �� 
					Assign02_Client frame = new Assign02_Client(); //frame�� �����ϰ�
					frame.setVisible(true); //frame�� ���̵��� ����
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		});
	}	
}

