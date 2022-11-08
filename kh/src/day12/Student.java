package day12;

public class Student {
	private int grade, classNum , num;
	private String name;
	// 하나의 객체에 하나의해시코드를 계산해서 같은 해시코드를 묶어넣음
	//hashCode() {
		
	//}
	//많이 쓰는거 2ㄱ
	
	
	
	
	
	// 두객체가 같은지 다른지 쉽게 비교 가능
	@Override			//매개 변수의 다향성 
	public boolean equals(Object obj) {
		if (this == obj) // 같은 객체를 공유하는가?
			return true;
		// null과 비교 불가능
		if (obj == null)
			return false;
		// obj 가 같은 클래스의 객체가 아닌 경우
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj; // 아닌경우 형변환
		if (classNum != other.classNum)
			return false;
		if (grade != other.grade)
			return false;
		if (num != other.num)
			return false;
		return true;
	}

	@Override // 멤버들을 하나의 문자열로 쭉 만들어줌
	public String toString() {
		return "Student [grade=" + grade + ", classNum=" + classNum + ", num=" + num + ", name=" + name + "]";
	}
	
	
}
