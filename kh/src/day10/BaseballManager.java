package day10;

import java.util.Scanner;

public class BaseballManager {
	
	public static void main(String[] args) {
		/*
		 * 숫자 야구게임을 플레이 한 후 , 기록을 저장하는 프로그램을 작성하세요
		 * 메뉴 마지막에 이름 적어서 기록 남김
		 * 1. 플레이
		 * 2. 기록확인
		 * 3. 종료
		 * 메뉴 선택 : 2
		 * 1위 홍길동 2회
		 * 2. 임꺽정 3회
		 * 3. 이몽룡 3회
		 * 4. 춘향이 4회
		 */
		// [new] 회수를 기록(최대 5등), 5등 기준으로 회수가 동일한 경우 먼저 플레이한 사용자 기록을 유지
		printMenu( 
				"--------",
				"메뉴",
				"1.플레이",
				"2.기록확인",
				"3.종료",
				"--------",
				"메뉴 선택:"
				);
		//메뉴 선택
		int menu = selectMenu();
		//선택한 메뉴에 따른 기능 실행
		runMenu(menu);
		
		
	}
	private static int selectMenu() {
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}
	

	public static void printMenu(String string, String string2, String string3, String string4, String string5,
			String string6, String string7) {
		
		
	}
}



