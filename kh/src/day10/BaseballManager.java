package day10;

import java.util.Scanner;

import day08.MethodBaseballGameEx01;

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
		int menu;
		Record[] recoards = new Record [5];
		
		do {
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
		 menu = selectMenu();
		//선택한 메뉴에 따른 기능 실행
		runMenu(menu,recoards); // 메뉴를 실행할때마다 기록됨
		}while(menu != 3);
		
	}
	/**
	 * 주어진 메뉴에 맞는 기능을 실행하는 메소드
	 * @param menu 실행할 메뉴 번호
	 * @param recoards 
	 */										//저장하거나 확인하기 위해서넘겨줌
	private static void runMenu(int menu, Record[] recoards) {
		switch (menu) {
		case 1 ://플레이
			//컴퓨터가 랜덤으로 숫자 생성
			int [] com = MethodBaseballGameEx01.createRandomArray(1, 9, 3);
			BaseballGame bg = new BaseballGame(com); // 베이스볼 게임을 만듦
			// 사용자가 숫자 입력
			int tryCount = 0; //시도횟수 1.
			do {
				int[] user = MethodBaseballGameEx01.scanArray(new Scanner(System.in), 3);
				bg.setUser(user); // 입력받은 유저정보 입력해줌
				//결과 출력
				bg.printResult();
				tryCount++; // 2. 증가시킴
			//판별
			//3S 종료
			}while(bg.getStrike() != 3);
			//5등 회수를 기록(최대 5등), 5등 기준으로 회수가 동일한 경우 먼저 플레이한 사용자 기록을 유지
			//기록의 최대 회수를 찾음 (꼴지 횟수)
			int maxRecordCount = getMaxRecordCount(recoards);
			//기록된 수를 찾음(꼴찌 순위)
			int maxRecordRank = getMaxRecordRank(recoards);
			//기록된 최대 횟수가 내 횟수보다 크거나 기록된 수가 5보다 작으면 기록
			if(maxRecordCount > tryCount || maxRecordRank < 5) {
				addRecord(recoards,tryCount);
			}
			break;
		case 2 ://기록하기
			printRecords(recoards);
			break;
		case 3 ://종료
			break;
		default:
			break;
		}
	}
	
	private static void printRecords(Record[] records) {
		for (int i = 0; i < records.length; i++) {
			System.out.println(1+1+"위");
			if(records[i] != null) {
				records[i].pirnt();
			}
		}
	}
	private static void addRecord(Record[] recoards, int tryCount) {
		Scanner sc = new Scanner(System.in);
		System.out.print("이름 입력(예 : JHL): ");
		String name = sc.next();
		Record r = new Record(tryCount, name);
		int index =0;
		for (Record record : recoards) {
			if(record != null && record.getCount() < tryCount) {
				index++; // 1등이 나보다 기록이 좋으면 index가 1됨.....
			}
		}
		for (int i = recoards.length -1;i>index; i--) {
			recoards[i] = recoards[i-1]; // 앞에 있는걸 뒤로 
		}
		recoards[index] = r; //기록이끝남
		
	}
	private static int getMaxRecordRank(Record[] recoards) {
		int count = 9999999;
		for (Record record : recoards) {
			if(record != null) {
				count = record.getCount(); // 1위부터 차례대로 덮어써서 꼴지 기록을 찾음 그런다음에 저장
			}
		}
		return count;
	}
	private static int getMaxRecordCount(Record[] recoards) {
		int rank = 9999999;
		for (Record record : recoards) {
			if(record != null) {
				rank++; //기록있을때부터 횟수를 세줌
			}
		}
		return rank;
	}
	
	private static int selectMenu() {
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}
	

	public static void printMenu(String...strs) {
		for (int i = 0; i < strs.length; i++) {
			System.out.print(strs[i]);
			if(i != strs.length -1) {
				System.out.println();
			}
		}
		
	}
}



