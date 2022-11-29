package example.board;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import lombok.Data;

@Data
public class Board implements Serializable{
	private static int boardNum = 0; // 게시글 번호
	private int num;
	private String title; // 제목
	private String content; // 내용
	private int views; // 조회수
	private Date date;
	private String loginId; // 게시글은 아이디만 가지고 있다.
	private Category category; // 게시글 종류
	private Notice notice;
	
	public Board(String title, String content, String loginId) {
		this.title = title;
		this.content = content;
		date = new Date();
		++boardNum;
		num = boardNum;
		this.views = 0;
		this.loginId = loginId;
	}
	
	public void addCategory(Category category) {
		this.category = category;
	}
	
	public void updateViews() {
		views++;
	}
	
	public void update(String title, String content) {
		this.title = title;
		this.content = content;
	}
	
}
