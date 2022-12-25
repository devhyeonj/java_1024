package assignment.db.domain;

import lombok.Data;

@Data
public class Lecture {
	private int le_num;
	private String le_name;
	private String le_schedule;
	private int le_point;
	private int le_class;
	private int le_year;
	private String le_term;
	private int le_pr_num;
	
	public Lecture() {
	}
	
	public Lecture(int le_num, String le_name, String le_schedule, int le_point, int le_class, int le_year,
			String le_term, int le_pr_num) {
		this.le_num = le_num;
		this.le_name = le_name;
		this.le_schedule = le_schedule;
		this.le_point = le_point;
		this.le_class = le_class;
		this.le_year = le_year;
		this.le_term = le_term;
		this.le_pr_num = le_pr_num;
	}
	
	
	
}
