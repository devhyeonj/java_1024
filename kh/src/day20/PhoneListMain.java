package day20;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Predicate;

import lombok.Data;

@Data
class Phonebook{
	// 전화번호부 번호를 위한 클래스 변수
	private static int count = 0;
	private int num;
	private String lastName;
	private String firstName;
	private String Job;
	private ArrayList<Phone> phones; //전화번호들??
	
	public Phonebook(String lastName, String firstName, String job, ArrayList<Phone> phones) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.Job = job;
		this.phones = phones;
		count++;
		num = count;
	}

	public Phonebook(String lastName, String firstName) {
		this.lastName = lastName;
		this.firstName = firstName;
	}
	
	
	
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass()) {
			if(!(obj instanceof String)) {
				return false;
			}
			return lastName.equals(obj) && firstName.equals(obj);
		}
		Phonebook other = (Phonebook) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "[" + num + "]"+"성명:"+lastName+firstName+" 직장:"+ Job
				+ phones;
	}

	

	
	
	
}
@Data
class Phone {
	private String name;
	private String phoneNumber;
	
	public Phone(String name, String phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "장소:" + name + ", 번호:" + phoneNumber;
	}
	
	
	
	
	
	
}

public class PhoneListMain {
	
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		/* 전화번호를 관리하는 프로그램을 작성하세요.
		 * 1. 전화번호 추가(성, 이름, 직장 ,전화번호들(이름 : 번호) 집 000 사무실 핸드폰 000 
		 * 2. 전화번호 수정
		 * 	- 이름으로 검색(성+이름)
		 * 	- 검색된 사람들 중에서 선택(contains
		 * 	- 성, 이름을 수정 할건지,
		 *  - 기존 등록된 전화번호를 수정할건지,
		 *  - 기존인물의 새 전화번호를 등록 할건지를 선택하여 동작
		 * 3. 전화번호 삭제
		 * 	- 이름으로 검색(성+이름)
		 *  - 검색된 사람들 중에서 선택
		 *  - 선택된 사람의 연락처를 삭제
		 * 4. 전화번호 조회
		 * 	- 이름으로 검색
		 *  - 검색된 사람들 중에서 선택
		 *  - 선택된 사람의 연락처를 출력 
		 * 
		 */
		int menu = 0;
		ArrayList<Phonebook> phonebookList = new ArrayList<Phonebook>();
		ArrayList<Phone> phoneList = new ArrayList<Phone>();
		do {
			printMenu();
			menu = sc.nextInt();
			runMenu(phonebookList, menu, phoneList);
		}while(menu != 5);

	}

	public static void runMenu(ArrayList<Phonebook> phonebookList, int menu,ArrayList<Phone> phoneList) {
		switch (menu) {
		case 1:
			insert(phonebookList,inputPhonebook(sc, phoneList));
			phonebookList.forEach((b)-> System.out.println(b));
			break;
		case 2:
			System.out.println("2. 전화번호 수정");
			break;
		case 3:
			System.out.println("3. 전화번호 삭제");
			break;
		case 4:
			System.out.println("4. 전화번호 조회");
			//앞에 번호가 나오게 출력
			select(phonebookList, sc);
			break;
		default:
			System.out.println("잘못된 메뉴입니다.");
		}
	}
	public static void select(ArrayList<Phonebook> phonebookList,Scanner sc) {
		System.out.println("전화번호부를 검색합니다.");
		System.out.print("성명을 입력하세요>>");
		String name = sc.next();
		detailSelect(phonebookList, (p) -> p.getLastName().contains(name) || p.getFirstName().contains(name));
	}

	public static void insert(ArrayList<Phonebook> phonebookList, Phonebook inputPhonebook) {
		if(inputPhonebook == null) {
			System.out.println("등록할 데이터가 없습니다.");
		}
//		String tmpLastname = inputPhonebook.getLastName();
//		String tmpFirstname = inputPhonebook.getFirstName();
//		boolean isData = detailSelect(phonebookList, (p) -> p.getLastName().equals(inputPhonebook.getLastName() == tmpLastname && p.getFirstName().equals(inputPhonebook.getFirstName() == tmpFirstname)));
//		if(isData) {
//			System.out.println("등록된 이름이 있습니다.");
//		}
		phonebookList.add(inputPhonebook);
		System.out.println("등록에 성공하였습니다.");
		
		//더 등록할건지 물어보기 y 면 등록 n 면 등록완료
	}

	public static Phonebook inputPhonebook(Scanner sc,ArrayList<Phone> phoneList) {
		String lastName,firstName,Job;
		System.out.println("전화번호부를 등록 합니다.");
		System.out.print("성: "); lastName = sc.next();
		System.out.print("이름: "); firstName = sc.next();
		System.out.print("직장: "); Job = sc.next();
		ArrayList<Phone> phoneTmp = inputPhones(sc,phoneList);
		return new Phonebook(lastName, firstName, Job, phoneTmp) ;
	}

	@SuppressWarnings("null")
	public static ArrayList<Phone> inputPhones(Scanner sc,ArrayList<Phone>phoneList) {
		String name;
		String phoneNumber;
		System.out.print("이름: "); name = sc.next();
		System.out.print("번호: "); phoneNumber = sc.next();
		Phone tmp = new Phone(name, phoneNumber);
		phoneList.add(tmp);
		return phoneList;
		
	}

	public static void printMenu() {
		System.out.println("===전화번호 관리 프로그램=====");
		System.out.println("1. 전화번호 추가");
		System.out.println("2. 전화번호 수정");
		System.out.println("3. 전화번호 삭제");
		System.out.println("4. 전화번호 조회");
		System.out.print("메뉴선택:");
	}
	
	public static boolean detailSelect(ArrayList<Phonebook> phoneList,Predicate<Phonebook> p) {
		for (Phonebook tmp : phoneList) {
			if(p.test(tmp)) {
				System.out.println(tmp);
				return true;
			}
		}
		return false;
	}

}
