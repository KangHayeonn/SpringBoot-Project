package Lambda;

import java.util.function.Function;
import java.util.function.Supplier;

public class MethodReference_ex1 {
	public static void main(String[] args) {
		// 람다식 ( (입력) -> 클래스이름.메서드이름(입력) )
		// Function<String, Integer> f = (String s) -> Integer.parseInt(s);
		
		// 메서드 참조 (클래스이름 :: 메서드이름)
		Function<String, Integer> f = Integer::parseInt;
		
		System.out.println(f.apply("200")+100); // 숫자 연산

		// Supplier는 입력X, 출력 O
		// Supplier<MyClass> s = () -> new MyClass();
		
		// 메서드 참조
		// Supplier<MyClass> s = MyClass::new;
		
		/*
		MyClass mc = s.get();
		System.out.println(mc); // 객체1
		System.out.println(s.get()); // 객체2 (!=객체1)
		*/
		
		// Function는 입력O, 출력 O
		// Function<Integer, MyClass> s = (i) -> new MyClass(i);
		
		// 메서드 참조
		Function<Integer, MyClass> s = MyClass::new;
		
		MyClass mc = s.apply(100);
		System.out.println(mc.iv); // 객체1
		System.out.println(s.apply(200).iv); // 객체2 (!=객체1)
		
		// Function<Integer, int[]> f2 = (i) -> new int[i];
		Function<Integer, int[]> f2 = int[]::new; // 메서드 참조
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
