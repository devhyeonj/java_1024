package day20;

import java.util.ArrayList;
import java.util.Scanner;

//강사님 코드
public class BookManagerMain {

	public static void main(String[] args) {
		//반복
		int menu = 0;
		Scanner sc = new Scanner(System.in);
		ArrayList<Book> list = new ArrayList<Book>();
		do {
			//메뉴를 출력
			System.out.println("=====메뉴=====");
			System.out.println("1. 도서 추가");
			System.out.println("2. 도서 조회");
			System.out.println("3. 종료");
			System.out.println("============");
			System.out.println("메뉴 선택:");
			//메뉴를 선택
			menu = sc.nextInt();
			System.out.println("============");
			String title, author,publisher,genre,isbn;
			int price;
			//선택한 메뉴에 따른 기능 실행
			switch(menu) {
			//선택 메뉴가 1번이면 도서 추가
			case 1:
				//추가할 도서 정보를 입력
				sc.nextLine();
				System.out.print("도서명:");
				title = sc.nextLine();
				System.out.print("저자:");
				author = sc.nextLine();
				System.out.print("가격:");
				price = sc.nextInt();
				sc.nextLine();
				System.out.print("출판사:");
				publisher = sc.nextLine();
				System.out.print("장르:");
				genre = sc.nextLine();
				System.out.print("ISBN:");
				isbn = sc.next();
				
				//도서 목록에 새 도서를 추가
				//위에서 입력받은 도서 정보를 이용하여 도서 객체
				Book book = new Book(title, author, publisher, genre, isbn, price);
				//생성된 도서 객체를 리스트에 추가
				//isbn 중복 체크해서 중복되면 건너뜀
				// 중복 : 리스트에 book객체가 포함되었다
				if(list.contains(book)) {
					System.out.println("이미 등록된 ISBN 번호입니다.");
					continue;
				}
				
				
				// 종복되지 않으면 추가
				list.add(book);
				System.out.println("도서 추가가 완료되었습니다.");
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
				System.out.println("====조회 메뉴=====");
				System.out.println("1. 도서명으로 조회");
				System.out.println("2. 저자로 조회");
				System.out.println("3. 출판사로 조회");
				System.out.println("4. 장르로 조회");
				System.out.println("5. 취소");
				System.out.println("=========");
				System.out.print("조회 방법 선택 :");
				// 서브 메뉴 선택
				int subMenu = sc.nextInt(); // 반복문 영향이 없음
				int count=0;
				//선택한 서브 메뉴 실행
				switch (subMenu) {
				// 서브메뉴가 1이면 도서명으로 조회
				case 1:
					System.out.println("도서명 : ");
					sc.nextLine();
					title = sc.nextLine();
					for(Book tmp : list) {			// 앞뒤 공백 제거 //공백하면 전체검색 하게하려고
						if(tmp.getTitle().contains(title.trim())) {
							System.out.println(tmp);
							count++;
						}
					}
					if(count == 0) {
						System.out.println("검색 결과가 없습니다.");
					}
					break;
				// 서브메뉴가 2이면 저자로 조회
				case 2:
					System.out.println("저자 : ");
					sc.nextLine();
					author = sc.nextLine();
					for(Book tmp : list) {			// 앞뒤 공백 제거 //공백하면 전체검색 하게하려고
						if(tmp.getAuthor().contains(author.trim())) {
							System.out.println(tmp);
							count++;
						}
					}
					if(count == 0) {
						System.out.println("검색 결과가 없습니다.");
					}
					break;
				// 서브메뉴가 3이면 출판사로 조회
				case 3:
					System.out.println("출판사 : ");
					sc.nextLine();
					publisher = sc.nextLine();
					for(Book tmp : list) {			// 앞뒤 공백 제거 //공백하면 전체검색 하게하려고
						if(tmp.getPublisher().contains(publisher.trim())) {
							System.out.println(tmp);
							count++;
						}
					}
					if(count == 0) {
						System.out.println("검색 결과가 없습니다.");
					}
					break;
				// 서브메뉴가 4이면 장르로 조회
				case 4:
					System.out.println("장르 : ");
					sc.nextLine();
					genre = sc.nextLine();
					for(Book tmp : list) {			// 앞뒤 공백 제거 //공백하면 전체검색 하게하려고
						if(tmp.getGenre().contains(genre.trim())) {
							System.out.println(tmp);
							count++;
						}
					}
					if(count == 0) {
						System.out.println("검색 결과가 없습니다.");
					}
					break;
				// 서브메뉴가 5이면 조회 취소
				case 5:
					System.out.println("조회를 취소 했습니다");
					break;
				// 잘못된 서브메뉴이면 잘못됐다고 출력
				default:
					System.out.println("잘못된 서브 메뉴 입니다.");
				}
				break;
			//선택 메뉴가 3번이면 프로그램 종료 출력
			case 3:
				System.out.println("프로그램 종료");
				break;
			//선택 메뉴가 1,2,3이 아니면 잘못된 메뉴라고 출력
			default:
				System.out.println("잘못된 메뉴");
			}
		}while(menu != 3);
		sc.close();
	}
}
