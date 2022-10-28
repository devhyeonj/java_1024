package Study;

//for문
public class Star {

	public static void main(String[] args) {
		// *****

		for (int i = 1; i < 6; i++) {
			System.out.print("*");
		}

		// *
		// *
		// *
		// *
		// *

		for (int i = 1; i < 6; i++) {
			System.out.print("*");
			System.out.println();
		}
		
		// 중첩 for문 안쪽 j로 별 다섯개 찍고 개행 하는걸 5번 반복한다.

		/*
		 * ***** 
		 * ***** 
		 * ***** 
		 * *****
		 * *****
		 */ 

		for (int i = 1; i <= 5; i++) {
			for (int j = 0; j <= 5; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		/*
		 * 11111
		 * 22222
		 * 33333
		 * 44444
		 * 55555
		 */
		
		for (int i = 1; i <= 5; i++) {
			for (int j = 0; j <= 5; j++) {
				System.out.print(i);
			}
			System.out.println();
		}
		System.out.println();
		
		int start = 1;
		for(int i = 0; i <5; i++) {
			for(int j= 0; j<5; j++) {
				System.out.print(start);
			}
			start++;
			System.out.println();
		}
		
		System.out.println();
		
		/*
		 * 12345
		 * 12345
		 * 12345
		 * 12345
		 * 12345
		 */
		for (int i = 1; i <=5; i++) {
			for (int j = 1; j <=5; j++) {
				System.out.print(j);
			}
			System.out.println();
		}
		
		System.out.println();
		
		start = 1;
		for(int i = 0; i <5; i++) {
			start = 1;
			for(int j= 0; j<5; j++) {
				System.out.print(start);
				start++;
			}
			System.out.println();
		}
		
		/*
		 * *
		 * **
		 * ***
		 * ****
		 * *****
		 */
		for(int j= 1; j<=5; j++) {
			for (int i = 1; i <=j; i++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println();
		
		/*
		 * *****
		 *  ****
		 *   ***
		 *    **
		 *     *
		 */
		
		for (int i = 0; i < 5; i++) {
			for (int j = 5; j > i; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
