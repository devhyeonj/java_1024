package day13;

import java.util.Scanner;

import Student.Score;
import day12.Student;

public class StudentProgramTest {
	/*
	 * 학생 성적 관리 프로그램을 작성 하세요. - 작성하기 위해 필요한 작업들을 주석으로 정리해보세요
	 */
	// 내가 작성한 주석
	/*
	 * 1. 학생 객체 만들기 1-1 필드 작성함 1-2 getter setter 작성함 1-3 toString 작성함 2. 성적 관리 인터페이스
	 * 만들기 2-1 메소드 만듬 3. 클래스 파일에서 성적 관리 인터페이스를 implement로 받아 메소드를 불러옴 4. 클래스 파일에서
	 * 메소드 파일을 완성함 5. toString을 sysout 출력할때 활용함
	 */

	// 강사님이 작성한 주석
	/*
	 * 1. 프로그램에 필요한 기능을 정리 메뉴 1. 학생 정보 추가 2. 학생 성적 추가 3. 학생 정보 출력 4. 프로그램 종료
	 * 
	 * 2. 프로그램 실행 과정은 어떻게 할건지? 기능 1. 학생정보 추가 - 학년, 반 , 번호, 이름을 입력하여 학생 정보 추가 - 학년,
	 * 반, 번호가 같은 학생이 이미 있으면 추가하지않음 //객체끼리 비교 2. 학생 성적 추가 - 학년 , 반 ,번호로 학생을 검색 한 후
	 * 있으면 성적을 추가 - 성적 추가시 과목명, 중간, 기말 수행 평가를 입력하여 추가한다. - 이미 추가된 과목이면(학기랑 과목명이 같으면)
	 * 추가하지 않음 3. 학생 정보 출력
	 * 
	 * 3. 정보를 효율적으로 관리하기 위해 클래스를 만들것인가? 만든다면 어떤 클래스를 만들건지? - 학생클래스 HighStudent -
	 * 성적클래스 Score
	 * 
	 * 4. 프로그램 실행 과정을 주석으로 작성 // 반복 // 메뉴 출력 // 메뉴 선택
	 * 
	 * // 선택한 메뉴에 따른 기능 실행
	 * 
	 * 1. 학생 정보 추가* // 학생 정보를 입력(학년,반 번호 ,이름) // 입력한 학생 정보가 없으면 추가 2. 학생 성적 추가 // 학생
	 * 정보를 입력(학년,반,번호) //입력한 학생 정보가 없으면 끝
	 * 
	 * //성적 정보를 입력(과목,학기,중간,기말,수행평가) // 입력한 성적 정보가 없으면 추가 3. 학생 정보 출력 // 저장된 정보 출력
	 * 
	 * 
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		HighStudent[] stds = new HighStudent[30]; // 고정
		int count = 0; // 현재 저장된 학생 수
		
		int menu=0;
		 // 반복
		do {
			System.out.println("====메뉴=====");
			System.out.println("1.학생 정보 추가");
			System.out.println("2.학생 성적 추가");
			System.out.println("3.학생 정보 출력");
			System.out.println("4. 프로그램 종료");
			System.out.print("메뉴 선택>>>");
			// 메뉴 선택
			menu = sc.nextInt();
			// 선택한 메뉴에 따른 기능 실행
			if(menu == 1) {
				//1. 학생 정보 추가
				System.out.println("학생 정보를 입력해주세요.");
				// 학생 정보를 입력(학년,반 번호 ,이름)
				System.out.print("학년,반,번호,이름>>");
				int grade = sc.nextInt();
				int classNum = sc.nextInt();
				int num = sc.nextInt();
				String name = sc.next(); // next써야 이름입력 할 수 있음
				
				// 입력한 학생 정보가 없으면 추가
				// 학생 정보들 중에서 하나씩 비교하여 학년, 반, 번호가 같은 학생이 있는지 확인해서
				// 없으면 마지막 학생 뒤에 추가
				// 기존 학생정보가 있는지 없는지 확인
				int index = -1; // 학생정보가 있으면 몇번지에 있는지 알려줄 변수
				HighStudent tmp = new HighStudent(grade, classNum, num, name);
				for (int i = 0; i < count; i++) {
					if(stds[i].equals(tmp)) {
						index = i; // 일차하는 학생의 위치(번지)를 index에 저장함
					}
				}
					if(index == -1 && count < stds.length) {
						stds[count] = tmp; // 생성자에 의해 만들어지고 조건문에 의해 초기화가 되기 때문에 ㄱㅊ다
						count ++; // 한명 증가했으니까 cout++;
					}
			}else if(menu ==2) {
					//2. 학생 성적 ㅊ가
					// 학생 정보를 입력(학년,반,번호)
					System.out.println("성적을 추가할 학생 정보 입력:");
					int grade = sc.nextInt();
					int classNum = sc.nextInt();
					int num = sc.nextInt();
					// 입력한 성적 정보가 없으면 끝
					// 성적 정보들 중에서 하나씩 비교하여 학년 , 반 ,번호가 같은 학생이 
					//없으면 조건문 종료
					int index = -1;
					HighStudent tmp = new HighStudent(grade, classNum, num);
					for (int i = 0; i < count; i++) {
						if(stds[i].equals(tmp)) {
							index = i; // 일차하는 학생의 위치(번지)를 index에 저장함
						}
					}
					if(index == -1) {
						continue;
					}
					
					// 성적 정보를 입력(과목,학기 ,중간 기말, 수행평가)
					System.out.println("성적 정보를 입력하세요");
					System.out.print("과목명,학기,중간,기말,수행평가");
					String title= sc.next();
					int term = sc.nextInt();
					int midScoer = sc.nextInt();
					int finalScore = sc.nextInt();
					int performance = sc.nextInt();
					boolean res = stds[index].addScore(new Score(title, term, midScoer, finalScore, performance));
					if(res) {
						System.out.println("성적을 등록했습니다.");
						stds[index].printScore();
					}else {
						System.out.println("성적 등록에 실패했습니다.");
					}
					// 입력한 성적 정보가 없으면 추가
					//선택한 학생의 성적 정보들 중에서 과목, 학기가 같은 성적 정보가 없으면 추가 
				}else if(menu ==3) {
					//3. 학생 정보 출력
					// 저장된 정보 출력
					for (int i = 0; i < count; i++) {
						System.out.println(stds[i]);
					}
				}else if(menu ==4) {
					System.out.println("프로그램 종료");
				}else {
					System.out.println("잘못된 메뉴!!");
				}
		}while(menu != 4);
		
		
		}
}