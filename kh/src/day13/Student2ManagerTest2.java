package day13;

import java.util.Scanner;

import day13.Student2;

public class Student2ManagerTest2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Student2 [] stds = new Student2[30];
		int count = 0;
		int menu = -1;
		for( ;menu != 4 ; ) {

			printMenu();

			menu = scan.nextInt();

			count = runMenu(menu, stds, count);
		}//for문 끝
	}//main 끝

	private static int runMenu(int menu, Student2[] stds, int count) {
		Scanner scan = new Scanner(System.in);
		switch(menu) {
		case 1:
			if(addStudent2(stds, count)) {
				System.out.println("학생을 추가했습니다.");
				count++;
			}else {
				System.out.println("학생을 추가하지 못했습니다.");
			}
			break;
		case 2:
			if(addScore(stds, count)) {
				System.out.println("성적을 등록했습니다.");
			}else {
				System.out.println("성적을 등록하지 못했습니다.");
			}
			break;
		case 3:	
			printStudent2List(stds, count);
			break;
		case 4: 
			System.out.println("프로그램 종료");
			break;
		default:
			System.out.println("잘못된 메뉴!!");
		}
		return count;
	}

	private static void printStudent2List(Student2[] stds, int count) {
		for(int i=0; i<count; i++) {
			System.out.println(stds[i]);
			stds[i].printScore();
		}
	}

	private static boolean addScore(Student2[] stds, int count) {
		System.out.println("성적을 추가할 학생 정보 입력");
		Student2 tmp = scanStudent2BaseInfo();
		int index = indexOfStudent2(stds, count, tmp);

		if(index == -1) {
			return false;
		}

		System.out.println("성적 정보를 입력하세요.");
		return stds[index].addScore(scanScore());
	}

	private static boolean addStudent2(Student2[] stds, int count) {
		Scanner scan = new Scanner(System.in);
		System.out.println("추가할 학생 정보 입력");
		Student2 tmp = scanStudent2BaseInfo();

		System.out.print("이름 : ");
		tmp.setName(scan.next());

		int index = indexOfStudent2(stds, count, tmp);

		if(index == -1 && count < stds.length) {
			stds[count] = tmp;
			return true;
		}
		return false;
	}

	private static Score scanScore() {
		Scanner scan = new Scanner(System.in);
		System.out.print("과목 : ");
		String title = scan.next();
		System.out.print("학기 : ");
		int term = scan.nextInt();
		System.out.print("중간 : ");
		int midScore = scan.nextInt();
		System.out.print("기말 : ");
		int finalScore = scan.nextInt();
		System.out.print("수행평가 : ");
		int performace = scan.nextInt();
		return new Score(title, term, midScore, finalScore, performace);
	}

	private static Student2 scanStudent2BaseInfo() {
		Scanner scan = new Scanner(System.in);
		System.out.print("학년 : ");
		int grade = scan.nextInt();
		System.out.print("반  : ");
		int classNum = scan.nextInt();
		System.out.print("번호 : ");
		int num = scan.nextInt();
		return new Student2(grade, classNum, num);
	}

	private static int indexOfStudent2(Student2[] stds, int count, Student2 tmp) {
		for(int i = 0; i<count; i++) {
			if(stds[i].equals(tmp)) {
				return i;
			}
		}
		return -1;
	}

	private static void printMenu() {
		System.out.println("------메뉴-----");
		System.out.println("1. 학생 정보 추가");
		System.out.println("2. 학생 성적 추가");
		System.out.println("3. 학생 정보 출력");
		System.out.println("4. 프로그램 종료");
		System.out.print("메뉴 선택 : ");
	}
}