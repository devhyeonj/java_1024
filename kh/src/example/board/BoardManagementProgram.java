package example.board;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.function.Predicate;

public class BoardManagementProgram {
	/*주말 과제3 게시물 관리 프로그램
	 * - 게시글 종류는 자유 , 공지는 기본
	 * - 게시글 종류는 추가 가능
	 * - 게시글은 회원만 작성 가능
	 * - 회원가입, 로그인 기능 필요 
	 * - 비회원은 작성, 수정 불가능 , 조회 가능
	 * - 회원 정보와 게시글을 파일에 저장하여 관리 
	 * */
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		String fileName = "member.txt";
		int menu = -1;
		ArrayList<Member> memberList = new ArrayList<>();
		ArrayList<Board> boardList = new ArrayList<>();
		load(memberList,fileName);
		do {
			printMainMenu();
			try {
				menu = sc.nextInt();
			}catch (InputMismatchException e) {
				sc.nextLine(); // 잘못 입력한거 날려버리기
				System.out.println("정수로 다시 입력 해주세요!!");
				System.out.print("메뉴 선택>>");
				menu = sc.nextInt();
			}
			runMainMenu(memberList,menu, boardList);
		}while(menu != 4);
		save(memberList,fileName);
	}



	private static void runMainMenu(ArrayList<Member> memberList, int menu, ArrayList<Board> boardList) {
		Member loginMember = null;
		switch (menu) {
		case 1://회원가입
			join(memberList);
			break;
		case 2://로그인
			loginMember = login(memberList);
			if(loginMember != null)
				board(loginMember, boardList); // 로그인에 성공하면 게시판 메소드로 이동
			break;
		case 3://게시글 목록
			boardAll(boardList, loginMember);
		default:
		}
	}
								//로그인 한 객체
	private static void board(Member loginMember, ArrayList<Board> boardList) {
		String fileName = "board.txt";
		ArrayList<Category> categoryList = new ArrayList<Category>();
		load(boardList,fileName);
		int menu = -1;
		do {
			try {
				boardsubMenu();
				menu = sc.nextInt();
				runboardSubMenu(menu,loginMember, boardList,categoryList);
			}catch (InputMismatchException e) {
				sc.nextLine(); // 잘못 입력한거 날려버리기
				System.out.println("정수로 다시 입력 해주세요!!");
				System.out.print("메뉴 선택>>");
				menu = sc.nextInt();
			}catch(RuntimeException e) {
				System.out.println(e.getMessage());
			}
		}while(menu !=0);
		save(boardList,fileName);
	
	}



	private static void runboardSubMenu(int menu, Member loginMember, ArrayList<Board> boardList, ArrayList<Category> categoryList) {
		switch (menu) {
		case 1: //게시글 작성
			insert(loginMember,boardList,categoryList);
			break;
		case 2://게시물 목록
			boardAll(boardList,loginMember);
			break;
		case 0:
			break;
		case 3://카테고리 
			
			insertCategory(categoryList);
			break;
		default:
		}
	}



	private static void insertCategory(ArrayList<Category> categoryList) {
		if(categoryList == null) {
			System.out.println("카테고리 리스트가 생성되지 않았습니다.");
			return ;
		}
		System.out.print("추가할 카테고리 이름을 입력 해주세요>>");
		String categoryName = sc.next();
		categoryList.add(new Category(categoryName));
		System.out.println("카테고리 추가에 성공 하셨습니다.");
		for (Category c : categoryList) {
			System.out.println(c);
		}
	}



	private static void boardAll(ArrayList<Board> boardList, Member loginMember) {
		if(boardList.size() == 0 || boardList == null) {
			throw new RuntimeException("게시글이 없습니다.");
		}
		for (Board board : boardList) {
			System.out.println("["+board.getNum()+"] 제목:"+board.getTitle()+" 글쓴이:"+board.getMember().getNickname());
		}
		detailBoard(boardList,loginMember);
		
	}



	private static void detailBoard(ArrayList<Board> boardList, Member loginMember) {
		System.out.print("상세보기 할 글번호를 입력하세요.");
		int num = sc.nextInt()-1;
		boardList.get(num).updateViews();
		System.out.println(boardList.get(num)); //상세보기
		if(boardList.get(num).getMember().equals(loginMember) || loginMember.getMembership().equals(Membership.MANAGER)) {
			// 지금 로그인한 멤버와 글쓴이랑 똑같은지 아니면 관리자 아이디인가?
			System.out.println("1.수정 2.삭제 3.뒤로가기" );
			System.out.print("메뉴선택>>");
			int select =sc.nextInt();
			switch (select) {
			case 1:
				updateBoard(boardList,num);
				break;
			case 2:
				deleteBoard(boardList,num);
				break;
			case 3:
				break;
			default:
				break;
			}
		}
		
	}



	private static void deleteBoard(ArrayList<Board> boardList, int num) {
		System.out.println("게시글 삭제");
		boardList.remove(num);
		System.out.println("게시글 삭제에 성공하였습니다.");
	}



	private static void updateBoard(ArrayList<Board> boardList, int num) {
		System.out.println("게시글 수정");
		sc.nextLine();
		System.out.print("제목:");
		String title = sc.nextLine();
		System.out.print("내용:");
		String contents = sc.nextLine();
		boardList.get(num).update(title, contents);
		System.out.println("게시글 수정에 성공하였습니다.");
	}



	private static void boardsubMenu() {
		System.out.println("===============");
		System.out.println("1. 게시글 작성");
		System.out.println("2. 게시글 목록");
		System.out.println("3. 카테고리 만들기");
		System.out.println("0. 돌아가기");
		System.out.println("===============");
		System.out.print("메뉴 선택>>");
	}



	private static void insert(Member loginMember, ArrayList<Board> boardList, ArrayList<Category> categoryList) {
		if(loginMember == null) {
			System.out.println("로그인 정보가 없습니다.");
		}
		System.out.println("게시글을 작성 합니다.");
		sc.nextLine();
		System.out.print("제목:");String title = sc.nextLine();
		System.out.print("내용:");String contents = sc.nextLine();
		Board tmp = new Board(title, contents, loginMember);
		for (int i = 0; i < categoryList.size(); i++) {
			System.out.println((i+1)+""+categoryList.get(i));
		}
		System.out.print("입력할 카데고리를 선택해주세요>>");
		int categoryNum = sc.nextInt()-1;
		tmp.addCategory(categoryList.get(categoryNum));
		System.out.println("게시글 작성에 성공 하셨습니다.");
		boardList.add(tmp);
	}



	private static Member login(ArrayList<Member> memberList) {
		if(memberList == null) 
			throw new RuntimeException("예외 발생 : 멤버를 관리할 리스트가 생성 되지 않았습니다.");
		System.out.println("로그인 해주세요.");
		System.out.print("아이디:"); String id = sc.next();
		System.out.print("비밀번호:"); String pw = sc.next();
		
		Member loginMember = search(memberList, (m) -> m.getId().equals(id) && m.getPassword().equals(pw));
		String str = null;
		// 입력한 아이디 비밀번호가 일치하는지?
		for (int i = 0; i < memberList.size(); i++) {
			if(memberList.get(i).getId().equals(id) && memberList.get(i).getPassword().equals(pw)) {
				str = "로그인에 성공!!";
			}else {
				str = "로그인에 실패!!";
			}
		}
		System.out.println(str);
		return loginMember; // 로그인에 성공하면 로그인한 아이디 비밀번호 정보를 가져간다.
		
	}


	private static <T> T search(ArrayList<T> list,Predicate<T> p) {
		for (int i = 0; i < list.size(); i++) {
			if(p.test(list.get(i))) {
				return list.get(i);
			}
		}
		return null;
	}



	private static <T> void save(ArrayList<T> list, String fileName) {
		if(list == null) 
			throw new RuntimeException("예외 발생 : 리스트가 생성 되지 않았습니다.");
	
		try(ObjectOutputStream oos
			= new ObjectOutputStream(new FileOutputStream(fileName))) {
			for (T t : list) {
				oos.writeObject(t);
			}
			System.out.println("저장하기 완료");
		} catch (FileNotFoundException e) {
			System.out.println(fileName + "을 생성할 수 없어서 저장에 실패했습니다.");
		} catch (IOException e) {
			System.out.println("저장에 실패했습니다.");
		}
	
	}
	
	private static <T> void load(ArrayList<T> list, String fileName) {
		if(list == null) 
			throw new RuntimeException("예외 발생 : 리스트가 생성 되지 않았습니다.");
	
		try(ObjectInputStream ois
			= new ObjectInputStream(new FileInputStream(fileName))) {
			while(true) {
				T t = (T) ois.readObject();
				list.add(t);
			}
		} catch (FileNotFoundException e) {
			System.out.println(fileName + "이 없어서 불러오기에 실패했습니다.");
		} catch (EOFException e) {
			System.out.println("불러오기 완료.");
		} catch (Exception e) {
			System.out.println("불러오기 실패.");
		}
	}
	
	
	private static void printMainMenu() {
		System.out.println("===============");
		System.out.println("1. 회원가입");
		System.out.println("2. 로그인");
		System.out.println("3. 게시글 목록");
		System.out.println("4. 프로그램 종료");
		System.out.println("===============");
		System.out.print("메뉴 선택>>");
	}
	
	private static void join(ArrayList<Member> memberList) {
		if(memberList == null) 
			throw new RuntimeException("예외 발생 : 멤버를 관리할 리스트가 생성 되지 않았습니다.");
		
		System.out.println("회원가입을 시작 합니다.");
		System.out.print("아이디:");String id = sc.next();
		System.out.print("비밀번호:");String pw = sc.next();
		System.out.print("닉네임:");String nickname = sc.next();
		Member member = new Member(id, pw, nickname);
		if(memberList.indexOf(member) != -1) { 
			System.out.println("회원 정보를 추가하지 못했습니다.");
			return ;
		}
		memberList.add(member);
		System.out.println("회원 정보를 추가했습니다.");
	}
}
