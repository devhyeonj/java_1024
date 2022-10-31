package day06;

import java.util.Scanner;
// 다시 해보기 
public class ArrayLottoEx01 {
	public static void main(String[] args) {

		/*
		 * 로또 번호를 랜덤으로 생성하고, 당첨번호를 입력하여 몇등 당첨됐는지 출력하는 코드를 작성하세요. 
		 * 숫자범위 : 1~45 
		 * 1등 : 6개 
		 * 2등: 5개 + 보너스 번호 
		 * 3등 : 5개 
		 * 4등 : 4개 
		 * 5등 : 3개 
		 * 로또 번호 : 번호 6개와 + 보너스 번호
		 */
		
		
		
		Scanner sc = new Scanner(System.in);

		int size = 6;
		int[] lotto = new int[size];
		int count = 0;
		int min = 1 , max = 45;

		while (count < size) {
			// 랜덤으로 6개의 로또 번호 생성
			int r = (int) (Math.random() * (max - min + 1) + min);
			boolean isDuplicated = false;
			for (int i = 0; i < count; i++) {
				if (lotto[i] == r) {
					isDuplicated = true;
				}
			}
			if (isDuplicated) {
				continue;
			}

			lotto[count++] = r;
		}
		System.out.println("로또 번호 확인:");
		for (int tmp : lotto) {
			System.out.print(tmp + " ");
		}
		
		// 보너스 번호를 랜덤으로 생성(위에서 생성한 번호와 중복되지 않게) -->????
		int bonus;
		while(true) {
			int r = (int) (Math.random() * (max - min + 1) + min);
			//원하는 번호가 있는지 없는지
			boolean isDuplicated = false;
			for (int i = 0; i < lotto.length; i++) {
				if (lotto[i] == r) { // 로또랑 랜덤이랑 비교해서 중복체크
					isDuplicated = true;
				}
			}
			if (isDuplicated) {
				continue;
			}
			bonus = r; // 중복되지않으면
			break;
			//
		}
		System.out.println("보너스 :" + bonus);
		//당첨 번호 6개를 입력 받음
		System.out.print("\n로또 번호를 입력하세요>>");
		int user[] = new int[size];
		for (int i = 0; i < size; i++) {
			user[i] = sc.nextInt();
		}
		int sameCount = 0;
		
		sc.close();
		
		//일치하는 번호 개수를 구함(보너스 번호 제외)
		for (int i = 0; i < lotto.length; i++) {
			for (int j = 0; j < user.length; j++) {
				if(lotto[i] == user[j]) {
					sameCount++;
				}
			}
		}
		
		
		
		//등수 판별
		switch (sameCount) {
		case 6: {
			System.out.println("1등");
			break;
		}
		case 5: {//2등 //3등
			boolean isDuplicated = false;
			for (int i = 0; i < user.length; i++) {
				if (user[i] ==  bonus) {
					isDuplicated = true;
				}
			}
			if(isDuplicated) {
				System.out.println("2등");
			}else {
				System.out.println("3등");
			}
			break;
		}
		case 4: {
			System.out.println("4등");
			break;
		}
		case 3: {
			System.out.println("5등");
			break;
		}
		default:
			System.out.println("꽝!");
		}
	}
}

	

