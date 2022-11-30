package day28;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

//강사님 코드
public class BoardMain {
	
	private static Scanner sc = new Scanner(System.in);
	//이렇게 하면 매개변수로 안넘겨도 되서 편해짐
	private static List<Member> memberList = new ArrayList<Member>();
	private static List<Object> boardList = new ArrayList<Object>();
	private static List<String> categoryList = new ArrayList<String>();//공지,자유
	private static Member user; // 얘를 바탕으로 새로운 리스트를 만들어줌 
	/*
	 * - 기능
	 * - 회원관리
	 * 	- 로그인
	 * 	- 회원가입
	 * - 게시글 관리
	 * 	- 게시글 등록 (회원만)
	 *  - 게시글 수정 (회원 + 작성자 본인)
	 *  - 게시글 삭제 (회원 + 작성자 본인)
	 *  - 게시글 목록 
	 *  	- 게시글 검색(검색 번호는 게시글 번호로)
	 *  	- 게시글 확인
	 *  - 카테고리 관리 (회원 + 관리자만)
	 *  	- 카테고리 추가
	 *  	- 카테고리 수정
	 *  	- 카테고리 삭제
	 *  
	 */
	public static void main(String[] args) {
		int menu = -1;
		loadMember("member.txt");
		loadCategory("category.txt");
		do {
			try{
			printMenu();
			menu = sc.nextInt();
			sc.nextLine(); // 위에서 입력한 엔터를 비움
			printBar();
			runMenu(menu);
			}catch(InputMismatchException e) {
				sc.nextLine(); // 잘못된 문자열들을 비워줌
				printStr("숫자를 입력하세요.");
			}catch(Exception e) {
				printStr(e.getMessage());
			}
		}while(menu != 4);
		saveMember("member.txt");
		saveCategory("category.txt");
		
	}
	private static void saveCategory(String filename) {
		try(ObjectOutputStream oos
				= new ObjectOutputStream(new FileOutputStream(filename))) {
			for (String category : categoryList) {
				oos.writeObject(category);
			}
			System.out.println("저장 완료");
		}catch(IOException e) {
			printStr("저장 실패");
		}
	}
	private static void loadCategory(String filename) {
		try(ObjectInputStream ois
				= new ObjectInputStream(new FileInputStream(filename))) {
			while(true) {
				String category = (String) ois.readObject();
				categoryList.add(category);
			}
		}catch (ClassNotFoundException e) {
			printStr("저장 실패");
		}catch (EOFException e) {
			if(categoryList.size() == 0)
				categoryList // 저장이 안되있으면 우선 공지 자유가 오도록 // 파일에저장이 안되있어도 기본적으로 공지 자유가 들어가게
				= new ArrayList<String>(Arrays.asList("공지","자유"));
			System.out.println("불러오기 성공");
		}catch(IOException e ) {
			printStr("저장 실패");
		}
	}
	private static void saveMember(String filename) {
		if(memberList.size() == 0) {
			return;
		}
		try(ObjectOutputStream oos
				= new ObjectOutputStream(new FileOutputStream(filename))) {
			for (Member member : memberList) {
				oos.writeObject(member);
			}
			System.out.println("저장 완료");
		}catch(IOException e) {
			printStr("저장 실패");
		}
	}
	private static void loadMember(String filename) {
		try(ObjectInputStream ois
				= new ObjectInputStream(new FileInputStream(filename))) {
			while(true) {
				Member member = (Member) ois.readObject();
			}
		}catch (ClassNotFoundException e) {
			printStr("저장 실패");
		}catch (EOFException e) {
			System.out.println("불러오기 성공");
		}catch(IOException e ) {
			printStr("저장 실패");
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
			throw new RuntimeException("잘못된 메뉴를 선택했습니다.");
		}
	}
	
