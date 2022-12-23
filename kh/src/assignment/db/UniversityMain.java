package assignment.db;

import java.util.Scanner;

import assignment.db.vo.Department;

public class UniversityMain {

	private static Scanner sc = new Scanner(System.in);
	private static UniversityDB universityDB;

	public static void main(String[] args) {

		final int EXIT = 7;
		int menu = -1;
		printMenu();
		do {
			menu = sc.nextInt();
			runMenu(menu);
		} while (menu != EXIT);

	}

	private static void runMenu(int subMenu) {
		int num = -1;
		switch (subMenu) {
		case 1: // 학부
			subMenuPrint(1);
			num = sc.nextInt();
			runDepartment(num);
			break;
		case 2: // 강좌
			subMenuPrint(2);
			break;
		case 3: // 학생
			subMenuPrint(3);
			break;
		case 4: // 교수
			subMenuPrint(4);
			break;
		case 5: // 수강
			subMenuPrint(5);
			break;
		case 6: // 성적
			subMenuPrint(6);
			break;
		case 7: // 종료
			subMenuPrint(7);
			break;
		}
	}

	private static void runDepartment(int num) {
		switch (num) {
		case 1:// 등록
			insertDepartment();
			break;
		case 2:// 수정
			
			break;
			
		case 3:// 삭제
			
			break;
		case 4:// 조회
			break;
		default:
			break;
		}
	}

	private static void insertDepartment() {
		System.out.println("학부 번호 : ");
		int de_num = sc.nextInt();
		sc.nextLine();
		System.out.println("학부명 : ");
		String de_name = sc.nextLine();
		System.out.println("학부 주소 : ");
		String de_address = sc.nextLine();
		System.out.println("학부 전화번호 : ");
		String de_tel = sc.nextLine();
		System.out.println("학부 교수 : ");
		int de_pr_num = sc.nextInt();
		Department department = new Department(de_num, de_name, de_address, de_tel, de_pr_num);
		universityDB.insertDepartment(department);
	}

	private static void subMenuPrint(int menu) {
		switch (menu) {
		case 1:
			System.out.println("1. 학부 등록");
			System.out.println("2. 학부 수정");
			System.out.println("3. 학부 삭제");
			System.out.println("4. 학부 조회");
			break;
		case 2:
			System.out.println("1. 강좌 등록");
			System.out.println("2. 강좌 수정");
			System.out.println("3. 강좌 삭제");
			System.out.println("4. 강좌 조회");
			break;
		case 3:
			System.out.println("1. 학생 등록");
			System.out.println("2. 학생 수정");
			System.out.println("3. 학생 삭제");
			System.out.println("4. 학생 조회");
			break;
		case 4:
			System.out.println("1. 교수 등록");
			System.out.println("2. 교수 수정");
			System.out.println("3. 교수 삭제");
			System.out.println("4. 교수 조회");
			break;
		case 5:
			System.out.println("1. 수강 신청");
			System.out.println("2. 수강 취소");
			break;
		case 6:
			System.out.println("1. 성적 등록");
			System.out.println("2. 성적 수정");
			System.out.println("3. 성적 조회");
			break;
		case 7:
			System.out.println("프로그램을 종료 합니다.");
			break;
		default:
		}
	}

	private static void printMenu() {
		System.out.println("====메뉴====");
		System.out.println("1. 학부 관리");
		System.out.println("2. 강좌 관리");
		System.out.println("3. 학생 관리");
		System.out.println("4. 교수 관리");
		System.out.println("5. 수강 관리");
		System.out.println("6. 성적 관리");
		System.out.println("7. 프로그램 종료");
		System.out.print("메뉴선택>>");
	}
}