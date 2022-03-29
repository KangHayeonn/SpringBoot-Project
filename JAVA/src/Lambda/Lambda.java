package Lambda;

public class Lambda {
	public static void main(String[] args) {
		// Object obj = (a, b) -> a > b ? a : b; // ���ٽ�. �͸�ü
		/* ver1 : ����
		Object obj = new Object () {
			int max(int a, int b) {
				return a > b ? a : b;
			}
		};
		
		int value = obj.max(3, 5); // �Լ��� �������̽� �ʿ� ( ����ȯ ���� �� ����)
		*/
		
		/* ver2 : ����
		MyFunction f = new MyFunction () {
			public int max(int a, int b) { // �������̵� - ���������ڴ� ���� ���ٲ۴�.
				return a > b ? a : b;
			}
		};
		
		int value = f.max(3, 5); // �Լ��� �������̽�
		System.out.println("value= " + value);
		*/
		
		// ver3 : ����
		// ���ٽ�(�͸� ��ü)�� �ٷ�� ���� ���������� Ÿ���� �Լ��� �������̽��� �Ѵ�.
		MyFunction f = (a, b) -> a > b ? a : b;
		
		int value = f.max(3, 5);
		System.out.println("value= " + value);
	}
}

// �Լ��� �������̽� ����
@FunctionalInterface // �Լ��� �������̽��� �� �ϳ��� �߻� �޼��常 ������ ��.
interface MyFunction {
	// public abstract int max(int a, int b);
	int max(int a, int b); // �������̽��� �޼���� ��� �⺻������ public���� abstract
}