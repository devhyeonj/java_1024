package assignment.db;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import assignment.db.domain.Department;
import assignment.db.domain.Lecture;

public class UniversityMain {

	private static Scanner sc = new Scanner(System.in);
	private static UniversityDB universityDB;

	public static void main(String[] args) throws SQLException {
		
		try {
			universityDB = new UniversityDB();
		} catch (Exception e) {
			System.out.println("[DB연결 실패]");
			System.out.println("[프로그램 종료]");
			return ;
		}
		
		final int EXIT = 7;
		int menu = -1;
		printMenu();
		do {
			menu = sc.nextInt();
			runMenu(menu);
		} while (menu != EXIT);

	}

	private static void runMenu(int subMenu) throws SQLException {
		int num = -1;
		switch (subMenu) {
		case 1: // 학부
			subMenuPrint(1);
			num = sc.nextInt();
			runDepartment(num);
			break;
		case 2: // 강좌
			subMenuPrint(2);
			num = sc.nextInt();
			runLecture(num);
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

	private static void runLecture(int num) throws SQLException {
		switch (num) {
		case 1:// 등록
			insertLecture();
			break;
		case 2:// 수정
			updateLecture();
			break;
		case 3:// 삭제
			deleteLecture();
			break;
		case 4:// 조회
			System.out.println("1. 전체 조회");
			System.out.println("2. 강좌명으로 검색");
			int selectNum = sc.nextInt();
			selectLectureMenu(selectNum);
			break;
		default:
			break;
		}
	}

	private static void selectLectureMenu(int selectNum) throws SQLException {
		switch (selectNum) {
		case 1:
			findAllLecture();
			break;
		case 2: 
			findByle_name();
			break;
		}
	}

	private static Lecture findByle_name() throws SQLException {
		System.out.println("검색 할 강좌명을 입력해주세요.");
		sc.nextLine();
		System.out.print("강좌명 : ");
		String le_name = sc.nextLine();
		Lecture lecture = universityDB.findByLeName(le_name);
		System.out.println(lecture);
		return lecture;
	}

	private static void findAllLecture() throws SQLException {
		List<Lecture> leList = universityDB.findAllLecture();
		leList.forEach(l -> System.out.println(l));
	}

	private static void deleteLecture() throws SQLException {
		findAllLecture();
		System.out.println("삭제 할 강좌명을 입력 해주세요.");
		sc.nextLine();
		System.out.print("강좌명 입력 >> ");
		String searchName = sc.nextLine();
		if(universityDB.deleteLecture(searchName)) {
			System.out.println("삭제에 성공하였습니다.");
		}else {
			System.out.println("삭제에 실패하였습니다.");
		}
	}

	private static void updateLecture() throws SQLException {
		findAllLecture();
		System.out.println("수정 할 강좌명을 입력 해주세요.");
		sc.nextLine();
		System.out.print("강좌명 입력 >> ");
		String searchName = sc.nextLine();
		System.out.println("수정을 시작합니다.");
		System.out.print("강좌명 : ");
		String le_name = sc.nextLine();
		System.out.print("스케쥴 : ");
		String le_schedule = sc.nextLine();
		System.out.print("학점 : ");
		int le_point = sc.nextInt();
		System.out.print("클래스 : ");
		int le_class = sc.nextInt();
		System.out.print("연도 : ");
		int le_year = sc.nextInt();
		System.out.print("학기 : ");
		String le_term =sc.next();
		System.out.print("담당 교수번호 : ");
		int le_pr_num = sc.nextInt();
		Lecture lecture = new Lecture(le_pr_num, le_name, le_schedule, le_point, le_class, le_year, le_term, le_pr_num);
		universityDB.updateLecture(lecture, searchName);
	}

	private static void insertLecture() {
		sc.nextLine();
		System.out.print("강좌명 : ");
		String le_name = sc.nextLine();
		System.out.print("스케쥴 : ");
		String le_schedule = sc.nextLine();
		System.out.print("학점 : ");
		int le_point = sc.nextInt();
		System.out.print("클래스 : ");
		int le_class = sc.nextInt();
		System.out.print("연도 : ");
		int le_year = sc.nextInt();
		System.out.print("학기 : ");
		String le_term =sc.next();
		System.out.print("담당 교수번호 : ");
		int le_pr_num = sc.nextInt();
		Lecture lecture = new Lecture(le_pr_num, le_name, le_schedule, le_point, le_class, le_year, le_term, le_pr_num);
		universityDB.insertLecture(lecture);
	}

	private static void runDepartment(int num) throws SQLException {
		switch (num) {
		case 1:// 등록
			insertDepartment();
			break;
		case 2:// 수정
			updateDepartment();
			break;
		case 3:// 삭제
			deleteDepartment();
			break;
		case 4:// 조회
			System.out.println("1. 전체 조회");
			System.out.println("2. 학부 명으로 검색");
			int selectNum = sc.nextInt();
			selectDepartmentMenu(selectNum);
			break;
		default:
			break;
		}
	}
	private static void selectDepartmentMenu(int selectNum) throws SQLException {
		switch (selectNum) {
		case 1:
			findAllDepartment();
			break;
		case 2: 
			findByde_Name();
			break;
		}
	}

	//전체조회
	private static void findAllDepartment() throws SQLException {
		List<Department> deList = universityDB.findAllDepartment();
		deList.forEach(d -> System.out.println(d));
	}
	
	//학부명으로 검색
	private static Department findByde_Name() throws SQLException {
		System.out.println("검색할 학부 명을 입력해주세요.");
		System.out.print("학부 명 : ");
		sc.nextLine();
		String de_name = sc.nextLine();
		Department findDepartment = universityDB.findByDeName(de_name);
		System.out.println(findDepartment);
		return findDepartment;
	}

	private static void updateDepartment() throws SQLException {
		Department isDepartment = findByde_Name();
		if(isDepartment == null) {
			System.out.println("해당 하는 학부가 없습니다.");
			return ;
		}
		System.out.println("수정을 시작 합니다.");
		System.out.print("학부 번호 : ");
		int de_num = sc.nextInt();
		sc.nextLine();
		System.out.println("학부명 : ");
		String de_name = sc.nextLine();
		System.out.println("학부 주소 : ");
		String de_address = sc.nextLine();
		System.out.println("학부 전화번호 : ");
		String de_tel = sc.nextLine();
		System.out.println("학부 교수번호 : ");
		int de_pr_num = sc.nextInt();
		Department department = new Department(de_num, de_name, de_address, de_tel, de_pr_num);
		universityDB.updateDepartment(department,isDepartment.getDe_num());
	}
	
	private static void deleteDepartment() throws SQLException {
		Department isDepartment = findByde_Name();
		if(isDepartment == null) {
			System.out.println("해당 하는 학부가 없습니다.");
			return ;
		}
		System.out.println("삭제 하겠습니까? (y/n)");
		if(sc.next().charAt(0) != 'y') {
			return ;
		}
		if(universityDB.deleteDepartment(isDepartment.getDe_num())) {
			System.out.println("삭제에 성공하였습니다.");
		}else {
			System.out.println("삭제에 실패하였습니다.");
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
		System.out.println("학부 교수번호 : ");
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