package day25;

import java.util.Scanner;

public class Ex01 {
	
	/*
	 * 정수를 입력받아 입력받은 정수가 0이상이면 0부터 입력받은 수까지 합을 구하고
	 * 입력받은 정수가 0미만 이면 0부터 입력받은 수까지 차를 코드를 작성하세요.
	 * 정수 입력 :
	 * 0부터 3까지 합 :6
	 * 정수 입력 : -3
	 * 0부터 -3까지 누적 차:6
	 * 0 - -1 - -2 - -3
	 */

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수입력>>");
		int num = sc.nextInt();
		int sum=0;
		if(num >= 0) {
			System.out.println(num+"가 0이상");
			for (int i = 0; i <= num; i++) {
				sum+=i;
			}
		}else if(num < 0) {
			System.out.println(num+"가 0미만");
			for (int i = 0; i >= num; i--) {
				sum-=i;
			}
			
		}
		
		System.out.println(sum);
		
	}

}
