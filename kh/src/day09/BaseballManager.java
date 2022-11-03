package day09;

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
		// 2. 기록확인
		// 3. 종료
		int menu,count = 0;
		GamePerson gamePerson[] = new GamePerson[5];
		
		Scanner sc = new Scanner(System.in);
		
		do {
			printMenu();
			menu = sc.nextInt();
			startMenu(menu,count,gamePerson);
			count++;
		}while(menu !=3);
		
	}
	//메뉴 출력 메소드
	public static void printMenu() {
		System.out.println("=======메뉴========");
		System.out.println("1. 플레이");
		System.out.println("2. 기록확인");
		System.out.println("3. 종료");
		System.out.println("=================");
	}
	
	//메뉴에 맞는 기능을 실행 하는 메소드
	public static void startMenu(int menu,int count,GamePerson[] list) {
		Scanner sc = new Scanner(System.in);
		int i = 0;
		switch (menu) {
		case 1:
			i++;
			BaseballGame.startGame();
			System.out.print("게임한 사람 이름은>>");
			String playGamePersonName = sc.next();
			list[i] = new GamePerson(playGamePersonName, count);
			break;
		case 2:
			for (int j = 0; j < list.length; j++) {
				if(list[j] != null)
				System.out.println(list[j]);
			}
		default:
			break;
		}
	}
	
	
	//기록 순위 매기는 메소드
	
	//출력 메소드?
}


