package day04;

// 주말에 거꾸로 된거 해보기 또는 다이아몬드
public class NestingForStarEx02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/* 
		 * * row = 1
		 * ** row = 2
		 * *** row = 3
		 * **** row = 4
		 * ***** row = 5
		 */
		
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println();
		
		//복습하기
		
		/*
		 * 		*
		 * 	   **
		 * 	  ***
		 *   ****
		 *  ***** 
		 */
		
		for (int i = 1; i <= 5; i++) {
			//공백 출력 5-row
			for (int j = 1; j <=5-i ; j++) {
				System.out.print(" ");
			}
			//* 출력 row 개
			for (int j = 1; j <= i ; j++) {
				System.out.print("*");
			}
			//엔터
			System.out.println();
		}
		System.out.println("=============");
		
		/*
		 * 		* 1
		 * 	   ** * 3
		 * 	  *** ** 5
		 *   **** *** 7
		 *  ****** **** 9
		 */
		
		for (int i = 1; i <= 5; i++) {
			//공백 출력 5-row
			for (int j = 1; j <=5-i ; j++) {
				System.out.print(" ");
			}
			//* 출력 row 개
			for (int j = 1; j <= i ; j++) {
				System.out.print("*");
			}
			//* 출력 row 개
			for (int j = 1; j <= i-1 ; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	}
}

