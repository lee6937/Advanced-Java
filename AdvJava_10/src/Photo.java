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

public class Photo extends JFrame{ //Frame을 상속받은 photo클래스
	static int[][] inImage = new int[512][512]; //원이미지 배열
	static int[][] outImage = new int[512][512]; //바뀐이미지 배열
	//사진 파일과 크기 동일
	
	Container contentPane; //이미지를 띄울 컨테이너 생성
	
	
	public static void main(String[] args) throws Exception {
		loadImage(); //사진파일 불러오기
		new Photo(); //포토 객체 생성

	}
	static public void loadImage() throws Exception { //사진 파일 불러오는 함수
		int i, k; //배열의 인덱스 변수 생성
		
		File inFp; //파일 형식의 변수
		FileInputStream inFs; //파일을 불러올 스트림 변수 
		inFp = new File("c:\\temp\\prince.raw"); // 파일의 경로를 변수에 담음
		
		inFs = new FileInputStream(inFp.getPath()); //파일 경로를 스트림 형태로 변수에 담음
		
		for(i = 0; i< 512; i++) { 
			for(k = 0; k <512; k++) { //for문 중첩해서 반복하면서 => 2차원배열임으로
				inImage[i][k] = inFs.read(); //파일스트림으로 읽어온 정보를 배열에 저장
				outImage[i][k] = inImage[i][k]; //그대로 다른배열 변수에도 저장
			}
		}
		inFs.close(); //파일 스트림 종료
	}
	
	Photo() { //생성자
		setTitle("사진 처리 프로그램"); //타이릍 이름
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //종료시 프레임을 나가도록 설정
		
		contentPane = getContentPane(); //클래스로부터 컨테이너를 가져옴
		
		addMenu(); //addMenu함수 실행
		
		DrawImage panel = new DrawImage(); //DrawImage클래스 객체화
		contentPane.add(panel, BorderLayout.CENTER); //컨테이너에 DrawImage객체 입력, 레이아웃 중간으로
		
		setSize(8 + 512 + 8, 25 + 31 + 512 + 8); //사이즈 설정
		setVisible(true); //화면에 보이도록 표시
		
		displayImage(); //displayImage함수 실행
	}
	
	class DrawImage extends JPanel { //패널을 상속받아 이미지를 그리는 클래스
		public void paintComponent(Graphics g) { //이미지를 그리기 위한 메소드
			super.paintComponent(g); 
			int R, G, B; //색깔 R,G,B 변수
			int i, k; //배열 인덱스 변수
			for(i = 0; i < 512 ; i++) {
				for(k = 0; k < 512; k++) { //이중 for문 반복하면서
					R = G = B = (int) outImage[i][k]; //이미지 배열의 값을 색깔 변수에 입력
					g.setColor(new Color(R, G, B)); //색깔 변수의 컬러를 그래픽의 컬러로 설정
					g.drawRect(k, i, 1, 1); //그래픽 함수이용하여 네모 그리기
					// (k,i)좌표에 너비,높이 각각 1씩
				}
			}
		}
	}
	void displayImage() { //이미지를 보여주는 함수
		Graphics g = contentPane.getGraphics(); //컨테이너의 그래픽을 가져와 변수에 저장
		contentPane.paintAll(g); //컨테이너에 그래픽을 보여줌
	}
	
	public void addMenu() { //메뉴 추가 함수
		JMenuBar menuBar = new JMenuBar(); //메뉴 바 생성
		setJMenuBar(menuBar); //설정
		JMenu photoMenu = new JMenu("사진 처리"); //메뉴 생성
		menuBar.add(photoMenu); //메뉴바에 메뉴 추가
		
		JMenuItem equalAction = new JMenuItem("동일한 사진");
		JMenuItem negativeAction = new JMenuItem("반전된 사진");
		JMenuItem mirror1Action = new JMenuItem("좌우 대칭 사진");
		JMenuItem mirror2Action = new JMenuItem("상하 대칭 사진");
		JMenuItem saveAction = new JMenuItem("저장");
		JMenuItem exitAction = new JMenuItem("Exit"); //메뉴 아이템 생성
		
		photoMenu.add(equalAction);
		photoMenu.add(negativeAction);
		photoMenu.add(mirror1Action);
		photoMenu.add(mirror2Action);
		photoMenu.addSeparator();
		photoMenu.add(saveAction);
		photoMenu.add(exitAction); //메뉴에 메뉴 아이템 추가
		
		equalAction.addActionListener(new ActionListener() { //"동일한 사진"을 눌렀을 때
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				equal(); //equal 함수 실행
				
			}
		});
		
