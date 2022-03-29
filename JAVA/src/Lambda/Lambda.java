package Lambda;

public class Lambda {
	public static void main(String[] args) {
		// Object obj = (a, b) -> a > b ? a : b; // 람다식. 익명객체
		/* ver1 : 실패
		Object obj = new Object () {
			int max(int a, int b) {
				return a > b ? a : b;
			}
		};
		
		int value = obj.max(3, 5); // 함수형 인터페이스 필요 ( 형변환 해줄 수 없음)
		*/
		
		/* ver2 : 성공
		MyFunction f = new MyFunction () {
			public int max(int a, int b) { // 오버라이딩 - 접근제어자는 좁게 못바꾼다.
				return a > b ? a : b;
			}
		};
		
		int value = f.max(3, 5); // 함수형 인터페이스
		System.out.println("value= " + value);
		*/
		
		// ver3 : 성공
		// 람다식(익명 객체)을 다루기 위한 참조변수의 타입은 함수형 인터페이스로 한다.
		MyFunction f = (a, b) -> a > b ? a : b;
		
		int value = f.max(3, 5);
		System.out.println("value= " + value);
	}
}

// 함수형 인터페이스 선언
@FunctionalInterface // 함수형 인터페이스는 단 하나의 추상 메서드만 가져야 함.
interface MyFunction {
	// public abstract int max(int a, int b);
	int max(int a, int b); // 인터페이스의 메서드는 모두 기본적으로 public이자 abstract
}