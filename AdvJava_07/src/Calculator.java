import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Calculator extends JFrame {
	String operator = null; //연산자를 담을 변수 생성
	double result = 0; //결과값을 담을 변수 생성
	String num1, num2 = null; //숫자를 담을 변수 생성
	double Num1, Num2 = 0; //더블형 숫자들을 담을 변수 생성
	private JPanel contentPane; //패널 생성
	private JTextField textField; //필드 생성

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {//이벤트 디스패칭 쓰레드에 의해 Runnalbe.run()을 실행한다.
			public void run() {
				try {
					Calculator frame = new Calculator(); //계산기 객체를 생성하고
					frame.setVisible(true); //그 객체를 눈에 보이게 한다.
				} catch (Exception e) {
					e.printStackTrace(); //에러를 출력하는 역할
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Calculator() {
		
		setTitle("\uACC4\uC0B0\uAE30"); //타이틀 이름 : "계산기"
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //GUI 끄면 종료하도록
		setBounds(100, 100, 450, 300); //위치 크기 설정
		contentPane = new JPanel(); //패널 생성
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5)); //패널의 경계 설정
		setContentPane(contentPane); //선택한 패널을 패널위에 설정
		contentPane.setLayout(new BorderLayout(0, 0)); //레이아웃을 Border로 설정
		
		JPanel panel = new JPanel(); //패널 생성
		contentPane.add(panel, BorderLayout.NORTH); //큰 패널 북쪽에 패널 추가 
		
		textField = new JTextField(); //텍스트필드 생성
		panel.add(textField); //패널에 텍스트필드 추가
		textField.setColumns(10); //간격 10 설정
		
		JPanel panel_1 = new JPanel(); //패널 생성
		contentPane.add(panel_1, BorderLayout.CENTER); //큰 패널 중앙에 패널 추가
		panel_1.setLayout(null); //레이아웃 설정 안함
		
		JPanel panel_2 = new JPanel(); //패널 생성
		panel_2.setBounds(102, 12, 221, 51); //경계 설정
		panel_1.add(panel_2); //패널을 중앙패널안에 추가
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5)); //레이아웃 Flow로 설정
		
		JButton btnNewButton = new JButton("on"); //on버튼 생성
		btnNewButton.addActionListener(new ActionListener() { //버튼의 액션리스너 생성
			public void actionPerformed(ActionEvent e) { //수행해야할 리스너
				textField.setText("0"); //텍스트필드를 0으로 설정
			}
		});
		panel_2.add(btnNewButton); //패널에 on 버튼 추가
		
		JButton btnNewButton_1 = new JButton("off"); //off버튼 생성
		btnNewButton_1.addActionListener(new ActionListener() { //버튼의 액션리스너 생성
			public void actionPerformed(ActionEvent e) { //수행해야할 리스너
				textField.setText(""); //텍스트 필드를 초기화
			}
		});
		panel_2.add(btnNewButton_1); //패널에 off 버튼 추가
		
		JPanel panel_3 = new JPanel(); // 패널 생성
		panel_3.setBounds(83, 76, 263, 121); // 경계 설정
		panel_1.add(panel_3); // 패널을 중앙패널에 추가
		panel_3.setLayout(new GridLayout(0, 4, 10,10)); //레이아웃을 Grid로 => 버튼 4*4로 간격을 10씩 줌
		
		JButton btnNewButton_2 = new JButton("7"); // 7버튼 생성
		btnNewButton_2.addActionListener(new ActionListener() { //버튼의 액션리스너 생성
			public void actionPerformed(ActionEvent e) { //수행해야할 리스너
				if(operator == null) //연산자가 비어있다면
				textField.setText(textField.getText()+"7"); //텍스트필드에 원래숫자 + 7 입력
				else { //연산자가 있다면
					if(num2 == null) //연산자 뒤의 숫자가 비어있다면
						num2 = "7"; //뒤의 숫자에 7 입력
					else //연산자 뒤의 숫자가 있다면
						num2 += "7"; // 7을 이어서 입력
					Num1 = Double.parseDouble(num1); //String형을 더블형으로 변환해서 저장
					Num2 = Double.parseDouble(num2); //String형을 더블형으로 변환해서 저장
					if(operator == "+") //연산자가 +라면
						result = Num1 + Num2; //두 숫자를 더함
					else if(operator == "-") //연산자가 -라면
						result = Num1 - Num2; //두 숫자를 뺌
					else if(operator == "*") //연산자가 *라면
						result = Num1 * Num2; //두 숫자를 곱함
					else //연산자가 /라면
						result = Num1 / Num2; //두 숫자를 나눔
					
					textField.setText(""+result); //결과값 텍스트필드에 출력
				}
			}
		});
		panel_3.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("8");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(operator == null)
					textField.setText(textField.getText()+"8");
					else {
						if(num2 == null)
							num2 = "8";
						else
							num2 += "8";
						Num1 = Double.parseDouble(num1);
						Num2 = Double.parseDouble(num2);
						if(operator == "+")
							result = Num1 + Num2;
						else if(operator == "-")
							result = Num1 - Num2;
						else if(operator == "*")
							result = Num1 * Num2;
						else
							result = Num1 / Num2;
						
						textField.setText(""+result);
					}
			}
		});
		panel_3.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("9");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(operator == null)
					textField.setText(textField.getText()+"9");
					else {
						if(num2 == null)
							num2 = "9";
						else
							num2 += "9";
						Num1 = Double.parseDouble(num1);
						Num2 = Double.parseDouble(num2);
						if(operator == "+")
							result = Num1 + Num2;
						else if(operator == "-")
							result = Num1 - Num2;
						else if(operator == "*")
							result = Num1 * Num2;
						else
							result = Num1 / Num2;
						
						textField.setText(""+result);
					}
			}
		});
		panel_3.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("+");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				operator = "+"; //연산자변수에 +입력
				num1 = textField.getText(); //연산자 이전 숫자들을  num1에 저장
				textField.setText(textField.getText()+"+"); //텍스트필드에 숫자와 +입력
			}
		});
		panel_3.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("4");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(operator == null)
					textField.setText(textField.getText()+"4");
					else {
						if(num2 == null)
							num2 = "4";
						else
							num2 += "4";
						Num1 = Double.parseDouble(num1);
						Num2 = Double.parseDouble(num2);
						if(operator == "+")
							result = Num1 + Num2;
						else if(operator == "-")
							result = Num1 - Num2;
						else if(operator == "*")
							result = Num1 * Num2;
						else
							result = Num1 / Num2;
						
						textField.setText(""+result);
					}
			}
		});
		panel_3.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("5");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(operator == null)
					textField.setText(textField.getText()+"5");
					else {
						if(num2 == null)
							num2 = "5";
						else
							num2 += "5";
						Num1 = Double.parseDouble(num1);
						Num2 = Double.parseDouble(num2);
						if(operator == "+")
							result = Num1 + Num2;
						else if(operator == "-")
							result = Num1 - Num2;
						else if(operator == "*")
							result = Num1 * Num2;
						else
							result = Num1 / Num2;
						
						textField.setText(""+result);
					}
			}
		});
		panel_3.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("6");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(operator == null)
					textField.setText(textField.getText()+"6");
					else {
						if(num2 == null)
							num2 = "6";
						else
							num2 += "6";
						Num1 = Double.parseDouble(num1);
						Num2 = Double.parseDouble(num2);
						if(operator == "+")
							result = Num1 + Num2;
						else if(operator == "-")
							result = Num1 - Num2;
						else if(operator == "*")
							result = Num1 * Num2;
						else
							result = Num1 / Num2;
						
						textField.setText(""+result);
					}
			}
		});
		panel_3.add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("-");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				operator = "-";
				num1 = textField.getText();
				textField.setText(textField.getText()+"-");
			}
		});
		panel_3.add(btnNewButton_9);
		
		JButton btnNewButton_10 = new JButton("1");
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(operator == null)
					textField.setText(textField.getText()+"1");
					else {
						if(num2 == null)
							num2 = "1";
						else
							num2 += "1";
						Num1 = Double.parseDouble(num1);
						Num2 = Double.parseDouble(num2);
						if(operator == "+")
							result = Num1 + Num2;
						else if(operator == "-")
							result = Num1 - Num2;
						else if(operator == "*")
							result = Num1 * Num2;
						else
							result = Num1 / Num2;
						
						textField.setText(""+result);
					}
			}
		});
		panel_3.add(btnNewButton_10);
		
		JButton btnNewButton_11 = new JButton("2");
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(operator == null)
					textField.setText(textField.getText()+"2");
					else {
						if(num2 == null)
							num2 = "2";
						else
							num2 += "2";
						Num1 = Double.parseDouble(num1);
						Num2 = Double.parseDouble(num2);
						if(operator == "+")
							result = Num1 + Num2;
						else if(operator == "-")
							result = Num1 - Num2;
						else if(operator == "*")
							result = Num1 * Num2;
						else
							result = Num1 / Num2;
						
						textField.setText(""+result);
					}
			}
		});
		panel_3.add(btnNewButton_11);
		
		JButton btnNewButton_12 = new JButton("3");
		btnNewButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(operator == null)
					textField.setText(textField.getText()+"3");
					else {
						if(num2 == null)
							num2 = "3";
						else
							num2 += "3";
						Num1 = Double.parseDouble(num1);
						Num2 = Double.parseDouble(num2);
						if(operator == "+")
							result = Num1 + Num2;
						else if(operator == "-")
							result = Num1 - Num2;
						else if(operator == "*")
							result = Num1 * Num2;
						else
							result = Num1 / Num2;
						
						textField.setText(""+result);
					}
			}
		});
		panel_3.add(btnNewButton_12);
		
		JButton btnNewButton_13 = new JButton("*");
		btnNewButton_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				operator = "*";
				num1 = textField.getText();
				textField.setText(textField.getText()+"*");
			}
		});
		panel_3.add(btnNewButton_13);
		
		JButton btnNewButton_14 = new JButton("0");
		btnNewButton_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(operator == null)
					textField.setText(textField.getText()+"0");
					else {
						if(num2 == null)
							num2 = "0";
						else
							num2 += "0";
						Num1 = Double.parseDouble(num1);
						Num2 = Double.parseDouble(num2);
						if(operator == "+")
							result = Num1 + Num2;
						else if(operator == "-")
							result = Num1 - Num2;
						else if(operator == "*")
							result = Num1 * Num2;
						else
							result = Num1 / Num2;
						
						textField.setText(""+result); //모든 숫자버튼 메소드 동일
					}
			}
		});
		panel_3.add(btnNewButton_14);
		
		JButton btnNewButton_15 = new JButton(".");
		btnNewButton_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+"."); //텍스트 필드에 이어서 점 입력
			}
		});
		panel_3.add(btnNewButton_15);
		
		JButton btnNewButton_16 = new JButton("=");
		btnNewButton_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				textField.setText("Result = "+textField.getText());
			}
		});
		panel_3.add(btnNewButton_16);
		
		JButton btnNewButton_17 = new JButton("/");
		btnNewButton_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				operator = "/";
				num1 = textField.getText();
				textField.setText(textField.getText()+"/");
			}
		});
		panel_3.add(btnNewButton_17);
	}

}
