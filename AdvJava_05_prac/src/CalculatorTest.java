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
	private JTextField t1; // TextField ���� ����
	private JButton on, off; // on, off ��ư ����
	private JButton num[]; // num �迭�� ��ư ����
	private BigDecimal result; // double�� ����� ���� ����

	String operator = null; // �����ڸ� ���� ���� ����
	String op1 = ""; // �ʵ� ���� ���� ���� ����
	String op2 = ""; // �ʵ� ���� ���� ���� ����
	double intOp1 = 0, intOp2 = 0; // �ʵ� ���� ����� �� �ִ� ���·� �ٲ㼭 ���� ���� ����
	int index = 0; // �ʵ� �� �ΰ��� ���� ���� ���� �ε��� ���� ����

	CalculatorTest() { // ������
		setTitle("����"); // title �̸� "����"
		setLayout(new BorderLayout(10, 10)); // ��ġ ������ ���� => ���� 10, 10��
		showNorth(); // ���ʿ� ������ �޼ҵ� ����
		showCenter(); // �߾ӿ� ������ �޼ҵ� ����

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // GUI�� ���� �����ϵ���
		setSize(250, 300); // ������ ����
		setVisible(true); // GUI�� ������ �� �ֵ���
	}

	private void showNorth() { // ���ʿ� �������� �޼ҵ�
		JPanel p0 = new JPanel(); // JPanel��ü ����, �ν��Ͻ�ȭ
		t1 = new JTextField(10); // TextField�� ������ ����

		p0.add(t1); // TextField�� Panel�� �߰�
		add(p0, BorderLayout.NORTH); // ���ʿ� �г��� �߰�
	}

	private void showCenter() { // �߾ӿ� �������� �޼ҵ�
		JPanel p1 = new JPanel(); // JPanel��ü ���� => on, off��ư�� �߰��ϱ� ����
		JPanel p2 = new JPanel(); // JPanel��ü ���� => num[] ��ư�� �߰��ϱ� ����
		JPanel p3 = new JPanel(); // JPanel��ü ���� => p1, p2 JPanel�� �߰��ϱ� ����
		JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.CENTER)); // on, off��ư�� �߾�����, 5�ȼ� ��������
		JPanel panel2 = new JPanel(new GridLayout(4, 4, 10, 10)); // num[] ��ư�� 4��, 4���� ���� 10, 10��

		JButton on = new JButton("on"); // on ��ư ��ü ����
		JButton off = new JButton("off"); // off ��ư ��ü ����
		String[] num = { "7", "8", "9", "+", "4", "5", "6", "-", "1", "2", "3", "*", "0", ".", "=", "/" }; // num�迭��
																											// ���ʴ�� �� �Է�
		JButton k[] = new JButton[16]; // 16���� ��ư ����

		for (int i = 0; i < 16; i++) { // �ݺ��� �����鼭
			k[i] = new JButton(num[i]); // num�迭�� ������ ��ư�� �Է�, ����
			panel2.add(k[i]); // panel2�� ������ ��ư �߰�
		}

		panel1.add(on); // on ��ư panel�� �߰�
		panel1.add(off); // off ��ư panel�� �߰�

		p3.add(panel1);
		p3.add(panel2); // panel1,2�� �� ū �гο� �߰�

		add(p3, BorderLayout.CENTER); // �߾ӿ� ūƲ�� �г� �߰�

		ActionListener l = new ActionListener() { // �̺�Ʈ ���� ��ü ����, �ν��Ͻ�ȭ
			public void actionPerformed(ActionEvent e) { // �̺�Ʈ ���� �޼ҵ�

				if (e.getSource() == on) // �̺�Ʈ�� �߻���Ų ��ü�� ��ġ���� on�� ������ Ȯ��
					t1.setText("0"); // ������ TextField�� 0����
				else if (e.getSource() == off) // �̺�Ʈ�� �߻���Ų ��ü�� ��ġ���� off�� ������ Ȯ��
					t1.setText(""); // ������ TextField�� �ʱ�ȭ 
				else { //on�� off�� �ƴ� ��
					for (int i = 0; i < 16; i++) { // �ݺ��� �����鼭
						if (e.getSource() == k[i]) { // �̺�Ʈ�� �߻���Ų ��ü�� ��ġ���� k�� i��° ��ư�� ���ٸ�
							if (isNumeric(e.getActionCommand())) // k�� i��° ��ư�� ���ڿ��� ���ڶ��
								t1.setText(t1.getText() + k[i].getText()); // TextField�� �� �� �ʵ尪���� �Է� ��  ���ڸ� �̾ �Է�
							else { // ���ڰ� �ƴϰ� ���ڶ��
								if (e.getActionCommand().equals("=")) { // �̺�Ʈ�� �߻���Ų ��ü�� ���ڿ��� "="���
									op2 = t1.getText().substring(index); // op2������ TextField���� index������ ���ڿ��� �Է�  => substring�� index�� 0���� ����
									
									BigDecimal OP1 = new BigDecimal(op1); // 
									BigDecimal OP2 = new BigDecimal(op2); // ����� �Ҽ��� ����� ���� BigDecimal ��ü ����
									switch (operator) { // �����ڿ� ���� switch���� ���� ���

									case "+": // �����ڰ� "+"���
										result = OP1.add(OP2); //�ΰ��� ������ ���ؼ� ����
										break; // ��������

									case "-": // �����ڰ� "-"���
										result =  OP1.subtract(OP2); //�ΰ��� ������ ���� ����
										break;

									case "*": // �����ڰ� "*"���
										result = OP1.multiply(OP2); //�ΰ��� ������ ���ؼ� ����
										break;

									case "/": // �����ڰ� "/"���
										result = OP1.divide(OP2); //�ΰ��� ������ ������ ����
										break;
									}

									t1.setText("Result : " + result); //������ �� TextField�� ����
								} else if (e.getActionCommand().equals(".")) { //�̺�Ʈ�� �߻���Ų ��ü�� ���ڿ��� "."���
									t1.setText(t1.getText() + "."); //TextField���� �̾ ����
									break; //
								} else { // "="�� "."�� �ƴ϶��
									operator = e.getActionCommand(); // operator������ �̺�Ʈ�� �߻���Ų ��ü�� ���ڿ��� �Է�
									op1 = t1.getText(); //������ �̺�Ʈ �߻� ���ڿ� ������ TextField�� ������ �Է�(����)
									t1.setText(t1.getText() + operator); // ���� TextField(����)�� ������ �Ѵ� TextField�� ����
									index = op1.length() + 1; // index������ op1�� ���̿� ���ϱ� 1�� ���� ���� �ε����� �Է� => op2�� op1,�����ڿ� �������� ���� ��å
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
			k[i].addActionListener(l);   // �̺�Ʈ �����ʸ� �� ��ư�� �߰����ִ� �۾�
		}
	}

	public static boolean isNumeric(String str) // �� String���� ���ڷ� �� �� �ִ��� �Ǵ��ϴ� �޼ҵ�
	{
		try {
			double d = Double.parseDouble(str); // String�� double������ ������ �õ�
		} catch (NumberFormatException e) {
			return false; // ���� �߻��� ���ڰ� �ƴ�
		}
		return true; // ���ڶ�� true ��ȯ
	}
}
