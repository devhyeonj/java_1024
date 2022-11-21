package day20.phonebook;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

//주말과제 다른 방식으로 해보기
public class PhoneListMain2 {

	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		int menu = 0;
		ArrayList<PhoneBook> phonebookList = new ArrayList<>();
		ArrayList<Integer> indexList = new ArrayList<>();
		PhoneBook phoneBook = null;
		Phone phone= null;
		do {
			printMainMenu();
			try {
			menu = sc.nextInt();
			}catch (InputMismatchException e) {
				System.out.println("정수형으로 다시 입력해주세요");
				menu = sc.nextInt();
			}
			runMainMenu(menu,phonebookList, phoneBook, phone, indexList);
		} while (menu!=5);
	}

	public static void runMainMenu(int menu,ArrayList<PhoneBook>phonebookList,PhoneBook createPhoneBook,Phone createPhone,ArrayList<Integer>indexList) {
		switch (menu) {
		case 1:
			inputCreateNumber(phonebookList, createPhoneBook);
			for (PhoneBook pb : phonebookList) {
				System.out.println(pb);
			}
			break;
		case 2:
			ArrayList<Integer> search = search(phonebookList);
			printSubMenu();
			try {
				int subMenu = sc.nextInt();
				RunsubMenu(phonebookList,search,subMenu,createPhoneBook);
			}catch(InputMismatchException e) {
				System.out.println("정수로 다시 입력해주세요.");
			}
			break;
		case 3:
			delete(phonebookList,indexList);
			break;
		case 4:
			search = search(phonebookList);
			break;
		case 5:
			System.out.println("프로그램을 종료 합니다.");
			break;
		default:
			System.out.println("잘못된 메뉴 입니다.");
			break;
		}
	}
	
	

	public static void RunsubMenu(ArrayList<PhoneBook> phonebookList, ArrayList<Integer> search, int subMenu,PhoneBook updatePhoneBook) {
		switch (subMenu) {
		case 1:// 이름 직장 수정
			if(!updatePerson(search,phonebookList)) {
				System.out.println("이름 직장을 수정에 실패 하였습니다.");
			}
			System.out.println("이름 직장을 수정 하였습니다.");
			break;
		case 2:// 기존 전화번호 수정
			printPhones(search, phonebookList);
			if(!updatePhone(search, phonebookList)) {
				System.out.println("기존 전화번호 수정에 실패하였습니다.");
			}
			System.out.println("기존 전화번호를 수정 하였습니다.");
			break;
		case 3:// 새 전화번호 추가 
			if(!addPhone(search, phonebookList)) {
				System.out.println("새 전화번호 추가에 실패하였습니다.");
			}
			System.out.println("새 전화번호를 추가하였습니다.");
			break;
		case 4:
			System.out.println("메뉴를 취소합니다.");
			break;
		}
	}

	public static boolean addPhone(ArrayList<Integer> search, ArrayList<PhoneBook> phonebookList) {
		sc.nextLine();
		System.out.print("이름:");String name = sc.nextLine();
		System.out.print("번호:");String number = sc.nextLine();
		for (int i = 0; i < search.size(); i++) {
			phonebookList.get(search.get(i)).addPhone(name, number);
		}
		return true;
	}

	public static boolean updatePhone(ArrayList<Integer> search, ArrayList<PhoneBook> phonebookList) {
		System.out.println("수정 할 전화번호를 선택해주세요");
		int updateNum = sc.nextInt()-1;
		System.out.println("수정 할 이름 번호를 입력해주세요");
		sc.nextLine();
		System.out.print("이름:");String name = sc.nextLine();
		System.out.print("번호:");String number = sc.nextLine();
		Phone p = new Phone(name, number);
		for (int i = 0; i < search.size(); i++) {
			phonebookList.get(search.get(i)).getPhoneList().set(updateNum, p);
		}
		return true;
		
	}

	public static void printPhones(ArrayList<Integer> search, ArrayList<PhoneBook> phonebookList) {
		for (int i = 0; i < search.size(); i++) {
			System.out.println(phonebookList.get(search.get(i)).getPhoneList());
			
		}
	}

	public static boolean updatePerson(ArrayList<Integer> search, ArrayList<PhoneBook> phonebookList) {
		sc.nextLine();
		System.out.print("성:");String lastName = sc.nextLine();
		System.out.print("이름:");String firstName = sc.nextLine();
		System.out.print("직장:");String work = sc.nextLine();
		for (int i = 0; i < search.size(); i++) {
			phonebookList.get(search.get(i)).updatePerson(lastName, firstName, work);
		}
		return true;
	}

	public static void printSubMenu() {
		System.out.println("1. 이름,직장 수정");
		System.out.println("2. 기존 전화번호 수정");
		System.out.println("3. 새 전화번호 추가");
	}
	
	public static boolean delete(ArrayList<PhoneBook> phonebookList, ArrayList<Integer> indexList) {
		if(phonebookList == null || phonebookList.size() ==0) {
			return false;
		}
		indexList = search(phonebookList);
		System.out.println("삭제 할 전화번호를 선택 해주세요.");
		int num = sc.nextInt()-1;
		
		if(num < 0 || num > indexList.size()) {
			System.out.println("다시 선택 해주세요.");
		}
		phonebookList.remove(num);
		System.out.println("삭제에 성공하였습니다.");
		return true;
		
	}

	public static PhoneBook inputCreatePerson() {
		String lastName = null,firstName = null,work = null;
		sc.nextLine();
		try {
			System.out.print("성:");lastName = sc.nextLine();
			System.out.print("이름:");firstName = sc.nextLine();
			System.out.print("직장:");work = sc.nextLine();
		}catch (InputMismatchException e) {
			System.out.println("다시 입력해주세요.");
		}
		return new PhoneBook(lastName, firstName, work);
	}
	
	public static void inputCreateNumber(ArrayList<PhoneBook>phonebookList,PhoneBook createPhoneBook) {
		createPhoneBook = inputCreatePerson();
		char ch;
		String name,number;
		do {
			
			System.out.print("이름:");name = sc.nextLine();
			System.out.print("번호:");number = sc.nextLine();
			System.out.println("전화번호를 더 입력 하시겠습니까?");ch = sc.next().charAt(0);
			sc.nextLine();
			createPhoneBook.addPhone(name, number);
		}while(ch != 'n');
		phonebookList.add(createPhoneBook);
	}

	public static void printMainMenu() {
		System.out.println("전화번호부 관리 프로그램 입니다.");
		System.out.println("1. 번호 추가");
		System.out.println("2. 번호 수정");
		System.out.println("3. 번호 삭제");
		System.out.println("4. 번호 조회");
		System.out.println("5. 프로그램 종료");
		System.out.print("메뉴선택:");
	}
	
	/**
	 * 성명을 입력받아 포함된 전화번호를 검색하여 출력하고 번호값 담긴 정수형 리스트를 리턴해주는 메소드
	 * @return 
	 */
	public static ArrayList<Integer> search(ArrayList<PhoneBook> phonebookList) {
		sc.nextLine();
		System.out.print("성명을 입력해주세요>>");
		String name = sc.nextLine();
		ArrayList<Integer> indexList = new ArrayList<>();
		for (int i = 0; i < phonebookList.size(); i++) {
			String fullname = phonebookList.get(i).getLastName()+phonebookList.get(i).getFirstName();
			if(fullname.contains(name)) {
				indexList.add(i);
			}
		}
		
		if(indexList == null || indexList.size() == 0) {
			System.out.println("검색 결과가 없습니다.");
			return null;
		}
		
		//성명이 포함된 전화번호를 출력
		for (int i = 0; i < indexList.size(); i++) {
			System.out.println(i+1+""+phonebookList.get(indexList.get(i)));
		}
		return indexList;
	}
}
