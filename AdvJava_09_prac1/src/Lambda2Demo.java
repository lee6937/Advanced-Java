interface Negative {
	int neg(int x);
}

public class Lambda2Demo {

	public static void main(String[] args) { //���ٽ� ǥ���� �������̽��� �����ϴ� ������ ���� ���δ�.
		Negative n; //�������̽� ������ ���� ����
		n = (int x) -> { //�Ű����� int�� x�� �ְ�
			return -x; //-x�� �����Ѵ�. 
		};
		n = (x) -> { //�Ű����� x�� �ְ� => Ÿ�� ��� �����൵ ��
			return -x; //-x�� �����Ѵ�.
		};
		n = x -> { //�ϳ��� �Ű������� �ִٸ� ��ȣ ���� ����
			return -x; //-x�� �����Ѵ�.
		};
		n = (int x) -> -x; //�ϳ��� ���๮�� �ִٸ� �߰�ȣ�� ���� �����ϴ�.
		n = (x) -> -x; 
		n = x -> -x;	
	} //���� ���� ���� �ϴ� ���ٽ�
} 
