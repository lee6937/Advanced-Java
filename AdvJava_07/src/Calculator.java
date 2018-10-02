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
	String operator = null; //�����ڸ� ���� ���� ����
	double result = 0; //������� ���� ���� ����
	String num1, num2 = null; //���ڸ� ���� ���� ����
	double Num1, Num2 = 0; //������ ���ڵ��� ���� ���� ����
	private JPanel contentPane; //�г� ����
	private JTextField textField; //�ʵ� ����

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {//�̺�Ʈ ����Ī �����忡 ���� Runnalbe.run()�� �����Ѵ�.
			public void run() {
				try {
					Calculator frame = new Calculator(); //���� ��ü�� �����ϰ�
					frame.setVisible(true); //�� ��ü�� ���� ���̰� �Ѵ�.
				} catch (Exception e) {
					e.printStackTrace(); //������ ����ϴ� ����
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Calculator() {
		
		setTitle("\uACC4\uC0B0\uAE30"); //Ÿ��Ʋ �̸� : "����"
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //GUI ���� �����ϵ���
		setBounds(100, 100, 450, 300); //��ġ ũ�� ����
		contentPane = new JPanel(); //�г� ����
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5)); //�г��� ��� ����
		setContentPane(contentPane); //������ �г��� �г����� ����
		contentPane.setLayout(new BorderLayout(0, 0)); //���̾ƿ��� Border�� ����
		
		JPanel panel = new JPanel(); //�г� ����
		contentPane.add(panel, BorderLayout.NORTH); //ū �г� ���ʿ� �г� �߰� 
		
		textField = new JTextField(); //�ؽ�Ʈ�ʵ� ����
		panel.add(textField); //�гο� �ؽ�Ʈ�ʵ� �߰�
		textField.setColumns(10); //���� 10 ����
		
		JPanel panel_1 = new JPanel(); //�г� ����
		contentPane.add(panel_1, BorderLayout.CENTER); //ū �г� �߾ӿ� �г� �߰�
		panel_1.setLayout(null); //���̾ƿ� ���� ����
		
		JPanel panel_2 = new JPanel(); //�г� ����
		panel_2.setBounds(102, 12, 221, 51); //��� ����
		panel_1.add(panel_2); //�г��� �߾��гξȿ� �߰�
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5)); //���̾ƿ� Flow�� ����
		
		JButton btnNewButton = new JButton("on"); //on��ư ����
		btnNewButton.addActionListener(new ActionListener() { //��ư�� �׼Ǹ����� ����
			public void actionPerformed(ActionEvent e) { //�����ؾ��� ������
				textField.setText("0"); //�ؽ�Ʈ�ʵ带 0���� ����
			}
		});
		panel_2.add(btnNewButton); //�гο� on ��ư �߰�
		
		JButton btnNewButton_1 = new JButton("off"); //off��ư ����
		btnNewButton_1.addActionListener(new ActionListener() { //��ư�� �׼Ǹ����� ����
			public void actionPerformed(ActionEvent e) { //�����ؾ��� ������
				textField.setText(""); //�ؽ�Ʈ �ʵ带 �ʱ�ȭ
			}
		});
		panel_2.add(btnNewButton_1); //�гο� off ��ư �߰�
		
		JPanel panel_3 = new JPanel(); // �г� ����
		panel_3.setBounds(83, 76, 263, 121); // ��� ����
		panel_1.add(panel_3); // �г��� �߾��гο� �߰�
		panel_3.setLayout(new GridLayout(0, 4, 10,10)); //���̾ƿ��� Grid�� => ��ư 4*4�� ������ 10�� ��
		
		JButton btnNewButton_2 = new JButton("7"); // 7��ư ����
		btnNewButton_2.addActionListener(new ActionListener() { //��ư�� �׼Ǹ����� ����
			public void actionPerformed(ActionEvent e) { //�����ؾ��� ������
				if(operator == null) //�����ڰ� ����ִٸ�
				textField.setText(textField.getText()+"7"); //�ؽ�Ʈ�ʵ忡 �������� + 7 �Է�
				else { //�����ڰ� �ִٸ�
					if(num2 == null) //������ ���� ���ڰ� ����ִٸ�
						num2 = "7"; //���� ���ڿ� 7 �Է�
					else //������ ���� ���ڰ� �ִٸ�
						num2 += "7"; // 7�� �̾ �Է�
					Num1 = Double.parseDouble(num1); //String���� ���������� ��ȯ�ؼ� ����
					Num2 = Double.parseDouble(num2); //String���� ���������� ��ȯ�ؼ� ����
					if(operator == "+") //�����ڰ� +���
						result = Num1 + Num2; //�� ���ڸ� ����
					else if(operator == "-") //�����ڰ� -���
						result = Num1 - Num2; //�� ���ڸ� ��
					else if(operator == "*") //�����ڰ� *���
						result = Num1 * Num2; //�� ���ڸ� ����
					else //�����ڰ� /���
						result = Num1 / Num2; //�� ���ڸ� ����
					
					textField.setText(""+result); //����� �ؽ�Ʈ�ʵ忡 ���
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
				operator = "+"; //�����ں����� +�Է�
				num1 = textField.getText(); //������ ���� ���ڵ���  num1�� ����
				textField.setText(textField.getText()+"+"); //�ؽ�Ʈ�ʵ忡 ���ڿ� +�Է�
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
						
						textField.setText(""+result); //��� ���ڹ�ư �޼ҵ� ����
					}
			}
		});
		panel_3.add(btnNewButton_14);
		
		JButton btnNewButton_15 = new JButton(".");
		btnNewButton_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+"."); //�ؽ�Ʈ �ʵ忡 �̾ �� �Է�
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
