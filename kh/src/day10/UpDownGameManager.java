package day10;

import java.util.Scanner;

public class UpDownGameManager {

	public static void main(String[] args) {
		/*
		 * UpDown게임을 구현하세요.
		 * 1. 플레이
		 * 2. 기록확인
		 * 3. 종료
		 */
		
		//변수 선언
		int menu = 0;
		Record[] record = new Record[5];
		
		//메뉴 출력
		do {
			menuPrint(
					"------------",
					"1. 플레이",
					"2. 기록확인",
					"3. 종료",
					"------------"
					);
			//메뉴 선택
			menu = insertInt();
			//선택한 메뉴에 따른 기능 실행
			runMenu(menu,record); // 기록정보가 남아있어여해서 밖에서 넘겨줌
		}while(menu != 3);
			
		
		
	}
	/**
	 * 주어진 기록정보를 이용하여 메뉴를 따른 기능을 실행하는 메소드
	 * @param records 기록정보들
	 * @param menu 선택한 메뉴
	 */
	public static void runMenu(int menu, Record[] record) {
		switch (menu) {
		case 1://플레이
			int tryCount = playGame(); // 몇번만에 맞추었는지 알아야되기때문에 인트를 리턴
			//그래야 카운트가지고 기록을 할수 있어서
			
			//기존 기록보다 좋으면 기록을 추가
			writeRecord(record, tryCount);
			break;
		case 2://기록확인
			//기록된 순위를 출력
			printRecord(record);
			break;
		case 3://종료
			System.out.println("프로그램 종료합니다.");
		default:
			System.out.println("메뉴를 잘못 입력 하셨습니다. 다시 입력해주세요.");
			break;
		}
		
	}
	private static void printRecord(Record[] record) {
		for (int i = 0; i < record.length; i++) {
			System.out.print(i+1+"위");
			if(record[i] != null) {
				record[i].pirnt();
			}else {
				System.out.println();
			}
		}
	}
	/**
	 * 기록 정보보다 사용자 기록이 좋으면 기록을 추가하는 메소드
	 * @param record
	 * @param tryCount
	 */
	public static void writeRecord(Record[] record, int tryCount) {
		int index = 0; // 몇번지에 수정할것인지 / 
		for (int i = 0; i < record.length; i++) {
			// 1등부터 비교하여 나보다 기록이 좋으면 내 순위기가 밀림
			if(record[i] != null && tryCount >= record[i].getCount()) {
				index++;
			// 기록이 없는 처음 순위를 내 기록으로 하기 위해 i를 index에 저장
			}else if(record[i] == null){ // else 로 묶어도 되는데 주석을 위해 나눔
				index = i; // 내가 처음 null 만나는 위치 (주소의 위치
				break;
			}
			// 비교 순위보다 내가 기록이 좋으면 반복문 종료
			else {
				index = i;
				break;
			}
		}
		// 순위안에 못들으면
		if( index == 5) {
			return;
		}
		System.arraycopy(record, index, record, index+1,
				record.length - index -1);
		// arraycopy를 이용하여 복사해서 다음번지부터 붙여놓는 작업
		record[index] = addRecord(record, tryCount);
	}
	public static int playGame() {
		int user = 0;
		int r = random(); //랜덤수 생성
		int tryCount=0; // 시도횟수
		//반복
		while(r != user) {
			System.out.println("답:"+r);
			System.out.print("1~100사이의 랜덤한 수를 맞추세요>>");
			//사용자 입력
			user = insertInt();
			tryCount++;
			//Up down 판별
			if(r > user) {
				System.out.println("up!!");
			}else if(r < user) {
				System.out.println("down!!");
			}
		}
		System.out.println("맞추셨습니다!!");
		return tryCount;
	}
	public static Record addRecord(Record[] record, int tryCount) {
		Scanner sc = new Scanner(System.in);
		System.out.print("이름을 입력하세요>>");
		String name = sc.next();
		Record r = new Record(tryCount, name);
		return r;
		
	}
	
	/*
	 * public static int getMaxRecordRank(Record[] record) { int count = 999; for
	 * (Record r : record) { if(r != null) { count = r.getCount(); } } return count;
	 * }
	 * 
	 * 
	 * public static int getMaxRecordCount(Record[] record) { int rank = 999; for
	 * (Record r : record) { if(r !=null) { rank++; } } return rank; }
	 */
	 
	
	public static int insertInt() {
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}
	
	public static int random() {
		return (int)(Math.random()*100)+1;
	}
	
	
	public static void menuPrint(String...strs) {
		for (int i = 0; i < strs.length; i++) {
			System.out.println(strs[i]);
		}
	}
}
