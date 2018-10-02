
public class TestSubject {

	public void run() {
		Subject<Student<Integer>> englishSubject = new Subject<Student<Integer>>(); //IntegerŸ���� StudentŸ���� SubjectŬ������ �ν��Ͻ�ȭ
		englishSubject.inputStudent("DONGHYUK", 90); //�л� �̸��� ���� �� �Է�
		englishSubject.inputStudent("YOONGDO", 80); //�л� �̸��� ���� �� �Է�
		englishSubject.inputStudent("KYUNGCHUL", 99); //�л� �̸��� ���� �� �Է�
		System.out.println(englishSubject.maxScoreStudent().getScore()); //���� ������ ���� �л��� ���� ���
		
		try { //����ó���� ���� try,catch
			System.out.println(englishSubject.fineScore("YOONGD").intValue()); //���๮ Integer�� int������ �ٲ㼭 ���
		} catch(NullPointerException e) { // nullpoint���� �϶� => null�� ���ϵǾ�����
			System.out.println("���� ó��"); // �̹� ���� ����
		}
		
	}
}
