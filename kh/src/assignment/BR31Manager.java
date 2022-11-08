package assignment;

import java.util.Scanner;

//강사님 예제
public class BR31Manager {

	public static void main(String[] args) {
		Record record = new Record(5); // maxsize
		int menu;
		do {
				printMenu();
				menu = inputInt();
				run(menu, record);
			}while(menu != 3);

	}
	
	public static void run(int menu, Record record) {
		switch (menu) {
		case 1:
			boolean res = play();
			record.addRecord(res);
			if(res) {
				System.out.println("사용자가 이겼습니다.");
			}else {
				System.out.println("컴퓨터가 이겼습니다.");
			}
			break;
		case 2://결과출력
			record.printResult();
			break;
		case 3:
			System.out.println("프로그램 종료!");
			break;
		default:
			System.out.println("잘못된 메뉴!");
			break;
		}
	}

	public static boolean play() {
		int start = 1;
		int min = 1, max = 3;
		do {
			int com = random(min,max);
			com = checkNum(start,com,3,31);
			System.out.print("com:");
			
			printNums(start , start+com);
			if(start + com > 31) {
				return true;
			}
			start = start + com;
			System.out.print("사용자 입력(1~3) : ");
			int user = inputInt();
			user = checkNum(start, user, 3, 31);
			System.out.print("user : ");
			printNums(start , start+user);
			if(start + user > 31) {
				return false;
			}
			start = start + user;
		}while(start <= 31);
		return false;
	}
	
	/**
	 * 정수 num가 maxCount개 이하이고,
	 * 정수 start부터 차례대로 num개의 정수를 불렀을 때 
	 * maxNum를 넘지 않도록 num의 개수를 다시 정해주는 메소드
	 * start 시작 정수
	 * num 판별해야할 정수
	 * maxCount num가 가질수 있는 최대 정수
	 * MaxNun start+num를 했을때 가질 수 있는 최대 정수
 	 */
	public static int checkNum(int start,int num,int maxCount, int maxNum) {
		num = num > maxCount ? maxCount : num;
		num = maxNum - start - num<0 ? maxNum - start + 1 :num;
		return num;
	}
	

	/*
	 * 랜덤으로 정수를 선택하여 알려주는 메소드
	 */
	public static int random(int min,int max) {
		return (int)(Math.random()*(max-min+1)+1);
		
	}
	
	/*
	 * 스캐너를 통해 정수를 입력받아 정수를 알려주는 메소드
	 */
	public static int inputInt() {
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}
	
	/*
	 * start부터 end보다 작은 정수를 차례대로 출력하는 메소드
	 */
	public static void printNums(int start,int end) {
		for (int i = start; i < end; i++) {
			System.out.print(i + "");
		}
		System.out.println();
	}
	
	/*
	 * 메뉴를 출력하는 메소드
	 */
	public static void printMenu() {
		System.out.println("------------");
		System.out.println("1.플레이");
		System.out.println("2.기록확인");
		System.out.println("3.종료");
		System.out.println("------------");
		System.out.println("메뉴 선택 :");
	}
}
