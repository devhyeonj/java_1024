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
	 * - 회원가입
	 * - 처음 가입한 회원이 관리자, 그이 회원인 일반 회원
	 * - 로그인
	 * - 게시글 등록/수정/삭제 => 회원만 가능
	 * 카테고리 관리(공지,자유)
	 * 카테고리 추가/수정/삭제(관리자만 가능) 중복체크하기
	 * 
	 * */
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		String fileName1 = "member.txt";
		String fileName2 = "board.txt";
		int menu = -1;
		ArrayList<Member> memberList = new ArrayList<>();
		ArrayList<Board> boardList = new ArrayList<>();
		load(memberList,fileName1);
		load(boardList,fileName2);
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
		save(memberList,fileName1);
		save(boardList,fileName2);
		
	}
	//로그인 안한사람이 보이는 메뉴
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
		
		ArrayList<Category> categoryList = new ArrayList<Category>();
		ArrayList<Notice> noticeList = new ArrayList<Notice>();
	
		int menu = -1;
		do {
			try {
				boardMembersubMenu();
				//로그인 한 아이디가 관리자 아이디면 관리자 메뉴도 보이게 설정
				if(loginMember.getMembership().equals(Membership.MANAGER)) {
					boardManagersubMenu();
				}
				menu = sc.nextInt();
				runboardSubMenu(menu,loginMember, boardList,categoryList,noticeList);
			}catch (InputMismatchException e) {
				sc.nextLine(); // 잘못 입력한거 날려버리기
				System.out.println("정수로 다시 입력 해주세요!!");
				System.out.print("메뉴 선택>>");
				menu = sc.nextInt();
			}catch(RuntimeException e) {
				System.out.println(e.getMessage());
			}
		}while(menu !=0);
		
	
	}



	private static void runboardSubMenu(int menu, Member loginMember, ArrayList<Board> boardList, ArrayList<Category> categoryList, ArrayList<Notice> noticeList) {
		switch (menu) {
		case 1: //게시글 작성
			insert(loginMember,boardList,categoryList);
			break;
		case 2://게시물 목록
			boardAll(boardList,loginMember);
			break;
		case 0:
			break;
		default:
		}
	}



	private static void insertNotice(ArrayList<Notice> noticeList) {
		if(noticeList == null) {
			System.out.println("공지 리스트가 생성되지 않았습니다.");
			return ;
		}
		System.out.println("공지사항을 작성합니다.");
		System.out.print("제목:");
		String title = sc.nextLine();
		System.out.print("내용:");
		String content = sc.nextLine();
		
		noticeList.add(new Notice(title, content));
		System.out.println("공지를 작성하였습니다.");
	}
	private static void insertCategory(ArrayList<Category> categoryList) {
		if(categoryList == null) {
			System.out.println("카테고리 리스트가 생성되지 않았습니다.");
			return ;
		}
		System.out.print("추가할 카테고리 이름을 입력 해주세요>>");
		String categoryName = sc.next();
		
		
		//카테고리 중복 체크
		Category categoryTmp = new Category(categoryName);
		if(categoryList.indexOf(categoryTmp) != -1) { 
			System.out.println("카테고리를 추가하지 못했습니다. 중복된 카테고리가 있습니다.");
			return ;
		}
		categoryList.add(categoryTmp);
		
		System.out.println("카테고리 추가에 성공 하셨습니다.");
		
		//확인용
		for (Category c : categoryList) {
			System.out.println(c);
		}
	}



	private static void boardAll(ArrayList<Board> boardList, Member loginMember) {
		if(boardList.size() == 0 || boardList == null) {
			throw new RuntimeException("게시글이 없습니다.");
		}
		for (Board board : boardList) {
			System.out.println("["+board.getNum()+"] 제목:"+board.getTitle()+" 글쓴이:"+board.getLoginId());
		}
		detailBoard(boardList,loginMember);
		
	}



	private static void detailBoard(ArrayList<Board> boardList, Member loginMember) {
		System.out.print("상세보기 할 글번호를 입력하세요.");
		int num = sc.nextInt()-1;
		boardList.get(num).updateViews();
		System.out.println(boardList.get(num)); //상세보기
		if(boardList.get(num).getLoginId().equals(loginMember.getId()) || loginMember.getMembership().equals(Membership.MANAGER)) {
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


	// 회원 서브 메뉴
	private static void boardMembersubMenu() {
		System.out.println("===============");
		System.out.println("1. 게시글 작성");
		System.out.println("2. 게시글 목록");
		System.out.println("0. 돌아가기");
		System.out.println("===============");
		System.out.print("메뉴 선택>>");
	}
	// 관리자 서브 메뉴
	private static void boardManagersubMenu() {
		System.out.println("===============");
		System.out.println("3. 카테고리 관리");
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
		Board tmp = new Board(title, contents, loginMember.getId());
		for (int i = 0; i < categoryList.size(); i++) {
			System.out.println((i+1)+""+categoryList.get(i));
		}
		System.out.print("입력할 카데고리를 선택해주세요>>");
		int categoryNum = sc.nextInt()-1;
		tmp.addCategory(categoryList.get(categoryNum));
		System.out.println("게시글 작성에 성공 하셨습니다.");
		boardList.add(tmp);
	}

	// 카테고리가 같은 게시판을 모아서 정수형 리스트에 저장하여 리턴하는 메소드
	
	
	
	
	
	
	
	
	
	
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
		if(memberList == null ) 
			throw new RuntimeException("예외 발생 : 멤버를 관리할 리스트가 생성 되지 않았습니다.");
		
		System.out.println("회원가입을 시작 합니다.");
		System.out.print("아이디:");String id = sc.next();
		System.out.print("비밀번호:");String pw = sc.next();
		System.out.print("닉네임:");String nickname = sc.next();
		Member member = new Member(id, pw, nickname);
		
		// Member 클래스에 equals를 @Data를 이용했기 때문에,
		// 필드 모두 같아야 있다고 판단하기 때문에 eqauls 오버라이딩이 필요함
		if(memberList.indexOf(member) != -1) { 
			System.out.println("회원 정보를 추가하지 못했습니다.");
			return ;
		}
		//첫번째 가입자는 관리자
		if(memberList.size() == 0) {
			member.setMemberShip(Membership.MANAGER);
		//그이상부터는 회원
		}else {
			member.setMemberShip(Membership.MEMBER);
		}
		memberList.add(member);
		System.out.println("회원 정보를 추가했습니다.");
		
		//확인용
		for (Member m : memberList) {
			System.out.println(m);
		}
	}
	
	private static Member login(ArrayList<Member> memberList) {
		if(memberList == null) 
			throw new RuntimeException("예외 발생 : 멤버를 관리할 리스트가 생성 되지 않았습니다.");
		System.out.println("로그인 해주세요.");
		System.out.print("아이디:"); String id = sc.next();
		System.out.print("비밀번호:"); String pw = sc.next();
		
		Member loginMember = search(memberList, (m) -> m.getId().equals(id) && m.getPassword().equals(pw));
		
		if(loginMember == null) {
			System.out.println("로그인에 실패 하였습니다.");
		}
		System.out.println("로그인에 성공 하였습니다.");
		return loginMember; // 로그인에 성공하면 로그인한 아이디 비밀번호 정보를 가져간다.
		
	}
}
