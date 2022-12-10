package home.example.board;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BoardProgram {
	
	private static Scanner sc = new Scanner(System.in);
	
	private List<Board> boardList = new ArrayList<>();
	private List<Category> categoryList = new ArrayList<>();
	private List<Member> memberList = new ArrayList<>();
	private List<Comment> commentList = new ArrayList<>();
	private MemberController mc = new MemberController();

	public void run() {
		int menu = -1;
		final int exit = 5;
		do {
			try {
				printMenu();
				menu = sc.nextInt();
				sc.nextLine();
				runMainMenu(menu);
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}while(menu != exit);
	}
	

	private void runMainMenu(int menu) {
		switch (menu) {
		case 1:
			subMenu(1);
			break;
		case 2:
			subMenu(2);
			break;
		case 3:
			subMenu(3);
			break;
		case 4:
			subMenu(4);
			break;
		case 5:
			break;
		default:
		}
	}
	
	private void subMenu(int num) {
		switch (num) {
		case 1:
			System.out.println("====회원 관리 메뉴====");
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.println("0. 이전");
			break;
		case 2:
			System.out.println("====게시글 관리 메뉴====");
			System.out.println("1. 게시글 등록");
			System.out.println("2. 게시글 수정");
			System.out.println("3. 게시글 삭제");
			System.out.println("4. 게시글 목록");
			System.out.println("0. 이전");
			break;
		case 3:
			System.out.println("====카테고리 관리 메뉴====");
			break;
		case 4:
			System.out.println("====댓글 관리 메뉴====");
			break;

		default:
			System.out.println("잘못된 메뉴를 선택 하셨습니다.");
		}
		System.out.println("============================");
		System.out.print("메뉴선택>>");
	}

	private void printMenu() {
		System.out.println("======메뉴======");
		System.out.println("1. 회원 관리");
		System.out.println("2. 게시글 관리");
		System.out.println("3. 카테고리 관리");
		System.out.println("4. 댓글 관리");
		System.out.println("5. 프로그램 종료");
		System.out.println("===============");
		System.out.print("메뉴 선택 :");
	}
}
