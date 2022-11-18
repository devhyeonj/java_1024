package day20;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.function.Predicate;

//강사님 코드
public class BookManagerMain2 {
	
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		//반복
		int menu = 0;
		
		ArrayList<Book> list = new ArrayList<Book>();
		do {
			//메뉴를 출력
			printMenu();
			//메뉴를 선택
			menu = sc.nextInt();
			printBar();
			//선택한 메뉴에 따른 기능 실행
			runMenu(list,menu);
		}while(menu != 3);
	}
	private static void runMenu(ArrayList<Book> list, int menu) {
		switch(menu) {
		//선택 메뉴가 1번이면 도서 추가
		case 1:
			//추가할 도서 정보를 입력
			Book book = createBook();
			//생성된 도서 객체를 리스트에 추가
			if(!insertBook(list,book)) 
				System.out.println("이미 등록된 ISBN 번호 입니다.");
			else 
				System.out.println("도서 추가가 완료됐습니다.");
			break;
		//선택 메뉴가 2번이면 도서 조회
		case 2:
			/* - 도서 조회
			 * 	- 도서명으로 조회
			 *  - 저자로 조회
			 *  - 출판사로 조회
			 *  - 분류로 조회
			 */ 
			// 서브 메뉴 출력
			printsearchMenu();
			// 서브 메뉴 선택
			int subMenu = sc.nextInt(); // 반복문 영향이 없음
			runSerachMenu(list,subMenu);
			break;
		//선택 메뉴가 3번이면 프로그램 종료 출력
		case 3:
			System.out.println("프로그램 종료");
			break;
		//선택 메뉴가 1,2,3이 아니면 잘못된 메뉴라고 출력
		default:
			System.out.println("잘못된 메뉴");
		}
		sc.close();
	}
	private static void runSerachMenu(ArrayList<Book> list, int subMenu) {
		String title, author,publisher,genre;
		
		int count=0;
		//선택한 서브 메뉴 실행
		switch (subMenu) {
		// 서브메뉴가 1이면 도서명으로 조회
		case 1:
			System.out.println("도서명 : ");
			sc.nextLine();
			title = sc.nextLine();
			printBookList(list, (b) -> b.getTitle().contains(title.trim()));
			break;
		// 서브메뉴가 2이면 저자로 조회
		case 2:
			System.out.println("저자 : ");
			sc.nextLine();
			author = sc.nextLine();
			printBookList(list, (b) -> b.getAuthor().contains(author.trim()));
			break;
		// 서브메뉴가 3이면 출판사로 조회
		case 3:
			System.out.println("출판사 : ");
			sc.nextLine();
			publisher = sc.nextLine();
			printBookList(list, (b) -> b.getPublisher().contains(publisher.trim()));
			break;
		// 서브메뉴가 4이면 장르로 조회
		case 4:
			System.out.println("장르 : ");
			sc.nextLine();
			genre = sc.nextLine();
			printBookList(list, (b) -> b.getGenre().contains(genre.trim()));
			break;
		// 서브메뉴가 5이면 조회 취소
		case 5:
			System.out.println("조회를 취소 했습니다");
			break;
		// 잘못된 서브메뉴이면 잘못됐다고 출력
		default:
			System.out.println("잘못된 서브 메뉴 입니다.");
		}
	}
	private static void printsearchMenu() {
		System.out.println("====조회 메뉴=====");
		System.out.println("1. 도서명으로 조회");
		System.out.println("2. 저자로 조회");
		System.out.println("3. 출판사로 조회");
		System.out.println("4. 장르로 조회");
		System.out.println("5. 취소");
		printBar();
		System.out.print("조회 방법 선택 :");
	}
	public static void printBar() {
		System.out.println("=============");
	}
	
	public static void printMenu() {
		System.out.println("=====메뉴=====");
		System.out.println("1. 도서 추가");
		System.out.println("2. 도서 조회");
		System.out.println("3. 종료");
		printBar();
		System.out.println("메뉴 선택:");
	}
	
	public static Book createBook () {
		sc.nextLine();
		System.out.print("도서명:");
		String title = sc.nextLine();
		System.out.print("저자:");
		String author = sc.nextLine();
		System.out.print("가격:");
		int price = sc.nextInt();
		sc.nextLine();
		System.out.print("출판사:");
		String publisher = sc.nextLine();
		System.out.print("장르:");
		String genre = sc.nextLine();
		System.out.print("ISBN:");
		String isbn = sc.next();
		
		//도서 목록에 새 도서를 추가
		//위에서 입력받은 도서 정보를 이용하여 도서 객체
		return new Book(title, author, publisher, genre, isbn, price);
	}
	
	public static boolean insertBook(ArrayList<Book> list,Book book) {
		if(list.contains(book)) {
			return false;
		}
		list.add(book);								// 문자열은 compareTo로 정렬 할 수 있다
		Collections.sort(list,(o1,o2)-> o1.getIsbn().compareTo(o2.getIsbn()));
		return true; // list는 중복을 허용하기때문에 무조건 true
	}
	
	public static void printBookList(ArrayList<Book> list, Predicate<Book> p) {
		int count =0;
		for(Book tmp : list) {			// 앞뒤 공백 제거 //공백하면 전체검색 하게하려고
			if(p.test(tmp)) {
				System.out.println(tmp);
				count++;
			}
		}
		if(count == 0) {
			System.out.println("검색 결과가 없습니다.");
		}
	}
}
