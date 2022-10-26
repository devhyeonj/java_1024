package day03;

//IfEx06예제를 switch 문으로 변경
public class SwitchEx03 {

	public static void main(String[] args) {
		
		char ch = '=';
		
		switch (ch) {
		case '+' , '-', '*', '/', '%':
			System.out.println("산술 연산자");
			break;
		default:
			System.out.println("산술 연산자가 아닙니다.");
			break;
		}

	}

}
