package home;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Predicate;

import day21.PhoneBook;
import day21.PhoneNumber;

public class PhoneListMain3 {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		int menu = 0;
		ArrayList<PhoneBook> list = new ArrayList<>();
		do {
			printMenu();
			try {
				menu = sc.nextInt();
				runMenu(list,menu);
			}catch (RuntimeException e) {
				System.out.println(e.getMessage());
			}
		}while(menu!=5);
	}

	
	private static void runMenu(ArrayList<PhoneBook> list, int menu) {
		switch (menu) {
		case 1: //전화번호 추가
			PhoneNumber p = inputPhoneNumber();
			inputPhoneNumbers();
			break;
		case 2://전화번호 수정
			update(list);
			break;
		case 3://전화번호 삭제
			delete(list);
			break;
		case 4://전화번호 조회
			printSearchNumber(list);
			break;
		case 5:
			System.out.println("프로그램을 종료 합니다.");
			break;
		default:
			throw new RuntimeException("잘못된 메뉴 입니다.");
		}
	}
	
	
	private static boolean update(ArrayList<PhoneBook> list) {
		sc.nextLine();
		System.out.print("이름:");String name = sc.next();
		ArrayList<Integer> indexs = search(list, (p) -> p.getName().contains(name));
		searchResult(list, indexs);
		int selectNum = sc.nextInt();
		if(selectNum < 0 || selectNum >= indexs.size()) {
			throw new RuntimeException("잘못 선택 하셨습니다.");
		}
		printSubMenu();
		int subMenu = sc.nextInt();
		int index = indexs.get(selectNum);
		return runSubMenu(subMenu, list.get(index));
	}
	
	private static boolean runSubMenu(int subMenu, PhoneBook pb) {
		switch (subMenu) {
		case 1:
			sc.nextLine();
			System.out.print("성명 : ");
			String name = sc.nextLine();
			System.out.print("직장 : ");
			String company = sc.nextLine();
			
			pb.update(name,company);
			
			break;
		case 2:
			sc.nextLine();
			//기존 전화번호 수정
			pb.printPhoneNumbers();
			System.out.print("번호 입력:");
			int index = sc.nextInt()-1;
			System.out.print("이름 : ");
			String pName = sc.nextLine();
			System.out.print("번호 : ");
			String number = sc.nextLine();
			pb.getPnList().get(index).update(pName,number);
			break;
		case 3:
			sc.nextLine();
			ArrayList<PhoneNumber> pnList = inputPhoneNumbers();
			pb.getPnList().addAll(pnList);
			break;
		default:
			System.out.println("잘못된 메뉴");
			return false;
		}
		return true;
		
	}


	private static boolean delete(ArrayList<PhoneBook> list) {
		sc.nextLine();
		System.out.print("이름:");String name = sc.next();
		ArrayList<Integer> indexs = search(list, p -> p.getName().contains(name));
		searchResult(list, indexs);
		int selectNum = sc.nextInt()-1;
		if(selectNum < 0 || selectNum >= indexs.size()) {
			return false;
		}
		return list.remove(selectNum) != null;
		
	}


	private static void printSearchNumber(ArrayList<PhoneBook> list) {
		sc.nextLine();
		System.out.print("이름:");String name = sc.next();
		ArrayList<Integer> indexs = search(list, p -> p.getName().contains(name));
		searchResult(list, indexs);
		int selectNum = sc.nextInt();
		if(selectNum == 0 || selectNum <= indexs.size()) {
			return ;
		}
		list.get(selectNum).print();
	}
	private static ArrayList<Integer> search(ArrayList<PhoneBook> list,Predicate<PhoneBook> p) {
		ArrayList<Integer> indexs = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			if(p.test(list.get(i))) {
				indexs.add(i);
			}
		}
		return indexs;
	}
	
	private static void searchResult(ArrayList<PhoneBook> list,ArrayList<Integer> indexs) {
		if(list == null || list.size() == 0 || indexs == null || indexs.size() ==0) {
			throw new RuntimeException("검색 결과가 없습니다");
		}
		for (int i = 0; i < indexs.size(); i++) {
			int index= indexs.get(i);
			System.out.println(i+1+". "+list.get(index));
		}
	}
	

	private static ArrayList<PhoneNumber> inputPhoneNumbers() {
		ArrayList<PhoneNumber> pnList = new ArrayList<>();
		do {
			PhoneNumber p = inputPhoneNumber();
			pnList.add(p);
			System.out.println("전화번호를 더 입력 하시겠습니까?");
		}while(sc.next().charAt(0) != 'n');
		return pnList;
	}


	private static PhoneNumber inputPhoneNumber() {
		System.out.print("이름:");String pName = sc.next();
		System.out.print("번호:");String number = sc.next();
		return new PhoneNumber(pName, number);
	}


	private static void printMenu() {
		System.out.println("=========메뉴=========");
		System.out.println("1. 전화번호 추가");
		System.out.println("2. 전화번호 수정");
		System.out.println("3. 전화번호 삭제");
		System.out.println("4. 전화번호 조회");
		System.out.println("5. 프로그램 종료");
		System.out.println("=====================");
		System.out.print("메뉴 선택 : ");
	}
	
	
	private static void printSubMenu() {
		System.out.println("=======수정 메뉴=======");
		System.out.println("1. 이름, 직장 수정");
		System.out.println("2. 기존 전화번호 수정"); 
		System.out.println("3. 새 전화번호 등록");
		System.out.println("=====================");
		System.out.print("메뉴 선택 : ");
	}

		

}