
import java.util.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class TestRepaint extends JFrame { 
	Random r = new Random(); //랜덤 객체 인스턴스화
	List<Rectangle> list = new ArrayList<>(); //ArrayList의 인스턴스화, 제네릭 Rectangle객체만 받을수 있도록 설정
	MouseEvent e; //마우스 이벤트 생성
	
	public TestRepaint() {
		add(new MousePanel()); //마우스 패널 추가
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //GUI 끄면 종료할수 있도록
		setSize(400, 200); //사이즈 설정 
		setVisible(true); //화면에 보일수 있게 표시
	}
	
	class MousePanel extends JPanel { //마우스 패널 클래스
		protected void paintComponent(Graphics g) { // 스윙 컴포넌트가 자신의 모양을 그리는 메소드
			super.paintComponent(g); //그래픽 g를 오버로드 하여 재작성
			
			addMouseListener(new MouseAdapter() {// 마우스 어댑터로 마우스 이벤트 사용
				public void mousePressed(MouseEvent e) { //마우스 클릭 메소드만 처리하려고 mousePressed메소드만 오버로딩
					if (TestRepaint.this.e != null) { //마우스 이벤트가 끝나지 않고
						if(TestRepaint.this.e.equals(e)) //마우스를 클릭하면 마우스 이벤트 실행되도록
							return; //리턴
					}
					
					int w = r.nextInt(20) + 5; //0부터 19까지 +5 =>0부터 24까지 중 랜덤으로
					int x = r.nextInt(350); // 0부터 349까지 중 랜덤으로
					int y = r.nextInt(150); // 0부터 149까지 중 랜덤으로
					list.add(new Rectangle(x, y, w, w)); //x,y좌표, 너비와 높이가 같은 사각형을 리스트에 추가
					
					repaint(); //update()메소드 호출
					
					TestRepaint.this.e = e; //마우스이벤트와 마우스 이벤트 매개변수 같게 설정
				}
			});
			
			for(int i = 0; i < list.size() - 1; i++) { //리스트의 사이즈 -1까지 반복
				Rectangle r = list.get(i); // 리스트의 i번째값을 불러와서 Rectangle객체에 저장
				int x = (int) r.getX(); //이벤트 발생 시 마우스의 X좌표 반환 후 저장 => 타입변환 필수
				int y = (int) r.getY(); //이벤트 발생 시 마우스의 Y좌표 반환 후 저장 => 타입변환 필수
				int l = (int) r.getWidth(); //이벤트 발생시 너비를 반환 후 저장 => 타입변환 필수
				g.drawRect(x, y, l, l); //x,y좌표 너비 높이가 같은 사각형을 그림 => grapics클래스에 정의된 drawRect()메소드
			}
		}
	}
}
