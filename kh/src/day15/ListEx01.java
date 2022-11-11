package day15;

import java.util.ArrayList;
import java.util.Scanner;
// 디버깅 f5는 메소드안으로 들어가는거고 f6은 결과값출력
public class ListEx01 {
	
	public static void main(String[] args) {
		/* 리스트를 이용하여 다음 기능을 갖는 오늘의 할일 프로그램을 작성하세요.
		 * 메뉴
		 * 1. 할일 추가
		 * 2. 할일 확인
		 * 3. 할일 삭제
		 * 4. 종료
		 * 메뉴 선택 : 1
		 * ---------------------
		 * 할일 입력 : 오후 수업 참여 
		 * ---------------------
		 * 메뉴
		 * 1. 할일 추가
		 * 2. 할일 확인
		 * 3. 할일 삭제
		 * 4. 종료
		 * 메뉴 선택 : 1
		 * ---------------------
		 * 할일 입력 : 저녁
		 * ---------------------
		 * 메뉴
		 * 1. 할일 추가
		 * 2. 할일 확인
		 * 3. 할일 삭제
		 * 4. 종료
		 * 메뉴 선택 : 2
		 *---------------------
		 * 1. 오후 수업 참여
		 * 2. 저녁
		 * ---------------------
		 *  메뉴
		 * 1. 할일 추가
		 * 2. 할일 확인
		 * 3. 할일 삭제
		 * 4. 종료
		 * 메뉴 선택 : 3
		 * 1. 오후 수업 참여
		 * 2. 저녁
		 * 삭제할 할일 번호 선택 : 1
		 * 1번 할일이 삭제되었습니다.
		 * 메뉴
		 * 1. 할일 추가
		 * 2. 할일 확인
		 * 3. 할일 삭제
		 * 4. 종료
		 * 메뉴 선택 : 4
		 *---------------------
		 */
		// 메뉴 변수 선언
		int menu = -1;
		// 스캐너 선언
		Scanner sc= new Scanner(System.in);
		//String을 리스트에 집어넣기
		ArrayList<String> todoList = new ArrayList<String>();
		//반복문
		do {
			//메뉴 출력
			printMenu();
			//메뉴 입력받음
			//메뉴 입력에 따른 기능 실행
			try {
				menu = sc.nextInt();
				runMenu(sc,menu, todoList);
			}catch (RuntimeException e) {
				System.out.println();
				System.out.println("예외 발생 : 정수를 입력하세요.");
				System.out.println();
				sc.nextLine(); // 잘못되게 입력한걸 날려줌
			} 
			catch (Exception e) {
				System.out.println("------------");
				System.out.println(e.getMessage());
				System.out.println("------------");
			} 
		}while(menu !=4);
		
		
	
	}
	
	public static void runMenu(Scanner sc, int menu,ArrayList<String> todoList) throws Exception {
		switch (menu) {
		case 1: //입력
			todoList.add(insert(sc));
			break;
		case 2: //출력
			printAll(todoList);
			break;
		case 3: //삭제
			printAll(todoList);
			todoList = delete(sc,todoList);
			break;
		case 4: //종료
			System.out.println("프로그램을 종료 합니다.");
			break;
		default:
			throw new Exception("예외 발생 : 잘못된 메뉴입니다.");
		}
	}
	
	

	public static ArrayList<String> delete(Scanner sc, ArrayList<String> todoList) throws Exception {
		System.out.print("삭제할 할일 번호 선택 : ");
		int deleteNum = sc.nextInt();
		//잘못된 번호를 입력한 경우
		if(deleteNum <0 || deleteNum >= todoList.size()) {
			throw new Exception("예외발생 : 삭제할 번호를 잘못 입력했습니다.");
		}
		todoList.remove(deleteNum-1);
		System.out.println(deleteNum+"번"+"할일이 삭제되었습니다.");
		return todoList;
	}

	public static String insert(Scanner sc) {
		sc = new Scanner(System.in);
		System.out.print("할일 입력:");
		String todo;
		//sc.nextLine(); //앞에꺼 제거 // 앞에 next 로 입력받는경우
		todo = sc.nextLine();
		return todo;
	}
	
	public static void printAll(ArrayList<String> todoList) {
		if(todoList == null || todoList.size() == 0) {
			System.out.println("저장된 할일이 없습니다.");
			return;
		}
		int size = todoList.size();
		// 숫자가 있기때문에 향상된 for문 보다 그냥 for문 쓰는게 나음
		for (int j = 0; j < size; j++) {
			System.out.println((j+1)+"."+todoList.get(j));
		}
	}

	public static void printMenu() {
		System.out.println("메뉴");
		System.out.println("1. 할일 추가");
		System.out.println("2. 할일 확인");
		System.out.println("3. 할일 삭제");
		System.out.println("4. 종료");
	}
	

}
