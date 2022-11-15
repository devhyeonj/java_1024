package day17;

import java.util.HashMap;
import java.util.Scanner;

public class UserManagerMapMain {

	private static Scanner sc = new Scanner(System.in);  //다른메소드에서도 쉽게접근할수있도록 필드로만듬
	
	public static void main(String[] args) {
		int menu = 0;
		HashMap<String, Member> map = new HashMap<String, Member>();
		do {
			System.out.println("------메뉴------");
			System.out.println("1. 회원 추가");
			System.out.println("2. 회원 검색");
			System.out.println("3. 회원 정보 수정");
			System.out.println("4. 회원 삭제");
			System.out.println("5. 종료");
			System.out.println("---------------");
			System.out.print("메뉴 선택 : ");
			
			menu = sc.nextInt();
			
			switch (menu) {
			case 1:
				if(addMember(map)) {
					System.out.println("회원 정보가 추가됐습니다.");
				}else {
					System.out.println("이미 가입된 아이디 입니다.");
				}
				break;
			case 2:
				if(!searchMember(map)) {
					System.out.println("아이디 또는 비번이 일치하지 않습니다.");
				}
				break;
				//다르면 종료
			case 3:
				if(updateMember(map)) {
					System.out.println("회원 정보를 수정했습니다.");
				}else {
					System.out.println("아이디 또는 비번이 일치하지 않습니다.");
				}
				break;
			case 4:
				if(deleteMember(map)) {
					System.out.println("회원 정보를 삭제했습니다.");
				}else {
					System.out.println("아이디 또는 비번이 일치하지 않습니다.");
				}
				break;
			case 5:
				System.out.println("프로그램을 종료합니다.");
				break;
			default:
			}
		}while(menu != 5);

	}
	public static boolean addMember(HashMap<String, Member> map) {
		if(map == null) {
			throw new RuntimeException("Map이 null입니다.");
		}
		
		System.out.println("회원 정보를 입력하세요.");
		System.out.print("아이디 : ");
		String id = sc.next();
		System.out.print("비번 : ");
		String pw = sc.next();
		System.out.print("이름 : ");
		String name = sc.next();
		System.out.print("주민번호 : ");
		String residentNumber = sc.next();
		System.out.print("나이 : ");
		int age = sc.nextInt();
		
		// map에 있는지 확인
		Member addtmp = map.get(id); // key값 value를 가져옴 
		//있으면 건너뜀
		if(addtmp != null) { // if(map.get(id) != null;
			System.out.println("이미 추가된 아이디입니다.");
			return false; 
		}
		//있으면 추가
		map.put(id, new Member(pw,name,residentNumber,age));
		return true;
	}
	
	public static boolean searchMember(HashMap<String, Member> map) {
		System.out.println("검색할 회원 정보를 입력하세요.");
		System.out.print("아이디 : ");
		String id = sc.next();
		System.out.print("비번 : ");
		String pw = sc.next();
		
		//아이디를 이용하여 회원 정보를 가져옴
		Member searchTmp = map.get(id);
		
		//일치하는 회원 정보가 없으면 건너뜀
		if(searchTmp == null) {
			return false;
		}
		//가져온 회원 정보에서 비밀번호가 같은지를 확인하여 같으면 회원정보 출력
		if(!searchTmp.getPw().equals(pw)) {
			return false;
		}
		System.out.println(id + ":" + searchTmp);
		return true;
	}
	
	public static boolean updateMember(HashMap<String, Member> map) {
		System.out.println("검색할 회원 정보를 입력하세요.");
		System.out.print("아이디 : ");
		String id = sc.next();
		System.out.print("비번 : ");
		String pw = sc.next();
		
		Member updateTmp = map.get(id);
		if(updateTmp == null || !updateTmp.getPw().equals(pw)) {
			return false;
		}
		
		System.out.println("수정할 회원 정보를 입력하세요.");
		System.out.print("새 비번 : ");
		String newPw = sc.next();
		System.out.print("이름 : ");
		String name = sc.next();
		System.out.print("주민번호 : ");
		String residentNumber = sc.next();
		System.out.print("나이 : ");
		int age = sc.nextInt();
		updateTmp.update(newPw,name,residentNumber,age);
		return true;
	}
	
	public static boolean deleteMember(HashMap<String, Member> map) {
		System.out.println("삭제할 회원 정보를 입력하세요.");
		System.out.print("아이디 : ");
		String id = sc.next();
		System.out.print("비번 : ");
		String pw = sc.next();
		
		Member deleteTmp = map.get(id);
		if(deleteTmp==null || !deleteTmp.getPw().equals(pw)) { //순서 바꾸면 안됨
			return false;
		}
		// or기준으로 왼쪽이 참이면 오른쪽 참이든 거짓이든 상관없이 참이다
		map.remove(id);
		System.out.println("삭제가 완료 했습니다.");
		return true;
	}
}
