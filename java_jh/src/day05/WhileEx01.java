package day05;

public class WhileEx01 {

	public static void main(String[] args) {
		/*
		 * while 문 문법
		 * while(조건식) {
		 * 		실행문;
		 * }
		 * 
		 * 
		 * 초기화;
		 * while(조건식) {
		 * 		실행문;
		 * 		증감식;
		 * }
		 * continue는 while문에서 조건식으로 이동
		 */
		int i = 1;
		while (i++ <= 5) { // i랑 비교해서 다음에 후위 연산자로 증가함
			System.out.println("Hello world!"); // for문에 비해 코드가 간결해짐
		}
		/*
		 * while문에서는 조건식을 생략할 수 없다
		 * while문에서 무한루프를 만들려면 조건식에 true를 넣어주면 된다.
		 */
		
		

	}
}
