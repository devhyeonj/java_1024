package day14;

import java.util.Scanner;

public class ExceptionEx03 {

	public static void main(String[] args) {
		// 다음과 같은 메뉴를 출력하고 정수를 입력받은 코드를 작성하세요
		// 단 종료를 선택하면 프로그램이 종료되고 예외처리를 적용하여 정수가 아닌 문자열이 입력되도록
		// 메뉴
		// 1.플레이
		// 2.기록확인
		// 3. 종료
		// 메뉴 선택:
		// 단 종료를 선택하면 프로그램이 종료
	int menu = 0;
	Scanner sc = new Scanner(System.in);
	int num=0;

	printMenu();
	for (;menu!=3; ) {
		num = runMenu(menu, num, sc);
	}
		
		
	}  
	public static void printMenu() {
		System.out.println("메뉴");
		System.out.println("1.플레이");
		System.out.println("2.기록확인");
		System.out.println("3.종료");
		System.out.print("메뉴 선택 :");
	}
	
	public static int runMenu(int menu,int num,Scanner sc) {
		switch (menu) {
		case 1:
			System.out.print("정수를 입력하세요>>");
			try {
				num = sc.nextInt();
			} catch (Exception e) {
				e.printStackTrace();
				sc.nextLine();
			}
			break;
		case 2:
			System.out.println(num);
			break;
		case 3:
			System.out.println("프로그램을 종료합니다.");
			break;
		}
	
		return num;
		
	}
}
