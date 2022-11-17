package day19;

public class ChainingEx01 {
	// 체이닝 : .이 연달아 나와 메소드를 연속해서 호출
	// 앞에 있는 메소드 리턴 값에 이어서 메소드를 호출
	// 앞에 일반자료형이 아닌 객체가 와야한다.
	
	public static void main(String[] args) {
		String str = "Hello";
		
		System.out.println(str.substring(2).charAt(0));
		
		System.out.println(1);
		System.out.println(toString(100).charAt(0));
		

	}
	public static String toString(int num) {
		return num + "";
	}
	
	public static void print(int num) {
		System.out.println(num);
	}
}
