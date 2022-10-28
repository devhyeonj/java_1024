package homeStudy;

//복습하기
public class BreakLCMEx01 {

	public static void main(String[] args) {
		/*
		 * 두 정수의 최소 공배수를 구하는 코드를 작성하세요 2의 배수 : 2 , 4 , 6 ,8 ..... 3의 배수 : 3, 6, 9 , 12
		 * ...... 2와 3의 공배수 : 6, 12, 18, .... 2와 3의 최소 공배수 : 6
		 */

		int num1 = 2, num2 = 3; // 두 정수
		for (int i = num1; i <= num1 * num2; i++) {
			if (i % num1 == 0 && i % num2 == 0) {
				System.out.println(i);
				break;
			}

		}

	}

}
