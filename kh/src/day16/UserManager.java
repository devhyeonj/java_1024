package day16;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

import lombok.Data;

public class UserManager {

	public static void main(String[] args) {
		/*
		 * 회원 정보를 관리하는 프로그램을 작성하세요
		 * - 회원 정보 아이디, 비번, 이름, 나이, 주민번호로 구성
		 * - 기능1: 회원 추가
		 * - 기능2: 회원 검색
		 * - 기능3: 회원 정보 수정
		 * - 기능4 : 회원삭제 
		 * 하나는 리스트 이용한 방법 하나는 맵을 이용한 방법
		 */
		
		
		
		// 1. 회원정보 클래스 만듬 
		// 메뉴 변수 선언
		int menu = -1;
		//스캐너 선언
		Scanner sc = new Scanner(System.in);
		// 컬렉션 선언
		HashMap<String, Member> memberList = new HashMap<String, Member>();
		// 반복문(do-while문)
			//메뉴 출력 (메소드)
			//메뉴 입력받음 
			//메뉴 입력받은거에 따른 기능 실행
		boolean canContinue = true;
		do {
			printMenu();
			try {
				menu = sc.nextInt();
				canContinue = runMenu(memberList,menu,canContinue);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}while(canContinue != false);
		
	}

	private static boolean runMenu(HashMap<String, Member> memberList,int menu,boolean canContinue) throws Exception {
		//switch 문
		switch (menu) {
		case 1: // 추가
			insert(memberList);
			break;
		case 2: // 검색
			select(memberList);
			break;
		case 3: //수정
			update(memberList);
			break;
		case 4: //삭제
			delete(memberList);
			break;
		default:
			canContinue = false;
			throw new Exception("메뉴를 잘못 입력하셨습니다.");
			
		}
		return canContinue;
	}

	private static void delete(HashMap<String, Member> memberList) {
		Scanner sc = new Scanner(System.in);
		System.out.print("회원 정보를 삭제할 아이디를 입력하세요>>");
		String memberId = sc.next();
		
		if(memberList.get(memberId) == null) {
			System.out.println("입력 하신 아이디가 없습니다. 다시 입력해주세요");
		}	
		
		memberList.remove(memberId);
		
		System.out.println("삭제에 성공했습니다.");
		
		
	}

	private static void update(HashMap<String, Member> memberList) {
		Scanner sc = new Scanner(System.in);
		System.out.print("회원 정보를 수정할 아이디를 입력하세요>>");
		String memberId = sc.next();
		
		
		if(memberList.get(memberId) == null) {
			System.out.println("입력 하신 아이디가 없습니다. 다시 입력해주세요");
		}	
		
		Member member = memberList.get(memberId);
		
		System.out.println("값 들어오나 확인"+member);
		
		System.out.println("회원 정보 수정");
		System.out.print("아이디,비번, 이름, 나이, 주민번호를 차례대로 입력해주세요>>");
		String memberId2 = sc.next();
 		String password = sc.next();
		String name = sc.next();
		int age = sc.nextInt();
		int id = sc.nextInt();
		
		//
		
	
		memberList.put(memberId, new Member(member.getMemberId(), password, name, age, id));
		
		System.out.println("수정에 성공 하셨습니다!!");
		
		
		//수정 확인용
		Set<String> keySet = memberList.keySet();
		for (String tmp : keySet) {
			System.out.println(tmp + ":" + memberList.get(tmp));
		}
	}

	private static void select(HashMap<String, Member> memberList) {
		Scanner sc = new Scanner(System.in);
		System.out.print("회원 정보를 볼 아이디를 입력하세요>>");
		String name = sc.next();
		Member member;
		
		if(memberList.get(name) != null) {
			member = memberList.get(name);
			if(member.getMemberId().equals(name) ) {
				System.out.println(member);
			}
		}
	}

	private static void insert(HashMap<String, Member> memberList) {
		Scanner sc = new Scanner(System.in);
		System.out.println("회원 정보 등록");
		System.out.print("아이디, 비번, 이름, 나이, 주민번호를 차례대로 입력해주세요>>");
		String memberId = sc.next();
		String password = sc.next();
		String name = sc.next();
		int age = sc.nextInt();
		int id = sc.nextInt();
		// 확인 리스트에 이미 가입된 아이디이면 안내 문구 출력
		memberList.put(memberId, new Member(memberId, password, name, age, id));

		//출력확인용
		Set<String> keySet = memberList.keySet();
		for (String tmp : keySet) {
			System.out.println(tmp + ":" + memberList.get(tmp));
		}
	}

	private static void printMenu() {
		System.out.println("메뉴");
		System.out.println("1. 회원 추가");
		System.out.println("2. 회원 검색");
		System.out.println("3. 회원 정보 수정");
		System.out.println("4. 회원 삭제");
		System.out.print("메뉴입력>>");
	}
}

@Data
class Member{
	private String memberId;
	private String password;
	private String name;
	private int age;
	private int id;
	
	public Member(String memberId, String password, String name, int age, int id) {
		this.memberId = memberId;
		this.password = password;
		this.name = name;
		this.age = age;
		this.id = id;
	}
	
	
}
