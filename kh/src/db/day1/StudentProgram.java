package db.day1;

import java.sql.SQLException;
import java.util.Scanner;

public class StudentProgram {
	
	private static DBTest1 dbtest1;
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		dbtest1.main(null);
		int menu = 0;
		final int EXIT = 3;
		do {
			mainMenu();
			menu = sc.nextInt();
			try {
				runMenu(menu);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}while(menu != EXIT);
	}

	private static void runMenu(int menu) throws SQLException {
		switch (menu) {
		case 1:
			System.out.print("학번:");
			String st_num = sc.next();
			System.out.print("이름:");
			String st_name = sc.next();
			System.out.print("학기:");
			int st_semester = sc.nextInt();
			System.out.print("상태:");
			String st_state = sc.next();
			System.out.print("교수번호:");
			String st_pr_num = sc.next();
			dbtest1.insertStudent(st_num, st_name, st_semester, st_state, st_pr_num);
			dbtest1.connectClose(dbtest1.con);
			break;
		case 2:
			
			break;
		case 3:
			System.out.println("프로그램 종료!!");
			break;
		default:
			System.out.println("잘못된 메뉴 입니다.");
			break;
		}
	}

	private static void mainMenu() {
		System.out.println("=====================");
		System.out.println("1. 학생 정보 추가");
		System.out.println("2. 학생 정보 전체 출력");
		System.out.println("=====================");
		System.out.println("메뉴선택>>");
	}
	
	
	

}
