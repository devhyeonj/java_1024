package day03;

public class IfEx01 {

	public static void main(String[] args) {
		/*
		 * ~하면 ...한다 ( 조건문 )
		 * ~ : 조건식
		 * ... : 실행문
		 * if(조건식) {
		 * 	실행문;
		 * }
		 */
		int num=-1;
		// 정수 num 가 0 보다 크면 양수라고 출력하는 코드를 작성
		if (num > 0) { //-1
			System.out.println(num +"은 양수!");
		}
		// 정수 num가 0과 같으면 0이라고 출력
		if(num == 0) { //-1
			System.out.println(num +"은 0");
		}
		// 정수 num가 0보다 작으면 음수라고 출력
		if(num < 0) { //-1
			System.out.println(num +"은 음수");
		}
	}

}
