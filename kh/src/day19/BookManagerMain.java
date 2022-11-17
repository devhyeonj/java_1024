package day19;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.function.Predicate;

import lombok.Data;

@Data
class Book {
	private String title;
	private String author;
	private int price;
	private String company;
	private String type;
	private int isbn;
	
	public Book(String title, String author, int price, String company, String type, int isbn) {
		this.title = title;
		this.author = author;
		this.price = price;
		this.company = company;
		this.type = type;
		this.isbn = isbn;
	}
}

public class BookManagerMain {
	
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		/*도서 관리 프로그램을 작성하세요
		 * 도서 정보
		 * - 도서명, 저자(여러명,엮은이,옮긴이 다 포함),가격,출판사,분류, ISBN
		 * 기능
		 * - 도서 추가
		 * - ISBN 으로 정렬(1,2,3,4)
		 * - 도서 조회
		 * 	- 도서명으로 조회
		 *  - 저자로 조회
		 *  - 출판사로 조회
		 *  - 분류로 조회
		 */
		ArrayList<Book> list = new ArrayList<Book>();
		int menu;
		do {
			printMenu();
			menu = sc.nextInt();
			runMenu(list,menu,sc);
		}while(true);
		
		
		
		
	
		
	}
	private static void runMenu(ArrayList<Book> list, int menu,Scanner sc) {
		switch (menu) {
		case 1: // 도서추가
			Book insertTmp = insertBook(list,sc);
			if(insertTmp == null) {
				System.out.println("도서 등록에 실패하였습니다.");
			}
			list.add(insertTmp);
			System.out.println("도서 등록에 성공하였습니다.");
			for (Book book : list) {
				System.out.println(book);
			}
			break;
		case 2: // 조회 -> 서브메뉴 메소드로 이동
			subMenu();
			int subMenu = sc.nextInt();
			subMenuRun(list,subMenu,sc);
			break;
		}
	}
	
	
	private static void subMenuRun(ArrayList<Book> list, int subMenu,Scanner sc) {
		switch (subMenu) {
		case 1: //도서명으로 조회
			sc.nextLine();
			System.out.print("도서명:");
			String title = sc.nextLine();
			Collections.sort(list, (a,b)-> a.getIsbn()-b.getIsbn());
			detailSelect(list,(b) -> b.getTitle().equals(title));
			break;
		case 2: //저자로 조회
			sc.nextLine();
			System.out.print("저자:");
			String author = sc.nextLine();
			Collections.sort(list, (a,b)-> a.getIsbn()-b.getIsbn());
			detailSelect(list,(b) -> b.getAuthor().equals(author));
			break;
		case 3: //출판사로 조회
			sc.nextLine();
			System.out.print("출판사:");
			String company = sc.nextLine();
			Collections.sort(list, (a,b)-> a.getIsbn()-b.getIsbn());
			detailSelect(list,(b) -> b.getCompany().equals(company));
			break;
		case 4: //분류로 조회
			sc.nextLine();
			System.out.print("분류:");
			String type = sc.nextLine();
			Collections.sort(list, (a,b)-> a.getIsbn()-b.getIsbn());
			detailSelect(list,(b) -> b.getType().equals(type));
			break;
		default:
		}
	}
	private static void detailSelect(ArrayList<Book> list,Predicate<Book> b) {
		for (Book tmp : list) {
			if(b.test(tmp)) {
				System.out.println(tmp);
			}
		}
	}
	private static Book insertBook(ArrayList<Book> list,Scanner sc) {
		sc.nextLine();
		System.out.print("도서명:");
		String title = sc.nextLine();
		System.out.print("저자:");
		String author = sc.next();
		System.out.print("가격:");
		int price = sc.nextInt();
		sc.nextLine();
		System.out.print("출판사:");
		String company = sc.nextLine();
		System.out.print("분류:");
		String type = sc.nextLine();
		System.out.print("ISBN:");
		int isbn = sc.nextInt();
		return new Book(title, author, price, company, type, isbn);
		
		
	}
	private static void subMenu() {
		System.out.println("1. 도서명으로 조회");
		System.out.println("2. 저자로 조회");
		System.out.println("3. 출판사로 조회");
		System.out.println("4. 분류로 조회");
	}
	public static void printMenu() {
		System.out.println("도서 관리 프로그램");
		System.out.println("1. 도서 추가");
		System.out.println("2. 도서 조회");
	}
	
}
