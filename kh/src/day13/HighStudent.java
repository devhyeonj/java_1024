package day13;

import Student.Score;

public class HighStudent {
	//필드
	private int grade;//학년
	private int classNum;//반
	private int num;//번호
	private String name;//이름
	private Score[] scoreList; // 성적들 포함관계
	private int maxSize; // 최대 저장 가능한 성적 수
	private int count; // 현재 저장된 성적 수 
	
	
	/**
	 * 학생 정보에 성적을 추가 하는 메소드
	 * @param 추가할 성적
	 * @return 추가 여부
	 */
	public boolean addScore(Score score) {
		if(score == null) {
			return false;
		}
		//배열에 성적들이 꽉 찼을 때 
		if(count == maxSize) { 
			return false;
		}
		// 학생의 성적 정보들 중에서 과목, 학기가 같은 성적 정보가 없으면 추가
		for (int i = 0; i < count; i++) {
			if(score.equals(scoreList[i])) { //같으면
				return false;
			}
		}
		scoreList[count] = new Score(score); // 밖에서 뭔짓을 하든 별개이기때문에 이렇게 하는거임
		count++;
		return true;
	}
	
	
	
	
	//메소드 : getter/setter equals(): 같은 객체인지 비교하기 위해
	//toString() : 객체를 쉽게 문자열로 만들기 위해 sysout 으로 출력함
	
	
	// 생성자 : 초기화
	// 학년 , 반 , 번호 , 이름이 필요한 생성자(학생정보 추가시 활용)
	public HighStudent(int grade, int classNum, int num, String name) {
		this.grade = grade;
		this.classNum = classNum;
		this.num = num;
		this.name = name;
		maxSize =30;
		scoreList = new Score[maxSize];
	}
	
	//학년 , 반, 번호가 필요한 생성자(성적 추가 시 학생이 있는지 없는지 판별할 때 활용)
	public HighStudent(int grade, int classNum, int num) {
		this.grade = grade;
		this.classNum = classNum;
		this.num = num;
	}
	
	
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getClassNum() {
		return classNum;
	}
	public void setClassNum(int classNum) {
		this.classNum = classNum;
	}
	public int getnum() {
		return num;
	}
	public void setnum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	// equals(): 같은 객체인지 비교하기 위해 // 오버라이딩 후 : HighStudent 클래스의 equals() 메소드 실행 --> 두 객체의 주소값 비교가 아닌 실제 필드 값들이 모두 일치하면 true 반환
	@Override
	public boolean equals(Object obj) {
		if (this == obj) // HighStudent 객체
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HighStudent other = (HighStudent) obj;
		if (classNum != other.classNum)
			return false;
		if (grade != other.grade)
			return false;
		if (num != other.num)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return grade + "학년" + classNum + "반" + num + "번"  + "이름"+name;
	}

	public Score[] getScore() {
		return getScore();
	}

	public void setScore(Score[] score) {
		this.scoreList = score;
	}

	/**
	 * 성적을 출력 하는 메소드
	 */
	public void printScore() {
		for(int i= 0; i<count; i++) {
			System.out.println(scoreList[i]);
		}
	}
	
}
