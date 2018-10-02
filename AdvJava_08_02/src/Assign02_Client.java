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

	private JPanel contentPane; //패널 생성
	private static JTextField textField; //소문자를 입력할 textfield 생성
	private static JTextArea textArea; //대문자를 출력할 textarea 생성
	
	/**
	 * Launch the application.
	 * @throws IOException 
	 */
	
	public Assign02_Client() {
		setTitle("Client"); //제목 Client로 설정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //종료 가능하도록
		setBounds(100, 100, 450, 300); //바운드 설정
		contentPane = new JPanel(); //패널 추가
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
		btnNewButton.addActionListener(new ActionListener() { //버튼을 눌렀을 때 액션리스너 생성
			public void actionPerformed(ActionEvent e) { //액션리스너 이벤트 실행

				Socket client = null; //클라이언트 소켓 초기화
				PrintWriter out = null; //출력 변수 초기화
				
				try {
					client = new Socket(); //소켓 객체 생성
					System.out.println("에코 서버와 연결 시도.....");
					client.connect(new InetSocketAddress("localhost", 9000), 3000); //9000포트로 소켓 연결  => 9000은 포트넘버 3000은 셋팅 넘버
					System.out.println("에코 서버와 연결 성공.....");
				} catch (Exception e1) {
				}
				
				try {
					out = new PrintWriter(client.getOutputStream(), true); //클라이언트 소켓의 아웃풋스트림 출력 객체 생성 후 저장
					
					String msg; //변수 생성
					msg = textField.getText(); //변수에 textField의 입력값을 저장
					
					out.println(msg); //입력값을 아웃풋스트림으로 보냄
					
					BufferedReader in_ = new BufferedReader(new InputStreamReader(client.getInputStream())); //버퍼 리더 생성 후 서버에서 보낸 값을 인풋스트림을 통해 받음
					System.out.println("클라이언트 문자 입력 대기");

					String msg_ = in_.readLine(); //서버에서 전송된 값을 변수에 저장
						
					textArea.setText(msg_); //저장된 값을 textArea에 입력 => 대문자로 바뀐 값이 화면에
					
					System.out.println("클라이언트 종료");
					out.close(); //출력 객체 종료
					in_.close(); //버퍼 리더 종료
					client.close(); //클라이언트 소켓 종료
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
					
					JOptionPane pane = new JOptionPane(); //JOptionPane객체 생성
					pane.setVisible(true); //보이도록 설정
					String string = JOptionPane.showInputDialog("Server IP Address?");
					if(string.contains("localhost")) {  // localhost를 입력했을 때 
					Assign02_Client frame = new Assign02_Client(); //frame을 생성하고
					frame.setVisible(true); //frame이 보이도록 설정
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		});
	}	
}

