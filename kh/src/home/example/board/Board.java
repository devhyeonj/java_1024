package home.example.board;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import lombok.Data;

@Data
public class Board {
	private static int count = 0;
	private int num;
	private String title;
	private String contents;
	private int views;
	private Date regDate,upDate;
	private String writer;
	private Category category;
															//true 새글 false 수정 삭제
	public Board(String title, String contents, String writer,boolean res) {
		this.title = title;
		this.contents = contents;
		this.writer = writer;
		this.regDate = new Date();
		if(res)
		num = count++;
	}
	
	public Board(int num) {
		this.num = num;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Board other = (Board) obj;
		return num == other.num;
	}

	@Override
	public int hashCode() {
		return Objects.hash(num);
	}
	
	public String getRegDate() {
		if(regDate == null)
			return "";
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return df.format(regDate);
	}
	
	public String getUpDate() {
		if(regDate == null)
			return "";
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return df.format(regDate);
	}
	
	@Override
	public String toString() {
		return num +"." + category + "|" +title+" | "+getRegDate() + " | "
				+ views + " | " + writer + " | ";
	}

	public void print() {
		System.out.println("번호 : " + num);
		System.out.println("카테고리 :" + category.getCategoryName());
		System.out.println("제목 : " + title);
		System.out.println("작성일 : " + getRegDate());
		if(upDate != null)
			System.out.println("수정일:" + getUpDate());
		System.out.println("조회수 : " + views);
		System.out.println("작성자 : " + writer);
		System.out.println("내용 : " + contents);
	}
	
	
	

}
