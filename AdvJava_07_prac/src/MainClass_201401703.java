public class MainClass_201401703 {
	public static void main(String args[]) {
		Prac01 prac01 = new Prac01();
		prac01.run();
		Prac02 prac02 = new Prac02();
		Prac02Thread thread = new Prac02Thread();
		thread.run();
		thread.run(null);
		
	} //���� �޼ҵ带 �����ϸ鼭 ���ÿ� �����尡 ����Ǵ� ����
}
	
