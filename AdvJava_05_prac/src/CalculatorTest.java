import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.concurrent.SynchronousQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculatorTest extends JFrame {
	private JTextField t1; // TextField 변수 생성
	private JButton on, off; // on, off 버튼 생성
	private JButton num[]; // num 배열의 버튼 생성
	private BigDecimal result; // double형 결과값 변수 생성

	String operator = null; // 연산자를 담을 변수 생성
	String op1 = ""; // 필드 값을 담을 변수 생성
	String op2 = ""; // 필드 값을 담을 변수 생성
	double intOp1 = 0, intOp2 = 0; // 필드 값을 계산할 수 있는 형태로 바꿔서 담을 변수 생성
	int index = 0; // 필드 값 두개를 구분 짓기 위한 인덱스 변수 생성

	CalculatorTest() { // 생성자
		setTitle("계산기"); // title 이름 "계산기"
		setLayout(new BorderLayout(10, 10)); // 배치 관리자 설정 => 간격 10, 10씩
		showNorth(); // 북쪽에 보여줄 메소드 생성
		showCenter(); // 중앙에 보여줄 메소드 생성

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // GUI를 끄면 종료하도록
		setSize(250, 300); // 사이즈 설정
		setVisible(true); // GUI가 보여질 수 있도록
	}

	private void showNorth() { // 북쪽에 보여지는 메소드
		JPanel p0 = new JPanel(); // JPanel객체 생성, 인스턴스화
		t1 = new JTextField(10); // TextField값 변수에 설정

		p0.add(t1); // TextField를 Panel에 추가
		add(p0, BorderLayout.NORTH); // 북쪽에 패널을 추가
	}

	private void showCenter() { // 중앙에 보여지는 메소드
		JPanel p1 = new JPanel(); // JPanel객체 생성 => on, off버튼을 추가하기 위한
		JPanel p2 = new JPanel(); // JPanel객체 생성 => num[] 버튼을 추가하기 위한
		JPanel p3 = new JPanel(); // JPanel객체 생성 => p1, p2 JPanel을 추가하기 위한
		JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.CENTER)); // on, off버튼을 중앙정렬, 5픽셀 간격으로
		JPanel panel2 = new JPanel(new GridLayout(4, 4, 10, 10)); // num[] 버튼을 4행, 4열로 간격 10, 10씩

		JButton on = new JButton("on"); // on 버튼 객체 생성
		JButton off = new JButton("off"); // off 버튼 객체 생성
		String[] num = { "7", "8", "9", "+", "4", "5", "6", "-", "1", "2", "3", "*", "0", ".", "=", "/" }; // num배열에
																											// 차례대로 값 입력
		JButton k[] = new JButton[16]; // 16개의 버튼 생성

		for (int i = 0; i < 16; i++) { // 반복문 돌리면서
			k[i] = new JButton(num[i]); // num배열의 값들을 버튼에 입력, 생성
			panel2.add(k[i]); // panel2에 생성된 버튼 추가
		}

		panel1.add(on); // on 버튼 panel에 추가
		panel1.add(off); // off 버튼 panel에 추가

		p3.add(panel1);
		p3.add(panel2); // panel1,2를 더 큰 패널에 추가

		add(p3, BorderLayout.CENTER); // 중앙에 큰틀의 패널 추가

		ActionListener l = new ActionListener() { // 이벤트 구현 객체 생성, 인스턴스화
			public void actionPerformed(ActionEvent e) { // 이벤트 구현 메소드

				if (e.getSource() == on) // 이벤트를 발생시킨 객체의 위치값이 on과 같은지 확인
					t1.setText("0"); // 같으면 TextField를 0으로
				else if (e.getSource() == off) // 이벤트를 발생시킨 객체의 위치값이 off와 같은지 확인
					t1.setText(""); // 같으면 TextField를 초기화 
				else { //on도 off도 아닐 시
					for (int i = 0; i < 16; i++) { // 반복문 돌리면서
						if (e.getSource() == k[i]) { // 이벤트를 발생시킨 객체의 위치값이 k의 i번째 버튼과 같다면
							if (isNumeric(e.getActionCommand())) // k의 i번째 버튼의 문자열이 숫자라면
								t1.setText(t1.getText() + k[i].getText()); // TextField에 그 전 필드값들을 입력 후  숫자를 이어서 입력
							else { // 숫자가 아니고 문자라면
								if (e.getActionCommand().equals("=")) { // 이벤트를 발생시킨 객체의 문자열이 "="라면
									op2 = t1.getText().substring(index); // op2변수에 TextField값의 index이후의 문자열을 입력  => substring의 index는 0부터 시작
									
									BigDecimal OP1 = new BigDecimal(op1); // 
									BigDecimal OP2 = new BigDecimal(op2); // 깔끔한 소수점 계산을 위한 BigDecimal 객체 생성
									switch (operator) { // 연산자에 따른 switch문을 통해 계산

									case "+": // 연산자가 "+"라면
										result = OP1.add(OP2); //두개의 변수값 더해서 저장
										break; // 빠져나옴

									case "-": // 연산자가 "-"라면
										result =  OP1.subtract(OP2); //두개의 변수값 빼서 저장
										break;

									case "*": // 연산자가 "*"라면
										result = OP1.multiply(OP2); //두개의 변수값 곱해서 저장
										break;

									case "/": // 연산자가 "/"라면
										result = OP1.divide(OP2); //두개의 변수값 나눠서 저장
										break;
									}

									t1.setText("Result : " + result); //저장한 값 TextField에 설정
								} else if (e.getActionCommand().equals(".")) { //이벤트를 발생시킨 객체의 문자열이 "."라면
									t1.setText(t1.getText() + "."); //TextField값에 이어서 설정
									break; //
								} else { // "="도 "."도 아니라면
									operator = e.getActionCommand(); // operator변수에 이벤트를 발생시킨 객체의 문자열을 입력
									op1 = t1.getText(); //변수에 이벤트 발생 문자열 이전의 TextField를 가져와 입력(숫자)
									t1.setText(t1.getText() + operator); // 이전 TextField(숫자)와 연산자 둘다 TextField에 설정
									index = op1.length() + 1; // index변수를 op1의 길이에 더하기 1을 해준 값을 인덱스에 입력 => op2를 op1,연산자와 구분짓기 위한 대책
								}

							}
						}
					}

				}

			}

		};
		on.addActionListener(l);
		off.addActionListener(l);
		for (int i = 0; i < 16; i++) {
			k[i].addActionListener(l);   // 이벤트 리스너를 각 버튼에 추가해주는 작업
		}
	}

	public static boolean isNumeric(String str) // 이 String형이 숫자로 쓸 수 있는지 판단하는 메소드
	{
		try {
			double d = Double.parseDouble(str); // String을 double형으로 선언을 시도
		} catch (NumberFormatException e) {
			return false; // 오류 발생시 숫자가 아님
		}
		return true; // 숫자라면 true 반환
	}
}
