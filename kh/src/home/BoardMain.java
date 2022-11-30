package home;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import home.Member;

//복습
public class BoardMain {
	
	private static Scanner sc = new Scanner(System.in);
	private static List<Member> memberList = new ArrayList<>();
	private static List<String> categoryList = new ArrayList<>();
	private static Member user;
	
	public static void main(String[] args) {
		int menu = -1;
		
		do {
			try {
				printMenu();
				menu = sc.nextInt();
				sc.nextLine(); // 위에서 입력한 엔터를 비움
				printBar();
				runMenu(menu);
			}catch (InputMismatchException e) {
				sc.nextLine(); // 잘못된 문자열들을 비워줌
				printStr("숫자를 입력하세요.");
			}catch(Exception e) {
				printStr("예외 발생"+ e.getMessage());
				e.printStackTrace();
			}
		}while(menu!= 4);
		save("member.txt", memberList);
		save("category.txt", categoryList);
	}
	
	private static <T> void save(String filename, List<T> list) {
		try(ObjectOutputStream oos =
				new ObjectOutputStream(new FileOutputStream(filename))) {
			for (T tmp : list) {
				oos.writeObject(tmp);
			}
			printStr("저장 완료");
		}catch (IOException e) {
			printStr("저장 실패");
		}
	}
	
	private static <T> void load(String filename, List<T> list) {
		try(ObjectInputStream ois =
				new ObjectInputStream(new FileInputStream(filename))) {
			while(true) {
				T obj = (T)ois.readObject();
				list.add(obj);}
			}catch(ClassNotFoundException e) {
				printStr("불러오기 실패");
			}catch(EOFException e) {
				printStr("불러오기 성공");
			}catch(IOException e) {
				printStr("불러오기 실패");
			}
	}

	private static void runMenu(int menu) {
		switch (menu) {
		case 1:
			memberMenu();
			break;
		case 2:
			boardMenu();
			break;
		case 3:
			categoryMenu();
			break;
		case 4:
			printStr("프로그램 종료");
			break;
		default:
			throw new RuntimeException("잘못된 메뉴를 선택 했습니다.");
		}
	}

	private static void boardMenu() {
		// TODO Auto-generated method stub
		
	}

	private static void categoryMenu() {
		//관리자 체크
		if(!isAdmin()) {
			return ;
		}
		int submenu = -1;
		do {
			printSubmenu(3);
			submenu = sc.nextInt();
			sc.nextLine();
			printBar();
			runCategoryMenu(submenu);
		}while(submenu != 5);
	}
		

	private static void runCategoryMenu(int submenu) {
		switch (submenu) {
		case 1:
			insertCategory();
			break;
		case 2:
			updateCategory();
			break;
		case 3:
			deleteCategory();
			break;
		case 4:
			printCategory();
			break;
		case 5:
			printStr("이전 메뉴로 돌아갑니다.");
			break;

		default:
			printStr("잘못된 메뉴를 선택했습니다.");
		}
	}

	private static void printCategory() {
		if(categoryList.size() == 0 ) {
			printStr("등록된 카테고리가 없습니다.");
			return;
		}
		for(int i = 0 ; i< categoryList.size(); i++) {
			System.out.println(i+1+". " + categoryList.get(i));
		}
		printBar();
	}

	private static void deleteCategory() {
		System.out.print("카테고리명 : ");
		String category = sc.nextLine();
		printBar();
		
		if(categoryList.remove(category)) {
			printStr("카테고리를 삭제했습니다.");
			return ;
		}
		printStr("등록되지 않은 카테고리 입니다.");
	}

	private static void updateCategory() {
		System.out.print("카테고리명 : ");
		String category = sc.nextLine();
		printBar();
		
		if(!categoryList.contains(category)) {
			printStr("등록되지 않은 카테고리 입니다.");
			return ;
		}
		System.out.print("카테고리명 : ");
		String newCategory = sc.nextLine();
		printBar();
		//기존 카테고리에 있는지 확인하여 없으면 수정
		if(!categoryList.contains(category)) {
			categoryList.remove(category);
			categoryList.add(newCategory);
			printStr("카테고리 수정에 성공했습니다.");
			return;
		}
		printStr("이미 등록된 카테고리 입니다.");
	}

	private static void insertCategory() {
		System.out.print("카테고리명 : ");
		String category = sc.nextLine();
		printBar();
		//카테고리 중복 확인
		if(categoryList.indexOf(category) == -1) {
			categoryList.add(category);
			printStr("새 카테고리를 추가했습니다.");
			return ;
		}
		printStr("이미 있는 카테고리 입니다.");
		
	}

