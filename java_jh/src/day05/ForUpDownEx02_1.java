package day05;

import java.util.Scanner;
//강사님 코드 / 나중에 붙여놓기
public class ForUpDownEx02_1 {

	public static void main(String[] args) {
		/*
		 * 랜덤한 정수를 맞추는 UP DOWN 게임 예시 1 ~ 100 사이의 랜덤한 수를 맞추세요.
		 * 
		 * ....
		 * 
		 * 더 하시겠습니까?(y/n) : y
		 * 
		 * ....
		 *
		 * 더하시겠습니까?(y/n) : n 프로그램을 종료합니다.
		 */

		Scanner sc = new Scanner(System.in);

		int min = 1, max = 100, num = 0;
		char ch = 'a';
		for (;;) {
			int r = (int) (Math.random() * (max - min + 1) + min);
			System.out.println(min + " ~ " + max + "사이의 랜덤한 수를 맞추세요.");
			num = min -1;
			for(; r != num;) {
				System.out.print("숫자를 입력하세요>>");
				num = sc.nextInt();
				if (num < r) {
					System.out.println("up!");
				} else if (num > r) {
					System.out.println("down!");
				} else if (num == r) {
					System.out.println("정답 입니다.");
					System.out.print("더 하시겠습니까?(y/n) : ");
					if(sc.next().charAt(0) == 'n') {
						System.out.println("프로그램을 종료합니다.");
						break;
					}
				}
			}
			if (num < r) {
				System.out.println("up!");
			} else if (num > r) {
				System.out.println("down!");
			} else if (num == r) {
				System.out.println("정답 입니다.");
				System.out.print("더 하시겠습니까?(y/n) : ");
				if(sc.next().charAt(0) == 'n') {
					System.out.println("프로그램을 종료합니다.");
					break;
				}
			}
			
		}
	}
}
