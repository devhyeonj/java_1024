package home;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import day22.Attendance;
import day22.Log;
import day22.Student;
import day22.StudentLog;

public class AttendanceMain {
	
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		int menu = -1;
		Attendance attendance = new Attendance();
		do {
			try {
				printMenu();
				menu = sc.nextInt();
				sc.nextLine();
				printBar();
				runMenu(menu, attendance);
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
			
		}while(menu != 3);
		
	}
	
	
	

	private static void printMenu() {
		System.out.println("=======메뉴=======");
		System.out.println("1. 학생 관리");
		System.out.println("2. 출석 관리");
		System.out.println("3. 종료");
		System.out.println("=================");
		System.out.print("메뉴 선택 : ");
	}
	
	private static void runMenu(int menu, Attendance attendance) {
		ArrayList<Student> stds = attendance.getStds();
		ArrayList<Log> logs = attendance.getLogs();
		switch (menu) {
		case 1: //학생관리
			managementStudent(stds);
			break;
		case 2://일지관리
			managementLogs(logs,stds);
			break;
		case 3:
			printStr("프로그램 종료!!");
			break;
		default:
			printStr("잘못된 메뉴 입니다.");
		}
	}
	
	private static void managementLogs(ArrayList<Log> logs, ArrayList<Student> stds) {
		printSubMenu(2);
		int subMenu = sc.nextInt();
		sc.nextLine();
		printBar();
		switch(subMenu) {
		case 1: 
			checkLog(logs,stds);
			sortLogs(logs);
			break;
		case 2: 
			printLogsByStudent(logs);
			break;
		case 3: 
			printLogsByDate(logs);
			break;
		case 4: 
			
			break;
		case 5: 
			
			break;
		case 6:printStr("취소 합니다."); break;
		default: printStr("메뉴를 잘못 입력했습니다."); 
	}




	private static void printLogsByDate(ArrayList<Log> logs) {
		System.out.print("날짜 입력:");
		String date = sc.nextLine();
		printBar();
		
		for (Log log : logs) {
			if(log.getDate().equals(date)) {
				for (StudentLog slog : log.getSlogs()) {
					String name = slog.getStd().getName();
				}
			}
		}
	}




	private static void printLogsByStudent(ArrayList<Log> logs) {
	}




	private static void sortLogs(ArrayList<Log> logs) {
		if(logs == null || logs.size() ==0) 
			return;
		
		Collections.sort(logs, (o1,o2) -> o1.getDate().compareTo(o2.getDate()));
	}




	private static void checkLog(ArrayList<Log> logs, ArrayList<Student> stds) {
		System.out.println("출석 일자(예:2022.11.23) :");
		String date = sc.nextLine();
		printBar();
		
		if(checkLogDate(logs,date)) {
			printStr("이미 출석 체크한 일자입니다.");
			return;
		}
		
		printStr("결석 : X, 출석 : O, 지각 : /, 조퇴 : \\");
		
		ArrayList<StudentLog> stdLogs = new ArrayList<>();
		for (Student std : stds) {
			System.out.print(std.getName() + "(" + std.getBirthday() + ") : ");
			String state = sc.nextLine();
			StudentLog stdLog = new StudentLog(std, state);
			stdLogs.add(stdLog);
			Log log = new Log(stdLogs, date);
			logs.add(log);
		}
	}




	private static boolean checkLogDate(ArrayList<Log> logs, String date) {
		if(logs == null || date == null) 
			throw new RuntimeException("일지 리스트가 없거나 날짜가 없습니다.");
		if(logs.size() == 0) 
			return false;
		for (Log log : logs) {
			if(log.getDate().equals(date)) {
				return true;
			}
		}
		
		
		return false;
	}




	private static void managementStudent(ArrayList<Student> stds) {
		printSubMenu(1);
		int subMenu = sc.nextInt();
		sc.nextLine();
		printBar();
		switch(subMenu) {
		case 1: addStudent(stds); break;
		case 2: updateStudent(stds); break;
		case 3: deleteStudent(stds); break;
		case 4: printStr("취소 했습니다."); break;
		default: printStr("메뉴를 잘못 입력했습니다."); break;
		}
	}
	
	private static void addStudent(ArrayList<Student> stds) {
		if(stds == null)
			throw new RuntimeException("예외 발생 : 학생 정보를 관리하는 리스트가 없습니다.");
		System.out.println("이름 입력 : ");
		String name = sc.nextLine();
		System.out.println("생일 입력 : ");
		String birth = sc.nextLine();
		Student std = new Student(name, birth);
		if(stds.indexOf(std) == -1) {
			printStr("학생 정보를 추가하지 못했습니다.");
			return ;
		}
		stds.add(std);
		printStr("학생 정보를 추가했습니다.");
	}




	private static void updateStudent(ArrayList<Student> stds) {
		if(stds == null)
			throw new RuntimeException("예외 발생 : 학생 정보를 관리하는 리스트가 없습니다.");
	
		String name = sc.nextLine();
		System.out.println("생일 입력 : ");
		String birth = sc.nextLine();
		Student std = new Student(name, birth);
		int index = stds.indexOf(std);
		if(index == -1) {
			printStr("입력 정보와 일치하는 학생이 없습니다.");
			return ;
		}
		System.out.print("수정할 이름 입력 :");
		name = sc.nextLine();
		System.out.print("수정할 생일 입력:");
		birth = sc.nextLine();
		std = new Student(name, birth);
		stds.set(index, std);
		printStr("학생 정보를 수정했습니다.");
	}




	private static void deleteStudent(ArrayList<Student> stds) {
		if(stds == null)
			throw new RuntimeException("예외 발생 : 학생 정보를 관리하는 리스트가 없습니다.");
		String name = sc.nextLine();
		System.out.println("생일 입력 : ");
		String birth = sc.nextLine();
		Student std = new Student(name, birth);
		int index = stds.indexOf(std);
		if(index == -1) {
			printStr("입력 정보와 일치하는 학생이 없습니다.");
			return ;
		}
		stds.remove(index);
		printStr("학생 정보를 삭제했습니다.");
	}




	private static void printSubMenu(int menu) {
		switch (menu) {
		case 1:
			System.out.println("===학생 관리 메뉴===");
			System.out.println("1. 학생 추가");
			System.out.println("2. 학생 수정");
			System.out.println("3. 학생 삭제");
			System.out.println("4. 취소");
			System.out.println("=================");
			System.out.print("메뉴 선택 : ");
			break;
		case 2:
			System.out.println("===출석 관리 메뉴===");
			System.out.println("1. 출석 체크 - 전체");
			System.out.println("2. 출석 확인 - 개별");
			System.out.println("3. 출석 확인 - 날짜별");
			System.out.println("4. 출석 수정");
			System.out.println("5. 출석 삭제");
			System.out.println("6. 취소");
			System.out.println("=================");
			System.out.print("메뉴 선택 : ");
			break;
		default:
			printStr("잘못된 메뉴입니다.");
		}
	}




	private static void printBar() {
		System.out.println("=================");
	}
	
	private static void printStr(String str) {
		System.out.println(str);
		printBar();
	}
}
