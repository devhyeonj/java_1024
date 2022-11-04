package day09;

import java.util.Arrays;
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
		int menu;
		int playerNum = 0;
		int ranking =0;
		Player[] player = new Player[5];
		
		Scanner sc = new Scanner(System.in);
		do {
			printMenu();
			menu = sc.nextInt();
			playerNum = startMenu(menu,player, playerNum);
			System.out.println(playerNum);
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
	public static int startMenu(int menu,Player[] player,int playerNum) {
		Scanner sc = new Scanner(System.in);				//현재 저장된 플레이어
		int i=0;
		int count = 0;
		switch (menu) {
		case 1:
				count = BaseballGame.startGame();
				System.out.print("게임한 사람 이름은>>");
				String playGamePersonName = sc.next();
				player[playerNum] = new Player(playGamePersonName, count);
				System.out.println("기록 하였습니다.");
				playerNum++;
				break;
		case 2:
			ranking(player);
			for (int j = 0; j < playerNum; j++) {
				player[j].print();
			}	
			
		default:
			System.out.println("잘못 입력하셨습니다. 다시 입력해주세요!!");
			break;
		}
		return playerNum;
	}
	//순위 메소드
	public static void ranking(Player[] player) {
		   int i=0, j=0, ranking=1;
	        for(i=0; i<player.length; i++) {
	            for(j=0; j<player.length; j++) {
	                if(player[i].getCount()<player[j].getCount()) {
	                    ranking++;
	                }
	            }
	            System.out.println(ranking + "위");
	            ranking=1;
	        }
	
	}
}

	//출력 메소드?


