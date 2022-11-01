package day07;

public class ClassTestEx01 {

	public static void main(String[] args) {
		// 인스턴스화 방법
		// 클래스명 객체명 = new 클래스명();
		String str = new String("abc");
		Person person1 = new Person();
		//person1.pNo = "000101-2123456";
		person1.setpNo("000101-3123456");
		System.out.println("주민번호 : "+person1.getpNo());
		System.out.println(str.charAt(0));
	}

}

/*
class Person {
	접근제한자 자료형 변수명; // 멤버변수 (클래스에 필요한 변수)
	****일반적으로 멤버변수는 private으로 쓴다.
}
*/
/*
 * 접근제한자 종류
 * private		: 본인 클래스
 * (default)	: 본인 클래스 + 같은 패키지 ( 아무것도 안쓴걸 default라고 함
 * protected	: 본인 클래스 + 같은 패키지 + 자식클래스 
 * public		: 본인 클래스 + 같은 패키지 + 자식클래스 + 외부 클래스 => 전부 
 */
class Person {
	private String pNo;
	private String name;
	private char gender;
	private String address;
	private String phone;
	private int age;
	
	//외부에서 접근하기 위해서 겟터 셋터 만든거임
	// 나중에 롬복하면 겟터셋터 안만들어도 됨
	
	
	
	public String getpNo() {
		return pNo;
	}
	public void setpNo(String pNo) {
		this.pNo = pNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}