	private static void categoryMenu() {
		// 관리자 체크 => 관리자가 아니면 메인메뉴로
		if(!isAdmin()) {
			return ;
		}
		int submenu = -1;
					// 서브 메뉴를 출력
					do {
						printSubmenu(3);
					//서브 메뉴 선택 및 선택한 서브 메뉴에 맞는 기능 실행
						submenu = sc.nextInt();
						sc.nextLine();
						printBar();
						runCategoryMenu(submenu);
				
					}while(submenu != 5);
					}
	private static void runCategoryMenu(int submenu) {
		switch(submenu) {
		case 1:
			insertCategory();
			System.out.println(categoryList);
			break;
		case 2:
			updateCategory();
			System.out.println(categoryList);
			break;
		case 3:
			deleteCategory();
			break;
		case 4:
			printCategory();
			break;
		case 5:
			break;
		default:
		//1. 카테고리 추가
		// 새 카테고리명 입력

		// 기존 카테고리에 있는지 확인하여 없으면 추가
	//2. 카테고리 수정
		// 수정할 카테고리명 입력
		
		// 기존 카테고리에 있는지 확인하여 없으면 수정
			//삭제할 카테고리명 입력

			//기존 카테고리에 있으면 삭제

		// 새 카테고리명 입력
	//3. 카테고리 삭제
			
		//삭제할 카테고리명 입력

		//기존 카테고리에 있으면 삭제
	//4. 카테고리 확인
	//5. 이전
	}
	}
	private static void printCategory() {
		if(categoryList.size() ==0) {
			printStr("등록된 카테고리가 없습니다.");
			return;
		}
		for (int i = 0; i < categoryList.size(); i++) {
			System.out.println(i+1+". " + categoryList.get(i));
		}
	}
	private static void deleteCategory() {
		System.out.println("카테고리명 : ");
		String category = sc.nextLine();
		printBar();
		
		if(categoryList.remove(category)) {
			printStr("카테고리를 삭제했습니다.");
			return;
		}
		printStr("등록되지 않은 카테고리 입니다.");
		
	}
	private static void updateCategory() {
		System.out.println("카테고리명 : ");
		String category = sc.nextLine();
		printBar();
		
		if(!categoryList.contains(category)) {
			printStr("등록되지 않은 카테고리입니다.");
			return ;
		}
		
		System.out.println("카테고리명 : ");
		String newCategory = sc.nextLine();
		printBar();
		if(!categoryList.contains(newCategory)) {
			categoryList.remove(category); 
			categoryList.add(newCategory);
			printStr("카테고리 수정에 성공했습니다.");
			return ;
		}
		printStr("이미 등록된 카테고리 입니다. ");
		
		
	}
	private static void insertCategory() {
		System.out.println("카테고리명 : ");
		String category = sc.nextLine();
		printBar();
		
		if(categoryList.indexOf(category) == -1) {
			categoryList.add(category);
			printStr("새 카테고리를 추가 했습니다");
			return ;
		}
		printStr("이미 존재하는 카테고리 입니다.");
		
	}
	private static boolean isAdmin() {
		if(user == null || user.getAuthority() == Authority.ADMIN) {
			printStr("관리자가 아닙니다. 해당 기능을 이용할 수 없습니다.");
			return false;
		}
		return true;
	}
	private static void boardMenu() {
		//서브 메뉴를 출력
		
		//서브 메뉴 선택 및 선택한 서브 메뉴에 맞는 기능 실행 => 반복
			// 1. 게시글 등록
				//회원 체크 => 회원(로그인한 사용자)이 아니면 게시글 등록 못함
			
				// 게시글 정보(제목,내용) 입력
			
				// 게시글을 등록
		
			// 2. 게시글 수정
				//회원 체크 => 회원(로그인한 사용자)이 아니면 게시글 등록 못함
				
				//수정할 게시글 번호 입력
		
				//해당 게시글이 존재하지 않거나, 작성자가 회원과 같지 않으면 수정 못함
					
				// 게시글 정보(제목,내용) 입력
			
				// 게시글을 등록
			// 3. 게시글 삭제
				// 회원 체크 => 회원(로그인한 사용자)이 아니면 게시글 등록못함
		
				//삭제할 게시글 번호 입력
		
				//해당 게시글이 존재하지 않거나 작성자가 회원과 같지 않으면 삭제 못함
		
				//해당 게시글 삭제
		    // 4. 게시글 목록
				// 서브 메뉴 출력
		
				//서브 메뉴 선택 및 기능 실행
					// 1. 게시글 목록 확인
						//모든 게시글 확인
					// 2. 게시글 검색
						//검색어 입력 후 게시글 확인
					// 3. 게시글 확인
						// 게시글 번호를 입력
		
						// 입력한 게시글이 있으면 확인
					// 4. 이전
			// 5. 이전
	}
	private static void memberMenu() {
		//로그인 체크 => 로그인 한 사람은 로그인/회원가입 시도를 할 수 없게 하기 위해
		if(checkLogin(true)) // true면 로그인했는지 물어보고 false면 로그인 안했는지 물어봄
			return; // true이면 리턴으로 빠져나감
		int submenu = -1;
		do {
		//서브 메뉴를 출력
		printSubmenu(1);
		//서브 메뉴 선택 및 선택한 서브 메뉴에 맞는 기능 실행 => 반복
		submenu = sc.nextInt();
		sc.nextLine();
		submenu = runMemberMenu(submenu); // 로그인성공하면 자동으로 메인으로 넘어감
			
		}while(submenu != 3);
	}
	private static int runMemberMenu(int submenu) {
		switch (submenu) {
		case 1://1. 회원가입
			signup();
			break;
		case 2:	//2. 로그인
			login();
			if(user != null) // 로그인성공
			return 3; // 로그인 성공하면 서브 메뉴를 3으로 수정하여 자동으로 메인으로 이동하게 함
			break; 
		case 3:	//3. 이전
			printStr("이전 메뉴로 돌아갑니다.");
			break;
		default:
			printStr("잘못된 메뉴를 선택했습니다.");
		}
		return submenu;
		
	}
	private static void login() {
		//회원 정보 입력(아이디,비번)
		System.out.println("로그인 정보 입력");
		Member member = inputMember();
		//일치하는 회원이 있으면 회원 정보를 가져옴(로그인 성공)
		int index = memberList.indexOf(member);
		if(index == -1) {
			printStr("로그인 실패");
			return;
		}
		user = memberList.get(index);
		printStr("로그인 성공");
		//로그인 성공하면 서브 메뉴를 3으로 수정하여 자동으로 메인으로 이동하게 함
	}
	private static void signup() {
		//회원 정보 입력
		System.out.println("회원 정보 입력");
		Member member = inputMember(); // 입력한 정보를 객체로 돌려줌
		//가입된 아이디인지 체크
		if(isMember(member)) {
			printStr("이미 가입된 아이디입니다.");
			return ;
		}

		//가입된 아이디가 아니면 회원가입 진행
		memberList.add(member);
		printStr("회원 가입이 완료 되었습니다.");
	}
	
