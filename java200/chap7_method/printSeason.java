package chap7_method;

import java.util.Scanner;

class printSeason {
	//m월의 계절을 표시
	static void printSeason(int m) {
		switch (m) {
		case 3: case 4: case 5: System.out.print("봄"); break;
		case 6: case 7: case 8: System.out.print("여름"); break;
		case 9: case 10: case 11: System.out.print("가을"); break;
		case 1: case 2: case 12: System.out.print("겨울"); break;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int month;
		do {
			System.out.print("몇 월입니까(1 ~12):");
			month = sc.nextInt();
		}while(month < 1 || month > 12);
		
		System.out.print("해당 월의 계절은 ");
		printSeason(month);
		System.out.print("입니다.");
	}
}
/* void 메서드
 void 메서드는 값을 반환하지 않으므로 return 필수가 아님
 메서드 처리 중에 강제적으로 호출한 곳으로 돌아가야 할 때는 다음과 같이 반환값없이 return 문만 실행
 return;
 * 
 */
