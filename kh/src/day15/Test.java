package day15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

import lombok.Data;
@Data
class Date {
	int year;
	int month;
	int day;
	
	
	@Override
	public String toString() {
		return year+"년,"+ month + "월, "+day+"일";
	}


	public Date(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	public String getDate(){
		return ""+ year + "/" + month + "/" + day ;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Date other = (Date) obj;
		return day == other.day && month == other.month && year == other.year;
	}


	@Override
	public int hashCode() {
		return Objects.hash(day, month, year);
	}
	
	
	
}
@Data
class Account{
	String division;
	String classification;
	String Contents;
	int price;
	Date date;
	
	
	public Account(String division, String classification, String contents, int price, Date date) {
		this.division = division;
		this.classification = classification;
		this.Contents = contents;
		this.price = price;
		this.date = date;
	}
	
	
	@Override
	public String toString() {
		return division+" "+ date + " "+ classification + " "+ Contents +" "+  price;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass()) {
			if(!(obj instanceof Integer)) {
				return false;
			}
			return date.equals(obj);
		}
		Account other = (Account) obj;
		return Objects.equals(date, other.date);
	}


	@Override
	public int hashCode() {
		return Objects.hash(date);
	}



	

	
}

public class Test {
	
	public static void main(String[] args) {
		/*
		 * 가계부 프로그램을 작성하세요.
		 * 메뉴
		 * 1. 내역 추가
		 * 2. 내역 확인
		 * 3. 내역 수정
		 * 4. 내역 삭제
		 * 5. 종료
		 * 
		 * 1. 내역 추가
		 * 구분 : 수입/지출
		 * 분류: 식비/통신비/교통비/생활비/용돈
		 * 내용: 홈플러스/X약국/X식당 ( 실제 내가 어디에 썼는지)
		 * 금액: 5000
		 * 일시 : 년 , 월 , 일
		 * 
		 * 2. 내역 확인
		 * 	2-1. 전체 내역 확인
		 *  2-2. 년 내역 확인
		 *  2-3. 월 내역 확인
		 *  2-4. 일 내역 확인  
		 * 구분 | 일시 | 분류 | 내용 | 금액 순으로
		 * 
		 * 3. 내역 수정
		 * 년,월,일로 검색 후 내역 출력
		 * 번호를 입력 
		 * 입력 받은 번호에 맞는 내역을 수정 - 구분/일시/분류/내용/금액순으로 입력받아 수정
 		 * 4. 내역 삭제
 		 * 년,월,일로 검색 후 내역 출력
 		 * 번호를 입력
 		 * 입력 받은 번호에 맞는 내역을 삭제
 		 * 
 		 * 추가 - 가계부를 년,월,일로 정렬
 		 */
		//스캐너
		Scanner sc = new Scanner(System.in);
		//메뉴 변수 
		int menu = -1;
		int dateNum = 0;
		//ArrayList<> 
		ArrayList<Account> accountList = new ArrayList<>();
		//
		Date date = null;
		Account account = null;
				
		//do-while menu!=5
		do {
			printMenu();
			// 입력 받을때 try catch 해보기
			try {
				menu = sc.nextInt();
				runMenu(menu,accountList, date, account); 
			}catch(InputMismatchException e) {
				System.out.println("숫자를 입력해주세요. 다시 입력해주세요.");
				menu = sc.nextInt();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}while(menu != 5);
		
	

	}//main
	
		
	
	/**
	 * 메뉴 출력하는 메소드
	 */
	public static void printMenu() {
		System.out.println("메뉴");
		System.out.println("1.내역 추가");
		System.out.println("2.내역 확인");
		System.out.println("3.내역 수정");
		System.out.println("4.내역 삭제");
		System.out.println("5.종료");
		System.out.print("메뉴 선택>>");
	}
	
	public static void printSubMenu() {
		System.out.println("2-1. 전체 내역 확인");
		System.out.println("2-2. 년 내역 확인");
		System.out.println("2-3. 월 내역 확인");
		System.out.println("2-4. 일 내역 확인");
	}
	
	public static void runMenu(int menu, ArrayList<Account> accountList,Date date,Account account) {
		//switch 문으로 메뉴 번호 선택에 따른 기능 실행
		Date datee =null;
		switch (menu) {
		case 1:// 추가
			insertAccount(accountList, datee, account);
			break;
		case 2:// 확인
			selectAccount(accountList, account, date);
			break;
		case 3:// 수정
			updateAccount(accountList, datee,account);
			break;
		case 4:// 삭제
			deleteAccount(accountList, datee, account);
			break;
		default:
			break;
		}
	}
	/**
	 * 내역 추가 메소드
	 * @param accountList
	 */
	public static void insertAccount(ArrayList<Account> accountList,Date datee,Account account) {
		//스캐너 선언
		Scanner sc = new Scanner(System.in);
		//입력받음
		try {
			account = scannerAccount(datee, account);
			accountList.add(account);
		}catch(InputMismatchException e) {
			System.out.println("잘못입력 하셨습니다. 다시 입력하세요!");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("등록에 실패하였습니다.");
		}
	}
	/**
	 * 등록 스캐너*/
	public static Account scannerAccount(Date date,Account account) {
		Scanner sc= new Scanner(System.in);
		System.out.print("구분:");String division = sc.next();
		System.out.print("분류:");String classification = sc.next();
		System.out.print("내용:");String Contents = sc.next();
		System.out.print("금액:");int price = sc.nextInt();
		date = scannerDate(date);
		account = new Account(division, classification, Contents, price, date);
		return account;
	}
	
	/**
	 * 수정 스캐너
	 */
	public static Account scannerUpdateAccount(Date date,Account account) {
		Scanner sc = new Scanner(System.in);
		System.out.print("구분:");String division = sc.next();
		date = scannerDate(date);
		System.out.print("분류:");String classification = sc.next();
		System.out.print("내용:");String Contents = sc.next();
		System.out.print("금액:");int price = sc.nextInt();
		account = new Account(division, classification, Contents, price, date);
		return account;
	}

	/**
	 * 년 월 일 입력받는 메소드
	 */
	public static Date scannerDate(Date date) {
		Scanner sc = new Scanner(System.in);
		System.out.print("일시(년,월,일 순으로 입력해주세요):");int year = sc.nextInt();int month = sc.nextInt(); int day = sc.nextInt();
		date = new Date(year, month, day);
		return date;
	}
	
	


	/**
	 * 내역 확인 메소드
	 * @param accountList
	 */
 	public static void selectAccount(ArrayList<Account> accountList,Account account,Date date) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> indexList = null;
		int num=0;
		//printSubMenu();
		if(accountList == null || accountList.size() < 0) {
			System.out.println("등록된 가계부가 없습니다.");
		}
		
		printSubMenu();
		String menu = sc.next();
		System.out.println("구분 | 일시| 분류 | 내용 | 금액");
		
				if(menu.equals("2-1")) {// 전체출력
					for (int i = 0; i < accountList.size(); i++) {
					accountList = sortMethod(accountList);
					System.out.println("2-"+(i+1)+"."+accountList.get(i));
					}
				}else if(menu.equals("2-2")) {//년
					System.out.print("보고싶은 년도를 입력하세요>>");
					printBunryu(indexList,accountList);
				}else if(menu.equals("2-3")) { // 월
					System.out.print("보고싶은 월을 입력하세요>>");
					printBunryu(indexList, accountList);
				}else if(menu.equals("2-4")) { // 일
					System.out.print("보고싶은 일을 입력하세요>>");
					printBunryu(indexList, accountList);
				}
		
	}
 	//여기가 문제
	private static ArrayList<Integer> searchIndex(ArrayList<Account> accountList, int dateNum) {
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < accountList.size(); i++) {
			if(accountList.equals(dateNum)) {
				list.add(i);
			}
		}
		return list;
	}
	
	public static void printBunryu(ArrayList<Integer> indexList, ArrayList<Account> accountList) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		indexList = searchIndex(accountList, num);
		for (int j = 0; j < indexList.size(); j++) {
			int index = indexList.get(j);
			System.out.println((j+1) +". " + accountList.get(index));
		}
	}
	


	public static ArrayList<Account> sortMethod(ArrayList<Account> accountList) {
		Collections.sort(accountList, new Comparator<Account>() {

			@Override
			public int compare(Account a1, Account a2) {
				if(a1.getDate().getYear() != a2.getDate().getYear()) {
					return a1.getDate().getYear() -  a2.getDate().getYear();
				}if(a1.getDate().getMonth() != a2.getDate().getMonth()){
					return a1.getDate().getMonth() - a2.getDate().getMonth();
				}
				return a1.getDate().getDay() - a2.getDate().getDay();
			}
			});
		return accountList;
	}



	/**
	 * 내역 수정 메소드
	 * @param accountList
	 */
	public static void updateAccount(ArrayList<Account> accountList,Date date,Account account) {
		Scanner sc = new Scanner(System.in);
		
		// 년,월,일로 입력받음
		date = scannerDate(date);
		// 출력 
		for (int i = 0; i <accountList.size() ; i++) {
			if(accountList.get(i).getDate().equals(date)) {
				System.out.println("\n2-"+(i+1)+"."+accountList.get(i));
			}
		}
		// 번호를 입력
		System.out.print("수정 할 번호를 끝자리 한자리수로 입력하세요 예) 1 2 3...");
		try {
			int num = sc.nextInt()-1;
			account = scannerUpdateAccount(date, account);
			accountList.set(num, account);
		}catch(InputMismatchException e) {
			System.out.println("다시 입력해주세요.");
			int num = sc.nextInt()-1;
		}catch(Exception e) {
			System.out.println("수정에 실패하였습니다.");
		}
	}



	/**
	 * 내역 삭제 메소드
	 * @param accountList
	 */
	public static void deleteAccount(ArrayList<Account> accountList,Date date,Account account) {
		Scanner sc = new Scanner(System.in);
		//년,월,일로 검색 후 내역 출력
		// 년,월,일로 입력받음
		date = scannerDate(date);
		// 출력 
		for (int i = 0; i <accountList.size() ; i++) {
			if(accountList.get(i).getDate().equals(date)) {
				System.out.println("\n2-"+(i+1)+"."+accountList.get(i));
			}
		}
		//번호를 입력
		System.out.print("삭제 할 번호를 끝자리를 한자리수로 입력하세요 예) 1 2 3...");
		//입력 받은 번호에 맞는 내역을 삭제
		try {
			int num = sc.nextInt()-1;
			accountList.remove(num);
		}catch(InputMismatchException e) {
			System.out.println("다시 입력해주세요.");
			int num = sc.nextInt()-1;
		}catch(Exception e) {
			System.out.println("삭제에 실패하였습니다.");
		}
	}
	
}//class
