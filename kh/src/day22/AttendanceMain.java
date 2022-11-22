package day22;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Predicate;

import lombok.Data;

public class AttendanceMain {
	
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		/* 출석부 관리 프로그램
		 *  1. 학생 등록
		 *   - 이름과 생년월일 
		 *  2. 학생 수정
		 *  - 이름과 생년월일로 검색해서 이름과 생년월일 수정
		 *  3. 학생 삭제
		 *  - 이름과 생년월일로 검색해서 삭제
		 *  4. 학생 출결 확인 
		 *  - 이름과 생년월일로 검색해서 해당 학생의 모든 출결을 확인
		 *  - 2022-11-22 출석
		 * --------------------------------------------
		 *  5. 출석 확인 
		 *  - 날짜 입력 : 2022-11-22
		 *  - 출석: 0, 지각 : /, 조퇴 : \, 결석 : X
		 *  - 등록된 학생 기준으로 확인하는데 이름을 입력하는게 아니라 뜨면 0 / \ X를 입력함
		 *  홍길동 출석현황 : X
		 *  고길동 출석현황 : O
		 *  임꺽정 출석현황 : /
		 *  6. 출석 수정
		 *  - 날짜 입력
		 *  - 수정할 학생의 이름과 생년월일 입력
		 *  7. 출석 삭제
		 *  - 날짜 입력하여 해당 날짜 출석 삭제
		 *  8. 날짜별 출석확인
		 *  - 날짜 입력하여 해당 날짜의 모든 학생의 출석 여부를 확인
		 *  9. 프로그램 종료 
		 *  
		 *  //학생 클래스 : 이름 ,생년월일
		 *  //학생 일지 클래스 : 이름, 생년월일 , 출결 (포함관계)
		 *  일지 클래스 : 날짜 , 학생일지들(이름,생년월일,출결)
		 *  출석부 클래스 : 학생들 , 일지들
		 */
		//메뉴 변수 
		int menu = 0;
		//출석부 ArrayList
		ArrayList<Student> stList = new ArrayList<Student>();
		ArrayList<StduentLog> stdLogList = new ArrayList<StduentLog>();
		//반복문 do-while문
		do {
			//메인메뉴 출력
			mainMenu();
			try {
			//메인메뉴 선택
			menu = sc.nextInt();
			//선택에 따른 기능 실행
			runMenu(stList,stdLogList, menu);
			}catch(RuntimeException e) {
				System.out.println(e.getMessage());
			}
			
		}while(menu != 9);

	}

	private static void runMenu(ArrayList<Student> stList,ArrayList<StduentLog> stdLogList,int menu) {
		switch (menu) {
		case 1:// 학생 등록
			// 이름과 생년월일
			if(createStudent(stList)) {
				System.out.println("학생 등록에 성공 하였습니다.");
			}else {
				System.out.println("학생 등록에 실패 하였습니다.");
			}
			break;
		case 2:// 학생 수정
			if(updateStudent(stList)) {
				System.out.println("학생 수정에 성공 하였습니다.");
			}else {
				System.out.println("학생 수정에 실패 하였습니다.");
			}
			// 이름과 생년월일로 검색해서 이름과 생년월일 수정
			break;	
		case 3:// 학생 삭제
			if(deleteStudent(stList)) {
				System.out.println("학생 삭제에 성공 하였습니다.");
			}else {
				System.out.println("학생 삭제에 실패 하였습니다.");
			}
			break;
		case 4:// 학생 출결 확인
			Student tmp1 = searchStudent(stList);
			
			// 이름과 생년월일로 검색해서 해당 학생의 모든 출결을 확인
			break;
		case 5:// 출석확인
			System.out.print("날짜 입력:");
			String date = sc.next();
			StduentLog tmp;
			String num;
			for (int i = 0; i < stList.size(); i++) {
				System.out.print(stList.get(i).getName()+" 출석현황 :");
				num =sc.next();
				tmp = new StduentLog(stList.get(i), num);
				stdLogList.add(tmp);
			}
				System.out.println(stdLogList.toString());
			// 날짜 입력(2022-11-22)
			// 출석 :O 지각:/ 조퇴:\ 결석:X
			break;
		case 6://출석 수정
			//날짜 입력
			// 수정할 학생의 이름과 생년월일 입력
			break;
		case 7:// 출석 삭제
			//날짜 입력하여 해당 날짜 출석 삭제
			break;
		case 8:// 날짜별 출석확인
			// 날짜 입력하여 해당 날짜의 모든 학생의 출석 여부를 확인
			break;
		case 9:
			System.out.println("프로그램을 종료 합니다.");
			break;
		default:
			throw new RuntimeException("잘못된 메뉴");
		}
		
	}
	
	private static boolean deleteStudent(ArrayList<Student> stList) {
		Student std = searchStudent(stList);
		if(std == null) {
			System.out.println("삭제 하려는 학생 정보가 없습니다.");
			return false;
		}
		return stList.remove(std);
	}

	private static boolean updateStudent(ArrayList<Student> stList) {
		Student std = searchStudent(stList);
		if(std == null) {
			System.out.println("수정 하려는 학생 정보가 없습니다.");
			return false;
		}
		System.out.println("수정 하고 싶은 이름과 생년월일을 입력해주세요.");
		System.out.print("이름:");String name = sc.next();
		System.out.print("생년월일(예: 2022-11-22)");String dateofbirth = sc.next();
		std.update(name,dateofbirth);
		return true;
	}

	
	private static Student searchStudent(ArrayList<Student> stList) {
		System.out.println("이름과 생년월일 검색");
		System.out.print("이름:");String name = sc.next();
		System.out.print("생년월일(예: 2022-11-22)");String dateofbirth = sc.next();
		ArrayList<Integer> indexs = search(stList, (s) -> s.getName().equals(name) && s.getDateofbirth().equals(dateofbirth));
		searchResult(stList, indexs);
		int index = 0;
		for (int i = 0; i < indexs.size(); i++) {
			index = indexs.get(i);
		}
		return stList.get(index);
	}
	
	private static <T> void searchResult(ArrayList<T> list,ArrayList<Integer> indexs) {
		if(list == null || list.size() == 0 || indexs == null || indexs.size() ==0) {
			throw new RuntimeException("검색 결과가 없습니다.");
		}
		for (int i = 0; i < indexs.size(); i++) {
			int index = indexs.get(i);
			System.out.println(i+1+"."+list.get(index));
		}
		
	}

	private static ArrayList<Integer> search(ArrayList<Student> stList,Predicate<Student> p) {
		ArrayList<Integer> indexList = new ArrayList<Integer>();
		for (int i = 0; i < stList.size(); i++) {
			if(p.test(stList.get(i))) {
				indexList.add(i);
			}
		}
		return indexList;
	}
	
	private static ArrayList<Integer> search2(ArrayList<Log> logList,Predicate<Log> p) {
		ArrayList<Integer> indexList = new ArrayList<Integer>();
		for (int i = 0; i < logList.size(); i++) {
			if(p.test(logList.get(i))) {
				indexList.add(i);
			}
		}
		return indexList;
	}

	private static Student inputStudent() {
		System.out.print("이름:");String name = sc.next();
		System.out.print("생년월일(예: 2022-11-22)");String dateofbirth = sc.next();
		return new Student(name, dateofbirth);
	}
	
	private static boolean createStudent(ArrayList<Student> stList) {
		Student tmp = inputStudent();
		if(tmp == null) {
			throw new RuntimeException("등록 하려는 학생 데이터가 없습니다.");
		}
		stList.add(tmp);
		for (Student student : stList) {
			System.out.println("학생 등록 확인"+student);
		}
		return true;
	}
	
	
	

	private static void mainMenu() {
		System.out.println("출석부 관리 프로그램 입니다.");
		System.out.println("1. 학생 등록");
		System.out.println("2. 학생 수정");
		System.out.println("3. 학생 삭제");
		System.out.println("4. 학생 출결 확인");
		System.out.println("5. 출석 확인");
		System.out.println("6. 출석 수정");
		System.out.println("7. 출석 삭제");
		System.out.println("8. 날짜별 출석확인");
		System.out.println("9. 프로그램 종료");
		System.out.print("메뉴입력>>");
	}

}

