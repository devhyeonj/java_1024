package day17_ME;

import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Data;

@Data
public class Board {
	// 번호,제목, 내용, 작성자, 작성일, 조회수
	private static int boardCount=1;
	private int boardNum;
	private String title,contents,Writer;
	private String dateStr;
	private int views;
	
	public Board(String title, String contents, String writer) {
		this.title = title;
		this.contents = contents;
		Writer = writer;
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String dateStr = format.format(date);
		this.dateStr = dateStr;
		this.boardNum = boardCount++;
	}

	public Board(int boardNum) {
		this.boardNum = boardNum;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass()) {
			if(obj instanceof Integer) {
				if(boardNum == (Integer)obj) {
					return true;
				}
			}
			//Integer, Board 클래스가 아니거나 게시글 번호가 다른 경우
			return false;
		}
		Board other = (Board) obj;
		if (boardNum != other.boardNum)
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + boardNum;
		return result;
	}

	public void update(String title, String contents) {
		this.title = title;
		this.contents = contents;
	}
	
	
	


}
