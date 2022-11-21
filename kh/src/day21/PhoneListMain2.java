package day21;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Predicate;

import jdk.jshell.spi.ExecutionControl.RunException;

//강사님 코드
public class PhoneListMain2 {
	
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
	ArrayList<PhoneBook> list = new ArrayList<PhoneBook>();
	ArrayList<PhoneNumber> pnList = new ArrayList<PhoneNumber>();
	int menu = 0;
	do {
		printMenu();
		try{
			menu = sc.nextInt();
			runMune(menu, list);
		}catch(RuntimeException e) {
			System.out.println(e.getMessage());
		} // 예외가 발생한 순간에 메소드를 종료시키고 나와서 밑에코드를 실행안한다.
	}while(menu != 5);
		

	}//main

	public static void runMune(int menu, ArrayList<PhoneBook> list) {
		switch (menu) {
		case 1:
			if(insertPhoneBook(list)) {
				System.out.println("전화번호를 추가했습니다.");
				for (PhoneBook tmp : list) {
					System.out.println(tmp);
				}
			}else {
				System.out.println("전화번호를 추가하지 못했습니다.");
			}
			break;
		case 2:
			if(updatePhoneBook(list)) {
				System.out.println("전화번호를 수정했습니다.");
			}else {
				System.out.println("전화번호를 수정하지 못했습니다.");
			}
			break;
		case 3:
			if(deletePhoneBook(list)) {
				System.out.println("전화번호를 삭제했습니다.");
			}else {
				System.out.println("전화번호를 삭제하지 못했습니다.");
			}
			break;
		case 4:
			printSearchNumber(list);
			break;
		case 5:
			System.out.println("프로그램 종료");
			break;
		default:
			System.out.println("잘못된 메뉴입니다. 다시 선택하세요.");
		}
	}

	private static boolean updatePhoneBook(ArrayList<PhoneBook> list) {
	}
	
	
													//수정할정보가 들어가야되서~~
	private static boolean runSubMenu(int subMenu, PhoneBook pb) {
		if(pb == null) {
			return false;
		}
		switch (subMenu) {
		case 1:
			break;
		case 2:
			break;
		case 3:
			break;
		default:
			return false;
		}
		return true;
	}
	private static void printSubMenu() {
		System.out.println("=========수정 메뉴=======");
		System.out.println("1. 이름,직장 수정");
		System.out.println("2. 기존 전화번호 수정");
		System.out.println("3. 새 전화번호 등록");
		System.out.println("======================");
		System.out.println("메뉴 선택:");
	}

	private static void printSearchNumber(ArrayList<PhoneBook> list) {
		sc.nextLine();
		System.out.print("이름 : ");
		String name = sc.next();
		ArrayList<Integer> indexs = searchPhoneBook(list, (p)-> p.getName().contains(name));
		
		printIndexsNumber(list, indexs);
		int selectIndex = sc.nextInt()-1;
		if(selectIndex <0 || selectIndex >= indexs.size()) {
			return ;
		}
		list.get(selectIndex).print();
	}
	/**
	 * 검색 결과를 출력해주는 메소드
	 * @param list
	 * @param indexs
	 */
	private static void printIndexsNumber(ArrayList<PhoneBook> list,
			ArrayList<Integer> indexs) {
		if(indexs == null || indexs.size() == 0 || list == null || list.size()== 0) {
			throw new RuntimeException("검색 결과가 없습니다."); //테스트하다가 원하는 상황이 발생하지 않기 때문에 해결 해야한다.
		}
		
		for (int i = 0; i < indexs.size(); i++) {
			int index = indexs.get(i);
			System.out.println(i+1+"."+list.get(index));
		}
		
	}
 	

	public static boolean deletePhoneBook(ArrayList<PhoneBook> list) {
		sc.nextLine();
		System.out.print("이름 : ");
		String name = sc.nextLine();
		ArrayList<Integer> indexs
		= searchPhoneBook(list, (p) -> p.getName().contains(name));
		
		printIndexsNumber(list,indexs);
		
	}
	/**
	 * PhoneBook 번지를 찾아 번지 저장하는 정수형 리스트를 돌려주는 메소드
	 * @param list
	 * @param p
	 * @return
	 */
	private static ArrayList<Integer> searchPhoneBook(ArrayList<PhoneBook> list, Predicate<PhoneBook> p) {
		ArrayList<Integer> indexs = new ArrayList<Integer>();
		for (int i = 0; i < list.size(); i++) {
			if(p.test(list.get(i))) {
				indexs.add(i);
			}
		}
		return indexs;
	}

	/**
	 * Phonebook 객체를 생성해서 list에 넣어주는 메소드
	 * @param list
	 * @return
	 */
	private static boolean insertPhoneBook(ArrayList<PhoneBook> list) {
		sc.nextLine();
		System.out.print("성명 : ");
		String name = sc.nextLine();
		System.out.print("직장 : ");
		String company = sc.nextLine();
		
		ArrayList<PhoneNumber> pnList;
		
		try {
			pnList = inputPhoneNumbers();
		}catch(RuntimeException e) {
			return false;
		}
		PhoneBook pb = new PhoneBook(name, company, pnList);
		list.add(pb);
		return true;
	}

	private static void printMenu() {
		System.out.println("=====메뉴=====");
		System.out.println("1. 전화번호 추가");
		System.out.println("2. 전화번호 수정");
		System.out.println("3. 전화번호 삭제");
		System.out.println("4. 전화번호 조회");
		System.out.println("5. 프로그램 종료 ");
		System.out.println("=============");
		System.out.print("메뉴 선택:");
	}
	/**
	 * PhoneNumber 객체를 생성해주는 메소드
	 * @return
	 */
	private static PhoneNumber inputPhoneNumber() {
		System.out.print("이름(집,직장 등):");
		String pName = sc.nextLine();
		System.out.print("번호(예:010-1234-5678) : ");
		String number = sc.nextLine();
		return new PhoneNumber(pName,number);
		
	}
	/**
	 * 메소드로부터 만들어진 PhoneNumber 객체를 pnList 추가하는 메소드
	 * 계속 추가 가능 do while문으로 물어봄 
	 * @return
	 */
	private static ArrayList<PhoneNumber> inputPhoneNumbers() {
		ArrayList<PhoneNumber> pnList = new ArrayList<PhoneNumber>();
		do {
			PhoneNumber pn = inputPhoneNumber();
			pnList.add(pn);
			System.out.println("더 입력하시겠습니까?(y/n) : ");
		}while(sc.nextLine().charAt(0) != 'n');
		return pnList;
	}

}//class
