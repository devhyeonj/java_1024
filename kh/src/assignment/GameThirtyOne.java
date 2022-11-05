package assignment;

public class GameThirtyOne {

	public static void main(String[] args) {
		
		//변수선언 
		int menu;  
		//메뉴출력 , 메뉴 입력
		printMenu(
				"==============",
				"1. 플레이",
				"2. 기록확인",
				"3. 종료",
				"==============",
				"메뉴 선택>>"
				);
		
		
		//입력에 따른 기능 실행
			//1. 플레이
			//31 부를때까지 반복함
				// 컴퓨터가 랜덤 1-3개의 숫자를 부름
		
				// 사용자가 몇개의 숫자를 부를지 입력함
		
				// 31 안 부른사람을 기록 ++;
		   // 2. 기록확인
		       // 사용자 x번
		       // 컴퓨터 x번
		   // 3. 종료
		
	}

	public static void printMenu(String...strs) {
		for (int i = 0; i < strs.length; i++) {
			System.out.print(strs[i]);
			if (i != strs.length-1) {
				System.out.println();
			}
		}
	}

}
/*
 * 사용자와 컴퓨터가 1부터 시작하여 돌아가면서 연속된 숫자를 부른다. 한 번에 최대 3개까지 부를수 있으며, 31 부르는 사람이 지는 게임.
 * 
 * 기록은 사용자가 몇번 이기고, 컴퓨터가 몇번 이기는지 기록한다.
 * 
 * 예시
 * 1 2 3 [컴퓨터]
 * > 2 [사용자 입력]
 * 4 5 [사용자 입력에 따른 결과]
 * 6 [컴퓨터]
 * > 3 [사용자 입력]
 * 7 8 9 [사용자 입력에 따른 결과]
 */