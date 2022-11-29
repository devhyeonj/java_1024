package example.board;

import lombok.Data;

@Data
public class Notice {
	
	private static int noticeNum = 0;
	private int num;
	private String title;
	private String content;
	
	
	public Notice(String title, String content) {
		++noticeNum;
		num = noticeNum;
		this.title = title;
		this.content = content;
	}
	
	public void print() {
		System.out.println("===========================");
		System.out.println("공지!!"+this.title);
		System.out.println(this.content);
		System.out.println("===========================");
	}
	
	

}
