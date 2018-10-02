public class MainClass_201401703 {
	public static void main(String args[]) {
		Prac01 prac01 = new Prac01();
		prac01.run();
		Prac02 prac02 = new Prac02();
		Prac02Thread thread = new Prac02Thread();
		thread.run();
		thread.run(null);
		
	} //메인 메소드를 실행하면서 동시에 스레드가 실행되는 원리
}
	
