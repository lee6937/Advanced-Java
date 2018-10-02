
import java.util.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class TestRepaint extends JFrame { 
	Random r = new Random(); //���� ��ü �ν��Ͻ�ȭ
	List<Rectangle> list = new ArrayList<>(); //ArrayList�� �ν��Ͻ�ȭ, ���׸� Rectangle��ü�� ������ �ֵ��� ����
	MouseEvent e; //���콺 �̺�Ʈ ����
	
	public TestRepaint() {
		add(new MousePanel()); //���콺 �г� �߰�
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //GUI ���� �����Ҽ� �ֵ���
		setSize(400, 200); //������ ���� 
		setVisible(true); //ȭ�鿡 ���ϼ� �ְ� ǥ��
	}
	
	class MousePanel extends JPanel { //���콺 �г� Ŭ����
		protected void paintComponent(Graphics g) { // ���� ������Ʈ�� �ڽ��� ����� �׸��� �޼ҵ�
			super.paintComponent(g); //�׷��� g�� �����ε� �Ͽ� ���ۼ�
			
			addMouseListener(new MouseAdapter() {// ���콺 ����ͷ� ���콺 �̺�Ʈ ���
				public void mousePressed(MouseEvent e) { //���콺 Ŭ�� �޼ҵ常 ó���Ϸ��� mousePressed�޼ҵ常 �����ε�
					if (TestRepaint.this.e != null) { //���콺 �̺�Ʈ�� ������ �ʰ�
						if(TestRepaint.this.e.equals(e)) //���콺�� Ŭ���ϸ� ���콺 �̺�Ʈ ����ǵ���
							return; //����
					}
					
					int w = r.nextInt(20) + 5; //0���� 19���� +5 =>0���� 24���� �� ��������
					int x = r.nextInt(350); // 0���� 349���� �� ��������
					int y = r.nextInt(150); // 0���� 149���� �� ��������
					list.add(new Rectangle(x, y, w, w)); //x,y��ǥ, �ʺ�� ���̰� ���� �簢���� ����Ʈ�� �߰�
					
					repaint(); //update()�޼ҵ� ȣ��
					
					TestRepaint.this.e = e; //���콺�̺�Ʈ�� ���콺 �̺�Ʈ �Ű����� ���� ����
				}
			});
			
			for(int i = 0; i < list.size() - 1; i++) { //����Ʈ�� ������ -1���� �ݺ�
				Rectangle r = list.get(i); // ����Ʈ�� i��°���� �ҷ��ͼ� Rectangle��ü�� ����
				int x = (int) r.getX(); //�̺�Ʈ �߻� �� ���콺�� X��ǥ ��ȯ �� ���� => Ÿ�Ժ�ȯ �ʼ�
				int y = (int) r.getY(); //�̺�Ʈ �߻� �� ���콺�� Y��ǥ ��ȯ �� ���� => Ÿ�Ժ�ȯ �ʼ�
				int l = (int) r.getWidth(); //�̺�Ʈ �߻��� �ʺ� ��ȯ �� ���� => Ÿ�Ժ�ȯ �ʼ�
				g.drawRect(x, y, l, l); //x,y��ǥ �ʺ� ���̰� ���� �簢���� �׸� => grapicsŬ������ ���ǵ� drawRect()�޼ҵ�
			}
		}
	}
}