		negativeAction.addActionListener(new ActionListener() { //"반전된 사진"을 눌렀을 때
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				negative(); //negative 함수 실행
				
			}
		});
		
		mirror1Action.addActionListener(new ActionListener() { //"좌우 대칭 사진"을 눌렀을 때
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				mirror1(); //mirror1 함수 실행
				
			}
		});
		mirror2Action.addActionListener(new ActionListener() { //"상하 대칭 사진"을 눌렀을 때
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				mirror2(); //mirror2 함수 실행
				
			}
		});
		saveAction.addActionListener(new ActionListener() { //"저장"을 눌렀을 때
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				saveImage(); //saveImage 함수 실행
			}
		});
		exitAction.addActionListener(new ActionListener() { //"exit"을 눌렀을 때
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0); //현재 프로세스 종료, 정상종료 => 0
				
			}
		});
	}
	
	void equal() { //동일 이미지 출력 함수
		int i, k; //변수 설정
		for(i = 0; i < 512; i++) { //512번 열 반복
			for(k = 0; k < 512 ; k++) { //512번 행 반복
				outImage[i][k] = inImage[i][k]; //2차원 배열의 값을 그대로 복사
			}
		}
		displayImage(); //이미지를 보여줌
	}
	void negative() { //반전 이미지 출력 함수
		int i, k; //변수 설정
		for(i = 0; i < 512; i++) { //512번 열 반복
			for(k = 0; k < 512 ; k++) { //512번 행 반복
				outImage[i][k] = 255 - inImage[i][k]; //255에서 각 배열의 값을 빼면 그 반대이미지가 나옴
			} //각 픽셀은 0~255중 하나의 값을 가지므로 그 반대편 값이 반대이미지
		}
		displayImage(); //이미지를 보여줌
	}
	void mirror1() { //좌우 대칭 이미지 출력 함수
		int i, k; //변수 설정
		for(i = 0; i < 512; i++) { //512번 열 반복
			for(k = 0; k < 512 ; k++) { //512번 행 반복
				outImage[i][k] = inImage[i][511 - k]; 
				//행의 값을 전체 픽셀 사이즈 -1에서 빼주면 좌우 대칭 가능
			}
		}
		displayImage(); //이미지를 보여줌
	}
	void mirror2() { //상하 대칭 이미지 출력 함수
		int i, k; //변수 설정
		for(i = 0; i < 512; i++) { //512번 열 반복
			for(k = 0; k < 512 ; k++) { //512번 행 반복
				outImage[i][k] = inImage[511 - i][k];
				//열의 값을 전체 픽셀 사이즈 -1에서 빼주면 상하 대칭 가능
			}
		}
		displayImage(); //이미지를 보여줌
	}
	public void saveImage() { //저장하는 함수
		int i, k;
		
		String newFname = "c:\\temp\\result.raw"; //새로운 파일 이름,경로 저장
		File outFp; //파일 형식의 변수
		FileOutputStream outFs; //파일 아웃스트림 변수 
		
		outFp = new File(newFname); //새로운 파일을  변수에 저장
		
		try {
			outFs = new FileOutputStream(outFp.getPath()); //파일의 경로를 아웃스트림 형태로 변수에 저장 
			for(i = 0; i < 512; i++) {
				for(k = 0; k < 512; k++) { //이중 for문 반복하면서
					outFs.write(outImage[i][k]); //이미지배열의 값을 읽어옴.
				}
			}
			outFs.close(); //아웃풋 스트림 종료
			JOptionPane.showMessageDialog(null, "파일 저장 성공", "파일 저장",JOptionPane.INFORMATION_MESSAGE); 
			//JOptionPane 생성 -> (파라미터 null, 내용-"파일 저장 성공", 제목-"파일 저장", 아이콘-"Information")
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