	private static boolean isAdmin() {
		if(user == null || user.getAuthority() != Authority.ADMIN) {
			printStr("괸리자가 아닙니다. 해당 기능을 이용할 수 없습니다.");
			return false;
		}
		return true;
	}

	private static void memberMenu() {
		//로그인 체크
		if(checkLogin(true))
			return;
		int submenu = -1;
		do {
			printSubmenu(1);
			submenu = sc.nextInt();
			sc.nextLine();
			submenu = runMemberMenu(submenu);
		}while(submenu != 3);
	}

	private static int runMemberMenu(int submenu) {
		switch (submenu) {
		case 1: //회원가입
			signup();
			break;
		case 2: //로그인
			login();
			//로그인 성공하면 서브 메뉴를 3으로 수정하여 자동으로 메인으로 이동하게 함
			if(user != null)
				return 3;
			break;
		case 3:
			printStr("이전 메뉴로 돌아갑니다.");
			break;
		default:
			printStr("잘못된 메뉴를 선택했습니다.");
		}
		return submenu;
	}

	private static void login() {
		System.out.println("로그인 정보 입력");
		Member member = inputMember();
		//일치하는 회원이 있으면 회원 정보를 가져옴(로그인 성공)
		int index = memberList.indexOf(member);
		if(index == -1) {
			printStr("로그인 실패");
			return ;
		}
		user = memberList.get(index); // 담아줌
		printStr("로그인 성공");
		
	}

	private static void signup() {
		System.out.println("회원 정보 입력");
		Member member = inputMember();
		//가입된 아이디인지 체크
		if(isMember(member)) {
			printStr("이미 가입된 아이디입니다.");
			return;
		}
		memberList.add(member);
		printStr("회원 가입이 완료되었습니다.");
	}

	private static boolean isMember(Member member) {
		if(member == null)
			return false;
		if(memberList == null)
			memberList = new ArrayList<>();
		if(memberList.size() ==0) 
			return false;
		for (Member tmp : memberList) {
			if(tmp.getId().equals(member.getId())) {
				return false;
			}
		}
		
		return false;
	}

	private static boolean checkLogin(boolean res) {
		if(user != null && res) {
			printStr("로그인한 사용자는 해당 기능을 이용할 수 없습니다.");
			return true;
		}
		if(user != null && !res) {
			printStr("로그인 하지 않은 사용자는 해당 기능을 이용할 수 없습니다.");
			return true;
		}
		return false;
	}

	private static Member inputMember() {
		System.out.print("아이디 : ");
		String id = sc.nextLine();
		System.out.print("비밀번호:");
		String pw = sc.nextLine();
		printBar();
		Authority authority = memberList.size() == 0 ? Authority.ADMIN : Authority.MEMBER;
		return new Member(id, pw, authority);
	}
	
	private static void printSubmenu(int menu) {
		switch (menu) {
		case 1:
			System.out.println("=====회원관리메뉴=====");
			System.out.println("1. 회원 가입");
			System.out.println("2. 로그인");
			System.out.println("3. 이전");
			break;
		case 2:
			System.out.println("=====게시글관리메뉴=====");
			System.out.println("1. 게시글 등록");
			System.out.println("2. 게시글 수정");
			System.out.println("3. 게시글 삭제");
			System.out.println("4. 게시글 목록");
			System.out.println("5. 이전");
			break;
		case 3:
			System.out.println("=====카테고리관리메뉴=====");
			System.out.println("1. 카테고리 등록");
			System.out.println("2. 카테고리 수정");
			System.out.println("3. 카테고리 삭제");
			System.out.println("4. 카테고리 목록");
			System.out.println("5. 이전");
			break;
		}
		printBar();
		System.out.print("메뉴 선택 : ");
	}
	
	private static void printMenu() {
		System.out.println("========메뉴========");
		System.out.println("1. 회원 관리"); //회원가입 로그인 이전
		System.out.println("2. 게시글 관리"); // 게시글 등록 게시글 수정 게시글 삭제 게시글 목록 이전
		System.out.println("3. 카테고리 관리"); //카테고리 등록 카테고리 수정 카테고리 삭제 카테고리 목록 이전
		System.out.println("4. 프로그램 종료");
		printBar();
		System.out.print("메뉴 선택 :");
	}
	
	private static void printStr(String str) {
		System.out.println(str);
		printBar();
	}
	
	private static void printBar() {
		System.out.println("===================");
	}
}