	private static boolean isMember(Member member) {
		if(member == null)
			return false;
		if(memberList == null)
			memberList = new ArrayList<Member>();
		if(memberList.size() == 0) 
			return false;
		for (Member tmp : memberList) {
			if(tmp.getId().equals(member.getId())) {
				return true;
			}
		}
		return false;
	}
	private static Member inputMember() {
		System.out.print("아이디 : ");String id = sc.nextLine();
		System.out.print("비밀번호 : ");String pw = sc.nextLine();
		Authority authority = memberList.size() == 0? Authority.ADMIN : Authority.MEMBER;
		return new Member(id, pw, authority);
	}
	private static void printSubmenu(int menu) {
		switch (menu) {
		case 1:
			System.out.println("=======회원 관리 메뉴=======");
			System.out.println("1. 회원 가입");
			System.out.println("2. 로그인");
			System.out.println("3. 이전");
			break;
		case 2:
			System.out.println("=======게시글 관리 메뉴=======");
			System.out.println("1. 게시글 등록");
			System.out.println("2. 게시글 수정");
			System.out.println("3. 게시글 삭제");
			System.out.println("4. 게시글 목록");
			System.out.println("5. 이전");
			break;
		case 3:
			System.out.println("=======카테고리 관리 메뉴=======");
			System.out.println("1. 카테고리 등록");
			System.out.println("2. 카테고리 수정");
			System.out.println("3. 카테고리 삭제");
			System.out.println("4. 카테고리 목록");
			System.out.println("5. 이전");
			break;
		}
		//공통된 부분이라 switch밖으로 뺌
		printBar();
		System.out.print("메뉴 선택 :");
	}
	private static boolean checkLogin(boolean res) {
		if(user != null && res) { //로그인함 res true
			printStr("로그인한 회원은 해당 기능을 이용할 수 없습니다.");
			return true;
		}else if(user ==null && !res){ // res false
			printStr("로그인 하지 않은 사용자는 해당 기능을 이용할 수 없습니다.");
			return true;
		}
		return false;
	}
	private static void printMenu() {
		System.out.println("=======메뉴=======");
		System.out.println("1. 회원 관리");
		System.out.println("2. 게시글 관리");
		System.out.println("3. 카테고리 관리");
		System.out.println("4. 프로그램 종료");
		printBar();
		System.out.print("메뉴 선택 :");
	}
	
	private static void printStr(String str) {
		System.out.println(str);
		printBar();
	}
	
	private static void printBar() {
		System.out.println("================");
	}
}
