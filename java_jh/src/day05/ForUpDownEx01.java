package day05;

import java.util.Scanner;

public class ForUpDownEx01 {

	public static void main(String[] args) {
		/*
		 * 랜덤한 수를 생성하여 해당 수를 맞추는 코드를 작성하세요.
		 */
		Scanner sc = new Scanner(System.in);
		
		int min = 1, max = 100,num = min-1;
		
		int i = (int) (Math.random() * (max -min+1) + min);
		for (; num != i; ) {
			System.out.print("1~100 사이의 숫자를 맞추세요:");
			num  = sc.nextInt();
			if(num < i) {
				System.out.println("up!");
			}else if(num > i) {
				System.out.println("down!");
			}else if(num == i) {
				System.out.println("정답 입니다.");
			}
		}
		sc.close();
	}
}
