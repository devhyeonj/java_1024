package chap7_method;

import java.util.Random;
import java.util.Scanner;

class MentalArithmetic {
	static Scanner sc = new Scanner(System.in);

	// 계속할지 여부 확인
	static boolean confirmRetyr() {
		int cont;
		do {
			System.out.print("다시 한번? <Yes...1/No...0>:");
			cont = sc.nextInt();
		}while(cont != 0 && cont != 1);
		return cont == 1;
	}
	
	public static void main(String[] args) {
		Random rand = new Random();
		System.out.println("암산 훈련!!");
		
		do {
			int x = rand.nextInt(900)+100; // 3자리 수 
			int y = rand.nextInt(900)+100; // 3자리 수 
			int z = rand.nextInt(900)+100; // 3자리 수 
			int pattern = rand.nextInt(); // 패턴 번호
			
			int answer; // 정답
			switch (pattern) {
			case 0: answer = x + y + z; break;
			case 1: answer = x + y - z; break;
			case 2: answer = x - y + z; break;
			default: answer = x - y - z; break;
			}
			while (true) {
				System.out.print(x + ((pattern < 2) ? "+" : "-") +
						y + ((pattern % 2 == 0) ? "+" : "-") +
								z + " = ");
			int k = sc.nextInt(); // 입력한 답을 읽는다.
			if (k == answer)
				break;
			System.out.println("틀렸습니다!!");
			}
		}while(confirmRetyr());
	
	}
}
