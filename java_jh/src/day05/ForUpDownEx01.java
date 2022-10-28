package day05;

import java.util.Scanner;

public class ForUpDownEx01 {

	public static void main(String[] args) {
		/*
		 * 랜덤한 수를 생성하여 해당 수를 맞추는 코드를 작성하세요.
		 */
		Scanner sc = new Scanner(System.in);
		
		int min = 1, max = 100, num1 = min-1; // 처음에 맞추는거 방지
									// (최댓값-최소값+1) + 최소값
		int i = (int)(Math.random() * (max - min + 1)+min);
		for (; num1 != i;) {
			System.out.println("1~100사이의 랜덤한 수를 맞추세요");
			System.out.print("숫자를 입력하세요>>");
			num1 = sc.nextInt();
			if(num1 < i) {
				System.out.println("up!");
			}else if(num1 > i) {
				System.out.println("down!");
			}else if(num1 == i) {
				System.out.println("정답 입니다.");
				// for문에 num != i 안넣으면 break; 넣으면 됨
			}
		}
		sc.close();
		
	}
}
