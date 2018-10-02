import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Photo extends JFrame{ //Frame�� ��ӹ��� photoŬ����
	static int[][] inImage = new int[512][512]; //���̹��� �迭
	static int[][] outImage = new int[512][512]; //�ٲ��̹��� �迭
	//���� ���ϰ� ũ�� ����
	
	Container contentPane; //�̹����� ��� �����̳� ����
	
	
	public static void main(String[] args) throws Exception {
		loadImage(); //�������� �ҷ�����
		new Photo(); //���� ��ü ����

	}
	static public void loadImage() throws Exception { //���� ���� �ҷ����� �Լ�
		int i, k; //�迭�� �ε��� ���� ����
		
		File inFp; //���� ������ ����
		FileInputStream inFs; //������ �ҷ��� ��Ʈ�� ���� 
		inFp = new File("c:\\temp\\prince.raw"); // ������ ��θ� ������ ����
		
		inFs = new FileInputStream(inFp.getPath()); //���� ��θ� ��Ʈ�� ���·� ������ ����
		
		for(i = 0; i< 512; i++) { 
			for(k = 0; k <512; k++) { //for�� ��ø�ؼ� �ݺ��ϸ鼭 => 2�����迭������
				inImage[i][k] = inFs.read(); //���Ͻ�Ʈ������ �о�� ������ �迭�� ����
				outImage[i][k] = inImage[i][k]; //�״�� �ٸ��迭 �������� ����
			}
		}
		inFs.close(); //���� ��Ʈ�� ����
	}
	
	Photo() { //������
		setTitle("���� ó�� ���α׷�"); //Ÿ�̸� �̸�
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //����� �������� �������� ����
		
		contentPane = getContentPane(); //Ŭ�����κ��� �����̳ʸ� ������
		
		addMenu(); //addMenu�Լ� ����
		
		DrawImage panel = new DrawImage(); //DrawImageŬ���� ��üȭ
		contentPane.add(panel, BorderLayout.CENTER); //�����̳ʿ� DrawImage��ü �Է�, ���̾ƿ� �߰�����
		
		setSize(8 + 512 + 8, 25 + 31 + 512 + 8); //������ ����
		setVisible(true); //ȭ�鿡 ���̵��� ǥ��
		
		displayImage(); //displayImage�Լ� ����
	}
	
	class DrawImage extends JPanel { //�г��� ��ӹ޾� �̹����� �׸��� Ŭ����
		public void paintComponent(Graphics g) { //�̹����� �׸��� ���� �޼ҵ�
			super.paintComponent(g); 
			int R, G, B; //���� R,G,B ����
			int i, k; //�迭 �ε��� ����
			for(i = 0; i < 512 ; i++) {
				for(k = 0; k < 512; k++) { //���� for�� �ݺ��ϸ鼭
					R = G = B = (int) outImage[i][k]; //�̹��� �迭�� ���� ���� ������ �Է�
					g.setColor(new Color(R, G, B)); //���� ������ �÷��� �׷����� �÷��� ����
					g.drawRect(k, i, 1, 1); //�׷��� �Լ��̿��Ͽ� �׸� �׸���
					// (k,i)��ǥ�� �ʺ�,���� ���� 1��
				}
			}
		}
	}
	void displayImage() { //�̹����� �����ִ� �Լ�
		Graphics g = contentPane.getGraphics(); //�����̳��� �׷����� ������ ������ ����
		contentPane.paintAll(g); //�����̳ʿ� �׷����� ������
	}
	
	public void addMenu() { //�޴� �߰� �Լ�
		JMenuBar menuBar = new JMenuBar(); //�޴� �� ����
		setJMenuBar(menuBar); //����
		JMenu photoMenu = new JMenu("���� ó��"); //�޴� ����
		menuBar.add(photoMenu); //�޴��ٿ� �޴� �߰�
		
		JMenuItem equalAction = new JMenuItem("������ ����");
		JMenuItem negativeAction = new JMenuItem("������ ����");
		JMenuItem mirror1Action = new JMenuItem("�¿� ��Ī ����");
		JMenuItem mirror2Action = new JMenuItem("���� ��Ī ����");
		JMenuItem saveAction = new JMenuItem("����");
		JMenuItem exitAction = new JMenuItem("Exit"); //�޴� ������ ����
		
		photoMenu.add(equalAction);
		photoMenu.add(negativeAction);
		photoMenu.add(mirror1Action);
		photoMenu.add(mirror2Action);
		photoMenu.addSeparator();
		photoMenu.add(saveAction);
		photoMenu.add(exitAction); //�޴��� �޴� ������ �߰�
		
		equalAction.addActionListener(new ActionListener() { //"������ ����"�� ������ ��
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				equal(); //equal �Լ� ����
				
			}
		});
		
		negativeAction.addActionListener(new ActionListener() { //"������ ����"�� ������ ��
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				negative(); //negative �Լ� ����
				
			}
		});
		
		mirror1Action.addActionListener(new ActionListener() { //"�¿� ��Ī ����"�� ������ ��
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				mirror1(); //mirror1 �Լ� ����
				
			}
		});
		mirror2Action.addActionListener(new ActionListener() { //"���� ��Ī ����"�� ������ ��
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				mirror2(); //mirror2 �Լ� ����
				
			}
		});
		saveAction.addActionListener(new ActionListener() { //"����"�� ������ ��
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				saveImage(); //saveImage �Լ� ����
			}
		});
		exitAction.addActionListener(new ActionListener() { //"exit"�� ������ ��
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0); //���� ���μ��� ����, �������� => 0
				
			}
		});
	}
	
	void equal() { //���� �̹��� ��� �Լ�
		int i, k; //���� ����
		for(i = 0; i < 512; i++) { //512�� �� �ݺ�
			for(k = 0; k < 512 ; k++) { //512�� �� �ݺ�
				outImage[i][k] = inImage[i][k]; //2���� �迭�� ���� �״�� ����
			}
		}
		displayImage(); //�̹����� ������
	}
	void negative() { //���� �̹��� ��� �Լ�
		int i, k; //���� ����
		for(i = 0; i < 512; i++) { //512�� �� �ݺ�
			for(k = 0; k < 512 ; k++) { //512�� �� �ݺ�
				outImage[i][k] = 255 - inImage[i][k]; //255���� �� �迭�� ���� ���� �� �ݴ��̹����� ����
			} //�� �ȼ��� 0~255�� �ϳ��� ���� �����Ƿ� �� �ݴ��� ���� �ݴ��̹���
		}
		displayImage(); //�̹����� ������
	}
	void mirror1() { //�¿� ��Ī �̹��� ��� �Լ�
		int i, k; //���� ����
		for(i = 0; i < 512; i++) { //512�� �� �ݺ�
			for(k = 0; k < 512 ; k++) { //512�� �� �ݺ�
				outImage[i][k] = inImage[i][511 - k]; 
				//���� ���� ��ü �ȼ� ������ -1���� ���ָ� �¿� ��Ī ����
			}
		}
		displayImage(); //�̹����� ������
	}
	void mirror2() { //���� ��Ī �̹��� ��� �Լ�
		int i, k; //���� ����
		for(i = 0; i < 512; i++) { //512�� �� �ݺ�
			for(k = 0; k < 512 ; k++) { //512�� �� �ݺ�
				outImage[i][k] = inImage[511 - i][k];
				//���� ���� ��ü �ȼ� ������ -1���� ���ָ� ���� ��Ī ����
			}
		}
		displayImage(); //�̹����� ������
	}
	public void saveImage() { //�����ϴ� �Լ�
		int i, k;
		
		String newFname = "c:\\temp\\result.raw"; //���ο� ���� �̸�,��� ����
		File outFp; //���� ������ ����
		FileOutputStream outFs; //���� �ƿ���Ʈ�� ���� 
		
		outFp = new File(newFname); //���ο� ������  ������ ����
		
		try {
			outFs = new FileOutputStream(outFp.getPath()); //������ ��θ� �ƿ���Ʈ�� ���·� ������ ���� 
			for(i = 0; i < 512; i++) {
				for(k = 0; k < 512; k++) { //���� for�� �ݺ��ϸ鼭
					outFs.write(outImage[i][k]); //�̹����迭�� ���� �о��.
				}
			}
			outFs.close(); //�ƿ�ǲ ��Ʈ�� ����
			JOptionPane.showMessageDialog(null, "���� ���� ����", "���� ����",JOptionPane.INFORMATION_MESSAGE); 
			//JOptionPane ���� -> (�Ķ���� null, ����-"���� ���� ����", ����-"���� ����", ������-"Information")
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
