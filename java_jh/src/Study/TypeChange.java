package Study;
//타입 간의 변환 방법 22-10-26
public class TypeChange {

	public static void main(String[] args) {
		// 숫자를 문자로 변환 - 숫자에 '0'을 더한다.
		System.out.println(1+'0');
		// 문자를 숫자로 변환 - 문자에서 '0'을 뺀다.
		System.out.println('3'-'0');
		// 숫자를 문자열로 변환 - 숫자에 빈 문자열 "" 을 더한다.
		System.out.println(""+3);
		// 문자열을 숫자로 변환
		System.out.println(Integer.parseInt("3"));
		// 문자열을 문자로 변환
		System.out.println("3".charAt(0));
		// 문자를 문자열로 변환 - 빈 문자열""을 더한다.
		System.out.println('3'+"");
	}

}
