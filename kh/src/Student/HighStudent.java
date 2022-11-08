package Student;

public class HighStudent {
	private int grade;//학년
	private int classNum;//반
	private int number;//번호
	private String name;//이름
	
	
	
	public HighStudent() {
	}
	public HighStudent(int grade, int classNum, int number, String name) {
		super();
		this.grade = grade;
		this.classNum = classNum;
		this.number = number;
		this.name = name;
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
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Score [grade=" + grade + ", classNum=" + classNum + ", number=" + number + ", name=" + name + "]";
	}
	
}
