package example.accountbook;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class AccountServiceImp implements AccountService {
	
	private Date date;
	private Item item;
	private Scanner sc = new Scanner(System.in);

	@Override
	public void insertItem(ArrayList<Item> list, Item item) {
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
		date = new Date(year, month, day);
		item = new Item(division, classification, Contents, price, date);
		if(item !=null) {
			list.add(item);
			System.out.println("가계부 등록에 성공 하셨습니다.");
		}
	}


	@Override
	public void printItem(ArrayList<Item> list,int subMenu) {
		String date;
		String tmpDate;
		int dateParse;
		switch(subMenu) {
		case 21:// 전체
			for (int i = 0; i < list.size(); i++) {
				list = sortMethod(list);
				System.out.println(list.get(i));
			}
			break;
		case 22:// 년
			for (int i = 0; i < list.size(); i++) {
			tmpDate = list.get(i).getDate().getDate();
			date = tmpDate.substring(0, 4);
			dateParse = Integer.parseInt(date);
			System.out.println(date+"년도 가계부");
			System.out.println("-------------------------");
			if(list.get(i).getDate().getYear() == dateParse) {
					list = sortMethod(list);
					System.out.println(list.get(i));
			}
			}
			break;
		case 23:// 월
			for (int i = 0; i < list.size(); i++) {
				tmpDate = list.get(i).getDate().getDate();
				if(tmpDate.length() == 10) {
					date = tmpDate.substring(5, 7);
				}else {
					date = tmpDate.substring(5, 6);
				}
				
				dateParse = Integer.parseInt(date);
				System.out.println(date+"월 가계부");
				System.out.println("-------------------------");
				if(list.get(i).getDate().getMonth() == dateParse) {
						list = sortMethod(list);
						System.out.println(list.get(i));
				}
			}
			break;
		case 24:// 일
			for (int i = 0; i < list.size(); i++) {
				tmpDate = list.get(i).getDate().getDate();
				if(tmpDate.length() == 10) {
					date = tmpDate.substring(8, 10);
				}else {
					date = tmpDate.substring(7, 8);
				}
				dateParse = Integer.parseInt(date);
				System.out.println(date+"일 가계부");
				System.out.println("-------------------------");
				if(list.get(i).getDate().getDay() == dateParse) {
						list = sortMethod(list);
						System.out.println(list.get(i));
				}
				System.out.println(date);
			}
				break;
		default:
			System.out.println("잘못된 메뉴입니다.");
		}
		
	}
	






	@Override
	public boolean updateItem(ArrayList<Item> list, int index, Item item) {
		System.out.print("수정할 일시(년,월,일 순으로 입력해주세요):");int year = sc.nextInt();int month = sc.nextInt(); int day = sc.nextInt();
		Date date = new Date(year, month, day);
		index = list.indexOf(new Item(date));
		
		if(index == -1) {
			System.out.println("일치하는 가계부 정보가 없습니다");
			return false;
		}
		
		item = list.get(index);
		
		System.out.println("수정할 가계부를 새롭게 입력하세요");
		System.out.print("구분:");String division = sc.next();
		System.out.print("일시(년,월,일 순으로 입력해주세요):");int uyear = sc.nextInt();int umonth = sc.nextInt(); int uday = sc.nextInt();
		date = new Date(uyear, umonth, uday);
		System.out.print("분류:");String classification = sc.next();
		System.out.print("내용:");String Contents = sc.next();
		System.out.print("금액:");int price = sc.nextInt();
		item.update(division,date,classification,Contents,price);
		return true;
	}

	@Override
	public boolean deleteItem(ArrayList<Item> list, int index) {
		System.out.print("삭제할 일시(년,월,일 순으로 입력해주세요):");int year = sc.nextInt();int month = sc.nextInt(); int day = sc.nextInt();
		Date date = new Date(year, month, day);
		index = list.indexOf(new Item(date));
		
		if(index == -1) {
			System.out.println("일치하는 가계부 정보가 없습니다");
			return false;
		}
		//삭제
		if(list.remove(new Item(date))) {
			System.out.println("가계부 삭제되었습니다.");
		}else {
			System.out.println("삭제에 실패하였습니다.");
		}
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
				insertItem(list,item);
				break;
			case 2:
				// 서브 메뉴 출력
				printSubMenu(menu);
				menu = sc.nextInt();
				printItem(list,menu);
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


	@Override
	public void printSubMenu(int menu) {
		switch(menu) {
		case 2:
			System.out.println("----조회 메뉴-----");
			System.out.println("2-1. 전체 내역 확인");
			System.out.println("2-2. 년 내역 확인");
			System.out.println("2-3. 월 내역 확인");
			System.out.println("2-4. 일 내역 확인");
			System.out.println("----------------");
			System.out.print("메뉴 선택 : ");
			break;
		}
	}


	@Override
	public ArrayList<Item> sortMethod(ArrayList<Item> list) {
		Collections.sort(list, new Comparator<Item>() {
			@Override
			public int compare(Item a1, Item a2) {
				if(a1.getDate().getYear() != a2.getDate().getYear()) {
					return a1.getDate().getYear() -  a2.getDate().getYear();
				}if(a1.getDate().getMonth() != a2.getDate().getMonth()){
					return a1.getDate().getMonth() - a2.getDate().getMonth();
				}
				return a1.getDate().getDay() - a2.getDate().getDay();
			}
			});
		return list;
	}
	
	


}
