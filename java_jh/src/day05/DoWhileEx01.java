package day05;

public class DoWhileEx01 {

	public static void main(String[] args) {
		/*
		 * for문, while문 상황에 따라서 한번도 동작하지 않을 수 있다.
		 * do while 문은 최소 1번은 실행된다.
		 * 문자 입력받는 예제는 do while 이 적절함
		 * do{
		 * 		실행문;
		 * }while(조건식); // 여기에 있는 ; 필수
		 */
		int j = 1;
		
		do {
			System.out.println("Hello wolrd");
		}while(j >= 5); // 조건식이 거짓이여도 무조건 실행됨
			
		

	}

}
