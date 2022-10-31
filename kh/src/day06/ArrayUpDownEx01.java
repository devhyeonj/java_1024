package day06;

import java.util.Scanner;
//내가 작성한 코드
public class ArrayUpDownEx01 {

	public static void main(String[] args) {
		/*
		 * Up Down 게임을 무조건 3번 반복해서 맞춘 3번의 횟수를 
		 * 배열에 저장하여 출력하는 코드를 작성하세요.
		 */
		Scanner sc = new Scanner(System.in);
		
		int coin = 3;
		int r = 0;
		int num =0;
		int count = 1;
		int[] numArr = new int[3];
		
		
		for (int i = 0; i < coin; i++) {
			r = (int) (Math.random()*100) + 1;
			System.out.println("=========랜덤 번호 확인"+ r);
			for (;r != num;) {
				System.out.println("횟수:"+(count));
				System.out.println("입력:");
				num =sc.nextInt();
				if(r == num) {
					System.out.println("정답입니다.");
					}else if(r > num) {
						System.out.println("down!");
					}else if(r < num) {
						System.out.println("up!");
					}
				count++;
				if(r == num) {
					numArr[i] = count;
					break;
				}if(count == 3) {
					break;
				}
			}
		}
		for (int j : numArr) {
			System.out.println(j-1+" "+"번째에서 정답을 맞추셨습니다.");
		}
	}

}
