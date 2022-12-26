package assignment.db.domain;

import lombok.Data;

@Data
public class Score {
	private int sc_num;
	private int sc_mid;
	private int sc_final;
	private int sc_homework;
	private int sc_attendance;
	private int sc_total;
	private int sc_co_num;
	
	public Score() {
	}
	
	public Score(int sc_num, int sc_mid, int sc_final, int sc_homework, int sc_attendance, int sc_total,
			int sc_co_num) {
		this.sc_num = sc_num;
		this.sc_mid = sc_mid;
		this.sc_final = sc_final;
		this.sc_homework = sc_homework;
		this.sc_attendance = sc_attendance;
		this.sc_total = sc_total;
		this.sc_co_num = sc_co_num;
	}
	
	

}
