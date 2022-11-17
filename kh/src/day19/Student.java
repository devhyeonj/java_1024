package day19;

import lombok.Data;

@Data
public class Student {
	private int grade;
	private int classNum;
	private int num;
	private String name;
	private int kor,eng,math;
	
	public Student(int grade, int classNum, int num, String name, int kor, int eng, int math) {
		super();
		this.grade = grade;
		this.classNum = classNum;
		this.num = num;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	
}
