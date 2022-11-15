package example.accountbook;

import java.util.ArrayList;
import java.util.Scanner;

public class AccountServiceImp implements AccountService {
	
	private Item item;
	private Scanner sc = new Scanner(System.in);

	@Override
	public void isnertItem(ArrayList<Item> list, Item item) {
		System.out.print("구분:");
		String division = sc.next();
		System.out.print("분류:");
		String classification = sc.next();
		System.out.print("내용:");
		String Contents = sc.next();
		System.out.print("금액:");
		int price = sc.nextInt();
		System.out.print("년,월,일 순으로 입력해주세요.");
		int year =sc.nextInt();
		int month = sc.nextInt();
		int day = sc.nextInt();
		
	}

	@Override
	public void printItem(ArrayList<Item> list) {
		
	}

	@Override
	public boolean updateItem(ArrayList<Item> list, int index, Item item) {
		
		return false;
	}

	@Override
	public boolean deleteItem(ArrayList<Item> list, int index) {
		
		return false;
	}

	@Override
	public void printMenu() {
		System.out.println("메뉴");
		System.out.println("1. 내역 추가");
		System.out.println("2. 내역 확인");
		System.out.println("3. 내역 수정");
		System.out.println("4. 내역 삭제");
		System.out.println("5. 종료");
	}

	@Override
	public void runMenu(ArrayList<Item> list, Scanner sc, int menu) {
			switch (menu) {
			case 1:
				isnertItem(list,item);
				break;
			case 2:
				printItem(list);
				break;
			case 3:
				updateItem(list, menu, item);
				break;
			case 4:
				deleteItem(list, menu);
				break;
			case 5:
				System.out.println("프로그램을 종료합니다.");
				break;
			default:
				System.out.println("잘못된 메뉴 입니다.");
				break;
			}
	}
}
