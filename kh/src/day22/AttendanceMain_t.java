package day22;

import java.util.ArrayList;
import java.util.Scanner;

import lombok.Data;

public class AttendanceMain_t {
	
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int menu = -1;
		Attendance attendance = new Attendance(); //출석부를 만듬 // 안에 list들이 있어서 따로 list를 넘겨주는게 아님
		do {
			printMenu();
			menu = sc.nextInt();
			sc.nextLine();
			runMenu(menu, attendance);
		}while(menu != 3);
	}
	private static void printBar() {
		System.out.println("===============");
	}
	
	private static void printStr(String str) {
		System.out.println(str);
		printBar();
	}
	

	private static void printMenu() {
		System.out.println("====메뉴====");
		System.out.println("1.학생 관리");
		System.out.println("2.출석 관리");
		System.out.println("3.종료");
		System.out.println("===========");
		System.out.print("메뉴 선택:");
	}
	
	private static void printSubMenu(int menu) {
		switch (menu) {
		case 1:
			System.out.println("====학생 관리 메뉴====");
			System.out.println("1. 학생 추가");
			System.out.println("2. 학생 수정");
			System.out.println("3. 학생 삭제");
			System.out.println("4. 취소");
			System.out.println("==================");
			System.out.print("메뉴 선택 :");
			break;
		case 2:
			System.out.println("====출석 관리 메뉴====");
			System.out.println("1. 출석 체크 - 전체");
			System.out.println("2. 출석 확인 - 개별");
			System.out.println("3. 출석 확인 - 날짜별");
			System.out.println("4. 출석 수정");
			System.out.println("5. 출석 삭제");
			System.out.println("6. 취소");
			System.out.println("==================");
			System.out.print("메뉴 선택 :");
			break;
		default:
			printStr("잘못된 메뉴 입니다.");
		}
	}
	
	private static void runMenu(int menu, Attendance attendance) {
		ArrayList<Student> stds = attendance.getStudents();
		ArrayList<Log> logs = attendance.getLogs();
		
		switch (menu) { // 서브메뉴로 인해 추가작업을 해야해서 리턴타입이 필요없다
		case 1:
			managementStudents(stds);
			break;
		case 2:
			//managementLogs(logs,stds);
			break;
		case 3:
			printStr("프로그램 종료!!");
			break;
		case 4:
			printStr("취소 했습니다.");
			break;
		default:
			printStr("잘못된 메뉴입니다.");
		}
	}
	private static void managementStudents(ArrayList<Student> stds) {
		printSubMenu(1);
		int subMenu = sc.nextInt();
		sc.nextLine();
		printBar();
		switch (subMenu) {
		case 1: addStudent(stds); break;
		case 2: updateStudent(stds); break;
		case 3: deleteStudent(stds); break;
		case 4: printStr("취소 했습니다."); break;
		default:
			printStr("메뉴를 잘못 입력했습니다.");
			break;
		}
	}
	private static void deleteStudent(ArrayList<Student> stds) {
		System.out.print("이름 입력 : ");
		String name = sc.nextLine();
		System.out.print("생일 입력 : ");
		String birth = sc.nextLine();
		Student std = new Student(name, birth);
		int index = stds.indexOf(std);
		if(index == -1) { // 중복처리
			printStr("입력 정보와 일치하는 학생이 없습니다.");
			return ;
		}
		stds.remove(index);
		printStr("학생 정보를 삭제했습니다.");
		System.out.println(stds);//확인용
		
	}
	private static void updateStudent(ArrayList<Student> stds) {
		System.out.print("이름 입력 : ");
		String name = sc.nextLine();
		System.out.print("생일 입력 : ");
		String birth = sc.nextLine();
		Student std = new Student(name, birth);
		int index = stds.indexOf(std);
		if(index == -1) { // 중복처리
			printStr("입력 정보와 일치하는 학생이 없습니다.");
			return ;
		}
		System.out.print("수정할 이름 입력 : ");
		name = sc.nextLine();
		System.out.print("수정할 생일 입력 : ");
		birth = sc.nextLine();
		std = new Student(name, birth); 
		stds.set(index, std);
		printStr("학생 정보를 추가했습니다.");
		System.out.println(stds);//확인용
		
	}
	private static void addStudent(ArrayList<Student> stds) {
		if(stds == null) {
			throw new RuntimeException("예외 발생 : 학생 정보를 관리하는 리스트가 없습니다.");
		}
		System.out.print("이름 입력 : ");
		String name = sc.nextLine();
		System.out.print("생일 입력 : ");
		String birth = sc.nextLine();
		Student std = new Student(name,birth);
		if(stds.indexOf(std) != -1) {
			printStr("학생 정보를 추가하지 못했습니다.");
			return ;
		}
		stds.add(std);
		System.out.println(stds); // 확인용
		printStr("학생 정보를 추가했습니다.");
	}
	

}

@Data
class Student {
	private String name; // 이름
	private String dateofbirth; // 생년월일 
	
	public Student(String name, String dateofbirth) {
		this.name = name;
		this.dateofbirth = dateofbirth;
	}

	public Student(Student std) { //깊은복사
		this.name = std.name;
		this.dateofbirth = std.dateofbirth;
	}

	public void update(String name, String dateofbirth) {
		this.name = name;
		this.dateofbirth = dateofbirth;
	}
}

@Data
class StduentLog {
	private Student student; // 포함관계 (이름,생년월일)
	private String state; // 출석,지각,조퇴,결석
	
	public StduentLog(Student std, String state) {
		this.student = new Student(std); // 참조변수는 = 이 안좋음 = 면 공유함 그래서 깊은복사 해주는게 좋음 
		this.state = state;
	}
	
}

@Data
class Log {
	private String date; // 날짜
	private ArrayList<StduentLog> stLogList = new ArrayList<StduentLog>();
	
	public Log(ArrayList<Student> stds,String date) {
		this.date = date;
		for (Student std : stds) {
			StduentLog slog = new StduentLog(std, date);
			stLogList.add(slog); // 빈칸 만들고 어떤 날짜들에 대해서 체크
		}
	}
	
}

@Data
class Attendance {
	private ArrayList<Student> students = new ArrayList<Student>();
	private ArrayList<Log> logs = new ArrayList<Log>();
}
