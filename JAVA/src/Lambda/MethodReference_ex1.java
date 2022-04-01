package Lambda;

import java.util.function.Function;
import java.util.function.Supplier;

public class MethodReference_ex1 {
	public static void main(String[] args) {
		// ���ٽ� ( (�Է�) -> Ŭ�����̸�.�޼����̸�(�Է�) )
		// Function<String, Integer> f = (String s) -> Integer.parseInt(s);
		
		// �޼��� ���� (Ŭ�����̸� :: �޼����̸�)
		Function<String, Integer> f = Integer::parseInt;
		
		System.out.println(f.apply("200")+100); // ���� ����

		// Supplier�� �Է�X, ��� O
		// Supplier<MyClass> s = () -> new MyClass();
		
		// �޼��� ����
		// Supplier<MyClass> s = MyClass::new;
		
		/*
		MyClass mc = s.get();
		System.out.println(mc); // ��ü1
		System.out.println(s.get()); // ��ü2 (!=��ü1)
		*/
		
		// Function�� �Է�O, ��� O
		// Function<Integer, MyClass> s = (i) -> new MyClass(i);
		
		// �޼��� ����
		Function<Integer, MyClass> s = MyClass::new;
		
		MyClass mc = s.apply(100);
		System.out.println(mc.iv); // ��ü1
		System.out.println(s.apply(200).iv); // ��ü2 (!=��ü1)
		
		// Function<Integer, int[]> f2 = (i) -> new int[i];
		Function<Integer, int[]> f2 = int[]::new; // �޼��� ����
		int[] arr = f2.apply(100);
		System.out.println("arr.length= " + arr.length);
		System.out.println(f2.apply(100).length);
	}
}

class MyClass {
	int iv;
	
	MyClass(int iv) {
		this.iv = iv;
	}
}
