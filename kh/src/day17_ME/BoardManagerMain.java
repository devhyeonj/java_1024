package day17_ME;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BoardManagerMain {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		/*
		 * 게시글 관리 프로그램을 작성하세요. 1. 게시글 작성 2. 게시글 조회 3. 게시글 수정 4. 게시글 삭제 5. 프로그램 종료 - 게시글은
		 * 제목, 내용, 작성자, 작성일, 조회수 로 구성 - 게시글 전체 조회는 나중에 작성된 게시글이 상단에 조회 - 게시글 상세 조회는 게시글
		 * 번호를 입력하여 게시글 내용을 확인 - 게시글 상세 조회를 하면 조회수가 1 증가 - 게시글 수정은 게시글 번호를 선택하면 해당 게시글의
		 * 제목,내용을 수정 - 게시글 삭제는 게시글 번호를 선택하면 해당 게시글을 삭제
		 * 
		 */
		int menu = 0;
		ArrayList<Board> boardList = new ArrayList<Board>();
		Board board = null;
		do {
			try {
				menuPrint();
				menu = sc.nextInt();
				runMenu(boardList, menu, sc, board);
			} catch (InputMismatchException e) {
				System.out.print("정수로 다시 입력해주세요.");
			}
		} while (menu != 5);

	}

	private static void menuPrint() {
		System.out.println("1. 게시글 작성");
		System.out.println("2. 게시글 조회");
		System.out.println("3. 게시글 수정");
		System.out.println("4. 게시글 삭제");
		System.out.println("5. 프로그램 종료");
		System.out.print("메뉴입력>>");
	}
	
	private static void sMenu(ArrayList<Board> boardList) {
		System.out.println("1. 전체 조회");
		System.out.println("2. 상세 조회");
		System.out.print("메뉴 선택 :");
		int subMenu = sc.nextInt();
		switch (subMenu) {
		case 1://전체조회
			select(boardList);
			break;
		case 2:
			break;
		default:
			System.out.println("잘못된 메뉴 입니다.");
		}
	}
	
	

	private static void runMenu(ArrayList<Board> boardList, int menu, Scanner sc, Board board) {
		switch (menu) {
		case 1:// 작성
			insert(boardList, sc);
			break;
		case 2:// 조회
			sMenu(boardList);
			detailSelect(boardList);
			break;
		case 3:// 수정
				update(boardList);
			break;
		case 4:// 삭제
			if(delete(boardList)) {
				System.out.println("삭제에 성공했습니다.");
			}else {
				System.out.println("삭제에 실패했습니다.");
			}
			break;
		case 5:// 프로그램 종료
			System.out.println("프로그램을 종료 합니다.");
			break;
		default:
			System.out.println("잘못 입력 하셨습니다.");
			break;
		}
	}

	private static Board detailSelect(ArrayList<Board> boardList) {
		int boardNum;
		System.out.print("상세보기 할 게시물 번호를 입력하세요>>");
		boardNum = sc.nextInt();
		
		int index = boardList.indexOf(new Board(boardNum));
		
		if(index == -1) {
			System.out.println("없는 게시글 번호입니다.");
			return null;
		}
		Board board = boardList.get(index);
		board.setViews(board.getViews()+1);
		System.out.println(boardList.get(index));
		return board;
		
	}

	private static boolean update(ArrayList<Board> boardList) {
		System.out.println("게시글을 수정 합니다.");
		sc.nextLine();
		System.out.print("제목:");
		String title = sc.nextLine();
		System.out.print("내용:");
		String contents = sc.nextLine();
		//생성자 update // new 
		Board board = boardList.get(boardTmp);
		board.update(title, contents);
		return true;
	}
	
	private static boolean delete(ArrayList<Board> boardList) {
		System.out.println("게시글을 삭제 합니다.");
		System.out.print("삭제 할 게시물 번호를 입력하세요>>");
		int boardNum = sc.nextInt();
		boardList.remove(boardTmp);
		return true;
	}

	private static void select(ArrayList<Board> boardList) {
		int boardNum;
		for (Board board : boardList) {
			System.out.print("게시글번호: " + board.getBoardNum() + " ");
			System.out.println(board);
		}
	}

	private static boolean insert(ArrayList<Board> boardList, Scanner sc) {
		System.out.println("게시글을 작성 합니다.");
		sc.nextLine();
		System.out.print("제목:");
		String title = sc.nextLine();
		System.out.print("내용:");
		String contents = sc.nextLine();
		System.out.print("작성자:");
		String Writer = sc.next();

		if(!boardList.isEmpty()) {
			boardList.add(boardList.size()-1, new Board(title, contents, Writer));
		}else {
			boardList.add(new Board(title, contents, Writer));
		}
		
		

		System.out.println("게시글 작성에 성공 하였습니다.");

		return true;

	}

}
