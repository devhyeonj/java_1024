package assignment.db.domain;

import lombok.Data;

@Data
public class Department {
	private int de_num;
	private String de_name;
	private String de_address;
	private String de_tel;
	private int de_pr_num;
	
	public Department() {
		
	}
	
	public Department(int de_num, String de_name, String de_address, String de_tel, int de_pr_num) {
		this.de_num = de_num;
		this.de_name = de_name;
		this.de_address = de_address;
		this.de_tel = de_tel;
		this.de_pr_num = de_pr_num;
	}

}