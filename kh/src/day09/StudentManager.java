package day09;

import java.util.Scanner;

public class StudentManager {
	
	public static void main(String[] args) {
		/* 클래스를 이용해서 만들기
		 * 메뉴 
		 * 1. 학생추가
		 * 2. 학생 성적 추가
		 * 3. 학생 정보 출력
		 * 4. 프로그램 종료
		 */
		// 반복문을 통해 메뉴를 출력
		int menu; // while true때문에 밖으로 뺌 코드가 간단해짐
		HighStudent [] list = new HighStudent[30];
		int count =0;
		do {
			// 메뉴를 출력(입력)
			printMenu();
			// 메뉴 선택
			menu = selectMenu();
			// 선택한 메뉴에 맞는 기능 실행
			System.out.println("c:"+count);
			count = runMenu(menu, list,count);
			System.out.println("c:"+count);
			
		}while(menu != 4);
		
	}
	
	/** 
	 * 메뉴를 출력하는 메소드
	 */
	public static void printMenu() {
		System.out.println("------메뉴------");
		System.out.println("1. 학생추가");
		System.out.println("2. 학생 성적 추가");
		System.out.println("3. 학생 정보 출력");
		System.out.println("4. 프로그램 종료");
		System.out.println("---------------");
		System.out.print("메뉴를 선택하세요>>");
	}
	/**
	 * 콘솔에서 입력받은 정수(메뉴) 를 알려주는 메소드
	 * @return 입력받은 정수(메뉴)
	 */
	public static int selectMenu() {
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}
	/**
	 * 메뉴에 맞는 기능을 실행하는 메소드
	 * @param menu 선택한 메뉴
	 * @param list 학생들 정보가 들어있는 리스트
	 * @return 현재 저장된 학생 수
	 */												// 현재 몇명 저장했는지 밖에서 알려줘야함
	public static int runMenu(int menu, HighStudent[] list, int count) {
		int grade, classNum, num;						// 현재 저장된 학생 수
		String name;
		Scanner sc = new Scanner(System.in);
		switch (menu) {
		case 1://학생 추가
			//학생 정보를 입력
			System.out.print("학생 정보 입력(학년,반,번호,이름순): ");
			grade = sc.nextInt();
			classNum =sc.nextInt();
			num = sc.nextInt();
			name = sc.next();
			
			//리스트에 학생 정보를 추가
			list[count] = new HighStudent(grade, classNum, num, name);
			//리스트에 들어가있는 학생수 1 증가
			count++;
			break;
		case 2: // 학생 성적 추가
			//학생을 선택 => 학생 정보를 출력 후, 학생을 선택
			for (int i = 0; i < count; i++) {
				System.out.println("---------------------");
				System.out.println(i+1+"번 학생");
				list[i].print();
				System.out.println("---------------------");
			}
			System.out.print("학생 선택: ");
			int index = sc.nextInt() - 1;
			// 성적을 입력
			System.out.print("성적 입력(국어,영어,수학순):");
			int kor = sc.nextInt();
			int eng = sc.nextInt();
			int math = sc.nextInt();
			//해당 학생의 성적을 입력받은 성적으로 변경
			list[index].updateScore(kor, eng, math);
			break;
		case 3:// 학생 정보 출력
			for (int i = 0; i < count; i++) {
				list[i].print();
			}
			break;
		case 4:
			System.out.println("프로그램을 종료합니다.!!");
			break;
		default:
			System.out.println("잘못된 메뉴입니다.");
			break;
		}
		return count;
	}
}


