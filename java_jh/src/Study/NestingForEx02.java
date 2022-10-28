package Study;
//e
public class NestingForEx02 {

	public static void main(String[] args) {

		/*
		 * 2부터 100사이의 소수를 출력하는 코드를 작성하세요.
		 */

		int num = 0, i = 0, count = 0;
		for (num = 2; num <= 100; num++) {
			count =0;
			for (i = 1; i <= num; i++) {

				if (num % i == 0) {
					count++;
				}
			}
			if (count == 2) {
				System.out.print(num + " ");
			}
		}
	}

}
