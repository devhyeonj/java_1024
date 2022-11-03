package day09;

public class HighStudent {
	private int grade; // 학년
	private int classNum; // 반
	private int num; // 번호
	private String name; // 이름
	private int kor,eng,math; // 성적
	
	public void print() {
		System.out.println(grade+"학년 "+ classNum + "반 " + num + "번 "+ name);
		System.out.println("국어 : "+ kor + ", 영어" + eng + ", "+ "수학:" + math);
	}
	
	public void updateKor(int kor1) {
		kor = kor1;
	}
	
	public void updateEng(int eng1) {
		eng = eng1;
	}
	
	public void updateMath(int math1) {
		math = math1;
	}
	
	public void updateScore(int kor1,int eng1, int math1) {
		updateKor(kor1);
		updateEng(eng1);
		updateMath(math1);
	}
	
	public HighStudent() {
		this(1,1,1,"");
	}

	public HighStudent(int grade1, int classNum1, int num1, String name1) {
		grade = grade1;
		classNum = classNum1;
		num = num1;
		name = name1;
	}
	
}