//@Data
//class Student {
//	private String name; // 이름
//	private String dateofbirth; // 생년월일 
//	
//	public Student(String name, String dateofbirth) {
//		this.name = name;
//		this.dateofbirth = dateofbirth;
//	}
//
//	public Student(Student std) { //깊은복사
//		this.name = std.name;
//		this.dateofbirth = std.dateofbirth;
//	}
//
//	public void update(String name, String dateofbirth) {
//		this.name = name;
//		this.dateofbirth = dateofbirth;
//	}
//}
//
//@Data
//class StduentLog {
//	private Student student; // 포함관계 (이름,생년월일)
//	private String state; // 출석,지각,조퇴,결석
//	
//	public StduentLog(Student std, String state) {
//		this.student = new Student(std); // 참조변수는 = 이 안좋음 = 면 공유함 그래서 깊은복사 해주는게 좋음 
//		this.state = state;
//	}
//	
//}
//
//@Data
//class Log {
//	private String date; // 날짜
//	private ArrayList<StduentLog> stLogList = new ArrayList<StduentLog>();
//	
//	public Log(ArrayList<Student> stds,String date) {
//		this.date = date;
//		for (Student std : stds) {
//			StduentLog slog = new StduentLog(std, date);
//			stLogList.add(slog); // 빈칸 만들고 어떤 날짜들에 대해서 체크
//		}
//	}
//	
//}
//
//@Data
//class Attendance {
//	private ArrayList<Student> students = new ArrayList<Student>();
//	private ArrayList<Log> logs = new ArrayList<Log>();
//}
