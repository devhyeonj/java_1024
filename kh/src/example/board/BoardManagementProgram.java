package example.board;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class BoardManagementProgram {
	/*주말 과제3 게시물 관리 프로그램
	 * - 회원가입 
	 * - 처음 가입한 회원이 관리자, 그외 회원인 일반 회원 
	 * - 로그인 -
	 * - 게시글 등록/수정/삭제 => 회원만 가능
	 * 카테고리 관리(공지,자유)
	 * 카테고리 추가/수정/삭제(관리자만 가능) 중복체크하기
	 *  - 카테고리를 변경하면 해당 카테고리에 있는 모든 게시글 카테고리를 같이 수정 
	 *  - 카테고리 삭제 시, 해당 카테고리에 등록된 게시글들이 있으면 '등록된 게시글들과 함께 삭제하겠습니까?'라고 메세지를 출력 한 후, y를 선택하면 같이 삭제
	 * - 댓글 확인 댓글 작성
	 * */
	private static Scanner sc = new Scanner(System.in);
	private static List<Member> memberList = new ArrayList<>();
	private static List<Board> boardList = new ArrayList<>();
	private static List<Category> categoryList = new ArrayList<>();
	private static Member user;
	private static ArrayList<Integer> indexList = new ArrayList<>();
	
	public static void main(String[] args) {
		
		int menu = -1;
		load("member.txt", memberList);
		load("category.txt", categoryList);
		loadBoard("board.txt");
		do {
			printMainMenu();
			try {
				menu = sc.nextInt();
				sc.nextLine();
				runMainMenu(menu);
			}catch (InputMismatchException e) {
				sc.nextLine();
				System.out.println("정수로 다시 입력 해주세요!!");
			}catch (Exception e) {
				printStr("예외 발생" + e.getMessage());
				e.printStackTrace();
			}
		}while(menu != 5);
		save("member.txt", memberList);
		save("category.txt", categoryList);
		saveBoard("board.txt");
	}
	
	private static void runMainMenu(int menu) {
		int subMenu = -1;
		switch (menu) {
		case 1:
			if(checkLogin(true)) 
				return;
			printSubMenu(1);
			subMenu = sc.nextInt();
			runMember(subMenu);
			break;
		case 2:
			if(checkLogin(false))
				return ;
			printSubMenu(2);
			subMenu = sc.nextInt();
			runBoard(subMenu);
			break;
		case 3:
			if(!isAdmin())
				return ;
			printSubMenu(3);
			subMenu = sc.nextInt();
			runCategory(subMenu);
			break;
		case 4:
			printSubMenu(4);
			subMenu = sc.nextInt();
			//runComment(subMenu);
			break;
		case 5:
			break;
		default:
			throw new RuntimeException("잘못된 메뉴를 입력 하셨습니다.");
		}
	}
	
	private static boolean checkLogin(boolean res) {
		if(user != null && res) {
			printStr("로그인한 사용자는 해당 기능을 이용할 수 없습니다.");
			return true;
		}
		if(user == null && !res) {
			printStr("로그인 하지 않은 사용자는 해당 기능을 이용할 수 없습니다.");
			return true;
		}
		return false;
	}

	private static void runBoard(int subMenu) {
		switch (subMenu) {
		case 1://게시글 등록
			insertBoard();
			break;
		case 2://게시글 수정
			updateBoard();
			break;
		case 3://게시글 삭제
			deleteBoard();
			break;
		case 4://게시글 목록 -> 서브메뉴
			printBoard();
			break;
		case 0:
			break;
		}
	}

	private static void printBoard() {
		
	}

	private static void deleteBoard() {
		System.out.println("게시글 삭제");
	}

	private static void updateBoard() {
		System.out.println("게시글 수정");
	}

	private static void insertBoard() {
		System.out.println("게시글 등록");
		System.out.println("카테고리명을 입력해주세요.");
		for (Category category : categoryList) {
			System.out.println(category);
		}
		sc.nextLine();
		System.out.print("카테고리:");String categoryName =sc.nextLine();
		int index = categoryList.indexOf(new Category(categoryName,true));
		if(index == -1) {
			System.out.println("해당 카테고리가 없습니다.");
			return;
		}
		System.out.print("제목:");String title = sc.nextLine();
		System.out.print("내용:");String contents = sc.nextLine();
		Board board = new Board(title, contents, user.getNickname());
		board.setCategory(new Category(categoryName,true));
		boardList.add(board);
		printStr("게시글 등록이 완료됐습니다.");
		
		//확인용
		boardList.forEach(b -> b.print());
	}

	private static void runComment(int subMenu) {
		
	}

	private static void runCategory(int subMenu) {
		switch (subMenu) {
		case 1://등록
			insertCategory();
			break;
		case 2://수정
			updateCategory();
			break;
		case 3://삭제
			deleteCategory();
			break;
		case 4://목록
			break;
		default:
		}
	}

	private static void deleteCategory() {
		for (Category category : categoryList) {
			System.out.println(category);
		}
		sc.nextLine();
		System.out.print("삭제 하고 싶은 카테고리명 : ");
		
		String category = sc.nextLine();
		int index = categoryList.indexOf(new Category(category,false));
		Category tmp = categoryList.get(index);
		
		indexList = search(boardList, (b) -> b.getCategory().getCategoryName().equals(category));
		
		System.out.println("등록된 게시글들과 함께 삭제하겠습니까?");
		char yn = sc.next().charAt(0);
		
		int i;
		if(yn == 'y') {
			categoryList.remove(tmp);
			boardList.removeIf(b -> b.getCategory().getCategoryName().equals(category));
		}else {// 'n'
			categoryList.remove(tmp);
		}
		
		System.out.println("삭제 했습니다.");
		
		//확인용
		boardList.forEach(b -> b.print());
		
	}

	private static void updateCategory() {
		for (Category category : categoryList) {
			System.out.println(category);
		}
		sc.nextLine();
		System.out.print("수정 하고 싶은 카테고리명 : ");
		String category = sc.nextLine();
		int index = categoryList.indexOf(new Category(category,false));
		Category tmp = categoryList.get(index);
		
		indexList = search(boardList, (b) -> b.getCategory().getCategoryName().equals(category));
		
		System.out.print("새로운 카테고리명:");String newCategory = sc.nextLine();
		//카테고리를 변경하면 해당 카테고리에 있는 모든 게시글 카테고리를 같이 수정
		tmp.setCategoryName(newCategory);
		for (int j = 0; j < indexList.size(); j++) {
			boardList.get(j).getCategory().update(newCategory);
		}
		System.out.println("카테고리 수정 완료했습니다.");
		
		//확인용
		indexList.forEach(i -> boardList.get(i).print());
		
		
	}
	
	//해당 카테고리에 있는 모든 게시글 찾아서 정수형 리스트에 번지를 저장하는 메소드
	private static <T> ArrayList<Integer> search(List<T> list,Predicate<T> p) {
		for (int i = 0; i < list.size(); i++) {
			if(p.test(list.get(i))) {
				indexList.add(i);
			}
		}
		return indexList;
		
	}

	private static boolean isAdmin() {
		if(user == null || user.getAuthority() != Authority.ADMIN) {
			printStr("관리자가 아닙니다. 해당 기능을 이용할 수 없습니다.");
			return false;
		}
		return true;
	}

	private static void insertCategory() {
		sc.nextLine();
		System.out.print("카테고리명 : ");
		String category = sc.nextLine();
		
		Category tmp = new Category(category,true);
		//카테고리 중복확인
		int index = categoryList.indexOf(tmp);
		if(index != -1) {
			printStr("이미 있는 카테고리 입니다.");
			return ;
		}
		categoryList.add(tmp);
		printStr("새 카테고리를 추가했습니다.");
		
		//확인용
		categoryList.forEach(c -> System.out.println(c));
	}

	private static void runMember(int subMenu) {
		switch (subMenu) {
		//로그인 체크
		case 1:
			join();
			break;
		case 2:
			login();
			break;
		case 0:
			break;
		}
	}

	private static void login() {
		Member tmp = inputIdPw();
		int index = memberList.indexOf(tmp);
		if(index == -1) {
			System.out.println("로그인에 실패 하였습니다.");
			return ;
		}
		user = memberList.get(index);
		System.out.println("로그인에 성공 하였습니다.");
		System.out.println("로그인정보 : "  + user.print());
	}

	private static void join() {
		System.out.println("회원가입");
		Member idPw = inputIdPw();
		System.out.print("닉네임 : ");String nickName = sc.next();
		
		Authority authority = memberList.size() == 0? Authority.ADMIN : Authority.MEMBER;
		
		Member member = new Member(idPw.getId(), idPw.getPassword(), nickName);
		member.setAuthority(authority);
		memberList.add(member);
		
		System.out.println("회원가입 했습니다.");
		
		//확인용
		memberList.forEach((m)-> m.print());
	}
	
	

	private static Member inputIdPw() {
		System.out.print("아이디 : ");String id = sc.next();
		System.out.print("비밀번호 : ");String pw = sc.next();
		return new Member(id, pw);
	}

	private static void printDetailMenu() {
		System.out.println("====게시글 목록메뉴====");
		System.out.println("1. 게시글 목록 확인");
		System.out.println("2. 게시글 검색");
		System.out.println("3. 게시글 확인");
		System.out.println("4. 이전");
		printBar();
		System.out.print("메뉴 선택 : ");
	}

	private static void printSubMenu(int num) {
		switch (num) {
		case 1:
			System.out.println("====회원관리메뉴=====");
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.println("0. 이전");
			printBar();
			break;
		case 2:
			System.out.println("====게시글관리메뉴=====");
			System.out.println("1. 게시글 등록");
			System.out.println("2. 게시글 수정");
			System.out.println("3. 게시글 삭제");
			System.out.println("4. 게시글 목록"); 
			System.out.println("0. 이전");
			printBar();
			break;
		case 3:
			System.out.println("====카테고리관리메뉴=====");
			System.out.println("1. 카테고리 등록");
			System.out.println("2. 카테고리 수정");
			System.out.println("3. 카테고리 삭제");
			System.out.println("4. 카테고리 목록");
			System.out.println("0. 이전");
			printBar();
			break;
		case 4:
			System.out.println("====댓글관리메뉴=====");
			System.out.println("1. 댓글 목록");
			System.out.println("2. 댓글 작성");
			System.out.println("0. 이전");
			printBar();
			break;
		case 0:
			break;
		default:
			System.out.println("잘못된 메뉴 선택");
		}
		System.out.print("메뉴선택>>");
	}

	private static void printMainMenu() {
		System.out.println("========메뉴========");
		System.out.println("1. 회원 관리");
		System.out.println("2. 게시글 관리");
		System.out.println("3. 카테고리 관리");
		System.out.println("4. 댓글 관리");
		System.out.println("5. 프로그램 종료");
		printBar();
		System.out.print("메뉴 선택 : ");
	}

	private static void saveBoard(String filename) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
			oos.writeInt(Board.getCount()); // 지금까지 게시글 번호가 몇번까지 만들어져있는지 확인함
			for (Board board : boardList) {
				oos.writeObject(board);
			}
			printStr("저장 완료");
		} catch (IOException e) {
			printStr("저장 실패");
		}
	}
	
	private static void loadBoard(String filename) {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
			int count = ois.readInt();
			Board.setCount(count);
			while(true) {
				Board board = (Board) ois.readObject();
				boardList.add(board);
			}
		} catch (ClassNotFoundException e) {
			printStr("불러오기 실패");
		} catch (EOFException e) {
			printStr("불러오기 성공");
		} catch (IOException e) {
			printStr("불러오기 실패");
		}
	}

	private static <T> void save(String filename, List<T> list) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
			for (T tmp : list) {
				oos.writeObject(tmp);
			}
			printStr("저장 완료");
		} catch (IOException e) {
			printStr("저장 실패");
		}
	}

	private static <T> void load(String filename, List<T> list) {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
			while (true) {
				T obj = (T) ois.readObject();
				list.add(obj);
			}
		} catch (ClassNotFoundException e) {
			printStr("불러오기 실패");
		} catch (EOFException e) {
			printStr("불러오기 성공");
		} catch (IOException e) {
			printStr("불러오기 실패");
		}
	}
	private static void printStr(String str) {
		System.out.println(str);
		printBar();
	}

	private static void printBar() {
		System.out.println("===================");
	}
}
