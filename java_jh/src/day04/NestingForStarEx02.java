package day04;

public class NestingForStarEx02 {

	public static void main(String[] args) {
		
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
		
		/* 
		 * ***** row = 5
		 * **** row = 4
		 * *** row = 3
		 * ** row = 2
		 * * row = 1
		 */
		

		for (int i = 1; i <=5 ; i++) {
			for (int j = 5; j >=i; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println();
		
//		/*
//		 * 		*
//		 * 	   **
//		 * 	  ***
//		 *   ****
//		 *  ***** 
//		 */
		
		for (int i = 1; i <=5 ; i++) {
			for (int j = 1; j <=5-i; j++) {
				System.out.print("");
			}
			for (int j = 1; j <=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		
		
		
		
		
		

//		
//		for (int i = 1; i <= 5; i++) {
//			//공백 출력 5-row
//			for (int j = 1; j <=5-i ; j++) {
//				System.out.print(" ");
//			}
//			//* 출력 row 개
//			for (int j = 1; j <= i ; j++) {
//				System.out.print("*");
//			}
//			//엔터
//			System.out.println();
//		}
//		System.out.println("=============");
//		
//		/*
//		 * 		* 1
//		 * 	   ** * 3
//		 * 	  *** ** 5
//		 *   **** *** 7
//		 *  ****** **** 9
//		 */
//		
//		for (int i = 1; i <= 5; i++) {
//			//공백 출력 5-row
//			for (int j = 1; j <=5-i ; j++) {
//				System.out.print(" ");
//			}
//			//* 출력 row 개
//			for (int j = 1; j <= i ; j++) {
//				System.out.print("*");
//			}
//			//* 출력 row 개
//			for (int j = 1; j <= i-1 ; j++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
		
	}
}

