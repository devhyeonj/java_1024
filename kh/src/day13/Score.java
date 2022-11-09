package day13;
// 과목명, 중간, 기말 수행 평가
public class Score {
	private String subject;
	private int midterm;
	private int finalExamination;
	private int performanceAssessment;
	
	public Score(String subject, int midterm, int finalExamination, int performanceAssessment) {
		super();
		this.subject = subject;
		this.midterm = midterm;
		this.finalExamination = finalExamination;
		this.performanceAssessment = performanceAssessment;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public int getMidterm() {
		return midterm;
	}

	public void setMidterm(int midterm) {
		this.midterm = midterm;
	}

	public int getFinalExamination() {
		return finalExamination;
	}

	public void setFinalExamination(int finalExamination) {
		this.finalExamination = finalExamination;
	}

	public int getPerformanceAssessment() {
		return performanceAssessment;
	}

	public void setPerformanceAssessment(int performanceAssessment) {
		this.performanceAssessment = performanceAssessment;
	}

	@Override
	public String toString() {
		return "Score [subject=" + subject + ", midterm=" + midterm + ", finalExamination=" + finalExamination
				+ ", performanceAssessment=" + performanceAssessment + "]";
	}
	
}
