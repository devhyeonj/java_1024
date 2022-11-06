package assignment;

import java.util.Scanner;

public class GameThirtyOne {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//메뉴 변수선언 
		int menu = 0;
		int start= 0;
		int userWin = 0,comWin = 0;
		int numN=0;
		//누가 승리
		// 게임 숫자 저장할 배열 생성
		int[] game = new int[31];
		//메뉴출력 , 메뉴 입력
		while (menu!=3) {
			printMenu(
					"==============",
					"1. 플레이",
					"2. 기록확인",
					"3. 종료",
					"==============",
					"메뉴 선택>>"
					);
			menu = scannerInt(sc);
			scannerMenu(menu, userWin,comWin, game, sc,start);
		}
	}
	//입력에 따른 기능 실행
	public static void scannerMenu(int menu,int userWin,int comWin,int game[],Scanner sc,int start) {
		switch (menu) {
		case 1:
			//1번 선택시 초기화			
			int lastNum = 0; 
			gameStart(lastNum, game, sc, start, userWin, comWin);
			break;
		case 2:
			printScore(comWin, userWin);
			break;
		case 3:
			System.out.println("종료");
			break;
		default:
			System.out.println("잘못된 번호 입니다. 다시 선택해주세요.");
			break;
		}
		
	}

	public static void printMenu(String...strs) {
		for (int i = 0; i < strs.length; i++) {
			System.out.print(strs[i]);
			if (i != strs.length-1) {
				System.out.println();
			}
		}
	}
	
	public static int scannerInt(Scanner sc) {
		return  sc.nextInt();
	}
	
	public static void printScore(int comWin, int userWin) {
		System.out.println("컴퓨터: "+comWin+"승");
		System.out.println("사용자: "+userWin+"승");
	}
	
	public static int gameStart(int lastNum,int[] game,Scanner sc,int start,int userWin,int comWin) {
	int comTurn = (int)(Math.random()*3)+1;
	System.out.println(""+comWin+userWin);
	printScore(comWin, userWin);
	loop : for (int i = 0; i < game.length; i++) {
		System.out.println("computer turn!");
		lastNum += comTurn;
		start = lastNum;
			for (int j = 0; j <lastNum; j++) {
				if(j == game.length) {
					userWin++;
					System.out.println("userWin확인"+userWin);
					break loop;
				}
				game[j] = j+1;
				System.out.print(j+1 + " ");
			}
			System.out.println();
	System.out.println("user turn!");
	System.out.print("입력(1-3)>>");
	int userTurn = scannerInt(sc);
	lastNum += userTurn;
	for (int k = start; k <lastNum; k++) {
		System.out.println("k확인"+k);
		if(k == game.length) {
			comWin++;
			System.out.println("comWin확인"+comWin);
			break loop;
		}
		game[k] = k+1;
		System.out.print(k+1 + " ");	
		}
	}
	return lastNum;
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