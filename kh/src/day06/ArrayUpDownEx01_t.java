package day06;

import java.util.Scanner;
// 강사님 코드
public class ArrayUpDownEx01_t {

	public static void main(String[] args) {
		/*
		 * Up Down 게임을 무조건 3번 반복해서 맞춘 3번의 횟수를 
		 * 배열에 저장하여 출력하는 코드를 작성하세요.
		 */
		
		int coin = 3;
		int record[] = new int[coin];
		int min = 1, max = 100;
		
		Scanner sc = new Scanner(System.in);

		while (coin -- > 0) {
			int r = (int) (Math.random() * (max - min +1)+ min);
			System.out.println(r);
			System.out.println(min+"~"+max+"사이의 랜덤한 수를 맞추세요.");
			int num;
			int tryCount = 0;
			do {
				tryCount++;
				System.out.print("숫자 입력 :");
				num = sc.nextInt();
				if(r == num) {
					System.out.println("정답입니다.");
					record[record.length - coin -1] = tryCount;
				}else if(r > num) {
					System.out.println("down!");
				}else if(r < num) {
					System.out.println("up!");
					}
			}while(r != num);
		}
		for (int i = 0; i < record.length; i++) {
			System.out.println(i+1+"번째 게임 횟수 :" + record[i]);
		}
		sc.close();
	}

}
